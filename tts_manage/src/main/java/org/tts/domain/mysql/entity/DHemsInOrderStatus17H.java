package org.tts.domain.mysql.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 拉取Hems订单状态信息表(DHemsInOrderStatus17H)实体类
 *
 * @author Tianjx
 * @since 2023-03-01 11:18:16
 */
public class DHemsInOrderStatus17H implements Serializable {
    private static final long serialVersionUID = -95990238528012615L;
    
    private Long id;
    /**
    * 内部订单号
    */
    private String orderId;
    /**
    * 订单号
    */
    private String olorderno;
    /**
    * hems线下状态
    */
    private Integer stautsOflineHems;
    /**
    * doms对应的线下状态
    */
    private String statusOflineDoms;
    /**
    * 时间轴项目号
    */
    private Long timershaftid;
    /**
    * sap合单号
    */
    private String sapno;
    
    private String sappickno;
    /**
    * 末次同步时间
    */
    private Date lastTimestamp;
    /**
    * 状态(0-待处理 1-已处理)
    */
    private Integer status;
    
    private Integer orderV;
    
    private String additional1;
    
    private String additional2;
    
    private String additional3;
    
    private String additional4;
    
    private String additional5;
    
    private Date timeStamp;
    
    private Date createTime;
    
    private Date updateTime;
    
    private String ext1;
    
    private String ext2;
    
    private String ext3;
    
    private String ext4;
    
    private String ext5;

        
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
        
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
        
    public String getOlorderno() {
        return olorderno;
    }

    public void setOlorderno(String olorderno) {
        this.olorderno = olorderno;
    }
        
    public Integer getStautsOflineHems() {
        return stautsOflineHems;
    }

    public void setStautsOflineHems(Integer stautsOflineHems) {
        this.stautsOflineHems = stautsOflineHems;
    }
        
    public String getStatusOflineDoms() {
        return statusOflineDoms;
    }

    public void setStatusOflineDoms(String statusOflineDoms) {
        this.statusOflineDoms = statusOflineDoms;
    }
        
    public Long getTimershaftid() {
        return timershaftid;
    }

    public void setTimershaftid(Long timershaftid) {
        this.timershaftid = timershaftid;
    }
        
    public String getSapno() {
        return sapno;
    }

    public void setSapno(String sapno) {
        this.sapno = sapno;
    }
        
    public String getSappickno() {
        return sappickno;
    }

    public void setSappickno(String sappickno) {
        this.sappickno = sappickno;
    }
        
    public Date getLastTimestamp() {
        return lastTimestamp;
    }

    public void setLastTimestamp(Date lastTimestamp) {
        this.lastTimestamp = lastTimestamp;
    }
        
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
        
    public Integer getOrderV() {
        return orderV;
    }

    public void setOrderV(Integer orderV) {
        this.orderV = orderV;
    }
        
    public String getAdditional1() {
        return additional1;
    }

    public void setAdditional1(String additional1) {
        this.additional1 = additional1;
    }
        
    public String getAdditional2() {
        return additional2;
    }

    public void setAdditional2(String additional2) {
        this.additional2 = additional2;
    }
        
    public String getAdditional3() {
        return additional3;
    }

    public void setAdditional3(String additional3) {
        this.additional3 = additional3;
    }
        
    public String getAdditional4() {
        return additional4;
    }

    public void setAdditional4(String additional4) {
        this.additional4 = additional4;
    }
        
    public String getAdditional5() {
        return additional5;
    }

    public void setAdditional5(String additional5) {
        this.additional5 = additional5;
    }
        
    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
        
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
        
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
        
    public String getExt1() {
        return ext1;
    }

    public void setExt1(String ext1) {
        this.ext1 = ext1;
    }
        
    public String getExt2() {
        return ext2;
    }

    public void setExt2(String ext2) {
        this.ext2 = ext2;
    }
        
    public String getExt3() {
        return ext3;
    }

    public void setExt3(String ext3) {
        this.ext3 = ext3;
    }
        
    public String getExt4() {
        return ext4;
    }

    public void setExt4(String ext4) {
        this.ext4 = ext4;
    }
        
    public String getExt5() {
        return ext5;
    }

    public void setExt5(String ext5) {
        this.ext5 = ext5;
    }

}