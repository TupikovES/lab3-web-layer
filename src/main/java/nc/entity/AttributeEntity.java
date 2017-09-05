package nc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by x3mib on 10.07.2017.
 */
@Entity
@Table(name = "nc_attribute")
public class AttributeEntity implements Serializable {

    private static final long serialVersionUID = -5513871868761011881L;

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "attribute_id")
    private String attributeId;

    @Column(name= "attribute_name", nullable = false)
    private String attributeName;

    @ManyToOne
    @JoinColumn(name = "object_type", nullable = false)
    private ObjectType objectType;

    @Column(name = "order_id", nullable = false)
    private int orderId;

    @Column(name = "type")
    @NotNull
    private String typeName;

    @Column(name = "multiple")
    private boolean multiple;

    public AttributeEntity() {
    }

    public AttributeEntity(String attributeId) {
        this.attributeId = attributeId;
    }

    public AttributeEntity(String attributeId, String attributeName, ObjectType objectType, int orderId, String typeName, boolean multiple) {
        this.attributeId = attributeId;
        this.attributeName = attributeName;
        this.objectType = objectType;
        this.orderId = orderId;
        this.typeName = typeName;
        this.multiple = multiple;
    }

    public AttributeEntity(String attributeName, ObjectType objectType, int orderId, String typeName, boolean multiple) {
        this.attributeName = attributeName;
        this.objectType = objectType;
        this.orderId = orderId;
        this.typeName = typeName;
        this.multiple = multiple;


    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(String attributeId) {
        this.attributeId = attributeId;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public ObjectType getObjectType() {
        return objectType;
    }

    public void setObjectType(ObjectType objectType) {
        this.objectType = objectType;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public boolean isMultiple() {
        return multiple;
    }

    public void setMultiple(boolean multiple) {
        this.multiple = multiple;
    }
}
