package com.zhihuiye.inovationcourse;

import java.util.ArrayList;
import java.util.List;

public class Comic {
    private String name;
    private int imageId;
    private String desc;
    //构造函数
    public Comic(String name, int imageId, String desc) {
        this.name = name;
        this.imageId = imageId;
        this.desc = desc;
    }
    // 返回一个 Comic 的列表
    public static List<Comic> getAllComics() {
        List<Comic> comics = new ArrayList<Comic>();
        comics.add(new Comic("秦时明月之君临天下", R.drawable.qinshi, "《秦时明月之君临天下》是由沈乐平执导，玄机科技出品的中国 3D 武侠动画《秦时明月》系列的第五部作品。动画讲述了天明、少羽、石兰三人误打误撞登上了停泊在海边的蜃楼后开始了奇幻莫测的探险逃亡之旅的故事,然而主角时常集体掉线，堪称史上最惨主角们"));
        comics.add(new Comic("狐妖小红娘", R.drawable.huyao, "《狐妖小红娘》是根据同名漫画改编的“玄幻搞笑纯情虐恋”故事，讲述了以红娘为职业的狐妖在为前世恋人牵红线过程当中发生的一系列有趣、神秘的故事，这里不仅有人妖之恋的不渝，还能见 识各种角度的 flag。初次食用一定要熬过前五集。"));
        comics.add(new Comic("罗小黑战记", R.drawable.luoxiaohei, "《罗小黑战记》是中国大陆独立动画制作人 MTJJ 及其工作室制作的一部 FLASH 动画片，主要讲述的是猫妖盗取天明珠被谛听发现，被打回原形重伤而逃，流落街头之时被萌妹子罗小白带回 了家，起名罗小黑由此发生的种种离奇故事。动漫力争两月更新一集，一集七八分钟，处处是彩蛋，目前由于筹备大电影而停更，是我与作者比命长系列之典范。"));
        return comics;
    }
    // 以下都是访问内部属性的 getter 和 setter
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getImageId() {
        return imageId;
    }
    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
}
