package com.bbcnews.automation.pageobjects

import io.appium.java_client.MobileElement
import io.appium.java_client.pagefactory.AndroidBy
import io.appium.java_client.pagefactory.AndroidFindAll
import io.appium.java_client.pagefactory.AndroidFindBy

object BBCNewsHindiPageObject {

    @AndroidFindBy(id = "android:id/button2")
    lateinit var noThanksButton: MobileElement

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='0']/android.widget.RelativeLayout[@index='0']/android.widget.LinearLayout[@index='1']/android.widget.TextView[@index='0']")
    lateinit var mainItemLayoutName: MobileElement

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='0']/android.widget.RelativeLayout[@index='0']/android.widget.LinearLayout[@index='1']/android.widget.LinearLayout[@index='1']/android.widget.LinearLayout[@index='0']/android.widget.TextView[@index='0']")
    lateinit var mainItemLayoutLastUpdated: MobileElement

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='1']/android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='1']")
    lateinit var articleItemLayoutName: MobileElement

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='1']/android.widget.RelativeLayout[@index='0']/android.widget.LinearLayout[@index='2']/android.widget.LinearLayout[@index='0']/android.widget.TextView[@index='0']")
    lateinit var articleItemLayoutLastUpdated: MobileElement

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
    lateinit var bbcHindiPleaseContact: MobileElement

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
    lateinit var hindiInternational: MobileElement

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

    @AndroidFindAll(AndroidBy(id = "uk.co.bbc.hindi.internal:id/image_item_caption"), AndroidBy(id = "uk.co.bbc.hindi:id/image_item_caption"))
    lateinit var imageItemCaption: MobileElement

    @AndroidFindAll(AndroidBy(id = "uk.co.bbc.hindi.internal:id/headline_title"), AndroidBy(id = "uk.co.bbc.hindi:id/headline_title"))
    lateinit var headlineTitle: MobileElement

    @AndroidFindAll(AndroidBy(id = "uk.co.bbc.hindi.internal:id/headline_info"), AndroidBy(id = "uk.co.bbc.hindi:id/headline_info"))
    lateinit var headlineInfo: MobileElement

    @AndroidFindAll(AndroidBy(id = "uk.co.bbc.hindi.internal:id/headline_author_name"), AndroidBy(id = "uk.co.bbc.hindi:id/headline_author_name"))
    lateinit var headlineAuthorName: MobileElement

    @AndroidFindAll(AndroidBy(id = "uk.co.bbc.hindi.internal:id/headline_author_title"), AndroidBy(id = "uk.co.bbc.hindi:id/headline_author_title"))
    lateinit var headlineAuthorTitle: MobileElement

    @AndroidFindAll(AndroidBy(xpath = "//android.widget.Button[@index='1']"), AndroidBy(xpath = "//android.widget.Button[@text='ओके']"))
    lateinit var bbcHindiOkButton: MobileElement

    @AndroidFindAll(AndroidBy(id = "uk.co.bbc.hindi.internal:id/image_item_badge"), AndroidBy(id = "uk.co.bbc.hindi:id/image_item_badge"))
    lateinit var imageItemBadge: MobileElement

    @AndroidFindAll(AndroidBy(id = "uk.co.bbc.hindi.internal:id/media_item_caption"), AndroidBy(id = "uk.co.bbc.hindi:id/media_item_caption"))
    lateinit var mediaItemCaption: MobileElement

    @AndroidFindAll(AndroidBy(id = "uk.co.bbc.hindi.internal:id/smp_seek_bar"), AndroidBy(id = "uk.co.bbc.hindi:id/smp_seek_bar"))
    lateinit var seekBar: MobileElement

    @AndroidFindAll(AndroidBy(id = "uk.co.bbc.hindi.internal:id/smp_pause_button"), AndroidBy(id = "uk.co.bbc.hindi:id/smp_pause_button"))
    lateinit var pauseButton: MobileElement

    @AndroidFindAll(AndroidBy(id = "uk.co.bbc.hindi.internal:id/title"), AndroidBy(id = "uk.co.bbc.hindi:id/title"))
    lateinit var picturesTitle: MobileElement

    @AndroidFindAll(AndroidBy(id = "uk.co.bbc.hindi.internal:id/subtitle"), AndroidBy(id = "uk.co.bbc.hindi:id/subtitle"))
    lateinit var picturesSubtitle: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@index='2']")
    lateinit var radioPageText: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@index='3']")
    lateinit var radioPageTextDaily: MobileElement

    @AndroidFindBy(id = "android:id/message")
    lateinit var bbcHindiMessage: MobileElement

    @AndroidFindBy(accessibility = "बैक")
    lateinit var backButton: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='हेमिल्टन जीता तो इतिहास रच देगी टीम इंडिया']")
    lateinit var sportsArticle: MobileElement

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='2']")
    lateinit var article: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='संबंधित टॉपिक']")
    lateinit var relatedTopics: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='संबंधित स्टोरीज़']")
    lateinit var relatedArticles: MobileElement

    @AndroidFindBy(accessibility = "Play")
    lateinit var playButton: MobileElement

    @AndroidFindBy(accessibility = "volume")
    lateinit var volumeButton: MobileElement

    @AndroidFindBy(accessibility = "Fullscreen")
    lateinit var fullScreenButton: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Front page']")
    lateinit var frontPage: MobileElement
}
