package org.tts.domain.mysql.entity;

import lombok.Builder;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品信息表(DWareBase)实体类
 *
 * @author makejava
 * @since 2021-08-20 18:04:41
 */
public class DWareBase implements Serializable {
    private static final long serialVersionUID = -79328392917738967L;
    /**
     * 自增id
     */
    private Long id;
    /**
     * 商品编码
     */
    private String warecode;
    /**
     * 商品名称
     */
    private String warename;
    /**
     * 商品来源(1.主数据 2.自建)
     */
    private Integer wareSrc;
    /**
     * 商品通用名称
     */
    private String waregeneralname;
    /**
     * 商品规格
     */
    private String warespec;
    /**
     * 商品单位
     */
    private String wareunit;
    /**
     * 批准文号
     */
    private String approvalNumber;
    /**
     * 商品助记码
     */
    private String wareabc;
    /**
     * 商品条码
     */
    private String barCode;
    /**
     * 失效天数
     */
    private String invalidDays;
    /**
     * 储存条件
     */
    private String storageCondition;
    /**
     * 体积(立方米)
     */
    private String volume;
    /**
     * 重量(克)
     */
    private String weight;
    /**
     * 上市许可持有人
     */
    private String holder;
    /**
     * 生产企业编号
     */
    private Integer compid;
    /**
     * 拆零单位
     */
    private String minUnit;
    /**
     * 可使用天数
     */
    private Integer availableDays;
    /**
     * 长(厘米)
     */
    private Double lengths;
    /**
     * 宽(厘米)
     */
    private Double widths;
    /**
     * 高(厘米)
     */
    private Double heights;
    /**
     * 科别
     */
    private String classification;
    /**
     * 诊断
     */
    private String diagnosis;
    /**
     * 处方药用法用量
     */
    private String medicationReminder;
    /**
     * 用法用量
     */
    private String usageDosage;
    /**
     * 主要成分
     */
    private String mainComponents;
    /**
     * 销项税
     */
    private Double saletax;
    /**
     * 商品性质1普通商品  2捆绑销售商品  3联营(不管库存)商品
     */
    private Integer wareKind;
    /**
     * 商品个性标识
     */
    private String wareMark;
    /**
     * 中包装数量
     */
    private Double midQty;
    /**
     * 每件数量
     */
    private Double maxQty;
    /**
     * 拆零比率
     */
    private Long minQty;
    /**
     * 品牌
     */
    private String trademark;
    /**
     * 是否冷藏：0否1是
     */
    private Integer isColdStorage;
    /**
     * 是否为含兴奋剂药品
     */
    private Integer isHasAnaleptic;
    /**
     * 是否为特殊类药品
     */
    private Integer isSpecialDrugs;
    /**
     * 是否拆零
     */
    private Integer isMin;
    /**
     * 是否为处方引流
     */
    private Integer isPrescriptionDrainage;
    /**
     * 是否为谈判品种
     */
    private Integer isNegotiationBreed;
    /**
     * 是否维价
     */
    private Integer isMaintenancePrice;
    /**
     * 功能主治
     */
    private String functions;
    /**
     * 零售自动拆零
     */
    private Integer autoDismounted;
    /**
     * 启用状态(0：未启用；1启用)(主数据状态)与d_ware_md的status同步
     */
    private Integer statusMd;
    /**
     * 启用状态(0：未启用；1启用)(订单中心状态)
     */
    private Integer status;
    /**
     * 采购状态(0：停止采购；1正常采购)
     */
    private Integer purStatus;
    /**
     * 销售状态(0：停止销售；1正常销售)
     */
    private Integer saleStatus;
    /**
     * 配送标志0正常配送1停止配送
     */
    private Integer distFlag;
    /**
     * 季节性品种
     */
    private String seasonBreed;
    /**
     * 物料类型(若为Z004则为备品）
     */
    private String mtart;
    /**
     * 物料组
     */
    private String indicationsClass;
    /**
     * 商品剂型
     */
    private String wareDosage;
    /**
     * 国家专门管理药品分类
     */
    private String manageDrugClass;
    /**
     * 统一价(电商价钱)
     */
    private Double saleprice;
    /**
     * 价格开始时间
     */
    private Date starttime;
    /**
     * 价格来源单据类型
     */
    private String billcode;
    /**
     * 价格来源编号
     */
    private String billno;
    /**
     * 是否维价(0否 1是)
     */
    private Integer ifPrice;
    /**
     * 建议零售价
     */
    private Double minsaleprice;
    /**
     * 主标题
     */
    private String mainTitle;
    /**
     * 副标题
     */
    private String subtitle;
    /**
     * 指导价
     */
    private Double guidancePrice;
    /**
     * 创建人
     */
    private String createUser;
    /**
     * 最终修改人
     */
    private String updateUser;
    /**
     * 移动平均价
     */
    private Double agrprice;
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
     * 备用字段1(套餐商品的生产厂家名称)
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

