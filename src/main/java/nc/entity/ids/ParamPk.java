package nc.entity.ids;

import nc.entity.AttributeEntity;
import nc.entity.ObjectEntity;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by x3mib on 08.07.2017.
 */
@Embeddable
public class ParamPk implements Serializable {

    private static final long serialVersionUID = 1324109517195714469L;

    private ObjectEntity objectId;

    private AttributeEntity attributeId;

    public ParamPk() {
    }

    public ParamPk(ObjectEntity objectId, AttributeEntity attributeId) {
        this.objectId = objectId;
        this.attributeId = attributeId;
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

    @Override
    public int hashCode() {
        int result = 0;
        result = result + objectId.hashCode();
        result = result + attributeId.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        ParamPk other = (ParamPk) obj;
        if (objectId.equals(other.getObjectId()) && attributeId.equals(other.getAttributeId())) {
            return true;
        } else {
            return false;
        }
    }
}
