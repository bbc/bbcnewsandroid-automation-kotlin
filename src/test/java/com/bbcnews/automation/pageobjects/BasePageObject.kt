package com.bbcnews.automation.pageobjects

import io.appium.java_client.MobileElement
import io.appium.java_client.pagefactory.AndroidBy
import io.appium.java_client.pagefactory.AndroidFindAll
import io.appium.java_client.pagefactory.AndroidFindBy
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

object BasePageObject {

    @AndroidFindBy(accessibility = "Navigate up")
    val navigateBack: MobileElement? = null

    @AndroidFindBy(id = "android:id/button1")
    val okButton: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.Button[@text='GO TO SETTINGS']")
    val settingsButton: MobileElement? = null

    @AndroidFindBy(accessibility = "Back")
    val backButton: MobileElement? = null

    @AndroidFindBy(id = "android:id/button2")
    val noThanksButton: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Top Stories']")
    val topStories: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='My News']")
    val myNews: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Popular']")
    val popular: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Video']")
    val video: MobileElement? = null

    @AndroidFindBy(accessibility = "Search")
    val searchButton: MobileElement? = null

    @AndroidFindBy(accessibility = "Share story")
    val shareStory: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/action_search"), AndroidBy(id = "bbc.mobile.news.uk:id/action_search"), AndroidBy(accessibility = "Search"))
    val search: MobileElement? = null

    val topicsPageElements = arrayOf("bbc.mobile.news.uk.internal:id/item_image", "bbc.mobile.news.uk.internal:id/item_layout_name", "bbc.mobile.news.uk.internal:id/itemLayoutLastUpdated", "bbc.mobile.news.uk.internal:id/itemLayoutHomeSection")

    val topicsPageElementsRelease = arrayOf("bbc.mobile.news.uk:id/item_image", "bbc.mobile.news.uk:id/item_layout_name", "bbc.mobile.news.uk:id/itemLayoutLastUpdated", "bbc.mobile.news.uk:id/itemLayoutHomeSection")

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/item_layout_name"), AndroidBy(id = "bbc.mobile.news.uk:id/item_layout_name"))
    val itemLayoutName: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/itemLayoutLastUpdated"), AndroidBy(id = "bbc.mobile.news.uk:id/itemLayoutLastUpdated"))
    val itemLayoutLastUpdated: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/itemLayoutHomeSection"), AndroidBy(id = "bbc.mobile.news.uk:id/itemLayoutHomeSection"))
    val itemLayoutHomeSection: MobileElement? = null

    @AndroidFindBy(accessibility = "Show navigation menu drawer")
    val menuButton: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Settings']")
    val settings: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='App info']")
    val appInfo: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Other BBC apps']")
    val otherBbcApps: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Internal Settings']")
    val internalSettings: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/search"), AndroidBy(id = "bbc.mobile.news.uk:id/search"))
    val searchField: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Brexit' and @index='0']")
    val searchKeyword: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/title"), AndroidBy(id = "bbc.mobile.news.uk:id/title"))
    val headlineTitle: MobileElement? = null

    @AndroidFindAll(AndroidBy(xpath = "//android.widget.TextView[contains(@resource-id,'bbc.mobile.news.uk.internal:id/heading') and @index='0']"), AndroidBy(xpath = "//android.widget.TextView[contains(@resource-id,'bbc.mobile.news.uk:id/heading') and @index='0']"))
    val searchHeading: MobileElement? = null

    @AndroidFindAll(AndroidBy(xpath = "//android.widget.TextView[@resource-id='bbc.mobile.news.uk.internal:id/heading' and @index='2']"), AndroidBy(xpath = "//android.widget.TextView[@resource-id='bbc.mobile.news.uk:id/heading' and @index='2']"))
    val searchHeading2: MobileElement? = null

    @AndroidFindAll(AndroidBy(xpath = "//android.widget.TextView[@resource-id='bbc.mobile.news.uk.internal:id/heading' and @index='4']"), AndroidBy(xpath = "//android.widget.TextView[@resource-id='bbc.mobile.news.uk:id/heading' and @index='4']"))
    val searchHeading4: MobileElement? = null

    @AndroidFindAll(AndroidBy(xpath = "//bbc.mobile.news.uk.internal:id/chip_item[@index='1']"), AndroidBy(xpath = "//bbc.mobile.news.uk:id/chip_item[@index='1']"))
    val searchSuggest1: MobileElement? = null

    @AndroidFindAll(AndroidBy(xpath = "//bbc.mobile.news.uk.internal:id/chip_item[@index='2']"), AndroidBy(xpath = "//bbc.mobile.news.uk:id/chip_item[@index='2']"))
    val searchSuggest2: MobileElement? = null

    @AndroidFindAll(AndroidBy(xpath = "//bbc.mobile.news.uk.internal:id/chip_item[@index='3']"), AndroidBy(xpath = "//bbc.mobile.news.uk.internal:id/chip_item[@index='3']"))
    val searchSuggest3: MobileElement? = null

    @AndroidFindBy(accessibility = "Cancel search")
    val cancelSearch: MobileElement? = null

    val subDirectory = "Screenshots"

    val screenshotPaths: String? = null

    const val searchText = "Brexit"

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='UK Politics added to My News']")
    val alertText: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.Button[@text='UNDO' and @index='1']")
    val undoButton: MobileElement? = null

    val alertTextUk = "UK Politics added to My News"

    val alertTextBusiness = "Business added to My News"

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Rape in India']")
    val article: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='3']/android.view.ViewGroup[@index='0']/android.widget.ImageView[@index='0']")
    val articleSearch: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='How social media helped catch rape suspect' and @index='1']")
    val articleItemWithItemBadge: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='India bishop accused of rape arrested' and @index='1']")
    val articleItemWithoutItemBadge: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[6]/bbc.mobile.news.uk.internal:id/main_view[0]/android.widget.ImageView[@index='0']")
    val articleItemImage: MobileElement? = null

    @AndroidFindAll(AndroidBy(xpath = "//android.widget.TextView[contains(@resource-id,'bbc.mobile.news.uk.internal:id/item_layout_name') and @index='0']"), AndroidBy(xpath = "//android.widget.TextView[contains(@resource-id,'bbc.mobile.news.uk:id/item_layout_name') and @index='0']"))
    val articleLayoutName: MobileElement? = null

    @AndroidFindAll(AndroidBy(xpath = "//android.widget.TextView[contains(@resource-id,'bbc.mobile.news.uk.internal:id/itemLayoutLastUpdated') and @index='0']"), AndroidBy(xpath = "//android.widget.TextView[contains(@resource-id,'bbc.mobile.news.uk:id/itemLayoutLastUpdated') and @index='0']"))
    val articleLastUpdated: MobileElement? = null

    @AndroidFindAll(AndroidBy(xpath = "//android.widget.TextView[contains(@resource-id,'bbc.mobile.news.uk.internal:id/itemLayoutHomeSection') and @index='0']"), AndroidBy(xpath = "//android.widget.TextView[contains(@resource-id,'bbc.mobile.news.uk:id/itemLayoutHomeSection') and @index='0']"))
    val articleHomeSection: MobileElement? = null

    val articleDetailPageLinks = arrayOf("bbc.mobile.news.uk.internal:id/image_item_caption", "bbc.mobile.news.uk.internal:id/headline_title", "bbc.mobile.news.uk.internal:id/headline_info", "bbc.mobile.news.uk.internal:id/headline_link")

    val articleDetailPageLinksRelease = arrayOf("bbc.mobile.news.uk:id/image_item_caption", "bbc.mobile.news.uk:id/headline_title", "bbc.mobile.news.uk:id/headline_info", "bbc.mobile.news.uk:id/headline_link")

    val articleItemWithImageBadge = arrayOf("Hundreds of people poured onto the streets demanding justice for the girl", "How India viral messages helped catch rape suspect", "10 Jul 2018", "India")

    val articleItemWithoutImageBadge = arrayOf("Bishop Franco Mulakkal denies wrongoing", "India bishop accused of rape arrested in Kerala", "21 Sep 2018", "India")

    val articlePageDetail = arrayOf("India man held for rape of British woman in Goa", "21 Dec 2018", "India")

    val articlePageDetailElements = arrayOf("bbc.mobile.news.uk.internal:id/headline_title", "bbc.mobile.news.uk.internal:id/headline_info", "bbc.mobile.news.uk.internal:id/headline_link")

    val articlePageDetailElementsRelease = arrayOf("bbc.mobile.news.uk:id/headline_title", "bbc.mobile.news.uk:id/headline_info", "bbc.mobile.news.uk:id/headline_link")

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/image_item_badge"), AndroidBy(id = "bbc.mobile.news.uk:id/image_item_badge"))
    val articleImageBadge: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Related stories']")
    val relatedStories: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Related topics']")
    val relatedTopics: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/smp_error_message"), AndroidBy(id = "bbc.mobile.news.uk:id/smp_error_message"))
    val smpErrorMessage: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/smp_error_button"), AndroidBy(id = "bbc.mobile.news.uk:id/smp_error_button"))
    val smpErrorOkButton: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/smp_retry_button"), AndroidBy(id = "bbc.mobile.news.uk:id/smp_retry_button"))
    val smpRetryButton: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/error_retry"), AndroidBy(id = "bbc.mobile.news.uk:id/error_retry"))
    val errorRetryButton: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.ListView[@index='0']")
    val appInfoListView: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='App info']")
    val menuAppInfo: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Terms of use']")
    val termsConditions: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Privacy policy']")
    val privacyPolicy: MobileElement? = null

    @FindBy(xpath = "//*[contains(text(), 'A few rules for us and you')]")
    val termsOfUseText: WebElement? = null

    @FindBy(xpath = "//*[contains(text(), 'Keeping your info safe & sound')]")
    val privacyPolicyText: WebElement? = null

    @FindBy(xpath = "//*[contains(text(), 'Your Information & Privacy')]")
    val getPrivacyPolicyText: WebElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='CPS Content']")
    val cpsContent: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Trevor TEST (Direct)' and @index='4']")
    val trevorTest: MobileElement? = null

    @AndroidFindBy(id = "bbc.mobile.news.uk.internal:id/snackbar_action")
    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/snackbar_action"), AndroidBy(id = "bbc.mobile.news.uk:id/snackbar_action"))
    val reloadButton: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Settings']")
    val menuSettings: MobileElement? = null

}
