package nc.service;

import nc.entity.SearchResultObject;

import java.util.List;

/**
 * Created by petka on 17.05.2017.
 *
 * @author Evgeniy Tupikov
 */
public interface SearchService {
    List<SearchResultObject> search(String query);
}
