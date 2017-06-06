package nc.service.impl.xml;

import nc.entity.NCObject;
import nc.entity.impl.NCObjectImpl;
import nc.service.XMLStatelessBean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Created by petka on 02.06.2017.
 *
 * @author Evgeniy Tupikov
 */
@Service("xmlService")
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class XMLSessionBean implements XMLStatelessBean {

    @Override
    public Document getDocumentObject(NCObject object) {
        try {
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            JAXBContext context = JAXBContext.newInstance(NCObjectImpl.class);
            Marshaller m = context.createMarshaller();
            m.marshal(object, document);
            return document;
        } catch (ParserConfigurationException | JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public File getFileObject(NCObject object) {

        try {
            File file = File.createTempFile("importObject", ".xml");
            JAXBContext context = JAXBContext.newInstance(NCObjectImpl.class);
            Marshaller m = context.createMarshaller();
            m.marshal(object, file);
            return file;
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }

        return null;
    }
}
