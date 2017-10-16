package kaxiaosu.izx.mytestkotlin.ui.base.contract;

import kaxiaosu.izx.mytestkotlin.bean.NewsDetail;
import kaxiaosu.izx.mytestkotlin.ui.base.BaseModel;
import kaxiaosu.izx.mytestkotlin.ui.base.BasePresenter;
import kaxiaosu.izx.mytestkotlin.ui.base.BaseView;
import rx.Observable;

/**
 * Created by haohaitao on 17/7/27.
 */

public interface TestContract {
    interface Model extends BaseModel {
        //请求获取新闻
        Observable<NewsDetail> getOneNewsData(String postId);
    }

    interface View extends BaseView {
        //返回获取的新闻
        void returnOneNewsData(NewsDetail newsDetail);
    }
    abstract static class Presenter extends BasePresenter<View, Model> {
        //发起获取单条新闻请求
        public abstract void getOneNewsDataRequest(String postId);
    }
}
