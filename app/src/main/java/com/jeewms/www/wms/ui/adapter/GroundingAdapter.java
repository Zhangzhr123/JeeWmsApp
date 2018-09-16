package com.jeewms.www.wms.ui.adapter;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.jeewms.www.wms.bean.bean.MessageEvent;
import com.jeewms.www.wms.bean.vm.GroundingVm;
import com.jeewms.www.wms.ui.itemview.GroundingItemView;
import com.jeewms.www.wms.util.LoadingUtil;
import com.jeewms.www.wms.util.Logutil;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

/**
 * Created by 13799 on 2018/6/7.
 */

public class GroundingAdapter extends BaseAdapter {

    Context mContext;
    private List<GroundingVm> obj;
    public void setGroundingGoodsList(List<GroundingVm> obj){
        this.obj=obj;
    }
    public GroundingAdapter(Context context){
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
        GroundingItemView itemView=null;
        if(view==null){
            itemView=new GroundingItemView(mContext);
            view=itemView.getmView();
            view.setTag(itemView);
        }else{
            itemView= (GroundingItemView) view.getTag();
        }
        itemView.bind(obj.get(i),i);
        itemView.setListent(new GroundingItemView.PickingDetailListent() {
            @Override
            public void save(final int position) {
                LoadingUtil.hideLoading();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        remove(position);
                    }
                },600);
            }

            @Override
            public void saveVm(int position, String shangjiachuwei) {
                Logutil.print("posi=="+position+"=="+shangjiachuwei);
                obj.get(position).setShangjiacunwei(shangjiachuwei);
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
