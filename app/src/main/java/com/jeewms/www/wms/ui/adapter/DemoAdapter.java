package com.jeewms.www.wms.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.jeewms.www.wms.bean.vm.DemoVm;
import com.jeewms.www.wms.ui.itemview.DemoItemView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 13799 on 2018/8/5.
 */

public class DemoAdapter extends BaseAdapter {

    Context mContext;
    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    private List<DemoVm> list = new ArrayList<>();

    public DemoAdapter(Context context) {
        mContext = context;
    }

    public List<DemoVm> getList() {
        return list;
    }

    public void setList(List<DemoVm> list) {
        this.list = list;
    }


    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        DemoItemView itemView=null;
        if(view==null){
            itemView=new DemoItemView(mContext);
            view=itemView.getmView();
            view.setTag(itemView);

        }else{
            itemView= (DemoItemView) view.getTag();
        }
        itemView.bind(list.get(i),i,type);
        return view;
    }
}
