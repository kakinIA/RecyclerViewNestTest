package com.example.cx.ganktest.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.cx.ganktest.GlideApp;
import com.example.cx.ganktest.R;
import com.example.cx.ganktest.bean.HomeModuleEntity;
import com.example.cx.ganktest.bean.MyHomeModuleEntity;
import com.example.cx.ganktest.bean.VideoImage;


import java.util.ArrayList;
import java.util.List;

/**
 * 首页多布局 适配器
 */

public class HomeMultipleAdapterNew2 extends BaseMultiItemQuickAdapter<MyHomeModuleEntity.ADataBean, BaseViewHolder> {


    private List<VideoImage> gamerVideoList;

    public HomeMultipleAdapterNew2(List<MyHomeModuleEntity.ADataBean> data) {
        super(data);
        init();
    }

    private void init() {
        //热门游戏
//        addItemType(MyHomeModuleEntity.TYPE_HOT_GAME_TITLE, R.layout.adapter_hometype_hotgame);
        //广告
//        addItemType(MyHomeModuleEntity.TYPE_AD, R.layout.view_banner);
        //猜你喜欢
        addItemType(MyHomeModuleEntity.TYPE_GUESS_YOU_LIKE_TITLE, R.layout.adapter_hometype_video);
        addItemType(MyHomeModuleEntity.TYPE_GUESS_YOU_LIKE, R.layout.adapter_video);
        //视频推荐
        addItemType(MyHomeModuleEntity.TYPE_SYSJ_VIDEO_TITLE, R.layout.adapter_hometype_video);
        addItemType(MyHomeModuleEntity.TYPE_SYSJ_VIDEO, R.layout.adapter_video);
        //热门解说
//        addItemType(MyHomeModuleEntity.TYPE_HOT_NARRATE, R.layout.adapter_hometype_hotnarrate);
        //游戏视频
        addItemType(MyHomeModuleEntity.TYPE_VIDEO_GROUP_TITLE, R.layout.adapter_hometype_video);
        addItemType(MyHomeModuleEntity.TYPE_VIDEO_GROUP, R.layout.adapter_video);
        //玩家视频
        addItemType(MyHomeModuleEntity.TYPE_GAMER_VIDEO_TITLE, R.layout.adapter_hometype_video);
        addItemType(MyHomeModuleEntity.TYPE_GAMER_VIDEO, R.layout.adapter_video);
    }

    @Override
    protected void convert(BaseViewHolder holder, MyHomeModuleEntity.ADataBean dataBean) {
        switch (dataBean.getItemType()) {

            case MyHomeModuleEntity.TYPE_GUESS_YOU_LIKE_TITLE: //猜你喜欢（视频类型)
                holder.setVisible(R.id.hometype_guess, true)
                        .addOnClickListener(R.id.hometype_youlike_change);
                holder.setVisible(R.id.rv_hometype, false);
                break;
            case MyHomeModuleEntity.TYPE_GUESS_YOU_LIKE:
                VideoImage ykVideoImage = changeVideoImageType(dataBean.getListBean());
                initVideoParams(holder, ykVideoImage);
                break;
            case MyHomeModuleEntity.TYPE_SYSJ_VIDEO_TITLE: //视界原创（视频类型）
                holder.setVisible(R.id.hometype_sysj, true)
                        .addOnClickListener(R.id.hometype_sysj);
                holder.setVisible(R.id.rv_hometype, false);
                break;
            case MyHomeModuleEntity.TYPE_SYSJ_VIDEO:
                VideoImage sysjVideoImage = changeVideoImageType(dataBean.getListBean());
                initVideoParams(holder, sysjVideoImage);
                break;
            case MyHomeModuleEntity.TYPE_VIDEO_GROUP_TITLE: //游戏视频（视频类型）
                holder.setVisible(R.id.rv_hometype, false);
                holder.setVisible(R.id.hometype_game, true)
                        .addOnClickListener(R.id.hometype_game);
                holder.setText(R.id.hoemtype_game_title, dataBean.getTitle());
                break;
            case MyHomeModuleEntity.TYPE_VIDEO_GROUP:
                VideoImage groupVideoImage = changeVideoImageType(dataBean.getListBean());
                initVideoParams(holder, groupVideoImage);
                break;
            case MyHomeModuleEntity.TYPE_GAMER_VIDEO_TITLE:
                holder.setVisible(R.id.rv_hometype, false);
                holder.setVisible(R.id.hometype_game, true);
                holder.setVisible(R.id.tv_more, false);
                holder.setVisible(R.id.iv_more, false);
                holder.setText(R.id.hoemtype_game_title, dataBean.getTitle());
                break;
            case MyHomeModuleEntity.TYPE_GAMER_VIDEO:
                VideoImage gamerVideoImage = changeVideoImageType(dataBean.getListBean());
                initVideoParams(holder, gamerVideoImage);
                break;
        }
    }

