package org.tts.domain.mysql.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 天猫订单明细订单列表(DPlTmOrderOrdersD)实体类
 *
 * @author Tianjx
 * @since 2023-03-17 15:13:51
 */
public class DPlTmOrderOrdersD implements Serializable {
    private static final long serialVersionUID = -11998408944494488L;
    /**
    * 天猫订单明细订单列表id
    */
    private Long id;
    /**
    * 交易编号 (父订单的交易编号)
    */
    private Long tid;
    /**
    * 网店编码
    */
    private String olshopid;
    /**
    * 虚拟服务子订单订单号
    */
    private String oid;
    /**
    * 手工调整金额
    */
    private String adjustFee;
    /**
    * 买家是否已评价
    */
    private String buyerRate;
    /**
    * 交易商品对应的类目ID
    */
    private Integer cid;
    /**
    * 订单状态
    */
    private String status;
    /**
    * 退款状态
    */
    private String refundStatus;
    /**
    * 子订单发货时间
    */
    private String consignTime;
    /**
    * 子订单级订单优惠金额
    */
    private String discountFee;
    /**
    * 分摊之后的实付金额
    */
    private String divideOrderFee;
    /**
    * 子订单的交易结束时间说明
    */
    private Date endTime;
    /**
    * 子订单所在包裹的运单号
    */
    private String invoiceNo;
    /**
    * 表示订单交易是否含有对应的代销采购单
    */
    private String isDaixiao;
    /**
    * 是否超卖
    */
    private String isOversold;
    /**
    * 子订单发货的快递公司名称
    */
    private String logisticsCompany;
    /**
    * 购买数量
    */
    private Integer num;
    /**
    * 商品数字ID
    */
    private Long numIid;
    /**
    * 子订单来源
    */
    private String orderFrom;
    /**
    * 商家外部编码
    */
    private String outerIid;
    /**
    * 子订单实付金额
    */
    private String payment;
    /**
    * 商品图片的绝对路径
    */
    private String picPath;
    /**
    * 商品价格
    */
    private String price;
    /**
    * 卖家是否已评价
    */
    private String sellerRate;
    /**
    * 卖家类型
    */
    private String sellerType;
    /**
    * 子订单的运送方式
    */
    private String shippingType;
    /**
    * 商品的最小库存单位Sku的id
    */
    private String skuId;
    /**
    * SKU的值
    */
    private String skuPropertiesName;
    /**
    * 订单快照URL
    */
    private String snapshotUrl;
    /**
    * 发货的仓库编码
    */
    private String storeCode;
    /**
    * 商品标题
    */
    private String title;
    /**
    * 应付金额
    */
    private String totalFee;
    /**
    * 套餐的值
    */
    private String itemMealName;
    /**
    * 卖家昵称
    */
    private String sellerNick;
    /**
    * 买家昵称
    */
    private String buyerNick;
    /**
    * 订单快照详细信息
    */
    private String snapshot;
    /**
    * 订单超时到期时间
    */
    private Date timeoutActionTime;
    /**
    * 天猫国际官网直供子订单关税税费
    */
    private String subOrderTaxFee;
    /**
    * 天猫国际官网直供子订单关税税率
    */
    private String subOrderTaxRate;
    /**
    * 子订单预计发货时间
    */
    private String estimateConTime;
    /**
    * 导购员ID
    */
    private String o2oGuideId;
    /**
    * 导购员名称
    */
    private String o2oGuideName;
    /**
    * 门店Id
    */
    private String o2oShopId;
    /**
    * 门店名称
    */
    private String o2oShopName;
    /**
    * 导购宝云店链路
    */
    private String bizCode;
    /**
    * 导购宝旗舰店
    */
    private String cloudStore;
    /**
    * 云店是否扣拥
    */
    private String hjSettleNoCommission;
    /**
    * 云店接单标记
    */
    private String orderTaking;
    /**
    * 云店改价用token
    */
    private String cloudStoreToken;
    /**
    * 云店pos单号
    */
    private String cloudStoreBindPos;
    /**
    * 前N有礼活动id
    */
    private String osActivityId;
    /**
    * 前N有礼赠品id
    */
    private String osFgItemId;
    /**
    * 前N有礼赠品数量
    */
    private String osGiftCount;
    /**
    * 前N有礼中奖名次
    */
    private String osSortNum;
    /**
    * 服务所属的交易订单号
    */
    private Integer itemOid;
    /**
    * 交易类型
    */
    private String type;
    /**
    * 商品的字符串编号
    */
    private String iid;
    /**
    * 服务数字id
    */
    private Integer serviceId;
    /**
    * 套餐ID
    */
    private Integer itemMealId;
    /**
    * 外部网店自己定义的Sku编号
    */
    private String outerSkuId;
    /**
    * 服务详情的URL地址
    */
    private String serviceDetailUrl;
    /**
    * 订单修改时间
    */
    private Date modified;
    /**
    * 最近退款ID
    */
    private String refundId;
    /**
    * 是否是服务订单
    */
    private String isServiceOrder;
    /**
    * 子订单扩展属性
    */
    private String orderAttr;
    /**
    * 捆绑的子订单号
    */
    private Integer bindOid;
    /**
    * 优惠分摊
    */
    private String partMjzDiscount;
    /**
    * 对应门票有效期的外部id
    */
    private String ticketOuterId;
    /**
    * 门票有效期的key
    */
    private String ticketExpdateKey;
    /**
    * 子订单是否是www订单
    */
    private String isWww;
    /**
    * 支持家装类物流的类型
    */
    private String tmserSpuCode;
    /**
    * bind_oid字段的升级
    */
    private String bindOids;
    /**
    * 征集预售订单征集状态
    */
    private String zhengjiStatus;
    /**
    * 免单资格属性
    */
    private String mdQualification;
    /**
    * 免单金额
    */
    private String mdFee;
    /**
    * 定制信息
    */
    private String customization;
    /**
    * 库存类型
    */
    private String invType;
    /**
    * xxx
    */
    private String xxx;
    /**
    * 是否发货
    */
    private String isShShip;
    /**
    * 仓储信息
    */
    private String shipper;
    /**
    * 订单履行类型
    */
    private String fType;
    /**
    * 订单履行状态
    */
    private String fStatus;
    /**
    * 单履行内容
    */
    private String fTerm;
    
