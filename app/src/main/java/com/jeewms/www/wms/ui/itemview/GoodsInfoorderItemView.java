package com.jeewms.www.wms.ui.itemview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.jeewms.www.wms.R;
import com.jeewms.www.wms.bean.vm.GoodsInfoVm;
import com.jeewms.www.wms.bean.vm.PickingSaveVm;
import com.jeewms.www.wms.constance.Constance;
import com.jeewms.www.wms.util.GsonUtils;
import com.jeewms.www.wms.util.LoadingUtil;
import com.jeewms.www.wms.util.SharedPreferencesUtil;
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

public class GoodsInfoorderItemView {
    View mView;
    ViewHolder holder;
    private Context mContext;
    public GoodsInfoListent listent;
    String ptr1 = "";
    String ptr2 = "";
    String ptr3 = "";
    String ptr4 = "";
    String ptr5 = "";
    String ptr6 = "";
    String ptr7 = "";
    String ptr8 = "";
    String ptr9 = "";

    public void setListent(GoodsInfoListent listent) {
        this.listent = listent;
    }

    public GoodsInfoorderItemView(Context context) {
        mContext = context;
        mView = LayoutInflater.from(context).inflate(R.layout.item_goodsinfoorder, null);
        holder = new ViewHolder(mView);
    }

    public View getmView() {
        return mView;
    }

