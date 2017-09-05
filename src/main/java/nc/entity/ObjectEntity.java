package nc.entity;

import org.hibernate.annotations.*;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "nc_object")
@NamedQueries({
        @NamedQuery(name = "getObjectsByObjectType", query = "from ObjectEntity oe where oe.objectType = :objectType"),
        @NamedQuery(name = "getObjectById", query = "from ObjectEntity oe where oe.id = :id"),
        //@NamedQuery(name = "updateObjects", query = "update ObjectEntity oe set oe.name = :suffix||''||(select pe.stringValue form ParamEntity pe where pe.attributeId = :attributeId and pe.objectId = oe) where oe.objectType = :objectType"),
        @NamedQuery(name = "getObjectsByParent", query = "from ObjectEntity oe where oe.parent = :parent")
})
public class ObjectEntity implements Serializable {

    private static final long serialVersionUID = 3720088500236365064L;

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "object_id")
    private String id;

    @NotNull
    @Column(name = "object_name")
    private String name;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "object_type")
    private ObjectType objectType;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private ObjectEntity parent;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "objectId", cascade = CascadeType.ALL)
    private List<ParamEntity> paramEntityList = new ArrayList<>();

    public ObjectEntity() {
    }

    public ObjectEntity(String id) {
        this.id = id;
    }

    public ObjectEntity(String id, String name, ObjectType objectType, ObjectEntity parent) {
        this.id = id;
        this.name = name;
        this.objectType = objectType;
        this.parent = parent;
    }

    public ObjectEntity(String name, ObjectType objectType, ObjectEntity parent) {
        this.name = name;
        this.objectType = objectType;
        this.parent = parent;
    }

    public ObjectEntity(String name, ObjectType objectType) {
        this.name = name;
        this.objectType = objectType;
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

    public ObjectType getObjectType() {
        return objectType;
    }

    public void setObjectType(ObjectType objectType) {
        this.objectType = objectType;
    }

    public ObjectEntity getParent() {
        return parent;
    }

    public void setParent(ObjectEntity parent) {
        this.parent = parent;
    }

    public List<ParamEntity> getParamEntityList() {
        return paramEntityList;
    }

    public void setParamEntityList(List<ParamEntity> paramEntityList) {
        this.paramEntityList = paramEntityList;
    }

    @Override
    public String toString() {
        return "object {" +
                "id=" + id + ", " +
                "name=" + name + ", " +
                "type=" + objectType.toString() + ", " +
                "parent=" + (parent != null ? parent.toString() : "not parent") +
                "}";
    }
}
