package com.bbcnews.automation.pageobjects

import io.appium.java_client.MobileElement
import io.appium.java_client.pagefactory.AndroidBy
import io.appium.java_client.pagefactory.AndroidFindAll
import io.appium.java_client.pagefactory.AndroidFindBy

object HomePageObject {

    @AndroidFindBy(xpath = "//android.widget.Button[@text='OK']")
    val okButton: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.Button[@text='GO TO SETTINGS']")
    val settingsButton: MobileElement? = null

    @AndroidFindBy(accessibility = "Back")
    val backButton: MobileElement? = null

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

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/action_search"), AndroidBy(id = "bbc.mobile.news.uk:id/action_search"), AndroidBy(accessibility = "Search"))
    val search: MobileElement? = null

    @AndroidFindBy(accessibility = "Show navigation menu drawer")
    val menuButton: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Technology']")
    val technologyTopic: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Education']")
    val educationTopics: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Family & Education']")
    val familyEducationTopic: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Politics']")
    val topStoriesPolitics: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='UK Politics']")
    val ukPoliticsTopHeading: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Business']")
    val businessTopics: MobileElement? = null

    @AndroidFindBy(accessibility = "Button:Videos of the day")
    val videoOfTheDayButton: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='WATCH']")
    val videoOfTheDayWatch: MobileElement? = null

    @AndroidFindBy(accessibility = "Button: Stories")
    val storiesButton: MobileElement? = null

    // @AndroidFindBy(id = "bbc.mobile.news.uk.internal:id/newstream_promo_counter")
    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/newstream_promo_counter"), AndroidBy(id = "bbc.mobile.news.uk:id/newstream_promo_counter"))
    val promoCounter: MobileElement? = null

    // @AndroidFindBy(id="bbc.mobile.news.uk.internal:id/newstream_promo_watch_label")
    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/newstream_promo_watch_label"), AndroidBy(id = "bbc.mobile.news.uk:id/newstream_promo_watch_label"))
    val watchVideo: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk:id/newstream_promo_title"), AndroidBy(id = "bbc.mobile.news.uk.internal:id/newstream_promo_title"))
    val videoOfTheDayTitle: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/newstream_promo_summary"), AndroidBy(id = "bbc.mobile.news.uk:id/newstream_promo_summary"))
    val videoOfTheDayPromoSummary: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/newstream_promo_watch_label"), AndroidBy(id = "bbc.mobile.news.uk:id/newstream_promo_watch_label"))
    val videoOfTheDayWatchNext: MobileElement? = null

    @AndroidFindBy(accessibility = "Exit")
    val closeWindow: MobileElement? = null

    @AndroidFindBy(accessibility = "Share")
    val shareButton: MobileElement? = null

    @AndroidFindBy(accessibility = "play video content")
    val playVideoContent: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@index='0']")
    val storiesContainer: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Check back later']")
    val checkBackLater: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/newsStreamProgress"), AndroidBy(id = "bbc.mobile.news.uk:id/newsStreamProgress"))
    val newsStreamProgress: MobileElement? = null

    @AndroidFindAll(AndroidBy(xpath = "//android.widget.FrameLayout[1]/bbc.mobile.news.uk.internal:id/main_view[0]/android.widget.ImageView[@index='0']"), AndroidBy(xpath = "//android.widget.FrameLayout[1]/bbc.mobile.news.uk:id/main_view[0]/android.widget.ImageView[@index='0']"))
    val topStoriesArticle: MobileElement? = null

}