    private String o2oEtOrderId;
    /**
    * 天猫搭配宝
    */
    private String comboId;
    /**
    * 主商品订单id
    */
    private String assemblyRela;
    /**
    * 价格
    */
    private String assemblyPrice;
    /**
    * assemblyItem
    */
    private String assemblyItem;
    /**
    * 天猫国际子订单计税优惠金额
    */
    private String subOrderTaxPromotionFee;
    /**
    * clDownPayment
    */
    private String clDownPayment;
    /**
    * clDownPaymentRatio
    */
    private String clDownPaymentRatio;
    /**
    * clMonthPayment
    */
    private String clMonthPayment;
    /**
    * clTailPayment
    */
    private String clTailPayment;
    /**
    * clInstallmentNum
    */
    private String clInstallmentNum;
    /**
    * calPenalty
    */
    private String calPenalty;
    /**
    * clServiceFee
    */
    private String clServiceFee;
    /**
    * clCarTaker
    */
    private String clCarTaker;
    /**
    * clCarTakerPhone
    */
    private String clCarTakerPhone;
    /**
    * clCarTakerIDNum
    */
    private String clCarTakerIDNum;
    /**
    * clCarTakerIDNum
    */
    private String clCarTakerIdNum;
    /**
    * downPayment
    */
    private String downPayment;
    /**
    * downPaymentRatio
    */
    private String downPaymentRatio;
    /**
    * monthPayment
    */
    private String monthPayment;
    /**
    * tailPayment
    */
    private String tailPayment;
    /**
    * installmentNum
    */
    private String installmentNum;
    /**
    * penalty
    */
    private String penalty;
    /**
    * serviceFee
    */
    private String serviceFee;
    /**
    * carTaker
    */
    private String carTaker;
    /**
    * carTakerPhone
    */
    private String carTakerPhone;
    /**
    * carTakerIDNum
    */
    private String carTakerIdNum;
    /**
    * carStoreCode
    */
    private String carStoreCode;
    /**
    * carStoreName
    */
    private String carStoreName;
    /**
    * outUniqueId
    */
    private String outUniqueId;
    /**
    * wsBankApplyNo
    */
    private String wsBankApplyNo;
    /**
    * carTakerID
    */
    private String carTakerId;
    /**
    * oidStr
    */
    private String oidStr;
    /**
    * 花呗分期期数
    */
    private Integer fqgNum;
    /**
    * 是否商家承担手续费
    */
    private String isFqgSFee;
    /**
    * 天猫国际订单是否包税
    */
    private String taxFree;
    /**
    * 天猫国际订单包税金额
    */
    private String taxCouponDiscount;
    /**
    * 个人充值红包金额
    */
    private String rechargeFee;
    /**
    * platformSubsidyFee
    */
    private String platformSubsidyFee;
    /**
    * nrReduceInvFail
    */
    private String nrReduceInvFail;
    /**
    * 新零售商家端商品唯一编号
    */
    private String nrOuterIid;
    /**
    * bind_oids字段的升级
    */
    private String bindOidsAllStatus;
    /**
    * sortInfo
    */
    private String sortInfo;
    /**
    * 天猫无人店线下店 ID
    */
    private String retailStoreId;
    /**
    * 天猫未来店外部 ERP 商品 ID
    */
    private String outItemId;
    /**
    * 新零售全渠道订单：商家自有货品编码
    */
    private String rtOmniOuterScId;
    /**
    * 新零售全渠道订单：后端货品ID
    */
    private String rtOmniScId;
    /**
    * 有值表示买家修改了地址
    */
    private String modifyAddress;
    /**
    * 买家修改地址时间
    */
    private String tiModifyAddressTime;
    /**
    * 有值表示信用购订单
    */
    private String creditBuy;
    
