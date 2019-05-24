package com.bbcnews.automation.scripts

import com.bbcnews.automation.commonfunctions.AppiumViewActions.compareTwoImages
import com.bbcnews.automation.commonfunctions.AppiumViewActions.navigateBack
import com.bbcnews.automation.commonfunctions.AppiumViewActions.screenshot
import com.bbcnews.automation.commonfunctions.AppiumViewActions.selectView
import com.bbcnews.automation.commonfunctions.AppiumViewActions.startTest
import com.bbcnews.automation.commonfunctions.AppiumViewActions.swipeElement
import com.bbcnews.automation.commonfunctions.AppiumViewActions.textPresent
import com.bbcnews.automation.commonfunctions.ScreenActions.generalSwipeLeft
import com.bbcnews.automation.commonfunctions.ScreenActions.goBackToHomeScreen
import com.bbcnews.automation.commonfunctions.ScreenActions.scrollDownToElement
import com.bbcnews.automation.commonfunctions.ScreenAssertions.assertDisplayingElements
import com.bbcnews.automation.commonfunctions.ScreenAssertions.assertIndexTitleMatches
import com.bbcnews.automation.pageobjects.BasePageObject
import com.bbcnews.automation.pageobjects.BasePageObject.contentInfo
import com.bbcnews.automation.pageobjects.BasePageObject.itemTitle
import com.bbcnews.automation.pageobjects.BasePageObject.menuButton
import com.bbcnews.automation.pageobjects.BasePageObject.myNews
import com.bbcnews.automation.pageobjects.BasePageObject.popular
import com.bbcnews.automation.pageobjects.BasePageObject.search
import com.bbcnews.automation.pageobjects.BasePageObject.topStories
import com.bbcnews.automation.pageobjects.BasePageObject.video
import com.bbcnews.automation.pageobjects.HomePageObject.firstContentCardLink
import com.bbcnews.automation.pageobjects.IndexPageObjects.followTopicButton
import com.bbcnews.automation.pageobjects.IndexPageObjects.topicFollowedPencilButton
import com.bbcnews.automation.pageobjects.MyNewsPageObject
import com.bbcnews.automation.pageobjects.MyNewsPageObject.addTopics
import com.bbcnews.automation.pageobjects.MyNewsPageObject.localNewsDisplayed
import com.bbcnews.automation.pageobjects.MyNewsPageObject.myNewsStartButton
import com.bbcnews.automation.pageobjects.MyNewsPageObject.myTopics
import com.bbcnews.automation.pageobjects.MyTopicsPageObject
import com.bbcnews.automation.pageobjects.PopularPageObjects.mostRead
import com.bbcnews.automation.testutils.TestSetup.androidDriver
import io.appium.java_client.MobileElement
import io.qameta.allure.Severity
import io.qameta.allure.SeverityLevel
import io.qameta.allure.Story
import org.testng.Assert.assertEquals
import org.testng.Assert.assertTrue
import org.testng.annotations.BeforeTest
import org.testng.annotations.Ignore
import org.testng.annotations.Test
import java.io.IOException
import java.time.Duration

class BBCNewsSmokeTest : BbcTestCase("SmokeTest") {

    @BeforeTest
    fun beforeEachTest() {
        setUp()
        goBackToHomeScreen()
    }

