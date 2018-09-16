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
import com.jeewms.www.wms.bean.vm.RecheckLoadingVm;
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

public class RecheckLoadingItemView {
    View mView;
    private Context mContext;
    ViewHolder holder;
    private RecheckLoadingListent listent;
    private String ptr1="";
    private String ptr2="";

    public void setListent(RecheckLoadingListent listent) {
        this.listent = listent;
    }

    public RecheckLoadingItemView(Context context) {
        mContext = context;
        mView = LayoutInflater.from(context).inflate(R.layout.item_recheckloading, null);
        holder = new ViewHolder(mView);
    }

    public void bind(final RecheckLoadingVm vm, final int position) {

        holder.tvZhongWenQch.setText(vm.getCusName());
        holder.tvZhongWenQch.setVisibility(View.GONE);
        holder.tvOmNoticeId.setText(vm.getOrderId());

        holder.tvQuerenriqi.setText(vm.getCheckData());
        if (StringUtil.isEmpty(vm.getCheckNum()))
            holder.tvFuheshuliang.setText(vm.getGoodsQua());
        else {
            holder.tvFuheshuliang.setText(vm.getCheckNum());
        }

        holder.tvKehu.setText(vm.getCusName());
        holder.tvShpMingCheng.setText(vm.getGoodsName());
        holder.tvTinId.setText(vm.getGoodsQua());
        holder.tvShlDanWei.setText(vm.getShlDanWei());
        holder.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save(position, vm, holder);
            }
        });
        holder.tvQuerenriqi.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus && !ptr1.equals(holder.tvQuerenriqi.getText().toString())) {
                    ptr1 = holder.tvQuerenriqi.getText().toString();
                    saveVm(position, holder);
                }
            }
        });
        holder.tvFuheshuliang.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus && !ptr2.equals(holder.tvFuheshuliang.getText().toString())) {
                    ptr2 = holder.tvFuheshuliang.getText().toString();
                    saveVm(position, holder);
                }
            }
        });

    }

    private void saveVm(int position, ViewHolder holder) {
        listent.saveVm(position, holder.tvQuerenriqi.getText().toString(), holder.tvFuheshuliang.getText().toString());
    }

    public interface RecheckLoadingListent {
        public void save(int position);
        public void saveVm(int position, String checkData, String checkNum);
    }


    private void save(final int position, RecheckLoadingVm vm, ViewHolder holder) {
        Map<String, String> map = new HashMap<>();
        map.put("id", vm.getId());
        map.put("updateBy", SharedPreferencesUtil.getInstance(mContext).getKeyValue(Constance.SHAREP.LOGINNAME));
        map.put("goodsQua", holder.tvFuheshuliang.getText().toString());
        JSONObject jsonObject = new JSONObject(map);
        Map<String, String> params = new HashMap<>();
        params.put("wmToDownGoodsstr", jsonObject.toString());//上传实体json
        LoadingUtil.showLoading(mContext);
        HTTPUtils.post(mContext, Constance.getwmToDownGoodsControllercURL(), params, new VolleyListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                ToastUtil.show(mContext, "未知错误");
                LoadingUtil.hideLoading();
            }

            @Override
            public void onResponse(String response) {
                LoadingUtil.hideLoading();
                PickingSaveVm vm = GsonUtils.parseJSON(response, PickingSaveVm.class);
                if (vm != null && vm.isOk()) {
                    listent.save(position);
                } else if (vm != null) {
                    ToastUtil.show(mContext, vm.getErrorMsg());
                }else{
                    ToastUtil.show(mContext, "未知错误");
                }
            }
        });
    }

    public View getmView() {
        return mView;
    }

    static class ViewHolder {
        @BindView(R.id.tv_zhongWenQch)
        TextView tvZhongWenQch;
        @BindView(R.id.tv_omNoticeId)
        TextView tvOmNoticeId;
        @BindView(R.id.tv_querenriqi)
        EditText tvQuerenriqi;
        @BindView(R.id.tv_fuheshuliang)
        EditText tvFuheshuliang;
        @BindView(R.id.tv_kehu)
        TextView tvKehu;
        @BindView(R.id.tv_shpMingCheng)
        TextView tvShpMingCheng;
        @BindView(R.id.tv_tinId)
        TextView tvTinId;
        @BindView(R.id.tv_shlDanWei)
        TextView tvShlDanWei;
        @BindView(R.id.btn_save)
        Button btnSave;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
