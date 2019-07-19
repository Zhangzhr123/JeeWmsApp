package com.jeewms.www.wms.ui.itemview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.jeewms.www.wms.R;
import com.jeewms.www.wms.bean.vm.PickingSaveVm;
import com.jeewms.www.wms.bean.vm.StorageMoveVm;
import com.jeewms.www.wms.constance.Constance;
import com.jeewms.www.wms.util.GsonUtils;
import com.jeewms.www.wms.util.LoadingUtil;
import com.jeewms.www.wms.util.Logutil;
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

public class StorageMoveItemView {
    private View mView;
    private ViewHolder holder;
    private Context mContext;
    public StorageMoveListent listent;
    private String ptr1="";
    private String ptr2="";
    private String ptr3="";
    private String ptr4="";

    public void setListent(StorageMoveListent listent) {
        this.listent = listent;
    }

    public StorageMoveItemView(Context context) {
        mView = LayoutInflater.from(context).inflate(R.layout.item_storagemove, null);
        mContext = context;
        holder = new ViewHolder(mView);
    }

    public View getmView() {
        return mView;
    }

    public void bindView(final StorageMoveVm vm, final int position) {
        final int mPosition = position;
        holder.tvZhongWenQch.setText(vm.getCusName());
        holder.tvYichutuopan.setText(vm.getTinFrom());
        if (!StringUtil.isEmpty(vm.getBinFrom())) {
            holder.tvYichuchuwei.setText(vm.getBinFrom());
        }
        if (!StringUtil.isEmpty(vm.getTinId())) {
            holder.tvYirutuopan.setText(vm.getTinId());
        }
        if (!StringUtil.isEmpty(vm.getBinTo())) {
            holder.tvYiruchuwei.setText(vm.getBinTo());
        }
        if (!StringUtil.isEmpty(vm.getGoodsQua())) {
            holder.tvShuliang1.setText(vm.getGoodsQua());
        }
        holder.tvShuliang2.setText(vm.getBaseGoodscount());
        holder.tvYuanchuwei.setText(vm.getBinFrom());
        holder.tvMubiaochuwei.setText(vm.getBinTo());
        holder.tvPinming.setText(vm.getGoodsName());
        holder.tvToCusName.setText(vm.getToCusName());
        holder.tvYichuchuwei.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus && !ptr1.equals(holder.tvYichuchuwei)) {
                    ptr1 = holder.tvYichuchuwei.getText().toString();
                    saveVm(position, holder);
                }
            }
        });
        holder.tvYirutuopan.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus && !ptr2.equals(holder.tvYirutuopan)) {
                    ptr2 = holder.tvYirutuopan.getText().toString();
                    saveVm(position, holder);
                }
            }
        });
        holder.tvYiruchuwei.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus && !ptr3.equals(holder.tvYiruchuwei)) {
                    ptr3 = holder.tvYiruchuwei.getText().toString();
                    saveVm(position, holder);
                }
            }
        });
        holder.tvShuliang1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus && !ptr4.equals(holder.tvShuliang1)) {
                    ptr4 = holder.tvShuliang1.getText().toString();
                    saveVm(position, holder);
                }
            }
        });
        holder.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save(position, vm, holder);
            }
        });

    }

    private void saveVm(int position, ViewHolder holder) {
        listent.saveVm(position, holder.tvYichuchuwei.getText().toString(),
                holder.tvYirutuopan.getText().toString(), holder.tvYiruchuwei.getText().toString(),
                holder.tvShuliang1.getText().toString());
    }

    public interface StorageMoveListent {
        public void save(int position);

        public void saveVm(int position, String yichuchuwei, String yirutuopan, String yiruchuwei, String shuliang1);
    }

    private void save(final int position, StorageMoveVm vm, ViewHolder holder) {
        Logutil.print("save==");
        LoadingUtil.showLoading(mContext);
        Map<String, String> map = new HashMap<>();
        map.put("id", vm.getId());
        map.put("updateBy", SharedPreferencesUtil.getInstance(mContext).getKeyValue(Constance.SHAREP.LOGINNAME));
        map.put("goodsQua",vm.getGoodsQua());
        map.put("baseGoodscount",vm.getGoodsQua());

        map.put("tinFrom",holder.tvYichutuopan.getText().toString());
        map.put("tinId",holder.tvYirutuopan.getText().toString());
        map.put("binFrom",holder.tvYichuchuwei.getText().toString());
        map.put("binTo",holder.tvYiruchuwei.getText().toString());

        map.put("moveSta","已完成");
        JSONObject jsonObject = new JSONObject(map);
        Map<String, String> params = new HashMap<>();
        params.put("wmToMoveGoodsstr", jsonObject.toString());//上传实体json
        HTTPUtils.post(mContext, Constance.getwmToMoveGoodsControllercURL(), params, new VolleyListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                LoadingUtil.hideLoading();ToastUtil.show(mContext, "未知错误");
            }
            @Override
            public void onResponse(String response) {
                Logutil.print("re=="+response);
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
        @BindView(R.id.tv_yichutuopan)
        TextView tvYichutuopan;
        @BindView(R.id.tv_yichuchuwei)
        EditText tvYichuchuwei;
        @BindView(R.id.tv_yirutuopan)
        EditText tvYirutuopan;
        @BindView(R.id.tv_yiruchuwei)
        EditText tvYiruchuwei;
        @BindView(R.id.tv_shuliang1)
        EditText tvShuliang1;
        @BindView(R.id.tv_shuliang2)
        TextView tvShuliang2;
        @BindView(R.id.tv_yuanchuwei)
        TextView tvYuanchuwei;
        @BindView(R.id.tv_mubiaochuwei)
        TextView tvMubiaochuwei;
        @BindView(R.id.tv_pinming)
        TextView tvPinming;
        @BindView(R.id.tv_toCusName)
        TextView tvToCusName;
        @BindView(R.id.btn_save)
        Button btnSave;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
