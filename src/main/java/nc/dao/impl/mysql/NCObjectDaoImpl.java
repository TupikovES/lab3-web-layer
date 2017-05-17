package nc.dao.impl.mysql;

import nc.dao.NCObjectDao;
import nc.entity.NCAttribute;
import nc.entity.NCObject;
import nc.entity.NCParam;
import nc.entity.SearchResultObject;
import nc.entity.impl.NCAttributeImpl;
import nc.entity.impl.NCObjectImpl;
import nc.entity.impl.NCParamImpl;
import nc.util.rowmappers.ObjectRowMapper;
import nc.util.rowmappers.SearchResultsRowMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by petka on 28.03.2017.
 *
 * @author Evgeniy Tupikov
 */
@Repository("ncObjectDaoImpl")
public class NCObjectDaoImpl implements NCObjectDao{

    public static final Logger log = Logger.getLogger(NCObjectDaoImpl.class);
    private List<Map<String, Object>> rows;
    private Map<NCAttribute, NCParam> values = new HashMap<>();
    private String id;
    private List<NCObject> objectList = new ArrayList<>();

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static final String INSERT_OBJECT = "INSERT INTO nc_object (object_name, parent_id, object_type)" +
                                               " VALUES (?, ?, ?)";
    public static final String SELECT_ALL_OBJECTS = "SELECT * FROM nc_object";
    public static final String DELETE_OBJECT_BY_ID = "DELETE FROM nc_object WHERE object_id = ?";
    public static final String SELECT_OBJECT_BY_PARENT = "SELECT * FROM nc_object WHERE parent_id = ?";
    public static final String SELECT_OBJECT_BY_TYPE = "SELECT * FROM nc_object WHERE object_type = ?";
    public static final String SELECT_OBJECT_BY_ID = "SELECT * FROM nc_object WHERE object_id = ?";
    public static final String SELECT_VALUES = "SELECT * FROM nc_attribute inner join nc_params using(attribute_id) where nc_params.object_id = ? order by nc_attribute.order_id;";
    public static final String SEARCH_BY_PARAM = "select t1.object_id, t1.object_name, t2.object_type_name, t4.type, t4.attribute_name, t3.string_value, t3.number_value from nc_object t1 inner join nc_object_type t2 on t1.object_type = t2.object_type_id inner join nc_params t3 using(object_id) inner join nc_attribute t4 on t3.attribute_id = t4.attribute_id where locate(?, t3.string_value) or locate(?, t3.number_value);";

