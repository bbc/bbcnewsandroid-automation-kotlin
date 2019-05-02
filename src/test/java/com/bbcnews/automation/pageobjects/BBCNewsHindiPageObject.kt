package com.bbcnews.automation.pageobjects

import io.appium.java_client.MobileElement
import io.appium.java_client.pagefactory.AndroidBy
import io.appium.java_client.pagefactory.AndroidFindAll
import io.appium.java_client.pagefactory.AndroidFindBy

object BBCNewsHindiPageObject {

    @AndroidFindBy(id = "android:id/button2")
    val noThanksButton: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='0']/android.widget.RelativeLayout[@index='0']/android.widget.LinearLayout[@index='1']/android.widget.TextView[@index='0']")
    val mainItemLayoutName: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='0']/android.widget.RelativeLayout[@index='0']/android.widget.LinearLayout[@index='1']/android.widget.LinearLayout[@index='1']/android.widget.LinearLayout[@index='0']/android.widget.TextView[@index='0']")
    val mainItemLayoutLastUpdated: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='1']/android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='1']")
    val articleItemLayoutName: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='1']/android.widget.RelativeLayout[@index='0']/android.widget.LinearLayout[@index='2']/android.widget.LinearLayout[@index='0']/android.widget.TextView[@index='0']")
    val articleItemLayoutLastUpdated: MobileElement? = null

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
    val bbcHindiPleaseContact: MobileElement? = null

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
    val hindiInternational: MobileElement? = null

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

    @AndroidFindAll(AndroidBy(id = "uk.co.bbc.hindi.internal:id/image_item_caption"), AndroidBy(id = "uk.co.bbc.hindi:id/image_item_caption"))
    val imageItemCaption: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "uk.co.bbc.hindi.internal:id/headline_title"), AndroidBy(id = "uk.co.bbc.hindi:id/headline_title"))
    val headlineTitle: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "uk.co.bbc.hindi.internal:id/headline_info"), AndroidBy(id = "uk.co.bbc.hindi:id/headline_info"))
    val headlineInfo: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "uk.co.bbc.hindi.internal:id/headline_author_name"), AndroidBy(id = "uk.co.bbc.hindi:id/headline_author_name"))
    val headlineAuthorName: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "uk.co.bbc.hindi.internal:id/headline_author_title"), AndroidBy(id = "uk.co.bbc.hindi:id/headline_author_title"))
    val headlineAuthorTitle: MobileElement? = null

    @AndroidFindAll(AndroidBy(xpath = "//android.widget.Button[@index='1']"), AndroidBy(xpath = "//android.widget.Button[@text='ओके']"))
    val bbcHindiOkButton: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "uk.co.bbc.hindi.internal:id/image_item_badge"), AndroidBy(id = "uk.co.bbc.hindi:id/image_item_badge"))
    val imageItemBadge: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "uk.co.bbc.hindi.internal:id/media_item_caption"), AndroidBy(id = "uk.co.bbc.hindi:id/media_item_caption"))
    val mediaItemCaption: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "uk.co.bbc.hindi.internal:id/smp_seek_bar"), AndroidBy(id = "uk.co.bbc.hindi:id/smp_seek_bar"))
    val seekBar: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "uk.co.bbc.hindi.internal:id/smp_pause_button"), AndroidBy(id = "uk.co.bbc.hindi:id/smp_pause_button"))
    val pauseButton: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "uk.co.bbc.hindi.internal:id/title"), AndroidBy(id = "uk.co.bbc.hindi:id/title"))
    val picturesTitle: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "uk.co.bbc.hindi.internal:id/subtitle"), AndroidBy(id = "uk.co.bbc.hindi:id/subtitle"))
    val picturesSubtitle: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@index='2']")
    val radioPageText: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@index='3']")
    val radioPageTextDaily: MobileElement? = null

    @AndroidFindBy(id = "android:id/message")
    val bbcHindiMessage: MobileElement? = null

    @AndroidFindBy(accessibility = "बैक")
    val backButton: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='हेमिल्टन जीता तो इतिहास रच देगी टीम इंडिया']")
    val sportsArticle: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='2']")
    val article: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='संबंधित टॉपिक']")
    val relatedTopics: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='संबंधित स्टोरीज़']")
    val relatedArticles: MobileElement? = null

    @AndroidFindBy(accessibility = "Play")
    val playButton: MobileElement? = null

    @AndroidFindBy(accessibility = "volume")
    val volumeButton: MobileElement? = null

    @AndroidFindBy(accessibility = "Fullscreen")
    val fullScreenButton: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Front page']")
    val frontPage: MobileElement? = null
}
