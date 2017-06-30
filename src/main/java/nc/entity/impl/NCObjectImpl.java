package nc.entity.impl;

import nc.entity.NCAttribute;
import nc.entity.NCObject;
import nc.entity.NCParam;
import nc.util.batchsqlquery.BatchSqlCreator;
import org.springframework.stereotype.Component;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by petka on 27.03.2017.
 *
 * @author Evgeniy Tupikov
 */
@XmlRootElement(name = "object")
@XmlAccessorType(XmlAccessType.FIELD)
public class NCObjectImpl implements NCObject {

    private static final long serialVersionUID = -4877459895255861985L;

    private String objectId;
    private String objectName;
    private String objectParent;
    private String objectType;

    private String objectTypeName;
    private String objectTypeParent;

    @XmlElementWrapper(name = "attributes")
    @XmlElement(type = NCAttributeImpl.class, name = "attribute")
    private List<NCAttribute> attributeList;

    @XmlElementWrapper(name = "params")
    @XmlElement(name = "param",type = NCParamImpl.class)
    private List<NCParam> paramList;

    @XmlTransient
    private Map<NCAttribute, NCParam> values = new HashMap<>();

    @XmlElementWrapper(name = "childs")
    @XmlElement(name = "child", type = NCObjectImpl.class)
    private List<NCObject> childList = new ArrayList<>();

    @XmlTransient
    private BatchSqlCreator context;

    public NCObjectImpl() {}

    public NCObjectImpl(String objectId, String objectName, String objectParent, String objectType) {
        this.objectId = objectId;
        this.objectName = objectName;
        this.objectParent = objectParent;
        this.objectType = objectType;
    }

    public NCObjectImpl(String objectId, String objectName, String objectParent, String objectType, Map<NCAttribute, NCParam> values) {
        this.objectId = objectId;
        this.objectName = objectName;
        this.objectParent = objectParent;
        this.objectType = objectType;
        this.values = values;
    }

    public NCObjectImpl(String objectType, String objectTypeName, String objectTypeParent) {
        this.objectType = objectType;
        this.objectTypeName = objectTypeName;
        this.objectTypeParent = objectTypeParent;
    }

    public NCObjectImpl(String objectTypeId, String objectTypeName, String objectTypeParent, List<NCAttribute> attributeList) {
        this.objectType = objectType;
        this.objectTypeName = objectTypeName;
        this.objectTypeParent = objectTypeParent;
        this.attributeList = attributeList;
    }

    public NCObjectImpl(String objectTypeId, String objectTypeName, String objectTypeParent, Map<NCAttribute, NCParam> values) {
        this.objectType = objectType;
        this.objectTypeName = objectTypeName;
        this.objectTypeParent = objectTypeParent;
        this.values = values;
    }

    public NCObjectImpl(List<NCAttribute> attributeList) {
        this.attributeList = attributeList;
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
    public String getObjectName() {
        return objectName;
    }

    @Override
    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    @Override
    public String getObjectParent() {
        return objectParent;
    }

    @Override
    public void setObjectParent(String objectParent) {
        this.objectParent = objectParent;
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
    public List<NCObject> getChildList() {
        return childList;
    }

    @Override
    public void setChildList(List<NCObject> childList) {
        this.childList = childList;
    }

    @Override
    public String getObjectTypeName() {
        return objectTypeName;
    }

    @Override
    public void setObjectTypeName(String objectTypeName) {
        this.objectTypeName = objectTypeName;
    }

    @Override
    public String getObjectTypeParent() {
        return objectTypeParent;
    }

    @Override
    public void setObjectTypeParent(String objectTypeParent) {
        this.objectTypeParent = objectTypeParent;
    }

    @Override
    public List<NCAttribute> getAttributes() {
        return attributeList;
    }

    @Override
    public void setAttributes(List<NCAttribute> attributeList) {
        this.attributeList = attributeList;
    }

    @Override
    public List<NCParam> getParams() {
        return paramList;
    }

    @Override
    public void setParams(List<NCParam> paramList) {
        this.paramList = paramList;
    }

    @Override
    public Map<NCAttribute, NCParam> getValues() {
        return values;
    }

    @Override
    public void setValues(Map<NCAttribute, NCParam> values) {
        this.values = values;
    }

    @Override
    public BatchSqlCreator getContext() {
        return context;
    }

    @Override
    public void setContext(BatchSqlCreator context) {
        this.context = context;
    }

    @Override
    public String toString() {
        return "NCObject { " +
                "object_id = " + objectId + ", " +
                "object_name = " + objectName + ", " +
                "object_parent = " + objectParent + ", " +
                "object_type = " + objectType + ", " +
                "object_type_name = " + objectTypeName + ", " +
                "object_type_parent = " + objectTypeParent + ", " +
                "attribute_list = " + (attributeList != null ? attributeList.toString() : "null") + ", " +
                "param_list = " + (paramList != null ? paramList.toString() : "null") +
                " }";
    }
}
