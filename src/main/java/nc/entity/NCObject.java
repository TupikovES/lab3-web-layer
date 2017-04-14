package nc.entity;

import nc.util.batchsqlquery.BatchSqlCreator;
import nc.util.batchsqlquery.BatchSqlCreatorContext;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by petka on 27.03.2017.
 *
 * @author Evgeniy Tupikov
 */
public interface NCObject extends Serializable {

    //Object
    String getObjectId();
    void setObjectId(String objectId);
    String getObjectName();
    void setObjectName(String objectName);
    String getObjectParent();
    void setObjectParent(String objectParent);
    String getObjectType();
    void setObjectType(String objectType);

    //Object type
    String getObjectTypeName();
    void setObjectTypeName(String objectTypeName);
    String getObjectTypeParent();
    void setObjectTypeParent(String objectTypeParent);

    //Attribute
    List<NCAttribute> getAttributes();
    void setAttributes(List<NCAttribute> attributeList);

    //Param
    List<NCParam> getParams();
    void setParams(List<NCParam> paramList);

    //Attribute and params
    Map<NCAttribute, NCParam> getValues();
    void setValues(Map<NCAttribute, NCParam> values);

    BatchSqlCreator getContext();
    void setContext(BatchSqlCreator context);
}
