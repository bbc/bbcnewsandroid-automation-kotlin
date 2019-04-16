package com.bbcnews.automation.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class BBCNewsHindiPageObject {

    public BBCNewsHindiPageObject() {
    }

    @AndroidFindBy(id = "android:id/button2")
    public MobileElement noThanksButton;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='0']/android.widget.RelativeLayout[@index='0']/android.widget.LinearLayout[@index='1']/android.widget.TextView[@index='0']")
    public MobileElement mainItemLayoutName;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='0']/android.widget.RelativeLayout[@index='0']/android.widget.LinearLayout[@index='1']/android.widget.LinearLayout[@index='1']/android.widget.LinearLayout[@index='0']/android.widget.TextView[@index='0']")
    public MobileElement mainItemLayoutLastUpdated;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='1']/android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='1']")
    public MobileElement articleItemLayoutName;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='1']/android.widget.RelativeLayout[@index='0']/android.widget.LinearLayout[@index='2']/android.widget.LinearLayout[@index='0']/android.widget.TextView[@index='0']")
    public MobileElement articleItemLayoutLastUpdated;

    //BBC News Hindi Common Page Objects
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='होम पेज']")
    public MobileElement bbcHindiHomepage;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='भारत']")
    public MobileElement bbcHindiIndia;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='अंतरराष्ट्रीय']")
    public MobileElement bbcHindiInternational;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='मनोरंजन']")
    public MobileElement bbcHindiEntertainment;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='खेल']")
    public MobileElement bbcHindiSports;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='रेडियो']")
    public MobileElement bbcHindiRadio;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='विज्ञान-टेक्नॉलॉजी']")
    public MobileElement bbcHindiScienceTechnology;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='देखिए']")
    public MobileElement bbcHindiLookAt;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='तस्वीरें']")
    public MobileElement bbcHindiThePhotos;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='सोशल']")
    public MobileElement bbcHindiSocial;

    @AndroidFindBy(accessibility = "More options")
    public MobileElement bbcMoreOptions;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='सेटिंग्स']")
    public MobileElement bbcHindiSettings;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='मदद']")
    public MobileElement bbcHindiHelp;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='संपर्क करें']")
    public MobileElement bbcHindiPleaseContact;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='बीबीसी के दूसरे ऐप्स']")
    public MobileElement bbcHindiOtherBbcApplications;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Internal Settings']")
    public MobileElement bbcHindiInternalSettings;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@index='0']/android.view.ViewGroup[@index='0']/android.widget.ImageButton[@index='0']")
    public MobileElement bbcHindiMoreSettings;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='स्थानीय समाचार']")
    public MobileElement bbcHindiLocalNews;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='टॉपिक्स']")
    public MobileElement bbcHindiTopics;

    @AndroidFindBy(accessibility = "Button: टॉपिक्स , collapse group")
    public MobileElement bbcHindiTopicsCollapseGroup;

    @AndroidFindBy(accessibility = "Button: स्थानीय समाचार , collapse group")
    public MobileElement bbcHindiLocalNewsCollapseGroup;

    @AndroidFindBy(accessibility = "Button: होम पेज ")
    public MobileElement hindiHomepage;

    @AndroidFindBy(accessibility = "Button: भारत ")
    public MobileElement hindiBharath;

    @AndroidFindBy(accessibility = "Button: अंतरराष्ट्रीय ")
    public MobileElement hindiInternational;

    @AndroidFindBy(accessibility = "Button: मनोरंजन ")
    public MobileElement hindiEntertainment;

    @AndroidFindBy(accessibility = "Button: खेल ")
    public MobileElement hindiSports;

    @AndroidFindBy(accessibility = "Button: विज्ञान-टेक्नॉलॉजी ")
    public MobileElement hindiScience;

    @AndroidFindBy(accessibility = "Button: सोशल ")
    public MobileElement hindiSocial;

    @AndroidFindBy(accessibility = "Button: देखिए ")
    public MobileElement hindiLookAt;

    @AndroidFindBy(accessibility = "Button: तस्वीरें ")
    public MobileElement hindiPhotos;

    @AndroidFindAll({
            @AndroidBy(id = "uk.co.bbc.hindi.internal:id/image_item_caption"),
            @AndroidBy(id = "uk.co.bbc.hindi:id/image_item_caption")
    })
    public MobileElement imageItemCaption;

    @AndroidFindAll({
            @AndroidBy(id = "uk.co.bbc.hindi.internal:id/headline_title"),
            @AndroidBy(id = "uk.co.bbc.hindi:id/headline_title")
    })
    public MobileElement headlineTitle;

    @AndroidFindAll({
            @AndroidBy(id = "uk.co.bbc.hindi.internal:id/headline_info"),
            @AndroidBy(id = "uk.co.bbc.hindi:id/headline_info")
    })
    public MobileElement headlineInfo;

    @AndroidFindAll({
            @AndroidBy(id = "uk.co.bbc.hindi.internal:id/headline_author_name"),
            @AndroidBy(id = "uk.co.bbc.hindi:id/headline_author_name")
    })
    public MobileElement headlineAuthorName;

    @AndroidFindAll({
            @AndroidBy(id = "uk.co.bbc.hindi.internal:id/headline_author_title"),
            @AndroidBy(id = "uk.co.bbc.hindi:id/headline_author_title")
    })
    public MobileElement headlineAuthorTitle;

    @AndroidFindAll({
            @AndroidBy(xpath = "//android.widget.Button[@index='1']"),
            @AndroidBy(xpath = "//android.widget.Button[@text='ओके']")
    })
    public MobileElement bbcHindiOkButton;

    @AndroidFindAll({
            @AndroidBy(id = "uk.co.bbc.hindi.internal:id/image_item_badge"),
            @AndroidBy(id = "uk.co.bbc.hindi:id/image_item_badge")
    })
    public MobileElement imageItemBadge;

    @AndroidFindAll({
            @AndroidBy(id = "uk.co.bbc.hindi.internal:id/media_item_caption"),
            @AndroidBy(id = "uk.co.bbc.hindi:id/media_item_caption")
    })
    public MobileElement mediaItemCaption;

    @AndroidFindAll({
            @AndroidBy(id = "uk.co.bbc.hindi.internal:id/smp_seek_bar"),
            @AndroidBy(id = "uk.co.bbc.hindi:id/smp_seek_bar")
    })
    public MobileElement seekBar;

    @AndroidFindAll({
            @AndroidBy(id = "uk.co.bbc.hindi.internal:id/smp_pause_button"),
            @AndroidBy(id = "uk.co.bbc.hindi:id/smp_pause_button")
    })
    public MobileElement pauseButton;

    @AndroidFindAll({
            @AndroidBy(id = "uk.co.bbc.hindi.internal:id/title"),
            @AndroidBy(id = "uk.co.bbc.hindi:id/title")
    })
    public MobileElement picturesTitle;

    @AndroidFindAll({
            @AndroidBy(id = "uk.co.bbc.hindi.internal:id/subtitle"),
            @AndroidBy(id = "uk.co.bbc.hindi:id/subtitle")
    })
    public MobileElement picturesSubtitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@index='2']")
    public MobileElement radioPageText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@index='3']")
    public MobileElement radioPageTextDaily;

    @AndroidFindBy(id = "android:id/message")
    public MobileElement bbcHindiMessage;

    @AndroidFindBy(accessibility = "बैक")
    public MobileElement backButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='हेमिल्टन जीता तो इतिहास रच देगी टीम इंडिया']")
    public MobileElement sportsArticle;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='2']")
    public MobileElement article;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='संबंधित टॉपिक']")
    public MobileElement relatedTopics;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='संबंधित स्टोरीज़']")
    public MobileElement relatedArticles;

    @AndroidFindBy(accessibility = "Play")
    public MobileElement playButton;

    @AndroidFindBy(accessibility = "volume")
    public MobileElement volumeButton;

    @AndroidFindBy(accessibility = "Fullscreen")
    public MobileElement fullScreenButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Front page']")
    public MobileElement frontPage;
}