    private String sTariffFee;
    /**
    * 时效服务身份
    */
    private String timingPromise;
    /**
    * 时效服务字段
    */
    private String promiseService;
    /**
    * 预计送达时间
    */
    private String esDate;
    /**
    * 预计配送时间段
    */
    private String esRange;
    /**
    * 预约配送
    */
    private String osDate;
    /**
    * 预约配送
    */
    private String osRange;
    /**
    * 物流截单时间
    */
    private String cutoffMinutes;
    /**
    * 物流时效
    */
    private String esTime;
    /**
    * 最晚发货时间
    */
    private String deliveryTime;
    /**
    * 最晚揽收时间
    */
    private String collectTime;
    /**
    * 最晚派送时间
    */
    private String dispatchTime;
    /**
    * 最晚签收时间
    */
    private String signTime;
    /**
    * 信用购履约结束时间
    */
    private String promiseEndTime;
    /**
    * 经销商货品商家编码
    */
    private String omniJxsOuterid;
    /**
    * 使用淘金币的数量
    */
    private String propoint;
    /**
    * 是否是考拉商品订单
    */
    private String isKaola;
    /**
    * 同城购订单source
    */
    private String brandLightShopSource;
    /**
    * 同城购门店id
    */
    private String brandLightShopStoreId;
    /**
    * 特殊的退款类型
    */
    private String specialRefundType;
    /**
    * 透出的额外信息
    */
    private String extendInfo;
    /**
    * 子订单优惠贬值
    */
    private String isDevalueFee;
    /**
    * 服务供应链-服务订单类型
    */
    private String serviceOrderType;
    /**
    * 服务供应链-服务商外部编码
    */
    private String serviceOuterId;
    /**
    * 购物金核销子订单权益金分摊金额（单位为分）
    */
    private String expandCardExpandPriceUsedSuborder;
    /**
    * 购物金核销子订单本金分摊金额（单位为分）
    */
    private String expandCardBasicPriceUsedSuborder;
    /**
    * 时间戳
    */
    private Date timeStamp;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 更新时间
    */
    private Date updateTime;
    /**
    * 备用字段1
    */
    private String ext1;
    /**
    * 备用字段2
    */
    private String ext2;
    /**
    * 备用字段3
    */
    private String ext3;
    /**
    * 备用字段4
    */
    private String ext4;
    /**
    * 备用字段5
    */
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
        
    public String getOlshopid() {
        return olshopid;
    }

