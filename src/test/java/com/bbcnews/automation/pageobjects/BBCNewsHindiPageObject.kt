package com.bbcnews.automation.pageobjects

import io.appium.java_client.MobileElement
import io.appium.java_client.pagefactory.AndroidBy
import io.appium.java_client.pagefactory.AndroidFindAll
import io.appium.java_client.pagefactory.AndroidFindBy

object BBCNewsHindiPageObject {

    @AndroidFindBy(id = "android:id/button2")
    var noThanksButton: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='0']/android.widget.RelativeLayout[@index='0']/android.widget.LinearLayout[@index='1']/android.widget.TextView[@index='0']")
    var mainItemLayoutName: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='0']/android.widget.RelativeLayout[@index='0']/android.widget.LinearLayout[@index='1']/android.widget.LinearLayout[@index='1']/android.widget.LinearLayout[@index='0']/android.widget.TextView[@index='0']")
    var mainItemLayoutLastUpdated: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='1']/android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='1']")
    var articleItemLayoutName: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='1']/android.widget.RelativeLayout[@index='0']/android.widget.LinearLayout[@index='2']/android.widget.LinearLayout[@index='0']/android.widget.TextView[@index='0']")
    var articleItemLayoutLastUpdated: MobileElement? = null

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
    var bbcHindiPleaseContact: MobileElement? = null

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
    var hindiInternational: MobileElement? = null

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

    @AndroidFindAll(AndroidBy(id = "uk.co.bbc.hindi.internal:id/image_item_caption"), AndroidBy(id = "uk.co.bbc.hindi:id/image_item_caption"))
    var imageItemCaption: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "uk.co.bbc.hindi.internal:id/headline_title"), AndroidBy(id = "uk.co.bbc.hindi:id/headline_title"))
    var headlineTitle: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "uk.co.bbc.hindi.internal:id/headline_info"), AndroidBy(id = "uk.co.bbc.hindi:id/headline_info"))
    var headlineInfo: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "uk.co.bbc.hindi.internal:id/headline_author_name"), AndroidBy(id = "uk.co.bbc.hindi:id/headline_author_name"))
    var headlineAuthorName: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "uk.co.bbc.hindi.internal:id/headline_author_title"), AndroidBy(id = "uk.co.bbc.hindi:id/headline_author_title"))
    var headlineAuthorTitle: MobileElement? = null

    @AndroidFindAll(AndroidBy(xpath = "//android.widget.Button[@index='1']"), AndroidBy(xpath = "//android.widget.Button[@text='ओके']"))
    var bbcHindiOkButton: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "uk.co.bbc.hindi.internal:id/image_item_badge"), AndroidBy(id = "uk.co.bbc.hindi:id/image_item_badge"))
    var imageItemBadge: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "uk.co.bbc.hindi.internal:id/media_item_caption"), AndroidBy(id = "uk.co.bbc.hindi:id/media_item_caption"))
    var mediaItemCaption: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "uk.co.bbc.hindi.internal:id/smp_seek_bar"), AndroidBy(id = "uk.co.bbc.hindi:id/smp_seek_bar"))
    var seekBar: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "uk.co.bbc.hindi.internal:id/smp_pause_button"), AndroidBy(id = "uk.co.bbc.hindi:id/smp_pause_button"))
    var pauseButton: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "uk.co.bbc.hindi.internal:id/title"), AndroidBy(id = "uk.co.bbc.hindi:id/title"))
    var picturesTitle: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "uk.co.bbc.hindi.internal:id/subtitle"), AndroidBy(id = "uk.co.bbc.hindi:id/subtitle"))
    var picturesSubtitle: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@index='2']")
    var radioPageText: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@index='3']")
    var radioPageTextDaily: MobileElement? = null

    @AndroidFindBy(id = "android:id/message")
    var bbcHindiMessage: MobileElement? = null

    @AndroidFindBy(accessibility = "बैक")
    var backButton: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='हेमिल्टन जीता तो इतिहास रच देगी टीम इंडिया']")
    var sportsArticle: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='2']")
    var article: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='संबंधित टॉपिक']")
    var relatedTopics: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='संबंधित स्टोरीज़']")
    var relatedArticles: MobileElement? = null

    @AndroidFindBy(accessibility = "Play")
    var playButton: MobileElement? = null

    @AndroidFindBy(accessibility = "volume")
    var volumeButton: MobileElement? = null

    @AndroidFindBy(accessibility = "Fullscreen")
    var fullScreenButton: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Front page']")
    var frontPage: MobileElement? = null
}
