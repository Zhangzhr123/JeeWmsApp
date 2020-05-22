package com.jeewms.www.wms.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.jeewms.www.wms.R;
import com.jeewms.www.wms.bean.bean.RkWmsSctlEntity;
import com.jeewms.www.wms.bean.bean.RkWmsShdbEntity;
import com.jeewms.www.wms.ui.acitivity.SAPReceiptActivity;
import com.jeewms.www.wms.ui.view.dialog.SyDialogHelper;
import com.jeewms.www.wms.util.DoubleUtil;
import com.jeewms.www.wms.util.StringUtil;

import java.util.List;

/**
 * Created by 13799 on 2018/6/7.
 */

public class SAPReceiptAdapter extends BaseAdapter {

    private Context mContext;
    private List<RkWmsShdbEntity> mList;
    private DetailViewHolderListener mListener;

    public SAPReceiptAdapter(Context context, List<RkWmsShdbEntity> list, DetailViewHolderListener mListener) {
        this.mContext = context;
        this.mList = list;
        this.mListener = mListener;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        holder = new ViewHolder();
        convertView = LayoutInflater.from(mContext).inflate(R.layout.item_sapreceipt, null);
        holder.sapHxm = (TextView) convertView.findViewById(R.id.tv_huowubianhao);
        holder.rkWlms = (TextView) convertView.findViewById(R.id.tv_huowumingcheng);
        holder.number = (EditText) convertView.findViewById(R.id.tv_shouhuoshuliang);
        holder.checkbox = (CheckBox) convertView.findViewById(R.id.ch_onclick);
        holder.ll_zhijian = (LinearLayout) convertView.findViewById(R.id.ll_zhijian);
        holder.btn_jian = (ImageButton) convertView.findViewById(R.id.btn_jian);
        holder.btn_jia = (ImageButton) convertView.findViewById(R.id.btn_jia);

        convertView.setTag(holder);
        //添加行数据
        final RkWmsShdbEntity rw = mList.get(position);
        holder.sapHxm.setText(rw.getShwlp());
        holder.rkWlms.setText(rw.getMaktx());
        holder.number.setText("" + rw.getMenge());
        holder.old = rw.getMenge();
        //设置质检标识
        if (!StringUtil.isEmpty(rw.getInflg())) {
            holder.ll_zhijian.setVisibility(View.VISIBLE);
        }
        //设置勾选状态
        if (rw.getChecked()) {
            holder.checkbox.setChecked(true);
        } else {
            holder.checkbox.setChecked(false);
        }
        //减号
        final ViewHolder finalHolder2 = holder;
        holder.btn_jian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double number = Double.valueOf(finalHolder2.number.getText().toString().trim());
                Double old = finalHolder2.old;
                if (Double.doubleToLongBits(DoubleUtil.sub(number, 1)) > Double.doubleToLongBits(old)) {
                    SyDialogHelper.showWarningDlg(mContext, "", "收货数量不能大于交货数量", "确定");
                } else {
                    finalHolder2.number.setText("");
                    finalHolder2.number.setText(DoubleUtil.sub(number, 1) + "");
                    rw.setMenge(DoubleUtil.sub(number, 1));
                }
            }
        });
        //加号
        final ViewHolder finalHolder1 = holder;
        holder.btn_jia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double number = Double.valueOf(finalHolder1.number.getText().toString().trim());
                Double old = finalHolder1.old;
                if (Double.doubleToLongBits(DoubleUtil.sum(number, 1)) > Double.doubleToLongBits(old)) {
                    SyDialogHelper.showWarningDlg(mContext, "", "收货数量不能大于交货数量", "确定");
                } else {
                    finalHolder1.number.setText("");
                    finalHolder1.number.setText(DoubleUtil.sum(number, 1) + "");
                    rw.setMenge(DoubleUtil.sum(number, 1));
                }
            }
        });

        mListener.setData(holder, position);
        return convertView;
    }

    public class ViewHolder {
        public TextView sapHxm;
        public TextView rkWlms;
        public EditText number;
        public CheckBox checkbox;
        public LinearLayout ll_zhijian;
        public ImageButton btn_jian, btn_jia;
        public Double old;
    }

    /**
     * 展示不同数据的接口
     */
    public interface DetailViewHolderListener {
        void setData(ViewHolder viewHolder, int position);
    }


}
