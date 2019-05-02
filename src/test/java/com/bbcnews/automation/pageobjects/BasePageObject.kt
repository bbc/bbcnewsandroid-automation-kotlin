package com.bbcnews.automation.pageobjects

import io.appium.java_client.MobileElement
import io.appium.java_client.pagefactory.AndroidBy
import io.appium.java_client.pagefactory.AndroidFindAll
import io.appium.java_client.pagefactory.AndroidFindBy
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

object BasePageObject {

    @AndroidFindBy(accessibility = "Navigate up")
    var navigateBack: MobileElement? = null

    @AndroidFindBy(id = "android:id/button1")
    var okButton: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.Button[@text='GO TO SETTINGS']")
    var settingsButton: MobileElement? = null

    @AndroidFindBy(accessibility = "Back")
    var backButton: MobileElement? = null

    @AndroidFindBy(id = "android:id/button2")
    var noThanksButton: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Top Stories']")
    var topStories: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='My News']")
    var myNews: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Popular']")
    var popular: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Video']")
    var video: MobileElement? = null

    @AndroidFindBy(accessibility = "Search")
    var searchButton: MobileElement? = null

    @AndroidFindBy(accessibility = "Share story")
    var shareStory: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/action_search"), AndroidBy(id = "bbc.mobile.news.uk:id/action_search"), AndroidBy(accessibility = "Search"))
    var search: MobileElement? = null

    var topicsPageElements = arrayOf("bbc.mobile.news.uk.internal:id/item_image", "bbc.mobile.news.uk.internal:id/item_layout_name", "bbc.mobile.news.uk.internal:id/itemLayoutLastUpdated", "bbc.mobile.news.uk.internal:id/itemLayoutHomeSection")

    var topicsPageElementsRelease = arrayOf("bbc.mobile.news.uk:id/item_image", "bbc.mobile.news.uk:id/item_layout_name", "bbc.mobile.news.uk:id/itemLayoutLastUpdated", "bbc.mobile.news.uk:id/itemLayoutHomeSection")

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/item_layout_name"), AndroidBy(id = "bbc.mobile.news.uk:id/item_layout_name"))
    var itemLayoutName: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/itemLayoutLastUpdated"), AndroidBy(id = "bbc.mobile.news.uk:id/itemLayoutLastUpdated"))
    var itemLayoutLastUpdated: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/itemLayoutHomeSection"), AndroidBy(id = "bbc.mobile.news.uk:id/itemLayoutHomeSection"))
    var itemLayoutHomeSection: MobileElement? = null

    @AndroidFindBy(accessibility = "Show navigation menu drawer")
    var menuButton: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Settings']")
    var settings: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='App info']")
    var appInfo: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Other BBC apps']")
    var otherBbcApps: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Internal Settings']")
    var internalSettings: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/search"), AndroidBy(id = "bbc.mobile.news.uk:id/search"))
    var searchField: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Brexit' and @index='0']")
    var searchKeyword: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/title"), AndroidBy(id = "bbc.mobile.news.uk:id/title"))
    var headlineTitle: MobileElement? = null

    @AndroidFindAll(AndroidBy(xpath = "//android.widget.TextView[contains(@resource-id,'bbc.mobile.news.uk.internal:id/heading') and @index='0']"), AndroidBy(xpath = "//android.widget.TextView[contains(@resource-id,'bbc.mobile.news.uk:id/heading') and @index='0']"))
    var searchHeading: MobileElement? = null

    @AndroidFindAll(AndroidBy(xpath = "//android.widget.TextView[@resource-id='bbc.mobile.news.uk.internal:id/heading' and @index='2']"), AndroidBy(xpath = "//android.widget.TextView[@resource-id='bbc.mobile.news.uk:id/heading' and @index='2']"))
    var searchHeading2: MobileElement? = null

    @AndroidFindAll(AndroidBy(xpath = "//android.widget.TextView[@resource-id='bbc.mobile.news.uk.internal:id/heading' and @index='4']"), AndroidBy(xpath = "//android.widget.TextView[@resource-id='bbc.mobile.news.uk:id/heading' and @index='4']"))
    var searchHeading4: MobileElement? = null

    @AndroidFindAll(AndroidBy(xpath = "//bbc.mobile.news.uk.internal:id/chip_item[@index='1']"), AndroidBy(xpath = "//bbc.mobile.news.uk:id/chip_item[@index='1']"))
    var searchSuggest1: MobileElement? = null

    @AndroidFindAll(AndroidBy(xpath = "//bbc.mobile.news.uk.internal:id/chip_item[@index='2']"), AndroidBy(xpath = "//bbc.mobile.news.uk:id/chip_item[@index='2']"))
    var searchSuggest2: MobileElement? = null

    @AndroidFindAll(AndroidBy(xpath = "//bbc.mobile.news.uk.internal:id/chip_item[@index='3']"), AndroidBy(xpath = "//bbc.mobile.news.uk.internal:id/chip_item[@index='3']"))
    var searchSuggest3: MobileElement? = null

    @AndroidFindBy(accessibility = "Cancel search")
    var cancelSearch: MobileElement? = null

    var subDirectory = "Screenshots"

    var screenshotPaths: String? = null

    var searchText = "Brexit"

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='UK Politics added to My News']")
    var alertText: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.Button[@text='UNDO' and @index='1']")
    var undoButton: MobileElement? = null

    var alertTextUk = "UK Politics added to My News"

    var alertTextBusiness = "Business added to My News"

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Rape in India']")
    var article: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='3']/android.view.ViewGroup[@index='0']/android.widget.ImageView[@index='0']")
    var articleSearch: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='How social media helped catch rape suspect' and @index='1']")
    var articleItemWithItemBadge: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='India bishop accused of rape arrested' and @index='1']")
    var articleItemWithoutItemBadge: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[6]/bbc.mobile.news.uk.internal:id/main_view[0]/android.widget.ImageView[@index='0']")
    var articleItemImage: MobileElement? = null

    @AndroidFindAll(AndroidBy(xpath = "//android.widget.TextView[contains(@resource-id,'bbc.mobile.news.uk.internal:id/item_layout_name') and @index='0']"), AndroidBy(xpath = "//android.widget.TextView[contains(@resource-id,'bbc.mobile.news.uk:id/item_layout_name') and @index='0']"))
    var articleLayoutName: MobileElement? = null

    @AndroidFindAll(AndroidBy(xpath = "//android.widget.TextView[contains(@resource-id,'bbc.mobile.news.uk.internal:id/itemLayoutLastUpdated') and @index='0']"), AndroidBy(xpath = "//android.widget.TextView[contains(@resource-id,'bbc.mobile.news.uk:id/itemLayoutLastUpdated') and @index='0']"))
    var articleLastUpdated: MobileElement? = null

    @AndroidFindAll(AndroidBy(xpath = "//android.widget.TextView[contains(@resource-id,'bbc.mobile.news.uk.internal:id/itemLayoutHomeSection') and @index='0']"), AndroidBy(xpath = "//android.widget.TextView[contains(@resource-id,'bbc.mobile.news.uk:id/itemLayoutHomeSection') and @index='0']"))
    var articleHomeSection: MobileElement? = null

    var articleDetailPageLinks = arrayOf("bbc.mobile.news.uk.internal:id/image_item_caption", "bbc.mobile.news.uk.internal:id/headline_title", "bbc.mobile.news.uk.internal:id/headline_info", "bbc.mobile.news.uk.internal:id/headline_link")

    var articleDetailPageLinksRelease = arrayOf("bbc.mobile.news.uk:id/image_item_caption", "bbc.mobile.news.uk:id/headline_title", "bbc.mobile.news.uk:id/headline_info", "bbc.mobile.news.uk:id/headline_link")

    var articleItemWithImageBadge = arrayOf("Hundreds of people poured onto the streets demanding justice for the girl", "How India viral messages helped catch rape suspect", "10 Jul 2018", "India")

    var articleItemWithoutImageBadge = arrayOf("Bishop Franco Mulakkal denies wrongoing", "India bishop accused of rape arrested in Kerala", "21 Sep 2018", "India")

    var articlePageDetail = arrayOf("India man held for rape of British woman in Goa", "21 Dec 2018", "India")

    var articlePageDetailElements = arrayOf("bbc.mobile.news.uk.internal:id/headline_title", "bbc.mobile.news.uk.internal:id/headline_info", "bbc.mobile.news.uk.internal:id/headline_link")

    var articlePageDetailElementsRelease = arrayOf("bbc.mobile.news.uk:id/headline_title", "bbc.mobile.news.uk:id/headline_info", "bbc.mobile.news.uk:id/headline_link")

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/image_item_badge"), AndroidBy(id = "bbc.mobile.news.uk:id/image_item_badge"))
    var articleImageBadge: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Related stories']")
    var relatedStories: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Related topics']")
    var relatedTopics: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/smp_error_message"), AndroidBy(id = "bbc.mobile.news.uk:id/smp_error_message"))
    var smpErrorMessage: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/smp_error_button"), AndroidBy(id = "bbc.mobile.news.uk:id/smp_error_button"))
    var smpErrorOkButton: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/smp_retry_button"), AndroidBy(id = "bbc.mobile.news.uk:id/smp_retry_button"))
    var smpRetryButton: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/error_retry"), AndroidBy(id = "bbc.mobile.news.uk:id/error_retry"))
    var errorRetryButton: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.ListView[@index='0']")
    var appInfoListView: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='App info']")
    var menuAppInfo: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Terms of use']")
    var termsConditions: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Privacy policy']")
    var privacyPolicy: MobileElement? = null

    @FindBy(xpath = "//*[contains(text(), 'A few rules for us and you')]")
    var termsOfUseText: WebElement? = null

    @FindBy(xpath = "//*[contains(text(), 'Keeping your info safe & sound')]")
    var privacyPolicyText: WebElement? = null

    @FindBy(xpath = "//*[contains(text(), 'Your Information & Privacy')]")
    var getPrivacyPolicyText: WebElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='CPS Content']")
    var cpsContent: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Trevor TEST (Direct)' and @index='4']")
    var trevorTest: MobileElement? = null

    @AndroidFindBy(id = "bbc.mobile.news.uk.internal:id/snackbar_action")
    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/snackbar_action"), AndroidBy(id = "bbc.mobile.news.uk:id/snackbar_action"))
    var reloadButton: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Settings']")
    var menuSettings: MobileElement? = null

}
