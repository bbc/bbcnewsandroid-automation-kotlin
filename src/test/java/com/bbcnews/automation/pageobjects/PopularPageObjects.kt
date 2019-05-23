package com.bbcnews.automation.pageobjects

import io.appium.java_client.MobileElement
import io.appium.java_client.pagefactory.AndroidFindBy

object PopularPageObjects {

    val popularVideoElements = arrayOf(
            "bbc.mobile.news.uk.internal:id/smpPauseButton",
            "bbc.mobile.news.uk.internal:id/videoTitleTimestamp",
            "bbc.mobile.news.uk.internal:id/videoTitleTopic",
            "bbc.mobile.news.uk.internal:id/videoSummary"
    )

    val popularVideoElementsRelease = arrayOf(
            "bbc.mobile.news.uk:id/smpPauseButton",
            "bbc.mobile.news.uk:id/videoTitleHeadline",
            "bbc.mobile.news.uk:id/videoTitleTimestamp",
            "bbc.mobile.news.uk:id/videoTitleTopic",
            "bbc.mobile.news.uk:id/videoSummary"
    )

    val mostReadPopularLinks = arrayOf(
            "bbc.mobile.news.uk.internal:id/headlineInfo",
            "bbc.mobile.news.uk.internal:id/headlineTitle",
            "bbc.mobile.news.uk.internal:id/headlineLink",
            "bbc.mobile.news.uk.internal:id/image_item"
    )

    val mostReadPopularLinksRelease = arrayOf(
            "bbc.mobile.news.uk:id/headlineInfo",
            "bbc.mobile.news.uk:id/headlineTitle",
            "bbc.mobile.news.uk:id/headlineLink",
            "bbc.mobile.news.uk:id/image_item"
    )

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Most Read']")
    lateinit var mostRead: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Most Watched']")
    lateinit var popularMostWatched: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='1' and @index='1']")
    lateinit var mostReadArticle: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Most Popular']")
    lateinit var mostPopular: MobileElement

    @AndroidFindBy(xpath = "//*[@content-desc='Media length' or @text='2']")
    lateinit var mostWatchedArticleVideo: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Egypt tightens control over internet use']")
    lateinit var relatedStoriesArticle: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Egypt']")
    lateinit var relatedTopicsArticle: MobileElement

}
