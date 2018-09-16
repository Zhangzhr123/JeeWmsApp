package com.jeewms.www.wms.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.jeewms.www.wms.bean.bean.MessageEvent;
import com.jeewms.www.wms.bean.vm.InventoryVm;
import com.jeewms.www.wms.ui.itemview.InventoryItemView;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

/**
 * Created by 13799 on 2018/6/7.
 */

public class InventoryAdapter extends BaseAdapter {

    Context mContext;
    private List<InventoryVm> obj;
    public void seInventoryList(List<InventoryVm> obj){
        this.obj=obj;
    }
   public  InventoryAdapter(Context context){
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
        InventoryItemView itemView=null;
        if(view==null){
            itemView=new InventoryItemView(mContext);
            view=itemView.getmView();
            view.setTag(itemView);
        }else{
            itemView= (InventoryItemView) view.getTag();
        }
        itemView.bind(obj.get(i),i);
        itemView.setListent(new InventoryItemView.InventoryListent() {
            @Override
            public void save(int position) {
                remove(position);
            }

            @Override
            public void saveVm(int position, String binId, String goodsQua) {
                obj.get(position).setBinId(binId);
                obj.get(position).setGoodsQua(goodsQua);
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