    public void bind(final GoodsInfoVm vm, final int position) {
        holder.tvZhongWenQch.setText(vm.getSuoShuKeHu());
        holder.tvPinming.setText(vm.getShpBianMa()+"-"+vm.getShpMingCheng());

//        holder.tvChang.setText(vm.getChZhXiang());
//        holder.tvKuang.setText(vm.getKuZhXiang());
//        holder.tvGao.setText(vm.getGaoZhXiang());
        holder.tvZhongliang.setText(vm.getZhlKg());
        holder.tvDancengshuliang.setText(vm.getMpDanCeng());
        holder.tvCenggao.setText(vm.getMpCengGao());
        holder.tvBaozhiqi.setText(vm.getBzhiQi());

        holder.tvShangpinbianma.setText(vm.getShpBianMa());
        holder.tvKehubianma.setText(vm.getSuoShuKeHu());
        holder.tvDanwei.setText(vm.getShlDanWei());
        holder.tvTiaoma.setText(vm.getShpTiaoMa());
        holder.tvTiaoma.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus && !ptr8.equals(holder.tvTiaoma.getText().toString())) {
                    ptr8 = holder.tvTiaoma.getText().toString();
                    saveVm(position, holder);
                }
            }
        });

        holder.tvTiji.setText(vm.getTiJiCm());
        holder.tvTiji.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus && !ptr9.equals(holder.tvTiji.getText().toString())) {
                    ptr9 = holder.tvTiji.getText().toString();
                    saveVm(position, holder);
                }
            }
        });

        holder.tvChang.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus && !ptr1.equals(holder.tvChang.getText().toString())) {
                    ptr1 = holder.tvChang.getText().toString();
                    saveVm(position, holder);
                }
            }
        });
        holder.tvKuang.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus && !ptr2.equals(holder.tvKuang.getText().toString())) {
                    ptr2 = holder.tvKuang.getText().toString();
                    saveVm(position, holder);
                }
            }
        });
        holder.tvGao.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus && !ptr3.equals(holder.tvGao.getText().toString())) {
                    ptr3 = holder.tvGao.getText().toString();
                    saveVm(position, holder);
                }
            }
        });
        holder.tvZhongliang.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus && !ptr4.equals(holder.tvZhongliang.getText().toString())) {
                    ptr4 = holder.tvZhongliang.getText().toString();
                    saveVm(position, holder);
                }
            }
        });
        holder.tvDancengshuliang.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus && !ptr5.equals(holder.tvDancengshuliang.getText().toString())) {
                    ptr5 = holder.tvDancengshuliang.getText().toString();
                    saveVm(position, holder);
                }
            }
        });
        holder.tvCenggao.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus && !ptr6.equals(holder.tvCenggao.getText().toString())) {
                    ptr6 = holder.tvCenggao.getText().toString();
                    saveVm(position, holder);
                }
            }
        });
        holder.tvBaozhiqi.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus && !ptr7.equals(holder.tvBaozhiqi.getText().toString())) {
                    ptr7 = holder.tvBaozhiqi.getText().toString();
                    saveVm(position, holder);
                }
            }
        });
        holder.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save(position,vm,holder);
            }
        });
    }

    public void saveVm(int position, ViewHolder holder) {
        listent.saveVm(position,holder.tvChang.getText().toString(),holder.tvKuang.getText().toString(),holder.tvGao.getText().toString(),
                holder.tvZhongliang.getText().toString(),holder.tvDancengshuliang.getText().toString(),holder.tvCenggao.getText().toString(),
                holder.tvBaozhiqi.getText().toString(),holder.tvTiaoma.getText().toString(),holder.tvTiji.getText().toString());
    }

    public interface GoodsInfoListent {
        public void save(int position);
        public void saveVm(int position, String ChZhXiang, String KuZhXiang, String GaoZhXiang, String ZhlKg, String MpDanCeng, String MpCengGao, String BzhiQi, String shptiaoma, String tiji);
    }

    private void save(final int position, GoodsInfoVm vm, ViewHolder holder) {
        Map<String, String> map = new HashMap<>();
        map.put("id", vm.getId());
        map.put("createBy", SharedPreferencesUtil.getInstance(mContext).getKeyValue(Constance.SHAREP.LOGINNAME));

        map.put("imCusCode", vm.getShpYanSe());
        map.put("reCarno",vm.getPpTuPian());
        map.put("imBeizhu", vm.getJjZhongBi());
        map.put("goodsQua",holder.tvTiji.getText().toString());
//        map.put("chZhXiang", holder.tvChang.getText().toString());
//        map.put("kuZhXiang", holder.tvKuang.getText().toString());
//        map.put("gaoZhXiang",holder.tvGao.getText().toString());
//        map.put("shpTiaoMa",holder.tvTiaoma.getText().toString());
//        map.put("tiJiCm",holder.tvTiji.getText().toString());

        JSONObject jsonObject = new JSONObject(map);
        Map<String, String> params = new HashMap<>();
        params.put("mdGoodsstr", jsonObject.toString());//上传实体json
        LoadingUtil.showLoading(mContext);
        HTTPUtils.post(mContext, Constance.getmdGoodsControllerorderURL(), params, new VolleyListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                LoadingUtil.hideLoading();ToastUtil.show(mContext, "未知错误");
            }

            @Override
            public void onResponse(String response) {
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
        @BindView(R.id.tv_pinming)
        TextView tvPinming;
        @BindView(R.id.tv_chang)
        EditText tvChang;
        @BindView(R.id.tv_kuang)
        EditText tvKuang;
        @BindView(R.id.tv_gao)
        EditText tvGao;
        @BindView(R.id.tv_tiji)
        EditText tvTiji;
        @BindView(R.id.tv_zhongliang)
        EditText tvZhongliang;
        @BindView(R.id.tv_dancengshuliang)
        EditText tvDancengshuliang;
        @BindView(R.id.tv_cenggao)
        EditText tvCenggao;
        @BindView(R.id.tv_baozhiqi)
        EditText tvBaozhiqi;
        @BindView(R.id.tv_shangpinbianma)
        TextView tvShangpinbianma;
        @BindView(R.id.tv_kehubianma)
        TextView tvKehubianma;
        @BindView(R.id.tv_danwei)
        TextView tvDanwei;
        @BindView(R.id.tv_tiaoma)
        EditText tvTiaoma;
        @BindView(R.id.btn_save)
        Button btnSave;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
