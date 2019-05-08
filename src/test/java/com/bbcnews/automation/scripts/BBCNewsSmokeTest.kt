package com.bbcnews.automation.scripts

import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.compareTwoImages
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.enterText
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.getText
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.navigateBack
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.screenshot
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.scrollToElement
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.startTest
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.tapButton
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.textPresent
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.verticalSwipe
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.videoPlaybackSeeking
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.waitFor
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.waitForScreenToLoad
import com.bbcnews.automation.commonfunctions.ScreenAssertions.assertDisplayingElements
import com.bbcnews.automation.pageobjects.BasePageObject
import com.bbcnews.automation.pageobjects.BasePageObject.headlineTitle
import com.bbcnews.automation.pageobjects.BasePageObject.itemLayoutHomeSection
import com.bbcnews.automation.pageobjects.BasePageObject.itemLayoutLastUpdated
import com.bbcnews.automation.pageobjects.BasePageObject.itemLayoutName
import com.bbcnews.automation.pageobjects.BasePageObject.menuButton
import com.bbcnews.automation.pageobjects.BasePageObject.myNews
import com.bbcnews.automation.pageobjects.BasePageObject.popular
import com.bbcnews.automation.pageobjects.BasePageObject.search
import com.bbcnews.automation.pageobjects.BasePageObject.searchField
import com.bbcnews.automation.pageobjects.BasePageObject.shareStory
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
import com.bbcnews.automation.pageobjects.MyNewsPageObject.showLess
import com.bbcnews.automation.pageobjects.MyNewsPageObject.showMore
import com.bbcnews.automation.pageobjects.MyTopicsPageObject
import com.bbcnews.automation.pageobjects.PopularPageObjects.mostRead
import com.bbcnews.automation.pageobjects.PopularPageObjects.popularMostWatched
import com.bbcnews.automation.pageobjects.VideoPageObjects.accessibilityPause
import com.bbcnews.automation.pageobjects.VideoPageObjects.accessibilityPlay
import com.bbcnews.automation.pageobjects.VideoPageObjects.bbcNewsChannel
import com.bbcnews.automation.pageobjects.VideoPageObjects.liveMediaItemCaption
import com.bbcnews.automation.pageobjects.VideoPageObjects.smpLiveIcon
import com.bbcnews.automation.pageobjects.VideoPageObjects.smpPlaceholderPlayButton
import com.bbcnews.automation.pageobjects.VideoPageObjects.smpPlayPauseButton
import com.bbcnews.automation.pageobjects.VideoPageObjects.smpSeekBar
import com.bbcnews.automation.pageobjects.VideoPageObjects.smpVolumeButton
import com.bbcnews.automation.pageobjects.VideoPageObjects.transportControls
import com.bbcnews.automation.testutils.TestSetup.androidDriver
import io.qameta.allure.Severity
import io.qameta.allure.SeverityLevel
import io.qameta.allure.Story
import org.openqa.selenium.By
import org.openqa.selenium.StaleElementReferenceException
import org.testng.Assert.assertEquals
import org.testng.Assert.assertTrue
import org.testng.annotations.Ignore
import org.testng.annotations.Test
import java.io.IOException
import java.time.Duration

