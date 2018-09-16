package com.jeewms.www.wms.bean.entity;

import java.util.Date;
import java.lang.String;


/**   
 * @Title: Entity
 * @Description: 收货登记
 * @author onlineGenerator
 * @date 2017-09-11 15:08:53
 * @version V1.0   
 *
 */


public class WmInQmIEntity {
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
	/**到货通知单*/

	private String imNoticeId;
	/**到货通知行项目*/

	private String imNoticeItem;
	/**商品编码*/

	private String goodsId;

	private String goodsName;
	/**到货数量*/

	private String imQuat;
	/**收货数量*/

	private String qmOkQuat;
	/**备注*/

	private String itemText;
	/**生产日期*/

	private String proData;
	/**托盘*/

	private String tinId;
	/**单位*/

	private String goodsUnit;
	/**批次*/

	private String goodsBatch;
	/**仓位*/

	private String binId;
	/**体积*/

	private String tinTj;
	/**重量*/

	private String tinZhl;
	/**是否已上架*/

	private String binSta;
	/**货主*/

	private String cusCode;

	private String cusName;
	/**温度*/

	private String recDeg;
	/**基本单位*/

	private String baseUnit;
	/**基本单位数量*/

	private String baseGoodscount;
	/**基本单位收货数量*/
//	@Excel(name="基本单位收货数量")
	private String baseQmcount;
	
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
	 *@return: java.lang.String  到货通知单
	 */

	public String getImNoticeId(){
		return this.imNoticeId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  到货通知单
	 */
	public void setImNoticeId(String imNoticeId){
		this.imNoticeId = imNoticeId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  到货通知行项目
	 */

	public String getImNoticeItem(){
		return this.imNoticeItem;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  到货通知行项目
	 */
	public void setImNoticeItem(String imNoticeItem){
		this.imNoticeItem = imNoticeItem;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  商品编码
	 */

	public String getGoodsId(){
		return this.goodsId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  商品编码
	 */
	public void setGoodsId(String goodsId){
		this.goodsId = goodsId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  到货数量
	 */

	public String getImQuat(){
		return this.imQuat;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  到货数量
	 */
	public void setImQuat(String imQuat){
		this.imQuat = imQuat;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收货数量
	 */

	public String getQmOkQuat(){
		return this.qmOkQuat;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收货数量
	 */
	public void setQmOkQuat(String qmOkQuat){
		this.qmOkQuat = qmOkQuat;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */

	public String getItemText(){
		return this.itemText;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setItemText(String itemText){
		this.itemText = itemText;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  生产日期
	 */

	public String getProData(){
		return this.proData;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  生产日期
	 */
	public void setProData(String proData){
		this.proData = proData;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  托盘
	 */

	public String getTinId(){
		return this.tinId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  托盘
	 */
	public void setTinId(String tinId){
		this.tinId = tinId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  单位
	 */

	public String getGoodsUnit(){
		return this.goodsUnit;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  单位
	 */
	public void setGoodsUnit(String goodsUnit){
		this.goodsUnit = goodsUnit;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  批次
	 */

	public String getGoodsBatch(){
		return this.goodsBatch;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  批次
	 */
	public void setGoodsBatch(String goodsBatch){
		this.goodsBatch = goodsBatch;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  仓位
	 */

	public String getBinId(){
		return this.binId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  仓位
	 */
	public void setBinId(String binId){
		this.binId = binId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  体积
	 */

	public String getTinTj(){
		return this.tinTj;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  体积
	 */
	public void setTinTj(String tinTj){
		this.tinTj = tinTj;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  重量
	 */

	public String getTinZhl(){
		return this.tinZhl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  重量
	 */
	public void setTinZhl(String tinZhl){
		this.tinZhl = tinZhl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否已上架
	 */

	public String getBinSta(){
		return this.binSta;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否已上架
	 */
	public void setBinSta(String binSta){
		this.binSta = binSta;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  货主
	 */

	public String getCusCode(){
		return this.cusCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  货主
	 */
	public void setCusCode(String cusCode){
		this.cusCode = cusCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  温度
	 */

	public String getRecDeg(){
		return this.recDeg;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  温度
	 */
	public void setRecDeg(String recDeg){
		this.recDeg = recDeg;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  基本单位
	 */

	public String getBaseUnit(){
		return this.baseUnit;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  基本单位
	 */
	public void setBaseUnit(String baseUnit){
		this.baseUnit = baseUnit;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  基本单位数量
	 */

	public String getBaseGoodscount(){
		return this.baseGoodscount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  基本单位数量
	 */
	public void setBaseGoodscount(String baseGoodscount){
		this.baseGoodscount = baseGoodscount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  基本单位收货数量
	 */

	public String getBaseQmcount(){
		return this.baseQmcount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  基本单位收货数量
	 */
	public void setBaseQmcount(String baseQmcount){
		this.baseQmcount = baseQmcount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  货主名称
	 */

	public String getCusName(){
		return this.cusName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  货主名称
	 */
	public void setCusName(String cusName){
		this.cusName = cusName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  商品名称
	 */

	public String getGoodsName(){
		return this.goodsName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  商品名称
	 */
	public void setGoodsName(String goodsName){
		this.goodsName = goodsName;
	}
	
	
}
