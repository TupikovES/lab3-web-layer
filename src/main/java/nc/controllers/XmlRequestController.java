package nc.controllers;

import nc.dao.NCObjectDao;
import nc.entity.NCObject;
import nc.entity.NCParam;
import nc.service.XMLStatelessBean;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
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
public class XmlRequestController {

    public static final Logger log = Logger.getLogger(XmlRequestController.class);

    @Autowired
    @Qualifier("xmlService")
    private XMLStatelessBean xmlStatelessBean;

    @Autowired
    @Qualifier("ncObjectDaoImpl")
    private NCObjectDao objectDao;

    @RequestMapping("/xml")
    public String getObject(Model model) throws Exception {
        NCObject ncObject;
        ncObject = objectDao.getObjectById("1168919a-3cba-11e7-8567-b888e3a0097b");
        ncObject.setValues(objectDao.getValuesByObject(ncObject));
        List<NCParam> paramList = new ArrayList<>();
        paramList.addAll(ncObject.getValues().values());
        ncObject.setParams(paramList);

        model.addAttribute("object", xmlStatelessBean.getDocumentObject(ncObject));

        return "viewobject";
    }

    @RequestMapping("/xml/export")
    public void getFile(HttpServletResponse response) throws IOException {
        NCObject ncObject;
        ncObject = objectDao.getObjectById("1168919a-3cba-11e7-8567-b888e3a0097b");
        ncObject.setValues(objectDao.getValuesByObject(ncObject));
        List<NCParam> paramList = new ArrayList<>();
        paramList.addAll(ncObject.getValues().values());
        ncObject.setParams(paramList);
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

}
