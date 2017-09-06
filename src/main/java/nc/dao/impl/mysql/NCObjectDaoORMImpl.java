package nc.dao.impl.mysql;

import nc.dao.NCObjectDao;
import nc.entity.NCAttribute;
import nc.entity.NCObject;
import nc.entity.NCParam;
import nc.entity.SearchResultObject;
import nc.entity.impl.NCObjectImpl;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Map;

/**
 * Created by x3mib on 06.07.2017.
 */
@Repository("NCObjectDaoORMImpl")
public class NCObjectDaoORMImpl implements NCObjectDao {

    public static final Logger log = Logger.getLogger(NCObjectDaoORMImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public String insertObject(NCObject object) {
        return null;
    }

    @Override
    public void updateObject(NCObject object) {

    }

    @Override
    public void updateObjectId(String lastId, String newId) {

    }

    @Override
    public void deleteObject(String id) {

    }

    @Override
    public NCObject getObjectById(String id) {
        log.info("get object with ORM [id#" + id + "]");
        return getSession().get(NCObjectImpl.class, id);
    }

    @Override
    public NCObject getObjectByName(String name) {
        return null;
    }

    @Override
    public List<SearchResultObject> searchObjectByParam(String query) {
        return null;
    }

    @Override
    public List<NCObject> getAllObjects() {
        return null;
    }

    @Override
    public List<NCObject> getObjectsByParent(NCObject parent) {
        return null;
    }

    @Override
    public List<NCObject> getObjectsByType(NCObject type) {
        return null;
    }

    @Override
    public List<NCObject> getObjectsByAttributeValue(NCObject attribute) {
        return null;
    }

    @Override
    public NCObject getObjectTypeById(String id) {
        return null;
    }

    @Override
    public NCObject getObjectTypeByName(String name) {
        return null;
    }

    @Override
    public List<NCObject> getObjectTypeByParent(NCObject parent) {
        return null;
    }

    @Override
    public NCAttribute getAttributeById(String id) {
        return null;
    }

    @Override
    public List<NCAttribute> getAttributesByObjectType(NCObject object) {
        return null;
    }

    @Override
    public void insertParam(NCParam param) {

    }

    @Override
    public void insertAllParams(NCObject paramList) {

    }

    @Override
    public void updateParam(NCParam param) {

    }

    @Override
    public void updateAllParams(NCObject paramList) {

    }

    @Override
    public List<NCParam> getParamByObject(NCObject object) {
        return null;
    }

    @Override
    public Map<NCAttribute, NCParam> getValuesByObject(NCObject object) {
        return null;
    }

    @Override
    public boolean isExist(NCObject object) {
        return false;
    }
}
