package com.bbcnews.automation.pageobjects

import io.appium.java_client.MobileElement
import io.appium.java_client.pagefactory.AndroidBy
import io.appium.java_client.pagefactory.AndroidFindAll
import io.appium.java_client.pagefactory.AndroidFindBy

object PopularPageObjects {

    @AndroidFindBy(xpath = "//android.widget.Button[@text='OK']")
    lateinit var okButton: MobileElement

    @AndroidFindBy(xpath = "//android.widget.Button[@text='NO, THANKS.']")
    lateinit var noThanksButton: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Popular']")
    lateinit var popular: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Most Read']")
    lateinit var mostRead: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Most Watched' and @index='0']")
    lateinit var popularMostWatched: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'bbc.mobile.news.uk.internal:id/content_card_ordered_badge') and @text='1']")
    lateinit var popularArticle: MobileElement

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/imageItemCaption"), AndroidBy(id = "bbc.mobile.news.uk:id/imageItemCaption"))
    lateinit var imageItemCaption: MobileElement

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/imageItemBadge"), AndroidBy(id = "bbc.mobile.news.uk:id/imageItemBadge"))
    lateinit var imageItemBadge: MobileElement

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/headlineTitle"), AndroidBy(id = "bbc.mobile.news.uk:id/headlineTitle"))
    lateinit var headlineTitle: MobileElement

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/headlineAuthorName"), AndroidBy(id = "bbc.mobile.news.uk:id/headlineAuthorName"))
    lateinit var headlineAuthorName: MobileElement

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/headlineAuthorTitle"), AndroidBy(id = "bbc.mobile.news.uk:id/headlineAuthorTitle"))
    lateinit var headlineAuthorTitle: MobileElement

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/headlineInfo"), AndroidBy(id = "bbc.mobile.news.uk:id/headlineInfo"))
    lateinit var headlineInfo: MobileElement

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/videoTitleHeadline"), AndroidBy(id = "bbc.mobile.news.uk:id/videoTitleHeadline"))
    lateinit var headlineLink: MobileElement

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
    lateinit var mostReadArticle: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Most Popular']")
    lateinit var mostPopular: MobileElement

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='3']/android.widget.TextView[@text='1' and @index='1']")
    lateinit var mostWatchedArticle: MobileElement

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/videoTitleHeadline"), AndroidBy(id = "bbc.mobile.news.uk:id/videoTitleHeadline"))
    lateinit var videoTitleHeadline: MobileElement

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/videoTitleTimestamp"), AndroidBy(id = "bbc.mobile.news.uk:id/videoTitleTimestamp"))
    lateinit var videoTitleTimestamp: MobileElement

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/videoTitleTopic"), AndroidBy(id = "bbc.mobile.news.uk:id/videoTitleTopic"))
    lateinit var videoTitleTopic: MobileElement

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/videoSummary"), AndroidBy(id = "bbc.mobile.news.uk:id/videoSummary"))
    lateinit var videoSummary: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Most Popular']")
    lateinit var mostPopularText: MobileElement

    val popularVideoElements = arrayOf("bbc.mobile.news.uk.internal:id/smpPauseButton",
            // "bbc.mobile.news.uk.internal:id/videoTitleHeadline",
            "bbc.mobile.news.uk.internal:id/videoTitleTimestamp", "bbc.mobile.news.uk.internal:id/videoTitleTopic", "bbc.mobile.news.uk.internal:id/videoSummary")

    val popularVideoElementsRelease = arrayOf("bbc.mobile.news.uk:id/smpPauseButton", "bbc.mobile.news.uk:id/videoTitleHeadline", "bbc.mobile.news.uk:id/videoTitleTimestamp", "bbc.mobile.news.uk:id/videoTitleTopic", "bbc.mobile.news.uk:id/videoSummary")

    @AndroidFindBy(xpath = "//android.support.v7.widget.RecyclerView[@index='0']/android.widget.FrameLayout[@index='3']/android.widget.RelativeLayout[@index='0']/android.widget.FrameLayout[@index=0]/android.widget.TextView[@text='2' and index='1']")
    lateinit var mostWatchedVideoArticle: MobileElement

    @AndroidFindBy(xpath = "//*[@content-desc='Media length' or @text='2']")
    lateinit var mostWatchedArticleVideo: MobileElement

    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='2']")
    lateinit var itemLayoutName: MobileElement

    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='1']")
    lateinit var itemLayoutPosition: MobileElement

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@index='0']/android.widget.TextView[@index='0']")
    lateinit var itemLayoutLastUpdated: MobileElement

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@index='0']/android.widget.TextView[@index='2']")
    lateinit var itemLayoutHomeSection: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Egypt tightens control over internet use']")
    lateinit var relatedStoriesArticle: MobileElement

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='5']/android.view.ViewGroup[@index='0']/android.widget.TextView[@index='1']")
    lateinit var contentCardTitle: MobileElement

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='5']/android.view.ViewGroup[@index='0']/android.widget.TextView[@index='2']")
    lateinit var contentCardInfo: MobileElement

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='5']/android.view.ViewGroup[@index='0']/android.widget.TextView[@index='3']")
    lateinit var contentCardLink: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Egypt']")
    lateinit var relatedTopicsArticle: MobileElement

}
