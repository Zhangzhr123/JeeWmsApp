package com.jeewms.www.wms.ui.itemview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jeewms.www.wms.R;
import com.jeewms.www.wms.bean.vm.StockQueryVm;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 13799 on 2018/6/7.
 */

public class StockQueryItemView {
    View mView;
    ViewHolder holder;
    private Context mContext;
    public StockQueryItemView(Context context) {
        mContext=context;
        mView = LayoutInflater.from(context).inflate(R.layout.item_stockquery, null);
        holder=new ViewHolder(mView);
    }

    public View getmView() {
        return mView;
    }
    public void bind(StockQueryVm vm,int position){
        holder.tvZhongWenQch.setText(vm.getCusCode());
        holder.tvTiaoma.setVisibility(View.GONE);
        holder.tvTuopan.setText(vm.getBinId());
        holder.tvBinId.setText(vm.getKuWeiBianMa());
        holder.tvShpMingCheng.setText(vm.getShpMingCheng());
        holder.tvKehu.setText(vm.getZhongWenQch());
        holder.tvShengchanriqi.setText(vm.getGoodsProData());
        holder.tvShuliang.setText(vm.getGoodsQua());
        holder.tvShlDanWei.setText(vm.getGoodsUnit());
    }

    static class ViewHolder {
        @BindView(R.id.tv_zhongWenQch)
        TextView tvZhongWenQch;
        @BindView(R.id.tv_tiaoma)
        EditText tvTiaoma;
        @BindView(R.id.tv_tuopan)
        TextView tvTuopan;
        @BindView(R.id.tv_binId)
        TextView tvBinId;
        @BindView(R.id.tv_shpMingCheng)
        TextView tvShpMingCheng;
        @BindView(R.id.tv_kehu)
        TextView tvKehu;
        @BindView(R.id.tv_shengchanriqi)
        TextView tvShengchanriqi;
        @BindView(R.id.tv_shuliang)
        TextView tvShuliang;
        @BindView(R.id.tv_shlDanWei)
        TextView tvShlDanWei;
        @BindView(R.id.btn_save)
        Button btnSave;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
