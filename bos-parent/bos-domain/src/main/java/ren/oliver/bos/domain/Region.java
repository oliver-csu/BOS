package ren.oliver.bos.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Region implements Serializable {

    private String id;
    private String province;
    private String city;
    private String district;
    private String postcode;
    private String shortcode;
    private String citycode;
    private Set subAreas = new HashSet(0);

    public Region() {

    }

    public Region(String id) {

        this.id = id;
    }

    public Region(String id, String province, String city, String district,
                  String postcode, String shortcode, String citycode, Set subAreas) {

        this.id = id;
        this.province = province;
        this.city = city;
        this.district = district;
        this.postcode = postcode;
        this.shortcode = shortcode;
        this.citycode = citycode;
        this.subAreas = subAreas;
    }

    public String getId() {

        return this.id;
    }

    public void setId(String id) {

        this.id = id;
    }

    public String getProvince() {

        return this.province;
    }

    public void setProvince(String province) {

        this.province = province;
    }

    public String getCity() {

        return this.city;
    }

    public void setCity(String city) {

        this.city = city;
    }

    public String getDistrict() {

        return this.district;
    }

    public void setDistrict(String district) {

        this.district = district;
    }

    public String getPostcode() {

        return this.postcode;
    }

    public void setPostcode(String postcode) {

        this.postcode = postcode;
    }

    public String getShortcode() {

        return this.shortcode;
    }

    public void setShortcode(String shortcode) {

        this.shortcode = shortcode;
    }

    public String getCitycode() {

        return this.citycode;
    }

    public void setCitycode(String citycode) {

        this.citycode = citycode;
    }

    public Set getSubAreas() {

        return this.subAreas;
    }

    public void setSubAreas(Set subAreas) {

        this.subAreas = subAreas;
    }
}
