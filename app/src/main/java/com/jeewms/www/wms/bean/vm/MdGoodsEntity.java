package com.jeewms.www.wms.bean.vm;

import java.util.Date;
import java.lang.String;


/**   
 * @Title: Entity
 * @Description: 商品信息
 * @author onlineGenerator
 * @date 2017-08-15 23:16:53
 * @version V1.0   
 *
 */

@SuppressWarnings("serial")
public class MdGoodsEntity  {
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
	/**所属客户*/

	private String suoShuKeHu;
	/**商品名称*/

	private String shpMingCheng;
	/**商品简称*/
	private String shpJianCheng;
	/**商品编码*/

	private String shpBianMa;

	private String shpBianMakh;
	/**商品型号*/
	private String shpXingHao;
	/**商品规格*/
	private String shpGuiGe;
	/**商品颜色*/
	private String shpYanSe;
	/**产品属性*/

	private String chpShuXing;
	/**存放温层*/

	private String cfWenCeng;
	/**拆零控制*/

	private String chlKongZhi;
	/**码盘单层数量*/

	private String mpDanCeng;
	/**码盘层高*/

	private String mpCengGao;
	/**计费商品类*/

	private String jfShpLei;
	/**商品品牌*/
	private String shpPinPai;
	/**商品条码*/

	private String shpTiaoMa;
	/**品牌图片*/
	private String ppTuPian;
	/**保质期*/

	private String bzhiQi;
	/**单位*/

	private String shlDanWei;
	/**拆零单位*/

	private String jshDanWei;
	/**体积*/

	private String tiJiCm;
	/**重量*/

	private String zhlKg;
	/**重量*/

	private String zhlKgm;
	/**拆零数量*/

	private String chlShl;
	/**件数与体积比*/
	private String jtiJiBi;
	/**件数与毛重比*/
	private String jmZhongBi;
	/**件数与净重比*/
	private String jjZhongBi;
	/**尺寸单位*/
	private String chcDanWei;
	/**长单品*/
	private String chDanPin;
	/**宽单品*/
	private String kuDanPin;
	/**高单品*/
	private String gaoDanPin;
	/**长整箱*/

	private String chZhXiang;
	/**宽整箱*/

	private String kuZhXiang;
	/**高整箱*/

	private String gaoZhXiang;

	private String jiZhunwendu;
	/**商品描述*/
	private String shpMiaoShu;
	/**停用*/
	private String zhuangTai;
	
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
	 *@return: java.lang.String  所属客户
	 */

