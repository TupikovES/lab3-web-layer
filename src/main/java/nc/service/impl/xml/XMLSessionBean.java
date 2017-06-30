package nc.service.impl.xml;

import nc.entity.NCObject;
import nc.entity.impl.NCObjectImpl;
import nc.service.XMLStatelessBean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.XMLConstants;
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

    @Override
    public NCObject importFile(File file) {
        try {
            JAXBContext context = JAXBContext.newInstance(NCObjectImpl.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(new File("F:\\Projects\\_IDEAProjects\\lab3-web-layer\\src\\main\\resources\\schema1.xsd"));
            unmarshaller.setSchema(schema);
            NCObject object = (NCObject) unmarshaller.unmarshal(file);
            return object;
        } catch (JAXBException | SAXException e) {
            e.printStackTrace();
        }

        return null;
    }
}
