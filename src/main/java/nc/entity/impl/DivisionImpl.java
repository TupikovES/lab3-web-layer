package nc.entity.impl;

import nc.entity.Division;

import javax.xml.bind.annotation.*;

/**
 * Created by petka on 13.04.2017.
 *
 * @author Evgeniy Tupikov
 */
@XmlRootElement(name = "division")
@XmlAccessorType(XmlAccessType.FIELD)
public class DivisionImpl implements Division {

    private static final long serialVersionUID = -974164528464548757L;

    private String id;
    private String name;

    public DivisionImpl() {}

    public DivisionImpl(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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
}
