package com.jeewms.www.wms.ui.itemview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.jeewms.www.wms.R;
import com.jeewms.www.wms.bean.vm.DemoVm;
import com.jeewms.www.wms.util.UpdataUiUtil;
import com.zhy.android.percent.support.PercentLinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 13799 on 2018/8/5.
 */

public class DemoItemView {
    Context mContext;
    View mView;
    ViewHolder viewHolder;

    public DemoItemView(Context context) {
        mContext = context;
        mView = LayoutInflater.from(context).inflate(R.layout.item_demo, null);
        viewHolder = new ViewHolder(mView);
    }

    public View getmView() {
        return mView;
    }

    public void bind(DemoVm vm, int position, int type) {
        if (type == 0) {
            viewHolder.llHold.setVisibility(View.VISIBLE);
            viewHolder.llHold2.setVisibility(View.GONE);
            UpdataUiUtil.getDefaul().setText(vm.getX2(), viewHolder.tvX1)
                    .setText(vm.getX3(), viewHolder.tvX2)
                    .setText(vm.getX3(), viewHolder.tvX3)
                    .setText(vm.getX4(), viewHolder.tvX4);
        }else {
            viewHolder.llHold.setVisibility(View.GONE);
            viewHolder.llHold2.setVisibility(View.VISIBLE);
            viewHolder.tvX3.setVisibility(View.GONE);
            viewHolder.tvX4.setVisibility(View.GONE);
            UpdataUiUtil.getDefaul().setText(vm.getX2(), viewHolder.tv2X1)
                    .setText(vm.getX3(), viewHolder.tv2X2);
        }
    }

    static class ViewHolder {
        @BindView(R.id.tv_x1)
        TextView tvX1;
        @BindView(R.id.tv_x2)
        TextView tvX2;
        @BindView(R.id.tv_x3)
        TextView tvX3;
        @BindView(R.id.tv_x4)
        TextView tvX4;
        @BindView(R.id.ll_hold)
        PercentLinearLayout llHold;
        @BindView(R.id.tv2_x1)
        TextView tv2X1;
        @BindView(R.id.tv2_x2)
        TextView tv2X2;
        @BindView(R.id.ll_hold2)
        PercentLinearLayout llHold2;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
