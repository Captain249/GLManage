package com.gl.mgr.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Lxy implements Serializable {
    private Integer id;

    private Date startdate;

    private String phonenum;

    private Integer numcount;

    private String name;

    private BigDecimal receivable;

    private BigDecimal received;

    private BigDecimal b2b;

    private String operator;

    private String salesroom;

    private String contract;

    private String invoice;

    private Date finishdate;

    private String principal;

    private String more;

    private String grouptype;

    private Integer status;

    private String gname;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum == null ? null : phonenum.trim();
    }

    public Integer getNumcount() {
        return numcount;
    }

    public void setNumcount(Integer numcount) {
        this.numcount = numcount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public BigDecimal getReceivable() {
        return receivable;
    }

    public void setReceivable(BigDecimal receivable) {
        this.receivable = receivable;
    }

    public BigDecimal getReceived() {
        return received;
    }

    public void setReceived(BigDecimal received) {
        this.received = received;
    }

    public BigDecimal getB2b() {
        return b2b;
    }

    public void setB2b(BigDecimal b2b) {
        this.b2b = b2b;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public String getSalesroom() {
        return salesroom;
    }

    public void setSalesroom(String salesroom) {
        this.salesroom = salesroom == null ? null : salesroom.trim();
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract == null ? null : contract.trim();
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice == null ? null : invoice.trim();
    }

    public Date getFinishdate() {
        return finishdate;
    }

    public void setFinishdate(Date finishdate) {
        this.finishdate = finishdate;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal == null ? null : principal.trim();
    }

    public String getMore() {
        return more;
    }

    public void setMore(String more) {
        this.more = more == null ? null : more.trim();
    }

    public String getGrouptype() {
        return grouptype;
    }

    public void setGrouptype(String grouptype) {
        this.grouptype = grouptype == null ? null : grouptype.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname == null ? null : gname.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Lxy other = (Lxy) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getStartdate() == null ? other.getStartdate() == null : this.getStartdate().equals(other.getStartdate()))
            && (this.getPhonenum() == null ? other.getPhonenum() == null : this.getPhonenum().equals(other.getPhonenum()))
            && (this.getNumcount() == null ? other.getNumcount() == null : this.getNumcount().equals(other.getNumcount()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getReceivable() == null ? other.getReceivable() == null : this.getReceivable().equals(other.getReceivable()))
            && (this.getReceived() == null ? other.getReceived() == null : this.getReceived().equals(other.getReceived()))
            && (this.getB2b() == null ? other.getB2b() == null : this.getB2b().equals(other.getB2b()))
            && (this.getOperator() == null ? other.getOperator() == null : this.getOperator().equals(other.getOperator()))
            && (this.getSalesroom() == null ? other.getSalesroom() == null : this.getSalesroom().equals(other.getSalesroom()))
            && (this.getContract() == null ? other.getContract() == null : this.getContract().equals(other.getContract()))
            && (this.getInvoice() == null ? other.getInvoice() == null : this.getInvoice().equals(other.getInvoice()))
            && (this.getFinishdate() == null ? other.getFinishdate() == null : this.getFinishdate().equals(other.getFinishdate()))
            && (this.getPrincipal() == null ? other.getPrincipal() == null : this.getPrincipal().equals(other.getPrincipal()))
            && (this.getMore() == null ? other.getMore() == null : this.getMore().equals(other.getMore()))
            && (this.getGrouptype() == null ? other.getGrouptype() == null : this.getGrouptype().equals(other.getGrouptype()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getGname() == null ? other.getGname() == null : this.getGname().equals(other.getGname()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getStartdate() == null) ? 0 : getStartdate().hashCode());
        result = prime * result + ((getPhonenum() == null) ? 0 : getPhonenum().hashCode());
        result = prime * result + ((getNumcount() == null) ? 0 : getNumcount().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getReceivable() == null) ? 0 : getReceivable().hashCode());
        result = prime * result + ((getReceived() == null) ? 0 : getReceived().hashCode());
        result = prime * result + ((getB2b() == null) ? 0 : getB2b().hashCode());
        result = prime * result + ((getOperator() == null) ? 0 : getOperator().hashCode());
        result = prime * result + ((getSalesroom() == null) ? 0 : getSalesroom().hashCode());
        result = prime * result + ((getContract() == null) ? 0 : getContract().hashCode());
        result = prime * result + ((getInvoice() == null) ? 0 : getInvoice().hashCode());
        result = prime * result + ((getFinishdate() == null) ? 0 : getFinishdate().hashCode());
        result = prime * result + ((getPrincipal() == null) ? 0 : getPrincipal().hashCode());
        result = prime * result + ((getMore() == null) ? 0 : getMore().hashCode());
        result = prime * result + ((getGrouptype() == null) ? 0 : getGrouptype().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getGname() == null) ? 0 : getGname().hashCode());
        return result;
    }
}