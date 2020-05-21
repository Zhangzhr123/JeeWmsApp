package com.jeewms.www.wms.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.jeewms.www.wms.R;
import com.jeewms.www.wms.bean.bean.RkWmsSctlEntity;
import com.jeewms.www.wms.util.DoubleUtil;

import java.util.List;

/**
 * Created by 13799 on 2018/6/7.
 */

public class SAPReceiptAdapter extends BaseAdapter {

    private Context mContext;
    private List<RkWmsSctlEntity> mList;
    private DetailViewHolderListener mListener;

    public SAPReceiptAdapter(Context context, List<RkWmsSctlEntity> list, DetailViewHolderListener mListener) {
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
        holder.imageView = (ImageView) convertView.findViewById(R.id.zhijian);
        holder.tv_zhijian = (TextView) convertView.findViewById(R.id.tv_zhijian);
        holder.btn_jian = (ImageButton) convertView.findViewById(R.id.btn_jian);
        holder.btn_jia = (ImageButton) convertView.findViewById(R.id.btn_jia);

        convertView.setTag(holder);
        //添加行数据
        RkWmsSctlEntity rw = mList.get(position);
        holder.sapHxm.setText(rw.getRkSydhxm());
        holder.rkWlms.setText(rw.getRkWlms());
        holder.number.setText(""+rw.getRkSl());
        holder.old = rw.getRkSl();
//        final ViewHolder finalHolder = holder;
//        holder.btn_jian.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Double number = Double.valueOf(finalHolder.number.getText().toString().trim());
//                finalHolder.number.setText("");
//                finalHolder.number.setText(DoubleUtil.sub(number,1)+"");
//            }
//        });
//        holder.btn_jia.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Double number = Double.valueOf(finalHolder.number.getText().toString().trim());
//                finalHolder.number.setText("");
//                finalHolder.number.setText(DoubleUtil.sum(number,1)+"");
//            }
//        });

        mListener.setData(holder, position);
        return convertView;
    }

    public class ViewHolder {
        public TextView sapHxm;
        public TextView rkWlms;
        public EditText number;
        public CheckBox checkbox;
        public ImageView imageView;
        public TextView tv_zhijian;
        public ImageButton btn_jian,btn_jia;
        public Double old;
    }

    /**
     * 展示不同数据的接口
     */
    public interface DetailViewHolderListener {
        void setData(ViewHolder viewHolder, int position);
    }


}
