package com.bbcnews.automation.pageobjects

import io.appium.java_client.MobileElement
import io.appium.java_client.pagefactory.AndroidBy
import io.appium.java_client.pagefactory.AndroidFindAll
import io.appium.java_client.pagefactory.AndroidFindBy

object MyNewsPageObject {

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/title"), AndroidBy(id = "bbc.mobile.news.uk:id/title"))
    val myNewsTitle: MobileElement? = null

    @AndroidFindBy(accessibility = "OK, let's get started Button:")
    val myNewsStartButton: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/summary"), AndroidBy(id = "bbc.mobile.news.uk:id/summary"))
    val myNewsSummary: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/icon"), AndroidBy(id = "bbc.mobile.news.uk:id/icon"))
    val addNewsButton: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='My Topics']")
    val myTopics: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Add Topics']")
    val addTopics: MobileElement? = null

    @AndroidFindBy(accessibility = "Topic heading,Local news")
    val localNews: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Allow location']")
    val allowLocation: MobileElement? = null

    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
    val allowLocationPermission: MobileElement? = null

    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_deny_button")
    val allowLocationPermissionDeny: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/request_permission"), AndroidBy(id = "bbc.mobile.news.uk:id/request_permission"))
    val locationButton: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Edit My News']")
    val editMyTopics: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/empty_text_view"), AndroidBy(id = "bbc.mobile.news.uk:id/empty_text_view"))
    val myTopicEmptyView: MobileElement? = null

    const val myNewsTitleText = "Add Topics to create your own personal news feed"

    const val myNewsSummaryText = "All the latest stories from your topics will appear here."

    const val myTopicEmptyViewText = "Your added topics will be displayed here"

    @AndroidFindBy(accessibility = "Add topic")
    val myNewsAddTopics: MobileElement? = null

    @AndroidFindBy(accessibility = "Edit My News")
    val editMyNews: MobileElement? = null

    @AndroidFindBy(accessibility = "Remove topic")
    val removeTopics: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Manchester']")
    val localNewsDisplayed: MobileElement? = null

    @AndroidFindBy(xpath = "//android.support.v7.widget.RecyclerView[@index='3']")
    val myNewsRecyclerView: MobileElement? = null

    @AndroidFindBy(accessibility = "Audio and Video")
    val asiaVideoAudioSection: MobileElement? = null

    val articlePageElements = arrayOf(
            //"bbc.mobile.news.uk.internal:id/imageItemBadge",
            "bbc.mobile.news.uk.internal:id/headlineInfo", "bbc.mobile.news.uk.internal:id/headlineTitle", "bbc.mobile.news.uk.internal:id/image_item", "bbc.mobile.news.uk.internal:id/headlineLink")

    val articlePageElementsRelease = arrayOf(
            //"bbc.mobile.news.uk:id/imageItemBadge",
            "bbc.mobile.news.uk:id/headlineInfo", "bbc.mobile.news.uk:id/headlineTitle", "bbc.mobile.news.uk:id/image_item", "bbc.mobile.news.uk:id/headlineLink")

    val articlePageView = arrayOf("bbc.mobile.news.uk.internal:id/itemLayoutName", "bbc.mobile.news.uk.internal:id/itemLayoutLastUpdated", "bbc.mobile.news.uk.internal:id/itemLayoutHomeSection")

    val articlePageViewRelease = arrayOf("bbc.mobile.news.uk:id/itemLayoutName", "bbc.mobile.news.uk:id/itemLayoutLastUpdated", "bbc.mobile.news.uk:id/itemLayoutHomeSection")

    @AndroidFindBy(accessibility = "Manage your topics")
    val manageYourTopics: MobileElement? = null

    @AndroidFindBy(xpath = "//bbc.mobile.news.uk.internal:id/recyclerview[@index='1']/android.widget.RelativeLayout[@index='4']/android.widget.ImageView[@index='0']")
    val removeTopicCymru: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='2']")
    //android.widget.RelativeLayout[@index='0']/android.widget.ImageView[@index='0']")
    val topicArticle: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='1']/android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='1']")
    val itemLayoutName: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='1']/android.widget.RelativeLayout[@index='0']/android.widget.LinearLayout[@index='2']/android.widget.LinearLayout[@index='0']/android.widget.TextView[@index='0']")
    val itemLayoutLastUpdated: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='1']/android.widget.RelativeLayout[@index='0']/android.widget.LinearLayout[@index='2']/android.widget.LinearLayout[@index='0']/android.widget.TextView[@index='2']")
    val itemLayoutHomeSection: MobileElement? = null

    @AndroidFindBy(xpath = "//android.support.v7.widget.RecyclerView[@index='3']/android.widget.FrameLayout[@index='2']/android.widget.RelativeLayout[@index='0']/android.widget.ImageView[@index='0']")
    val topicVideoArticle: MobileElement? = null

    @AndroidFindBy(xpath = "//android.support.v7.widget.RecyclerView[@index='3']/android.widget.FrameLayout[@index='0']/android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='1']")
    val videoItemLayoutPrimaryTime: MobileElement? = null

    @AndroidFindBy(xpath = "//android.support.v7.widget.RecyclerView[@index='3']/android.widget.FrameLayout[@index='0']/android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='2']")
    val videoItemLayoutName: MobileElement? = null

    @AndroidFindBy(xpath = "//android.support.v7.widget.RecyclerView[@index='3']/android.widget.FrameLayout[@index='0']/android.widget.RelativeLayout[@index='0']/android.widget.LinearLayout[@index='3']/android.widget.LinearLayout[@index='0']/android.widget.TextView[@index='0']")
    val videoItemLayoutLastUpdated: MobileElement? = null

    @AndroidFindBy(xpath = "//android.support.v7.widget.RecyclerView[@index='3']/android.widget.FrameLayout[@index='0']/android.widget.RelativeLayout[@index='0']/android.widget.LinearLayout[@index='3']/android.widget.LinearLayout[@index='0']/android.widget.TextView[@index='2']")
    val videoItemLayoutHomeSection: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/snackbar_text"), AndroidBy(id = "bbc.mobile.news.uk:id/snackbar_text"))
    val snackbar: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='OK, got it']")
    val okGotIt: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@tex'More']")
    val moreButton: MobileElement? = null

    @AndroidFindAll(AndroidBy(xpath = "//android.widget.TextView[contains(@resource-id,'bbc.mobile.news.uk.internal:id/item_layout_header_title') and @text='Wales']"), AndroidBy(xpath = "//android.widget.TextView[contains(@resource-id,'bbc.mobile.news.uk:id/item_layout_header_title') and @text='Wales']"))
    val topicTitle: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/showmore_title"), AndroidBy(id = "bbc.mobile.news.uk:id/showmore_title"))
    val showMore: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Less']")
    val showLess: MobileElement? = null

}