    @Test(priority = 2, description = "User journey including adding items to my news")
    @Story("Journey_1")
    @Severity(SeverityLevel.CRITICAL)
    fun journey_UserAddingItemsToMyNews() {
        startTest("Journey: MyNews", "Browsing user", "Smoke")

//     Tap on an index header (e.g. London)
        val topic = firstContentCardLink.text
        selectView(androidDriver, firstContentCardLink)
        assertIndexTitleMatches(topic)

//     Tap (+) to add to MyNews
        selectView(androidDriver, followTopicButton)
//     Tap pencil (now appeared) to edit MyNews
        selectView(androidDriver, topicFollowedPencilButton)

//     Swipe to Add Topics
        generalSwipeLeft(androidDriver)
        assertTrue(addTopics.isSelected)

//     Scroll down and add four topics
        scrollToAndAddTopics(
                MyNewsPageObject.businessTopic,
                MyNewsPageObject.technologyTopic,
                MyNewsPageObject.entertainmentTopic,
                MyNewsPageObject.educationTopic
        )

//     Add a topic from Search
//        selectView(androidDriver, searchForTopics)
//        enterSearchText(addTopicsSearchField, "UK Royal Family")

//     Swipe back to MyTopics and assert they've been added
        selectView(androidDriver, myTopics)

        assertDisplayingElements(
                MyNewsPageObject.toReorderTopicsPrompt,
                MyNewsPageObject.businessTopic,
                MyNewsPageObject.technologyTopic,
                MyNewsPageObject.entertainmentTopic,
                MyNewsPageObject.educationTopic
        )

//     Press back twice to go back to Top Stories
        goBackToHomeScreen()

//     Swipe or tap to MyNews
        selectView(androidDriver, myNews)

//     Swipe carousel
        swipeElement(androidDriver, MyNewsPageObject.topicsCarousel, "Left")

//     Tap a topic

//     Swipe through the indexes


        goBackToHomeScreen() // temp to stop other tests from failing

    }

    private fun scrollToAndAddTopics(vararg topics: MobileElement) {
        for (topic in topics) {
            scrollDownToElement(androidDriver, topic)
            topic.click()
        }
    }


    @Ignore
    @Test(priority = 2, description = "takes the screenshot of the topStories, myNews, popular,video and menu page")
    @Throws(IOException::class)
    fun smokeTestTakeScreenshotsOfPages() {
        selectView(androidDriver, topStories)
        screenshot(androidDriver, "Before", "topStories")
        selectView(androidDriver, myNews)
        screenshot(androidDriver, "Before", "myNews")
        selectView(androidDriver, popular)
        screenshot(androidDriver, "Before", "popular")
        selectView(androidDriver, video)
        screenshot(androidDriver, "Before", "video")
        selectView(androidDriver, menuButton)
        screenshot(androidDriver, "Before", "menu")
        goBackToHomeScreen() // temp to stop other tests from failing
    }

    @Test(priority = 2, description = "Check the links on the Home page after app launched")
    @Story("Home")
    @Severity(SeverityLevel.CRITICAL)
    fun smokeTestCheckHomePage() {
        androidDriver.runAppInBackground(Duration.ofSeconds(5))
        startTest("HomePage", "Checking the HomePage", "Smoke")
        selectView(androidDriver, topStories)
        assertTrue(topStories.isSelected)
        assertDisplayingElements(itemTitle,
                contentInfo,
                myNews,
                popular,
                video,
                menuButton,
                search
        )

        goBackToHomeScreen() // temp to stop other tests from failing
    }

    @Ignore
    @Test(priority = 3, description = "Test to check the MyNews page")
    @Story("MyNews")
    @Severity(SeverityLevel.CRITICAL)
    fun smokeTestAllowLocation() {
        startTest("MyNews", "Checking MyNews", "Smoke")
        selectView(androidDriver, myNews)
        selectView(androidDriver, myNewsStartButton)
        selectView(androidDriver, MyNewsPageObject.allowLocation)
        selectView(androidDriver, MyNewsPageObject.allowLocationPermission)
        goBackToHomeScreen() // temp to stop other tests from failing
    }

    @Test(priority = 4, description = "Test to check the popular page")
    @Story("Popular")
    @Severity(SeverityLevel.CRITICAL)
    fun smokeTestPopularPage() {
        startTest("PopularPage", "Checking the Popular", "Smoke")
        selectView(androidDriver, popular)
        assertTrue(popular.isSelected)
        assertDisplayingElements(mostRead)
        assertEquals("Most Read", mostRead.text, "Text Matched")
        goBackToHomeScreen() // temp to stop other tests from failing
    }

