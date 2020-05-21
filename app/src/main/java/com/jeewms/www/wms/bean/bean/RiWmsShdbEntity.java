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
	public Date getCreateDate(){
		return this.createDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建日期
	 */
	public void setCreateDate(Date createDate){
		this.createDate = createDate;
	}
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
	public Date getUpdateDate(){
		return this.updateDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  更新日期
	 */
	public void setUpdateDate(Date updateDate){
		this.updateDate = updateDate;
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
	 *@return: java.lang.String  采购订单
	 */
	public String getRkCgdd(){
		return this.rkCgdd;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  采购订单
	 */
	public void setRkCgdd(String rkCgdd){
		this.rkCgdd = rkCgdd;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  行项目
	 */
	public String getRkHxm(){
		return this.rkHxm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  行项目
	 */
	public void setRkHxm(String rkHxm){
		this.rkHxm = rkHxm;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  供应商编号
	 */
	public String getRkGysbh(){
		return this.rkGysbh;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  供应商编号
	 */
	public void setRkGysbh(String rkGysbh){
		this.rkGysbh = rkGysbh;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  供应商名称
	 */
	public String getRkGysmc(){
		return this.rkGysmc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  供应商名称
	 */
	public void setRkGysmc(String rkGysmc){
		this.rkGysmc = rkGysmc;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  用途描述
	 */
	public String getRkYtms(){
		return this.rkYtms;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用途描述
	 */
	public void setRkYtms(String rkYtms){
		this.rkYtms = rkYtms;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  送货地点
	 */
	public String getRkShdd(){
		return this.rkShdd;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  送货地点
	 */
	public void setRkShdd(String rkShdd){
		this.rkShdd = rkShdd;
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
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  收货日期
	 */
	public Date getRkShrq(){
		return this.rkShrq;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  收货日期
	 */
	public void setRkShrq(Date rkShrq){
		this.rkShrq = rkShrq;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收货人
	 */
	public String getRkShr(){
		return this.rkShr;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收货人
	 */
	public void setRkShr(String rkShr){
		this.rkShr = rkShr;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  溯源单据号
	 */
	public String getRkSydjh(){
		return this.rkSydjh;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  溯源单据号
	 */
	public void setRkSydjh(String rkSydjh){
		this.rkSydjh = rkSydjh;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  溯源单行项目
	 */
	public String getRkSydhxm(){
		return this.rkSydhxm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  溯源单行项目
	 */
	public void setRkSydhxm(String rkSydhxm){
		this.rkSydhxm = rkSydhxm;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  SAP状态
	 */
	public Integer getRkSapzz(){
		return this.rkSapzz;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  SAP状态
	 */
	public void setRkSapzz(Integer rkSapzz){
		this.rkSapzz = rkSapzz;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  SAP异常信息
	 */
	public String getRkSapycxx(){
		return this.rkSapycxx;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  SAP异常信息
	 */
	public void setRkSapycxx(String rkSapycxx){
		this.rkSapycxx = rkSapycxx;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  人工处理
	 */
	public Integer getRkRgcl(){
		return this.rkRgcl;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  人工处理
	 */
	public void setRkRgcl(Integer rkRgcl){
		this.rkRgcl = rkRgcl;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  处理时间
	 */
	public Date getRkClsj(){
		return this.rkClsj;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  处理时间
	 */
	public void setRkClsj(Date rkClsj){
		this.rkClsj = rkClsj;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  处理人
	 */
	public String getRkClr(){
		return this.rkClr;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  处理人
	 */
	public void setRkClr(String rkClr){
		this.rkClr = rkClr;
	}
}
