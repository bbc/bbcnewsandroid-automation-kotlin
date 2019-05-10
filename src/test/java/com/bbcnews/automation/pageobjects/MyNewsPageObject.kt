package com.bbcnews.automation.pageobjects

import io.appium.java_client.MobileElement
import io.appium.java_client.pagefactory.AndroidBy
import io.appium.java_client.pagefactory.AndroidFindAll
import io.appium.java_client.pagefactory.AndroidFindBy

object MyNewsPageObject {

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/title"), AndroidBy(id = "bbc.mobile.news.uk:id/title"))
    lateinit var myNewsTitle: MobileElement

    @AndroidFindBy(accessibility = "OK, let's get started Button:")
    lateinit var myNewsStartButton: MobileElement

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/summary"), AndroidBy(id = "bbc.mobile.news.uk:id/summary"))
    lateinit var myNewsSummary: MobileElement

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/icon"), AndroidBy(id = "bbc.mobile.news.uk:id/icon"))
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

    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_deny_button")
    lateinit var allowLocationPermissionDeny: MobileElement

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/request_permission"), AndroidBy(id = "bbc.mobile.news.uk:id/request_permission"))
    lateinit var locationButton: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Edit My News']")
    lateinit var editMyTopics: MobileElement

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/empty_text_view"), AndroidBy(id = "bbc.mobile.news.uk:id/empty_text_view"))
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

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Manchester']")
    lateinit var localNewsDisplayed: MobileElement

    @AndroidFindBy(xpath = "//android.support.v7.widget.RecyclerView[@index='3']")
    lateinit var myNewsRecyclerView: MobileElement

    @AndroidFindBy(accessibility = "Audio and Video")
    lateinit var asiaVideoAudioSection: MobileElement

    val articlePageElements = arrayOf(
            //"bbc.mobile.news.uk.internal:id/imageItemBadge",
            "bbc.mobile.news.uk.internal:id/headlineInfo", "bbc.mobile.news.uk.internal:id/headlineTitle", "bbc.mobile.news.uk.internal:id/image_item", "bbc.mobile.news.uk.internal:id/headlineLink")

    val articlePageElementsRelease = arrayOf(
            //"bbc.mobile.news.uk:id/imageItemBadge",
            "bbc.mobile.news.uk:id/headlineInfo", "bbc.mobile.news.uk:id/headlineTitle", "bbc.mobile.news.uk:id/image_item", "bbc.mobile.news.uk:id/headlineLink")

    val articlePageView = arrayOf("bbc.mobile.news.uk.internal:id/itemLayoutName", "bbc.mobile.news.uk.internal:id/itemLayoutLastUpdated", "bbc.mobile.news.uk.internal:id/itemLayoutHomeSection")

    val articlePageViewRelease = arrayOf("bbc.mobile.news.uk:id/itemLayoutName", "bbc.mobile.news.uk:id/itemLayoutLastUpdated", "bbc.mobile.news.uk:id/itemLayoutHomeSection")

    @AndroidFindBy(accessibility = "Manage your topics")
    lateinit var manageYourTopics: MobileElement

    @AndroidFindBy(xpath = "//bbc.mobile.news.uk.internal:id/recyclerview[@index='1']/android.widget.RelativeLayout[@index='4']/android.widget.ImageView[@index='0']")
    lateinit var removeTopicCymru: MobileElement

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='2']")
    //android.widget.RelativeLayout[@index='0']/android.widget.ImageView[@index='0']")
    lateinit var topicArticle: MobileElement

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='1']/android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='1']")
    lateinit var itemLayoutName: MobileElement

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='1']/android.widget.RelativeLayout[@index='0']/android.widget.LinearLayout[@index='2']/android.widget.LinearLayout[@index='0']/android.widget.TextView[@index='0']")
    lateinit var itemLayoutLastUpdated: MobileElement

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='1']/android.widget.RelativeLayout[@index='0']/android.widget.LinearLayout[@index='2']/android.widget.LinearLayout[@index='0']/android.widget.TextView[@index='2']")
    lateinit var itemLayoutHomeSection: MobileElement

    @AndroidFindBy(xpath = "//android.support.v7.widget.RecyclerView[@index='3']/android.widget.FrameLayout[@index='2']/android.widget.RelativeLayout[@index='0']/android.widget.ImageView[@index='0']")
    lateinit var topicVideoArticle: MobileElement

    @AndroidFindBy(xpath = "//android.support.v7.widget.RecyclerView[@index='3']/android.widget.FrameLayout[@index='0']/android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='1']")
    lateinit var videoItemLayoutPrimaryTime: MobileElement

    @AndroidFindBy(xpath = "//android.support.v7.widget.RecyclerView[@index='3']/android.widget.FrameLayout[@index='0']/android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='2']")
    lateinit var videoItemLayoutName: MobileElement

    @AndroidFindBy(xpath = "//android.support.v7.widget.RecyclerView[@index='3']/android.widget.FrameLayout[@index='0']/android.widget.RelativeLayout[@index='0']/android.widget.LinearLayout[@index='3']/android.widget.LinearLayout[@index='0']/android.widget.TextView[@index='0']")
    lateinit var videoItemLayoutLastUpdated: MobileElement

    @AndroidFindBy(xpath = "//android.support.v7.widget.RecyclerView[@index='3']/android.widget.FrameLayout[@index='0']/android.widget.RelativeLayout[@index='0']/android.widget.LinearLayout[@index='3']/android.widget.LinearLayout[@index='0']/android.widget.TextView[@index='2']")
    lateinit var videoItemLayoutHomeSection: MobileElement

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/snackbar_text"), AndroidBy(id = "bbc.mobile.news.uk:id/snackbar_text"))
    lateinit var snackbar: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='OK, got it']")
    lateinit var okGotIt: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@tex'More']")
    lateinit var moreButton: MobileElement

    @AndroidFindAll(AndroidBy(xpath = "//android.widget.TextView[contains(@resource-id,'bbc.mobile.news.uk.internal:id/item_layout_header_title') and @text='Wales']"), AndroidBy(xpath = "//android.widget.TextView[contains(@resource-id,'bbc.mobile.news.uk:id/item_layout_header_title') and @text='Wales']"))
    lateinit var topicTitle: MobileElement

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/showmore_title"), AndroidBy(id = "bbc.mobile.news.uk:id/showmore_title"))
    lateinit var showMore: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Less']")
    lateinit var showLess: MobileElement

}
