package com.jeewms.www.wms.ui.itemview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.jeewms.www.wms.R;
import com.jeewms.www.wms.bean.vm.InventoryVm;
import com.jeewms.www.wms.bean.vm.PickingSaveVm;
import com.jeewms.www.wms.constance.Constance;
import com.jeewms.www.wms.util.GsonUtils;
import com.jeewms.www.wms.util.LoadingUtil;
import com.jeewms.www.wms.util.SharedPreferencesUtil;
import com.jeewms.www.wms.util.StringUtil;
import com.jeewms.www.wms.util.ToastUtil;
import com.jeewms.www.wms.volley.HTTPUtils;
import com.jeewms.www.wms.volley.VolleyListener;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 13799 on 2018/6/7.
 */

public class InventoryItemView {
    View mView;
    private Context mContext;
    ViewHolder holder;
    public InventoryListent listent;

    private String ptr1="";
    private String ptr2="";
    private String saveon="";


    public void setListent(InventoryListent listent) {
        this.listent = listent;
    }

    public InventoryItemView(Context context) {
        mView = LayoutInflater.from(context).inflate(R.layout.item_inventory, null);
        mContext = context;
        holder=new ViewHolder(mView);
    }

    public View getmView() {
        return mView;
    }

    public void bind(final InventoryVm vm, final int position) {
        holder.tvZhongWenQch.setText(vm.getCusName());
        holder.tvTuopanhao.setText(vm.getTinId());
        holder.tvPandianchuwei.setText(vm.getBinId());
        holder.tvChuwei.setText(vm.getBinId());
        holder.tvPinming.setText(vm.getGoodsName());
        holder.tvShengchanriqi.setText(vm.getGoodsProData());
        holder.tvShlDanWei.setText(vm.getGoodsUnit());
        holder.tvShijishuliang.setText(vm.getGoodsQua());

//        holder.tvPandianchuwei.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//                if (!hasFocus && !ptr1.equals(holder.tvPandianchuwei)) {
//                    ptr1 = holder.tvPandianchuwei.getText().toString();
//                    saveVm(position, holder);
//                }
//            }
//        });
//        holder.tvShijishuliang.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//                if (!hasFocus && !ptr2.equals(holder.tvShijishuliang)) {
//                    ptr2 = holder.tvShijishuliang.getText().toString();
//                    saveVm(position, holder);
//                }
//            }
//        });


        holder.tvPandianchuwei.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!StringUtil.isEmpty(ptr1)) {
                    if (!b && !ptr1.equals(holder.tvPandianchuwei.getText().toString())) {
                        ptr1 = holder.tvPandianchuwei.getText().toString();
                        listent.setchuwei(position, holder.tvPandianchuwei.getText().toString());
                    }
                }
            }
        });


        holder.tvShijishuliang.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!StringUtil.isEmpty(ptr2)) {
                    if (!b && !ptr2.equals(holder.tvShijishuliang.getText().toString())) {
                        ptr2 = holder.tvShijishuliang.getText().toString();
                        listent.setsjsl(position, holder.tvShijishuliang.getText().toString());
                    }
                }
            }
        });


        holder.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(StringUtil.isEmpty(saveon)) {
                    saveon = "on";
                    save(position, vm, holder);
                }
            }
        });
    }
    public void saveVm(int position,ViewHolder holder){
        listent.saveVm(position,holder.tvPandianchuwei.getText().toString(),holder.tvShijishuliang.getText().toString());
    }


    public interface InventoryListent {
        public void save(int position);
        public void saveVm(int position, String binId, String goodsQua);
        public void setchuwei(int position,String value);
        public void setsjsl(int position,String value);
    }

    private void save(final int position, InventoryVm vm, ViewHolder holder) {
        Map<String, String> map = new HashMap<>();
        map.put("id", vm.getId());
        map.put("updateBy", SharedPreferencesUtil.getInstance(mContext).getKeyValue(Constance.SHAREP.LOGINNAME));
//        map.put("tinId", vm.getTinId());
        map.put("binId", holder.tvPandianchuwei.getText().toString());
        map.put("sttQua",holder.tvShijishuliang.getText().toString());

        JSONObject jsonObject = new JSONObject(map);
        Map<String, String> params = new HashMap<>();
        params.put("wmSttInGoodsstr", jsonObject.toString());//上传实体json
        LoadingUtil.showLoading(mContext);
        HTTPUtils.post(mContext, Constance.getwmSttInGoodsControllercURL(), params, new VolleyListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                LoadingUtil.hideLoading();
                saveon = "";

                ToastUtil.show(mContext, "未知错误");
            }

            @Override
            public void onResponse(String response) {
                saveon = "";

                LoadingUtil.hideLoading();
                PickingSaveVm vm = GsonUtils.parseJSON(response, PickingSaveVm.class);
                if (vm != null && vm.isOk()) {
                    listent.save(position);

                }else if(vm!=null){
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
        @BindView(R.id.tv_tuopanhao)
        TextView tvTuopanhao;
        @BindView(R.id.tv_pandianchuwei)
        EditText tvPandianchuwei;
        @BindView(R.id.tv_shijishuliang)
        EditText tvShijishuliang;
        @BindView(R.id.tv_chuwei)
        TextView tvChuwei;
        @BindView(R.id.tv_pinming)
        TextView tvPinming;
        @BindView(R.id.tv_shengchanriqi)
        TextView tvShengchanriqi;
        @BindView(R.id.tv_shlDanWei)
        TextView tvShlDanWei;
        @BindView(R.id.btn_save)
        Button btnSave;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
