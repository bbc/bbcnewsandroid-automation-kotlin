package com.bbcnews.automation.scripts.journeys

import com.bbcnews.automation.scripts.BbcTestCase
import org.junit.Test

class MyNewsJourney: BbcTestCase(
        "bbc.mobile.news.v3.app.TopLevelActivity",
        "User Journey") {


    @Test
    fun `user can add items to My News`() {

    }
    // Scenario 2: user can add items to MyNews
    // (Can we launch appium in states???)

    // Tap on an index header (e.g. London)
    // Tap (+) to add to MyNews
    // Tap pencil (now appeared) to edit MyNews
    // Swipe to Add Topics
    // Scroll and add 4 topics
    // Add a topic from Search
    // Swipe back to MyTopics and assert they've been added
    // Press back twice to go back to Top Stories
    // Swipe or tap to MyNews
    // Swipe carousel
    // Tap a topic
    // Swipe through the indexes

}