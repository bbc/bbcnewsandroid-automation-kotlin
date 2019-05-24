package com.bbcnews.automation.pageobjects

import io.appium.java_client.MobileElement
import io.appium.java_client.pagefactory.AndroidBy
import io.appium.java_client.pagefactory.AndroidFindAll
import io.appium.java_client.pagefactory.AndroidFindBy

object BasePageObject {

    const val searchText = "Brexit"

    val articleDetailPageLinks = arrayOf(
            "bbc.mobile.news.uk.internal:id/image_item_caption",
            "bbc.mobile.news.uk.internal:id/headline_title",
            "bbc.mobile.news.uk.internal:id/headline_info",
            "bbc.mobile.news.uk.internal:id/headline_link"
    )

    val articleDetailPageLinksRelease = arrayOf(
            "bbc.mobile.news.uk:id/image_item_caption",
            "bbc.mobile.news.uk:id/headline_title",
            "bbc.mobile.news.uk:id/headline_info",
            "bbc.mobile.news.uk:id/headline_link"
    )

    val articleItemWithImageBadge = arrayOf(
            "Hundreds of people poured onto the streets demanding justice for the girl",
            "How India viral messages helped catch rape suspect",
            "10 Jul 2018",
            "India"
    )

    val articleItemWithoutImageBadge = arrayOf(
            "Bishop Franco Mulakkal denies wrongdoing",
            "India bishop accused of rape arrested in Kerala",
            "21 Sep 2018",
            "India"
    )

    val articlePageDetail = arrayOf(
            "India man held for rape of British woman in Goa",
            "21 Dec 2018",
            "India"
    )

    val articlePageDetailElements = arrayOf(
            "bbc.mobile.news.uk.internal:id/headline_title",
            "bbc.mobile.news.uk.internal:id/headline_info",
            "bbc.mobile.news.uk.internal:id/headline_link"
    )

    val articlePageDetailElementsRelease = arrayOf(
            "bbc.mobile.news.uk:id/headline_title",
            "bbc.mobile.news.uk:id/headline_info",
            "bbc.mobile.news.uk:id/headline_link"
    )

    @AndroidFindAll(
            AndroidBy(className = "android.widget.ImageButton"),
            AndroidBy(accessibility = "Navigate up"),
            AndroidBy(xpath = "//android.widget.ImageButton[@index='0']")
    )
    lateinit var navigateBack: MobileElement

    @AndroidFindBy(id = "android:id/button1")
    lateinit var dialog_yes: MobileElement

    @AndroidFindBy(id = "android:id/button2")
    lateinit var dialog_no: MobileElement

