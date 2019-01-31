package com.alphaomega.demo.domain;

import java.util.Date;

public class User{
	private Integer userid;

    private String username;

    private String password;

    private String phoneno;

    private Integer isvalid;

    private Date updatetime;

    private Integer operator;

    private Integer permissionid;

    private Date createtime;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno == null ? null : phoneno.trim();
    }

    public Integer getIsvalid() {
        return isvalid;
    }

    public void setIsvalid(Integer isvalid) {
        this.isvalid = isvalid;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Integer getOperator() {
        return operator;
    }

    public void setOperator(Integer operator) {
        this.operator = operator;
    }

    public Integer getPermissionid() {
        return permissionid;
    }

    public void setPermissionid(Integer permissionid) {
        this.permissionid = permissionid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}


//==========以下是使用JPA的Entity===========
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Column;
//import javax.persistence.GeneratedValue;
//import java.io.Serializable;
//
//@Entity
//public class User implements Serializable {
//
//    private static final long serialVersionUID = 1L;
//    @Id
//    @GeneratedValue
//    private Integer userid;
//    
//    @Column(nullable = false, unique = true)
//    private String userName;
//    
//    @Column(nullable = false)
//    private String password;
//    
//    private String phoneNo;
//    
//    @Column(nullable = false, unique = true)
//    private String email;
//    
//    @Column(nullable = true, unique = true)
//    private String nickName;
//    
//    @Column(nullable = false)
//    private String regTime;
//    
//    private Integer permissionid;
//
//    public Integer getUserid() {
//        return userid;
//    }
//    
//    public String getUserName() {
//    	return userName;
//    }
//    
//    public String getNickName() {
//    	return nickName;
//    }
//    
//    public String getPassword() {
//        return password;
//    }
//    
//    public Integer getPermissionid() {
//        return permissionid;
//    }
//    
//    public String getPhoneno() {
//        return phoneNo;
//    }
//
//    public void setPhoneno(String phoneno) {
//        this.phoneNo = phoneno == null ? null : phoneno.trim();
//    }
//    
//    public User() {
//    	
//    }
//    
//    public User(String uName, String pwd, String e,String nName,String rTime)
//    {
//    	this.userName = uName;
//    	this.password = pwd;
//    	this.email = e;
//    	this.nickName = nName;
//    	this.regTime =rTime;
//    }
//}
