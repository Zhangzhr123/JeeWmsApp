package com.jeewms.www.wms.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.jeewms.www.wms.bean.bean.MessageEvent;
import com.jeewms.www.wms.bean.vm.GoodsInfoVm;
import com.jeewms.www.wms.ui.itemview.GoodsInfoorderItemView;
import com.jeewms.www.wms.util.LoadingUtil;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

/**
 * Created by 13799 on 2018/6/7.
 */

public class GoodsInfoorderAdaper extends BaseAdapter {

    Context mContext;

    private List<GoodsInfoVm> obj;
    public void setGoodsInfoList(List<GoodsInfoVm> obj){
        this.obj=obj;
    }
    public GoodsInfoorderAdaper(Context context){
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
        GoodsInfoorderItemView itemView=null;
        if(view==null){
            itemView=new GoodsInfoorderItemView(mContext);
            view=itemView.getmView();
            view.setTag(itemView);
        }else{
            itemView= (GoodsInfoorderItemView) view.getTag();
        }
        itemView.bind(obj.get(i),i);
        itemView.setListent(new GoodsInfoorderItemView.GoodsInfoListent() {
            @Override
            public void save(int position) {
                remove(position);
            }
            @Override
            public void saveVm(int position, String ChZhXiang, String KuZhXiang, String GaoZhXiang, String ZhlKg, String MpDanCeng, String MpCengGao, String BzhiQi, String shptiaoma, String tiji) {
                obj.get(position).setChZhXiang(ChZhXiang);
                obj.get(position).setKuZhXiang(KuZhXiang);
                obj.get(position).setGaoZhXiang(GaoZhXiang);
                obj.get(position).setZhlKg(ZhlKg);
                obj.get(position).setMpDanCeng(MpDanCeng);
                obj.get(position).setMpCengGao(MpCengGao);
                obj.get(position).setBzhiQi(BzhiQi);
                obj.get(position).setShpTiaoMa(shptiaoma);
                obj.get(position).setTiJiCm(tiji);
            }
        });
        return view;
    }

    public void remove(int position){
        LoadingUtil.hideLoading();
        EventBus.getDefault().post(new MessageEvent(""));
//        obj.remove(position);
//        notifyDataSetChanged();
    }
}
