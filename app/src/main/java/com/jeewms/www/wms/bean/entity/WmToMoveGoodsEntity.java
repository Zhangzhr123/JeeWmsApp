package com.jeewms.www.wms.bean.entity;

import java.util.Date;
import java.lang.String;


/**   
 * @Title: Entity
 * @Description: 库内转移
 * @author onlineGenerator
 * @date 2017-09-11 15:25:15
 * @version V1.0   
 *
 */

@SuppressWarnings("serial")
public class WmToMoveGoodsEntity {
	/**
	 * 主键
	 */
	private String id;
	/**
	 * 创建人名称
	 */
	private String createName;
	/**
	 * 创建人登录名称
	 */
	private String createBy;
	/**
	 * 创建日期
	 */
	private Date createDate;
	/**
	 * 更新人名称
	 */
	private String updateName;
	/**
	 * 更新人登录名称
	 */
	private String updateBy;
	/**
	 * 更新日期
	 */
	private Date updateDate;
	/**
	 * 所属部门
	 */
	private String sysOrgCode;
	/**
	 * 所属公司
	 */
	private String sysCompanyCode;
	/**
	 * 原始单据类型
	 */
	private String orderTypeCode;
	/**
	 * 原始单据编码
	 */
	private String orderId;
	/**
	 * 原始单据行项目
	 */
	private String orderIdI;
	/**
	 * 商品编码
	 */
	private String goodsId;
	/**
	 * 商品名称
	 */
	private String goodsName;
	/**
	 * 数量
	 */
	private String goodsQua;
	/**
	 * 生产日期
	 */
	private String goodsProData;
	/**
	 * 单位
	 */
	private String goodsUnit;
	/**
	 * 客户编码
	 */
	private String cusCode;
	/**
	 * 客户名称
	 */
	private String cusName;
	/**
	 * 源托盘
	 */
	private String tinFrom;
	/**
	 * 到托盘
	 */
	private String tinId;
	/**
	 * 源储位
	 */
	private String binFrom;
	/**
	 * 到储位
	 */
	private String binTo;
	/**
	 * 状态
	 */
	private String moveSta;
	/**
	 * 转移客户
	 */
	private String toCusCode;
	/**
	 * 转移客户名称
	 */
	private String toCusName;
	/**
	 * 基本单位
	 */
	private String baseUnit;
	/**
	 * 基本单位数量
	 */
	private String baseGoodscount;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreateName() {
		return createName;
	}

	public void setCreateName(String createName) {
		this.createName = createName;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUpdateName() {
		return updateName;
	}

	public void setUpdateName(String updateName) {
		this.updateName = updateName;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getSysOrgCode() {
		return sysOrgCode;
	}

	public void setSysOrgCode(String sysOrgCode) {
		this.sysOrgCode = sysOrgCode;
	}

	public String getSysCompanyCode() {
		return sysCompanyCode;
	}

	public void setSysCompanyCode(String sysCompanyCode) {
		this.sysCompanyCode = sysCompanyCode;
	}

	public String getOrderTypeCode() {
		return orderTypeCode;
	}

	public void setOrderTypeCode(String orderTypeCode) {
		this.orderTypeCode = orderTypeCode;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderIdI() {
		return orderIdI;
	}

	public void setOrderIdI(String orderIdI) {
		this.orderIdI = orderIdI;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsQua() {
		return goodsQua;
	}

	public void setGoodsQua(String goodsQua) {
		this.goodsQua = goodsQua;
	}

	public String getGoodsProData() {
		return goodsProData;
	}

	public void setGoodsProData(String goodsProData) {
		this.goodsProData = goodsProData;
	}

	public String getGoodsUnit() {
		return goodsUnit;
	}

	public void setGoodsUnit(String goodsUnit) {
		this.goodsUnit = goodsUnit;
	}

	public String getCusCode() {
		return cusCode;
	}

	public void setCusCode(String cusCode) {
		this.cusCode = cusCode;
	}

	public String getCusName() {
		return cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	public String getTinFrom() {
		return tinFrom;
	}

	public void setTinFrom(String tinFrom) {
		this.tinFrom = tinFrom;
	}

	public String getTinId() {
		return tinId;
	}

	public void setTinId(String tinId) {
		this.tinId = tinId;
	}

	public String getBinFrom() {
		return binFrom;
	}

	public void setBinFrom(String binFrom) {
		this.binFrom = binFrom;
	}

	public String getBinTo() {
		return binTo;
	}

	public void setBinTo(String binTo) {
		this.binTo = binTo;
	}

	public String getMoveSta() {
		return moveSta;
	}

	public void setMoveSta(String moveSta) {
		this.moveSta = moveSta;
	}

	public String getToCusCode() {
		return toCusCode;
	}

	public void setToCusCode(String toCusCode) {
		this.toCusCode = toCusCode;
	}

	public String getToCusName() {
		return toCusName;
	}

	public void setToCusName(String toCusName) {
		this.toCusName = toCusName;
	}

	public String getBaseUnit() {
		return baseUnit;
	}

	public void setBaseUnit(String baseUnit) {
		this.baseUnit = baseUnit;
	}

	public String getBaseGoodscount() {
		return baseGoodscount;
	}

	public void setBaseGoodscount(String baseGoodscount) {
		this.baseGoodscount = baseGoodscount;
	}
}
