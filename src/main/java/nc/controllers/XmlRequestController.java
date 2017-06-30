package nc.controllers;

import nc.dao.NCObjectDao;
import nc.entity.NCObject;
import nc.entity.NCParam;
import nc.entity.impl.NCObjectImpl;
import nc.service.XMLStatelessBean;
import nc.util.Utilites;
import nc.util.batchsqlquery.impl.ClubBatchSqlCreator;
import nc.util.batchsqlquery.impl.PlayerBatchSqlCreator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by petka on 05.06.2017.
 *
 * @author Evgeniy Tupikov
 */
@Controller
@RequestMapping("/xml")
@SessionAttributes("object")
public class XmlRequestController{

    public static final Logger log = Logger.getLogger(XmlRequestController.class);

    @Autowired
    @Qualifier("xmlService")
    private XMLStatelessBean xmlStatelessBean;

    @Autowired
    @Qualifier("ncObjectDaoImpl")
    private NCObjectDao objectDao;

    @RequestMapping("/{id}")
    public String getObject(@PathVariable String id, Model model) throws Exception {
        NCObject ncObject;
        ncObject = objectDao.getObjectById(id);
        ncObject.setValues(objectDao.getValuesByObject(ncObject));
        List<NCParam> paramList = new ArrayList<>();
        paramList.addAll(ncObject.getValues().values());
        ncObject.setParams(paramList);

        model.addAttribute("object", xmlStatelessBean.getDocumentObject(ncObject));

        return "viewobject";
    }

    @RequestMapping("/export/{id}")
    public void getFile(HttpServletResponse response, @PathVariable String id) throws IOException {
        NCObject ncObject;
        ncObject = objectDao.getObjectById(id);
        ncObject.setValues(objectDao.getValuesByObject(ncObject));
        List<NCParam> paramList = new ArrayList<>();
        paramList.addAll(ncObject.getValues().values());
        ncObject.setParams(paramList);
        ncObject.setChildList(objectDao.getObjectsByParent(ncObject));
        for (NCObject object : ncObject.getChildList()) {
            List<NCParam> tempParamList = new ArrayList<>();
            tempParamList.addAll(objectDao.getValuesByObject(object).values());
            object.setParams(tempParamList);
        }
        File file = xmlStatelessBean.getFileObject(ncObject);
        String memType = URLConnection.guessContentTypeFromName(file.getName());
        if (memType == null) {
            memType = "application/octet-stream";
        }
        response.setContentType(memType);
        response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() +"\""));
        response.setContentLength((int)file.length());
        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
        FileCopyUtils.copy(inputStream, response.getOutputStream());
    }

    @RequestMapping(value = "/import", method = RequestMethod.GET)
    public String viewImportPage(@RequestParam(defaultValue = "none") String message, Model model, SessionStatus session){
        model.addAttribute("message", message);
        session.setComplete();
        return "import/importPage";
    }


    @RequestMapping(value = "/import", method = RequestMethod.POST)
    public String importFile(@RequestParam MultipartFile file, RedirectAttributes redirectAttributes,
                             Model model, HttpSession session, HttpServletRequest request){
        NCObject object = xmlStatelessBean.importFile(Utilites.multipartFileToFile(file));
        log.info("Unmarshaller object: id=" + object.getObjectId() + ", param=" + object.getParams().get(1));
        if (object == null) {
            redirectAttributes.addAttribute("message", "error file");
            return "redirect:/xml/import";
        }
        if (objectDao.getObjectById(object.getObjectParent()) == null) {
            redirectAttributes.addAttribute("message", "No parent this object");
            return "redirect:/xml/import";
        }
        if (objectDao.isExist(object)) {
            log.info("insert object params : " + object.getObjectId() + " = " + object.getParams().toString());
            object.setContext(object.getObjectType() == "0be38f6b-10b9-11e7-83f0-b888e3a0097b" ? new PlayerBatchSqlCreator() : new ClubBatchSqlCreator());
            objectDao.insertObject(object);
            return "redirect:/search?query=" + object.getObjectName();
        } else {
            NCObject oldObject = objectDao.getObjectById(object.getObjectId());
            oldObject.setParams(object.getParams());
            session = request.getSession(true);
            session.setAttribute("object", object);
            model.addAttribute("object", object);
            model.addAttribute("oldObject", oldObject);
            model.addAttribute("oldParamList", oldObject.getParams());
            model.addAttribute("newObject", object);
            model.addAttribute("newParamList", object.getParams());
            return "import/updatePage";
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateObject(@ModelAttribute("object") NCObject ncObject, Model model) {
        //NCObject object = (NCObject) session.getAttribute("object");
        log.info(ncObject.toString());
        objectDao.updateObject(ncObject);
        return "redirect:/search?query=" + ncObject.getObjectName();
    }

}
