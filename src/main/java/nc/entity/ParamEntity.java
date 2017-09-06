package nc.entity;

import nc.entity.ids.ParamPk;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by x3mib on 12.07.2017.
 */
@Entity
@Table(name = "nc_params")
@IdClass(ParamPk.class)
@org.hibernate.annotations.NamedQueries({
        @NamedQuery(name = "getParamForObject", query = "from ParamEntity pe where pe.objectId = :id"),
        @NamedQuery(name = "getObjectsByParam", query = "select pe.objectId from ParamEntity pe where locate(:numberValue, pe.numberValue) > 0 or locate(:stringValue, pe.stringValue) > 0")
})
public class ParamEntity implements Serializable{

    private static final long serialVersionUID = -1749537130852076187L;

    @Id
    @ManyToOne
    @JoinColumn(name= "object_id", nullable = false)
    private ObjectEntity objectId;

    @Id
    @ManyToOne
    @JoinColumn(name= "attribute_id", nullable = false)
    private AttributeEntity attributeId;

    @Column(name = "string_value")
    private String stringValue;

    @Column(name = "number_value")
    private Integer numberValue;

    @Column(name = "date_value")
    private Date dateValue;

    @JoinColumn(name= "reference_value")
    @ManyToOne
    private ObjectEntity objectEntityValue;

    public ParamEntity() {
    }

    public ParamEntity(ObjectEntity objectId, AttributeEntity attributeId, String stringValue, Integer numberValue, Date dateValue, ObjectEntity objectEntityValue) {
        this.objectId = objectId;
        this.attributeId = attributeId;
        this.stringValue = stringValue;
        this.numberValue = numberValue;
        this.dateValue = dateValue;
        this.objectEntityValue = objectEntityValue;
    }

    public ParamEntity(ObjectEntity objectId, AttributeEntity attributeId, String stringValue) {
        this.objectId = objectId;
        this.attributeId = attributeId;
        this.stringValue = stringValue;
    }

    public ParamEntity(ObjectEntity objectId, AttributeEntity attributeId, Integer numberValue) {
        this.objectId = objectId;
        this.attributeId = attributeId;
        this.numberValue = numberValue;
    }

    public ParamEntity(ObjectEntity objectId, AttributeEntity attributeId, Date dateValue) {
        this.objectId = objectId;
        this.attributeId = attributeId;
        this.dateValue = dateValue;
    }

    public ParamEntity(ObjectEntity objectId, AttributeEntity attributeId, ObjectEntity objectEntityValue) {
        this.objectId = objectId;
        this.attributeId = attributeId;
        this.objectEntityValue = objectEntityValue;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public ObjectEntity getObjectId() {
        return objectId;
    }

    public void setObjectId(ObjectEntity objectId) {
        this.objectId = objectId;
    }

    public AttributeEntity getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(AttributeEntity attributeId) {
        this.attributeId = attributeId;
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public Integer getNumberValue() {
        return numberValue;
    }

    public void setNumberValue(Integer numberValue) {
        this.numberValue = numberValue;
    }

    public Date getDateValue() {
        return dateValue;
    }

    public void setDateValue(Date dateValue) {
        this.dateValue = dateValue;
    }

    public ObjectEntity getObjectEntityValue() {
        return objectEntityValue;
    }

    public void setObjectEntityValue(ObjectEntity objectEntityValue) {
        this.objectEntityValue = objectEntityValue;
    }
}
