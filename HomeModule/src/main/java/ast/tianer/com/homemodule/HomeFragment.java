package ast.tianer.com.homemodule;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.Glide;
import com.dreamlive.upmarqueeview.UPMarqueeView;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.smile.ch.common.Constants.BaseUrls;
import com.smile.ch.common.adapter.BaseViewHolder;
import com.smile.ch.common.adapter.MyBaseAdapter;
import com.smile.ch.common.base.ARouterManager;
import com.smile.ch.common.base.BaseFragment;
import com.smile.ch.common.view.HorizontalListView;
import com.smile.ch.common.view.MyGridView;
import com.smile.ch.common.view.RoundImageView;
import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;
import com.zhouwei.mzbanner.holder.MZViewHolder;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import ast.tianer.com.homemodule.bean.HomeBean;

/**
 * @author RuanWei
 * @date 2018/5/23 11:49
 */
@Route(path = ARouterManager.HomeFragment)
public class HomeFragment extends BaseFragment {
    MZBannerView mzBannerView;
    UPMarqueeView upview;
    HorizontalListView hlvHome;
    RoundImageView ivHome;
    TextView tvHomeTitle;
    TextView tvPrice;
    MyGridView gvHomeCourseware;
    MyGridView mgvModels;
    List<View> views = new ArrayList<>();

    LinearLayout ll_home_design;

    List<HomeBean.BodyBean.DesignResultsBean> designResultslist = new ArrayList<>();
    List<HomeBean.BodyBean.CoursewaresBean> coursewareslist = new ArrayList<>();
    List<HomeBean.BodyBean.ModelsBean> modelslist = new ArrayList<>();
    private MyBaseAdapter designResultsAdapter;
    private MyBaseAdapter excellentAdapter;
    private MyBaseAdapter modelsAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected View initView(View parent) {
        initLayout(parent);
        initAdapter();
        getData();

        return parent;
    }

