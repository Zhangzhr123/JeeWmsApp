package com.jeewms.www.wms.constance;

import com.jeewms.www.wms.R;
import com.jeewms.www.wms.util.StringUtil;

/**
 * Created by zhangzr on 2020/5/20.
 */

public class Constance {

    //测试站http://119.23.251.167/wms/
    //public static String COMMON_URL = "http://172.16.77.184:8080";
    public static String COMMON_URL = "http://192.168.0.226:8060/rkwms";

    //主界面按钮图片
    public static final int[] btnImgList = {R.drawable.home1, R.drawable.home2, R.drawable.home3, R.drawable.home4, R.drawable.home5, R.drawable.home6, R.drawable.home7, R.drawable.home8, R.drawable.home9, R.drawable.home10, R.drawable.home11, R.drawable.home12};

    //主界面按钮名字
//    public static final String[] btnNameList = {"收货", "上架", "按单拣货", "装车复核", "储位转移", "盘点", "商品资料", "库存查询", "波次拣货", "波次下架复核", "波次分拣", "波次装车复核"};
    public static final String[] btnNameList = {"入库收货","投料收货", "按单拣货", "装车复核", "储位转移", "盘点"};


    public static void setBaseUrl(String baseUrl) {
        if (!StringUtil.isEmpty(baseUrl)) {
            COMMON_URL = baseUrl;
        }
    }

    //登录
    public static final String LOGIN = "/rest/tokens/login";
    //获取SAP送货单数据
    public static final String getZrfcGetShw = "/rest/sAPAppService/getZrfcGetShw";
    //发送收货单
    public static final String getZrfcMigoPost = "/rest/sAPAppService/getZrfcMigoPost";
    //发送收货投料单
    public static final String getZrfcShwMgtl = "/rest/sAPAppService/getZrfcShwMgtl";
    //下载
    public static final String download = "/rest/file/download";
    //获取SAP出库单
    public static final String getCKD = "/rest/sAPAppService/getCKD";
    //发送出库单
    public static final String saveCKDshrk = "/rest/sAPAppService/saveCKDshrk";
    //发送出库投料单
    public static final String saveCKDshtl = "/rest/sAPAppService/saveCKDshtl";

    //原生接口
    //按货捡单
    public static final String GINOTICE = "/rest/wvGiNoticeController";
    //保存捡单
    public static final String SAVEGINOTICE = "/rest/wmToDownGoodsController";
    //获取按货捡单列表
    public static final String QUERYWV = "/xys/xys/queryWv_gi_notice_head";
    //收货                                       rest/wmInQmIController
    public static final String NoticeController = "/rest/wvNoticeController";
    public static final String InQmIController = "/rest/wmInQmIController";
    public static final String ToMoveGoodsController = "/rest/wmToMoveGoodsController";
    public static final String SttInGoodsController = "/rest/wmSttInGoodsController";
    public static final String GoodsController = "/rest/mdGoodsController";
    public static final String wvGiController = "/rest/wvGiController";
    public static final String StockController = "/rest/wvStockController";
    //保存上架
    public static final String wmToUpGoodsController = "/rest/wmToUpGoodsController";
    public static final String wmInQmIController = "/rest/wmInQmIController";
    //盘点保存
    public static final String wmSttInGoodsControllerc = "/rest/wmSttInGoodsController/change";
    //装车复核保存
    public static final String wmToDownGoodsControllerc = "/rest/wmToDownGoodsController/change";
    //商品信息保存
    public static final String mdGoodsControllerc = "/rest/mdGoodsController/change";
    //商品下单
    public static final String mdGoodsControllercorder = "/rest/mdGoodsController/order";
    //移储保存
    public static final String wmToMoveGoodsControllerc = "/rest/wmToMoveGoodsController/change";
    //镭射清单
    public static final String tSapLsqdController = "/rest/tSapLsqdController";
    //库存清单
    public static final String tSapStockController = "/rest/tSapStockController";
    //库存清单
    public static final String tSapLtttController = "/rest/tSapLtttController";

    //登录
    public static String getLoginURL() {
        return COMMON_URL + LOGIN;
    }

    //获取简单详情
    public static String getGiNoticeURL() {
        return COMMON_URL + GINOTICE;
    } //登录

    public static String getSaveginoticeURL() {
        return COMMON_URL + SAVEGINOTICE;
    }

    public static String getNoticeControllerURL() {
        return COMMON_URL + NoticeController;
    }

    public static String getInQmIControllerURL() {
        return COMMON_URL + InQmIController;
    }

    public static String getToMoveGoodsControllerURL() {
        return COMMON_URL + ToMoveGoodsController;
    }

    public static String getSttInGoodsControllerURL() {
        return COMMON_URL + SttInGoodsController;
    }

    public static String getGoodsControllerURL() {
        return COMMON_URL + GoodsController;
    }

    public static String getStockControllerURL() {
        return COMMON_URL + StockController;
    }

    public static String getWmToUpGoodsControllerURL() {
        return COMMON_URL + wmToUpGoodsController;
    }

    public static String getWmInQmIControllerURL() {
        return COMMON_URL + wmInQmIController;
    }

    public static String getwvGiControllerURL() {
        return COMMON_URL + wvGiController;
    }

    public static String getwmToDownGoodsControllercURL() {
        return COMMON_URL + wmToDownGoodsControllerc;
    }

    public static String getwmSttInGoodsControllercURL() {
        return COMMON_URL + wmSttInGoodsControllerc;
    }

    public static String getmdGoodsControllercURL() {
        return COMMON_URL + mdGoodsControllerc;
    }

    public static String getmdGoodsControllerorderURL() {
        return COMMON_URL + mdGoodsControllercorder;
    }

    public static String getwmToMoveGoodsControllercURL() {
        return COMMON_URL + wmToMoveGoodsControllerc;
    }

    public static String gettSapLsqdControllerURL() {
        return COMMON_URL + tSapLsqdController;
    }

    public static String gettSapStockControllerURL() {
        return COMMON_URL + tSapStockController;
    }

    public static String gettSapLtttControllerURL() {
        return COMMON_URL + tSapLtttController;
    }

    public static class SHAREP {
        /**
         * SharedPreferences
         */
        public static final String SHAREDSAVE = "save";
        //版本
        public static final String VERSION = "version";

        //登录名
        public static final String LOGINNAME = "userName";
        //登录密码
        public static final String PASSWORD = "passWord";
        //地址
        public static final String HTTPADDRESS = "httpAddress";
        //用户名
        public static final String USERNAME = "realName";
        //部门
        public static final String DEPT = "dept";
        //公司
        public static final String COMPANY = "company";

    }
}