	public String getSuoShuKeHu(){
		return this.suoShuKeHu;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所属客户
	 */
	public void setSuoShuKeHu(String suoShuKeHu){
		this.suoShuKeHu = suoShuKeHu;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  商品名称
	 */

	public String getShpMingCheng(){
		return this.shpMingCheng;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  商品名称
	 */
	public void setShpMingCheng(String shpMingCheng){
		this.shpMingCheng = shpMingCheng;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  商品简称
	 */

	public String getShpJianCheng(){
		return this.shpJianCheng;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  商品简称
	 */
	public void setShpJianCheng(String shpJianCheng){
		this.shpJianCheng = shpJianCheng;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  商品编码
	 */

	public String getShpBianMa(){
		return this.shpBianMa;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  商品编码
	 */
	public void setShpBianMa(String shpBianMa){
		this.shpBianMa = shpBianMa;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  商品编码
	 */

	public String getShpBianMakh(){
		return this.shpBianMakh;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  商品编码
	 */
	public void setShpBianMakh(String shpBianMakh){
		this.shpBianMakh = shpBianMakh;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  商品型号
	 */

	public String getShpXingHao(){
		return this.shpXingHao;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  商品型号
	 */
	public void setShpXingHao(String shpXingHao){
		this.shpXingHao = shpXingHao;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  商品规格
	 */

	public String getShpGuiGe(){
		return this.shpGuiGe;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  商品规格
	 */
	public void setShpGuiGe(String shpGuiGe){
		this.shpGuiGe = shpGuiGe;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  商品颜色
	 */

	public String getShpYanSe(){
		return this.shpYanSe;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  商品颜色
	 */
	public void setShpYanSe(String shpYanSe){
		this.shpYanSe = shpYanSe;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  产品属性
	 */

	public String getChpShuXing(){
		return this.chpShuXing;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  产品属性
	 */
	public void setChpShuXing(String chpShuXing){
		this.chpShuXing = chpShuXing;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  存放温层
	 */

	public String getCfWenCeng(){
		return this.cfWenCeng;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  存放温层
	 */
	public void setCfWenCeng(String cfWenCeng){
		this.cfWenCeng = cfWenCeng;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  拆零控制
	 */

	public String getChlKongZhi(){
		return this.chlKongZhi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  拆零控制
	 */
	public void setChlKongZhi(String chlKongZhi){
		this.chlKongZhi = chlKongZhi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  码盘单层数量
	 */

	public String getMpDanCeng(){
		return this.mpDanCeng;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  码盘单层数量
	 */
	public void setMpDanCeng(String mpDanCeng){
		this.mpDanCeng = mpDanCeng;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  码盘层高
	 */

	public String getMpCengGao(){
		return this.mpCengGao;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  码盘层高
	 */
	public void setMpCengGao(String mpCengGao){
		this.mpCengGao = mpCengGao;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  计费商品类
	 */

	public String getJfShpLei(){
		return this.jfShpLei;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  计费商品类
	 */
	public void setJfShpLei(String jfShpLei){
		this.jfShpLei = jfShpLei;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  商品品牌
	 */

	public String getShpPinPai(){
		return this.shpPinPai;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  商品品牌
	 */
	public void setShpPinPai(String shpPinPai){
		this.shpPinPai = shpPinPai;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  商品条码
	 */

	public String getShpTiaoMa(){
		return this.shpTiaoMa;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  商品条码
	 */
	public void setShpTiaoMa(String shpTiaoMa){
		this.shpTiaoMa = shpTiaoMa;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  品牌图片
	 */

	public String getPpTuPian(){
		return this.ppTuPian;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  品牌图片
	 */
	public void setPpTuPian(String ppTuPian){
		this.ppTuPian = ppTuPian;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  保质期
	 */

	public String getBzhiQi(){
		return this.bzhiQi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  保质期
	 */
	public void setBzhiQi(String bzhiQi){
		this.bzhiQi = bzhiQi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  单位
	 */

	public String getShlDanWei(){
		return this.shlDanWei;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  单位
	 */
	public void setShlDanWei(String shlDanWei){
		this.shlDanWei = shlDanWei;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  拆零单位
	 */

	public String getJshDanWei(){
		return this.jshDanWei;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  拆零单位
	 */
	public void setJshDanWei(String jshDanWei){
		this.jshDanWei = jshDanWei;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  体积
	 */

	public String getTiJiCm(){
		return this.tiJiCm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  体积
	 */
	public void setTiJiCm(String tiJiCm){
		this.tiJiCm = tiJiCm;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  重量
	 */

	public String getZhlKg(){
		return this.zhlKg;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  重量
	 */
	public void setZhlKgm(String zhlKgm){
		this.zhlKgm = zhlKgm;
	}

	public String getZhlKgm(){
		return this.zhlKgm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  重量
	 */
	public void setZhlKg(String zhlKg){
		this.zhlKg = zhlKg;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  拆零数量
	 */

	public String getChlShl(){
		return this.chlShl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  拆零数量
	 */
	public void setChlShl(String chlShl){
		this.chlShl = chlShl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  件数与体积比
	 */

	public String getJtiJiBi(){
		return this.jtiJiBi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  件数与体积比
	 */
	public void setJtiJiBi(String jtiJiBi){
		this.jtiJiBi = jtiJiBi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  件数与毛重比
	 */

	public String getJmZhongBi(){
		return this.jmZhongBi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  件数与毛重比
	 */
	public void setJmZhongBi(String jmZhongBi){
		this.jmZhongBi = jmZhongBi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  件数与净重比
	 */

	public String getJjZhongBi(){
		return this.jjZhongBi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  件数与净重比
	 */
	public void setJjZhongBi(String jjZhongBi){
		this.jjZhongBi = jjZhongBi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  尺寸单位
	 */

	public String getChcDanWei(){
		return this.chcDanWei;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  尺寸单位
	 */
	public void setChcDanWei(String chcDanWei){
		this.chcDanWei = chcDanWei;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  长单品
	 */

	public String getChDanPin(){
		return this.chDanPin;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  长单品
	 */
	public void setChDanPin(String chDanPin){
		this.chDanPin = chDanPin;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  宽单品
	 */

	public String getKuDanPin(){
		return this.kuDanPin;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  宽单品
	 */
	public void setKuDanPin(String kuDanPin){
		this.kuDanPin = kuDanPin;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  高单品
	 */

	public String getGaoDanPin(){
		return this.gaoDanPin;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  高单品
	 */
	public void setGaoDanPin(String gaoDanPin){
		this.gaoDanPin = gaoDanPin;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  长整箱
	 */

	public String getChZhXiang(){
		return this.chZhXiang;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  长整箱
	 */
	public void setChZhXiang(String chZhXiang){
		this.chZhXiang = chZhXiang;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  宽整箱
	 */

	public String getKuZhXiang(){
		return this.kuZhXiang;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  宽整箱
	 */
	public void setKuZhXiang(String kuZhXiang){
		this.kuZhXiang = kuZhXiang;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  高整箱
	 */

	public String getGaoZhXiang(){
		return this.gaoZhXiang;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  高整箱
	 */
	public void setGaoZhXiang(String gaoZhXiang){
		this.gaoZhXiang = gaoZhXiang;
	}
	

	public String getJiZhunwendu(){
		return this.jiZhunwendu;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  高整箱
	 */
	public void setJiZhunwendu(String jiZhunwendu){
		this.jiZhunwendu = jiZhunwendu;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  商品描述
	 */
	public String getShpMiaoShu(){
		return this.shpMiaoShu;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  商品描述
	 */
	public void setShpMiaoShu(String shpMiaoShu){
		this.shpMiaoShu = shpMiaoShu;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  停用
	 */
	public String getZhuangTai(){
		return this.zhuangTai;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  停用
	 */
	public void setZhuangTai(String zhuangTai){
		this.zhuangTai = zhuangTai;
	}
}
