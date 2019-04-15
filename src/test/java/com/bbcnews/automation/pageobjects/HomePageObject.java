package com.bbcnews.automation.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomePageObject {

    public HomePageObject() {

    }

    @AndroidFindBy(xpath = "//android.widget.Button[@text='OK']")
    public MobileElement okButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='GO TO SETTINGS']")
    public MobileElement settingsButton;

    @AndroidFindBy(accessibility = "Back")
    public MobileElement backButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='NO, THANKS.']")
    public MobileElement noThanksButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Top Stories']")
    public MobileElement topStories;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='My News']")
    public MobileElement myNews;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Popular']")
    public MobileElement popular;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Video']")
    public MobileElement video;

    @AndroidFindBy(accessibility = "Search")
    public MobileElement searchButton;

    @AndroidFindAll({
            @AndroidBy(id = "bbc.mobile.news.uk.internal:id/action_search"),
            @AndroidBy(id = "bbc.mobile.news.uk:id/action_search"),
            @AndroidBy(accessibility = "Search")
    })
    public MobileElement search;

    @AndroidFindBy(accessibility = "Show navigation menu drawer")
    public MobileElement menuButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Technology']")
    public MobileElement technologyTopic;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Education']")
    public MobileElement educationTopics;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Family & Education']")
    public MobileElement familyEducationTopic;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Politics']")
    public MobileElement topStoriesPolitics;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='UK Politics']")
    public MobileElement uKPoliticsTopHeading;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Business']")
    public MobileElement businessTopics;

    @AndroidFindBy(accessibility = "Button:Videos of the day")
    public MobileElement videoOfTheDayButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='WATCH']")
    public MobileElement videoOfTheDayWatch;

    @AndroidFindBy(accessibility = "Button: Stories")
    public MobileElement storiesButton;

    // @AndroidFindBy(id = "bbc.mobile.news.uk.internal:id/newstream_promo_counter")
    @AndroidFindAll({
            @AndroidBy(id = "bbc.mobile.news.uk.internal:id/newstream_promo_counter"),
            @AndroidBy(id = "bbc.mobile.news.uk:id/newstream_promo_counter")
    })

    public MobileElement promoCounter;


    // @AndroidFindBy(id="bbc.mobile.news.uk.internal:id/newstream_promo_watch_label")
    @AndroidFindAll({
            @AndroidBy(id = "bbc.mobile.news.uk.internal:id/newstream_promo_watch_label"),
            @AndroidBy(id = "bbc.mobile.news.uk:id/newstream_promo_watch_label")
    })

    public MobileElement watchVideo;

    @AndroidFindAll({
            @AndroidBy(id = "bbc.mobile.news.uk:id/newstream_promo_title"),
            @AndroidBy(id = "bbc.mobile.news.uk.internal:id/newstream_promo_title")
    })

    public MobileElement videoOfTheDayTitle;

    @AndroidFindAll({
            @AndroidBy(id = "bbc.mobile.news.uk.internal:id/newstream_promo_summary"),
            @AndroidBy(id = "bbc.mobile.news.uk:id/newstream_promo_summary")
    })

    public MobileElement videoOfTheDayPromoSummary;

    @AndroidFindAll({
            @AndroidBy(id = "bbc.mobile.news.uk.internal:id/newstream_promo_watch_label"),
            @AndroidBy(id = "bbc.mobile.news.uk:id/newstream_promo_watch_label")
    })

    public MobileElement videoOfTheDayWatchText;

    @AndroidFindBy(accessibility = "Exit")
    public MobileElement closeWindow;

    @AndroidFindBy(accessibility = "Share")
    public MobileElement shareButton;

    @AndroidFindBy(accessibility = "play video content")
    public MobileElement playVideoContent;

    @AndroidFindBy(xpath = "//android.widget.TextView[@index='0']")
    public MobileElement storiesContainer;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Check back later']")
    public MobileElement checkBackLater;

    @AndroidFindAll({
            @AndroidBy(id = "bbc.mobile.news.uk.internal:id/newsStreamProgress"),
            @AndroidBy(id = "bbc.mobile.news.uk:id/newsStreamProgress")
    })

    public MobileElement newsStreamProgress;

}
