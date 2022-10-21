package org.tts.domain.mysql.entity;

import lombok.Builder;

import java.util.Date;
import java.io.Serializable;

/**
 * 天猫订单主表(DPlTmOrderH)实体类
 *
 * @author Tianjx
 * @since 2022-10-12 14:45:55
 */
@Builder
public class DPlTmOrderH implements Serializable {
    private static final long serialVersionUID = -88828104234267644L;
    /**
    * 天猫订单主表id
    */
    private Long id;
    /**
    * 交易编号 (父订单的交易编号)
    */
    private Long tid;
    /**
    * 交易状态
    */
    private String status;
    /**
    * 网店编码
    */
    private String olshopid;
    /**
    * 交易类型列表
    */
    private String type;
    /**
    * 卖家昵称
    */
    private String sellerNick;
    /**
    * 买家昵称
    */
    private String buyerNick;
    /**
    * 交易创建时间
    */
    private Date created;
    /**
    * (收货人+手机号+收货地址+create）4字段返回值都都不能为空，否则生成不了oaid
    */
    private String oaid;
    /**
    * 交易修改时间
    */
    private Date modified;
    /**
    * 卖家手工调整金额
    */
    private String adjustFee;
    
    private String alipayNo;
    /**
    * 买家是否已评价
    */
    private String buyerRate;
    /**
    * 使用信用卡支付金额数
    */
    private String creditCardFee;
    /**
    * 卖家发货时间
    */
    private Date consignTime;
    /**
    * 查询系统优惠系统优惠金额
    */
    private String discountFee;
    /**
    * 交易结束时间
    */
    private Date endTime;
    /**
    * 订单中是否包含运费险订单
    */
    private String hasYfx;
    /**
    * 实付金额
    */
    private String payment;
    /**
    * 邮费
    */
    private String postFee;
    /**
    * 卖家实际收到的支付宝打款金额
    */
    private String receivedPayment;
    /**
    * 收货人的详细地址
    */
    private String receiverAddress;
    /**
    * 收货人国籍
    */
    private String receiverCountry;
    /**
    * 收货人的所在省份
    */
    private String receiverState;
    /**
    * 收货人的所在城市
    */
    private String receiverCity;
    /**
    * 收货人的所在地区
    */
    private String receiverDistrict;
    /**
    * 收货人街道地址
    */
    private String receiverTown;
    /**
    * 收货人的手机号码
    */
    private String receiverMobile;
    /**
    * 收货人的姓名
    */
    private String receiverName;
    /**
    * 收货人的电话号码
    */
    private String receiverPhone;
    /**
    * 收货人的邮编
    */
    private String receiverZip;
    /**
    * 卖家是否已评价
    */
    private String sellerRate;
    /**
    * 创建交易时的物流方式
    */
    private String shippingType;
    /**
    * 交易标题
    */
    private String title;
    /**
    * 商品金额
    */
    private String totalFee;
    /**
    * 交易内部来源
    */
    private String tradeFrom;
    /**
    * 卖家备注旗帜
    */
    private Integer sellerFlag;
    
    private Long alipayPoint;
    
    private Double availableConfirmFee;
    
    private String buyerAlipayNo;
    
    private String buyerArea;
    /**
    * 买家货到付款服务费。精确到2位小数;单位:元
    */
    private Double buyerCodFee;
    
    private String buyerEmail;
    /**
    * 买家留言
    */
    private String buyerMessage;
    
    private Long buyerObtainPointFee;
    
    private String codFee;
    
    private String codStatus;
    /**
    * 订单中使用红包付款的金额
    */
    private Double couponFee;
    
    private Double commissionFee;
    /**
    * 是否包含邮费
    */
    private String hasPostFee;
    
    private String is3d;
    
    private String isBrandSale;
    
    private String isDaixiao;
    
    private String isForceWlb;
    /**
    * 是否屏蔽发货
    */
    private String isShShip;
    
    private String isLgtype;
    
    private String isPartConsign;
    
    private String isWt;
    
    private Long pccAf;
    
    private Double pointFee;
    
    private Double realPointFee;
    
    private String sellerAlipayNo;
    
    private String sellerCanRate;
    
    private String sellerCodFee;
    
    private String sellerEmail;
    
    private String sellerMemo;
    
    private String sellerMobile;
    
