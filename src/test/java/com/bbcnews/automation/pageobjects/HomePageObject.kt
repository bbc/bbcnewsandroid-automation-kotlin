package com.bbcnews.automation.pageobjects

import io.appium.java_client.MobileElement
import io.appium.java_client.pagefactory.AndroidBy
import io.appium.java_client.pagefactory.AndroidFindAll
import io.appium.java_client.pagefactory.AndroidFindBy

object HomePageObject {

    @AndroidFindBy(xpath = "//android.widget.Button[@text='OK']")
    lateinit var okButton: MobileElement

    @AndroidFindBy(xpath = "//android.widget.Button[@text='GO TO SETTINGS']")
    lateinit var settingsButton: MobileElement

    @AndroidFindBy(accessibility = "Back")
    lateinit var backButton: MobileElement

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

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/action_search"), AndroidBy(id = "bbc.mobile.news.uk:id/action_search"), AndroidBy(accessibility = "Search"))
    lateinit var search: MobileElement

    @AndroidFindBy(accessibility = "Show navigation menu drawer")
    lateinit var menuButton: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Technology']")
    lateinit var technologyTopic: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Education']")
    lateinit var educationTopics: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Family & Education']")
    lateinit var familyEducationTopic: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Politics']")
    lateinit var topStoriesPolitics: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='UK Politics']")
    lateinit var ukPoliticsTopHeading: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Business']")
    lateinit var businessTopics: MobileElement

    @AndroidFindBy(accessibility = "Button:Videos of the day")
    lateinit var videoOfTheDayButton: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='WATCH']")
    lateinit var videoOfTheDayWatch: MobileElement

    @AndroidFindBy(accessibility = "Button: Stories")
    lateinit var storiesButton: MobileElement

    // @AndroidFindBy(id = "bbc.mobile.news.uk.internal:id/newstream_promo_counter")
    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/newstream_promo_counter"), AndroidBy(id = "bbc.mobile.news.uk:id/newstream_promo_counter"))
    lateinit var promoCounter: MobileElement

    // @AndroidFindBy(id="bbc.mobile.news.uk.internal:id/newstream_promo_watch_label")
    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/newstream_promo_watch_label"), AndroidBy(id = "bbc.mobile.news.uk:id/newstream_promo_watch_label"))
    lateinit var watchVideo: MobileElement

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk:id/newstream_promo_title"), AndroidBy(id = "bbc.mobile.news.uk.internal:id/newstream_promo_title"))
    lateinit var videoOfTheDayTitle: MobileElement

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/newstream_promo_summary"), AndroidBy(id = "bbc.mobile.news.uk:id/newstream_promo_summary"))
    lateinit var videoOfTheDayPromoSummary: MobileElement

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/newstream_promo_watch_label"), AndroidBy(id = "bbc.mobile.news.uk:id/newstream_promo_watch_label"))
    lateinit var videoOfTheDayWatchNext: MobileElement

    @AndroidFindBy(accessibility = "Exit")
    lateinit var closeWindow: MobileElement

    @AndroidFindBy(accessibility = "Share")
    lateinit var shareButton: MobileElement

    @AndroidFindBy(accessibility = "play video content")
    lateinit var playVideoContent: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@index='0']")
    lateinit var storiesContainer: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Check back later']")
    lateinit var checkBackLater: MobileElement

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/newsStreamProgress"), AndroidBy(id = "bbc.mobile.news.uk:id/newsStreamProgress"))
    lateinit var newsStreamProgress: MobileElement

    @AndroidFindAll(AndroidBy(xpath = "//android.widget.FrameLayout[1]/bbc.mobile.news.uk.internal:id/main_view[0]/android.widget.ImageView[@index='0']"), AndroidBy(xpath = "//android.widget.FrameLayout[1]/bbc.mobile.news.uk:id/main_view[0]/android.widget.ImageView[@index='0']"))
    lateinit var topStoriesArticle: MobileElement

}
