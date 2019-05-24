package com.bbcnews.automation.pageobjects

import io.appium.java_client.MobileElement
import io.appium.java_client.pagefactory.AndroidFindBy

object IndexPageObjects {

    @AndroidFindBy(id = "bbc.mobile.news.uk.internal:id/activity_news_index_title")
    lateinit var indexTitle: MobileElement

    @AndroidFindBy(id = "bbc.mobile.news.uk.internal:id/menu_follow")
    lateinit var followTopicButton: MobileElement

    @AndroidFindBy(id = "bbc.mobile.news.uk.internal:id/menu_edit_followed")
    lateinit var topicFollowedPencilButton: MobileElement


}