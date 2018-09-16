package com.jeewms.www.wms.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.jeewms.www.wms.bean.bean.MessageEvent;
import com.jeewms.www.wms.bean.vm.StockQueryVm;
import com.jeewms.www.wms.ui.itemview.StockQueryItemView;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

/**
 * Created by 13799 on 2018/6/7.
 */

public class StockQueryAdapter extends BaseAdapter {

    Context mContext;
    private List<StockQueryVm> obj;
    public void setStockQueryList(List<StockQueryVm> obj){
        this.obj=obj;
    }
    public StockQueryAdapter(Context context){
        mContext=context;
    }

    @Override
    public int getCount() {
        return obj==null?0:obj.size();
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
        StockQueryItemView itemView=null;
        if(view==null){
            itemView=new StockQueryItemView(mContext);
            view=itemView.getmView();
            view.setTag(itemView);
        }else{
            itemView= (StockQueryItemView) view.getTag();
        }
        itemView.bind(obj.get(i),i);
        return view;
    }
    public void remove(int position){
        EventBus.getDefault().post(new MessageEvent(""));
    }
}
