package nc.entity.impl;

import nc.entity.SearchResultObject;

/**
 * Created by petka on 17.05.2017.
 *
 * @author Evgeniy Tupikov
 */
public class SearchResultObjectImpl implements SearchResultObject {

    private static final long serialVersionUID = -9096272010230483539L;

    private String id;
    private String name;
    private String objectType;
    private String typeParam;
    private String attributeName;
    private String stringValue;
    private int intValue;

    public SearchResultObjectImpl() {
    }

    public SearchResultObjectImpl(String id, String name, String objectType, String typeParam, String attributeName, String stringValue) {
        this.stringValue = stringValue;
        this.id = id;
        this.name = name;
        this.objectType = objectType;
        this.typeParam = typeParam;
        this.attributeName = attributeName;
    }

    public SearchResultObjectImpl(String id, String name, String objectType, String typeParam, String attributeName, int intValue) {
        this.id = id;
        this.name = name;
        this.objectType = objectType;
        this.typeParam = typeParam;
        this.attributeName = attributeName;
        this.intValue = intValue;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
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
    public String getTypeParam() {
        return typeParam;
    }

    @Override
    public void setTypeParam(String typeParam) {
        this.typeParam = typeParam;
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
    public String getStringValue() {
        return stringValue;
    }

    @Override
    public int getIntValue() {
        return intValue;
    }

    @Override
    public void setValue(String value) {
        stringValue = value;
    }

    @Override
    public void setValue(int value) {
        intValue = value;
    }
}
