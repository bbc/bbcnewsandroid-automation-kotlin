package com.bbcnews.automation.pageobjects

import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.pagefactory.AndroidBy
import io.appium.java_client.pagefactory.AndroidFindAll
import io.appium.java_client.pagefactory.AndroidFindBy

object CommonPageObjects {

    internal val appiumDriver: AppiumDriver<MobileElement>? = null

    fun commonPageObjects() {

    }

    @AndroidFindBy(accessibility = "Navigate up")
    val navigateBack: MobileElement? = null

    //@AndroidFindBy(xpath = "//android.widget.Button[@resource-id='android:id/button1' and @text='OK']")
    @AndroidFindBy(xpath = "//android.widget.Button[@text='OK']")
    val okButton: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.Button[@text='GO TO SETTINGS']")
    val settingsButton: MobileElement? = null

    @AndroidFindBy(accessibility = "Back")
    val backButton: MobileElement? = null

    // @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='android:id/button2' and @text='NO, THANKS.']")
    @AndroidFindBy(xpath = "//android.widget.Button[@text='NO, THANKS.']")
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

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/action_search"), AndroidBy(accessibility = "Search"))
    val search: MobileElement? = null

    @AndroidFindBy(id = "bbc.mobile.news.uk.internal:id/itemLayoutName")
    val itemLayoutName: MobileElement? = null

    @AndroidFindBy(id = "bbc.mobile.news.uk.internal:id/itemLayoutLastUpdated")
    val itemLayoutLastUpdated: MobileElement? = null

    @AndroidFindBy(id = "bbc.mobile.news.uk.internal:id/itemLayoutHomeSection")
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

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Search topics and articles']")
    val searchField: MobileElement? = null

    // @AndroidFindBy(xpath="//android.widget.TextView[contains(@resource-id,'bbc.mobile.news.uk.internal:id/chip_item') and @index='0']")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Brexit' and @index='0']")
    val searchKeyword: MobileElement? = null

    @AndroidFindBy(id = "bbc.mobile.news.uk.internal:id/title")
    val headlineTitle: MobileElement? = null

    //  @AndroidFindBy(id = "bbc.mobile.news.uk.internal:id/heading")
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'bbc.mobile.news.uk.internal:id/heading') and @index='0']")
    //@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'bbc.mobile.news.uk.internal:id/content_card_ordered_badge') and @text='1']")
    val searchHeading: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='bbc.mobile.news.uk.internal:id/heading' and @index='2']")
    val searchHeading2: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='bbc.mobile.news.uk.internal:id/heading' and @index='4']")
    val searchHeading4: MobileElement? = null

    @AndroidFindBy(xpath = "//bbc.mobile.news.uk.internal:id/chip_item[@index='1']")
    val searchSuggest1: MobileElement? = null
    val searchSuggest1Text = "India"

    @AndroidFindBy(xpath = "//bbc.mobile.news.uk.internal:id/chip_item[@index='2']")
    val searchSuggest2: MobileElement? = null
    val searchSuggest2Text = "India-Pakistan independence"

    @AndroidFindBy(xpath = "//bbc.mobile.news.uk.internal:id/chip_item[@index='3']")
    val searchSuggest3: MobileElement? = null

    val searchSuggest3Text = "Rape in India"

    @AndroidFindBy(accessibility = "Cancel search")
    val cancelSearch: MobileElement? = null

    val subDirectory = "Screenshots"

    val screenshotPaths: String? = null

    val searchText = "Brexit"

    //BBC News Hindi Common Page Objects

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='होम पेज']")
    val bbcHindiHomepage: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='भारत']")
    val bbcHindiIndia: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='अंतरराष्ट्रीय']")
    val bbcHindiInternational: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='मनोरंजन']")
    val bbcHindiEntertainment: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='खेल']")
    val bbcHindiSports: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='रेडियो']")
    val bbcHindiRadio: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='विज्ञान-टेक्नॉलॉजी']")
    val bbcHindiScienceTechnology: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='देखिए']")
    val bbcHindiLookAt: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='तस्वीरें']")
    val bbcHindiThePhotos: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='सोशल']")
    val bbcHindiSocial: MobileElement? = null

    @AndroidFindBy(accessibility = "More options")
    val bbcMoreOptions: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='सेटिंग्स']")
    val bbcHindiSettings: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='मदद']")
    val bbcHindiHelp: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='संपर्क करें']")
    val bbcHindipleasecontact: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='बीबीसी के दूसरे ऐप्स']")
    val bbcHindiOtherBbcApplications: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Internal Settings']")
    val bbcHindiInternalSettings: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@index='0']/android.view.ViewGroup[@index='0']/android.widget.ImageButton[@index='0']")
    val bbcHindiMoreSettings: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='स्थानीय समाचार']")
    val bbcHindiLocalNews: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='टॉपिक्स']")
    val bbcHindiTopics: MobileElement? = null

    @AndroidFindBy(accessibility = "Button: टॉपिक्स , collapse group")
    val bbcHindiTopicsCollapseGroup: MobileElement? = null

    @AndroidFindBy(accessibility = "Button: स्थानीय समाचार , collapse group")
    val bbcHindiLocalNewsCollapseGroup: MobileElement? = null

    @AndroidFindBy(accessibility = "Button: होम पेज ")
    val hindiHomepage: MobileElement? = null

    @AndroidFindBy(accessibility = "Button: भारत ")
    val hindiBharath: MobileElement? = null

    @AndroidFindBy(accessibility = "Button: अंतरराष्ट्रीय ")
    val hindiInternatonal: MobileElement? = null

    @AndroidFindBy(accessibility = "Button: मनोरंजन ")
    val hindiEntertainment: MobileElement? = null

    @AndroidFindBy(accessibility = "Button: खेल ")
    val hindiSports: MobileElement? = null

    @AndroidFindBy(accessibility = "Button: विज्ञान-टेक्नॉलॉजी ")
    val hindiScience: MobileElement? = null

    @AndroidFindBy(accessibility = "Button: सोशल ")
    val hindiSocial: MobileElement? = null

    @AndroidFindBy(accessibility = "Button: देखिए ")
    val hindiLookAt: MobileElement? = null

    @AndroidFindBy(accessibility = "Button: तस्वीरें ")
    val hindiPhotos: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.Button[@index=1]")
    val bbcHindiOkButton: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='UK Politics added to My News']")
    //   @AndroidFindBy(id="bbc.mobile.news.uk.internal:id/snackbar_text")
    val alertText: MobileElement? = null

    //@AndroidFindBy(id="bbc.mobile.news.uk.internal:id/snackbar_action")
    @AndroidFindBy(xpath = "//android.widget.Button[@text='UNDO' and @index='1']")
    val undoButton: MobileElement? = null

    val alertTextUk = "UK Politics added to My News"

    val alertTextBusiness = "Business added to My News"

}