    public void setOlshopid(String olshopid) {
        this.olshopid = olshopid;
    }
        
    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }
        
    public String getAdjustFee() {
        return adjustFee;
    }

    public void setAdjustFee(String adjustFee) {
        this.adjustFee = adjustFee;
    }
        
    public String getBuyerRate() {
        return buyerRate;
    }

    public void setBuyerRate(String buyerRate) {
        this.buyerRate = buyerRate;
    }
        
    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }
        
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
        
    public String getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(String refundStatus) {
        this.refundStatus = refundStatus;
    }
        
    public String getConsignTime() {
        return consignTime;
    }

    public void setConsignTime(String consignTime) {
        this.consignTime = consignTime;
    }
        
    public String getDiscountFee() {
        return discountFee;
    }

    public void setDiscountFee(String discountFee) {
        this.discountFee = discountFee;
    }
        
    public String getDivideOrderFee() {
        return divideOrderFee;
    }

    public void setDivideOrderFee(String divideOrderFee) {
        this.divideOrderFee = divideOrderFee;
    }
        
    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
        
    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }
        
    public String getIsDaixiao() {
        return isDaixiao;
    }

    public void setIsDaixiao(String isDaixiao) {
        this.isDaixiao = isDaixiao;
    }
        
    public String getIsOversold() {
        return isOversold;
    }

    public void setIsOversold(String isOversold) {
        this.isOversold = isOversold;
    }
        
    public String getLogisticsCompany() {
        return logisticsCompany;
    }

    public void setLogisticsCompany(String logisticsCompany) {
        this.logisticsCompany = logisticsCompany;
    }
        
    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
        
    public Long getNumIid() {
        return numIid;
    }

    public void setNumIid(Long numIid) {
        this.numIid = numIid;
    }
        
    public String getOrderFrom() {
        return orderFrom;
    }

    public void setOrderFrom(String orderFrom) {
        this.orderFrom = orderFrom;
    }
        
    public String getOuterIid() {
        return outerIid;
    }

    public void setOuterIid(String outerIid) {
        this.outerIid = outerIid;
    }
        
    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }
        
    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }
        
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
        
    public String getSellerRate() {
        return sellerRate;
    }

    public void setSellerRate(String sellerRate) {
        this.sellerRate = sellerRate;
    }
        
    public String getSellerType() {
        return sellerType;
    }

    public void setSellerType(String sellerType) {
        this.sellerType = sellerType;
    }
        
    public String getShippingType() {
        return shippingType;
    }

    public void setShippingType(String shippingType) {
        this.shippingType = shippingType;
    }
        
    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }
        
    public String getSkuPropertiesName() {
        return skuPropertiesName;
    }

    public void setSkuPropertiesName(String skuPropertiesName) {
        this.skuPropertiesName = skuPropertiesName;
    }
        
    public String getSnapshotUrl() {
        return snapshotUrl;
    }

    public void setSnapshotUrl(String snapshotUrl) {
        this.snapshotUrl = snapshotUrl;
    }
        
    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
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
        
    public String getItemMealName() {
        return itemMealName;
    }

    public void setItemMealName(String itemMealName) {
        this.itemMealName = itemMealName;
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
        
    public String getSnapshot() {
        return snapshot;
    }

    public void setSnapshot(String snapshot) {
        this.snapshot = snapshot;
    }
        
    public Date getTimeoutActionTime() {
        return timeoutActionTime;
    }

    public void setTimeoutActionTime(Date timeoutActionTime) {
        this.timeoutActionTime = timeoutActionTime;
    }
        
    public String getSubOrderTaxFee() {
        return subOrderTaxFee;
    }

    public void setSubOrderTaxFee(String subOrderTaxFee) {
        this.subOrderTaxFee = subOrderTaxFee;
    }
        
    public String getSubOrderTaxRate() {
        return subOrderTaxRate;
    }

    public void setSubOrderTaxRate(String subOrderTaxRate) {
        this.subOrderTaxRate = subOrderTaxRate;
    }
        
    public String getEstimateConTime() {
        return estimateConTime;
    }

    public void setEstimateConTime(String estimateConTime) {
        this.estimateConTime = estimateConTime;
    }
        
    public String getO2oGuideId() {
        return o2oGuideId;
    }

    public void setO2oGuideId(String o2oGuideId) {
        this.o2oGuideId = o2oGuideId;
    }
        
    public String getO2oGuideName() {
        return o2oGuideName;
    }

    public void setO2oGuideName(String o2oGuideName) {
        this.o2oGuideName = o2oGuideName;
    }
        
    public String getO2oShopId() {
        return o2oShopId;
    }

    public void setO2oShopId(String o2oShopId) {
        this.o2oShopId = o2oShopId;
    }
        
    public String getO2oShopName() {
        return o2oShopName;
    }

    public void setO2oShopName(String o2oShopName) {
        this.o2oShopName = o2oShopName;
    }
        
    public String getBizCode() {
        return bizCode;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
    }
        
    public String getCloudStore() {
        return cloudStore;
    }

    public void setCloudStore(String cloudStore) {
        this.cloudStore = cloudStore;
    }
        
    public String getHjSettleNoCommission() {
        return hjSettleNoCommission;
    }

    public void setHjSettleNoCommission(String hjSettleNoCommission) {
        this.hjSettleNoCommission = hjSettleNoCommission;
    }
        
    public String getOrderTaking() {
        return orderTaking;
    }

    public void setOrderTaking(String orderTaking) {
        this.orderTaking = orderTaking;
    }
        
    public String getCloudStoreToken() {
        return cloudStoreToken;
    }

    public void setCloudStoreToken(String cloudStoreToken) {
        this.cloudStoreToken = cloudStoreToken;
    }
        
    public String getCloudStoreBindPos() {
        return cloudStoreBindPos;
    }

    public void setCloudStoreBindPos(String cloudStoreBindPos) {
        this.cloudStoreBindPos = cloudStoreBindPos;
    }
        
    public String getOsActivityId() {
        return osActivityId;
    }

    public void setOsActivityId(String osActivityId) {
        this.osActivityId = osActivityId;
    }
        
    public String getOsFgItemId() {
        return osFgItemId;
    }

    public void setOsFgItemId(String osFgItemId) {
        this.osFgItemId = osFgItemId;
    }
        
    public String getOsGiftCount() {
        return osGiftCount;
    }

    public void setOsGiftCount(String osGiftCount) {
        this.osGiftCount = osGiftCount;
    }
        
    public String getOsSortNum() {
        return osSortNum;
    }

    public void setOsSortNum(String osSortNum) {
        this.osSortNum = osSortNum;
    }
        
    public Integer getItemOid() {
        return itemOid;
    }

    public void setItemOid(Integer itemOid) {
        this.itemOid = itemOid;
    }
        
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
        
    public String getIid() {
        return iid;
    }

    public void setIid(String iid) {
        this.iid = iid;
    }
        
    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }
        
    public Integer getItemMealId() {
        return itemMealId;
    }

    public void setItemMealId(Integer itemMealId) {
        this.itemMealId = itemMealId;
    }
        
    public String getOuterSkuId() {
        return outerSkuId;
    }

    public void setOuterSkuId(String outerSkuId) {
        this.outerSkuId = outerSkuId;
    }
        
    public String getServiceDetailUrl() {
        return serviceDetailUrl;
    }

    public void setServiceDetailUrl(String serviceDetailUrl) {
        this.serviceDetailUrl = serviceDetailUrl;
    }
        
    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }
        
    public String getRefundId() {
        return refundId;
    }

    public void setRefundId(String refundId) {
        this.refundId = refundId;
    }
        
    public String getIsServiceOrder() {
        return isServiceOrder;
    }

    public void setIsServiceOrder(String isServiceOrder) {
        this.isServiceOrder = isServiceOrder;
    }
        
    public String getOrderAttr() {
        return orderAttr;
    }

    public void setOrderAttr(String orderAttr) {
        this.orderAttr = orderAttr;
    }
        
    public Integer getBindOid() {
        return bindOid;
    }

    public void setBindOid(Integer bindOid) {
        this.bindOid = bindOid;
    }
        
    public String getPartMjzDiscount() {
        return partMjzDiscount;
    }

    public void setPartMjzDiscount(String partMjzDiscount) {
        this.partMjzDiscount = partMjzDiscount;
    }
        
    public String getTicketOuterId() {
        return ticketOuterId;
    }

    public void setTicketOuterId(String ticketOuterId) {
        this.ticketOuterId = ticketOuterId;
    }
        
    public String getTicketExpdateKey() {
        return ticketExpdateKey;
    }

    public void setTicketExpdateKey(String ticketExpdateKey) {
        this.ticketExpdateKey = ticketExpdateKey;
    }
        
    public String getIsWww() {
        return isWww;
    }

    public void setIsWww(String isWww) {
        this.isWww = isWww;
    }
        
    public String getTmserSpuCode() {
        return tmserSpuCode;
    }

    public void setTmserSpuCode(String tmserSpuCode) {
        this.tmserSpuCode = tmserSpuCode;
    }
        
    public String getBindOids() {
        return bindOids;
    }

    public void setBindOids(String bindOids) {
        this.bindOids = bindOids;
    }
        
    public String getZhengjiStatus() {
        return zhengjiStatus;
    }

    public void setZhengjiStatus(String zhengjiStatus) {
        this.zhengjiStatus = zhengjiStatus;
    }
        
    public String getMdQualification() {
        return mdQualification;
    }

    public void setMdQualification(String mdQualification) {
        this.mdQualification = mdQualification;
    }
        
    public String getMdFee() {
        return mdFee;
    }

    public void setMdFee(String mdFee) {
        this.mdFee = mdFee;
    }
        
    public String getCustomization() {
        return customization;
    }

    public void setCustomization(String customization) {
        this.customization = customization;
    }
        
    public String getInvType() {
        return invType;
    }

    public void setInvType(String invType) {
        this.invType = invType;
    }
        
    public String getXxx() {
        return xxx;
    }

    public void setXxx(String xxx) {
        this.xxx = xxx;
    }
        
    public String getIsShShip() {
        return isShShip;
    }

    public void setIsShShip(String isShShip) {
        this.isShShip = isShShip;
    }
        
    public String getShipper() {
        return shipper;
    }

    public void setShipper(String shipper) {
        this.shipper = shipper;
    }
        
    public String getFType() {
        return fType;
    }

    public void setFType(String fType) {
        this.fType = fType;
    }
        
    public String getFStatus() {
        return fStatus;
    }

    public void setFStatus(String fStatus) {
        this.fStatus = fStatus;
    }
        
    public String getFTerm() {
        return fTerm;
    }

    public void setFTerm(String fTerm) {
        this.fTerm = fTerm;
    }
        
    public String getO2oEtOrderId() {
        return o2oEtOrderId;
    }

    public void setO2oEtOrderId(String o2oEtOrderId) {
        this.o2oEtOrderId = o2oEtOrderId;
    }
        
    public String getComboId() {
        return comboId;
    }

    public void setComboId(String comboId) {
        this.comboId = comboId;
    }
        
    public String getAssemblyRela() {
        return assemblyRela;
    }

    public void setAssemblyRela(String assemblyRela) {
        this.assemblyRela = assemblyRela;
    }
        
    public String getAssemblyPrice() {
        return assemblyPrice;
    }

    public void setAssemblyPrice(String assemblyPrice) {
        this.assemblyPrice = assemblyPrice;
    }
        
    public String getAssemblyItem() {
        return assemblyItem;
    }

    public void setAssemblyItem(String assemblyItem) {
        this.assemblyItem = assemblyItem;
    }
        
    public String getSubOrderTaxPromotionFee() {
        return subOrderTaxPromotionFee;
    }

    public void setSubOrderTaxPromotionFee(String subOrderTaxPromotionFee) {
        this.subOrderTaxPromotionFee = subOrderTaxPromotionFee;
    }
        
    public String getClDownPayment() {
        return clDownPayment;
    }

    public void setClDownPayment(String clDownPayment) {
        this.clDownPayment = clDownPayment;
    }
        
    public String getClDownPaymentRatio() {
        return clDownPaymentRatio;
    }

    public void setClDownPaymentRatio(String clDownPaymentRatio) {
        this.clDownPaymentRatio = clDownPaymentRatio;
    }
        
    public String getClMonthPayment() {
        return clMonthPayment;
    }

    public void setClMonthPayment(String clMonthPayment) {
        this.clMonthPayment = clMonthPayment;
    }
        
    public String getClTailPayment() {
        return clTailPayment;
    }

    public void setClTailPayment(String clTailPayment) {
        this.clTailPayment = clTailPayment;
    }
        
    public String getClInstallmentNum() {
        return clInstallmentNum;
    }

    public void setClInstallmentNum(String clInstallmentNum) {
        this.clInstallmentNum = clInstallmentNum;
    }
        
    public String getCalPenalty() {
        return calPenalty;
    }

    public void setCalPenalty(String calPenalty) {
        this.calPenalty = calPenalty;
    }
        
    public String getClServiceFee() {
        return clServiceFee;
    }

    public void setClServiceFee(String clServiceFee) {
        this.clServiceFee = clServiceFee;
    }
        
    public String getClCarTaker() {
        return clCarTaker;
    }

    public void setClCarTaker(String clCarTaker) {
        this.clCarTaker = clCarTaker;
    }
        
    public String getClCarTakerPhone() {
        return clCarTakerPhone;
    }

    public void setClCarTakerPhone(String clCarTakerPhone) {
        this.clCarTakerPhone = clCarTakerPhone;
    }
        
    public String getClCarTakerIDNum() {
        return clCarTakerIDNum;
    }

    public void setClCarTakerIDNum(String clCarTakerIDNum) {
        this.clCarTakerIDNum = clCarTakerIDNum;
    }
        
    public String getClCarTakerIdNum() {
        return clCarTakerIdNum;
    }

    public void setClCarTakerIdNum(String clCarTakerIdNum) {
        this.clCarTakerIdNum = clCarTakerIdNum;
    }
        
    public String getDownPayment() {
        return downPayment;
    }

    public void setDownPayment(String downPayment) {
        this.downPayment = downPayment;
    }
        
    public String getDownPaymentRatio() {
        return downPaymentRatio;
    }

    public void setDownPaymentRatio(String downPaymentRatio) {
        this.downPaymentRatio = downPaymentRatio;
    }
        
    public String getMonthPayment() {
        return monthPayment;
    }

    public void setMonthPayment(String monthPayment) {
        this.monthPayment = monthPayment;
    }
        
    public String getTailPayment() {
        return tailPayment;
    }

    public void setTailPayment(String tailPayment) {
        this.tailPayment = tailPayment;
    }
        
    public String getInstallmentNum() {
        return installmentNum;
    }

    public void setInstallmentNum(String installmentNum) {
        this.installmentNum = installmentNum;
    }
        
    public String getPenalty() {
        return penalty;
    }

    public void setPenalty(String penalty) {
        this.penalty = penalty;
    }
        
    public String getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(String serviceFee) {
        this.serviceFee = serviceFee;
    }
        
    public String getCarTaker() {
        return carTaker;
    }

    public void setCarTaker(String carTaker) {
        this.carTaker = carTaker;
    }
        
    public String getCarTakerPhone() {
        return carTakerPhone;
    }

    public void setCarTakerPhone(String carTakerPhone) {
        this.carTakerPhone = carTakerPhone;
    }
        
    public String getCarTakerIdNum() {
        return carTakerIdNum;
    }

    public void setCarTakerIdNum(String carTakerIdNum) {
        this.carTakerIdNum = carTakerIdNum;
    }
        
    public String getCarStoreCode() {
        return carStoreCode;
    }

    public void setCarStoreCode(String carStoreCode) {
        this.carStoreCode = carStoreCode;
    }
        
    public String getCarStoreName() {
        return carStoreName;
    }

    public void setCarStoreName(String carStoreName) {
        this.carStoreName = carStoreName;
    }
        
    public String getOutUniqueId() {
        return outUniqueId;
    }

    public void setOutUniqueId(String outUniqueId) {
        this.outUniqueId = outUniqueId;
    }
        
    public String getWsBankApplyNo() {
        return wsBankApplyNo;
    }

    public void setWsBankApplyNo(String wsBankApplyNo) {
        this.wsBankApplyNo = wsBankApplyNo;
    }
        
    public String getCarTakerId() {
        return carTakerId;
    }

    public void setCarTakerId(String carTakerId) {
        this.carTakerId = carTakerId;
    }
        
    public String getOidStr() {
        return oidStr;
    }

    public void setOidStr(String oidStr) {
        this.oidStr = oidStr;
    }
        
    public Integer getFqgNum() {
        return fqgNum;
    }

    public void setFqgNum(Integer fqgNum) {
        this.fqgNum = fqgNum;
    }
        
    public String getIsFqgSFee() {
        return isFqgSFee;
    }

    public void setIsFqgSFee(String isFqgSFee) {
        this.isFqgSFee = isFqgSFee;
    }
        
    public String getTaxFree() {
        return taxFree;
    }

    public void setTaxFree(String taxFree) {
        this.taxFree = taxFree;
    }
        
    public String getTaxCouponDiscount() {
        return taxCouponDiscount;
    }

    public void setTaxCouponDiscount(String taxCouponDiscount) {
        this.taxCouponDiscount = taxCouponDiscount;
    }
        
    public String getRechargeFee() {
        return rechargeFee;
    }

    public void setRechargeFee(String rechargeFee) {
        this.rechargeFee = rechargeFee;
    }
        
    public String getPlatformSubsidyFee() {
        return platformSubsidyFee;
    }

    public void setPlatformSubsidyFee(String platformSubsidyFee) {
        this.platformSubsidyFee = platformSubsidyFee;
    }
        
    public String getNrReduceInvFail() {
        return nrReduceInvFail;
    }

    public void setNrReduceInvFail(String nrReduceInvFail) {
        this.nrReduceInvFail = nrReduceInvFail;
    }
        
    public String getNrOuterIid() {
        return nrOuterIid;
    }

    public void setNrOuterIid(String nrOuterIid) {
        this.nrOuterIid = nrOuterIid;
    }
        
    public String getBindOidsAllStatus() {
        return bindOidsAllStatus;
    }

    public void setBindOidsAllStatus(String bindOidsAllStatus) {
        this.bindOidsAllStatus = bindOidsAllStatus;
    }
        
    public String getSortInfo() {
        return sortInfo;
    }

    public void setSortInfo(String sortInfo) {
        this.sortInfo = sortInfo;
    }
        
    public String getRetailStoreId() {
        return retailStoreId;
    }

    public void setRetailStoreId(String retailStoreId) {
        this.retailStoreId = retailStoreId;
    }
        
    public String getOutItemId() {
        return outItemId;
    }

    public void setOutItemId(String outItemId) {
        this.outItemId = outItemId;
    }
        
    public String getRtOmniOuterScId() {
        return rtOmniOuterScId;
    }

    public void setRtOmniOuterScId(String rtOmniOuterScId) {
        this.rtOmniOuterScId = rtOmniOuterScId;
    }
        
    public String getRtOmniScId() {
        return rtOmniScId;
    }

    public void setRtOmniScId(String rtOmniScId) {
        this.rtOmniScId = rtOmniScId;
    }
        
    public String getModifyAddress() {
        return modifyAddress;
    }

    public void setModifyAddress(String modifyAddress) {
        this.modifyAddress = modifyAddress;
    }
        
    public String getTiModifyAddressTime() {
        return tiModifyAddressTime;
    }

    public void setTiModifyAddressTime(String tiModifyAddressTime) {
        this.tiModifyAddressTime = tiModifyAddressTime;
    }
        
    public String getCreditBuy() {
        return creditBuy;
    }

    public void setCreditBuy(String creditBuy) {
        this.creditBuy = creditBuy;
    }
        
    public String getSTariffFee() {
        return sTariffFee;
    }

    public void setSTariffFee(String sTariffFee) {
        this.sTariffFee = sTariffFee;
    }
        
    public String getTimingPromise() {
        return timingPromise;
    }

    public void setTimingPromise(String timingPromise) {
        this.timingPromise = timingPromise;
    }
        
    public String getPromiseService() {
        return promiseService;
    }

    public void setPromiseService(String promiseService) {
        this.promiseService = promiseService;
    }
        
    public String getEsDate() {
        return esDate;
    }

    public void setEsDate(String esDate) {
        this.esDate = esDate;
    }
        
    public String getEsRange() {
        return esRange;
    }

    public void setEsRange(String esRange) {
        this.esRange = esRange;
    }
        
    public String getOsDate() {
        return osDate;
    }

    public void setOsDate(String osDate) {
        this.osDate = osDate;
    }
        
    public String getOsRange() {
        return osRange;
    }

    public void setOsRange(String osRange) {
        this.osRange = osRange;
    }
        
    public String getCutoffMinutes() {
        return cutoffMinutes;
    }

    public void setCutoffMinutes(String cutoffMinutes) {
        this.cutoffMinutes = cutoffMinutes;
    }
        
    public String getEsTime() {
        return esTime;
    }

    public void setEsTime(String esTime) {
        this.esTime = esTime;
    }
        
    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }
        
    public String getCollectTime() {
        return collectTime;
    }

    public void setCollectTime(String collectTime) {
        this.collectTime = collectTime;
    }
        
    public String getDispatchTime() {
        return dispatchTime;
    }

    public void setDispatchTime(String dispatchTime) {
        this.dispatchTime = dispatchTime;
    }
        
    public String getSignTime() {
        return signTime;
    }

    public void setSignTime(String signTime) {
        this.signTime = signTime;
    }
        
    public String getPromiseEndTime() {
        return promiseEndTime;
    }

    public void setPromiseEndTime(String promiseEndTime) {
        this.promiseEndTime = promiseEndTime;
    }
        
    public String getOmniJxsOuterid() {
        return omniJxsOuterid;
    }

    public void setOmniJxsOuterid(String omniJxsOuterid) {
        this.omniJxsOuterid = omniJxsOuterid;
    }
        
    public String getPropoint() {
        return propoint;
    }

    public void setPropoint(String propoint) {
        this.propoint = propoint;
    }
        
    public String getIsKaola() {
        return isKaola;
    }

    public void setIsKaola(String isKaola) {
        this.isKaola = isKaola;
    }
        
    public String getBrandLightShopSource() {
        return brandLightShopSource;
    }

    public void setBrandLightShopSource(String brandLightShopSource) {
        this.brandLightShopSource = brandLightShopSource;
    }
        
    public String getBrandLightShopStoreId() {
        return brandLightShopStoreId;
    }

    public void setBrandLightShopStoreId(String brandLightShopStoreId) {
        this.brandLightShopStoreId = brandLightShopStoreId;
    }
        
    public String getSpecialRefundType() {
        return specialRefundType;
    }

    public void setSpecialRefundType(String specialRefundType) {
        this.specialRefundType = specialRefundType;
    }
        
    public String getExtendInfo() {
        return extendInfo;
    }

    public void setExtendInfo(String extendInfo) {
        this.extendInfo = extendInfo;
    }
        
    public String getIsDevalueFee() {
        return isDevalueFee;
    }

    public void setIsDevalueFee(String isDevalueFee) {
        this.isDevalueFee = isDevalueFee;
    }
        
    public String getServiceOrderType() {
        return serviceOrderType;
    }

    public void setServiceOrderType(String serviceOrderType) {
        this.serviceOrderType = serviceOrderType;
    }
        
    public String getServiceOuterId() {
        return serviceOuterId;
    }

    public void setServiceOuterId(String serviceOuterId) {
        this.serviceOuterId = serviceOuterId;
    }
        
    public String getExpandCardExpandPriceUsedSuborder() {
        return expandCardExpandPriceUsedSuborder;
    }

    public void setExpandCardExpandPriceUsedSuborder(String expandCardExpandPriceUsedSuborder) {
        this.expandCardExpandPriceUsedSuborder = expandCardExpandPriceUsedSuborder;
    }
        
    public String getExpandCardBasicPriceUsedSuborder() {
        return expandCardBasicPriceUsedSuborder;
    }

    public void setExpandCardBasicPriceUsedSuborder(String expandCardBasicPriceUsedSuborder) {
        this.expandCardBasicPriceUsedSuborder = expandCardBasicPriceUsedSuborder;
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