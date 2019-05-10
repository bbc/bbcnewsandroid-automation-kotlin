package com.bbcnews.automation.pageobjects

import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.pagefactory.AndroidBy
import io.appium.java_client.pagefactory.AndroidFindAll
import io.appium.java_client.pagefactory.AndroidFindBy

object CommonPageObjects {

    internal val appiumDriver: AppiumDriver<MobileElement>? = null

    @AndroidFindBy(accessibility = "Navigate up")
    lateinit var navigateBack: MobileElement

    //@AndroidFindBy(xpath = "//android.widget.Button[@resource-id='android:id/button1' and @text='OK']")
    @AndroidFindBy(xpath = "//android.widget.Button[@text='OK']")
    lateinit var okButton: MobileElement

    @AndroidFindBy(xpath = "//android.widget.Button[@text='GO TO SETTINGS']")
    lateinit var settingsButton: MobileElement

    @AndroidFindBy(accessibility = "Back")
    lateinit var backButton: MobileElement

    // @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='android:id/button2' and @text='NO, THANKS.']")
    @AndroidFindBy(xpath = "//android.widget.Button[@text='NO, THANKS.']")
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

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/action_search"), AndroidBy(accessibility = "Search"))
    lateinit var search: MobileElement

    @AndroidFindBy(id = "bbc.mobile.news.uk.internal:id/itemLayoutName")
    lateinit var itemLayoutName: MobileElement

    @AndroidFindBy(id = "bbc.mobile.news.uk.internal:id/itemLayoutLastUpdated")
    lateinit var itemLayoutLastUpdated: MobileElement

    @AndroidFindBy(id = "bbc.mobile.news.uk.internal:id/itemLayoutHomeSection")
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

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Search topics and articles']")
    lateinit var searchField: MobileElement

    // @AndroidFindBy(xpath="//android.widget.TextView[contains(@resource-id,'bbc.mobile.news.uk.internal:id/chip_item') and @index='0']")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Brexit' and @index='0']")
    lateinit var searchKeyword: MobileElement

    @AndroidFindBy(id = "bbc.mobile.news.uk.internal:id/title")
    lateinit var headlineTitle: MobileElement

    //  @AndroidFindBy(id = "bbc.mobile.news.uk.internal:id/heading")
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'bbc.mobile.news.uk.internal:id/heading') and @index='0']")
    //@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'bbc.mobile.news.uk.internal:id/content_card_ordered_badge') and @text='1']")
    lateinit var searchHeading: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='bbc.mobile.news.uk.internal:id/heading' and @index='2']")
    lateinit var searchHeading2: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='bbc.mobile.news.uk.internal:id/heading' and @index='4']")
    lateinit var searchHeading4: MobileElement

    @AndroidFindBy(xpath = "//bbc.mobile.news.uk.internal:id/chip_item[@index='1']")
    lateinit var searchSuggest1: MobileElement
    val searchSuggest1Text = "India"

    @AndroidFindBy(xpath = "//bbc.mobile.news.uk.internal:id/chip_item[@index='2']")
    lateinit var searchSuggest2: MobileElement
    val searchSuggest2Text = "India-Pakistan independence"

    @AndroidFindBy(xpath = "//bbc.mobile.news.uk.internal:id/chip_item[@index='3']")
    lateinit var searchSuggest3: MobileElement

    val searchSuggest3Text = "Rape in India"

    @AndroidFindBy(accessibility = "Cancel search")
    lateinit var cancelSearch: MobileElement

    val subDirectory = "Screenshots"

    lateinit var screenshotPaths: String

    val searchText = "Brexit"

    //BBC News Hindi Common Page Objects

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='होम पेज']")
    lateinit var bbcHindiHomepage: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='भारत']")
    lateinit var bbcHindiIndia: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='अंतरराष्ट्रीय']")
    lateinit var bbcHindiInternational: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='मनोरंजन']")
    lateinit var bbcHindiEntertainment: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='खेल']")
    lateinit var bbcHindiSports: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='रेडियो']")
    lateinit var bbcHindiRadio: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='विज्ञान-टेक्नॉलॉजी']")
    lateinit var bbcHindiScienceTechnology: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='देखिए']")
    lateinit var bbcHindiLookAt: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='तस्वीरें']")
    lateinit var bbcHindiThePhotos: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='सोशल']")
    lateinit var bbcHindiSocial: MobileElement

    @AndroidFindBy(accessibility = "More options")
    lateinit var bbcMoreOptions: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='सेटिंग्स']")
    lateinit var bbcHindiSettings: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='मदद']")
    lateinit var bbcHindiHelp: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='संपर्क करें']")
    lateinit var bbcHindipleasecontact: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='बीबीसी के दूसरे ऐप्स']")
    lateinit var bbcHindiOtherBbcApplications: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Internal Settings']")
    lateinit var bbcHindiInternalSettings: MobileElement

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@index='0']/android.view.ViewGroup[@index='0']/android.widget.ImageButton[@index='0']")
    lateinit var bbcHindiMoreSettings: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='स्थानीय समाचार']")
    lateinit var bbcHindiLocalNews: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='टॉपिक्स']")
    lateinit var bbcHindiTopics: MobileElement

    @AndroidFindBy(accessibility = "Button: टॉपिक्स , collapse group")
    lateinit var bbcHindiTopicsCollapseGroup: MobileElement

    @AndroidFindBy(accessibility = "Button: स्थानीय समाचार , collapse group")
    lateinit var bbcHindiLocalNewsCollapseGroup: MobileElement

    @AndroidFindBy(accessibility = "Button: होम पेज ")
    lateinit var hindiHomepage: MobileElement

    @AndroidFindBy(accessibility = "Button: भारत ")
    lateinit var hindiBharath: MobileElement

    @AndroidFindBy(accessibility = "Button: अंतरराष्ट्रीय ")
    lateinit var hindiInternatonal: MobileElement

    @AndroidFindBy(accessibility = "Button: मनोरंजन ")
    lateinit var hindiEntertainment: MobileElement

    @AndroidFindBy(accessibility = "Button: खेल ")
    lateinit var hindiSports: MobileElement

    @AndroidFindBy(accessibility = "Button: विज्ञान-टेक्नॉलॉजी ")
    lateinit var hindiScience: MobileElement

    @AndroidFindBy(accessibility = "Button: सोशल ")
    lateinit var hindiSocial: MobileElement

    @AndroidFindBy(accessibility = "Button: देखिए ")
    lateinit var hindiLookAt: MobileElement

    @AndroidFindBy(accessibility = "Button: तस्वीरें ")
    lateinit var hindiPhotos: MobileElement

    @AndroidFindBy(xpath = "//android.widget.Button[@index=1]")
    lateinit var bbcHindiOkButton: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='UK Politics added to My News']")
    //   @AndroidFindBy(id="bbc.mobile.news.uk.internal:id/snackbar_text")
    lateinit var alertText: MobileElement

    //@AndroidFindBy(id="bbc.mobile.news.uk.internal:id/snackbar_action")
    @AndroidFindBy(xpath = "//android.widget.Button[@text='UNDO' and @index='1']")
    lateinit var undoButton: MobileElement

    val alertTextUk = "UK Politics added to My News"

    val alertTextBusiness = "Business added to My News"

}