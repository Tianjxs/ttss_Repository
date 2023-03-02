package org.tts.domain.mysql.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (DPlRabbitMessage)实体类
 *
 * @author Tianjx
 * @since 2023-03-01 13:36:40
 */
public class DPlRabbitMessage implements Serializable {
    private static final long serialVersionUID = -53336828309916762L;
    
    private Long id;
    
    private String orderId;
    /**
    * 1: 生产方，2：消费方
    */
    private Integer type;
    /**
    * 生产方【0:初始化,1:消息成功发送到交换机,2:消息失败发送到交换机,3:消息失败发送到队列】 消费方【1:消息成功消费,2:消息失败消费】
     * 4:代表重试超过最大次数,不再进行发送消息了，需手工处理
    */
    private Integer status;
    
    private String exchangename;
    
    private String routingkey;
    
    private String queuename;
    
    private Integer maxtrycount;
    
    private Integer currentretrycount;
    
    private Long retryintervaltime;
    
    private String message;
    
    private Date createTime;
    
    private Date updateTime;
    
    private String ext1;
    
    private String ext2;
    
    private String ext3;

        
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
        
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
        
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
        
    public String getExchangename() {
        return exchangename;
    }

    public void setExchangename(String exchangename) {
        this.exchangename = exchangename;
    }
        
    public String getRoutingkey() {
        return routingkey;
    }

    public void setRoutingkey(String routingkey) {
        this.routingkey = routingkey;
    }
        
    public String getQueuename() {
        return queuename;
    }

    public void setQueuename(String queuename) {
        this.queuename = queuename;
    }
        
    public Integer getMaxtrycount() {
        return maxtrycount;
    }

    public void setMaxtrycount(Integer maxtrycount) {
        this.maxtrycount = maxtrycount;
    }
        
    public Integer getCurrentretrycount() {
        return currentretrycount;
    }

    public void setCurrentretrycount(Integer currentretrycount) {
        this.currentretrycount = currentretrycount;
    }
        
    public Long getRetryintervaltime() {
        return retryintervaltime;
    }

    public void setRetryintervaltime(Long retryintervaltime) {
        this.retryintervaltime = retryintervaltime;
    }
        
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

}