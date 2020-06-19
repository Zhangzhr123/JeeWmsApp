package com.jeewms.www.wms.bean.bean;
import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;


/**   
 * @Title: Entity
 * @Description: 物料信息
 * @author onlineGenerator
 * @date 2020-06-19 14:41:21
 * @version V1.0   
 *
 */
@SuppressWarnings("serial")
public class RkWmsScllEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**创建人登录名称*/
	private String createBy;
	/**更新人登录名称*/
	private String updateBy;
	/**所属部门*/
	private String sysOrgCode;
	/**所属公司*/
	private String sysCompanyCode;
	/**流程状态*/
	private String bpmStatus;
	/**WBS*/
	private String rkWbs;
	/**工厂*/
	private String rkGc;
	/**领料单编号*/
	private String rkLldbh;
	/**领料单行项目*/
	private String rkLldhxm;
	/**物料编码*/
	private String rkWlbm;
	/**物料描述*/
	private String rkWlms;
	/**库存地点*/
	private String rkKcdd;
	/**数量*/
	private Double rkSl;
	/**单位*/
	private String rkDw;
	/**库位*/
	private String rkKw;
	/**是否打印*/
	private String rkSfdy;
	/**备注*/
	private String rkBz;
	/**创建人*/
	private String createName;
	/**创建日期*/
	private Long createDate;
	/**修改人*/
	private String updateName;
	/**修改时间*/
	private Long updateDate;
	/**生产领料主表主键*/
	private String parentid;
	/**SAP状态*/
	private String sapzt;
	/**SAP异常信息*/
	private String sapycxx;
	/**投料数量*/
	private Double rkTlsl;
	/**扫描类型*/
	private String smtype;
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
	 *@return: java.lang.String  WBS
	 */
	
	public String getRkWbs(){
		return this.rkWbs;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  WBS
	 */
	public void setRkWbs(String rkWbs){
		this.rkWbs = rkWbs;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  工厂
	 */
	
	public String getRkGc(){
		return this.rkGc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  工厂
	 */
	public void setRkGc(String rkGc){
		this.rkGc = rkGc;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  领料单编号
	 */
	
	public String getRkLldbh(){
		return this.rkLldbh;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  领料单编号
	 */
	public void setRkLldbh(String rkLldbh){
		this.rkLldbh = rkLldbh;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  领料单行项目
	 */
	
	public String getRkLldhxm(){
		return this.rkLldhxm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  领料单行项目
	 */
	public void setRkLldhxm(String rkLldhxm){
		this.rkLldhxm = rkLldhxm;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  物料编码
	 */
	
	public String getRkWlbm(){
		return this.rkWlbm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  物料编码
	 */
	public void setRkWlbm(String rkWlbm){
		this.rkWlbm = rkWlbm;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  物料描述
	 */
	
	public String getRkWlms(){
		return this.rkWlms;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  物料描述
	 */
	public void setRkWlms(String rkWlms){
		this.rkWlms = rkWlms;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  库存地点
	 */
	
	public String getRkKcdd(){
		return this.rkKcdd;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  库存地点
	 */
	public void setRkKcdd(String rkKcdd){
		this.rkKcdd = rkKcdd;
	}
	
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  数量
	 */
	
	public Double getRkSl(){
		return this.rkSl;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  数量
	 */
	public void setRkSl(Double rkSl){
		this.rkSl = rkSl;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  单位
	 */
	
	public String getRkDw(){
		return this.rkDw;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  单位
	 */
	public void setRkDw(String rkDw){
		this.rkDw = rkDw;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  库位
	 */
	
	public String getRkKw(){
		return this.rkKw;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  库位
	 */
	public void setRkKw(String rkKw){
		this.rkKw = rkKw;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否打印
	 */
	
	public String getRkSfdy(){
		return this.rkSfdy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否打印
	 */
	public void setRkSfdy(String rkSfdy){
		this.rkSfdy = rkSfdy;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	
	public String getRkBz(){
		return this.rkBz;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setRkBz(String rkBz){
		this.rkBz = rkBz;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人
	 */
	
	public String getCreateName(){
		return this.createName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人
	 */
	public void setCreateName(String createName){
		this.createName = createName;
	}
	
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建日期
	 */
	
	public Long getCreateDate(){
		return this.createDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建日期
	 */
	public void setCreateDate(Long createDate){
		this.createDate = createDate;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  修改人
	 */
	
	public String getUpdateName(){
		return this.updateName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  修改人
	 */
	public void setUpdateName(String updateName){
		this.updateName = updateName;
	}
	
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  修改时间
	 */
	
	public Long getUpdateDate(){
		return this.updateDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  修改时间
	 */
	public void setUpdateDate(Long updateDate){
		this.updateDate = updateDate;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  生产领料主表主键
	 */
	
	public String getParentid(){
		return this.parentid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  生产领料主表主键
	 */
	public void setParentid(String parentid){
		this.parentid = parentid;
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
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  投料数量
	 */
	
	public Double getRkTlsl(){
		return this.rkTlsl;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  投料数量
	 */
	public void setRkTlsl(Double rkTlsl){
		this.rkTlsl = rkTlsl;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  扫描类型
	 */
	
	public String getSmtype(){
		return this.smtype;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  扫描类型
	 */
	public void setSmtype(String smtype){
		this.smtype = smtype;
	}
	
}
