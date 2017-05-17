package nc.service.impl.mysql;

import nc.dao.NCObjectDao;
import nc.entity.SearchResultObject;
import nc.service.SearchService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by petka on 17.05.2017.
 *
 * @author Evgeniy Tupikov
 */
@Service("searchDBService")
public class SearchDBService implements SearchService {

    public static final Logger log = Logger.getLogger(PlayerDBService.class);

    @Autowired
    @Qualifier("ncObjectDaoImpl")
    private NCObjectDao objectDao;

    @Override
    public List<SearchResultObject> search(String query) {
        return objectDao.searchObjectByParam(query);
    }
}
