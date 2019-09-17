package com.jeewms.www.wms.ui.itemview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.jeewms.www.wms.R;
import com.jeewms.www.wms.bean.vm.CollectGoodsVm;
import com.jeewms.www.wms.bean.vm.PickingSaveVm;
import com.jeewms.www.wms.constance.Constance;
import com.jeewms.www.wms.util.CheckUtil;
import com.jeewms.www.wms.util.GsonUtils;
import com.jeewms.www.wms.util.LoadingUtil;
import com.jeewms.www.wms.util.Logutil;
import com.jeewms.www.wms.util.SharedPreferencesUtil;
import com.jeewms.www.wms.util.StringUtil;
import com.jeewms.www.wms.util.ToastUtil;
import com.jeewms.www.wms.util.UUIDUtil;
import com.jeewms.www.wms.volley.HTTPUtils;
import com.jeewms.www.wms.volley.VolleyListener;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 13799 on 2018/6/7.
 */

public class CollectGoodsItemView {

    View mView;
    ViewHolder holder;
    private List<CollectGoodsVm> obj;
    Context mContext;
    PickingDetailListent listenter;
    int position;
    private String ptr1="";
    private String ptr2="";
    private String ptr3="";
    private String ptr4="";
    private String ptr5="";
    private String saveon="";
    public void setListenter(PickingDetailListent listenter) {
        this.listenter = listenter;
    }

    public void setCollectGoodsList(List<CollectGoodsVm> obj) {
        this.obj = obj;
    }

    private int selectedEditTextPosition = -1;

    public CollectGoodsItemView(Context context) {
        mContext = context;
        mView = LayoutInflater.from(context).inflate(R.layout.item_collectgoods, null);
        holder = new ViewHolder(mView);

    }

    public View getView() {
        if (selectedEditTextPosition != -1 && selectedEditTextPosition == position) {
            holder.tvShouhuoshuliang.requestFocus();
            holder.tvShouhuoshuliang.setSelection(holder.tvShouhuoshuliang.getText().toString().length());
        }
        return mView;
    }

    public void bind(final CollectGoodsVm vm, final int position) {
        this.position = position;
        holder.tvZhongWenQch.setText(vm.getZhongWenQch());
        holder.tvShouhuotongzhi.setText(vm.getNoticeId());
        holder.tvTihi.setText(vm.getMpDanCeng() + "*" + vm.getMpCengGao());
        holder.tvShouhuoshuliang.setText(vm.getGrCount());
        if (StringUtil.isEmpty(vm.getGrCount()))
            holder.tvShouhuoshuliang.setText("");
        else {
            try{
                int shulian = Integer.valueOf(vm.getMpDanCeng()) * Integer.valueOf(vm.getMpCengGao());

                int shul = Integer.parseInt(vm.getGrCount());
                if(shul <= shulian){
                    holder.tvShouhuoshuliang.setText(vm.getGrCount());
                }else{
                    holder.tvShouhuoshuliang.setText(Integer.toString(shulian));
                }
            }catch (Exception e){
            }
        }
        holder.tvShengchanriqi.setText(vm.getPreprodate());
//        holder.tvShouhuowendu.setText(vm.getRecDeg());
        if (vm.getTvTinId2() != null) ;
        holder.tvTinId2.setText(vm.getTvTinId2());
//        if (StringUtil.isEmpty(vm.getType()))
//            holder.tvKucunleixing.setText("");
//        else {
//            holder.tvKucunleixing.setText(vm.getShpTiaoMa());
//        }
        holder.tvShengchanriqi.setText(StringUtil.getdata());
        holder.tvShpMingCheng.setText(vm.getShpMingCheng());
        holder.tvYuqishuliang.setText(vm.getGoodsCount());
        holder.tvYishoushuliang.setText(vm.getGoodsQmCount());
        holder.tvDanwei.setText(vm.getShlDanWei());
        holder.tvShouhuoshuliang.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!StringUtil.isEmpty(ptr1)){
                    if(!b&&ptr1.equals(holder.tvShouhuoshuliang.getText().toString())) {
                        ptr1=holder.tvShouhuoshuliang.getText().toString();
                        saveVm(position, holder);
                    }
                }


            }
        });
        holder.tvShengchanriqi.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!StringUtil.isEmpty(ptr2)) {
                    if (!b && ptr2.equals(holder.tvShengchanriqi.getText().toString())) {
                        ptr2 = holder.tvShengchanriqi.getText().toString();
                        saveVm(position, holder);
                    }
                }
            }
        });
//        holder.tvShouhuowendu.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View view, boolean b) {
//                if(!b&&ptr3.equals(holder.tvShouhuowendu.getText().toString())) {
//                    ptr3=holder.tvShouhuowendu.getText().toString();
//                    saveVm(position, holder);
//                }
//            }
//        });
        holder.tvTinId2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!StringUtil.isEmpty(ptr4)) {
                    if (!b && ptr4.equals(holder.tvTinId2.getText().toString())) {
                        ptr4 = holder.tvTinId2.getText().toString();
                        saveVm(position, holder);
                    }
                }
            }
        });