    /**
     * Adding the topics to MyNews
     * This test is super flaky because the topics aren't always returned??
     * Only happens on Appium.. I think it's something to do with the proxy
     */
    @Ignore
    @Test(priority = 7, description = "Test to check the adding the topics to MyNews page")
    fun smokeTestAddingTopicsToMyNewsPage() {
        startTest("MyNews", "Adding topics to MyNews", "Smoke")
        selectView(androidDriver, myNewsStartButton)
        selectView(androidDriver, addTopics)

        assertEquals("UK", localNewsDisplayed.text)
        assertDisplayingElements(localNewsDisplayed)

        scrollDownToElement(androidDriver, MyTopicsPageObject.addWalesTopicButton)
        selectView(androidDriver, MyTopicsPageObject.addWalesTopicButton)
        textPresent(androidDriver, "Wales", "added to")

        scrollDownToElement(androidDriver, MyTopicsPageObject.addWorldTopicButton)
        selectView(androidDriver, MyTopicsPageObject.addWorldTopicButton)
        goBackToHomeScreen() // temp to stop other tests from failing
    }

    /**
     * Checked the selected topics are getting displayed under Added Topics
     * Todo This test won't pass if the topics don't get added!!!
     */
    @Ignore // This test won't pass if the topics don't get added!!!
    @Test(priority = 8, description = "Test to check whether selected topics displayed under MyTopics page")
    fun smokeTestCheckAddedTopicsUnderMyTopics() {
        startTest("MyTopics", "Checking Added topics in MyTopics", "Smoke")
        selectView(androidDriver, MyNewsPageObject.myTopics)
        assertDisplayingElements(MyTopicsPageObject.walesTopic,
                MyTopicsPageObject.worldTopic
        )
        navigateBack(androidDriver)
        goBackToHomeScreen() // temp to stop other tests from failing
    }

    /**
     * Open the Menu items and assert whether links are displayed properly
     */
    @Test(priority = 12, description = "Test to Check the Menu Options ")
    @Story("Menu")
    @Severity(SeverityLevel.CRITICAL)
    @Throws(Exception::class, AssertionError::class)
    fun smokeTestMenuPage() {
        startTest("Menu", "Checking the Menu Items", "Smoke")
        selectView(androidDriver, menuButton)

        assertDisplayingElements(BasePageObject.appInfo,
                BasePageObject.otherBbcApps,
                BasePageObject.internalSettings,
                BasePageObject.settings
        )

        generalSwipeLeft(androidDriver)
        goBackToHomeScreen() // temp to stop other tests from failing
    }

    /**
     * un-ignore if you want to check the screenshot compare tests
     */
    @Ignore
    @Test(priority = 16, description = "takes the screenshot of the Top Stories, My News, Popular, Video, and Menu pages")
    @Throws(IOException::class)
    fun smokeTestTakeScreenshotAfter() {
        selectView(androidDriver, topStories)
        screenshot(androidDriver, "After", "topStories")

        selectView(androidDriver, myNews)
        screenshot(androidDriver, "After", "myNews")

        selectView(androidDriver, popular)
        screenshot(androidDriver, "After", "popular")

        selectView(androidDriver, video)
        screenshot(androidDriver, "After", "video")

        selectView(androidDriver, menuButton)
        screenshot(androidDriver, "After", "menu")

        goBackToHomeScreen() // temp to stop other tests from failing
    }

    /**
     * un-ignore if you want to check the screenshot compare tests
     */
    @Ignore
    @Test(priority = 17, description = "Compares the images")
    @Throws(IOException::class)
    fun smokeTestCompareImages() {
        startTest("CompareImages", "Compares the HomePage", "Smoke")
        compareTwoImages()
        goBackToHomeScreen() // temp to stop other tests from failing
    }

}
