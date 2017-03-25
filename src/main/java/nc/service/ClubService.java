package nc.service;

import nc.entity.Club;

import java.util.List;

/**
 * Created by petka on 24.03.2017.
 *
 * @author Evgeniy Tupikov
 */
public interface ClubService {
    Club getById(String id);
    Club getByName(String name);
    int deleteClub(Club club);
    int updateClub(Club club);
    List<Club> getAll();
    int createClub(Club club);
    boolean isExist(Club club);
}
