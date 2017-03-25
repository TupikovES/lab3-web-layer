package nc.entity;

import java.io.Serializable;

/**
 * Created by petka on 24.03.2017.
 *
 * @author Evgeniy Tupikov
 */
public interface Player extends Serializable {
    String getId();
    void setId(String id);
    String getFirstName();
    void setFirstName(String firstName);
    String getLastName();
    void setLastName(String lastName);
    int getAge();
    void setAge(int age);
}
