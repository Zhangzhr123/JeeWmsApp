package com.jeewms.www.wms.bean.bean;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;


/**   
 * @Title: Entity
 * @Description: 收货单表
 * @author onlineGenerator
 * @date 2020-05-20 12:53:36
 * @version V1.0   
 *
 */

@SuppressWarnings("serial")
public class RiWmsShdbEntity implements java.io.Serializable {
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
	/**工厂*/
	private String rkGc;
	/**采购订单*/
	private String rkCgdd;
	/**行项目*/
	private String rkHxm;
	/**供应商编号*/
	private String rkGysbh;
	/**供应商名称*/
	private String rkGysmc;
	/**用途描述*/
	private String rkYtms;
	/**送货地点*/
	private String rkShdd;
	/**WBS*/
	private String rkWbs;
	/**物料编码*/
	private String rkWlbm;
	/**物料描述*/
	private String rkWlms;
	/**数量*/
	private Double rkSl;
	/**收货日期*/
	private Date rkShrq;
	/**收货人*/
	private String rkShr;
	/**溯源单据号*/
	private String rkSydjh;
	/**溯源单行项目*/
	private String rkSydhxm;
	/**SAP状态*/
	private Integer rkSapzz;
	/**SAP异常信息*/
	private String rkSapycxx;
	/**人工处理*/
	private Integer rkRgcl;
	/**处理时间*/
	private Date rkClsj;
	/**处理人*/
	private String rkClr;
	/**是否选中*/
	private Boolean checked;

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

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

	public String getRkGc() {
		return rkGc;
	}

	public void setRkGc(String rkGc) {
		this.rkGc = rkGc;
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

	public String getRkGysbh() {
		return rkGysbh;
	}

	public void setRkGysbh(String rkGysbh) {
		this.rkGysbh = rkGysbh;
	}

	public String getRkGysmc() {
		return rkGysmc;
	}

	public void setRkGysmc(String rkGysmc) {
		this.rkGysmc = rkGysmc;
	}

	public String getRkYtms() {
		return rkYtms;
	}

	public void setRkYtms(String rkYtms) {
		this.rkYtms = rkYtms;
	}

	public String getRkShdd() {
		return rkShdd;
	}

	public void setRkShdd(String rkShdd) {
		this.rkShdd = rkShdd;
	}

	public String getRkWbs() {
		return rkWbs;
	}

	public void setRkWbs(String rkWbs) {
		this.rkWbs = rkWbs;
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

	public Double getRkSl() {
		return rkSl;
	}

	public void setRkSl(Double rkSl) {
		this.rkSl = rkSl;
	}

	public Date getRkShrq() {
		return rkShrq;
	}

	public void setRkShrq(Date rkShrq) {
		this.rkShrq = rkShrq;
	}

	public String getRkShr() {
		return rkShr;
	}

	public void setRkShr(String rkShr) {
		this.rkShr = rkShr;
	}

	public String getRkSydjh() {
		return rkSydjh;
	}

	public void setRkSydjh(String rkSydjh) {
		this.rkSydjh = rkSydjh;
	}

	public String getRkSydhxm() {
		return rkSydhxm;
	}

	public void setRkSydhxm(String rkSydhxm) {
		this.rkSydhxm = rkSydhxm;
	}

	public Integer getRkSapzz() {
		return rkSapzz;
	}

	public void setRkSapzz(Integer rkSapzz) {
		this.rkSapzz = rkSapzz;
	}

	public String getRkSapycxx() {
		return rkSapycxx;
	}

	public void setRkSapycxx(String rkSapycxx) {
		this.rkSapycxx = rkSapycxx;
	}

	public Integer getRkRgcl() {
		return rkRgcl;
	}

	public void setRkRgcl(Integer rkRgcl) {
		this.rkRgcl = rkRgcl;
	}

	public Date getRkClsj() {
		return rkClsj;
	}

	public void setRkClsj(Date rkClsj) {
		this.rkClsj = rkClsj;
	}

	public String getRkClr() {
		return rkClr;
	}

	public void setRkClr(String rkClr) {
		this.rkClr = rkClr;
	}
}
