package nc.entity.impl;

import nc.entity.NCAttribute;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by petka on 27.03.2017.
 *
 * @author Evgeniy Tupikov
 */
@XmlRootElement(name = "attribute")
@XmlAccessorType(XmlAccessType.FIELD)
public class NCAttributeImpl implements NCAttribute {

    private static final long serialVersionUID = -1609690264860696629L;

    private String attributeId;
    private String attributeName;
    private String objectType;
    private String type;

    private int order;
    private boolean multiple;

    public NCAttributeImpl() {}

    public NCAttributeImpl(String attributeId, String attributeName, String objectType, String type, int order, boolean multiple) {
        this.attributeId = attributeId;
        this.attributeName = attributeName;
        this.objectType = objectType;
        this.type = type;
        this.order = order;
        this.multiple = multiple;
    }

    public NCAttributeImpl(String attributeName, String objectType, String type, int order, boolean multiple) {
        this.attributeName = attributeName;
        this.objectType = objectType;
        this.type = type;
        this.order = order;
        this.multiple = multiple;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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
    public String getAttributeName() {
        return attributeName;
    }

    @Override
    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    @Override
    public String getObjectType() {
        return objectType;
    }

    @Override
    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int getOrder() {
        return order;
    }

    @Override
    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public boolean isMultiple() {
        return multiple;
    }

    @Override
    public void setMultiple(boolean multiple) {
        this.multiple = multiple;
    }
}
