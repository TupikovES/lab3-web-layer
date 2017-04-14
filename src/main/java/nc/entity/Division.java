package nc.entity;

import java.io.Serializable;

/**
 * Created by petka on 24.03.2017.
 *
 * @author Evgeniy Tupikov
 */
public interface Division extends Serializable {
    String getId();
    void setId(String id);
    String getName();
    void setName(String name);
}
