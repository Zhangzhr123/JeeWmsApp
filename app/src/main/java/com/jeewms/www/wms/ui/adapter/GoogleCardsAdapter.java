package com.jeewms.www.wms.ui.adapter;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.jeewms.www.wms.bean.bean.MessageEvent;
import com.jeewms.www.wms.bean.vm.PickingDetailVm;
import com.jeewms.www.wms.ui.itemview.PickingItemView;
import com.jeewms.www.wms.util.LoadingUtil;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

/**
 * Created by 13799 on 2018/6/7.
 */

public class GoogleCardsAdapter extends BaseAdapter{

    Context mContext;
    private List<PickingDetailVm> mPickingList;

    public List<PickingDetailVm> getmPickingList() {
        return mPickingList;
    }

    public void setmPickingList(List<PickingDetailVm> mPickingList) {
        this.mPickingList = mPickingList;
    }

    public GoogleCardsAdapter(Context context){
        mContext=context;
    }
    @Override
    public int getCount() {
        return mPickingList==null?0:mPickingList.size();
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
        PickingItemView itemView=null;
        if(view==null){
            itemView=new PickingItemView(mContext);
            view=itemView.getView();
            view.setTag(itemView);
        }else{
            itemView= (PickingItemView) view.getTag();
        }
        itemView.bindView(mPickingList.get(i),i);
        itemView.setListent(new PickingItemView.PickingDetailListent() {
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
            public void setTinId2(int position, String value) {
                mPickingList.get(position).setTinId2(value);
            }
        });
        return view;
    }
    public void remove(int position){
//        mPickingList.remove(position);
//        notifyDataSetChanged();
        EventBus.getDefault().post(new MessageEvent(""));
    }



}
