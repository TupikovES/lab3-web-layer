package nc.entity;

import java.util.List;
import java.util.Map;

/**
 * Created by petka on 27.03.2017.
 *
 * @author Evgeniy Tupikov
 */
public interface NCObject {

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
    String getObjectTypeId();
    void setObjectTypeId(String objectTypeId);
    String getObjectTypeName();
    void setObjectTypeName(String objectTypeName);
    String getObjectTypeParent();
    void setObjectTypeParent(String objectTypeParent);

    //Attribute
    List<NCAttribute> getAttributes();
    void setAttribute(List<NCAttribute> attributeList);

    //Attribute and params
    Map<NCAttribute, NCParam> getValues();
    void setValues(Map<NCAttribute, NCParam> values);
}
