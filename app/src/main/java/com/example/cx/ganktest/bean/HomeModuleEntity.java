package com.example.cx.ganktest.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 新版本-首页分栏数据
 */

public class HomeModuleEntity implements Cloneable {


    public static final int TYPE_HOT_GAME = 0;          //热门游戏
    public static final int TYPE_AD = 1;                //通栏广告
    public static final int TYPE_GUESS_YOU_LIKE = 2;    //猜你喜欢
    public static final int TYPE_SYSJ_VIDEO = 3;        //视界原创
    public static final int TYPE_HOT_NARRATE = 4;       //热门主播
    public static final int TYPE_VIDEO_GROUP = 5;       //游戏视频
    public static final int TYPE_GAMER_VIDEO = 6;       //玩家视频


    /**
     * AData : [{"more_mark":"","flag":"banner","title":"幻灯图","list":[{"type":"activity","type_id":"132","title":"手游视界陪练模块上线","flag":"59a386c30e61a.jpg","go_url":"http://www.17sysj.com/act/pljs/","match_id":"132","flagPath":"http://192.168.48.9:233/Public/Uploads/Focuse/Flag/59a386c30e61a.jpg"},{"type":"video","type_id":"4898767","title":"《快递小哥》帝王变身快递小哥去送快递啦！","flag":"video_20170824184146528.jpg","go_url":"","video_id":"4898767","flagPath":"http://cover.17sysj.com/video_20170824184146528.jpg?imageView2/2/h/200","yk_url":"","qn_key":"lpds_c5a22d2d0726b"},{"type":"video","type_id":"4899769","title":"《王者荣耀》荣耀大神秀第36期刺客操作要领全解析","flag":"video_20170824142810239.jpg","go_url":"","video_id":"4899769","flagPath":"http://cover.17sysj.com/video_20170824142810239.jpg?imageView2/2/h/200","yk_url":"","qn_key":"bj_rydsx36"},{"type":"event","type_id":"596","title":"《王者荣耀》实力对垒","flag":"598c1a0ba7c75.jpg","go_url":"","event_id":"596","flagPath":"http://192.168.48.9:233/Public/Uploads/Event/Flag/598c1a0ba7c75.jpg"},{"type":"video","type_id":"4879543","title":"《FACE DANCE》试玩 这游戏随手一截就是表情包","flag":"video_20170823171347584.jpg","go_url":"","video_id":"4879543","flagPath":"http://cover.17sysj.com/video_20170823171347584.jpg?imageView2/2/h/200","yk_url":"","qn_key":"lpds_00c85fd40722b"},{"type":"video","type_id":"4879765","title":"【王者快报】新版本\u201c齐聚长城\u201d速看 8月24更新内容一览","flag":"video_20170823154431456.jpg","go_url":"","video_id":"4879765","flagPath":"http://cover.17sysj.com/video_20170823154431456.jpg?imageView2/2/h/200","yk_url":"","qn_key":"sysj_dSGU5EeIzvH3a"}],"icon_pic":""},{"more_mark":"","flag":"hotGame","title":"热门游戏","list":[{"group_id":"109","game_id":"5057","group_name":"王者荣耀","flag":"http://192.168.48.9:233/Public/Uploads/Game/Flag/591960b021a9f.png","url":""},{"group_id":"30","game_id":"93","group_name":"我的世界","flag":"http://192.168.48.9:233/Public/Uploads/Game/Flag/5919620dd04e5.png","url":""},{"group_id":"112","game_id":"8128","group_name":"穿越火线","flag":"http://192.168.48.9:233/Public/Uploads/Game/Flag/591962f9ddb95.png","url":""},{"group_id":"713","game_id":"4804","group_name":"球球大作战","flag":"http://192.168.48.9:233/Public/Uploads/Game/Flag/59196e76d02b2.png","url":""},{"group_id":"804","game_id":"5028","group_name":"火影忍者","flag":"http://192.168.48.9:233/Public/Uploads/Game/Flag/591963caaa620.png","url":""},{"group_id":"172","game_id":"101","group_name":"节奏大师","flag":"http://192.168.48.9:233/Public/Uploads/Game/Flag/54a39739b9b7d.png","url":""},{"group_id":"1538","game_id":"9710","group_name":"滚动的天空","flag":"http://192.168.48.9:233/Public/Uploads/Game/Flag/57ff62a3deb8f.png","url":""},{"group_id":"1293","game_id":"9042","group_name":"皇室战争","flag":"http://192.168.48.9:233/Public/Uploads/Game/Flag/591963aca4b34.png","url":""},{"group_id":"1459","game_id":"9262","group_name":"迷你世界","flag":"http://192.168.48.9:233/Public/Uploads/Game/Flag/574e8f5149ebb.gif","url":""},{"group_id":"496","game_id":"2262","group_name":"全民突击","flag":"http://192.168.48.9:233/Public/Uploads/Game/Flag/59196f559fc13.png","url":""},{"group_id":"113","game_id":"75","group_name":"部落冲突","flag":"http://192.168.48.9:233/Public/Uploads/Game/Flag/5919635cc3662.png","url":""},{"group_id":"110","game_id":"88","group_name":"全民枪战","flag":"http://192.168.48.9:233/Public/Uploads/Game/Flag/59196f0d5828a.png","url":""},{"group_id":"164","game_id":"92","group_name":"天天炫斗","flag":"http://192.168.48.9:233/Public/Uploads/Game/Flag/59196ff053a88.png","url":""},{"group_id":"1524","game_id":"9625","group_name":"贪吃蛇大作战","flag":"http://192.168.48.9:233/Public/Uploads/Game/Flag/59196fc968f18.png","url":""},{"group_id":"1513","game_id":"9629","group_name":"全民斗战神","flag":"http://192.168.48.9:233/Public/Uploads/Game/Flag/59196ee829b48.png","url":""},{"group_id":"473","game_id":"2002","group_name":"泰拉瑞亚","flag":"http://192.168.48.9:233/Public/Uploads/Game/Flag/59196f822d039.png","url":""},{"group_id":"1103","game_id":"8799","group_name":"时空召唤","flag":"http://192.168.48.9:233/Public/Uploads/Game/Flag/591964878658a.png","url":""},{"group_id":"1532","game_id":"9372","group_name":"阴阳师","flag":"http://192.168.48.9:233/Public/Uploads/Game/Flag/59196465c2188.png","url":""},{"group_id":"29","game_id":"39","group_name":"海岛奇兵","flag":"http://192.168.48.9:233/Public/Uploads/Game/Flag/5919637b8f10e.png","url":""},{"group_id":"803","game_id":"5027","group_name":"炉石传说","flag":"http://192.168.48.9:233/Public/Uploads/Game/Flag/55c170350c110.png","url":""}],"icon_pic":""},{"video_ids":"4977020,4943214,4918381,4938486","more_mark":"","flag":"guessVideo","title":"猜你喜欢","list":[{"video_id":"4918381","title":"《吃豆大作战》趣萌休闲手游 再看就吃掉你！","flag":"pic_fb813e3e4754","pic_flsp":"","pic_mrgx":"","click_count":"49757","yk_url":"","qn_key":"lpds_6e02c74e7671b","time_length":"1504602370","cover_position":"1","flagPath":"http://cover.17sysj.com/pic_fb813e3e4754?imageView2/2/h/200"},{"video_id":"4938486","title":"《部落冲突》棍总天女蓝矿应变三星满十一防三","flag":"pic_e4af5b952542","pic_flsp":"","pic_mrgx":"","click_count":"37243","yk_url":"","qn_key":"lpds_c292628a3965b","time_length":"1503892693","cover_position":"1","flagPath":"http://cover.17sysj.com/pic_e4af5b952542?imageView2/2/h/200"},{"video_id":"4943214","title":"（星仔解说）王者荣耀新手秀第十期，用死亡骑士5连胜!","flag":"pic_6a2f7eb04799","pic_flsp":"","pic_mrgx":"","click_count":"35519","yk_url":"","qn_key":"lpds_494e0a596350b","time_length":"1503802021","cover_position":"1","flagPath":"http://cover.17sysj.com/pic_6a2f7eb04799?imageView2/2/h/200"},{"video_id":"4977020","title":"《火影忍者》落岩秘境磨血打法","flag":"pic_dd8bdba11811","pic_flsp":"","pic_mrgx":"","click_count":"32332","yk_url":"","qn_key":"lpds_f07c33556040b","time_length":"1503974925","cover_position":"1","flagPath":"http://cover.17sysj.com/pic_dd8bdba11811?imageView2/2/h/200"}],"icon_pic":""},{"isGame":"0","group_id":"","game_id":"","list":[{"video_id":"4937731","title":"【王者快报】诸葛亮貂蝉甄姬新皮肤 狄仁杰新模型","flag":"video_201708261436141070.jpg","pic_flsp":"","pic_mrgx":"","click_count":"44283","yk_url":"","qn_key":"sysj_G7wTp4WROhGNa","time_length":"1503729385","cover_position":"1","isRecommend":1,"flagPath":"http://cover.17sysj.com/video_201708261436141070.jpg?imageView2/2/h/200"},{"video_id":"4899769","title":"《王者荣耀》荣耀大神秀第36期刺客操作要领全解析","flag":"video_20170824142851730.jpg","pic_flsp":"","pic_mrgx":"video_20170824142810239.jpg","click_count":"13127","yk_url":"","qn_key":"bj_rydsx36","time_length":"1503556234","cover_position":"1","isRecommend":1,"flagPath":"http://cover.17sysj.com/video_20170824142851730.jpg?imageView2/2/h/200"},{"video_id":"4894734","title":"《方块大乱》小张解说 比球球好玩十倍的游戏！","flag":"pic_18db6b719163","pic_flsp":"","pic_mrgx":"video_20170824102752468.jpg","click_count":"43072","yk_url":"","qn_key":"lpds_4ba4f6db9029a","time_length":"1503541695","cover_position":"1","isRecommend":1,"flagPath":"http://cover.17sysj.com/pic_18db6b719163?imageView2/2/h/200"},{"video_id":"4879543","title":"《FACE DANCE》试玩 这游戏随手一截就是表情包","flag":"video_20170823170520243.jpg","pic_flsp":"","pic_mrgx":"video_20170823171347584.jpg","click_count":"27930","yk_url":"","qn_key":"lpds_00c85fd40722b","time_length":"1503479664","cover_position":"1","isRecommend":1,"flagPath":"http://cover.17sysj.com/video_20170823170520243.jpg?imageView2/2/h/200"}],"more_mark":"","flag":"sysj_original","title":"视界推荐","icon_pic":""},{"more_mark":"","flag":"hotMember","title":"热门解说","list":[{"member_id":"60","nickname":"小小舞","avatar":"http://192.168.48.9:233/Public/Uploads/Member/Avatar/56f8a34a68ff6.jpg","sex":"0","upload_time":"1444448965"},{"member_id":"9","nickname":"admin","avatar":"http://192.168.48.9:233/Public/Uploads/Member/Avatar/default.png","sex":"0","upload_time":"1505123759"},{"member_id":"269092","nickname":"孤独海怪69","avatar":"http://192.168.48.9:233/Public/Uploads/Member/Avatar/5857f6cef3677.jpg","sex":"1","upload_time":"1499308691"},{"member_id":"229027","nickname":"清雨","avatar":"http://192.168.48.9:233/Public/Uploads/Member/Avatar/5914422e53d61.jpg","sex":"1","upload_time":"1452968776"},{"member_id":"230653","nickname":"小玄","avatar":"http://192.168.48.9:233/Public/Uploads/Member/Avatar/586651a675c35.jpg","sex":"1","upload_time":"1453128057"},{"member_id":"82609","nickname":"天下吟唱","avatar":"http://192.168.48.9:233/Public/Uploads/Member/Avatar/563efa2cc907c.jpg","sex":"1","upload_time":"1450694837"},{"member_id":"93992","nickname":"小小诺","avatar":"http://192.168.48.9:233/Public/Uploads/Member/Avatar/5708b22cb9cda.jpg","sex":"1","upload_time":"1445148385"},{"member_id":"194212","nickname":"喵老师","avatar":"http://192.168.48.9:233/Public/Uploads/Member/Avatar/5866f76e169bc.jpg","sex":"1","upload_time":"1454687525"},{"member_id":"169442","nickname":"Boss天","avatar":"http://192.168.48.9:233/Public/Uploads/Member/Avatar/56ec4d7d622c9.jpg","sex":"1","upload_time":"1456653812"},{"member_id":"284263","nickname":"舒奇yokuwa","avatar":"http://192.168.48.9:233/Public/Uploads/Member/Avatar/5942bad7a41f3.jpg","sex":"0","upload_time":"1456552183"},{"member_id":"81458","nickname":"晨风","avatar":"http://192.168.48.9:233/Public/Uploads/Member/Avatar/5849113ad6ee1.jpg","sex":"1","upload_time":"1444440983"},{"member_id":"243564","nickname":"ぜ桩桩Roger's","avatar":"http://192.168.48.9:233/Public/Uploads/Member/Avatar/575a83480e976.jpg","sex":"1","upload_time":"1456576371"},{"member_id":"252145","nickname":"可爱的小公举","avatar":"http://192.168.48.9:233/Public/Uploads/Member/Avatar/57bbc29ed9986.jpg","sex":"1","upload_time":"1456477411"},{"member_id":"235638","nickname":"许生解说","avatar":"http://192.168.48.9:233/Public/Uploads/Member/Avatar/56a0d1b3eef0e.jpg","sex":"1","upload_time":"1456365659"},{"member_id":"57","nickname":"小小白","avatar":"http://192.168.48.9:233/Public/Uploads/Member/Avatar/562a5ad75b27c.jpg","sex":"1","upload_time":"1450323509"},{"member_id":"48","nickname":"舞大大","avatar":"http://192.168.48.9:233/Public/Uploads/Member/Avatar/56f8ef20d9496.jpg","sex":"0","upload_time":"1445219571"},{"member_id":"54","nickname":"胖哥","avatar":"http://192.168.48.9:233/Public/Uploads/Member/Avatar/568cc7b4cfe62.jpg","sex":"0","upload_time":"1444360425"},{"member_id":"183036","nickname":"骏Gg","avatar":"http://192.168.48.9:233/Public/Uploads/Member/Avatar/56a35c2bf11e4.jpg","sex":"1","upload_time":"1450181035"},{"member_id":"59","nickname":"SJ","avatar":"http://192.168.48.9:233/Public/Uploads/Member/Avatar/56455854f4212.jpg","sex":"1","upload_time":"1452679579"},{"member_id":"56","nickname":"视界小柿","avatar":"http://192.168.48.9:233/Public/Uploads/Member/Avatar/pc_1464764520678.jpg","sex":"0","upload_time":"1444464476"}],"icon_pic":""}]
     * OData : null
     * page_count : 4
     */


