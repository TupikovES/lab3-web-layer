package nc.entity;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by petka on 27.03.2017.
 *
 * @author Evgeniy Tupikov
 */
public interface NCParam extends Serializable {

    String getObjectId();
    void setObjectId(String objectId);
    String getAttributeId();
    void setAttributeId(String attributeId);
    String getStringValue();
    void setStringValue(String stringValue);
    Date getDateValue();
    void setDateValue(Date dateValues);
    int getNumberValue();
    void setNumberValue(int numberValues);
    NCObject getReferenceValue();
    void setReferenceValue(NCObject referenceValue);
    void setValueByType(String type, Object value);
}
