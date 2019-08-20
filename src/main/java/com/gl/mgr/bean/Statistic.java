package com.gl.mgr.bean;

import java.math.BigDecimal;

public class Statistic {
    private BigDecimal ys;
    private BigDecimal ss;
    private BigDecimal b2bs;
    private String time;
    private int num;

    public BigDecimal getYs() {
        return ys;
    }

    public void setYs(BigDecimal ys) {
        this.ys = ys;
    }

    public BigDecimal getSs() {
        return ss;
    }

    public void setSs(BigDecimal ss) {
        this.ss = ss;
    }

    public BigDecimal getB2bs() {
        return b2bs;
    }

    public void setB2bs(BigDecimal b2bs) {
        this.b2bs = b2bs;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
