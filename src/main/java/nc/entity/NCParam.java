package nc.entity;

import java.util.Date;

/**
 * Created by petka on 27.03.2017.
 *
 * @author Evgeniy Tupikov
 */
public interface NCParam {

    String getObjectId();
    void setObjectId(String objectId);
    String getAttributeId();
    void setAttributeId(String attributeId);
    String getStringValue();
    void setStringValue(String stringValue);
    Date getDateValues();
    void setDateValues(Date dateValues);
    int getNumberValues();
    void setNumberValues(int numberValues);
    NCObject getReferenceValue();
    void setReferenceValue(NCObject referenceValue);

}
