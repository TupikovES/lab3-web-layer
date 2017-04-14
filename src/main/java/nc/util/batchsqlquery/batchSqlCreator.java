package nc.util.batchsqlquery;

import nc.entity.NCObject;
import nc.entity.NCParam;

/**
 * Created by petka on 10.04.2017.
 *
 * @author Evgeniy Tupikov
 */
public interface BatchSqlCreator {
    String[] create(NCObject object);
}