    private void initLayout(View parent) {
        mzBannerView = parent.findViewById(R.id.banner_normal);
        upview = parent.findViewById(R.id.upview);
        hlvHome = parent.findViewById(R.id.hlv_home);
        ivHome = parent.findViewById(R.id.iv_home);
        tvHomeTitle = parent.findViewById(R.id.tv_home_title);
        tvPrice = parent.findViewById(R.id.tv_price);
        gvHomeCourseware = parent.findViewById(R.id.gv_home_courseware);
        mgvModels = parent.findViewById(R.id.mgv_models);
        ll_home_design = parent.findViewById(R.id.ll_home_design);
        ll_home_design.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //发起路由跳转
                ARouter.getInstance()
                        .build(ARouterManager.DesignListActivity)
                        .withString("msg", "我是首页进来的")
                        .navigation(getActivity(),999);
            }
        });
    }


    private void getData() {
        OkGo.<String>get(BaseUrls.doReadIndexInfo)
                .tag(this)
                .cacheMode(CacheMode.REQUEST_FAILED_READ_CACHE)
                .cacheKey(BaseUrls.doReadIndexInfo)
                .cacheTime(3600 * 1000)
                .params("cityName", "杭州")
                .params("userId", "F2EE5DC7DE3911E7B19800163E0EB16B")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        //UI线程 缓存读取成功后回调
                        responseData(response);
                    }

                    @Override
                    public void onCacheSuccess(Response<String> response) {
                        //UI线程 请求成功后回调
                        if (response.isFromCache()) {
                            responseData(response);
                        }
                    }

                    @Override
                    public void onError(Response<String> response) {
                        //UI线程 缓存读取失败后回调

                    }


                });

    }

    private void responseData(Response<String> response) {
        //UI线程 请求成功后回调
        String body = response.body();
        try {
            JSONObject jsonObject = new JSONObject(body);
            JSONObject head = jsonObject.getJSONObject("head");
            if ("0000000".equals(head.getString("respCode"))) {
                Gson gson = new Gson();
                HomeBean baseBean = gson.fromJson(body, HomeBean.class);
                analyzeData(baseBean);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    private void analyzeData(HomeBean baseBean) {
        //轮播图
        List<HomeBean.BodyBean.BannerImagesBean> bannerImages = baseBean.getBody().getBannerImages();
        //消息资讯
        List<HomeBean.BodyBean.InformationsBean> informations = baseBean.getBody().getInformations();
        //成果推荐
        List<HomeBean.BodyBean.DesignResultsBean> designResults = baseBean.getBody().getDesignResults();
        //优秀课件
        List<HomeBean.BodyBean.CoursewaresBean> coursewares = baseBean.getBody().getCoursewares();
        //精品小工具
        List<HomeBean.BodyBean.ModelsBean> models = baseBean.getBody().getModels();
        modelslist.addAll(models);
        //优秀课件
        if (coursewares.size() > 0) {
            HomeBean.BodyBean.CoursewaresBean coursewaresBean = coursewares.get(0);
            String idforcoursewaresone = coursewaresBean.getId();
            String subjectPicPath = coursewaresBean.getSubjectPicPath();
            String name = coursewaresBean.getName();
            String price = coursewaresBean.getPrice();
            Glide.with(mContext).load(subjectPicPath).into(ivHome);
            tvHomeTitle.setText(name);
            tvPrice.setText(price);
            for (int i = 1; i < coursewares.size(); i++) {
                HomeBean.BodyBean.CoursewaresBean coursewaresBean2 = coursewares.get(i);
                coursewareslist.add(coursewaresBean2);
            }
        }
        designResultslist.addAll(designResults);
        designResultsAdapter.notifyDataSetChanged(designResultslist.size());
        excellentAdapter.notifyDataSetChanged(coursewareslist.size());
        modelsAdapter.notifyDataSetChanged(modelslist.size());
        setBanner(bannerImages);
        setView(informations);
    }


    private void setBanner(final List<HomeBean.BodyBean.BannerImagesBean> movies) {
        mzBannerView.setDelayedTime(5000);
        mzBannerView.setBannerPageClickListener(new MZBannerView.BannerPageClickListener() {
            @Override
            public void onPageClick(View view, int position) {
                HomeBean.BodyBean.BannerImagesBean bannerImagesBean = movies.get(position);
                String linkUrl = bannerImagesBean.getLinkUrl();
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


    public static class BannerViewHolder implements MZViewHolder<HomeBean.BodyBean.BannerImagesBean> {
        private ImageView mImageView;

        @Override
        public View createView(Context context) {
            View view = LayoutInflater.from(context).inflate(R.layout.remote_banner_item, null);
            mImageView = (ImageView) view.findViewById(R.id.remote_item_image);
            return view;
        }

        @Override
        public void onBind(Context context, int position, HomeBean.BodyBean.BannerImagesBean data) {
            Glide.with(context).load(data.getImageUrl()).into(mImageView);
        }

    }


    private void setView(final List<HomeBean.BodyBean.InformationsBean> informations) {
        if (views.size() != 0) {
            views.clear();
        }
        for (int i = 0; i < informations.size(); i++) {
            final int position = i;
            //设置滚动的单个布局
            LinearLayout moreView = (LinearLayout) LayoutInflater.from(mContext).inflate(R.layout.item_view, null);
            //初始化布局的控件
            TextView tv1 = (TextView) moreView.findViewById(R.id.tv1);
            TextView tv2 = (TextView) moreView.findViewById(R.id.tv2);
            RelativeLayout rl = (RelativeLayout) moreView.findViewById(R.id.rl);
            RelativeLayout rl2 = (RelativeLayout) moreView.findViewById(R.id.rl2);

            rl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    HomeBean.BodyBean.InformationsBean informationsBean = informations.get(position);
                    String id1 = informationsBean.getId();
//                    Intent intent = new Intent(mContext, InformationDetailAcitivity.class);
//                    intent.putExtra("id", id1);
//                    startActivity(intent);
                }
            });

            rl2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    HomeBean.BodyBean.InformationsBean informationsBean = informations.get(position + 1);
                    String id2 = informationsBean.getId();
//                    Intent intent = new Intent(mContext, InformationDetailAcitivity.class);
//                    intent.putExtra("id", id2);
//                    startActivity(intent);
                }
            });

            //进行对控件赋值
            tv1.setText(informations.get(i).getTitle());
            if (informations.size() > i + 1) {
                //因为淘宝那儿是两条数据，但是当数据是奇数时就不需要赋值第二个，所以加了一个判断，还应该把第二个布局给隐藏掉
                tv2.setText(informations.get(i + 1).getTitle());
            } else {
                rl2.setVisibility(View.GONE);
            }

            //添加到循环滚动数组里面去
            views.add(moreView);
        }
        upview.setViews(views);
    }


    private void initAdapter() {
        designResultsAdapter = new MyBaseAdapter<ViewHolder>(designResultslist.size()) {
            @Override
            public void onHolder(ViewHolder holder, int position) {
                Glide.with(mContext).load(designResultslist.get(position).getSubjectPicPath()).into(holder.tvImg);
                holder.tvHomeTitle.setText(designResultslist.get(position).getName());
                holder.tvPrice.setText(designResultslist.get(position).getPrice());
            }

            @Override
            public ViewHolder onCreateViewHolder() {
                return new ViewHolder(getViewByRes(R.layout.result_list_item));
            }
        };

        hlvHome.setAdapter(designResultsAdapter);


        excellentAdapter = new MyBaseAdapter<ViewHolder>(coursewareslist.size()) {
            @Override
            public void onHolder(ViewHolder holder, int position) {
                Glide.with(mContext).load(coursewareslist.get(position).getSubjectPicPath()).into(holder.tvImg);
                holder.tvHomeTitle.setText(coursewareslist.get(position).getName());
                holder.tvPrice.setText(coursewareslist.get(position).getPrice());
            }

            @Override
            public ViewHolder onCreateViewHolder() {
                return new ViewHolder(getViewByRes(R.layout.course_grid_item));
            }
        };
        gvHomeCourseware.setAdapter(excellentAdapter);


        modelsAdapter = new MyBaseAdapter<ViewHolderModels>(modelslist.size()) {

            @Override
            public void onHolder(ViewHolderModels holder, final int position) {

                Glide.with(mContext).load(modelslist.get(position).getImgUrl()).into(holder.ivHome);
                holder.tvHomeTitle.setText(modelslist.get(position).getDesc());
                holder.tvContent.setText(modelslist.get(position).getIntro());

                holder.tvDesign.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        String jumpUrl = modelslist.get(position).getJumpUrl();
//                        Intent intent = new Intent(getContext(), Design3dActivity.class);
//                        intent.putExtra("jumpUrl", jumpUrl);
//                        startActivity(intent);
                    }
                });
            }

            @Override
            public ViewHolderModels onCreateViewHolder() {
                return new ViewHolderModels(getViewByRes(R.layout.item_home_sjmx));
            }
        };
        mgvModels.setAdapter(modelsAdapter);
    }


    public class ViewHolder extends BaseViewHolder {
        View rootView;
        RoundImageView tvImg;
        TextView tvHomeTitle;
        TextView tvPrice;

        ViewHolder(View rootView) {
            this.rootView = rootView;
            this.tvImg = (RoundImageView) rootView.findViewById(R.id.iv_home);
            this.tvHomeTitle = (TextView) rootView.findViewById(R.id.tv_home_title);
            this.tvPrice = (TextView) rootView.findViewById(R.id.tv_price);
        }

        @Override
        public View createView() {
            return rootView;
        }

    }

    public class ViewHolderModels extends BaseViewHolder {
        View rootView;
        TextView tvHomeTitle;
        TextView tvContent;
        RoundImageView ivHome;
        TextView tvDesign;

        ViewHolderModels(View rootView) {
            this.rootView = rootView;
            this.ivHome = (RoundImageView) rootView.findViewById(R.id.iv_home);
            this.tvHomeTitle = (TextView) rootView.findViewById(R.id.tv_home_title);
            this.tvContent = (TextView) rootView.findViewById(R.id.tv_content);
            this.tvDesign = (TextView) rootView.findViewById(R.id.tv_design);
        }

        @Override
        public View createView() {
            return rootView;
        }

    }


    @Override
    public void onPause() {
        super.onPause();
        mzBannerView.pause();//暂停轮播
    }

    @Override
    public void onResume() {
        super.onResume();
        mzBannerView.start();//开始轮播
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
