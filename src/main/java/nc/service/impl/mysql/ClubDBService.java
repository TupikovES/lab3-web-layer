package nc.service.impl.mysql;

import nc.dao.NCObjectDao;
import nc.dao.ObjectDao;
import nc.entity.*;
import nc.entity.impl.NCObjectImpl;
import nc.service.ClubService;
import nc.util.NCObjectConverter;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by petka on 24.03.2017.
 *
 * @author Evgeniy Tupikov
 */
@Service("clubDBService")
@Transactional(readOnly = true)
public class ClubDBService implements ClubService {

    public static final Logger log = Logger.getLogger(ClubDBService.class);

    @Autowired
    //@Qualifier("ncObjectDaoImpl")
    @Qualifier("objectDaoImpl")
    private ObjectDao objectDao;

    @Override
    public Club getById(String id) {
        ObjectEntity object = objectDao.getObjectById(id);
        return NCObjectConverter.toClub(object);
    }

    @Override
    public Club getByName(String name) {
        return NCObjectConverter.toClub(objectDao.getObjectByName(name));
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteClub(Club club) {
        log.info("delete " + club.toString());
        ObjectEntity objectEntity = objectDao.getObjectById(club.getId());
        if (objectEntity != null) {
            log.info("load object: " + objectEntity.toString());
            objectDao.deleteObject(objectEntity);
        }
    }

    @Override
    @Transactional(readOnly = false)
    public void updateClub(Club club) {
        objectDao.updateObject(NCObjectConverter.toNCObject(club));
    }

    @Override
    public List<Club> getAll() {
        ObjectType objectType = objectDao.getObjectTypeByName("Club");
        List<ObjectEntity> objectList = objectDao.getObjectsByObjectType(objectType);
        List<Club> clubList = new ArrayList<>();
        for (ObjectEntity object : objectList) {
            Club club = NCObjectConverter.toClub(object);
            clubList.add(club);
        }
        return clubList;
    }

    @Override
    @Transactional(readOnly = false)
    public String createClub(Club club) {
        ObjectEntity objectEntity = NCObjectConverter.toNCObject(club);
        return (String) objectDao.saveObject(objectEntity);
    }

    @Override
    public boolean isExist(Club club) {
        return false;
    }

    @Override
    public void renameClub(String suffix) {
        ObjectType objectType = objectDao.getObjectTypeByName("Club");
        AttributeEntity attributeEntity = objectDao.getAttributeEntityById("ad184d56-10b9-11e7-83f0-b888e3a0097b");
        objectDao.rename(objectType, suffix, attributeEntity);
    }
}
