package nc.entity;

import javax.persistence.Entity;
import java.io.Serializable;

/**
 * Created by petka on 27.03.2017.
 *
 * @author Evgeniy Tupikov
 */
public interface NCAttribute extends Serializable {

    String getAttributeId();
    void setAttributeId(String attributeId);
    String getAttributeName();
    void setAttributeName(String attributeName);
    String getObjectType();
    void setObjectType(String objectType);
    String getType();
    void setType(String type);
    int getOrder();
    void setOrder(int order);
    boolean isMultiple();
    void setMultiple(boolean multiple);

}
