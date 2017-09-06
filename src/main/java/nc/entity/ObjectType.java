package nc.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "nc_object_type")
@org.hibernate.annotations.NamedQueries({
        @NamedQuery(name = "getObjectTypeByName", query = "from ObjectType ot where ot.name = :name")
})
public class ObjectType implements Serializable {

    private static final long serialVersionUID = 8830573077028736448L;

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "object_type_id")
    private String id;

    @NotNull
    @Column(name = "object_type_name", unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private ObjectType parent;

    public ObjectType() {
    }

    public ObjectType(String id) {
        this.id = id;
    }

    public ObjectType(String id, String name, ObjectType parent) {
        this.id = id;
        this.name = name;
        this.parent = parent;
    }

    public ObjectType(String name, ObjectType parent) {
        this.name = name;
        this.parent = parent;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ObjectType getParent() {
        return parent;
    }

    public void setParent(ObjectType parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "object type {" +
                "name=" + name + ", " +
                "parent=" + (parent != null ? parent.getName() : "not parent") +
                "}";
    }
}
