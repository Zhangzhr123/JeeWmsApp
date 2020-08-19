package com.jeewms.www.wms.bean.bean;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;

/**   
 * @Title: Entity
 * @Description: 出库单
 * @author onlineGenerator
 * @date 2020-06-19 14:02:33
 * @version V1.0   
 *
 */
@SuppressWarnings("serial")
public class RkWmsCkdbEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**创建人名称*/
	private String createName;
	/**创建人登录名称*/
	private String createBy;
	/**创建日期*/
//	private Date createDate;
	/**更新人名称*/
	private String updateName;
	/**更新人登录名称*/
	private String updateBy;
	/**更新日期*/
//	private Date updateDate;
	/**所属部门*/
	private String sysOrgCode;
	/**所属公司*/
	private String sysCompanyCode;
	/**流程状态*/
	private String bpmStatus;
	/**出库单号*/
	private String ntnum;
	/**出库单行项目*/
	private String vbeln;
	/**申请类型*/
	private String stype;
	/**申请类型描述*/
	private String stype1;
	/**采购凭证号 */
	private String ebeln;
	/**采购凭证的项目编号 */
	private String ebelp;
	/**预留_相关需求的编号*/
	private String rsnum;
	/**预留_相关需求的项目编号*/
	private String rspos;
	/**订单号*/
	private String aufnr;
	/**操作_活动编号*/
	private String vornr;
	/**销售凭证 */
	private String vbeknVa;
	/**销售凭证项目 */
	private String posnrVa;
	/**WBS 要素*/
	private String pspel;
	/**批次号*/
	private String pici;
	/**物料号*/
	private String matnr;
	/**物料描述*/
	private String maktx;
	/**工厂*/
	private String werks;
	/**特殊库存标识*/
	private String sobz;
	/**转储订单凭证号*/
	private String eblnu;
	/**转储订单项目编号*/
	private String eblpu;
	/**匹配数量*/
	private Double ppmen;
	/**库存地点*/
	private String lgort;
	/**转储单的供应发出工厂*/
	private String reswk;
	/**SAP状态*/
	private String sapzt;
	/**SAP异常信息*/
	private String sapycxx;
	/**接收类型*/
	private String smtype;
	/**pvornr*/
	private String pvornr;
	/**行项目id*/
	private String ind;
	/**是否选中*/
	private Boolean checked;
	/**交货数量*/
	private Double jhsl;

	public Double getJhsl() {
		return jhsl;
	}

	public void setJhsl(Double jhsl) {
		this.jhsl = jhsl;
	}

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}


	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
	public String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主键
	 */
	public void setId(String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人名称
	 */
	public String getCreateName(){
		return this.createName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人名称
	 */
	public void setCreateName(String createName){
		this.createName = createName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人登录名称
	 */
	public String getCreateBy(){
		return this.createBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人登录名称
	 */
	public void setCreateBy(String createBy){
		this.createBy = createBy;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建日期
	 */
//	public Date getCreateDate(){
//		return this.createDate;
//	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建日期
	 */
//	public void setCreateDate(Date createDate){
//		this.createDate = createDate;
//	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人名称
	 */
	public String getUpdateName(){
		return this.updateName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人名称
	 */
	public void setUpdateName(String updateName){
		this.updateName = updateName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人登录名称
	 */
	public String getUpdateBy(){
		return this.updateBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人登录名称
	 */
	public void setUpdateBy(String updateBy){
		this.updateBy = updateBy;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  更新日期
	 */
//	public Date getUpdateDate(){
//		return this.updateDate;
//	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  更新日期
	 */
//	public void setUpdateDate(Date updateDate){
//		this.updateDate = updateDate;
//	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所属部门
	 */
	public String getSysOrgCode(){
		return this.sysOrgCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所属部门
	 */
	public void setSysOrgCode(String sysOrgCode){
		this.sysOrgCode = sysOrgCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所属公司
	 */
	public String getSysCompanyCode(){
		return this.sysCompanyCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所属公司
	 */
	public void setSysCompanyCode(String sysCompanyCode){
		this.sysCompanyCode = sysCompanyCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  流程状态
	 */
	public String getBpmStatus(){
		return this.bpmStatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  流程状态
	 */
	public void setBpmStatus(String bpmStatus){
		this.bpmStatus = bpmStatus;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  出库单号
	 */
	public String getNtnum(){
		return this.ntnum;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  出库单号
	 */
	public void setNtnum(String ntnum){
		this.ntnum = ntnum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  出库单行项目
	 */
	public String getVbeln(){
		return this.vbeln;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  出库单行项目
	 */
	public void setVbeln(String vbeln){
		this.vbeln = vbeln;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  申请类型
	 */
	public String getStype(){
		return this.stype;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  申请类型
	 */
	public void setStype(String stype){
		this.stype = stype;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  申请类型描述
	 */
	public String getStype1(){
		return this.stype1;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  申请类型描述
	 */
	public void setStype1(String stype1){
		this.stype1 = stype1;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  采购凭证号 
	 */
	public String getEbeln(){
		return this.ebeln;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  采购凭证号 
	 */
	public void setEbeln(String ebeln){
		this.ebeln = ebeln;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  采购凭证的项目编号 
	 */
	public String getEbelp(){
		return this.ebelp;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  采购凭证的项目编号 
	 */
	public void setEbelp(String ebelp){
		this.ebelp = ebelp;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  预留_相关需求的编号
	 */
	public String getRsnum(){
		return this.rsnum;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  预留_相关需求的编号
	 */
	public void setRsnum(String rsnum){
		this.rsnum = rsnum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  预留_相关需求的项目编号
	 */
	public String getRspos(){
		return this.rspos;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  预留_相关需求的项目编号
	 */
	public void setRspos(String rspos){
		this.rspos = rspos;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  订单号
	 */
	public String getAufnr(){
		return this.aufnr;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  订单号
	 */
	public void setAufnr(String aufnr){
		this.aufnr = aufnr;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  操作_活动编号
	 */
	public String getVornr(){
		return this.vornr;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  操作_活动编号
	 */
	public void setVornr(String vornr){
		this.vornr = vornr;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  销售凭证 
	 */
	public String getVbeknVa(){
		return this.vbeknVa;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  销售凭证 
	 */
	public void setVbeknVa(String vbeknVa){
		this.vbeknVa = vbeknVa;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  销售凭证项目 
	 */
	public String getPosnrVa(){
		return this.posnrVa;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  销售凭证项目 
	 */
	public void setPosnrVa(String posnrVa){
		this.posnrVa = posnrVa;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  WBS 要素
	 */
	public String getPspel(){
		return this.pspel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  WBS 要素
	 */
	public void setPspel(String pspel){
		this.pspel = pspel;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  批次号
	 */
	public String getPici(){
		return this.pici;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  批次号
	 */
	public void setPici(String pici){
		this.pici = pici;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  物料号
	 */
	public String getMatnr(){
		return this.matnr;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  物料号
	 */
	public void setMatnr(String matnr){
		this.matnr = matnr;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  物料描述
	 */
	public String getMaktx(){
		return this.maktx;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  物料描述
	 */
	public void setMaktx(String maktx){
		this.maktx = maktx;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  工厂
	 */
	public String getWerks(){
		return this.werks;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  工厂
	 */
	public void setWerks(String werks){
		this.werks = werks;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  特殊库存标识
	 */
	public String getSobz(){
		return this.sobz;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  特殊库存标识
	 */
	public void setSobz(String sobz){
		this.sobz = sobz;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  转储订单凭证号
	 */
	public String getEblnu(){
		return this.eblnu;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  转储订单凭证号
	 */
	public void setEblnu(String eblnu){
		this.eblnu = eblnu;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  转储订单项目编号
	 */
	public String getEblpu(){
		return this.eblpu;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  转储订单项目编号
	 */
	public void setEblpu(String eblpu){
		this.eblpu = eblpu;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  匹配数量
	 */
	public Double getPpmen(){
		return this.ppmen;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  匹配数量
	 */
	public void setPpmen(Double ppmen){
		this.ppmen = ppmen;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  库存地点
	 */
	public String getLgort(){
		return this.lgort;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  库存地点
	 */
	public void setLgort(String lgort){
		this.lgort = lgort;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  转储单的供应发出工厂
	 */
	public String getReswk(){
		return this.reswk;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  转储单的供应发出工厂
	 */
	public void setReswk(String reswk){
		this.reswk = reswk;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  SAP状态
	 */
	public String getSapzt(){
		return this.sapzt;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  SAP状态
	 */
	public void setSapzt(String sapzt){
		this.sapzt = sapzt;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  SAP异常信息
	 */
	public String getSapycxx(){
		return this.sapycxx;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  SAP异常信息
	 */
	public void setSapycxx(String sapycxx){
		this.sapycxx = sapycxx;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  接收类型
	 */
	public String getSmtype(){
		return this.smtype;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  接收类型
	 */
	public void setSmtype(String smtype){
		this.smtype = smtype;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  pvornr
	 */
	public String getPvornr(){
		return this.pvornr;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  pvornr
	 */
	public void setPvornr(String pvornr){
		this.pvornr = pvornr;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  行项目id
	 */
	public String getInd(){
		return this.ind;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  行项目id
	 */
	public void setInd(String ind){
		this.ind = ind;
	}
}
