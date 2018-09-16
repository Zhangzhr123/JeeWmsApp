package com.jeewms.www.wms.bean.entity;

import java.util.Date;
import java.lang.String;


/**   
 * @Title: Entity
 * @Description: 生成盘点单
 * @author onlineGenerator
 * @date 2017-09-08 22:26:27
 * @version V1.0   
 *
 */

@SuppressWarnings("serial")
public class WvStockEntity  {
	/**id*/
	private String id;
	
	/**创建人名称*/
	private String createName;
	/**创建人登录名称*/
	private String createBy;
	/**创建日期*/
	private Date createDate;
	private Date lastMove;
	/**库存类型*/
	private String kuctype;
	/**储位*/
	private String kuWeiBianMa;
	/**托盘*/
	private String binId;
	/**货主*/
	private String cusCode;
	/**货主名称*/
	private String zhongWenQch;
	/**商品编码*/
	private String goodsId;
	private String goodsCode;
	/**商品数量*/
	private Long goodsQua;
	/**商品名称*/
	private String shpMingCheng;
	/**生产日期*/
	private String goodsProData;
	/**保质期*/
	private String bzhiQi;
	/**单位*/
	private String goodsUnit;

	private String sttSta;

	private String moveSta;

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

	public Date getLastMove() {
		return lastMove;
	}

	public void setLastMove(Date lastMove) {
		this.lastMove = lastMove;
	}

	public String getKuctype() {
		return kuctype;
	}

	public void setKuctype(String kuctype) {
		this.kuctype = kuctype;
	}

	public String getKuWeiBianMa() {
		return kuWeiBianMa;
	}

	public void setKuWeiBianMa(String kuWeiBianMa) {
		this.kuWeiBianMa = kuWeiBianMa;
	}

	public String getBinId() {
		return binId;
	}

	public void setBinId(String binId) {
		this.binId = binId;
	}

	public String getCusCode() {
		return cusCode;
	}

	public void setCusCode(String cusCode) {
		this.cusCode = cusCode;
	}

	public String getZhongWenQch() {
		return zhongWenQch;
	}

	public void setZhongWenQch(String zhongWenQch) {
		this.zhongWenQch = zhongWenQch;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsCode() {
		return goodsCode;
	}

	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}

	public Long getGoodsQua() {
		return goodsQua;
	}

	public void setGoodsQua(Long goodsQua) {
		this.goodsQua = goodsQua;
	}

	public String getShpMingCheng() {
		return shpMingCheng;
	}

	public void setShpMingCheng(String shpMingCheng) {
		this.shpMingCheng = shpMingCheng;
	}

	public String getGoodsProData() {
		return goodsProData;
	}

	public void setGoodsProData(String goodsProData) {
		this.goodsProData = goodsProData;
	}

	public String getBzhiQi() {
		return bzhiQi;
	}

	public void setBzhiQi(String bzhiQi) {
		this.bzhiQi = bzhiQi;
	}

	public String getGoodsUnit() {
		return goodsUnit;
	}

	public void setGoodsUnit(String goodsUnit) {
		this.goodsUnit = goodsUnit;
	}

	public String getSttSta() {
		return sttSta;
	}

	public void setSttSta(String sttSta) {
		this.sttSta = sttSta;
	}

	public String getMoveSta() {
		return moveSta;
	}

	public void setMoveSta(String moveSta) {
		this.moveSta = moveSta;
	}
}
