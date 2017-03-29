package nc.service.impl.mysql;

import nc.dao.NCObjectDao;
import nc.entity.Club;
import nc.entity.NCAttribute;
import nc.entity.NCObject;
import nc.entity.NCParam;
import nc.entity.impl.NCObjectImpl;
import nc.service.ClubService;
import nc.util.NCObjectConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by petka on 24.03.2017.
 *
 * @author Evgeniy Tupikov
 */
@Service("clubDBService")
public class ClubDBService implements ClubService {

    @Autowired
    @Qualifier("ncObjectDaoImpl")
    private NCObjectDao objectDao;

    @Override
    public Club getById(String id) {
        return null;
    }

    @Override
    public Club getByName(String name) {
        return null;
    }

    @Override
    public void deleteClub(Club club) {

    }

    @Override
    public void updateClub(Club club) {

    }

    @Override
    public List<Club> getAll() {
        return null;
    }

    @Override
    public String createClub(Club club) {
        NCObject object = NCObjectConverter.toNCObject(club);
        return objectDao.insertObject(object);
    }

    @Override
    public boolean isExist(Club club) {
        return false;
    }
}
