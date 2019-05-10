package com.bbcnews.automation.pageobjects

import io.appium.java_client.MobileElement
import io.appium.java_client.pagefactory.AndroidBy
import io.appium.java_client.pagefactory.AndroidFindAll
import io.appium.java_client.pagefactory.AndroidFindBy
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

object BasePageObject {

    @AndroidFindBy(accessibility = "Navigate up")
    lateinit var navigateBack: MobileElement

    @AndroidFindAll(
            AndroidBy(id = "android:id/button1"),
            AndroidBy(xpath = "android.widget.Button[@text='OK']")
    )
    lateinit var okButton: MobileElement

    @AndroidFindAll(
            AndroidBy(id = "android:id/button1"),
            AndroidBy(xpath = "//android.widget.Button[@text='YES.' and @index='1']")
    )
    lateinit var yesbutton: MobileElement

    @AndroidFindBy(xpath = "//android.widget.Button[@text='GO TO SETTINGS']")
    lateinit var settingsButton: MobileElement

    @AndroidFindBy(accessibility = "Back")
    lateinit var backButton: MobileElement

    @AndroidFindBy(id = "android:id/button2")
    lateinit var noThanksButton: MobileElement

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

    @AndroidFindBy(accessibility = "Share story")
    lateinit var shareStory: MobileElement

    @AndroidFindAll(
            AndroidBy(id = "bbc.mobile.news.uk.internal:id/action_search"),
            AndroidBy(id = "bbc.mobile.news.uk:id/action_search"),
            AndroidBy(accessibility = "Search")
    )
    lateinit var search: MobileElement

    var topicsPageElements = arrayOf(
            "bbc.mobile.news.uk.internal:id/item_image",
            "bbc.mobile.news.uk.internal:id/item_layout_name",
            "bbc.mobile.news.uk.internal:id/itemLayoutLastUpdated",
            "bbc.mobile.news.uk.internal:id/itemLayoutHomeSection"
    )

    var topicsPageElementsRelease = arrayOf(
            "bbc.mobile.news.uk:id/item_image",
            "bbc.mobile.news.uk:id/item_layout_name",
            "bbc.mobile.news.uk:id/itemLayoutLastUpdated",
            "bbc.mobile.news.uk:id/itemLayoutHomeSection"
    )

    @AndroidFindAll(
            AndroidBy(id = "bbc.mobile.news.uk.internal:id/item_layout_name"),
            AndroidBy(id = "bbc.mobile.news.uk:id/item_layout_name")
    )
    lateinit var itemLayoutName: MobileElement

    @AndroidFindAll(
            AndroidBy(id = "bbc.mobile.news.uk.internal:id/itemLayoutLastUpdated"),
            AndroidBy(id = "bbc.mobile.news.uk:id/itemLayoutLastUpdated")
    )
    lateinit var itemLayoutLastUpdated: MobileElement

    @AndroidFindAll(
            AndroidBy(id = "bbc.mobile.news.uk.internal:id/itemLayoutHomeSection"),
            AndroidBy(id = "bbc.mobile.news.uk:id/itemLayoutHomeSection")
    )
    lateinit var itemLayoutHomeSection: MobileElement

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

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/search"), AndroidBy(id = "bbc.mobile.news.uk:id/search"))
    lateinit var searchField: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Brexit' and @index='0']")
    lateinit var searchKeyword: MobileElement

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/title"), AndroidBy(id = "bbc.mobile.news.uk:id/title"))
    lateinit var headlineTitle: MobileElement

    @AndroidFindAll(AndroidBy(xpath = "//android.widget.TextView[contains(@resource-id,'bbc.mobile.news.uk.internal:id/heading') and @index='0']"), AndroidBy(xpath = "//android.widget.TextView[contains(@resource-id,'bbc.mobile.news.uk:id/heading') and @index='0']"))
    lateinit var searchHeading: MobileElement

    @AndroidFindAll(AndroidBy(xpath = "//android.widget.TextView[@resource-id='bbc.mobile.news.uk.internal:id/heading' and @index='2']"), AndroidBy(xpath = "//android.widget.TextView[@resource-id='bbc.mobile.news.uk:id/heading' and @index='2']"))
    lateinit var searchHeading2: MobileElement

    @AndroidFindAll(AndroidBy(xpath = "//android.widget.TextView[@resource-id='bbc.mobile.news.uk.internal:id/heading' and @index='4']"), AndroidBy(xpath = "//android.widget.TextView[@resource-id='bbc.mobile.news.uk:id/heading' and @index='4']"))
    lateinit var searchHeading4: MobileElement

    @AndroidFindAll(AndroidBy(xpath = "//bbc.mobile.news.uk.internal:id/chip_item[@index='1']"), AndroidBy(xpath = "//bbc.mobile.news.uk:id/chip_item[@index='1']"))
    lateinit var searchSuggest1: MobileElement

    @AndroidFindAll(AndroidBy(xpath = "//bbc.mobile.news.uk.internal:id/chip_item[@index='2']"), AndroidBy(xpath = "//bbc.mobile.news.uk:id/chip_item[@index='2']"))
    lateinit var searchSuggest2: MobileElement

    @AndroidFindAll(AndroidBy(xpath = "//bbc.mobile.news.uk.internal:id/chip_item[@index='3']"), AndroidBy(xpath = "//bbc.mobile.news.uk.internal:id/chip_item[@index='3']"))
    lateinit var searchSuggest3: MobileElement

    @AndroidFindBy(accessibility = "Cancel search")
    lateinit var cancelSearch: MobileElement

    val subDirectory = "Screenshots"

    lateinit var screenshotPaths: String

