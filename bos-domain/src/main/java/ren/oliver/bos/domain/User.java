package ren.oliver.bos.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class User implements Serializable {

	private String id;
	private String username;
	private String password;
	private Double salary;
	private Date birthday;
	private String gender;
	private String station;
	private String telephone;
	private String remark;
	private Set<NoticeBill> noticeBills = new HashSet(0);
	private Set<Role> roles = new HashSet(0);

	public User() {

	}

	public User(String id) {

		this.id = id;
	}

	public User(String id, String username, String password, Double salary,
				Date birthday, String gender, String station, String telephone,
				String remark, Set noticeBills, Set roles) {

		this.id = id;
		this.username = username;
		this.password = password;
		this.salary = salary;
		this.birthday = birthday;
		this.gender = gender;
		this.station = station;
		this.telephone = telephone;
		this.remark = remark;
		this.noticeBills = noticeBills;
		this.roles = roles;
	}

	public String getId() {

		return this.id;
	}

	public void setId(String id) {

		this.id = id;
	}

	public String getUsername() {

		return this.username;
	}

	public void setUsername(String username) {

		this.username = username;
	}

	public String getPassword() {

		return this.password;
	}

	public void setPassword(String password) {

		this.password = password;
	}

	public Double getSalary() {

		return this.salary;
	}

	public void setSalary(Double salary) {

		this.salary = salary;
	}

	public Date getBirthday() {

		return this.birthday;
	}

	public void setBirthday(Date birthday) {

		this.birthday = birthday;
	}

	public String getGender() {

		return this.gender;
	}

	public void setGender(String gender) {

		this.gender = gender;
	}

	public String getStation() {

		return this.station;
	}

	public void setStation(String station) {

		this.station = station;
	}

	public String getTelephone() {

		return this.telephone;
	}

	public void setTelephone(String telephone) {

		this.telephone = telephone;
	}

	public String getRemark() {

		return this.remark;
	}

	public void setRemark(String remark) {

		this.remark = remark;
	}

	public Set getNoticeBills() {

		return this.noticeBills;
	}

	public void setNoticeBills(Set noticeBills) {

		this.noticeBills = noticeBills;
	}

	public Set getRoles() {

		return this.roles;
	}

	public void setRoles(Set roles) {

		this.roles = roles;
	}

	public String getRoleNames(){

		String roleNames = "";
		for(Role role : roles){
			String name = role.getName();
			roleNames += name + " ";
		}
		return roleNames;
	}

	public String getBirthdayString(){

		if (birthday != null) {
			String format = new SimpleDateFormat("yyyy-MM-dd").format(birthday);
			return format;
		} else {
			return "暂无数据";
		}
	}
}