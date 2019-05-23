package com.bbcnews.automation.scripts

import com.bbcnews.automation.commonfunctions.AppiumViewActions.compareTwoImages
import com.bbcnews.automation.commonfunctions.AppiumViewActions.navigateBack
import com.bbcnews.automation.commonfunctions.AppiumViewActions.screenshot
import com.bbcnews.automation.commonfunctions.AppiumViewActions.selectView
import com.bbcnews.automation.commonfunctions.AppiumViewActions.startTest
import com.bbcnews.automation.commonfunctions.AppiumViewActions.textPresent
import com.bbcnews.automation.commonfunctions.ScreenActions.scrollDownToElement
import com.bbcnews.automation.commonfunctions.ScreenAssertions.assertDisplayingElements
import com.bbcnews.automation.pageobjects.BasePageObject
import com.bbcnews.automation.pageobjects.BasePageObject.contentInfo
import com.bbcnews.automation.pageobjects.BasePageObject.itemTitle
import com.bbcnews.automation.pageobjects.BasePageObject.menuButton
import com.bbcnews.automation.pageobjects.BasePageObject.myNews
import com.bbcnews.automation.pageobjects.BasePageObject.popular
import com.bbcnews.automation.pageobjects.BasePageObject.search
import com.bbcnews.automation.pageobjects.BasePageObject.topStories
import com.bbcnews.automation.pageobjects.BasePageObject.video
import com.bbcnews.automation.pageobjects.MyNewsPageObject
import com.bbcnews.automation.pageobjects.MyNewsPageObject.addNewsButton
import com.bbcnews.automation.pageobjects.MyNewsPageObject.addTopics
import com.bbcnews.automation.pageobjects.MyNewsPageObject.localNewsDisplayed
import com.bbcnews.automation.pageobjects.MyNewsPageObject.myNewsStartButton
import com.bbcnews.automation.pageobjects.MyNewsPageObject.myNewsSummary
import com.bbcnews.automation.pageobjects.MyNewsPageObject.myNewsSummaryText
import com.bbcnews.automation.pageobjects.MyNewsPageObject.myNewsTitle
import com.bbcnews.automation.pageobjects.MyNewsPageObject.myNewsTitleText
import com.bbcnews.automation.pageobjects.MyTopicsPageObject
import com.bbcnews.automation.pageobjects.PopularPageObjects.mostRead
import com.bbcnews.automation.testutils.TestSetup.androidDriver
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
    }


    @Test(priority = 2, description = "User journey including adding items to my news")
    @Story("Journey_1")
    @Severity(SeverityLevel.CRITICAL)
    fun journey_UserAddingItemsToMyNews() {
        startTest("Journey: MyNews", "Browsing user", "Smoke")


//     Tap on an index header (e.g. London)
//     Tap (+) to add to MyNews
//     Tap pencil (now appeared) to edit MyNews
//     Swipe to Add Topics
//     Scroll and add 4 topics
//     Add a topic from Search
//     Swipe back to MyTopics and assert they've been added
//     Press back twice to go back to Top Stories
//     Swipe or tap to MyNews
//     Swipe carousel
//     Tap a topic
//     Swipe through the indexes
    }


//    @Test(priority = 2, description = "takes the screenshot of the topStories, myNews, popular,video and menu page")
//    @Throws(IOException::class)
//    fun smokeTestTakeScreenshotsOfPages() {
//        selectView(androidDriver, topStories)
//        screenshot(androidDriver, "Before", "topStories")
//        selectView(androidDriver, myNews)
//        screenshot(androidDriver, "Before", "myNews")
//        selectView(androidDriver, popular)
//        screenshot(androidDriver, "Before", "popular")
//        selectView(androidDriver, video)
//        screenshot(androidDriver, "Before", "video")
//        selectView(androidDriver, menuButton)
//        screenshot(androidDriver, "Before", "menu")
//        navigateBack(androidDriver)
//    }

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
    }

    @Test(priority = 3, description = "Test to check the MyNews page")
    @Story("MyNews")
    @Severity(SeverityLevel.CRITICAL)
    fun smokeTestAllowLocation() {
        startTest("MyNews", "Checking MyNews", "Smoke")
        selectView(androidDriver, myNews)
        selectView(androidDriver, myNewsStartButton)
        selectView(androidDriver, MyNewsPageObject.allowLocation)
        selectView(androidDriver, MyNewsPageObject.allowLocationPermission)
        navigateBack(androidDriver)
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
    }

    @Test(priority = 6, description = "Test to check the MyNews page")
    @Story("MyNews")
    @Severity(SeverityLevel.CRITICAL)
    fun smokeTestMyNewsPage() {
        startTest("MyNews", "Checking the MyNews", "Smoke")
        selectView(androidDriver, myNews)

        assertTrue(myNews.isSelected)

        assertDisplayingElements(myNewsSummary,
                myNewsTitle,
                addNewsButton
        )

        assertEquals(myNewsTitleText, myNewsTitle.text, "Text matched")
        assertEquals(myNewsSummaryText, myNewsSummary.text, "Text matched")
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
    }

    /**
     * Checked the selected topics are getting displayed under Added Topics
     * Todo This test won't pass if the topics don't get added!!!
     */
    @Test(priority = 8, description = "Test to check whether selected topics displayed under MyTopics page")
    @Ignore // This test won't pass if the topics don't get added!!!
    @Story("MyTopics")
    fun smokeTestCheckAddedTopicsUnderMyTopics() {
        startTest("MyTopics", "Checking Added topics in MyTopics", "Smoke")
        selectView(androidDriver, MyNewsPageObject.myTopics)
        assertDisplayingElements(MyTopicsPageObject.walesTopic,
                MyTopicsPageObject.worldTopic
        )
        navigateBack(androidDriver)
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

        navigateBack(androidDriver)
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

        navigateBack(androidDriver)
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
    }

}
