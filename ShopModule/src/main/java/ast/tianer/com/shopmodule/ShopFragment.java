package ast.tianer.com.shopmodule;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.smile.ch.common.adapter.BaseViewHolder;
import com.smile.ch.common.adapter.MyBaseAdapter;
import com.smile.ch.common.base.ARouterManager;
import com.smile.ch.common.base.BaseMvpFragment;
import com.smile.ch.common.view.RoundImageView;
import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;
import com.zhouwei.mzbanner.holder.MZViewHolder;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import ast.tianer.com.shopmodule.bean.ShopBean;
import ast.tianer.com.shopmodule.eventbus.EventMsg;
import ast.tianer.com.shopmodule.presenter.ShopPresenter;
import ast.tianer.com.shopmodule.view.ShopView;

/**
 * @author RuanWei
 * @date 2018/5/16 13:49
 */
@Route(path = ARouterManager.ShopFragment)
public class ShopFragment extends BaseMvpFragment<ShopView, ShopPresenter> implements ShopView, View.OnClickListener {
    private ListView lvShop;
    private MZBannerView mzBannerView;
    private MyBaseAdapter adapter;


    private List<ShopBean.BodyBean.DesignResultsBean> beanlist = new ArrayList<>();

    @Override
    public ShopPresenter createPresenter() {
        return new ShopPresenter();
    }

    @Override
    public ShopView createView() {
        return this;
    }

    @Override
    protected void getData() {
        getPresenter().getShopData("杭州", "F2EE5DC7DE3911E7B19800163E0EB16B");
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_shop, null);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        EventBus.getDefault().register(this);
        lvShop = view.findViewById(R.id.lv_shop);
        TextView tvTitle = view.findViewById(R.id.tv_title);
        tvTitle.setText("商城");
        View headerView = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_shop_header, null);
        lvShop.addHeaderView(headerView);
        LinearLayout llShopDesign = headerView.findViewById(R.id.ll_shop_design);
        LinearLayout llShopMaterial = headerView.findViewById(R.id.ll_shop_materiel);
        LinearLayout llShopBook = headerView.findViewById(R.id.ll_shop_book);
        LinearLayout llShopMachine = headerView.findViewById(R.id.ll_shop_machine);
        LinearLayout llShopLeasse = headerView.findViewById(R.id.ll_shop_lease);
        mzBannerView = headerView.findViewById(R.id.banner_normal);
        llShopDesign.setOnClickListener(this);
        llShopMaterial.setOnClickListener(this);
        llShopBook.setOnClickListener(this);
        llShopMachine.setOnClickListener(this);
        llShopLeasse.setOnClickListener(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onShopResult(String result) {
        try {
            JSONObject jsonObject = new JSONObject(result);
            JSONObject head = jsonObject.getJSONObject("head");
            if ("0000000".equals(head.getString("respCode"))) {
                analyzeData(result);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View view) {
        int i = view.getId();
        if (i == R.id.ll_shop_design) {
            //发起路由跳转
            ARouter.getInstance()
                    .build(ARouterManager.DesignListActivity)
                    .withString("msg", "我是商城页面进来的")
                    .navigation();
        } else if (i == R.id.ll_shop_materiel) {

        } else if (i == R.id.ll_shop_book) {

        } else if (i == R.id.ll_shop_machine) {

        } else if (i == R.id.ll_shop_lease) {

        }

    }


    @Override
    protected void initAdapter() {
        adapter = new MyBaseAdapter<ViewHolder>(beanlist.size()) {
            @Override
            public void onHolder(ViewHolder holder, int position) {
                //商品名称
                holder.tvShopTitle.setText(beanlist.get(position).getName());
                //主图
                Glide.with(getContext()).load(beanlist.get(position).getSubjectPicPath()).into(holder.ivShopImg);

                //转化金钱格式
                DecimalFormat df = new DecimalFormat("#,##0.00");
                String db2 = df.format(beanlist.get(position).getPrice());


                holder.tvShopPrice.setText(db2);
                if ("".equals(beanlist.get(position).getSalesVolume())) {
                    holder.tvShopOrder.setText(0 + "人已付款");
                } else {
                    holder.tvShopOrder.setText(beanlist.get(position).getSalesVolume() + "人已付款");
                }
            }

            @Override
            public ViewHolder onCreateViewHolder() {
                return new ViewHolder(getViewByRes(R.layout.item_shop));
            }
        };
        lvShop.setAdapter(adapter);
    }

    public class ViewHolder extends BaseViewHolder {
        public View rootView;
        private RoundImageView ivShopImg;
        private TextView tvShopTitle;
        private TextView tvShopPrice;
        private TextView tvShopOrder;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.ivShopImg = rootView.findViewById(R.id.iv_shop_img);
            this.tvShopTitle = rootView.findViewById(R.id.tv_shop_title);
            this.tvShopPrice = rootView.findViewById(R.id.tv_shop_price);
            this.tvShopOrder = rootView.findViewById(R.id.tv_shop_order);
        }

        @Override
        public View createView() {
            return rootView;
        }
    }


    private void analyzeData(String response) {
        ShopBean b = new Gson().fromJson(response, ShopBean.class);
        if (beanlist != null) {
            beanlist.clear();
        }
        beanlist.addAll(b.getBody().getDesignResults());
        adapter.notifyDataSetChanged(beanlist.size());
        List<ShopBean.BodyBean.BannersBean> getBannerslist = b.getBody().getBanners();
        ArrayList<String> mpiclist = new ArrayList<>();
        for (int i = 0; i < getBannerslist.size(); i++) {
            String imageUrl = getBannerslist.get(i).getImageUrl();
            mpiclist.add(imageUrl);
        }
        setBanner(mpiclist);
    }

    private void setBanner(List<String> movies) {
        mzBannerView.setDelayedTime(5000);
        mzBannerView.setBannerPageClickListener(new MZBannerView.BannerPageClickListener() {
            @Override
            public void onPageClick(View view, int position) {

            }
        });

        mzBannerView.setPages(movies, new MZHolderCreator<BannerViewHolder>() {
            @Override
            public BannerViewHolder createViewHolder() {
                return new BannerViewHolder();
            }
        });

        mzBannerView.start();


    }

    public static class BannerViewHolder implements MZViewHolder<String> {
        private ImageView mImageView;

        @Override
        public View createView(Context context) {
            View view = LayoutInflater.from(context).inflate(R.layout.remote_banner_item, null);
            mImageView = view.findViewById(R.id.remote_item_image);
            return view;
        }

        @Override
        public void onBind(Context context, int position, String data) {
            Glide.with(context).load(data).into(mImageView);
        }
    }
    @Subscribe
    public void onGetMsg(EventMsg msg){
        String msg1 = msg.getMsg();
        Toast.makeText(getActivity(),msg1,Toast.LENGTH_LONG);
    }


}
