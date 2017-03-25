package nc.service.impl.mysql;

import nc.dao.ClubDao;
import nc.entity.Club;
import nc.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by petka on 24.03.2017.
 *
 * @author Evgeniy Tupikov
 */
@Service("clubDBService")
public class ClubDBService implements ClubService {

    @Autowired
    @Qualifier("clubDBDaoImpl")
    private ClubDao clubDao;


    @Override
    public Club getById(String id) {
        return clubDao.getById(id);
    }

    @Override
    public Club getByName(String name) {
        return clubDao.getByName(name);
    }

    @Override
    public int deleteClub(Club club) {
        return clubDao.deleteClub(club);
    }

    @Override
    public int updateClub(Club club) {
        return clubDao.updateClub(club);
    }

    @Override
    public List<Club> getAll() {
        return clubDao.getAll();
    }

    @Override
    public int createClub(Club club) {
        return clubDao.createClub(club);
    }

    @Override
    public boolean isExist(Club club) {
        return clubDao.isExist(club);
    }
}