    @Override
    public String insertObject(NCObject object) {
        PreparedStatementCreator psc = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(INSERT_OBJECT, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, object.getObjectName());
                ps.setString(2, object.getObjectParent());
                ps.setString(3, object.getObjectType());
                log.info(ps.toString());
                return ps;
            }
        };
        jdbcTemplate.update(psc);
        id = getLastId();
        log.info("id = " + id);
        object.setObjectId(id);
        insertAllParams(object);
        return id;
    }

    @Override
    public void updateObject(NCObject object) {

    }

    @Override
    public void deleteObject(String id) {
        jdbcTemplate.update(DELETE_OBJECT_BY_ID, new Object[] { id });
    }

    @Override
    public NCObject getObjectById(String id) {
        return jdbcTemplate.queryForObject(SELECT_OBJECT_BY_ID, new Object[]{ id }, new ObjectRowMapper());
    }

    @Override
    public NCObject getObjectByName(String name) {
        return null;
    }

    @Override
    public List<NCObject> getAllObjects() {
        rows = jdbcTemplate.queryForList(SELECT_ALL_OBJECTS);
        if (!objectList.isEmpty()) {
            objectList.clear();
        }
        for (Map row : rows) {
            NCObject object = new NCObjectImpl();
            object.setObjectId((String)row.get("object_id"));
            object.setObjectName((String)row.get("object_name"));
            object.setObjectParent((String)row.get("parent_id"));
            object.setObjectType((String)row.get("object_type"));
            objectList.add(object);
        }
        return objectList;
    }

    @Override
    public List<NCObject> getObjectsByParent(NCObject parent) {
        PreparedStatementCreator psc = connection -> {
            PreparedStatement ps = connection.prepareStatement(SELECT_OBJECT_BY_PARENT);
            log.info("parent id : " + parent.getObjectId());
            ps.setString(1, parent.getObjectId());
            return ps;
        };
        objectList = jdbcTemplate.query(psc, new ObjectRowMapper());
        log.info("object list : " + objectList.isEmpty());
        return objectList;
    }

    @Override
    public List<NCObject> getObjectsByType(NCObject type) {
        PreparedStatementCreator psc = connection -> {
            PreparedStatement ps = connection.prepareStatement(SELECT_OBJECT_BY_TYPE);
            ps.setString(1, type.getObjectType());
            return ps;
        };

        objectList = jdbcTemplate.query(psc, new ObjectRowMapper());
        return objectList;
    }

    @Override
    public List<NCObject> getObjectsByAttributeValue(NCObject attribute) {
        return null;
    }

    @Override
    public NCObject getObjectTypeById(String id) {
        return null;
    }

    @Override
    public NCObject getObjectTypeByName(String name) {
        return null;
    }

    @Override
    public List<SearchResultObject> searchObjectByParam(String query) {
        PreparedStatementCreator psc = connection -> {
            PreparedStatement ps = connection.prepareStatement(SEARCH_BY_PARAM);
            ps.setString(1, query);
            ps.setString(2, query);
            return ps;
        };

        List<SearchResultObject> searchResults = jdbcTemplate.query(psc, new SearchResultsRowMapper());
        return searchResults;
    }

    @Override
    public List<NCObject> getObjectTypeByParent(NCObject parent) {
        return null;
    }

    @Override
    public NCAttribute getAttributeById(String id) {
        return null;
    }

    @Override
    public List<NCAttribute> getAttributesByObjectType(NCObject object) {
        return null;
    }

    @Override
    public void insertParam(NCParam param) {

    }

    @Override
    public void insertAllParams(NCObject paramList) {
        jdbcTemplate.batchUpdate(paramList.getContext().create(paramList));
    }

    @Override
    public void updateParam(NCParam param) {

    }

    @Override
    public void updateAllParams(NCObject paramList) {

    }

    @Override
    public List<NCParam> getParamByObject(NCObject object) {
        return null;
    }

    @Override
    public Map<NCAttribute, NCParam> getValuesByObject(NCObject object) {
        if(!values.isEmpty()) {
            values.clear();
        }
        PreparedStatementCreator psc = connection -> {
            PreparedStatement ps = connection.prepareStatement(SELECT_VALUES);
            ps.setString(1, object.getObjectId());
            return ps;
        };

        class ValuesRowMapper implements RowMapper<Map<NCAttribute, NCParam>> {

            @Override
            public Map<NCAttribute, NCParam> mapRow(ResultSet resultSet, int i) throws SQLException {
                NCAttribute attribute = new NCAttributeImpl();
                NCParam param = new NCParamImpl();
                attribute.setAttributeId(resultSet.getString("attribute_id"));
                attribute.setAttributeName(resultSet.getString("attribute_name"));
                attribute.setObjectType(resultSet.getString("object_type"));
                attribute.setMultiple(resultSet.getInt("multiple") == 0 ? false : true);
                attribute.setType(resultSet.getString("type"));
                attribute.setOrder(resultSet.getInt("order_id"));
                param.setAttributeId(attribute.getAttributeId());
                param.setObjectId(resultSet.getString("object_id"));
                param.setValueByType(attribute.getType(), resultSet.getObject(attribute.getType() + "_value"));
                values.put(attribute, param);
                return values;
            }
        }
        jdbcTemplate.query(psc, new ValuesRowMapper());
        return values;
    }

    private String getLastId() {
        return jdbcTemplate.queryForObject("SELECT @id", String.class);
    }
}