    public String getWarecode() {
        return warecode;
    }

    public void setWarecode(String warecode) {
        this.warecode = warecode;
    }

    public String getWarename() {
        return warename;
    }

    public void setWarename(String warename) {
        this.warename = warename;
    }

    public Integer getWareSrc() {
        return wareSrc;
    }

    public void setWareSrc(Integer wareSrc) {
        this.wareSrc = wareSrc;
    }

    public String getWaregeneralname() {
        return waregeneralname;
    }

    public void setWaregeneralname(String waregeneralname) {
        this.waregeneralname = waregeneralname;
    }

    public String getWarespec() {
        return warespec;
    }

    public void setWarespec(String warespec) {
        this.warespec = warespec;
    }

    public String getWareunit() {
        return wareunit;
    }

    public void setWareunit(String wareunit) {
        this.wareunit = wareunit;
    }

    public String getApprovalNumber() {
        return approvalNumber;
    }

    public void setApprovalNumber(String approvalNumber) {
        this.approvalNumber = approvalNumber;
    }

    public String getWareabc() {
        return wareabc;
    }

    public void setWareabc(String wareabc) {
        this.wareabc = wareabc;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getInvalidDays() {
        return invalidDays;
    }

    public void setInvalidDays(String invalidDays) {
        this.invalidDays = invalidDays;
    }

    public String getStorageCondition() {
        return storageCondition;
    }

    public void setStorageCondition(String storageCondition) {
        this.storageCondition = storageCondition;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Integer getCompid() {
        return compid;
    }

    public void setCompid(Integer compid) {
        this.compid = compid;
    }

    public String getMinUnit() {
        return minUnit;
    }

    public void setMinUnit(String minUnit) {
        this.minUnit = minUnit;
    }

    public Integer getAvailableDays() {
        return availableDays;
    }

    public void setAvailableDays(Integer availableDays) {
        this.availableDays = availableDays;
    }

    public Double getLengths() {
        return lengths;
    }

    public void setLengths(Double lengths) {
        this.lengths = lengths;
    }

    public Double getWidths() {
        return widths;
    }

    public void setWidths(Double widths) {
        this.widths = widths;
    }

    public Double getHeights() {
        return heights;
    }

    public void setHeights(Double heights) {
        this.heights = heights;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getMedicationReminder() {
        return medicationReminder;
    }

    public void setMedicationReminder(String medicationReminder) {
        this.medicationReminder = medicationReminder;
    }

    public String getUsageDosage() {
        return usageDosage;
    }

    public void setUsageDosage(String usageDosage) {
        this.usageDosage = usageDosage;
    }

    public String getMainComponents() {
        return mainComponents;
    }

    public void setMainComponents(String mainComponents) {
        this.mainComponents = mainComponents;
    }

    public Double getSaletax() {
        return saletax;
    }

    public void setSaletax(Double saletax) {
        this.saletax = saletax;
    }

    public Integer getWareKind() {
        return wareKind;
    }

    public void setWareKind(Integer wareKind) {
        this.wareKind = wareKind;
    }

    public String getWareMark() {
        return wareMark;
    }

    public void setWareMark(String wareMark) {
        this.wareMark = wareMark;
    }

    public Double getMidQty() {
        return midQty;
    }

    public void setMidQty(Double midQty) {
        this.midQty = midQty;
    }

    public Double getMaxQty() {
        return maxQty;
    }

    public void setMaxQty(Double maxQty) {
        this.maxQty = maxQty;
    }

    public Long getMinQty() {
        return minQty;
    }

    public void setMinQty(Long minQty) {
        this.minQty = minQty;
    }

    public String getTrademark() {
        return trademark;
    }

    public void setTrademark(String trademark) {
        this.trademark = trademark;
    }

    public Integer getIsColdStorage() {
        return isColdStorage;
    }

    public void setIsColdStorage(Integer isColdStorage) {
        this.isColdStorage = isColdStorage;
    }

    public Integer getIsHasAnaleptic() {
        return isHasAnaleptic;
    }

    public void setIsHasAnaleptic(Integer isHasAnaleptic) {
        this.isHasAnaleptic = isHasAnaleptic;
    }

    public Integer getIsSpecialDrugs() {
        return isSpecialDrugs;
    }

    public void setIsSpecialDrugs(Integer isSpecialDrugs) {
        this.isSpecialDrugs = isSpecialDrugs;
    }

    public Integer getIsMin() {
        return isMin;
    }

    public void setIsMin(Integer isMin) {
        this.isMin = isMin;
    }

    public Integer getIsPrescriptionDrainage() {
        return isPrescriptionDrainage;
    }

    public void setIsPrescriptionDrainage(Integer isPrescriptionDrainage) {
        this.isPrescriptionDrainage = isPrescriptionDrainage;
    }

    public Integer getIsNegotiationBreed() {
        return isNegotiationBreed;
    }

    public void setIsNegotiationBreed(Integer isNegotiationBreed) {
        this.isNegotiationBreed = isNegotiationBreed;
    }

    public Integer getIsMaintenancePrice() {
        return isMaintenancePrice;
    }

    public void setIsMaintenancePrice(Integer isMaintenancePrice) {
        this.isMaintenancePrice = isMaintenancePrice;
    }

    public String getFunctions() {
        return functions;
    }

    public void setFunctions(String functions) {
        this.functions = functions;
    }

    public Integer getAutoDismounted() {
        return autoDismounted;
    }

    public void setAutoDismounted(Integer autoDismounted) {
        this.autoDismounted = autoDismounted;
    }

    public Integer getStatusMd() {
        return statusMd;
    }

    public void setStatusMd(Integer statusMd) {
        this.statusMd = statusMd;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPurStatus() {
        return purStatus;
    }

    public void setPurStatus(Integer purStatus) {
        this.purStatus = purStatus;
    }

    public Integer getSaleStatus() {
        return saleStatus;
    }

    public void setSaleStatus(Integer saleStatus) {
        this.saleStatus = saleStatus;
    }

    public Integer getDistFlag() {
        return distFlag;
    }

    public void setDistFlag(Integer distFlag) {
        this.distFlag = distFlag;
    }

    public String getSeasonBreed() {
        return seasonBreed;
    }

    public void setSeasonBreed(String seasonBreed) {
        this.seasonBreed = seasonBreed;
    }

    public String getMtart() {
        return mtart;
    }

    public void setMtart(String mtart) {
        this.mtart = mtart;
    }

    public String getIndicationsClass() {
        return indicationsClass;
    }

    public void setIndicationsClass(String indicationsClass) {
        this.indicationsClass = indicationsClass;
    }

    public String getWareDosage() {
        return wareDosage;
    }

    public void setWareDosage(String wareDosage) {
        this.wareDosage = wareDosage;
    }

    public String getManageDrugClass() {
        return manageDrugClass;
    }

    public void setManageDrugClass(String manageDrugClass) {
        this.manageDrugClass = manageDrugClass;
    }

    public Double getSaleprice() {
        return saleprice;
    }

    public void setSaleprice(Double saleprice) {
        this.saleprice = saleprice;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public String getBillcode() {
        return billcode;
    }

    public void setBillcode(String billcode) {
        this.billcode = billcode;
    }

    public String getBillno() {
        return billno;
    }

    public void setBillno(String billno) {
        this.billno = billno;
    }

    public Integer getIfPrice() {
        return ifPrice;
    }

    public void setIfPrice(Integer ifPrice) {
        this.ifPrice = ifPrice;
    }

    public Double getMinsaleprice() {
        return minsaleprice;
    }

    public void setMinsaleprice(Double minsaleprice) {
        this.minsaleprice = minsaleprice;
    }

    public String getMainTitle() {
        return mainTitle;
    }

    public void setMainTitle(String mainTitle) {
        this.mainTitle = mainTitle;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public Double getGuidancePrice() {
        return guidancePrice;
    }

    public void setGuidancePrice(Double guidancePrice) {
        this.guidancePrice = guidancePrice;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Double getAgrprice() {
        return agrprice;
    }

    public void setAgrprice(Double agrprice) {
        this.agrprice = agrprice;
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
