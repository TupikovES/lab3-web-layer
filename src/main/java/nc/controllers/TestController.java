package nc.controllers;

import nc.dao.NCObjectDao;
import nc.entity.NCObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    @Qualifier("NCObjectDaoORMImpl")
    private NCObjectDao objectDao;

    @RequestMapping("/getObject/{id}")
    public String getObject(@PathVariable String id, Model model) {
        NCObject object = objectDao.getObjectById(id);
        model.addAttribute("object", object.toString());
        return "test/object";
    }

}
