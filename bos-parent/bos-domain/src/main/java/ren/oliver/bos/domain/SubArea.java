package ren.oliver.bos.domain;

import java.io.Serializable;

public class SubArea implements Serializable {

    private String id;
    private DecidedZone decidedZone;
    private Region region;
    private String addresskey;
    private String startnum;
    private String endnum;
    private String single;
    private String position;

    public SubArea() {

    }

    public SubArea(String id) {

        this.id = id;
    }

    public SubArea(String id, DecidedZone decidedzone, Region region,
                   String addresskey, String startnum, String endnum, String single,
                   String position) {

        this.id = id;
        this.decidedZone = decidedzone;
        this.region = region;
        this.addresskey = addresskey;
        this.startnum = startnum;
        this.endnum = endnum;
        this.single = single;
        this.position = position;
    }

    public String getId() {

        return this.id;
    }

    public void setId(String id) {

        this.id = id;
    }

    public DecidedZone getDecidedzone() {

        return this.decidedZone;
    }

    public void setDecidedzone(DecidedZone decidedZone) {

        this.decidedZone = decidedZone;
    }

    public Region getRegion() {

        return this.region;
    }

    public void setRegion(Region region) {

        this.region = region;
    }

    public String getAddresskey() {

        return this.addresskey;
    }

    public void setAddresskey(String addresskey) {

        this.addresskey = addresskey;
    }

    public String getStartnum() {

        return this.startnum;
    }

    public void setStartnum(String startnum) {

        this.startnum = startnum;
    }

    public String getEndnum() {

        return this.endnum;
    }

    public void setEndnum(String endnum) {

        this.endnum = endnum;
    }

    public String getSingle() {

        return this.single;
    }

    public void setSingle(String single) {

        this.single = single;
    }

    public String getPosition() {

        return this.position;
    }

    public void setPosition(String position) {

        this.position = position;
    }
}
