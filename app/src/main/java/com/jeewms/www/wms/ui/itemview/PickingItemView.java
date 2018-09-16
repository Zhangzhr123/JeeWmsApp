package com.jeewms.www.wms.ui.itemview;

import android.content.Context;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.jeewms.www.wms.R;
import com.jeewms.www.wms.bean.vm.PickingDetailVm;
import com.jeewms.www.wms.bean.vm.PickingSaveVm;
import com.jeewms.www.wms.constance.Constance;
import com.jeewms.www.wms.util.CheckUtil;
import com.jeewms.www.wms.util.GsonUtils;
import com.jeewms.www.wms.util.LoadingUtil;
import com.jeewms.www.wms.util.SharedPreferencesUtil;
import com.jeewms.www.wms.util.ToastUtil;
import com.jeewms.www.wms.util.UUIDUtil;
import com.jeewms.www.wms.volley.HTTPUtils;
import com.jeewms.www.wms.volley.VolleyListener;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 13799 on 2018/6/3.
 */

public class PickingItemView {

    View mView;
    Context mContext;
    ViewHolder holder;
    PickingDetailListent mListent;
    Map<Integer, String> mMapContent;
    String perStr;


    public void setListent(PickingDetailListent listent) {
        mListent = listent;
    }

    public PickingItemView(Context act) {
        mContext = act;
        mMapContent = new HashMap<Integer, String>();
        LayoutInflater inflater = LayoutInflater.from(mContext);
        mView = inflater.inflate(R.layout.item_pickingdetail, null);
        holder=new ViewHolder(mView);
    }

    public View getView() {
        return mView;
    }

    public void bindView(final PickingDetailVm vm, final int position) {
        final int mPosition=position;
        holder.tvOmNoticeId.setText(vm.getOmNoticeId());
        holder.tvBaseGoodscount.setText(vm.getBaseGoodscount());
        holder.tvBinId.setText(vm.getBinId());
        holder.tvShpMingCheng.setText(vm.getShpMingCheng());
        holder.tvTinId.setText(vm.getTinId());
        holder.tvGoodsProData.setText(vm.getGoodsProData());
        holder.tvShlDanWei.setText(vm.getShlDanWei());
        holder.tvOmBeiZhu.setText(vm.getOmBeiZhu());
        holder.tvZhongWenQch.setText(vm.getZhongWenQch());
        //界面edittext输入丢失问题
        holder.tvTinId2.setTag(position);
        perStr=vm.getTinId2()==null?"":vm.getTinId2();
        holder.tvTinId2.setText(perStr);
        holder.tvTinId2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!b&&!perStr.equals(holder.tvTinId2.getText().toString())) {
                    perStr=holder.tvTinId2.getText().toString();
                    mListent.setTinId2(position,holder.tvTinId2.getText().toString());
                }
            }
        });
        holder.tvTinId2.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if(CheckUtil.checkText(mContext,holder.tvTinId2,"请输入托盘号"))
                save(position,holder.tvTinId2.getText().toString(),vm);
                return false;
            }
        });
        holder.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mListent!=null){
                    if(CheckUtil.checkText(mContext,holder.tvTinId2,"请输入托盘号"))
                    save(position,holder.tvTinId2.getText().toString(),vm);
                }
            }
        });
    }
    private void save(final int position, String tinId2, PickingDetailVm vm){
        Map<String,String> map=new HashMap<>();
        map.put("id", UUIDUtil.getUUID32());
        map.put("createBy", SharedPreferencesUtil.getInstance(mContext).getKeyValue(Constance.SHAREP.LOGINNAME));
        map.put("goodsId",vm.getGoodsId());//商品编码
        map.put("goodsQua",vm.getBaseGoodscount());//数量
        map.put("goodsQuaok",vm.getBaseGoodscount());//完成数量
        map.put("orderId",vm.getOmNoticeId());//原始单据编码
        map.put("orderIdI",vm.getId());//原始单据行项目
        map.put("goodsUnit",vm.getBaseUnit());//单位
        map.put("goodsProData",vm.getGoodsProData());//生产日期
        map.put("kuWeiBianMa",vm.getBinId());//库位编码



        map.put("binIdTo",vm.getOmNoticeId());//目标托盘
        map.put("binIdFrom",tinId2);//源托盘码
        map.put("cusCode",vm.getCusCode());//货主
        map.put("baseUnit",vm.getBaseUnit());//基本单位
        map.put("baseGoodscount",vm.getBaseGoodscount());//基本单位数量
        map.put("wmToDownGoodsstr",vm.getBaseGoodscount());//基本单位数量
        JSONObject jsonObject=new JSONObject(map);
        Map<String,String> params=new HashMap<>();
        params.put("wmToDownGoodsstr",jsonObject.toString());//上传实体json
        LoadingUtil.showLoading(mContext);
        HTTPUtils.post(mContext, Constance.getSaveginoticeURL(), params, new VolleyListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                LoadingUtil.hideLoading();ToastUtil.show(mContext, "未知错误");
            }

            @Override
            public void onResponse(String response) {
                PickingSaveVm vm=GsonUtils.parseJSON(response,PickingSaveVm.class);
                if(vm!=null&&vm.isOk()){
                    mListent.save(position);
                }else if(vm!=null){
                    LoadingUtil.hideLoading();
                    ToastUtil.show(mContext,vm.getErrorMsg());
                }else{
                    ToastUtil.show(mContext, "未知错误");
                }
            }
        });
    }

    public interface PickingDetailListent {
        public void save(int position);
        public void setTinId2(int position,String value);
    }

    static class ViewHolder {
        @BindView(R.id.tv_zhongWenQch)
        TextView tvZhongWenQch;
        @BindView(R.id.tv_omNoticeId)
        TextView tvOmNoticeId;
        @BindView(R.id.tv_tinId2)
        EditText tvTinId2;
        @BindView(R.id.tv_baseGoodscount)
        TextView tvBaseGoodscount;
        @BindView(R.id.tv_binId)
        TextView tvBinId;
        @BindView(R.id.tv_shpMingCheng)
        TextView tvShpMingCheng;
        @BindView(R.id.tv_tinId)
        TextView tvTinId;
        @BindView(R.id.tv_goodsProData)
        TextView tvGoodsProData;
        @BindView(R.id.tv_shlDanWei)
        TextView tvShlDanWei;
        @BindView(R.id.tv_omBeiZhu)
        TextView tvOmBeiZhu;
        @BindView(R.id.btn_save)
        Button btnSave;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }

    }
}
