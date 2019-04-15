package ren.oliver.bos.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class NoticeBill implements Serializable {

    public static final String  ORDERTYPE_AUTO = "自动分单";
    public static final String  ORDERTYPE_MANUL = "人工分单";

    private String id;
    private User user;
    private Staff staff;
    private String customerId;
    private String customerName;
    private String delegater;
    private String telephone;
    private String pickAddress;
    private String arriveCity;
    private String product;
    private Date pickdate;
    private Integer num;
    private Double weight;
    private String volume;
    private String remark;
    private String orderType;
    private Set workBills = new HashSet(0);

    public NoticeBill() {

    }

    public NoticeBill(String id) {

        this.id = id;
    }

    public NoticeBill(String id, User user, Staff staff, String customerId,
                      String customerName, String delegater, String telephone,
                      String pickAddress, String arriveCity, String product,
                      Date pickdate, Integer num, Double weight, String volume,
                      String remark, String orderType, Set workBills) {

        this.id = id;
        this.user = user;
        this.staff = staff;
        this.customerId = customerId;
        this.customerName = customerName;
        this.delegater = delegater;
        this.telephone = telephone;
        this.pickAddress = pickAddress;
        this.arriveCity = arriveCity;
        this.product = product;
        this.pickdate = pickdate;
        this.num = num;
        this.weight = weight;
        this.volume = volume;
        this.remark = remark;
        this.orderType = orderType;
        this.workBills = workBills;
    }

    public String getId() {

        return this.id;
    }

    public void setId(String id) {

        this.id = id;
    }

    public User getUser() {

        return this.user;
    }

    public void setUser(User user) {

        this.user = user;
    }

    public Staff getStaff() {

        return this.staff;
    }

    public void setStaff(Staff staff) {

        this.staff = staff;
    }

    public String getCustomerId() {

        return this.customerId;
    }

    public void setCustomerId(String customerId) {

        this.customerId = customerId;
    }

    public String getCustomerName() {

        return this.customerName;
    }

    public void setCustomerName(String customerName) {

        this.customerName = customerName;
    }

    public String getDelegater() {

        return this.delegater;
    }

    public void setDelegater(String delegater) {

        this.delegater = delegater;
    }

    public String getTelephone() {

        return this.telephone;
    }

    public void setTelephone(String telephone) {

        this.telephone = telephone;
    }

    public String getPickAddress() {

        return this.pickAddress;
    }

    public void setPickAddress(String pickAddress) {

        this.pickAddress = pickAddress;
    }

    public String getArriveCity() {

        return this.arriveCity;
    }

    public void setArriveCity(String arriveCity) {

        this.arriveCity = arriveCity;
    }

    public String getProduct() {

        return this.product;
    }

    public void setProduct(String product) {

        this.product = product;
    }

    public Date getPickdate() {

        return this.pickdate;
    }

    public void setPickdate(Date pickdate) {

        this.pickdate = pickdate;
    }

    public Integer getNum() {

        return this.num;
    }

    public void setNum(Integer num) {

        this.num = num;
    }

    public Double getWeight() {

        return this.weight;
    }

    public void setWeight(Double weight) {

        this.weight = weight;
    }

    public String getVolume() {

        return this.volume;
    }

    public void setVolume(String volume) {

        this.volume = volume;
    }

    public String getRemark() {

        return this.remark;
    }

    public void setRemark(String remark) {

        this.remark = remark;
    }

    public String getOrderType() {

        return this.orderType;
    }

    public void setOrderType(String orderType) {

        this.orderType = orderType;
    }

    public Set getWorkBills() {

        return this.workBills;
    }

    public void setWorkbills(Set workBills) {

        this.workBills = workBills;
    }
}
