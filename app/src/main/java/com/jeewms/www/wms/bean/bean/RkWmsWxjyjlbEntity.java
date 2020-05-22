package com.jeewms.www.wms.bean.bean;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;


/**   
 * @Title: Entity
 * @Description: 外协检验记录表
 * @author onlineGenerator
 * @date 2020-05-22 11:45:15
 * @version V1.0   
 *
 */

@SuppressWarnings("serial")
public class RkWmsWxjyjlbEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**创建人名称*/
	private String createName;
	/**创建人登录名称*/
	private String createBy;
	/**创建日期*/
	private Date createDate;
	/**更新人名称*/
	private String updateName;
	/**更新人登录名称*/
	private String updateBy;
	/**更新日期*/
	private Date updateDate;
	/**所属部门*/
	private String sysOrgCode;
	/**所属公司*/
	private String sysCompanyCode;
	/**流程状态*/
	private String bpmStatus;
	/**WBS*/
	private String rkWbs;
	/**采购订单*/
	private String rkCgdd;
	/**行项目*/
	private String rkHxm;
	/**物料编码*/
	private String rkWlbm;
	/**物料描述*/
	private String rkWlms;
	/**订单数量*/
	private Double rkDdsl;
	/**收货数量*/
	private Double rkShsl;
	/**检验类型*/
	private String rkJylx;

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

	public String getBpmStatus() {
		return bpmStatus;
	}

	public void setBpmStatus(String bpmStatus) {
		this.bpmStatus = bpmStatus;
	}

	public String getRkWbs() {
		return rkWbs;
	}

	public void setRkWbs(String rkWbs) {
		this.rkWbs = rkWbs;
	}

	public String getRkCgdd() {
		return rkCgdd;
	}

	public void setRkCgdd(String rkCgdd) {
		this.rkCgdd = rkCgdd;
	}

	public String getRkHxm() {
		return rkHxm;
	}

	public void setRkHxm(String rkHxm) {
		this.rkHxm = rkHxm;
	}

	public String getRkWlbm() {
		return rkWlbm;
	}

	public void setRkWlbm(String rkWlbm) {
		this.rkWlbm = rkWlbm;
	}

	public String getRkWlms() {
		return rkWlms;
	}

	public void setRkWlms(String rkWlms) {
		this.rkWlms = rkWlms;
	}

	public Double getRkDdsl() {
		return rkDdsl;
	}

	public void setRkDdsl(Double rkDdsl) {
		this.rkDdsl = rkDdsl;
	}

	public Double getRkShsl() {
		return rkShsl;
	}

	public void setRkShsl(Double rkShsl) {
		this.rkShsl = rkShsl;
	}

	public String getRkJylx() {
		return rkJylx;
	}

	public void setRkJylx(String rkJylx) {
		this.rkJylx = rkJylx;
	}
}
