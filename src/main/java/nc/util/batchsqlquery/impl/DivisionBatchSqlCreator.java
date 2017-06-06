package nc.util.batchsqlquery.impl;

import nc.entity.NCObject;
import nc.util.batchsqlquery.BatchSqlCreator;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by petka on 13.04.2017.
 *
 * @author Evgeniy Tupikov
 */
@XmlRootElement(name = "division-batch")
@XmlAccessorType(XmlAccessType.FIELD)
public class DivisionBatchSqlCreator implements BatchSqlCreator {
    @Override
    public String[] create(NCObject object) {
        return new String[0];
    }
}
