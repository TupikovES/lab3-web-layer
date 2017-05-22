package nc.service;

import nc.entity.Club;
import nc.entity.Division;
import nc.entity.Player;

import java.util.List;

/**
 * Created by petka on 28.03.2017.
 *
 * @author Evgeniy Tupikov
 */
public interface PlayerService {
    String createPlayer(Player player, String parentId);
    void updatePlayer(Player player);
    void deletePlayer(String id);
    Player getById(String id);
    Player getByFirstName(String firstName);
    Player getByLastName(String lastName);
    List<Player> getByClub(Club club);
    List<Player> getByDivision(Division division);
    List<Player> getByAge(int age);
    List<Player> getAll();
    boolean isExist(Player player);
}
