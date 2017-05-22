package nc.service.impl.mysql;

import nc.dao.NCObjectDao;
import nc.entity.*;
import nc.entity.impl.NCAttributeImpl;
import nc.entity.impl.PlayerImpl;
import nc.service.PlayerService;
import nc.util.NCObjectConverter;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by petka on 09.05.2017.
 *
 * @author Evgeniy Tupikov
 */
@Service("playerDBService")
public class PlayerDBService implements PlayerService {

    public static final Logger log = Logger.getLogger(PlayerDBService.class);

    @Autowired
    @Qualifier("ncObjectDaoImpl")
    private NCObjectDao objectDao;

    @Override
    public String createPlayer(Player player, String parentId) {
        log.info("Create player : " + player.toString());
        NCObject object = NCObjectConverter.toNCObject(player);
        object.setObjectParent(parentId);
        return objectDao.insertObject(object);
    }

    @Override
    public void updatePlayer(Player player) {
        objectDao.updateObject(NCObjectConverter.toNCObject(player));
    }

    @Override
    public void deletePlayer(String id) {
        objectDao.deleteObject(id);
    }

    @Override
    public Player getById(String id) {
        NCObject object = objectDao.getObjectById(id);
        object.setValues(objectDao.getValuesByObject(object));
        return NCObjectConverter.toPlayer(object);
    }

    @Override
    public Player getByFirstName(String firstName) {
        return null;
    }

    @Override
    public Player getByLastName(String lastName) {
        return null;
    }

    @Override
    public List<Player> getByClub(Club club) {
        return null;
    }

    @Override
    public List<Player> getByDivision(Division division) {
        log.info("Get players by " + division.getName() + "...");
        List<NCObject> objectList = objectDao.getObjectsByParent(NCObjectConverter.toNCObject(division));
        List<Player> playerList = new ArrayList<>();
        for (NCObject object : objectList) {
            object.setValues(objectDao.getValuesByObject(object));
            Player player = NCObjectConverter.toPlayer(object);
            playerList.add(player);
        }
        return playerList;
    }

    @Override
    public List<Player> getByAge(int age) {
        return null;
    }

    @Override
    public List<Player> getAll() {
        return null;
    }

    @Override
    public boolean isExist(Player player) {
        return false;
    }
}
