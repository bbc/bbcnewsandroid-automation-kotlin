package com.bbcnews.automation.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MyNewsPageObject {

    public MyNewsPageObject() {

    }

    @AndroidFindAll({
            @AndroidBy(id = "bbc.mobile.news.uk.internal:id/title"),
            @AndroidBy(id = "bbc.mobile.news.uk:id/title")
    })
    public MobileElement myNewsTitle;

    @AndroidFindBy(accessibility = "OK, let's get started Button:")
    public MobileElement myNewsStartButton;

    @AndroidFindAll({
            @AndroidBy(id = "bbc.mobile.news.uk.internal:id/summary"),
            @AndroidBy(id = "bbc.mobile.news.uk:id/summary")
    })
    public MobileElement myNewsSummary;

    @AndroidFindAll({
            @AndroidBy(id = "bbc.mobile.news.uk.internal:id/icon"),
            @AndroidBy(id = "bbc.mobile.news.uk:id/icon")
    })
    public MobileElement addNewsButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='My Topics']")
    public MobileElement myTopics;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Add Topics']")
    public MobileElement addTopics;

    @AndroidFindBy(accessibility = "Topic heading,Local news")
    public MobileElement localNews;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Allow location']")
    public MobileElement allowLocation;

    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
    public MobileElement allowLocationPermission;

    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_deny_button")
    public MobileElement allowLocationPermissionDeny;

    @AndroidFindAll({
            @AndroidBy(id = "bbc.mobile.news.uk.internal:id/request_permission"),
            @AndroidBy(id = "bbc.mobile.news.uk:id/request_permission")
    })
    public MobileElement locationButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Edit My News']")
    public MobileElement editMyTopics;

    @AndroidFindAll({
            @AndroidBy(id = "bbc.mobile.news.uk.internal:id/empty_text_view"),
            @AndroidBy(id = "bbc.mobile.news.uk:id/empty_text_view")
    })
    public MobileElement myTopicEmptyView;

    public String myNewsTitleText = "Add Topics to create your own personal news feed";

    public String myNewsSummaryText = "All the latest stories from your topics will appear here.";

    public String myTopicEmptyViewText = "Your added topics will be displayed here";

    @AndroidFindBy(accessibility = "Add topic")
    public MobileElement myNewsAddTopics;

    @AndroidFindBy(accessibility = "Edit My News")
    public MobileElement editMyNews;

    @AndroidFindBy(accessibility = "Remove topic")
    public MobileElement removeTopics;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Manchester']")
    public MobileElement localNewsDisplayed;

    @AndroidFindBy(xpath = "//android.support.v7.widget.RecyclerView[@index='3']")
    public MobileElement myNewsRecyclerView;

    @AndroidFindBy(accessibility = "Audio and Video")
    public MobileElement asiaVideoAudioSection;

    public String[] articlePageElements = {
            //"bbc.mobile.news.uk.internal:id/imageItemBadge",
            "bbc.mobile.news.uk.internal:id/headlineInfo",
            "bbc.mobile.news.uk.internal:id/headlineTitle",
            "bbc.mobile.news.uk.internal:id/image_item",
            "bbc.mobile.news.uk.internal:id/headlineLink",
    };

    public String[] articlePageElementsRelease = {
            //"bbc.mobile.news.uk:id/imageItemBadge",
            "bbc.mobile.news.uk:id/headlineInfo",
            "bbc.mobile.news.uk:id/headlineTitle",
            "bbc.mobile.news.uk:id/image_item",
            "bbc.mobile.news.uk:id/headlineLink",
    };

    public String[] articlePageView = {
            "bbc.mobile.news.uk.internal:id/itemLayoutName",
            "bbc.mobile.news.uk.internal:id/itemLayoutLastUpdated",
            "bbc.mobile.news.uk.internal:id/itemLayoutHomeSection"
    };

    public String[] articlePageViewRelease = {
            "bbc.mobile.news.uk:id/itemLayoutName",
            "bbc.mobile.news.uk:id/itemLayoutLastUpdated",
            "bbc.mobile.news.uk:id/itemLayoutHomeSection"
    };

    @AndroidFindBy(accessibility = "Manage your topics")
    public MobileElement manageYourTopics;

    @AndroidFindBy(xpath = "//bbc.mobile.news.uk.internal:id/recyclerview[@index='1']/android.widget.RelativeLayout[@index='4']/android.widget.ImageView[@index='0']")
    public MobileElement removeTopicCymru;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='2']")
    //android.widget.RelativeLayout[@index='0']/android.widget.ImageView[@index='0']")
    public MobileElement topicArticle;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='1']/android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='1']")
    public MobileElement itemLayoutName;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='1']/android.widget.RelativeLayout[@index='0']/android.widget.LinearLayout[@index='2']/android.widget.LinearLayout[@index='0']/android.widget.TextView[@index='0']")
    public MobileElement itemLayoutLastUpdated;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='1']/android.widget.RelativeLayout[@index='0']/android.widget.LinearLayout[@index='2']/android.widget.LinearLayout[@index='0']/android.widget.TextView[@index='2']")
    public MobileElement itemLayoutHomeSection;

    @AndroidFindBy(xpath = "//android.support.v7.widget.RecyclerView[@index='3']/android.widget.FrameLayout[@index='2']/android.widget.RelativeLayout[@index='0']/android.widget.ImageView[@index='0']")
    public MobileElement topicVideoArticle;

    @AndroidFindBy(xpath = "//android.support.v7.widget.RecyclerView[@index='3']/android.widget.FrameLayout[@index='0']/android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='1']")
    public MobileElement videoItemLayoutPrimaryTime;

    @AndroidFindBy(xpath = "//android.support.v7.widget.RecyclerView[@index='3']/android.widget.FrameLayout[@index='0']/android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='2']")
    public MobileElement videoItemLayoutName;

    @AndroidFindBy(xpath = "//android.support.v7.widget.RecyclerView[@index='3']/android.widget.FrameLayout[@index='0']/android.widget.RelativeLayout[@index='0']/android.widget.LinearLayout[@index='3']/android.widget.LinearLayout[@index='0']/android.widget.TextView[@index='0']")
    public MobileElement videoItemLayoutLastUpdated;

    @AndroidFindBy(xpath = "//android.support.v7.widget.RecyclerView[@index='3']/android.widget.FrameLayout[@index='0']/android.widget.RelativeLayout[@index='0']/android.widget.LinearLayout[@index='3']/android.widget.LinearLayout[@index='0']/android.widget.TextView[@index='2']")
    public MobileElement videoItemLayoutHomeSection;

    @AndroidFindAll({
            @AndroidBy(id = "bbc.mobile.news.uk.internal:id/snackbar_text"),
            @AndroidBy(id = "bbc.mobile.news.uk:id/snackbar_text")
    })
    public MobileElement snackbar;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='OK, got it']")
    public MobileElement okGotIt;

    @AndroidFindBy(xpath = "//android.widget.TextView[@tex'More']")
    public MobileElement moreButton;

    @AndroidFindAll({
            @AndroidBy(xpath = "//android.widget.TextView[contains(@resource-id,'bbc.mobile.news.uk.internal:id/item_layout_header_title') and @text='Wales']"),
            @AndroidBy(xpath = "//android.widget.TextView[contains(@resource-id,'bbc.mobile.news.uk:id/item_layout_header_title') and @text='Wales']")
    })
    public MobileElement topicTitle;

    @AndroidFindAll({
            @AndroidBy(id = "bbc.mobile.news.uk.internal:id/showmore_title"),
            @AndroidBy(id = "bbc.mobile.news.uk:id/showmore_title")
    })
    public MobileElement showMore;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Less']")
    public MobileElement showLess;

}
