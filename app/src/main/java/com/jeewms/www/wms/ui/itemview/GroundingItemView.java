package com.jeewms.www.wms.ui.itemview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.jeewms.www.wms.R;
import com.jeewms.www.wms.bean.vm.GroundingVm;
import com.jeewms.www.wms.bean.vm.PickingSaveVm;
import com.jeewms.www.wms.constance.Constance;
import com.jeewms.www.wms.util.CheckUtil;
import com.jeewms.www.wms.util.GsonUtils;
import com.jeewms.www.wms.util.LoadingUtil;
import com.jeewms.www.wms.util.Logutil;
import com.jeewms.www.wms.util.SharedPreferencesUtil;
import com.jeewms.www.wms.util.ToastUtil;
import com.jeewms.www.wms.util.UUIDUtil;
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

public class GroundingItemView {
    View mView;
    ViewHolder holder;
    PickingDetailListent listent;
    private Context mContext;
    private String ptr="";

    public void setListent(PickingDetailListent listent) {
        this.listent = listent;
    }

    public GroundingItemView(Context context) {
        mContext = context;
        mView = LayoutInflater.from(context).inflate(R.layout.item_grounding, null);
        holder = new ViewHolder(mView);
    }

    public View getmView() {
        return mView;
    }

    public void bind(final GroundingVm vm, final int position) {
        holder.tvZhongWenQch.setText(vm.getCusName());
        holder.tvTuopanhao.setText(vm.getTinId());
        holder.tvShangjiacunwei.setText(vm.getBinId());
//        holder.tvBinId.setText(vm.getBinId());

        holder.tvShangjiacunwei.setText(vm.getBinId());
        holder.tvShpMingCheng.setText(vm.getGoodsName());
        holder.tvBaseGoodscount.setText(vm.getQmOkQuat());
        holder.tvShlDanWei.setText(vm.getGoodsUnit());
        holder.tvShangjiacunwei.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!b&&ptr.equals(holder.tvShangjiacunwei.getText().toString())) {
                    ptr=holder.tvShangjiacunwei.getText().toString();
                    listent.saveVm(position,holder.tvShangjiacunwei.getText().toString());
                }
            }
        });
        holder.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listent != null) {
                    if (CheckUtil.checkText(mContext, holder.tvShangjiacunwei, "请输入上架储位！"))
                        save(position, vm, holder);
                }
            }
        });
    }

    public interface PickingDetailListent {
        public void save(int position);

        public void saveVm(int position, String BindId);
    }


    private void save(final int position, GroundingVm vm, ViewHolder holder) {
        Map<String, String> map = new HashMap<>();
        map.put("id", UUIDUtil.getUUID32());
        map.put("createBy", SharedPreferencesUtil.getInstance(mContext).getKeyValue(Constance.SHAREP.LOGINNAME));
        map.put("goodsId", vm.getGoodsId());
        map.put("goodsQua",vm.getQmOkQuat());
        map.put("orderId", vm.getImNoticeId());
        map.put("orderIdI",vm.getImNoticeItem());
        map.put("wmToUpId", vm.getId());
        map.put("goodsUnit", vm.getGoodsUnit());
        map.put("goodsProData", vm.getProData());
        map.put("kuWeiBianMa", holder.tvShangjiacunwei.getText().toString());//上架储位
        map.put("binId",vm.getTinId());
        map.put("cusCode", vm.getCusCode());
        JSONObject jsonObject = new JSONObject(map);
        Map<String, String> params = new HashMap<>();
        params.put("wmToUpGoodsstr", jsonObject.toString());//上传实体json
        LoadingUtil.showLoading(mContext);
        HTTPUtils.post(mContext, Constance.getWmToUpGoodsControllerURL(), params, new VolleyListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                LoadingUtil.hideLoading();ToastUtil.show(mContext, "未知错误");
            }

            @Override
            public void onResponse(String response) {
                Logutil.print("res=="+response);
                PickingSaveVm vm = GsonUtils.parseJSON(response, PickingSaveVm.class);
                if (vm != null && vm.isOk()) {
                    listent.save(position);
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
        @BindView(R.id.tv_tuopanhao)
        TextView tvTuopanhao;
        @BindView(R.id.tv_shangjiacunwei)
        EditText tvShangjiacunwei;
//        @BindView(R.id.tv_binId)
//        TextView tvBinId;
        @BindView(R.id.tv_shpMingCheng)
        TextView tvShpMingCheng;
        @BindView(R.id.tv_baseGoodscount)
        TextView tvBaseGoodscount;
        @BindView(R.id.tv_shlDanWei)
        TextView tvShlDanWei;
        @BindView(R.id.btn_save)
        Button btnSave;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
