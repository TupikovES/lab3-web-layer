package nc.service;

import nc.entity.NCObject;
import org.w3c.dom.Document;

import java.io.File;

/**
 * Created by petka on 02.06.2017.
 *
 * @author Evgeniy Tupikov
 */
public interface XMLStatelessBean {
    Document getDocumentObject(NCObject object);
    File getFileObject(NCObject object);
}
