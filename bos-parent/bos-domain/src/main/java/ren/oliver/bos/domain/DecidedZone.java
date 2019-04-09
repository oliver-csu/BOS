package ren.oliver.bos.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class DecidedZone implements Serializable {

    private String id;
    private Staff staff;
    private String name;
    private Set subAreas = new HashSet(0);

    public DecidedZone() {

    }

    public DecidedZone(String id) {

        this.id = id;
    }

    public DecidedZone(String id, Staff staff, String name, Set subAreas) {

        this.id = id;
        this.staff = staff;
        this.name = name;
        this.subAreas = subAreas;
    }

    public String getId() {

        return this.id;
    }

    public void setId(String id) {

        this.id = id;
    }

    public Staff getStaff() {

        return this.staff;
    }

    public void setStaff(Staff staff) {

        this.staff = staff;
    }

    public String getName() {

        return this.name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public Set getSubAreas() {

        return this.subAreas;
    }

    public void setSubAreas(Set subAreas) {

        this.subAreas = subAreas;
    }
}
