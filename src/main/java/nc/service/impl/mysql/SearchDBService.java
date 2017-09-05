package nc.service.impl.mysql;

import nc.dao.NCObjectDao;
import nc.dao.ObjectDao;
import nc.entity.ObjectEntity;
import nc.entity.SearchResultObject;
import nc.service.SearchService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by petka on 17.05.2017.
 *
 * @author Evgeniy Tupikov
 */
@Service("searchDBService")
@Transactional(readOnly = true)
public class SearchDBService implements SearchService {

    public static final Logger log = Logger.getLogger(PlayerDBService.class);

    @Autowired
    @Qualifier("objectDaoImpl")
    private ObjectDao objectDao;

    @Override
    public List<ObjectEntity> search(String query) {
        return objectDao.findByAttributes(query);
    }
}
