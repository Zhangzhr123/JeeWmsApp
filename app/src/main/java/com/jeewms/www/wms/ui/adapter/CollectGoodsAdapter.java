package com.jeewms.www.wms.ui.adapter;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.jeewms.www.wms.bean.bean.MessageEvent;
import com.jeewms.www.wms.bean.vm.CollectGoodsVm;
import com.jeewms.www.wms.ui.itemview.CollectGoodsItemView;
import com.jeewms.www.wms.ui.itemview.CollectGoodsItemView.PickingDetailListent;
import com.jeewms.www.wms.util.LoadingUtil;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

/**
 * Created by 13799 on 2018/6/7.
 */

public class CollectGoodsAdapter extends BaseAdapter{

    Context mContext;

    private List<CollectGoodsVm> obj;
    public void seCollectGoodsVmList(List<CollectGoodsVm> obj){
        this.obj=obj;
    }

    public CollectGoodsAdapter(Context context){
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
        CollectGoodsItemView itemView=null;
        if(view==null){
            itemView=new CollectGoodsItemView(mContext);
            view=itemView.getView();
            view.setTag(itemView);
        }else{
            itemView= (CollectGoodsItemView) view.getTag();
        }
        itemView.setCollectGoodsList(obj);
        itemView.bind(obj.get(i),i);
        itemView.setListenter(new PickingDetailListent() {
            @Override
            public void save(final int position) {
                LoadingUtil.hideLoading();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
//                        notifyDataSetChanged();
                        remove(position);
                    }
                },600);
            }

            @Override
            public void saveVm(int position, String shuliang, String riqi,   String tinid2, String type) {
                obj.get(position).setTvTinId2(tinid2);
                obj.get(position).setShulian(shuliang);
                obj.get(position).setPreprodate(riqi);
//                obj.get(position).setCfWenCeng(wendu);
                obj.get(position).setType(type);
            }
        });
        return view;
    }


    public void remove(int position){
//        obj.remove(position);
        EventBus.getDefault().post(new MessageEvent(""));
    }



}
