package nc.entity.impl;

import nc.entity.NCObject;
import nc.entity.NCParam;

import java.util.Date;

/**
 * Created by petka on 27.03.2017.
 *
 * @author Evgeniy Tupikov
 */
public class NCParamImpl implements NCParam {

    private static final long serialVersionUID = 5686136934572489040L;

    private String objectId;
    private String attributeId;
    private String stringValue;
    private Date dateValue;
    private int numberValue;
    private NCObject referenceValue;

    public NCParamImpl() {}

    public NCParamImpl(String stringValue) {
        this.stringValue = stringValue;
    }

    public NCParamImpl(Date dateValue) {
        this.dateValue = dateValue;
    }

    public NCParamImpl(int numberValue) {
        this.numberValue = numberValue;
    }

    public NCParamImpl(NCObject referenceValue) {
        this.referenceValue = referenceValue;
    }

    public NCParamImpl(String attributeId, String stringValue) {
        this.attributeId = attributeId;
        this.stringValue = stringValue;
    }

    public NCParamImpl(String attributeId, Date dateValue) {
        this.attributeId = attributeId;
        this.dateValue = dateValue;
    }

    public NCParamImpl(String attributeId, int numberValue) {
        this.attributeId = attributeId;
        this.numberValue = numberValue;
    }

    public NCParamImpl(String attributeId, NCObject referenceValue) {
        this.attributeId = attributeId;
        this.referenceValue = referenceValue;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String getObjectId() {
        return objectId;
    }

    @Override
    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    @Override
    public String getAttributeId() {
        return attributeId;
    }

    @Override
    public void setAttributeId(String attributeId) {
        this.attributeId = attributeId;
    }

    @Override
    public String getStringValue() {
        return stringValue;
    }

    @Override
    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    @Override
    public Date getDateValue() {
        return dateValue;
    }

    @Override
    public void setDateValue(Date dateValue) {
        this.dateValue = dateValue;
    }

    @Override
    public int getNumberValue() {
        return numberValue;
    }

    @Override
    public void setNumberValue(int numberValue) {
        this.numberValue = numberValue;
    }

    @Override
    public NCObject getReferenceValue() {
        return referenceValue;
    }

    @Override
    public void setReferenceValue(NCObject referenceValue) {
        this.referenceValue = referenceValue;
    }

    @Override
    public void setValueByType(String type, Object value) {
        switch (type) {
            case "string":
                setStringValue((String) value);
                break;
            case "date":
                setDateValue((Date) value);
                break;
            case "number":
                setNumberValue((int) value);
                break;
            case "reference":
                setReferenceValue((NCObject) value);
                break;
        }
    }

    @Override
    public String toString() {
        return "NCParam { " +
                "object_id = " + objectId + ", " +
                "attribute_id = " + attributeId + ", " +
                "string_value = " + stringValue + ", " +
                "number_value = " + numberValue +
                " }";
    }
}
