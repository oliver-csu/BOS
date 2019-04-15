package ren.oliver.bos.domain;

import java.io.Serializable;
import java.util.Date;

public class WorkOrderManage implements Serializable {

    private String id;
    private String arriveCity;
    private String product;
    private Integer num;
    private Double weight;
    private String floadreqr;
    private String prodtimeLimit;
    private String prodType;
    private String senderName;
    private String senderPhone;
    private String senderAddr;
    private String receiverName;
    private String receiverPhone;
    private String receiverAddr;
    private Integer feeitemnum;
    private Double actlweit;
    private String vol;
    private String managerCheck;
    private Date updatetime;

    public WorkOrderManage() {

    }

    public WorkOrderManage(String id) {

        this.id = id;
    }

    public WorkOrderManage(String id, String arriveCity, String product,
                           Integer num, Double weight, String floadreqr, String prodtimeLimit,
                           String prodType, String senderName, String senderPhone,
                           String senderAddr, String receiverName, String receiverPhone,
                           String receiverAddr, Integer feeitemnum, Double actlweit,
                           String vol, String managerCheck, Date updatetime) {

        this.id = id;
        this.arriveCity = arriveCity;
        this.product = product;
        this.num = num;
        this.weight = weight;
        this.floadreqr = floadreqr;
        this.prodtimeLimit = prodtimeLimit;
        this.prodType = prodType;
        this.senderName = senderName;
        this.senderPhone = senderPhone;
        this.senderAddr = senderAddr;
        this.receiverName = receiverName;
        this.receiverPhone = receiverPhone;
        this.receiverAddr = receiverAddr;
        this.feeitemnum = feeitemnum;
        this.actlweit = actlweit;
        this.vol = vol;
        this.managerCheck = managerCheck;
        this.updatetime = updatetime;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {

        this.id = id;
    }

    public String getArriveCity() {

        return arriveCity;
    }

    public void setArriveCity(String arriveCity) {

        this.arriveCity = arriveCity;
    }

    public String getProduct() {

        return product;
    }

    public void setProduct(String product) {

        this.product = product;
    }

    public Integer getNum() {

        return num;
    }

    public void setNum(Integer num) {

        this.num = num;
    }

    public Double getWeight() {

        return weight;
    }

    public void setWeight(Double weight) {

        this.weight = weight;
    }

    public String getFloadreqr() {

        return floadreqr;
    }

    public void setFloadreqr(String floadreqr) {

        this.floadreqr = floadreqr;
    }

    public String getProdtimeLimit() {

        return prodtimeLimit;
    }

    public void setProdtimeLimit(String prodtimeLimit) {

        this.prodtimeLimit = prodtimeLimit;
    }

    public String getProdType() {

        return prodType;
    }

    public void setProdType(String prodType) {

        this.prodType = prodType;
    }

    public String getSenderName() {

        return senderName;
    }

    public void setSenderName(String senderName) {

        this.senderName = senderName;
    }

    public String getSenderPhone() {

        return senderPhone;
    }

    public void setSenderPhone(String senderPhone) {

        this.senderPhone = senderPhone;
    }

    public String getSenderAddr() {

        return senderAddr;
    }

    public void setSenderAddr(String senderAddr) {

        this.senderAddr = senderAddr;
    }

    public String getReceiverName() {

        return receiverName;
    }

    public void setReceiverName(String receiverName) {

        this.receiverName = receiverName;
    }

    public String getReceiverPhone() {

        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {

        this.receiverPhone = receiverPhone;
    }

    public String getReceiverAddr() {

        return receiverAddr;
    }

    public void setReceiverAddr(String receiverAddr) {

        this.receiverAddr = receiverAddr;
    }

    public Integer getFeeitemnum() {

        return feeitemnum;
    }

    public void setFeeitemnum(Integer feeitemnum) {

        this.feeitemnum = feeitemnum;
    }

    public Double getActlweit() {

        return actlweit;
    }

    public void setActlweit(Double actlweit) {

        this.actlweit = actlweit;
    }

    public String getVol() {

        return vol;
    }

    public void setVol(String vol) {

        this.vol = vol;
    }

    public String getManagerCheck() {

        return managerCheck;
    }

    public void setManagerCheck(String managerCheck) {

        this.managerCheck = managerCheck;
    }

    public Date getUpdatetime() {

        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {

        this.updatetime = updatetime;
    }
}