    private void setAdLayoutParmas(BaseViewHolder holder) {
        RelativeLayout container = holder.getView(R.id.container);
        WindowManager windowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        int srceenWidth = windowManager.getDefaultDisplay().getWidth();
        int height = (int) (((float) (srceenWidth)) / 7.5);

        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) container.getLayoutParams();
        if (params == null)
            params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, height);
        params.width = srceenWidth;
        params.height = height;
        container.setLayoutParams(params);
    }

    private void setRootLayoutParams(View view) {
        if (view != null) {
            WindowManager windowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
            int srceenWidth = windowManager.getDefaultDisplay().getWidth();
            // 86/148
            int w = (srceenWidth - (int)(mContext.getResources().getDisplayMetrics().density * (10 * 2))) / 2;
            int h = w * 9 / 16;
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, h);
            view.setLayoutParams(params);
        }
    }

    public static List<VideoImage> changeVideoImageType(List<HomeModuleEntity.ADataBean.ListBean> listBean) {
        List<VideoImage> videoImages = new ArrayList<>();
        for (int i = 0; i < listBean.size(); i++) {
            VideoImage videoImage = new VideoImage();
            HomeModuleEntity.ADataBean.ListBean dataBean = listBean.get(i);
            videoImage.setFlag(dataBean.getFlag());
            videoImage.setVideo_id(dataBean.getVideo_id());
            videoImage.setTitle(dataBean.getTitle());
            videoImage.setClick_count(dataBean.getClick_count());
            videoImage.setYk_url(dataBean.getYk_url());
            videoImage.setQn_key(dataBean.getQn_key());
            videoImage.setFlagPath(dataBean.getFlagPath());
            videoImage.setIsRecommend(dataBean.getIsRecommend());
            videoImage.setPic_flsp(dataBean.getPic_flsp());
            videoImage.setAvatar(dataBean.getAvatar());
            videoImage.setTime_length(dataBean.getTime_length());
            videoImage.setNickname(dataBean.getNickname());
            videoImage.setMember_id(dataBean.getMember_id());
            videoImages.add(videoImage);
        }
        return videoImages;
    }

    public static VideoImage changeVideoImageType(HomeModuleEntity.ADataBean.ListBean listBean) {
        VideoImage videoImage = new VideoImage();
        HomeModuleEntity.ADataBean.ListBean dataBean = listBean;
        videoImage.setFlag(dataBean.getFlag());
        videoImage.setVideo_id(dataBean.getVideo_id());
        videoImage.setTitle(dataBean.getTitle());
        videoImage.setClick_count(dataBean.getClick_count());
        videoImage.setYk_url(dataBean.getYk_url());
        videoImage.setQn_key(dataBean.getQn_key());
        videoImage.setFlagPath(dataBean.getFlagPath());
        videoImage.setIsRecommend(dataBean.getIsRecommend());
        videoImage.setPic_flsp(dataBean.getPic_flsp());
        videoImage.setAvatar(dataBean.getAvatar());
        videoImage.setTime_length(dataBean.getTime_length());
        videoImage.setNickname(dataBean.getNickname());
        videoImage.setMember_id(dataBean.getMember_id());
        return videoImage;
    }

    private void initVideoParams(BaseViewHolder holder, VideoImage videoImage) {
        setRootLayoutParams(holder.getView(R.id.root));
        TextView title = holder.getView(R.id.video_title);
        ImageView cover = holder.getView(R.id.video_cover);
        TextView allTime = holder.getView(R.id.video_allTime);
        ImageView avatar = holder.getView(R.id.civ_user);//FIXME 这里采用CircleImageView 可能会出错
        TextView nickname= holder.getView(R.id.tv_up_user_name);

        // 标题
        title.setText(videoImage.getTitle());
        //作者名字
        nickname.setText(videoImage.getNickname());
        // 播放时长
        allTime.setText(videoImage.getTime_length());
        // 封面
        GlideApp.with(mContext).load(videoImage.getFlagPath()).into(cover);
        //上传主的头像
        GlideApp.with(mContext).load(videoImage.getAvatar()).into(avatar);
    }


}
