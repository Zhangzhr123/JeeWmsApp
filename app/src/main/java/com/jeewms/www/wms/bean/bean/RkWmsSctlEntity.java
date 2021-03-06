package com.jeewms.www.wms.bean.bean;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;


/**   
 * @Title: Entity
 * @Description: 生产投料
 * @author onlineGenerator
 * @date 2020-05-20 10:23:50
 * @version V1.0   
 *
 */

@SuppressWarnings("serial")
public class RkWmsSctlEntity implements java.io.Serializable {
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
	/**WBS*/
	private String rkWbs;
	/**投料编号*/
	private String rkTlbh;
	/**投料类型*/
	private String rkTllx;
	/**物料编码*/
	private String rkWlbm;
	/**物料描述*/
	private String rkWlms;
	/**投料库存地点*/
	private String rkTlkcdd;
	/**数量*/
	private Double rkSl;
	/**投料时间*/
	private String rkTlsj;
	/**投料人*/
	private String rkTlr;
	/**溯源单*/
	private String rkSyd;
	/**溯源单行项目*/
	private String rkSydhxm;
	/**SAP状态*/
	private String rkSapzt;
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

	public String getRkWbs() {
		return rkWbs;
	}

	public void setRkWbs(String rkWbs) {
		this.rkWbs = rkWbs;
	}

	public String getRkTlbh() {
		return rkTlbh;
	}

	public void setRkTlbh(String rkTlbh) {
		this.rkTlbh = rkTlbh;
	}

	public String getRkTllx() {
		return rkTllx;
	}

	public void setRkTllx(String rkTllx) {
		this.rkTllx = rkTllx;
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

	public String getRkTlkcdd() {
		return rkTlkcdd;
	}

	public void setRkTlkcdd(String rkTlkcdd) {
		this.rkTlkcdd = rkTlkcdd;
	}

	public Double getRkSl() {
		return rkSl;
	}

	public void setRkSl(Double rkSl) {
		this.rkSl = rkSl;
	}

	public String getRkTlsj() {
		return rkTlsj;
	}

	public void setRkTlsj(String rkTlsj) {
		this.rkTlsj = rkTlsj;
	}

	public String getRkTlr() {
		return rkTlr;
	}

	public void setRkTlr(String rkTlr) {
		this.rkTlr = rkTlr;
	}

	public String getRkSyd() {
		return rkSyd;
	}

	public void setRkSyd(String rkSyd) {
		this.rkSyd = rkSyd;
	}

	public String getRkSydhxm() {
		return rkSydhxm;
	}

	public void setRkSydhxm(String rkSydhxm) {
		this.rkSydhxm = rkSydhxm;
	}

	public String getRkSapzt() {
		return rkSapzt;
	}

	public void setRkSapzt(String rkSapzt) {
		this.rkSapzt = rkSapzt;
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