//        holder.tvKucunleixing.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View view, boolean b) {
//                if(!StringUtil.isEmpty(ptr5)) {
//
//                    if (!b && ptr5.equals(holder.tvKucunleixing.getText().toString())) {
//                        ptr5 = holder.tvKucunleixing.getText().toString();
//                        saveVm(position, holder);
//                    }
//                }
//            }
//        });
        holder.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listenter != null) {
                    if (CheckUtil.checkText(mContext, holder.tvShouhuoshuliang, "请输入收货数量") || CheckUtil.checkText(mContext, holder.tvShengchanriqi, "请输入生产日期")
//                            CheckUtil.checkText(mContext, holder.tvShouhuowendu, "请输入收货温度") || CheckUtil.checkText(mContext, holder.tvTinId2, "请输入托盘号"))
                                                      )

                    if(StringUtil.isEmpty(saveon)){
                        saveon = "on";
                        save(position, vm, holder);

                    }
                }
            }
        });
    }

    private void saveVm(int position, ViewHolder holder) {
//        listenter.saveVm(position, holder.tvShouhuoshuliang.getText().toString(), holder.tvShengchanriqi.getText().toString(),
//                holder.tvShouhuowendu.getText().toString(), holder.tvTinId2.getText().toString(), holder.tvKucunleixing.getText().toString());
        listenter.saveVm(position, holder.tvShouhuoshuliang.getText().toString(), holder.tvShengchanriqi.getText().toString(),
                  holder.tvTinId2.getText().toString());

    }

    public interface PickingDetailListent {
        public void save(int position);
        public void saveVm(int position, String shuliang, String riqi,  String tinid2);
    }

    private void save(final int position, CollectGoodsVm vm, ViewHolder holder) {
        Map<String, String> map = new HashMap<>();
        map.put("id", UUIDUtil.getUUID32());
        map.put("createBy", SharedPreferencesUtil.getInstance(mContext).getKeyValue(Constance.SHAREP.LOGINNAME));
        map.put("imNoticeId",vm.getNoticeId());//商品编码
        map.put("imNoticeItem",vm.getId());
        map.put("goodsName",vm.getShpMingCheng());
        map.put("imQuat",vm.getGoodsCount());
        map.put("goodsCode",vm.getGoodsCode());
        map.put("qmOkQuat",holder.tvShouhuoshuliang.getText().toString());//收货数量
//        map.put("itemText",holder.tvKucunleixing.getText().toString());//质量
        map.put("proData",holder.tvShengchanriqi.getText().toString());//生产日期
        map.put("tinId",holder.tvTinId2.getText().toString());
        map.put("goodsUnit",vm.getShlDanWei());
        map.put("binId",holder.tv_shangjiachuwei.getText().toString());
        JSONObject jsonObject = new JSONObject(map);
        Map<String, String> params = new HashMap<>();
        params.put("wmInQmIstr", jsonObject.toString());//上传实体json

        LoadingUtil.showLoading(mContext);
        Logutil.print("url=="+Constance.getWmInQmIControllerURL());
        HTTPUtils.post(mContext, Constance.getWmInQmIControllerURL(), params, new VolleyListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                saveon = "";
                LoadingUtil.hideLoading();
                ToastUtil.show(mContext, "未知错误");
            }

            @Override
            public void onResponse(String response) {
                saveon = "";
                Logutil.print("res=="+response);
                PickingSaveVm vm = GsonUtils.parseJSON(response, PickingSaveVm.class);
                if (vm != null && vm.isOk()) {
                    listenter.save(position);
                }else if(vm!=null){
                    LoadingUtil.hideLoading();
                    ToastUtil.show(mContext,vm.getErrorMsg());
                }else{
                    ToastUtil.show(mContext, "未知错误");
                }
            }
        });
    }

    static class ViewHolder {
        @BindView(R.id.tv_zhongWenQch)
        TextView tvZhongWenQch;
        @BindView(R.id.tv_shouhuotongzhi)
        TextView tvShouhuotongzhi;
        @BindView(R.id.tv_tihi)
        TextView tvTihi;
        @BindView(R.id.tv_shouhuoshuliang)
        EditText tvShouhuoshuliang;
        @BindView(R.id.tv_shengchanriqi)
        EditText tvShengchanriqi;
//        @BindView(R.id.tv_shouhuowendu)
//        EditText tvShouhuowendu;
        @BindView(R.id.tv_tinId2)
        EditText tvTinId2;
        @BindView(R.id.tv_shangjiachuwei)
        EditText tv_shangjiachuwei;

//        @BindView(R.id.tv_kucunleixing)
//        EditText tvKucunleixing;
        @BindView(R.id.tv_shpMingCheng)
        TextView tvShpMingCheng;
        @BindView(R.id.tv_yuqishuliang)
        TextView tvYuqishuliang;
        @BindView(R.id.tv_yishoushuliang)
        TextView tvYishoushuliang;
        @BindView(R.id.tv_danwei)
        TextView tvDanwei;
        @BindView(R.id.btn_save)
        Button btnSave;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
