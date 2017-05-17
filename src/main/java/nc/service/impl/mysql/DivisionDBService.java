package nc.service.impl.mysql;

import nc.dao.NCObjectDao;
import nc.entity.Club;
import nc.entity.Division;
import nc.entity.NCObject;
import nc.entity.impl.DivisionImpl;
import nc.service.DivisionService;
import nc.util.NCObjectConverter;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by petka on 13.04.2017.
 *
 * @author Evgeniy Tupikov
 */
@Service("divisionDBService")
public class DivisionDBService implements DivisionService {

    public static final Logger log = Logger.getLogger(DivisionDBService.class);

    @Autowired
    @Qualifier("ncObjectDaoImpl")
    private NCObjectDao objectDao;

    @Override
    public String createDivision(Division division, String parentId) {
        NCObject object = NCObjectConverter.toNCObject(division);
        object.setObjectParent(parentId);
        return objectDao.insertObject(object);
    }

    @Override
    public void updateDivision(Division division) {
        objectDao.updateObject(NCObjectConverter.toNCObject(division));
    }

    @Override
    public void deleteDivision(String id) {
        objectDao.deleteObject(id);
    }

    @Override
    public Division getById(String id) {
        return NCObjectConverter.toDivision(objectDao.getObjectById(id));
    }

    @Override
    public Division getByName(String name) {
        return NCObjectConverter.toDivision(objectDao.getObjectByName(name));
    }

    @Override
    public List<Division> getByClub(Club club) {
        List<NCObject> objectList = objectDao.getObjectsByParent(NCObjectConverter.toNCObject(club));
        log.info("Division DB Service : " + objectList.isEmpty());
        List<Division> divisionList = new ArrayList<>();
        for (NCObject object : objectList) {
            divisionList.add(NCObjectConverter.toDivision(object));
        }
        return divisionList;
    }

    @Override
    public List<Division> getAll() {
        return null;
    }

    @Override
    public boolean isExist(Division division) {
        return false;
    }
}
