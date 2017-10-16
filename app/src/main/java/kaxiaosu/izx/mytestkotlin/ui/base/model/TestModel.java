package kaxiaosu.izx.mytestkotlin.ui.base.model;

import java.util.List;

import kaxiaosu.izx.mytestkotlin.bean.NewsDetail;
import kaxiaosu.izx.mytestkotlin.ui.base.contract.TestContract;
import rx.Observable;

/**
 * Created by haohaitao on 17/7/27.
 */

public class TestModel implements TestContract.Model{
    @Override
    public Observable<NewsDetail> getOneNewsData(String postId) {
        return null;
    }
    private void changeNewsDetail(NewsDetail newsDetail) {
        List<NewsDetail.ImgBean> imgSrcs = newsDetail.getImg();
        if (isChange(imgSrcs)) {
            String newsBody = newsDetail.getBody();
            newsBody = changeNewsBody(imgSrcs, newsBody);
            newsDetail.setBody(newsBody);
        }
    }

    private boolean isChange(List<NewsDetail.ImgBean> imgSrcs) {
        return imgSrcs != null && imgSrcs.size() >= 2;
    }

    private String changeNewsBody(List<NewsDetail.ImgBean> imgSrcs, String newsBody) {
        for (int i = 0; i < imgSrcs.size(); i++) {
            String oldChars = "<!--IMG#" + i + "-->";
            String newChars;
            if (i == 0) {
                newChars = "";
            } else {
                newChars = "<img src=\"" + imgSrcs.get(i).getSrc() + "\" />";
            }
            newsBody = newsBody.replace(oldChars, newChars);

        }
        return newsBody;
    }
}
