package com.bbcnews.automation.pageobjects

import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.pagefactory.AndroidBy
import io.appium.java_client.pagefactory.AndroidFindAll
import io.appium.java_client.pagefactory.AndroidFindBy

class CommonPageObjects {

    internal var appiumDriver: AppiumDriver<MobileElement>? = null

    fun commonPageObjects() {

    }

    @AndroidFindBy(accessibility = "Navigate up")
    var navigateBack: MobileElement? = null

    //@AndroidFindBy(xpath = "//android.widget.Button[@resource-id='android:id/button1' and @text='OK']")
    @AndroidFindBy(xpath = "//android.widget.Button[@text='OK']")
    var okButton: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.Button[@text='GO TO SETTINGS']")
    var settingsButton: MobileElement? = null

    @AndroidFindBy(accessibility = "Back")
    var backButton: MobileElement? = null

    // @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='android:id/button2' and @text='NO, THANKS.']")
    @AndroidFindBy(xpath = "//android.widget.Button[@text='NO, THANKS.']")
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

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/action_search"), AndroidBy(accessibility = "Search"))
    var search: MobileElement? = null

    @AndroidFindBy(id = "bbc.mobile.news.uk.internal:id/itemLayoutName")
    var itemLayoutName: MobileElement? = null

    @AndroidFindBy(id = "bbc.mobile.news.uk.internal:id/itemLayoutLastUpdated")
    var itemLayoutLastUpdated: MobileElement? = null

    @AndroidFindBy(id = "bbc.mobile.news.uk.internal:id/itemLayoutHomeSection")
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

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Search topics and articles']")
    var searchField: MobileElement? = null

    // @AndroidFindBy(xpath="//android.widget.TextView[contains(@resource-id,'bbc.mobile.news.uk.internal:id/chip_item') and @index='0']")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Brexit' and @index='0']")
    var searchKeyword: MobileElement? = null

    @AndroidFindBy(id = "bbc.mobile.news.uk.internal:id/title")
    var headlineTitle: MobileElement? = null

    //  @AndroidFindBy(id = "bbc.mobile.news.uk.internal:id/heading")
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'bbc.mobile.news.uk.internal:id/heading') and @index='0']")
    //@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'bbc.mobile.news.uk.internal:id/content_card_ordered_badge') and @text='1']")
    var searchHeading: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='bbc.mobile.news.uk.internal:id/heading' and @index='2']")
    var searchHeading2: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='bbc.mobile.news.uk.internal:id/heading' and @index='4']")
    var searchHeading4: MobileElement? = null

    @AndroidFindBy(xpath = "//bbc.mobile.news.uk.internal:id/chip_item[@index='1']")
    var searchSuggest1: MobileElement? = null
    var searchSuggest1Text = "India"

    @AndroidFindBy(xpath = "//bbc.mobile.news.uk.internal:id/chip_item[@index='2']")
    var searchSuggest2: MobileElement? = null
    var searchSuggest2Text = "India-Pakistan independence"

    @AndroidFindBy(xpath = "//bbc.mobile.news.uk.internal:id/chip_item[@index='3']")
    var searchSuggest3: MobileElement? = null

    var searchSuggest3Text = "Rape in India"

    @AndroidFindBy(accessibility = "Cancel search")
    var cancelSearch: MobileElement? = null

    var subDirectory = "Screenshots"

    var screenshotPaths: String? = null

    var searchText = "Brexit"

    //BBC News Hindi Common Page Objects

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='होम पेज']")
    var bbcHindiHomepage: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='भारत']")
    var bbcHindiIndia: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='अंतरराष्ट्रीय']")
    var bbcHindiInternational: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='मनोरंजन']")
    var bbcHindiEntertainment: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='खेल']")
    var bbcHindiSports: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='रेडियो']")
    var bbcHindiRadio: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='विज्ञान-टेक्नॉलॉजी']")
    var bbcHindiScienceTechnology: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='देखिए']")
    var bbcHindiLookAt: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='तस्वीरें']")
    var bbcHindiThePhotos: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='सोशल']")
    var bbcHindiSocial: MobileElement? = null

    @AndroidFindBy(accessibility = "More options")
    var bbcMoreOptions: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='सेटिंग्स']")
    var bbcHindiSettings: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='मदद']")
    var bbcHindiHelp: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='संपर्क करें']")
    var bbcHindipleasecontact: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='बीबीसी के दूसरे ऐप्स']")
    var bbcHindiOtherBbcApplications: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Internal Settings']")
    var bbcHindiInternalSettings: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@index='0']/android.view.ViewGroup[@index='0']/android.widget.ImageButton[@index='0']")
    var bbcHindiMoreSettings: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='स्थानीय समाचार']")
    var bbcHindiLocalNews: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='टॉपिक्स']")
    var bbcHindiTopics: MobileElement? = null

    @AndroidFindBy(accessibility = "Button: टॉपिक्स , collapse group")
    var bbcHindiTopicsCollapseGroup: MobileElement? = null

    @AndroidFindBy(accessibility = "Button: स्थानीय समाचार , collapse group")
    var bbcHindiLocalNewsCollapseGroup: MobileElement? = null

    @AndroidFindBy(accessibility = "Button: होम पेज ")
    var hindiHomepage: MobileElement? = null

    @AndroidFindBy(accessibility = "Button: भारत ")
    var hindiBharath: MobileElement? = null

    @AndroidFindBy(accessibility = "Button: अंतरराष्ट्रीय ")
    var hindiInternatonal: MobileElement? = null

    @AndroidFindBy(accessibility = "Button: मनोरंजन ")
    var hindiEntertainment: MobileElement? = null

    @AndroidFindBy(accessibility = "Button: खेल ")
    var hindiSports: MobileElement? = null

    @AndroidFindBy(accessibility = "Button: विज्ञान-टेक्नॉलॉजी ")
    var hindiScience: MobileElement? = null

    @AndroidFindBy(accessibility = "Button: सोशल ")
    var hindiSocial: MobileElement? = null

    @AndroidFindBy(accessibility = "Button: देखिए ")
    var hindiLookAt: MobileElement? = null

    @AndroidFindBy(accessibility = "Button: तस्वीरें ")
    var hindiPhotos: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.Button[@index=1]")
    var bbcHindiOkButton: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='UK Politics added to My News']")
    //   @AndroidFindBy(id="bbc.mobile.news.uk.internal:id/snackbar_text")
    var alertText: MobileElement? = null

    //@AndroidFindBy(id="bbc.mobile.news.uk.internal:id/snackbar_action")
    @AndroidFindBy(xpath = "//android.widget.Button[@text='UNDO' and @index='1']")
    var undoButton: MobileElement? = null

    var alertTextUk = "UK Politics added to My News"

    var alertTextBusiness = "Business added to My News"

}