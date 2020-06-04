package com.jeewms.www.wms.ui.itemview;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.jeewms.www.wms.R;
import com.jeewms.www.wms.bean.bean.HomeBtnBean;
import com.jeewms.www.wms.constance.Constance;
import com.jeewms.www.wms.ui.acitivity.*;
import com.jeewms.www.wms.ui.view.CircleImageView;
import com.zhy.android.percent.support.PercentLinearLayout;

/**
 * Created by 13799 on 2018/6/2.
 */

public class HomeGridItemView {


    protected Activity mActivity;
    CircleImageView imgHomeitem;
    TextView tvHomename;
    PercentLinearLayout ll_root;
    private View mView;


    public HomeGridItemView(Activity act) {
        this.mActivity = act;

        LayoutInflater inflater = LayoutInflater.from(act);
        mView = inflater.inflate(R.layout.itemhome, null);
        imgHomeitem=mView.findViewById(R.id.img_homeitem);
        tvHomename=mView.findViewById(R.id.tv_homename);
        ll_root=mView.findViewById(R.id.ll_root);
    }


    public View getView() {
        return mView;
    }

    public void bindView(final HomeBtnBean bean) {
        imgHomeitem.setImageResource(bean.getImaResId());
        tvHomename.setText(bean.getBtnName());
        ll_root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                ToastUtil.show(mActivity,bean.getBtnName());
                Jump(bean.getBtnName());
            }
        });
    }
    //菜单点击跳转
    private void Jump(String btnName){
        if(Constance.btnNameList[0].equals(btnName)){
            SAPReceiptActivity.show(mActivity);
        }
        else if(Constance.btnNameList[1].equals(btnName)){
            TLReceiptActivity.show(mActivity);
        }
//        else if(Constance.btnNameList[2].equals(btnName)){
//            //按货捡单
//            PickingDetailActivity.show(mActivity);
//        }else if(Constance.btnNameList[3].equals(btnName)){
//            RecheckLoadingActivity.show(mActivity);
//        }else if(Constance.btnNameList[4].equals(btnName)){
//            StorageMoveActivity.show(mActivity);
//        }else if(Constance.btnNameList[5].equals(btnName)){
//            InventoryActivity.show(mActivity);
//        }
//        else if(Constance.btnNameList[6].equals(btnName)){
//            GoodsInfoActivity.show(mActivity);
//        }else if(Constance.btnNameList[7].equals(btnName)){
//            StockQueryActivity.show(mActivity);
//        }else if(Constance.btnNameList[8].equals(btnName)){
//            GoodsInfoorderActivity.show(mActivity);
//        }else if(Constance.btnNameList[9].equals(btnName)){
//
//        }else if(Constance.btnNameList[10].equals(btnName)){
//
//        }else if(Constance.btnNameList[11].equals(btnName)){
//
//        }
    }
}
