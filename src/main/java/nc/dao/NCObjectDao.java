package nc.dao;

import nc.entity.NCAttribute;
import nc.entity.NCObject;
import nc.entity.NCParam;
import nc.entity.SearchResultObject;

import java.util.List;
import java.util.Map;

/**
 * Created by petka on 24.03.2017.
 *
 * @author Evgeniy Tupikov
 */
public interface NCObjectDao {

    //Object
    String insertObject(NCObject object);
    void updateObject(NCObject object);
    void updateObjectId(String lastId, String newId);
    void deleteObject(String id);

    NCObject getObjectById(String id);
    NCObject getObjectByName(String name);
    List<SearchResultObject> searchObjectByParam(String query);
    List<NCObject> getAllObjects();
    List<NCObject> getObjectsByParent(NCObject parent);
    List<NCObject> getObjectsByType(NCObject type);
    List<NCObject> getObjectsByAttributeValue(NCObject attribute);

    //Object type
    NCObject getObjectTypeById(String id);
    NCObject getObjectTypeByName(String name);
    List<NCObject> getObjectTypeByParent(NCObject parent);

    //Attribute
    NCAttribute getAttributeById(String id);
    List<NCAttribute> getAttributesByObjectType(NCObject object);

    //Param
    void insertParam(NCParam param);
    void insertAllParams(NCObject paramList);
    void updateParam(NCParam param);
    void updateAllParams(NCObject paramList);
    List<NCParam> getParamByObject(NCObject object);

    Map<NCAttribute, NCParam> getValuesByObject(NCObject object);

    boolean isExist(NCObject object);
}
