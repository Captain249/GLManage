package com.gl.common.lxy.bean;


public class Lxy {
    private int id;
    private String grouptype;
    private String name;
    private int countmem;
    private String principal;
    private String phonenum;
    private String memberlist;
    private String price;
    private String profit;
    private String date;
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGrouptype() {
        return grouptype;
    }

    public void setGrouptype(String grouptype) {
        this.grouptype = grouptype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return countmem;
    }

    public void setCount(int count) {
        this.countmem = count;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public int getCountmem() {
        return countmem;
    }

    public void setCountmem(int countmem) {
        this.countmem = countmem;
    }

    public String getMemberlist() {
        return memberlist;
    }

    public void setMemberlist(String memberlist) {
        this.memberlist = memberlist;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getProfit() {
        return profit;
    }

    public void setProfit(String profit) {
        this.profit = profit;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Lxy() {
    }

    public Lxy(int id, String grouptype, String name, int countmem, String principal, String phonenum, String memberlist, String price, String profit, String date, String status) {
        this.id = id;
        this.grouptype = grouptype;
        this.name = name;
        this.countmem = countmem;
        this.principal = principal;
        this.phonenum = phonenum;
        this.memberlist = memberlist;
        this.price = price;
        this.profit = profit;
        this.date = date;
        this.status = status;
    }
}
