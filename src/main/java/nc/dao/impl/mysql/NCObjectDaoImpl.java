package nc.dao.impl.mysql;

import nc.dao.NCObjectDao;
import nc.entity.NCAttribute;
import nc.entity.NCObject;
import nc.entity.NCParam;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static final String INSERT_OBJECT = "INSERT INTO nc_object (object_name, parent_id, object_type)" +
                                               " VALUES (?, ?, ?)";

    @Override
    public String insertObject(NCObject object) {
        String id = "";
        PreparedStatementCreator psc = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(INSERT_OBJECT, new String[] { "object_id" });
                ps.setString(1, object.getObjectName());
                ps.setString(2, object.getObjectParent());
                ps.setString(3, object.getObjectType());
                return ps;
            }
        };
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(psc, holder);
        try {
            log.info(holder.getKey().toString());
        } catch (NullPointerException ex) {
            log.error("error ", ex);
        }
        //id = (String) holder.getKeys().get("object_id");
        return id;
    }

    @Override
    public void updateObject(NCObject object) {

    }

    @Override
    public void deleteObject(String id) {

    }

    @Override
    public NCObject getObjectById(String id) {
        return null;
    }

    @Override
    public NCObject getObjectByName(String name) {
        return null;
    }

    @Override
    public List<NCObject> getObjectsByParent(NCObject parent) {
        return null;
    }

    @Override
    public List<NCObject> getObjectsByType(NCObject type) {
        return null;
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
}
