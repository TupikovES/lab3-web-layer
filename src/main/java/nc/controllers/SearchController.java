package nc.controllers;

import nc.entity.ObjectEntity;
import nc.entity.SearchResultObject;
import nc.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by petka on 17.05.2017.
 *
 * @author Evgeniy Tupikov
 */
@Controller
public class SearchController {

    @Autowired
    @Qualifier("searchDBService")
    private SearchService searchService;

    @RequestMapping("/search")
    public String search(@RequestParam String query, Model model) {
        List<ObjectEntity> resultObjects;
        resultObjects = searchService.search(query);
        model.addAttribute("query", query);
        model.addAttribute("results", resultObjects);
        return "search/view_result";
    }

}
