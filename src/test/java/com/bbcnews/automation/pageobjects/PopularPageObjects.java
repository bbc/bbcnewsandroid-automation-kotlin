package com.bbcnews.automation.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class PopularPageObjects {

    public PopularPageObjects() {

    }

    @AndroidFindBy(xpath = "//android.widget.Button[@text='OK']")
    public MobileElement okButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='NO, THANKS.']")
    public MobileElement noThanksButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Popular']")
    public MobileElement popular;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Most Read']")
    public MobileElement mostRead;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Most Watched' and @index='0']")
    public MobileElement popularMostWatched;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'bbc.mobile.news.uk.internal:id/content_card_ordered_badge') and @text='1']")
    public MobileElement popularArticle;

    @AndroidFindAll({
            @AndroidBy(id = "bbc.mobile.news.uk.internal:id/imageItemCaption"),
            @AndroidBy(id = "bbc.mobile.news.uk:id/imageItemCaption")
    })
    public MobileElement imageItemCaption;

    @AndroidFindAll({
            @AndroidBy(id = "bbc.mobile.news.uk.internal:id/imageItemBadge"),
            @AndroidBy(id = "bbc.mobile.news.uk:id/imageItemBadge")
    })
    public MobileElement imageItemBadge;

    @AndroidFindAll({
            @AndroidBy(id = "bbc.mobile.news.uk.internal:id/headlineTitle"),
            @AndroidBy(id = "bbc.mobile.news.uk:id/headlineTitle")
    })
    public MobileElement headlineTitle;

    @AndroidFindAll({
            @AndroidBy(id = "bbc.mobile.news.uk.internal:id/headlineAuthorName"),
            @AndroidBy(id = "bbc.mobile.news.uk:id/headlineAuthorName")
    })
    public MobileElement headlineAuthorName;

    @AndroidFindAll({
            @AndroidBy(id = "bbc.mobile.news.uk.internal:id/headlineAuthorTitle"),
            @AndroidBy(id = "bbc.mobile.news.uk:id/headlineAuthorTitle")
    })
    public MobileElement headlineAuthorTitle;

    @AndroidFindAll({
            @AndroidBy(id = "bbc.mobile.news.uk.internal:id/headlineInfo"),
            @AndroidBy(id = "bbc.mobile.news.uk:id/headlineInfo")
    })
    public MobileElement headlineInfo;

    @AndroidFindAll({
            @AndroidBy(id = "bbc.mobile.news.uk.internal:id/videoTitleHeadline"),
            @AndroidBy(id = "bbc.mobile.news.uk:id/videoTitleHeadline")
    })
    public MobileElement headlineLink;

    public String[] mostReadPopularLinks = {
            //"bbc.mobile.news.uk.internal:id/imageItemBadge",
            "bbc.mobile.news.uk.internal:id/headlineInfo",
            "bbc.mobile.news.uk.internal:id/headlineTitle",
            //"bbc.mobile.news.uk.internal:id/headlineAuthorTitle",
            "bbc.mobile.news.uk.internal:id/headlineLink",
            // "bbc.mobile.news.uk.internal:id/imageItemCaption",
            //  "bbc.mobile.news.uk.internal:id/headlineAuthorName"
            "bbc.mobile.news.uk.internal:id/image_item"
    };

    public String[] mostReadPopularLinksRelease = {
            "bbc.mobile.news.uk:id/headlineInfo",
            "bbc.mobile.news.uk:id/headlineTitle",
            "bbc.mobile.news.uk:id/headlineLink",
            // "bbc.mobile.news.uk:id/imageItemCaption",
            //  "bbc.mobile.news.uk:id/headlineAuthorName"
            "bbc.mobile.news.uk:id/image_item"
    };

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='1' and @index='1']")
    public MobileElement mostReadArticle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Most Popular']")
    public MobileElement mostPopular;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='3']/android.widget.TextView[@text='1' and @index='1']")
    public MobileElement mostWatchedArticle;

    @AndroidFindAll({
            @AndroidBy(id = "bbc.mobile.news.uk.internal:id/videoTitleHeadline"),
            @AndroidBy(id = "bbc.mobile.news.uk:id/videoTitleHeadline")
    })
    public MobileElement videoTitleHeadline;

    @AndroidFindAll({
            @AndroidBy(id = "bbc.mobile.news.uk.internal:id/videoTitleTimestamp"),
            @AndroidBy(id = "bbc.mobile.news.uk:id/videoTitleTimestamp")
    })
    public MobileElement videoTitleTimestamp;

    @AndroidFindAll({
            @AndroidBy(id = "bbc.mobile.news.uk.internal:id/videoTitleTopic"),
            @AndroidBy(id = "bbc.mobile.news.uk:id/videoTitleTopic")
    })
    public MobileElement videoTitleTopic;

    @AndroidFindAll({
            @AndroidBy(id = "bbc.mobile.news.uk.internal:id/videoSummary"),
            @AndroidBy(id = "bbc.mobile.news.uk:id/videoSummary")
    })
    public MobileElement videoSummary;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Most Popular']")
    public MobileElement mostPopularText;

    public String[] popularVideoElements = {
            "bbc.mobile.news.uk.internal:id/smpPauseButton",
            // "bbc.mobile.news.uk.internal:id/videoTitleHeadline",
            "bbc.mobile.news.uk.internal:id/videoTitleTimestamp",
            "bbc.mobile.news.uk.internal:id/videoTitleTopic",
            "bbc.mobile.news.uk.internal:id/videoSummary"
    };

    public String[] popularVideoElementsRelease = {
            "bbc.mobile.news.uk:id/smpPauseButton",
            "bbc.mobile.news.uk:id/videoTitleHeadline",
            "bbc.mobile.news.uk:id/videoTitleTimestamp",
            "bbc.mobile.news.uk:id/videoTitleTopic",
            "bbc.mobile.news.uk:id/videoSummary"
    };

    @AndroidFindBy(xpath = "//android.support.v7.widget.RecyclerView[@index='0']/android.widget.FrameLayout[@index='3']/android.widget.RelativeLayout[@index='0']/android.widget.FrameLayout[@index=0]/android.widget.TextView[@text='2' and index='1']")
    public MobileElement mostWatchedVideoArticle;

    @AndroidFindBy(xpath = "//*[@content-desc='Media length' or @text='2']")
    public MobileElement mostWatchedArticleVideo;

    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='2']")
    public MobileElement itemLayoutName;

    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='1']")
    public MobileElement itemLayoutPosition;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@index='0']/android.widget.TextView[@index='0']")
    public MobileElement itemLayoutLastUpdated;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@index='0']/android.widget.TextView[@index='2']")
    public MobileElement itemLayoutHomeSection;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Egypt tightens control over internet use']")
    public MobileElement relatedStoriesArticle;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='5']/android.view.ViewGroup[@index='0']/android.widget.TextView[@index='1']")
    public MobileElement contentCardTitle;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='5']/android.view.ViewGroup[@index='0']/android.widget.TextView[@index='2']")
    public MobileElement contentCardInfo;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='5']/android.view.ViewGroup[@index='0']/android.widget.TextView[@index='3']")
    public MobileElement contentCardLink;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Egypt']")
    public MobileElement relatedTopicsArticle;

}
