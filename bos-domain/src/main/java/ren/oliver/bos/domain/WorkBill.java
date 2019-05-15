package ren.oliver.bos.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class WorkBill implements Serializable {

    public static final String  TYPE_1 = "新单";
    public static final String  TYPE_2 = "追单";
    public static final String  TYPE_3 = "改单";
    public static final String  TYPE_4 = "销单";
    public static final String  PICKSTATE_NO = "未取件";
    public static final String  PICKSTATE_RUNNING = "取件中";
    public static final String  PICKSTATE_YES = "已取件";

    private String id;
    private NoticeBill noticeBill;
    private Staff staff;
    private String type;
    private String pickstate;
    private Timestamp buildTime;
    private Integer attachBillTimes;
    private String remark;

    public WorkBill() {

    }

    public WorkBill(String id, Timestamp buildTime) {

        this.id = id;
        this.buildTime = buildTime;
    }

    public WorkBill(String id, NoticeBill noticeBill, Staff staff, String type,
                    String pickstate, Timestamp buildTime, Integer attachBillTimes,
                    String remark) {

        this.id = id;
        this.noticeBill = noticeBill;
        this.staff = staff;
        this.type = type;
        this.pickstate = pickstate;
        this.buildTime = buildTime;
        this.attachBillTimes = attachBillTimes;
        this.remark = remark;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {

        this.id = id;
    }

    public NoticeBill getNoticeBill() {

        return noticeBill;
    }

    public void setNoticeBill(NoticeBill noticeBill) {

        this.noticeBill = noticeBill;
    }

    public Staff getStaff() {

        return staff;
    }

    public void setStaff(Staff staff) {

        this.staff = staff;
    }

    public String getType() {

        return type;
    }

    public void setType(String type) {

        this.type = type;
    }

    public String getPickstate() {

        return pickstate;
    }

    public void setPickstate(String pickstate) {

        this.pickstate = pickstate;
    }

    public Timestamp getBuildTime() {

        return buildTime;
    }

    public void setBuildTime(Timestamp buildTime) {

        this.buildTime = buildTime;
    }

    public Integer getAttachBillTimes() {

        return attachBillTimes;
    }

    public void setAttachBillTimes(Integer attachBillTimes) {

        this.attachBillTimes = attachBillTimes;
    }

    public String getRemark() {

        return remark;
    }

    public void setRemark(String remark) {

        this.remark = remark;
    }
}
