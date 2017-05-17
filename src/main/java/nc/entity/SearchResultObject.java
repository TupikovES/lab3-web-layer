package nc.entity;

import java.io.Serializable;

/**
 * Created by petka on 17.05.2017.
 *
 * @author Evgeniy Tupikov
 */
public interface SearchResultObject extends Serializable {
    String getId();
    void setId(String id);
    String getName();
    void setName(String name);
    String getObjectType();
    void setObjectType(String objectType);
    String getTypeParam();
    void setTypeParam(String typeParam);
    String getAttributeName();
    void setAttributeName(String attributeName);
    String getStringValue();
    int getIntValue();
    void setValue(String value);
    void setValue(int value);
}
