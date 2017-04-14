package nc.util.batchsqlquery.impl;

import nc.entity.NCObject;
import nc.entity.NCParam;
import nc.util.batchsqlquery.BatchSqlCreator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by petka on 10.04.2017.
 *
 * @author Evgeniy Tupikov
 */
public class ClubBatchSqlCreator implements BatchSqlCreator {
    @Override
        public String[] create(NCObject object) {
            List<NCParam> paramList = object.getParams();
            String[] sqlResultList = new String[paramList.size()];
            String tempSql = "INSERT INTO nc_params (object_id, attribute_id, string_value) VALUES (" +
                    "\'" + object.getObjectId() + "\', ";
            for (int i = 0; i < sqlResultList.length; i++) {
                sqlResultList[i] = tempSql + "\'" + paramList.get(i).getAttributeId() + "\', \'" + paramList.get(i).getStringValue() + "\')";
            }

            return sqlResultList;
    }
}