    private int page_count;
    private List<ADataBean> AData;

    private boolean result = false;
    private int code;

    private String status;

    private int total_page;

    public int getPage_count() {
        return page_count;
    }

    public void setPage_count(int page_count) {
        this.page_count = page_count;
    }

    public List<ADataBean> getAData() {
        return AData;
    }

    public void setAData(List<ADataBean> AData) {
        this.AData = AData;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isResult() {
        return result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public int getTotal_page() {
        return total_page;
    }

    public void setTotal_page(int total_page) {
        this.total_page = total_page;
    }

    public static class ADataBean implements MultiItemEntity, Cloneable {
        public static final int TITLE_SPAN_SIZE = 1;
        public static final int VIDEO_SPAN_SIZE = 2;

        private int mItemType;
        private int spanSize;


        public void setItemType(int itemType) {
            mItemType = itemType;
        }

        @Override
        public int getItemType() {
            return mItemType;
        }

        public int getSpanSize() {
            return spanSize;
        }

        public void setSpanSize(int spanSize) {
            this.spanSize = spanSize;
        }

        /**
         * more_mark :
         * flag : banner
         * title : 幻灯图
         * list : [{"type":"activity","type_id":"132","title":"手游视界陪练模块上线","flag":"59a386c30e61a.jpg","go_url":"http://www.17sysj.com/act/pljs/","match_id":"132","flagPath":"http://192.168.48.9:233/Public/Uploads/Focuse/Flag/59a386c30e61a.jpg"},{"type":"video","type_id":"4898767","title":"《快递小哥》帝王变身快递小哥去送快递啦！","flag":"video_20170824184146528.jpg","go_url":"","video_id":"4898767","flagPath":"http://cover.17sysj.com/video_20170824184146528.jpg?imageView2/2/h/200","yk_url":"","qn_key":"lpds_c5a22d2d0726b"},{"type":"video","type_id":"4899769","title":"《王者荣耀》荣耀大神秀第36期刺客操作要领全解析","flag":"video_20170824142810239.jpg","go_url":"","video_id":"4899769","flagPath":"http://cover.17sysj.com/video_20170824142810239.jpg?imageView2/2/h/200","yk_url":"","qn_key":"bj_rydsx36"},{"type":"event","type_id":"596","title":"《王者荣耀》实力对垒","flag":"598c1a0ba7c75.jpg","go_url":"","event_id":"596","flagPath":"http://192.168.48.9:233/Public/Uploads/Event/Flag/598c1a0ba7c75.jpg"},{"type":"video","type_id":"4879543","title":"《FACE DANCE》试玩 这游戏随手一截就是表情包","flag":"video_20170823171347584.jpg","go_url":"","video_id":"4879543","flagPath":"http://cover.17sysj.com/video_20170823171347584.jpg?imageView2/2/h/200","yk_url":"","qn_key":"lpds_00c85fd40722b"},{"type":"video","type_id":"4879765","title":"【王者快报】新版本\u201c齐聚长城\u201d速看 8月24更新内容一览","flag":"video_20170823154431456.jpg","go_url":"","video_id":"4879765","flagPath":"http://cover.17sysj.com/video_20170823154431456.jpg?imageView2/2/h/200","yk_url":"","qn_key":"sysj_dSGU5EeIzvH3a"}]
         * icon_pic :
         * video_ids : 4977020,4943214,4918381,4938486
         * isGame : 0
         * group_id :
         * game_id :
         */

        private String more_mark;
        private String flag;
        private String title;
        private String icon_pic;
        private String video_ids;
        private String isGame;
        private String group_id;
        private String game_id;
        private List<ListBean> list;

        public String getMore_mark() {
            return more_mark;
        }

        public void setMore_mark(String more_mark) {
            this.more_mark = more_mark;
        }

        public String getFlag() {
            return flag;
        }

        public void setFlag(String flag) {
            this.flag = flag;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getIcon_pic() {
            return icon_pic;
        }

        public void setIcon_pic(String icon_pic) {
            this.icon_pic = icon_pic;
        }

        public String getVideo_ids() {
            return video_ids;
        }

        public void setVideo_ids(String video_ids) {
            this.video_ids = video_ids;
        }

        public String getIsGame() {
            return isGame;
        }

        public void setIsGame(String isGame) {
            this.isGame = isGame;
        }

        public String getGroup_id() {
            return group_id;
        }

        public void setGroup_id(String group_id) {
            this.group_id = group_id;
        }

        public String getGame_id() {
            return game_id;
        }

        public void setGame_id(String game_id) {
            this.game_id = game_id;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public void clearList() {
            this.list.clear();
        }


        public static class ListBean implements Cloneable {
            /**
             * type : activity
             * type_id : 132
             * title : 手游视界陪练模块上线
             * flag : 59a386c30e61a.jpg
             * go_url : http://www.17sysj.com/act/pljs/
             * match_id : 132
             * flagPath : http://192.168.48.9:233/Public/Uploads/Focuse/Flag/59a386c30e61a.jpg
             * video_id : 4898767
             * yk_url :
             * qn_key : lpds_c5a22d2d0726b
             * event_id : 596
             */

            private String type;
            private String type_id;
            private String title;
            private String flag;
            private String go_url;
            private String match_id;
            private String flagPath;
            private String video_id;
            private String yk_url;
            private String qn_key;
            private String event_id;
            private String group_id;
            private String game_id;
            private String group_name;
            private String url;
            private String click_count;
            private String video_name;//为了适配上一个版本
            private String more_mark;
            private String time_length;
            private String pic_flsp;
            private String pic_mrgx;
            private String isRecommend;
            private String cover_position;
            private String member_id;
            private String nickname;
            private String avatar;
            private int sex;
            private String upload_time;

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public int getSex() {
                return sex;
            }

            public void setSex(int sex) {
                this.sex = sex;
            }

            public String getUpload_time() {
                return upload_time;
            }

            public void setUpload_time(String upload_time) {
                this.upload_time = upload_time;
            }

            public String getMember_id() {
                return member_id;
            }

            public void setMember_id(String member_id) {
                this.member_id = member_id;
            }

            public String getPic_flsp() {
                return pic_flsp;
            }

            public void setPic_flsp(String pic_flsp) {
                this.pic_flsp = pic_flsp;
            }

            public String getPic_mrgx() {
                return pic_mrgx;
            }

            public void setPic_mrgx(String pic_mrgx) {
                this.pic_mrgx = pic_mrgx;
            }

            public String getIsRecommend() {
                return isRecommend;
            }

            public void setIsRecommend(String isRecommend) {
                this.isRecommend = isRecommend;
            }

            public String getCover_position() {
                return cover_position;
            }

            public void setCover_position(String cover_position) {
                this.cover_position = cover_position;
            }

            public String getTime_length() {
                return time_length;
            }

            public void setTime_length(String time_length) {
                this.time_length = time_length;
            }

            public String getMore_mark() {
                return more_mark;
            }

            public void setMore_mark(String more_mark) {
                this.more_mark = more_mark;
            }

            public String getVideo_name() {
                return video_name;
            }

            public void setVideo_name(String video_name) {
                this.video_name = video_name;
            }

            public String getClick_count() {
                return click_count;
            }

            public void setClick_count(String click_count) {
                this.click_count = click_count;
            }

            private String package_id;
            private String time;


            public String getPackage_id() {
                return package_id;
            }

            public void setPackage_id(String package_id) {
                this.package_id = package_id;
            }


            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public String getGroup_id() {
                return group_id;
            }

            public void setGroup_id(String group_id) {
                this.group_id = group_id;
            }

            public String getGame_id() {
                return game_id;
            }

            public void setGame_id(String game_id) {
                this.game_id = game_id;
            }

            public String getGroup_name() {
                return group_name;
            }

            public void setGroup_name(String group_name) {
                this.group_name = group_name;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getType_id() {
                return type_id;
            }

            public void setType_id(String type_id) {
                this.type_id = type_id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getFlag() {
                return flag;
            }

            public void setFlag(String flag) {
                this.flag = flag;
            }

            public String getGo_url() {
                return go_url;
            }

            public void setGo_url(String go_url) {
                this.go_url = go_url;
            }

            public String getMatch_id() {
                return match_id;
            }

            public void setMatch_id(String match_id) {
                this.match_id = match_id;
            }

            public String getFlagPath() {
                return flagPath;
            }

            public void setFlagPath(String flagPath) {
                this.flagPath = flagPath;
            }

            public String getVideo_id() {
                return video_id;
            }

            public void setVideo_id(String video_id) {
                this.video_id = video_id;
            }

            public String getYk_url() {
                return yk_url;
            }

            public void setYk_url(String yk_url) {
                this.yk_url = yk_url;
            }

            public String getQn_key() {
                return qn_key;
            }

            public void setQn_key(String qn_key) {
                this.qn_key = qn_key;
            }

            public String getEvent_id() {
                return event_id;
            }

            public void setEvent_id(String event_id) {
                this.event_id = event_id;
            }

            @Override
            public Object clone() throws CloneNotSupportedException {
                return super.clone();
            }
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            ADataBean aDataBean = (ADataBean) super.clone();
            List<ListBean> listBeen = new ArrayList<>();
            Iterator<ListBean> iterator = this.list.iterator();
            while (iterator.hasNext()) {
                listBeen.add((ListBean) iterator.next().clone());
            }
            aDataBean.list = listBeen;
            return aDataBean;
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        HomeModuleEntity entity = (HomeModuleEntity) super.clone();
        if (this.AData != null) {
            List<ADataBean> aDataBeanList = new ArrayList<>();
            for (ADataBean aDataBean : this.AData) {
                try {
                    aDataBeanList.add((ADataBean) aDataBean.clone());
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }
            }
            entity.AData = aDataBeanList;
        }

        return entity;

    }
}
