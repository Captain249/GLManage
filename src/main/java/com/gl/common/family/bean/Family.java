package com.gl.common.family.bean;

import java.util.List;

public class Family {
    private int id;
    private int fid;
    private int mid;
    private List<Integer> cid;
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public List<Integer> getCid() {
        return cid;
    }

    public void setCid(List<Integer> cid) {
        this.cid = cid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Family() {
    }

    public Family(int id, int fid, int mid, List<Integer> cid, String address) {
        this.id = id;
        this.fid = fid;
        this.mid = mid;
        this.cid = cid;
        this.address = address;
    }
}
