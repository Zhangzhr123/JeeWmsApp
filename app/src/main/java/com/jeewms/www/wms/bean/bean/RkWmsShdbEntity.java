package com.jeewms.www.wms.bean.bean;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;


/**   
 * @Title: Entity
 * @Description: 送货单表
 * @author onlineGenerator
 * @date 2020-05-22 10:16:12
 * @version V1.0   
 *
 */
@SuppressWarnings("serial")
public class RkWmsShdbEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**创建人名称*/
	private String createName;
	/**创建人登录名称*/
	private String createBy;
	/**创建日期*/
	private Long createDate;
	/**更新人名称*/
	private String updateName;
	/**更新人登录名称*/
	private String updateBy;
	/**更新日期*/
	private Long updateDate;
	/**所属部门*/
	private String sysOrgCode;
	/**所属公司*/
	private String sysCompanyCode;
	/**流程状态*/
	private String bpmStatus;
	/**送货单编号*/
	private String pshwln;
	/**工厂*/
	private String pwerks;
	/**供应商*/
	private String plifnr;
	/**供应商描述*/
	private String pliftx;
	/**采购组*/
	private String pernam;
	/**用途描述*/
	private String ptype;
	/**送货地点*/
	private String plgort;
	/**网络生产订单*/
	private String paufnr;
	/**收货员*/
	private String ploggr;
	/**补打标志*/
	private String pdupli;
	/**条码*/
	private String ptm;
	/**送货单行项目*/
	private String shwlp;
	/**采购订单*/
	private String ebeln;
	/**采购订单行项目*/
	private String ebelp;
	/**WBS*/
	private String psptx;
	/**物料编号*/
	private String maktr;
	/**物料描述*/
	private String maktx;
	/**订单数量*/
	private Double bdmng;
	/**本次交货数量*/
	private Double menge;
	/**单位*/
	private String meins;
	/**计划提交日期*/
	private Long fxdate;
	/**质检标识*/
	private String inflg;
	/**创建人*/
	private String pname;
	/**创建时间*/
	private Long pdate;
	/**修改人*/
	private String mname;
	/**修改时间*/
	private Long mdate;
	/**行项目条码*/
	private String tm;
	/**是否选中*/
	private Boolean checked;
	/**活动号*/
	private String pvornr;

	public String getPvornr() {
		return pvornr;
	}

	public void setPvornr(String pvornr) {
		this.pvornr = pvornr;
	}

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

	public Long getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Long createDate) {
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

	public Long getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Long updateDate) {
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

	public String getPshwln() {
		return pshwln;
	}

	public void setPshwln(String pshwln) {
		this.pshwln = pshwln;
	}

	public String getPwerks() {
		return pwerks;
	}

	public void setPwerks(String pwerks) {
		this.pwerks = pwerks;
	}

	public String getPlifnr() {
		return plifnr;
	}

	public void setPlifnr(String plifnr) {
		this.plifnr = plifnr;
	}

	public String getPliftx() {
		return pliftx;
	}

	public void setPliftx(String pliftx) {
		this.pliftx = pliftx;
	}

	public String getPernam() {
		return pernam;
	}

	public void setPernam(String pernam) {
		this.pernam = pernam;
	}

	public String getPtype() {
		return ptype;
	}

	public void setPtype(String ptype) {
		this.ptype = ptype;
	}

	public String getPlgort() {
		return plgort;
	}

	public void setPlgort(String plgort) {
		this.plgort = plgort;
	}

	public String getPaufnr() {
		return paufnr;
	}

	public void setPaufnr(String paufnr) {
		this.paufnr = paufnr;
	}

	public String getPloggr() {
		return ploggr;
	}

	public void setPloggr(String ploggr) {
		this.ploggr = ploggr;
	}

	public String getPdupli() {
		return pdupli;
	}

	public void setPdupli(String pdupli) {
		this.pdupli = pdupli;
	}

	public String getPtm() {
		return ptm;
	}

	public void setPtm(String ptm) {
		this.ptm = ptm;
	}

	public String getShwlp() {
		return shwlp;
	}

	public void setShwlp(String shwlp) {
		this.shwlp = shwlp;
	}

	public String getEbeln() {
		return ebeln;
	}

	public void setEbeln(String ebeln) {
		this.ebeln = ebeln;
	}

	public String getEbelp() {
		return ebelp;
	}

	public void setEbelp(String ebelp) {
		this.ebelp = ebelp;
	}

	public String getPsptx() {
		return psptx;
	}

	public void setPsptx(String psptx) {
		this.psptx = psptx;
	}

	public String getMaktr() {
		return maktr;
	}

	public void setMaktr(String maktr) {
		this.maktr = maktr;
	}

	public String getMaktx() {
		return maktx;
	}

	public void setMaktx(String maktx) {
		this.maktx = maktx;
	}

	public Double getBdmng() {
		return bdmng;
	}

	public void setBdmng(Double bdmng) {
		this.bdmng = bdmng;
	}

	public Double getMenge() {
		return menge;
	}

	public void setMenge(Double menge) {
		this.menge = menge;
	}

	public String getMeins() {
		return meins;
	}

	public void setMeins(String meins) {
		this.meins = meins;
	}

	public Long getFxdate() {
		return fxdate;
	}

	public void setFxdate(Long fxdate) {
		this.fxdate = fxdate;
	}

	public String getInflg() {
		return inflg;
	}

	public void setInflg(String inflg) {
		this.inflg = inflg;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Long getPdate() {
		return pdate;
	}

	public void setPdate(Long pdate) {
		this.pdate = pdate;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public Long getMdate() {
		return mdate;
	}

	public void setMdate(Long mdate) {
		this.mdate = mdate;
	}

	public String getTm() {
		return tm;
	}

	public void setTm(String tm) {
		this.tm = tm;
	}
}
