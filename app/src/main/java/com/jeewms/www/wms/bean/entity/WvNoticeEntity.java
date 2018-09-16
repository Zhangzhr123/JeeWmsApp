package com.jeewms.www.wms.bean.entity;

import java.util.Date;
import java.lang.String;
import java.lang.Double;


/**   
 * @Title: Entity
 * @Description: wv_notice
 * @author onlineGenerator
 * @date 2018-05-30 20:21:05
 * @version V1.0   
 *
 */

@SuppressWarnings("serial")
public class WvNoticeEntity  {
	/**主键*/
	private String id;
	/**进货通知单号*/

	private String noticeId;
	/**客户编码*/

	private String cusCode;
	/**中文全称*/

	private String zhongWenQch;
	/**单据状态*/

	private String imSta;
	/**商品编码*/

	private String goodsCode;
	/**shpMingCheng*/

	private String shpMingCheng;
	/**shpTiaoMa*/

	private String shpTiaoMa;
	/**cfWenCeng*/

	private String cfWenCeng;
	/**mpDanCeng*/

	private String mpDanCeng;
	/**mpCengGao*/

	private String mpCengGao;
	/**tiJiCm*/

	private String tiJiCm;
	/**数量*/

	private String goodsCount;
	/**goodsQmCount*/

	private String goodsQmCount;
	/**grCount*/

	private Double grCount;
	/**shlDanWei*/

	private String shlDanWei;
	/**体积*/

	private String goodsFvol;
	/**重量*/

	private String goodsWeight;
	/**lastgrdate*/

	private Date lastgrdate;
	/**preprodate*/

	private String preprodate;
	/**recDeg*/

	private String recDeg;
	
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
	 *@return: java.lang.String  进货通知单号
	 */

	public String getNoticeId(){
		return this.noticeId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  进货通知单号
	 */
	public void setNoticeId(String noticeId){
		this.noticeId = noticeId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  客户编码
	 */

	public String getCusCode(){
		return this.cusCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户编码
	 */
	public void setCusCode(String cusCode){
		this.cusCode = cusCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  中文全称
	 */

	public String getZhongWenQch(){
		return this.zhongWenQch;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  中文全称
	 */
	public void setZhongWenQch(String zhongWenQch){
		this.zhongWenQch = zhongWenQch;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  单据状态
	 */

	public String getImSta(){
		return this.imSta;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  单据状态
	 */
	public void setImSta(String imSta){
		this.imSta = imSta;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  商品编码
	 */

	public String getGoodsCode(){
		return this.goodsCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  商品编码
	 */
	public void setGoodsCode(String goodsCode){
		this.goodsCode = goodsCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  shpMingCheng
	 */

	public String getShpMingCheng(){
		return this.shpMingCheng;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  shpMingCheng
	 */
	public void setShpMingCheng(String shpMingCheng){
		this.shpMingCheng = shpMingCheng;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  shpTiaoMa
	 */

	public String getShpTiaoMa(){
		return this.shpTiaoMa;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  shpTiaoMa
	 */
	public void setShpTiaoMa(String shpTiaoMa){
		this.shpTiaoMa = shpTiaoMa;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  cfWenCeng
	 */

	public String getCfWenCeng(){
		return this.cfWenCeng;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  cfWenCeng
	 */
	public void setCfWenCeng(String cfWenCeng){
		this.cfWenCeng = cfWenCeng;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  mpDanCeng
	 */

	public String getMpDanCeng(){
		return this.mpDanCeng;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  mpDanCeng
	 */
	public void setMpDanCeng(String mpDanCeng){
		this.mpDanCeng = mpDanCeng;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  mpCengGao
	 */

	public String getMpCengGao(){
		return this.mpCengGao;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  mpCengGao
	 */
	public void setMpCengGao(String mpCengGao){
		this.mpCengGao = mpCengGao;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  tiJiCm
	 */

	public String getTiJiCm(){
		return this.tiJiCm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  tiJiCm
	 */
	public void setTiJiCm(String tiJiCm){
		this.tiJiCm = tiJiCm;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  数量
	 */

	public String getGoodsCount(){
		return this.goodsCount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  数量
	 */
	public void setGoodsCount(String goodsCount){
		this.goodsCount = goodsCount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  goodsQmCount
	 */

	public String getGoodsQmCount(){
		return this.goodsQmCount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  goodsQmCount
	 */
	public void setGoodsQmCount(String goodsQmCount){
		this.goodsQmCount = goodsQmCount;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  grCount
	 */

	public Double getGrCount(){
		return this.grCount;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  grCount
	 */
	public void setGrCount(Double grCount){
		this.grCount = grCount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  shlDanWei
	 */

	public String getShlDanWei(){
		return this.shlDanWei;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  shlDanWei
	 */
	public void setShlDanWei(String shlDanWei){
		this.shlDanWei = shlDanWei;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  体积
	 */

	public String getGoodsFvol(){
		return this.goodsFvol;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  体积
	 */
	public void setGoodsFvol(String goodsFvol){
		this.goodsFvol = goodsFvol;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  重量
	 */

	public String getGoodsWeight(){
		return this.goodsWeight;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  重量
	 */
	public void setGoodsWeight(String goodsWeight){
		this.goodsWeight = goodsWeight;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  lastgrdate
	 */

	public Date getLastgrdate(){
		return this.lastgrdate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  lastgrdate
	 */
	public void setLastgrdate(Date lastgrdate){
		this.lastgrdate = lastgrdate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  preprodate
	 */

	public String getPreprodate(){
		return this.preprodate;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  preprodate
	 */
	public void setPreprodate(String preprodate){
		this.preprodate = preprodate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  recDeg
	 */

	public String getRecDeg(){
		return this.recDeg;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  recDeg
	 */
	public void setRecDeg(String recDeg){
		this.recDeg = recDeg;
	}
}
