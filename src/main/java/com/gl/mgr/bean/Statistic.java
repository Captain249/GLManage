package com.gl.mgr.bean;

import java.math.BigDecimal;

public class Statistic {
    private BigDecimal ss;
    private String time;
    private int num;

    public BigDecimal getSs() {
        return ss;
    }

    public void setSs(BigDecimal ss) {
        this.ss = ss;
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
