package nc.entity.impl;

import nc.entity.Club;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by petka on 24.03.2017.
 *
 * @author Evgeniy Tupikov
 */
@XmlRootElement(name = "club")
@XmlAccessorType(XmlAccessType.FIELD)
public class ClubImpl implements Club {

    private static final long serialVersionUID = -6019060070107352857L;

    private String id;
    private String name;
    private String city;

    public ClubImpl() {
    }

    public ClubImpl(String id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public ClubImpl(String name, String city) {
        this.name = name;
        this.city = city;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getCity() {
        return city;
    }

    @Override
    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "ClubImpl{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                "}";
    }
}
