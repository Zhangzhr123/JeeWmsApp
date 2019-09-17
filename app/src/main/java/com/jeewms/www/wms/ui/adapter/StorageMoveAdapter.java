package com.jeewms.www.wms.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.jeewms.www.wms.bean.bean.MessageEvent;
import com.jeewms.www.wms.bean.vm.StorageMoveVm;
import com.jeewms.www.wms.ui.itemview.StorageMoveItemView;
import com.jeewms.www.wms.util.Logutil;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

/**
 * Created by 13799 on 2018/6/7.
 */

public class StorageMoveAdapter extends BaseAdapter {

    Context mContext;
    private List<StorageMoveVm> obj;
    public void setStorageMoveGoodsList(List<StorageMoveVm> obj){
        this.obj=obj;
    }
    public StorageMoveAdapter(Context context) {
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
        StorageMoveItemView itemView=null;
        if(view==null){
            itemView=new StorageMoveItemView(mContext);
            view=itemView.getmView();
            view.setTag(itemView);
        }else{
            itemView= (StorageMoveItemView) view.getTag();
        }
        itemView.bindView(obj.get(i),i);
        itemView.setListent(new StorageMoveItemView.StorageMoveListent() {
            @Override
            public void save(int position) {
                remove(position);
            }

            @Override
            public void saveVm(int position, String yichuchuwei, String yirutuopan, String yiruchuwei, String shuliang1) {
                obj.get(position).setBinFrom(yichuchuwei);
                Logutil.print("yi="+yirutuopan);
                obj.get(position).setTinId(yirutuopan);
                obj.get(position).setBinTo(yiruchuwei);
                obj.get(position).setGoodsQua(shuliang1);
            }
            @Override
            public void setchuwei(int position,String value){
                obj.get(position).setBinFrom(value);

            }
            @Override
            public void setyirutuopan(int position,String value){
                obj.get(position).setTinId(value);

            }
            @Override
            public void setyiruchuwei(int position,String value){
                obj.get(position).setBinTo(value);

            }
            @Override
            public void setyirushuliang(int position,String value){
                obj.get(position).setGoodsQua(value);

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