class BBCNewsSmokeTest : BbcTestCase(
        "bbc.mobile.news.v3.app.TopLevelActivity",
        "SmokeTest"
) {

    /**
     * launches the app and ignores the pop up message
     */
    @Test(priority = 1, description = "Launching the app")
    fun testOpenNewsApp() {
        tapButton(androidDriver, BasePageObject.okButton, false)
        tapButton(androidDriver, BasePageObject.noThanksButton, false)

        try {
            tapButton(androidDriver, BasePageObject.errorRetryButton, false)
        } catch (e: Exception) {
            // if the retry button is not present then do nothing
        }
    }

    /**
     * un-ignore if you want to check the screenshot compare tests
     */
    @Ignore
    @Test(priority = 2, description = "takes the screenshot of the topStories, myNews, popular,video and menu page")
    @Throws(IOException::class)
    fun testTakeScreenshotsOfPages() {
        tapButton(androidDriver, topStories, false)
        screenshot(androidDriver, "Before", "topStories")
        tapButton(androidDriver, myNews, false)
        screenshot(androidDriver, "Before", "myNews")
        tapButton(androidDriver, popular, false)
        screenshot(androidDriver, "Before", "popular")
        tapButton(androidDriver, video, false)
        screenshot(androidDriver, "Before", "video")
        tapButton(androidDriver, menuButton, false)
        screenshot(androidDriver, "Before", "menu")
        navigateBack(androidDriver)
    }

    @Test(priority = 2, description = "Check the links on the Home page after app launched")
    @Story("Home")
    @Severity(SeverityLevel.CRITICAL)
    fun testCheckHomePage() {
        androidDriver.runAppInBackground(Duration.ofSeconds(30))
        startTest("HomePage", "Checking the HomePage", "Smoke")
        tapButton(androidDriver, topStories, false)
        assertTrue(topStories?.isSelected!!)
        assertDisplayingElements(androidDriver,
                itemLayoutName,
                itemLayoutHomeSection,
                itemLayoutLastUpdated,
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
    fun testAllowLocation() {
        startTest("MyNews", "Checking the MyNews", "Smoke")
        tapButton(androidDriver, myNews, false)
        tapButton(androidDriver, myNewsStartButton, false)
        tapButton(androidDriver, MyNewsPageObject.allowLocation, false)
        tapButton(androidDriver, MyNewsPageObject.allowLocationPermission, false)
        navigateBack(androidDriver)
    }

    @Test(priority = 4, description = "Test to check the popular page")
    @Story("Popular")
    @Severity(SeverityLevel.CRITICAL)
    fun testPopularPage() {
        startTest("PopularPage", "Checking the Popular", "Smoke")
        tapButton(androidDriver, popular, false)
        assertTrue(popular?.isSelected!!)
        assertDisplayingElements(androidDriver, mostRead)
        assertEquals("Most Read", mostRead?.text, "Text Matched")
    }

    @Test(priority = 5, description = "checking that most watched displayed in popular page")
    @Story("Popular")
    @Severity(SeverityLevel.CRITICAL)
    fun testMostWatched() {
        startTest("PopularPage", "Checking most watched displayed the Popular", "Smoke")
        scrollToElement(androidDriver, popularMostWatched)
        assertEquals("Most Watched", popularMostWatched?.text, "Text Matched")
    }

    @Test(priority = 6, description = "Test to check the Mynews page")
    @Story("MyNews")
    @Severity(SeverityLevel.CRITICAL)
    fun testMyNewsPage() {
        startTest("MyNews", "Checking the MyNews", "Smoke")
        tapButton(androidDriver, myNews, false)

        assertTrue(myNews?.isSelected!!)

        assertDisplayingElements(androidDriver,
                myNewsSummary,
                myNewsTitle,
                addNewsButton
        )

        assertEquals(myNewsTitleText, myNewsTitle?.text, "Text matched")
        assertEquals(myNewsSummaryText, myNewsSummary?.text, "Text matched")
    }

    /**
     * Adding the topics to MyNews
     */
    @Test(priority = 7, description = "Test to check the adding the topics to MyNews page")
    @Severity(SeverityLevel.CRITICAL)
    fun testAddingTopicsToMyNewsPage() {
        startTest("MyNews", "Adding topics to MyNews", "Smoke")
        tapButton(androidDriver, myNewsStartButton, false)
        tapButton(androidDriver, addTopics, false)

        assertEquals("Manchester", localNewsDisplayed?.text)
        assertDisplayingElements(androidDriver, localNewsDisplayed)

        scrollToElement(androidDriver, MyTopicsPageObject.addWalesTopicButton)
        tapButton(androidDriver, MyTopicsPageObject.addWalesTopicButton, false)
        textPresent(androidDriver, "Wales", "added to")

        scrollToElement(androidDriver, MyTopicsPageObject.addWorldTopicButton)
        tapButton(androidDriver, MyTopicsPageObject.addWorldTopicButton, false)
    }

    /**
     * Checked the selected topics are getting displayed under Added Topics
     */
    @Test(priority = 8, description = "Test to check whether selected topics displayed under MyTopics page")
    @Story("MyTopics")
    @Severity(SeverityLevel.CRITICAL)
    fun testCheckAddedTopicsUnderMyTopics() {
        startTest("MyTopics", "Checking Added topics in MyTopics", "Smoke")
        tapButton(androidDriver, MyNewsPageObject.myTopics, false)
        assertDisplayingElements(androidDriver,
                MyTopicsPageObject.walesTopic,
                MyTopicsPageObject.worldTopic
        )
        navigateBack(androidDriver)
    }

    /**
     * Checks for Added topics displayed under My News page
     */
    @Test(priority = 9, description = "Test to check whether added topics displayed under MyNews page")
    @Story("MyNews")
    @Severity(SeverityLevel.CRITICAL)
    fun testCheckAddedTopicsUnderMyNews() {
        startTest("MyNews", "Checking added topics in My News", "Smoke")

        try {
            assertDisplayingElements(androidDriver,
                    MyTopicsPageObject.walesTopic,
                    MyTopicsPageObject.worldTopic
            )
        } catch (e: StaleElementReferenceException) {
            // todo find a way to stop StaleElementReferenceException
        }
    }

    /**
     * removing one of the topics(England) from MyNews-Added Topics
     */
    @Test(priority = 10, description = "Test To remove topics which are displayed under MyNews")
    @Throws(Exception::class)
    fun testMyNewsRemoveTopics() {
        startTest("Removing Added Topics", "Test to check Topics on MyNews page", "MyNews")
        tapButton(androidDriver, myNews, false)
        tapButton(androidDriver, MyNewsPageObject.editMyNews, false)

        assertDisplayingElements(androidDriver,
                MyTopicsPageObject.walesTopic,
                MyTopicsPageObject.worldTopic
        )

        tapButton(androidDriver, MyNewsPageObject.removeTopics, false)
        tapButton(androidDriver, BasePageObject.backButton, false)
    }

    /**
     * Checks the Articles from Topics page, Checks for More button and checks for Less button displayed
     */
    @Test(priority = 11, description = "Test to check the Articles displayed under topics of MyNews page")
    fun testCheckArticlesOfTopics() {
        startTest("MyNews", "Checking the Articles displayed under topics of MyNews Page", "Smoke")

        val contentImages = androidDriver.findElements(By.id("bbc.mobile.news.uk.internal:id/content_card_image"))
        val contentCardTitle = androidDriver.findElements(By.id("bbc.mobile.news.uk.internal:id/content_card_title"))
        val contentCardUpdated = androidDriver.findElements(By.id("bbc.mobile.news.uk.internal:id/content_card_last_updated"))

        val total = contentImages.size
        System.out.println("The number of cards is: $total")

        for (i in contentImages.indices) {
            assertDisplayingElements(androidDriver,
                    contentCardTitle[i],
                    contentCardUpdated[i]
            )
        }

        tapButton(androidDriver, showMore, false)

        scrollToElement(androidDriver, showLess)
        System.out.println("\"Show less\" text= " + showLess?.text)

        tapButton(androidDriver, showLess, false)
        assertDisplayingElements(androidDriver, showMore)
        System.out.println("\"Show more\" text= " + showMore?.text)
    }

    /**
     * Open the Menu items and assert whether links are displayed properly
     */
    @Test(priority = 12, description = "Test to Check the Menu Options ")
    @Story("Menu")
    @Severity(SeverityLevel.CRITICAL)
    @Throws(Exception::class, AssertionError::class)
    fun testMenuPage() {
        startTest("Menu", "Checking the Menu Items", "Smoke")
        tapButton(androidDriver, menuButton, false)

        assertDisplayingElements(androidDriver,
                BasePageObject.appInfo,
                BasePageObject.otherBbcApps,
                BasePageObject.internalSettings,
                BasePageObject.settings
        )

        navigateBack(androidDriver)
    }

    /**
     * check the live video on video page
     */
    @Test(priority = 13, description = "Test to check the Video page and selecting the live video for playback and asserting the playback controls")
    @Story("VideoPage")
    @Severity(SeverityLevel.CRITICAL)
    @Throws(Exception::class, AssertionError::class)
    fun testVideoPage() {
        startTest("VideoPage", "Checking the Video", "Smoke")

        tapButton(androidDriver, video, false)
        assertTrue(video?.isSelected!!)

        tapButton(androidDriver, bbcNewsChannel, false)
        assertDisplayingElements(androidDriver, liveMediaItemCaption)
        try {
            if (shareStory?.isDisplayed!!) {
                verticalSwipe(androidDriver, "Up")

                assertDisplayingElements(androidDriver, shareStory)
            }
        } catch (e: NoSuchElementException) {
        }

        tapButton(androidDriver, smpPlaceholderPlayButton, false)
    }

    /**
     * check the live video  seeking
     */
    @Test(priority = 14, description = "Test to check whether you can scrub the Live Video and Live Text shouldn't be displayed")
    @Story("VideoPage")
    @Severity(SeverityLevel.CRITICAL)
    fun testCheckLiveVideoSeeking() {
        startTest("VideopageSeeking", "Test to whether you can scrub the Live Video ", "Smoke")

        tapButton(androidDriver, transportControls, false)
        tapButton(androidDriver, transportControls, false)

        assertDisplayingElements(androidDriver,
                smpLiveIcon,
                smpVolumeButton,
                smpSeekBar
        )

        tapButton(androidDriver, bbcNewsChannel, false)
        waitForScreenToLoad(androidDriver, smpSeekBar, 3)

        videoPlaybackSeeking(androidDriver, smpSeekBar, 0.30)

        assertDisplayingElements(androidDriver, accessibilityPause)
        tapButton(androidDriver, smpPlayPauseButton, false)
        assertDisplayingElements(androidDriver, accessibilityPlay)

        navigateBack(androidDriver)
    }

    /**
     * check to search for a topic
     */
    @Test(priority = 15, description = "Test to check for search results")
    fun testSearchStories() {
        try {
            startTest("Search", "Checking for Search Topics", "Smoke")
            tapButton(androidDriver, BasePageObject.searchButton, false)
            enterText(searchField, BasePageObject.searchText)
            waitFor(1000)
            assertEquals(BasePageObject.searchText, BasePageObject.searchKeyword?.text, "Text Matched")
            tapButton(androidDriver, BasePageObject.searchKeyword, false)
            val title = getText(headlineTitle)
            assertEquals(BasePageObject.searchText, title)
            tapButton(androidDriver, BasePageObject.backButton, false)
            navigateBack(androidDriver)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    /**
     * un-ignore if you want to check the screenshot compare tests
     */
    @Ignore
    @Test(priority = 16, description = "takes the screenshot of the Top Stories, My News, Popular, Video, and Menu pages")
    @Throws(IOException::class)
    fun testTakeScreenshotAfter() {
        try {
            tapButton(androidDriver, BasePageObject.navigateBack, false)
        } catch (e: NoSuchElementException) {
            // Ignore if already on the main screen
            assertDisplayingElements(androidDriver, menuButton)
        }

        tapButton(androidDriver, topStories, false)
        screenshot(androidDriver, "After", "topStories")

        tapButton(androidDriver, myNews, false)
        screenshot(androidDriver, "After", "myNews")

        tapButton(androidDriver, popular, false)
        screenshot(androidDriver, "After", "popular")

        tapButton(androidDriver, video, false)
        screenshot(androidDriver, "After", "video")

        tapButton(androidDriver, menuButton, false)
        screenshot(androidDriver, "After", "menu")

        navigateBack(androidDriver)
    }

    /**
     * un-ignore if you want to check the screenshot compare tests
     */
    @Ignore
    @Test(priority = 17, description = "Compares the images")
    @Throws(IOException::class)
    fun testCompareImages() {
        startTest("CompareImages", "Compares the HomePage", "Smoke")
        compareTwoImages()
    }

}