    private String sellerName;
    
    private String sellerPhone;
    /**
    * 物流标签
    */
    private Object serviceTags;
    
    private String sid;
    /**
    * 付款时间
    */
    private Date payTime;
    /**
    * 买家备注
    */
    private String buyerMemo;
    
    private String snapshotUrl;
    
    private String tradeSource;
    /**
    * 处方药未审核状态
    */
    private String rxAuditStatus;
    /**
    * 标识完美履约订单
    */
    private String isWmly;
    /**
    * 是否疫情登记的订单。0=未登记，1=已登记
    */
    private String drugRegister;
    /**
    * 全渠道包裹信息
    */
    private String omniPackage;
    /**
    * 星盘业务字段
    */
    private String omniParam;
    /**
    * 全渠道商品通相关字段
    */
    private String omnichannelParam;
    /**
    * 星盘标识字段
    */
    private String omniAttr;
    /**
    * top定义订单类型
    */
    private Integer toptype;
    
    private Integer mergeStatus;
    
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
        
    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }
        
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
        
    public String getOlshopid() {
        return olshopid;
    }

    public void setOlshopid(String olshopid) {
        this.olshopid = olshopid;
    }
        
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
        
    public String getSellerNick() {
        return sellerNick;
    }

    public void setSellerNick(String sellerNick) {
        this.sellerNick = sellerNick;
    }
        
    public String getBuyerNick() {
        return buyerNick;
    }

    public void setBuyerNick(String buyerNick) {
        this.buyerNick = buyerNick;
    }
        
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
        
    public String getOaid() {
        return oaid;
    }

    public void setOaid(String oaid) {
        this.oaid = oaid;
    }
        
    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }
        
    public String getAdjustFee() {
        return adjustFee;
    }

    public void setAdjustFee(String adjustFee) {
        this.adjustFee = adjustFee;
    }
        
    public String getAlipayNo() {
        return alipayNo;
    }

    public void setAlipayNo(String alipayNo) {
        this.alipayNo = alipayNo;
    }
        
    public String getBuyerRate() {
        return buyerRate;
    }

    public void setBuyerRate(String buyerRate) {
        this.buyerRate = buyerRate;
    }
        
    public String getCreditCardFee() {
        return creditCardFee;
    }

    public void setCreditCardFee(String creditCardFee) {
        this.creditCardFee = creditCardFee;
    }
        
    public Date getConsignTime() {
        return consignTime;
    }

    public void setConsignTime(Date consignTime) {
        this.consignTime = consignTime;
    }
        
    public String getDiscountFee() {
        return discountFee;
    }

    public void setDiscountFee(String discountFee) {
        this.discountFee = discountFee;
    }
        
    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
        
    public String getHasYfx() {
        return hasYfx;
    }

    public void setHasYfx(String hasYfx) {
        this.hasYfx = hasYfx;
    }
        
    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }
        
    public String getPostFee() {
        return postFee;
    }

    public void setPostFee(String postFee) {
        this.postFee = postFee;
    }
        
    public String getReceivedPayment() {
        return receivedPayment;
    }

    public void setReceivedPayment(String receivedPayment) {
        this.receivedPayment = receivedPayment;
    }
        
    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }
        
    public String getReceiverCountry() {
        return receiverCountry;
    }

    public void setReceiverCountry(String receiverCountry) {
        this.receiverCountry = receiverCountry;
    }
        
    public String getReceiverState() {
        return receiverState;
    }

    public void setReceiverState(String receiverState) {
        this.receiverState = receiverState;
    }
        
    public String getReceiverCity() {
        return receiverCity;
    }

    public void setReceiverCity(String receiverCity) {
        this.receiverCity = receiverCity;
    }
        
    public String getReceiverDistrict() {
        return receiverDistrict;
    }

    public void setReceiverDistrict(String receiverDistrict) {
        this.receiverDistrict = receiverDistrict;
    }
        
    public String getReceiverTown() {
        return receiverTown;
    }

    public void setReceiverTown(String receiverTown) {
        this.receiverTown = receiverTown;
    }
        
    public String getReceiverMobile() {
        return receiverMobile;
    }

    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile;
    }
        
    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }
        
    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }
        
    public String getReceiverZip() {
        return receiverZip;
    }

    public void setReceiverZip(String receiverZip) {
        this.receiverZip = receiverZip;
    }
        
    public String getSellerRate() {
        return sellerRate;
    }

    public void setSellerRate(String sellerRate) {
        this.sellerRate = sellerRate;
    }
        
    public String getShippingType() {
        return shippingType;
    }

    public void setShippingType(String shippingType) {
        this.shippingType = shippingType;
    }
        
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
        
    public String getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(String totalFee) {
        this.totalFee = totalFee;
    }
        
    public String getTradeFrom() {
        return tradeFrom;
    }

    public void setTradeFrom(String tradeFrom) {
        this.tradeFrom = tradeFrom;
    }
        
    public Integer getSellerFlag() {
        return sellerFlag;
    }

    public void setSellerFlag(Integer sellerFlag) {
        this.sellerFlag = sellerFlag;
    }
        
    public Long getAlipayPoint() {
        return alipayPoint;
    }

    public void setAlipayPoint(Long alipayPoint) {
        this.alipayPoint = alipayPoint;
    }
        
    public Double getAvailableConfirmFee() {
        return availableConfirmFee;
    }

    public void setAvailableConfirmFee(Double availableConfirmFee) {
        this.availableConfirmFee = availableConfirmFee;
    }
        
    public String getBuyerAlipayNo() {
        return buyerAlipayNo;
    }

    public void setBuyerAlipayNo(String buyerAlipayNo) {
        this.buyerAlipayNo = buyerAlipayNo;
    }
        
    public String getBuyerArea() {
        return buyerArea;
    }

    public void setBuyerArea(String buyerArea) {
        this.buyerArea = buyerArea;
    }
        
    public Double getBuyerCodFee() {
        return buyerCodFee;
    }

    public void setBuyerCodFee(Double buyerCodFee) {
        this.buyerCodFee = buyerCodFee;
    }
        
    public String getBuyerEmail() {
        return buyerEmail;
    }

    public void setBuyerEmail(String buyerEmail) {
        this.buyerEmail = buyerEmail;
    }
        
    public String getBuyerMessage() {
        return buyerMessage;
    }

    public void setBuyerMessage(String buyerMessage) {
        this.buyerMessage = buyerMessage;
    }
        
    public Long getBuyerObtainPointFee() {
        return buyerObtainPointFee;
    }

    public void setBuyerObtainPointFee(Long buyerObtainPointFee) {
        this.buyerObtainPointFee = buyerObtainPointFee;
    }
        
    public String getCodFee() {
        return codFee;
    }

    public void setCodFee(String codFee) {
        this.codFee = codFee;
    }
        
    public String getCodStatus() {
        return codStatus;
    }

    public void setCodStatus(String codStatus) {
        this.codStatus = codStatus;
    }
        
    public Double getCouponFee() {
        return couponFee;
    }

    public void setCouponFee(Double couponFee) {
        this.couponFee = couponFee;
    }
        
    public Double getCommissionFee() {
        return commissionFee;
    }

    public void setCommissionFee(Double commissionFee) {
        this.commissionFee = commissionFee;
    }
        
    public String getHasPostFee() {
        return hasPostFee;
    }

    public void setHasPostFee(String hasPostFee) {
        this.hasPostFee = hasPostFee;
    }
        
    public String getIs3d() {
        return is3d;
    }

    public void setIs3d(String is3d) {
        this.is3d = is3d;
    }
        
    public String getIsBrandSale() {
        return isBrandSale;
    }

    public void setIsBrandSale(String isBrandSale) {
        this.isBrandSale = isBrandSale;
    }
        
    public String getIsDaixiao() {
        return isDaixiao;
    }

    public void setIsDaixiao(String isDaixiao) {
        this.isDaixiao = isDaixiao;
    }
        
    public String getIsForceWlb() {
        return isForceWlb;
    }

    public void setIsForceWlb(String isForceWlb) {
        this.isForceWlb = isForceWlb;
    }
        
    public String getIsShShip() {
        return isShShip;
    }

    public void setIsShShip(String isShShip) {
        this.isShShip = isShShip;
    }
        
    public String getIsLgtype() {
        return isLgtype;
    }

    public void setIsLgtype(String isLgtype) {
        this.isLgtype = isLgtype;
    }
        
    public String getIsPartConsign() {
        return isPartConsign;
    }

    public void setIsPartConsign(String isPartConsign) {
        this.isPartConsign = isPartConsign;
    }
        
    public String getIsWt() {
        return isWt;
    }

    public void setIsWt(String isWt) {
        this.isWt = isWt;
    }
        
    public Long getPccAf() {
        return pccAf;
    }

    public void setPccAf(Long pccAf) {
        this.pccAf = pccAf;
    }
        
    public Double getPointFee() {
        return pointFee;
    }

    public void setPointFee(Double pointFee) {
        this.pointFee = pointFee;
    }
        
    public Double getRealPointFee() {
        return realPointFee;
    }

    public void setRealPointFee(Double realPointFee) {
        this.realPointFee = realPointFee;
    }
        
    public String getSellerAlipayNo() {
        return sellerAlipayNo;
    }

    public void setSellerAlipayNo(String sellerAlipayNo) {
        this.sellerAlipayNo = sellerAlipayNo;
    }
        
    public String getSellerCanRate() {
        return sellerCanRate;
    }

    public void setSellerCanRate(String sellerCanRate) {
        this.sellerCanRate = sellerCanRate;
    }
        
    public String getSellerCodFee() {
        return sellerCodFee;
    }

    public void setSellerCodFee(String sellerCodFee) {
        this.sellerCodFee = sellerCodFee;
    }
        
    public String getSellerEmail() {
        return sellerEmail;
    }

    public void setSellerEmail(String sellerEmail) {
        this.sellerEmail = sellerEmail;
    }
        
    public String getSellerMemo() {
        return sellerMemo;
    }

    public void setSellerMemo(String sellerMemo) {
        this.sellerMemo = sellerMemo;
    }
        
    public String getSellerMobile() {
        return sellerMobile;
    }

    public void setSellerMobile(String sellerMobile) {
        this.sellerMobile = sellerMobile;
    }
        
    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }
        
    public String getSellerPhone() {
        return sellerPhone;
    }

    public void setSellerPhone(String sellerPhone) {
        this.sellerPhone = sellerPhone;
    }
        
    public Object getServiceTags() {
        return serviceTags;
    }

    public void setServiceTags(Object serviceTags) {
        this.serviceTags = serviceTags;
    }
        
    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }
        
    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }
        
    public String getBuyerMemo() {
        return buyerMemo;
    }

    public void setBuyerMemo(String buyerMemo) {
        this.buyerMemo = buyerMemo;
    }
        
    public String getSnapshotUrl() {
        return snapshotUrl;
    }

    public void setSnapshotUrl(String snapshotUrl) {
        this.snapshotUrl = snapshotUrl;
    }
        
    public String getTradeSource() {
        return tradeSource;
    }

    public void setTradeSource(String tradeSource) {
        this.tradeSource = tradeSource;
    }
        
    public String getRxAuditStatus() {
        return rxAuditStatus;
    }

    public void setRxAuditStatus(String rxAuditStatus) {
        this.rxAuditStatus = rxAuditStatus;
    }
        
    public String getIsWmly() {
        return isWmly;
    }

    public void setIsWmly(String isWmly) {
        this.isWmly = isWmly;
    }
        
    public String getDrugRegister() {
        return drugRegister;
    }

    public void setDrugRegister(String drugRegister) {
        this.drugRegister = drugRegister;
    }
        
    public String getOmniPackage() {
        return omniPackage;
    }

    public void setOmniPackage(String omniPackage) {
        this.omniPackage = omniPackage;
    }
        
    public String getOmniParam() {
        return omniParam;
    }

    public void setOmniParam(String omniParam) {
        this.omniParam = omniParam;
    }
        
    public String getOmnichannelParam() {
        return omnichannelParam;
    }

    public void setOmnichannelParam(String omnichannelParam) {
        this.omnichannelParam = omnichannelParam;
    }
        
    public String getOmniAttr() {
        return omniAttr;
    }

    public void setOmniAttr(String omniAttr) {
        this.omniAttr = omniAttr;
    }
        
    public Integer getToptype() {
        return toptype;
    }

    public void setToptype(Integer toptype) {
        this.toptype = toptype;
    }
        
    public Integer getMergeStatus() {
        return mergeStatus;
    }

    public void setMergeStatus(Integer mergeStatus) {
        this.mergeStatus = mergeStatus;
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