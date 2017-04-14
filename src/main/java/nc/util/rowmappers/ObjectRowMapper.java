package nc.util.rowmappers;

import nc.entity.NCObject;
import nc.entity.impl.NCObjectImpl;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by petka on 13.04.2017.
 *
 * @author Evgeniy Tupikov
 */
public class ObjectRowMapper implements RowMapper<NCObject> {

    @Override
    public NCObject mapRow(ResultSet resultSet, int i) throws SQLException {
        NCObject object = new NCObjectImpl();
        object.setObjectId(resultSet.getString("object_id"));
        object.setObjectName(resultSet.getString("object_name"));
        object.setObjectParent(resultSet.getString("parent_id"));
        object.setObjectType(resultSet.getString("object_type"));
        return object;
    }
}