    val searchText = "Brexit"

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='UK Politics added to My News']")
    lateinit var alertText: MobileElement

    @AndroidFindBy(xpath = "//android.widget.Button[@text='UNDO' and @index='1']")
    lateinit var undoButton: MobileElement

    val alertTextUk = "UK Politics added to My News"

    val alertTextBusiness = "Business added to My News"

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Rape in India']")
    lateinit var article: MobileElement

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='3']/android.view.ViewGroup[@index='0']/android.widget.ImageView[@index='0']")
    lateinit var articleSearch: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='How social media helped catch rape suspect' and @index='1']")
    lateinit var articleItemWithItemBadge: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='India bishop accused of rape arrested' and @index='1']")
    lateinit var articleItemWithoutItemBadge: MobileElement

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[6]/bbc.mobile.news.uk.internal:id/main_view[0]/android.widget.ImageView[@index='0']")
    lateinit var articleItemImage: MobileElement

    @AndroidFindAll(AndroidBy(xpath = "//android.widget.TextView[contains(@resource-id,'bbc.mobile.news.uk.internal:id/item_layout_name') and @index='0']"), AndroidBy(xpath = "//android.widget.TextView[contains(@resource-id,'bbc.mobile.news.uk:id/item_layout_name') and @index='0']"))
    lateinit var articleLayoutName: MobileElement

    @AndroidFindAll(AndroidBy(xpath = "//android.widget.TextView[contains(@resource-id,'bbc.mobile.news.uk.internal:id/itemLayoutLastUpdated') and @index='0']"), AndroidBy(xpath = "//android.widget.TextView[contains(@resource-id,'bbc.mobile.news.uk:id/itemLayoutLastUpdated') and @index='0']"))
    lateinit var articleLastUpdated: MobileElement

    @AndroidFindAll(AndroidBy(xpath = "//android.widget.TextView[contains(@resource-id,'bbc.mobile.news.uk.internal:id/itemLayoutHomeSection') and @index='0']"), AndroidBy(xpath = "//android.widget.TextView[contains(@resource-id,'bbc.mobile.news.uk:id/itemLayoutHomeSection') and @index='0']"))
    lateinit var articleHomeSection: MobileElement

    val articleDetailPageLinks = arrayOf("bbc.mobile.news.uk.internal:id/image_item_caption", "bbc.mobile.news.uk.internal:id/headline_title", "bbc.mobile.news.uk.internal:id/headline_info", "bbc.mobile.news.uk.internal:id/headline_link")

    val articleDetailPageLinksRelease = arrayOf("bbc.mobile.news.uk:id/image_item_caption", "bbc.mobile.news.uk:id/headline_title", "bbc.mobile.news.uk:id/headline_info", "bbc.mobile.news.uk:id/headline_link")

    val articleItemWithImageBadge = arrayOf("Hundreds of people poured onto the streets demanding justice for the girl", "How India viral messages helped catch rape suspect", "10 Jul 2018", "India")

    val articleItemWithoutImageBadge = arrayOf("Bishop Franco Mulakkal denies wrongoing", "India bishop accused of rape arrested in Kerala", "21 Sep 2018", "India")

    val articlePageDetail = arrayOf("India man held for rape of British woman in Goa", "21 Dec 2018", "India")

    val articlePageDetailElements = arrayOf("bbc.mobile.news.uk.internal:id/headline_title", "bbc.mobile.news.uk.internal:id/headline_info", "bbc.mobile.news.uk.internal:id/headline_link")

    val articlePageDetailElementsRelease = arrayOf("bbc.mobile.news.uk:id/headline_title", "bbc.mobile.news.uk:id/headline_info", "bbc.mobile.news.uk:id/headline_link")

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/image_item_badge"), AndroidBy(id = "bbc.mobile.news.uk:id/image_item_badge"))
    lateinit var articleImageBadge: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Related stories']")
    lateinit var relatedStories: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Related topics']")
    lateinit var relatedTopics: MobileElement

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/smp_error_message"), AndroidBy(id = "bbc.mobile.news.uk:id/smp_error_message"))
    lateinit var smpErrorMessage: MobileElement

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/smp_error_button"), AndroidBy(id = "bbc.mobile.news.uk:id/smp_error_button"))
    lateinit var smpErrorOkButton: MobileElement

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/smp_retry_button"), AndroidBy(id = "bbc.mobile.news.uk:id/smp_retry_button"))
    lateinit var smpRetryButton: MobileElement

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/error_retry"), AndroidBy(id = "bbc.mobile.news.uk:id/error_retry"))
    lateinit var errorRetryButton: MobileElement

    @AndroidFindBy(xpath = "//android.widget.ListView[@index='0']")
    lateinit var appInfoListView: MobileElement

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='App info']")
    lateinit var menuAppInfo: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Terms of use']")
    lateinit var termsConditions: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Privacy policy']")
    lateinit var privacyPolicy: MobileElement

    @FindBy(xpath = "//*[contains(text(), 'A few rules for us and you')]")
    lateinit var termsOfUseText: WebElement

    @FindBy(xpath = "//*[contains(text(), 'Keeping your info safe & sound')]")
    lateinit var privacyPolicyText: WebElement

    @FindBy(xpath = "//*[contains(text(), 'Your Information & Privacy')]")
    lateinit var getPrivacyPolicyText: WebElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='CPS Content']")
    lateinit var cpsContent: MobileElement

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Trevor TEST (Direct)' and @index='4']")
    lateinit var trevorTest: MobileElement

    @AndroidFindBy(id = "bbc.mobile.news.uk.internal:id/snackbar_action")
    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/snackbar_action"), AndroidBy(id = "bbc.mobile.news.uk:id/snackbar_action"))
    lateinit var reloadButton: MobileElement

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Settings']")
    lateinit var menuSettings: MobileElement

}
