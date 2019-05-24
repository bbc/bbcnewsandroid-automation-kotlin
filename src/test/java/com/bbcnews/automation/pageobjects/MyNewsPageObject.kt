package com.bbcnews.automation.pageobjects

import io.appium.java_client.MobileElement
import io.appium.java_client.pagefactory.AndroidBy
import io.appium.java_client.pagefactory.AndroidFindAll
import io.appium.java_client.pagefactory.AndroidFindBy

object MyNewsPageObject {

    @AndroidFindAll(
            AndroidBy(id = "bbc.mobile.news.uk.internal:id/title"),
            AndroidBy(id = "bbc.mobile.news.uk:id/title"))
    lateinit var myNewsTitle: MobileElement

    @AndroidFindAll(
            AndroidBy(id = "bbc.mobile.news.uk.internal:id/button"),
            AndroidBy(className = "android.widget.TextView"),
            AndroidBy(xpath = "//android.widget.TextView[@text='OK, let's get started']")
    )
    lateinit var myNewsStartButton: MobileElement

    @AndroidFindAll(
            AndroidBy(id = "bbc.mobile.news.uk.internal:id/summary"),
            AndroidBy(id = "bbc.mobile.news.uk:id/summary"))
    lateinit var myNewsSummary: MobileElement

    @AndroidFindAll(
            AndroidBy(id = "bbc.mobile.news.uk.internal:id/icon"),
            AndroidBy(id = "bbc.mobile.news.uk:id/icon"))
    lateinit var addNewsButton: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='My Topics']")
    lateinit var myTopics: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Add Topics']")
    lateinit var addTopics: MobileElement

    @AndroidFindBy(accessibility = "Topic heading,Local news")
    lateinit var localNews: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Allow location']")
    lateinit var allowLocation: MobileElement

    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
    lateinit var allowLocationPermission: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Edit My News']")
    lateinit var editMyTopics: MobileElement

    @AndroidFindAll(
            AndroidBy(id = "bbc.mobile.news.uk.internal:id/empty_text_view"),
            AndroidBy(id = "bbc.mobile.news.uk:id/empty_text_view"))
    lateinit var myTopicEmptyView: MobileElement

    const val myNewsTitleText = "Add Topics to create your own personal news feed"

    const val myNewsSummaryText = "All the latest stories from your topics will appear here."

    const val myTopicEmptyViewText = "Your added topics will be displayed here"

    @AndroidFindBy(accessibility = "Add topic")
    lateinit var myNewsAddTopics: MobileElement

    @AndroidFindBy(accessibility = "Edit My News")
    lateinit var editMyNews: MobileElement

    @AndroidFindBy(accessibility = "Remove topic")
    lateinit var removeTopics: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='UK']")
    lateinit var localNewsDisplayed: MobileElement

    @AndroidFindBy(xpath = "//android.support.v7.widget.RecyclerView[@index='3']")
    lateinit var myNewsRecyclerView: MobileElement

    @AndroidFindBy(accessibility = "Manage your topics")
    lateinit var manageYourTopics: MobileElement

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='2']")
    lateinit var topicArticle: MobileElement

    @AndroidFindBy(xpath = "//android.support.v7.widget.RecyclerView[@index='3']/android.widget.FrameLayout[@index='2']/android.widget.RelativeLayout[@index='0']/android.widget.ImageView[@index='0']")
    lateinit var topicVideoArticle: MobileElement

    @AndroidFindAll(
            AndroidBy(id = "bbc.mobile.news.uk.internal:id/showmore_title"),
            AndroidBy(id = "bbc.mobile.news.uk:id/showmore_title"))
    lateinit var showMore: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Less']")
    lateinit var showLess: MobileElement

}
