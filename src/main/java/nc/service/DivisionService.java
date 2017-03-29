package nc.service;

import nc.entity.Club;
import nc.entity.Division;

import java.util.List;

/**
 * Created by petka on 28.03.2017.
 *
 * @author Evgeniy Tupikov
 */
public interface DivisionService {
    String createDivision(Division division);
    void updateDivision(Division division);
    void deleteDivision(String id);
    Division getById(String id);
    Division getByName(String name);
    List<Division> getByClub(Club club);
    List<Division> getAll();
    boolean isExist(Division division);
}
