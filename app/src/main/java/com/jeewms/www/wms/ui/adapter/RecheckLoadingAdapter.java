package com.jeewms.www.wms.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.jeewms.www.wms.bean.bean.MessageEvent;
import com.jeewms.www.wms.bean.vm.RecheckLoadingVm;
import com.jeewms.www.wms.ui.itemview.RecheckLoadingItemView;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

/**
 * Created by 13799 on 2018/6/7.
 */

public class RecheckLoadingAdapter extends BaseAdapter {
    Context mContext;
    private List<RecheckLoadingVm> obj;
    public void setRecheckLoadingList(List<RecheckLoadingVm> obj){
        this.obj=obj;
    }
    public RecheckLoadingAdapter(Context context){
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
        RecheckLoadingItemView itemView=null;
        if(view==null){
            itemView=new RecheckLoadingItemView(mContext);
            view=itemView.getmView();
            view.setTag(itemView);
        }else{
            itemView= (RecheckLoadingItemView) view.getTag();
        }
        itemView.bind(obj.get(i),i);
        itemView.setListent(new RecheckLoadingItemView.RecheckLoadingListent() {
            @Override
            public void save(int position) {
                remove(position);
            }

            @Override
            public void saveVm(int position, String checkData, String checkNum) {
                obj.get(position).setCheckData(checkData);
                obj.get(position).setCheckNum(checkNum);
            }
        });
        return view;
    }
    public void remove(int position){
//        obj.remove(position);
//        notifyDataSetChanged();
        EventBus.getDefault().post(new MessageEvent(""));
    }
}
