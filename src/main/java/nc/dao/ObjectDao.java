package nc.dao;

import nc.entity.AttributeEntity;
import nc.entity.ObjectEntity;
import nc.entity.ObjectType;
import nc.entity.ParamEntity;

import java.io.Serializable;
import java.util.List;

public interface ObjectDao {

    /**
     * ObjectEntity method's
     */
    ObjectEntity getObjectById(final Serializable id);
    ObjectEntity getObjectByName(String name);
    List<ObjectEntity> getObjectsByParent(ObjectEntity parent);
    Serializable saveObject(ObjectEntity objectEntity);
    void deleteObject(ObjectEntity objectEntity);
    void updateObject(ObjectEntity objectEntity);
    List<ObjectEntity> getObjectsByObjectType(ObjectType objectType);
    void rename(ObjectType objectType, String suffix, AttributeEntity attributeEntity);

    /**
     * ObjectTypes method's
     */
    ObjectType getObjectTypeById(final Serializable id);
    ObjectType getObjectTypeByName(String name);
    Serializable saveObjectType(ObjectType objectType);
    List getAllObjectTypes();

    /**
     * ParamEntity method's
     */
    List<ParamEntity> getParamList(ObjectEntity objectEntity);

    /**
     * AttributeEntity method's
     */
    AttributeEntity getAttributeEntityById(final Serializable id);

    /**
     * Search
     */
    List<ObjectEntity> findByAttributes(String query);

}
