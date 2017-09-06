package nc.service.impl.mysql;

import nc.dao.NCObjectDao;
import nc.dao.ObjectDao;
import nc.entity.Club;
import nc.entity.Division;
import nc.entity.NCObject;
import nc.entity.ObjectEntity;
import nc.entity.impl.DivisionImpl;
import nc.entity.impl.NCObjectImpl;
import nc.service.DivisionService;
import nc.util.Breadcrumb;
import nc.util.NCObjectConverter;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by petka on 13.04.2017.
 *
 * @author Evgeniy Tupikov
 */
@Service("divisionDBService")
@Transactional(readOnly = true)
public class DivisionDBService implements DivisionService {

    public static final Logger log = Logger.getLogger(DivisionDBService.class);

    @Autowired
    @Qualifier("objectDaoImpl")
    private ObjectDao objectDao;

    @Override
    @Transactional(readOnly = false)
    public String createDivision(Division division, String parentId) {
        ObjectEntity object = NCObjectConverter.toNCObject(division);
        object.setParent(new ObjectEntity(parentId));
        return (String) objectDao.saveObject(object);
    }

    @Override
    @Transactional(readOnly = false)
    public void updateDivision(Division division) {
        ObjectEntity objectEntityUpdate = objectDao.getObjectById(division.getId());
        ObjectEntity objectEntityNew = NCObjectConverter.toNCObject(division);
        objectEntityUpdate.getParamEntityList().clear();
        objectEntityUpdate.getParamEntityList().addAll(objectEntityNew.getParamEntityList());
        objectDao.updateObject(objectEntityUpdate);
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteDivision(String id) {
        ObjectEntity objectEntity = objectDao.getObjectById(id);
        if (objectEntity != null)
            objectDao.deleteObject(objectEntity);
    }

    @Override
    public Division getById(String id) {
        ObjectEntity object = objectDao.getObjectById(id);
        return NCObjectConverter.toDivision(object);
    }

    @Override
    public Division getByName(String name) {
        return NCObjectConverter.toDivision(objectDao.getObjectByName(name));
    }

    @Override
    public List<Division> getByClub(Club club) {
        ObjectEntity objectParent = objectDao.getObjectById(club.getId());
        List<ObjectEntity> objectList = objectDao.getObjectsByParent(objectParent);
        log.info("Division DB Service : " + objectList.isEmpty());
        List<Division> divisionList = new ArrayList<>();
        for (ObjectEntity object : objectList) {
            divisionList.add(NCObjectConverter.toDivision(object));
        }
        return divisionList;
    }

    @Override
    public List<Division> getAll() {
        return null;
    }

    @Override
    public String getBreadcrumb(String divisionId) {
        return new Breadcrumb().createBreadcrumb(objectDao.getObjectById(divisionId));
    }

    @Override
    public boolean isExist(Division division) {
        return false;
    }
}
