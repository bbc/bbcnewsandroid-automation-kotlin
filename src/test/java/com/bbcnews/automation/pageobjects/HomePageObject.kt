package com.bbcnews.automation.pageobjects

import io.appium.java_client.MobileElement
import io.appium.java_client.pagefactory.AndroidBy
import io.appium.java_client.pagefactory.AndroidFindAll
import io.appium.java_client.pagefactory.AndroidFindBy

object HomePageObject {

    @AndroidFindBy(xpath = "//android.widget.Button[@text='OK']")
    var okButton: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.Button[@text='GO TO SETTINGS']")
    var settingsButton: MobileElement? = null

    @AndroidFindBy(accessibility = "Back")
    var backButton: MobileElement? = null

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

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/action_search"), AndroidBy(id = "bbc.mobile.news.uk:id/action_search"), AndroidBy(accessibility = "Search"))
    var search: MobileElement? = null

    @AndroidFindBy(accessibility = "Show navigation menu drawer")
    var menuButton: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Technology']")
    var technologyTopic: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Education']")
    var educationTopics: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Family & Education']")
    var familyEducationTopic: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Politics']")
    var topStoriesPolitics: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='UK Politics']")
    var ukPoliticsTopHeading: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Business']")
    var businessTopics: MobileElement? = null

    @AndroidFindBy(accessibility = "Button:Videos of the day")
    var videoOfTheDayButton: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='WATCH']")
    var videoOfTheDayWatch: MobileElement? = null

    @AndroidFindBy(accessibility = "Button: Stories")
    var storiesButton: MobileElement? = null

    // @AndroidFindBy(id = "bbc.mobile.news.uk.internal:id/newstream_promo_counter")
    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/newstream_promo_counter"), AndroidBy(id = "bbc.mobile.news.uk:id/newstream_promo_counter"))
    var promoCounter: MobileElement? = null

    // @AndroidFindBy(id="bbc.mobile.news.uk.internal:id/newstream_promo_watch_label")
    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/newstream_promo_watch_label"), AndroidBy(id = "bbc.mobile.news.uk:id/newstream_promo_watch_label"))
    var watchVideo: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk:id/newstream_promo_title"), AndroidBy(id = "bbc.mobile.news.uk.internal:id/newstream_promo_title"))
    var videoOfTheDayTitle: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/newstream_promo_summary"), AndroidBy(id = "bbc.mobile.news.uk:id/newstream_promo_summary"))
    var videoOfTheDayPromoSummary: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/newstream_promo_watch_label"), AndroidBy(id = "bbc.mobile.news.uk:id/newstream_promo_watch_label"))
    var videoOfTheDayWatchNext: MobileElement? = null

    @AndroidFindBy(accessibility = "Exit")
    var closeWindow: MobileElement? = null

    @AndroidFindBy(accessibility = "Share")
    var shareButton: MobileElement? = null

    @AndroidFindBy(accessibility = "play video content")
    var playVideoContent: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@index='0']")
    var storiesContainer: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Check back later']")
    var checkBackLater: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/newsStreamProgress"), AndroidBy(id = "bbc.mobile.news.uk:id/newsStreamProgress"))
    var newsStreamProgress: MobileElement? = null

    @AndroidFindAll(AndroidBy(xpath = "//android.widget.FrameLayout[1]/bbc.mobile.news.uk.internal:id/main_view[0]/android.widget.ImageView[@index='0']"), AndroidBy(xpath = "//android.widget.FrameLayout[1]/bbc.mobile.news.uk:id/main_view[0]/android.widget.ImageView[@index='0']"))
    var topStoriesArticle: MobileElement? = null

}
