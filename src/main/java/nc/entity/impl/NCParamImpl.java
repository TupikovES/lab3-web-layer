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

    public NCParamImpl(String objectId, String attributeId, String stringValue) {
        this.objectId = objectId;
        this.attributeId = attributeId;
        this.stringValue = stringValue;
    }

    public NCParamImpl(String objectId, String attributeId, Date dateValue) {
        this.objectId = objectId;
        this.attributeId = attributeId;
        this.dateValue = dateValue;
    }

    public NCParamImpl(String objectId, String attributeId, int numberValue) {
        this.objectId = objectId;
        this.attributeId = attributeId;
        this.numberValue = numberValue;
    }

    public NCParamImpl(String objectId, String attributeId, NCObject referenceValue) {
        this.objectId = objectId;
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
            case "String":
                setStringValue((String) value);
                break;
            case "Date":
                setDateValue((Date) value);
                break;
            case "Number":
                setNumberValue((int) value);
                break;
            case "Reference":
                setReferenceValue((NCObject) value);
                break;
            default:
                setStringValue((String) value);
                break;
        }
    }
}
