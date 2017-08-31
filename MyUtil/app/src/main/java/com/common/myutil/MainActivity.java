package com.common.myutil;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LayoutAnimationController;
import android.view.animation.TranslateAnimation;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private articleListAdapter articleAdapter;
    private List<ArticleList> data = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.lv_article);
        initData();
        listView.setLayoutAnimation(getListAnim());
        articleAdapter = new articleListAdapter(this,R.layout.article_item,data);
        listView.setAdapter(articleAdapter);
    }
    public void initData(){
        ArticleList articleList = new ArticleList();
        articleList.setContent("简介....");
        articleList.setTitle("第一章");
        articleList.setTime("2017");
        data.add(articleList);
        articleList = new ArticleList();
        articleList.setContent("简介....");
        articleList.setTitle("第二章");
        articleList.setTime("2017");
        data.add(articleList);
        articleList = new ArticleList();
        articleList.setContent("简介....");
        articleList.setTitle("第三章");
        articleList.setTime("2017");
        data.add(articleList);
        articleList = new ArticleList();
        articleList.setContent("简介....");
        articleList.setTitle("第四章");
        articleList.setTime("2017");
        data.add(articleList);
        articleList = new ArticleList();
        articleList.setContent("简介....");
        articleList.setTitle("第五章");
        articleList.setTime("2017");
        data.add(articleList);
        articleList = new ArticleList();
        articleList.setContent("简介....");
        articleList.setTitle("第六章");
        articleList.setTime("2017");
        data.add(articleList);
        articleList = new ArticleList();
        articleList.setContent("简介....");
        articleList.setTitle("第七章");
        articleList.setTime("2017");
        data.add(articleList);
        articleList = new ArticleList();
        articleList.setContent("简介....");
        articleList.setTitle("第八章");
        articleList.setTime("2017");
        data.add(articleList);
        articleList = new ArticleList();
        articleList.setContent("简介....");
        articleList.setTitle("第九章");
        articleList.setTime("2017");
        data.add(articleList);
        articleList = new ArticleList();
        articleList.setContent("简介....");
        articleList.setTitle("第十章");
        articleList.setTime("2017");
        data.add(articleList);

        articleList = new ArticleList();
        articleList.setContent("简介....");
        articleList.setTitle("第十一章");
        articleList.setTime("2017");
        data.add(articleList);
        articleList = new ArticleList();
        articleList.setContent("简介....");
        articleList.setTitle("第十二章");
        articleList.setTime("2017");
        data.add(articleList);
        articleList = new ArticleList();
        articleList.setContent("简介....");
        articleList.setTitle("第十三章");
        articleList.setTime("2017");
        data.add(articleList);
        articleList = new ArticleList();
        articleList.setContent("简介....");
        articleList.setTitle("第十四章");
        articleList.setTime("2017");
        data.add(articleList);
    }


    public LayoutAnimationController getListAnim() {
        AnimationSet set = new AnimationSet(true);
        Animation animation = new AlphaAnimation(0.0f, 1.0f);
        animation.setDuration(300);
        set.addAnimation(animation);

        animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                -1.0f, Animation.RELATIVE_TO_SELF, 0.0f);
        animation.setDuration(500);
        set.addAnimation(animation);
        LayoutAnimationController controller = new LayoutAnimationController(
                set, 0.5f);
        return controller;
    }
}
