package com.gl.common.member.bean;

public class Member {
    private int id;
    private String mname;
    private String phonenum;
    private String address;
    private String idcard;
    private String passport;
    private int family;
    private String company;
    private String more;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public int getFamily() {
        return family;
    }

    public void setFamily(int family) {
        this.family = family;
    }

    public String getMore() {
        return more;
    }

    public void setMore(String more) {
        this.more = more;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Member() {
    }

    public Member(int id, String mname, String phonenum, String address, String idcard, String passport, int family, String company, String more) {
        this.id = id;
        this.mname = mname;
        this.phonenum = phonenum;
        this.address = address;
        this.idcard = idcard;
        this.passport = passport;
        this.family = family;
        this.company = company;
        this.more = more;
    }
}
