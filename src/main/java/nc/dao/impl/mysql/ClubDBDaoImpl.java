package nc.dao.impl.mysql;

import nc.dao.ClubDao;
import nc.entity.Club;
import nc.entity.impl.ClubImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by petka on 24.03.2017.
 *
 * @author Evgeniy Tupikov
 */
@Repository("clubDBDaoImpl")
public class ClubDBDaoImpl implements ClubDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public class ClubMapper implements RowMapper<Club> {
        @Override
        public Club mapRow(ResultSet resultSet, int i) throws SQLException {
            Club club = new ClubImpl();
            club.setId(resultSet.getString("object_id"));
            club.setName(resultSet.getString(""));
            return club;
        }
    }


    @Override
    public Club getById(String id) {
        return null;
    }

    @Override
    public Club getByName(String name) {
        return null;
    }

    @Override
    public int deleteClub(Club club) {
        return 0;
    }

    @Override
    public int updateClub(Club club) {
        return 0;
    }

    @Override
    public List<Club> getAll() {
        return null;
    }

    @Override
    public int createClub(Club club) {
        return 0;
    }

    @Override
    public boolean isExist(Club club) {
        return false;
    }
}
