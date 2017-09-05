package nc.dao.impl.mysql;

import nc.dao.ObjectDao;
import nc.entity.AttributeEntity;
import nc.entity.ObjectEntity;
import nc.entity.ObjectType;
import nc.entity.ParamEntity;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;

@Repository
public class ObjectDaoImpl implements ObjectDao {

    public static final Logger log = Logger.getLogger(ObjectDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public ObjectEntity getObjectById(final Serializable id) {
        //return (ObjectEntity) getSession().getNamedQuery("getObjectById").setParameter("id", id).getSingleResult();
        return getSession().get(ObjectEntity.class, id);
    }

    @Override
    public ObjectEntity getObjectByName(String name) {
        return (ObjectEntity) getSession().getNamedQuery("getObjectByName").setParameter("name", name).getSingleResult();
    }

    @Override
    public List<ObjectEntity> getObjectsByParent(ObjectEntity parent) {
        return getSession().getNamedQuery("getObjectsByParent").setParameter("parent", parent).list();
    }

    @Override
    public Serializable saveObject(ObjectEntity objectEntity) {
        return getSession().save(objectEntity);
    }

    @Override
    public void deleteObject(ObjectEntity objectEntity) {
        getSession().delete(objectEntity);
    }

    @Override
    public void updateObject(ObjectEntity objectEntity) {
        getSession().update(objectEntity);
    }

    @Override
    public List<ObjectEntity> getObjectsByObjectType(ObjectType objectType) {
        return getSession().getNamedQuery("getObjectsByObjectType").setParameter("objectType", objectType).list();
    }

    @Override
    public void rename(ObjectType objectType, String suffix, AttributeEntity attributeEntity) {
        /*getSession().getNamedQuery("updateObjects")
                .setParameter("suffix", suffix)
                .setParameter("attributeId", attributeEntity)
                .setParameter("objectType", objectType);*/
    }

    @Override
    public ObjectType getObjectTypeById(Serializable id) {
        return getSession().get(ObjectType.class, id);
    }

    @Override
    public ObjectType getObjectTypeByName(String name) {
        return (ObjectType) getSession().getNamedQuery("getObjectTypeByName").setParameter("name", name).getSingleResult();
    }

    @Override
    public Serializable saveObjectType(ObjectType objectType) {
        return getSession().save(objectType);
    }

    @Override
    public List<ObjectType> getAllObjectTypes() {
        return null;
    }

    @Override
    public List<ParamEntity> getParamList(ObjectEntity objectEntity) {
        return getSession().getNamedQuery("getParamForObject").setParameter("id", objectEntity).list();
    }

    @Override
    public AttributeEntity getAttributeEntityById(Serializable id) {
        return getSession().get(AttributeEntity.class, id);
    }

    @Override
    public List<ObjectEntity> findByAttributes(String query) {
        Integer numberValue;
        try {
            numberValue = Integer.valueOf(query);
        } catch (NumberFormatException e) {
            numberValue = 0;
        }
        List<ObjectEntity> paramEntityList = getSession().getNamedQuery("getObjectsByParam")
                .setParameter("stringValue", query)
                .setParameter("numberValue", numberValue)
                .getResultList();
        return paramEntityList;
    }
}
