package com.bbcnews.automation.pageobjects

import io.appium.java_client.MobileElement
import io.appium.java_client.pagefactory.AndroidBy
import io.appium.java_client.pagefactory.AndroidFindAll
import io.appium.java_client.pagefactory.AndroidFindBy

object PopularPageObjects {

    @AndroidFindBy(xpath = "//android.widget.Button[@text='OK']")
    val okButton: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.Button[@text='NO, THANKS.']")
    val noThanksButton: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Popular']")
    val popular: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Most Read']")
    val mostRead: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Most Watched' and @index='0']")
    val popularMostWatched: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'bbc.mobile.news.uk.internal:id/content_card_ordered_badge') and @text='1']")
    val popularArticle: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/imageItemCaption"), AndroidBy(id = "bbc.mobile.news.uk:id/imageItemCaption"))
    val imageItemCaption: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/imageItemBadge"), AndroidBy(id = "bbc.mobile.news.uk:id/imageItemBadge"))
    val imageItemBadge: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/headlineTitle"), AndroidBy(id = "bbc.mobile.news.uk:id/headlineTitle"))
    val headlineTitle: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/headlineAuthorName"), AndroidBy(id = "bbc.mobile.news.uk:id/headlineAuthorName"))
    val headlineAuthorName: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/headlineAuthorTitle"), AndroidBy(id = "bbc.mobile.news.uk:id/headlineAuthorTitle"))
    val headlineAuthorTitle: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/headlineInfo"), AndroidBy(id = "bbc.mobile.news.uk:id/headlineInfo"))
    val headlineInfo: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/videoTitleHeadline"), AndroidBy(id = "bbc.mobile.news.uk:id/videoTitleHeadline"))
    val headlineLink: MobileElement? = null

    val mostReadPopularLinks = arrayOf(
            //"bbc.mobile.news.uk.internal:id/imageItemBadge",
            "bbc.mobile.news.uk.internal:id/headlineInfo", "bbc.mobile.news.uk.internal:id/headlineTitle",
            //"bbc.mobile.news.uk.internal:id/headlineAuthorTitle",
            "bbc.mobile.news.uk.internal:id/headlineLink",
            // "bbc.mobile.news.uk.internal:id/imageItemCaption",
            //  "bbc.mobile.news.uk.internal:id/headlineAuthorName"
            "bbc.mobile.news.uk.internal:id/image_item")

    val mostReadPopularLinksRelease = arrayOf("bbc.mobile.news.uk:id/headlineInfo", "bbc.mobile.news.uk:id/headlineTitle", "bbc.mobile.news.uk:id/headlineLink",
            // "bbc.mobile.news.uk:id/imageItemCaption",
            //  "bbc.mobile.news.uk:id/headlineAuthorName"
            "bbc.mobile.news.uk:id/image_item")

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='1' and @index='1']")
    val mostReadArticle: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Most Popular']")
    val mostPopular: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='3']/android.widget.TextView[@text='1' and @index='1']")
    val mostWatchedArticle: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/videoTitleHeadline"), AndroidBy(id = "bbc.mobile.news.uk:id/videoTitleHeadline"))
    val videoTitleHeadline: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/videoTitleTimestamp"), AndroidBy(id = "bbc.mobile.news.uk:id/videoTitleTimestamp"))
    val videoTitleTimestamp: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/videoTitleTopic"), AndroidBy(id = "bbc.mobile.news.uk:id/videoTitleTopic"))
    val videoTitleTopic: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/videoSummary"), AndroidBy(id = "bbc.mobile.news.uk:id/videoSummary"))
    val videoSummary: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Most Popular']")
    val mostPopularText: MobileElement? = null

    val popularVideoElements = arrayOf("bbc.mobile.news.uk.internal:id/smpPauseButton",
            // "bbc.mobile.news.uk.internal:id/videoTitleHeadline",
            "bbc.mobile.news.uk.internal:id/videoTitleTimestamp", "bbc.mobile.news.uk.internal:id/videoTitleTopic", "bbc.mobile.news.uk.internal:id/videoSummary")

    val popularVideoElementsRelease = arrayOf("bbc.mobile.news.uk:id/smpPauseButton", "bbc.mobile.news.uk:id/videoTitleHeadline", "bbc.mobile.news.uk:id/videoTitleTimestamp", "bbc.mobile.news.uk:id/videoTitleTopic", "bbc.mobile.news.uk:id/videoSummary")

    @AndroidFindBy(xpath = "//android.support.v7.widget.RecyclerView[@index='0']/android.widget.FrameLayout[@index='3']/android.widget.RelativeLayout[@index='0']/android.widget.FrameLayout[@index=0]/android.widget.TextView[@text='2' and index='1']")
    val mostWatchedVideoArticle: MobileElement? = null

    @AndroidFindBy(xpath = "//*[@content-desc='Media length' or @text='2']")
    val mostWatchedArticleVideo: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='2']")
    val itemLayoutName: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='1']")
    val itemLayoutPosition: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@index='0']/android.widget.TextView[@index='0']")
    val itemLayoutLastUpdated: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@index='0']/android.widget.TextView[@index='2']")
    val itemLayoutHomeSection: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Egypt tightens control over internet use']")
    val relatedStoriesArticle: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='5']/android.view.ViewGroup[@index='0']/android.widget.TextView[@index='1']")
    val contentCardTitle: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='5']/android.view.ViewGroup[@index='0']/android.widget.TextView[@index='2']")
    val contentCardInfo: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='5']/android.view.ViewGroup[@index='0']/android.widget.TextView[@index='3']")
    val contentCardLink: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Egypt']")
    val relatedTopicsArticle: MobileElement? = null

}
