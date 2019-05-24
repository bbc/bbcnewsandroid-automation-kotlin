package com.bbcnews.automation.pageobjects

import io.appium.java_client.MobileElement
import io.appium.java_client.pagefactory.AndroidBy
import io.appium.java_client.pagefactory.AndroidFindAll
import io.appium.java_client.pagefactory.AndroidFindBy

object HomePageObject {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Video']")
    lateinit var video: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Technology']")
    lateinit var technologyTopic: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Education']")
    lateinit var educationTopics: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Family & Education']")
    lateinit var familyEducationTopic: MobileElement

    @AndroidFindBy(accessibility = "Button:Videos of the day")
    lateinit var videoOfTheDayButton: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='WATCH']")
    lateinit var videoOfTheDayWatch: MobileElement

    @AndroidFindAll(
            AndroidBy(id = "bbc.mobile.news.uk.internal:id/newstream_promo_counter"),
            AndroidBy(id = "bbc.mobile.news.uk:id/newstream_promo_counter")
    )
    lateinit var promoCounter: MobileElement

    @AndroidFindAll(
            AndroidBy(id = "bbc.mobile.news.uk:id/newstream_promo_title"),
            AndroidBy(id = "bbc.mobile.news.uk.internal:id/newstream_promo_title")
    )
    lateinit var videoOfTheDayTitle: MobileElement

    @AndroidFindAll(
            AndroidBy(id = "bbc.mobile.news.uk.internal:id/newstream_promo_summary"),
            AndroidBy(id = "bbc.mobile.news.uk:id/newstream_promo_summary")
    )
    lateinit var videoOfTheDayPromoSummary: MobileElement

    @AndroidFindAll(
            AndroidBy(id = "bbc.mobile.news.uk.internal:id/newstream_promo_watch_label"),
            AndroidBy(id = "bbc.mobile.news.uk:id/newstream_promo_watch_label")
    )
    lateinit var videoOfTheDayWatchNext: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Check back later']")
    lateinit var checkBackLater: MobileElement

    @AndroidFindAll(
            AndroidBy(id = "bbc.mobile.news.uk.internal:id/newsStreamProgress"),
            AndroidBy(id = "bbc.mobile.news.uk:id/newsStreamProgress")
    )
    lateinit var newsStreamProgress: MobileElement

    @AndroidFindAll(
            AndroidBy(id = "bbc.mobile.news.uk.internal:id/content_card_link"),
            AndroidBy(className = "android.widget.TextView"),
            AndroidBy(xpath = "//android.widget.TextView[2]")
    )
    lateinit var firstContentCardLink: MobileElement

}
