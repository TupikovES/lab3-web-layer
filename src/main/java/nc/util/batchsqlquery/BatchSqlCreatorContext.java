package nc.util.batchsqlquery;

import nc.entity.Club;
import nc.entity.NCObject;
import nc.entity.NCParam;

import java.util.List;

/**
 * Created by petka on 10.04.2017.
 *
 * @author Evgeniy Tupikov
 */
public class BatchSqlCreatorContext {

    private BatchSqlCreator creator;

    public BatchSqlCreatorContext(BatchSqlCreator creator) {
        this.creator = creator;
    }

    public String[] create(NCObject object) {
        return creator.create(object);
    }

}