    @AndroidFindBy(accessibility = "Back")
    lateinit var backButton: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Top Stories']")
    lateinit var topStories: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='My News']")
    lateinit var myNews: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Popular']")
    lateinit var popular: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Video']")
    lateinit var video: MobileElement

    @AndroidFindBy(accessibility = "Search")
    lateinit var searchButton: MobileElement

    @AndroidFindBy(accessibility = "Search for topics")
    lateinit var searchForTopics: MobileElement

    @AndroidFindBy(accessibility = "Share story")
    lateinit var shareStory: MobileElement

    @AndroidFindBy(id = "bbc.mobile.news.uk.internal:id/copyright_item_title")
    lateinit var copyrightFooter: MobileElement

    @AndroidFindAll(
            AndroidBy(id = "bbc.mobile.news.uk.internal:id/action_search"),
            AndroidBy(id = "bbc.mobile.news.uk:id/action_search"),
            AndroidBy(accessibility = "Search")
    )
    lateinit var search: MobileElement

    var topicsPageElements = arrayOf(
            "bbc.mobile.news.uk.internal:id/item_image",
            "bbc.mobile.news.uk.internal:id/item_layout_name",
            "bbc.mobile.news.uk.internal:id/contentInfo",
            "bbc.mobile.news.uk.internal:id/itemLayoutHomeSection"
    )

    var topicsPageElementsRelease = arrayOf(
            "bbc.mobile.news.uk:id/item_image",
            "bbc.mobile.news.uk:id/item_layout_name",
            "bbc.mobile.news.uk:id/contentInfo",
            "bbc.mobile.news.uk:id/itemLayoutHomeSection"
    )

    @AndroidFindBy(id = "bbc.mobile.news.uk.internal:id/content_card_title")
    lateinit var itemTitle: MobileElement

    @AndroidFindBy(id = "bbc.mobile.news.uk.internal:id/content_card_info")
    lateinit var contentInfo: MobileElement

    @AndroidFindBy(accessibility = "Show navigation menu drawer")
    lateinit var menuButton: MobileElement

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Settings']")
    lateinit var settings: MobileElement

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='App info']")
    lateinit var appInfo: MobileElement

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Other BBC apps']")
    lateinit var otherBbcApps: MobileElement

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Internal Settings']")
    lateinit var internalSettings: MobileElement

    @AndroidFindAll(
            AndroidBy(id = "bbc.mobile.news.uk.internal:id/search"),
            AndroidBy(id = "bbc.mobile.news.uk:id/search"))
    lateinit var searchField: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Brexit' and @index='0']")
    lateinit var searchKeyword: MobileElement

    @AndroidFindAll(
            AndroidBy(id = "bbc.mobile.news.uk.internal:id/title"),
            AndroidBy(id = "bbc.mobile.news.uk:id/title"))
    lateinit var headlineTitle: MobileElement

    @AndroidFindAll(
            AndroidBy(xpath = "//android.widget.TextView[contains(@resource-id,'bbc.mobile.news.uk.internal:id/heading') and @index='0']"),
            AndroidBy(xpath = "//android.widget.TextView[contains(@resource-id,'bbc.mobile.news.uk:id/heading') and @index='0']"))
    lateinit var searchHeading: MobileElement

    @AndroidFindAll(
            AndroidBy(xpath = "//android.widget.TextView[@resource-id='bbc.mobile.news.uk.internal:id/heading' and @index='2']"),
            AndroidBy(xpath = "//android.widget.TextView[@resource-id='bbc.mobile.news.uk:id/heading' and @index='2']"))
    lateinit var searchHeading2: MobileElement

    @AndroidFindBy(accessibility = "Cancel search")
    lateinit var cancelSearch: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Rape in India']")
    lateinit var article: MobileElement

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='3']/android.view.ViewGroup[@index='0']/android.widget.ImageView[@index='0']")
    lateinit var articleSearch: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='How social media helped catch rape suspect' and @index='1']")
    lateinit var articleItemWithItemBadge: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='India bishop accused of rape arrested' and @index='1']")
    lateinit var articleItemWithoutItemBadge: MobileElement

    @AndroidFindAll(
            AndroidBy(xpath = "//android.widget.TextView[contains(@resource-id,'bbc.mobile.news.uk.internal:id/item_layout_name') and @index='0']"),
            AndroidBy(xpath = "//android.widget.TextView[contains(@resource-id,'bbc.mobile.news.uk:id/item_layout_name') and @index='0']"))
    lateinit var articleLayoutName: MobileElement

    @AndroidFindAll(
            AndroidBy(xpath = "//android.widget.TextView[contains(@resource-id,'bbc.mobile.news.uk.internal:id/contentInfo') and @index='0']"),
            AndroidBy(xpath = "//android.widget.TextView[contains(@resource-id,'bbc.mobile.news.uk:id/contentInfo') and @index='0']"))
    lateinit var articleLastUpdated: MobileElement

    @AndroidFindAll(
            AndroidBy(id = "bbc.mobile.news.uk.internal:id/image_item_badge"),
            AndroidBy(id = "bbc.mobile.news.uk:id/image_item_badge"))
    lateinit var articleImageBadge: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Related stories']")
    lateinit var relatedStories: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Related topics']")
    lateinit var relatedTopics: MobileElement

    @AndroidFindAll(
            AndroidBy(id = "bbc.mobile.news.uk.internal:id/smp_error_message"),
            AndroidBy(id = "bbc.mobile.news.uk:id/smp_error_message"))
    lateinit var smpErrorMessage: MobileElement

    @AndroidFindAll(
            AndroidBy(id = "bbc.mobile.news.uk.internal:id/smp_error_button"),
            AndroidBy(id = "bbc.mobile.news.uk:id/smp_error_button"))
    lateinit var smpErrorOkButton: MobileElement

    @AndroidFindAll(
            AndroidBy(id = "bbc.mobile.news.uk.internal:id/smp_retry_button"),
            AndroidBy(id = "bbc.mobile.news.uk:id/smp_retry_button"))
    lateinit var smpRetryButton: MobileElement

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='App info']")
    lateinit var menuAppInfo: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Terms of use']")
    lateinit var termsConditions: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Privacy policy']")
    lateinit var privacyPolicy: MobileElement

}
