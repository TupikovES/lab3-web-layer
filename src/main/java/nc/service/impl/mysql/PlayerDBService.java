package nc.service.impl.mysql;

import nc.dao.NCObjectDao;
import nc.dao.ObjectDao;
import nc.entity.*;
import nc.entity.impl.NCAttributeImpl;
import nc.entity.impl.PlayerImpl;
import nc.service.PlayerService;
import nc.util.NCObjectConverter;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by petka on 09.05.2017.
 *
 * @author Evgeniy Tupikov
 */
@Service("playerDBService")
@Transactional(readOnly = true)
public class PlayerDBService implements PlayerService {

    public static final Logger log = Logger.getLogger(PlayerDBService.class);

    @Autowired
    @Qualifier("objectDaoImpl")
    private ObjectDao objectDao;

    @Override
    @Transactional(readOnly = false)
    public String createPlayer(Player player, String parentId) {
        log.info("Create player : " + player.toString());
        ObjectEntity object = NCObjectConverter.toNCObject(player);
        object.setParent(new ObjectEntity(parentId));
        return (String) objectDao.saveObject(object);
    }

    @Override
    @Transactional(readOnly = false)
    public void updatePlayer(Player player) {
        ObjectEntity objectEntityUpdate = objectDao.getObjectById(player.getId());
        ObjectEntity objectEntityNew = NCObjectConverter.toNCObject(player);
        objectEntityUpdate.getParamEntityList().clear();
        objectEntityUpdate.getParamEntityList().addAll(objectEntityNew.getParamEntityList());
        objectDao.updateObject(objectEntityUpdate);
    }

    @Override
    @Transactional(readOnly = false)
    public void deletePlayer(String id) {
        ObjectEntity objectEntity = objectDao.getObjectById(id);
        if (objectEntity != null)
            objectDao.deleteObject(objectEntity);
    }

    @Override
    public Player getById(String id) {
        ObjectEntity object = objectDao.getObjectById(id);
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
        ObjectEntity objectParent = objectDao.getObjectById(division.getId());
        log.info(objectParent.toString());
        List<ObjectEntity> objectList = objectDao.getObjectsByParent(objectParent);
        List<Player> playerList = new ArrayList<>();
        for (ObjectEntity object : objectList) {
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
