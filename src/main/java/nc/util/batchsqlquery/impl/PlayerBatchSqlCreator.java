package nc.util.batchsqlquery.impl;

import nc.entity.NCObject;
import nc.entity.NCParam;
import nc.util.batchsqlquery.BatchSqlCreator;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by petka on 15.05.2017.
 *
 * @author Evgeniy Tupikov
 */
@XmlRootElement(name = "player-batch")
@XmlAccessorType(XmlAccessType.FIELD)
public class PlayerBatchSqlCreator implements BatchSqlCreator {
    @Override
    public String[] create(NCObject object) {
        List<NCParam> paramList = object.getParams();
        String[] sqlResultList = new String[paramList.size()];
        String tempSql = "INSERT INTO nc_params (object_id, attribute_id, string_value) VALUES (" +
                "\'" + object.getObjectId() + "\', ";
        for (int i = 0; i < sqlResultList.length; i++) {
            if(i == sqlResultList.length - 1) {
                sqlResultList[i] = "INSERT INTO nc_params (object_id, attribute_id, number_value) VALUES (" +
                        "\'" + object.getObjectId() + "\', " +
                        "\'" + paramList.get(i).getAttributeId() + "\', \'" + paramList.get(i).getNumberValue() + "\')";
            } else {
                sqlResultList[i] = tempSql + "\'" + paramList.get(i).getAttributeId() + "\', \'" + paramList.get(i).getStringValue() + "\')";
            }
        }

        return sqlResultList;
    }
}
