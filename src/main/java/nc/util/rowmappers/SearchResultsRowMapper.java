package nc.util.rowmappers;

import nc.entity.NCObject;
import nc.entity.SearchResultObject;
import nc.entity.impl.NCObjectImpl;
import nc.entity.impl.SearchResultObjectImpl;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by petka on 17.05.2017.
 *
 * @author Evgeniy Tupikov
 */
public class SearchResultsRowMapper implements RowMapper<SearchResultObject> {
    @Override
    public SearchResultObject mapRow(ResultSet resultSet, int i) throws SQLException {
        SearchResultObject object = new SearchResultObjectImpl();
        object.setId(resultSet.getString("object_id"));
        object.setName(resultSet.getString("object_name"));
        object.setObjectType(resultSet.getString("object_type_name"));
        object.setTypeParam(resultSet.getString("type"));
        object.setAttributeName(resultSet.getString("attribute_name"));
        object.setValue(resultSet.getString("string_value"));
        object.setValue(resultSet.getInt("number_value"));
        return object;
    }
}
