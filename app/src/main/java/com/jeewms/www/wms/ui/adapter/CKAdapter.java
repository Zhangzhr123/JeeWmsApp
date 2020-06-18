package com.jeewms.www.wms.ui.adapter;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.jeewms.www.wms.R;
import com.jeewms.www.wms.bean.bean.RkWmsCkdbEntity;
import com.jeewms.www.wms.util.StringUtil;

import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by 13799 on 2018/6/7.
 */

public class CKAdapter extends BaseAdapter {

    private Context mContext;
    private List<RkWmsCkdbEntity> mList;
    private DetailViewHolderListener mListener;
    // 点击过的item，用于焦点获取
    private int touchItemPosition = -1;

    public CKAdapter(Context context, List<RkWmsCkdbEntity> list, DetailViewHolderListener mListener) {
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        holder = new ViewHolder();
        convertView = LayoutInflater.from(mContext).inflate(R.layout.item_sapreceipt, null);
        holder.sapHxm = (TextView) convertView.findViewById(R.id.tv_huowubianhao);
        holder.number = (EditText) convertView.findViewById(R.id.tv_number);
        holder.checkbox = (CheckBox) convertView.findViewById(R.id.ch_onclick);
        holder.ll_zhijian = (LinearLayout) convertView.findViewById(R.id.ll_zhijian);
        holder.btn_jian = (ImageButton) convertView.findViewById(R.id.btn_jian);
        holder.btn_jia = (ImageButton) convertView.findViewById(R.id.btn_jia);

        //强制隐藏软键盘
        disableShowInput(holder.number);

        convertView.setTag(holder);
        //添加行数据
        final RkWmsCkdbEntity rw = mList.get(position);
        holder.sapHxm.setText(rw.getInd() + "/" + rw.getMatnr());
        holder.number.setText("" + rw.getPpmen());
        holder.old = rw.getJhsl();

        holder.number.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String str = String.valueOf(s);
                if (!(str).matches(".*[a-zA-Z].*") && !str.contains("-") && !StringUtil.isEmpty(str)) {
                    mList.get(position).setPpmen(Double.valueOf(str));
                } else {
                    mList.get(position).setPpmen(null);
                }
            }
        });

//        //设置质检标识
//        if (!StringUtil.isEmpty(rw.getInflg())) {
//            holder.ll_zhijian.setVisibility(View.VISIBLE);
//        }
        //设置勾选状态
        if (rw.getChecked()) {
            holder.checkbox.setChecked(true);
        } else {
            holder.checkbox.setChecked(false);
        }

        mListener.setCKData(holder, position);
        return convertView;
    }

    public class ViewHolder {
        public TextView sapHxm;
        public EditText number;
        public CheckBox checkbox;
        public LinearLayout ll_zhijian;
        public ImageButton btn_jian;
        public ImageButton btn_jia;
        public Double old;
    }

    /**
     * 展示不同数据的接口
     */
    public interface DetailViewHolderListener {
        void setCKData(ViewHolder viewHolder, int position);
    }

    public void setList(List<RkWmsCkdbEntity> datas) {
        mList = datas;
        notifyDataSetChanged();
    }

    public void disableShowInput(EditText et) {
        Class<EditText> cls = EditText.class;
        Method method;
        try {
            method = cls.getMethod("setShowSoftInputOnFocus", boolean.class);
            method.setAccessible(true);
            method.invoke(et, false);
        } catch (Exception e) {//TODO: handle exception
        }
    }


}
