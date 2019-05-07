package com.bbcnews.automation.scripts

import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.checkConnection
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.createAReportHive
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.elementDisplayed
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.elementDragDrop
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.elementIsSelected
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.emptyFolder
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.enterText
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.getTestResult
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.getText
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.isElementPresent
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.isElementSelected
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.publishReport
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.readRecyclerView
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.scrollToElement
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.seeking
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.startTest
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.tapButton
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.textPresent
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.verticalSwipe
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.waitFor
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.waitForScreenToLoad
import com.bbcnews.automation.commonfunctions.FilePaths.screenshotPath
import com.bbcnews.automation.commonfunctions.ScreenActions.pressBack
import com.bbcnews.automation.commonfunctions.ScreenAssertions.assertDisplayingElements
import com.bbcnews.automation.pageobjects.*
import com.bbcnews.automation.pageobjects.BasePageObject.appInfo
import com.bbcnews.automation.pageobjects.BasePageObject.article
import com.bbcnews.automation.pageobjects.BasePageObject.articleDetailPageLinks
import com.bbcnews.automation.pageobjects.BasePageObject.articleImageBadge
import com.bbcnews.automation.pageobjects.BasePageObject.articleItemWithImageBadge
import com.bbcnews.automation.pageobjects.BasePageObject.articleItemWithItemBadge
import com.bbcnews.automation.pageobjects.BasePageObject.articleItemWithoutImageBadge
import com.bbcnews.automation.pageobjects.BasePageObject.articleItemWithoutItemBadge
import com.bbcnews.automation.pageobjects.BasePageObject.articleLastUpdated
import com.bbcnews.automation.pageobjects.BasePageObject.articleLayoutName
import com.bbcnews.automation.pageobjects.BasePageObject.articlePageDetail
import com.bbcnews.automation.pageobjects.BasePageObject.articlePageDetailElements
import com.bbcnews.automation.pageobjects.BasePageObject.articleSearch
import com.bbcnews.automation.pageobjects.BasePageObject.backButton
import com.bbcnews.automation.pageobjects.BasePageObject.cancelSearch
import com.bbcnews.automation.pageobjects.BasePageObject.headlineTitle
import com.bbcnews.automation.pageobjects.BasePageObject.internalSettings
import com.bbcnews.automation.pageobjects.BasePageObject.menuAppInfo
import com.bbcnews.automation.pageobjects.BasePageObject.menuButton
import com.bbcnews.automation.pageobjects.BasePageObject.myNews
import com.bbcnews.automation.pageobjects.BasePageObject.navigateBack
import com.bbcnews.automation.pageobjects.BasePageObject.noThanksButton
import com.bbcnews.automation.pageobjects.BasePageObject.okButton
import com.bbcnews.automation.pageobjects.BasePageObject.otherBbcApps
import com.bbcnews.automation.pageobjects.BasePageObject.popular
import com.bbcnews.automation.pageobjects.BasePageObject.privacyPolicy
import com.bbcnews.automation.pageobjects.BasePageObject.relatedStories
import com.bbcnews.automation.pageobjects.BasePageObject.relatedTopics
import com.bbcnews.automation.pageobjects.BasePageObject.search
import com.bbcnews.automation.pageobjects.BasePageObject.searchButton
import com.bbcnews.automation.pageobjects.BasePageObject.searchField
import com.bbcnews.automation.pageobjects.BasePageObject.searchHeading
import com.bbcnews.automation.pageobjects.BasePageObject.searchHeading2
import com.bbcnews.automation.pageobjects.BasePageObject.searchKeyword
import com.bbcnews.automation.pageobjects.BasePageObject.searchText
import com.bbcnews.automation.pageobjects.BasePageObject.settings
import com.bbcnews.automation.pageobjects.BasePageObject.shareStory
import com.bbcnews.automation.pageobjects.BasePageObject.smpErrorMessage
import com.bbcnews.automation.pageobjects.BasePageObject.smpErrorOkButton
import com.bbcnews.automation.pageobjects.BasePageObject.smpRetryButton
import com.bbcnews.automation.pageobjects.BasePageObject.termsConditions
import com.bbcnews.automation.pageobjects.BasePageObject.topStories
import com.bbcnews.automation.pageobjects.BasePageObject.topicsPageElements
import com.bbcnews.automation.pageobjects.BasePageObject.video
import com.bbcnews.automation.pageobjects.HomePageObject.educationTopics
import com.bbcnews.automation.pageobjects.HomePageObject.technologyTopic
import com.bbcnews.automation.pageobjects.MyNewsPageObject.addNewsButton
import com.bbcnews.automation.pageobjects.MyNewsPageObject.addTopics
import com.bbcnews.automation.pageobjects.MyNewsPageObject.allowLocation
import com.bbcnews.automation.pageobjects.MyNewsPageObject.allowLocationPermission
import com.bbcnews.automation.pageobjects.MyNewsPageObject.editMyNews
import com.bbcnews.automation.pageobjects.MyNewsPageObject.editMyTopics
import com.bbcnews.automation.pageobjects.MyNewsPageObject.localNews
import com.bbcnews.automation.pageobjects.MyNewsPageObject.localNewsDisplayed
import com.bbcnews.automation.pageobjects.MyNewsPageObject.manageYourTopics
import com.bbcnews.automation.pageobjects.MyNewsPageObject.myNewsAddTopics
import com.bbcnews.automation.pageobjects.MyNewsPageObject.myNewsRecyclerView
import com.bbcnews.automation.pageobjects.MyNewsPageObject.myNewsStartButton
import com.bbcnews.automation.pageobjects.MyNewsPageObject.myNewsSummary
import com.bbcnews.automation.pageobjects.MyNewsPageObject.myNewsSummaryText
import com.bbcnews.automation.pageobjects.MyNewsPageObject.myNewsTitle
import com.bbcnews.automation.pageobjects.MyNewsPageObject.myNewsTitleText
import com.bbcnews.automation.pageobjects.MyNewsPageObject.myTopicEmptyView
import com.bbcnews.automation.pageobjects.MyNewsPageObject.myTopicEmptyViewText
import com.bbcnews.automation.pageobjects.MyNewsPageObject.myTopics
import com.bbcnews.automation.pageobjects.MyNewsPageObject.removeTopics
import com.bbcnews.automation.pageobjects.MyNewsPageObject.topicArticle
import com.bbcnews.automation.pageobjects.MyNewsPageObject.topicVideoArticle
import com.bbcnews.automation.pageobjects.MyTopicsPageObject.addAfricaTopicButton
import com.bbcnews.automation.pageobjects.MyTopicsPageObject.addEnglandTopicButton
import com.bbcnews.automation.pageobjects.MyTopicsPageObject.addEuTopicButton
import com.bbcnews.automation.pageobjects.MyTopicsPageObject.addMortgagesTopicButton
import com.bbcnews.automation.pageobjects.MyTopicsPageObject.addYouTubeTopicButton
import com.bbcnews.automation.pageobjects.MyTopicsPageObject.africaTopic
import com.bbcnews.automation.pageobjects.MyTopicsPageObject.englandTopic
import com.bbcnews.automation.pageobjects.MyTopicsPageObject.europeanTopic
import com.bbcnews.automation.pageobjects.MyTopicsPageObject.mortgagesTopic
import com.bbcnews.automation.pageobjects.MyTopicsPageObject.youTubeTopic
import com.bbcnews.automation.pageobjects.PopularPageObjects.mostPopular
import com.bbcnews.automation.pageobjects.PopularPageObjects.mostRead
import com.bbcnews.automation.pageobjects.PopularPageObjects.mostReadArticle
import com.bbcnews.automation.pageobjects.PopularPageObjects.mostReadPopularLinks
import com.bbcnews.automation.pageobjects.PopularPageObjects.mostWatchedArticleVideo
import com.bbcnews.automation.pageobjects.PopularPageObjects.popularMostWatched
import com.bbcnews.automation.pageobjects.PopularPageObjects.popularVideoElements
import com.bbcnews.automation.pageobjects.PopularPageObjects.relatedStoriesArticle
import com.bbcnews.automation.pageobjects.PopularPageObjects.relatedTopicsArticle
import com.bbcnews.automation.pageobjects.VideoPageObjects.accessibilityPlay
import com.bbcnews.automation.pageobjects.VideoPageObjects.bbcNewsChannel
import com.bbcnews.automation.pageobjects.VideoPageObjects.elapsedTimeBackward
import com.bbcnews.automation.pageobjects.VideoPageObjects.elapsedTimeForward
import com.bbcnews.automation.pageobjects.VideoPageObjects.liveMediaItemCaption
import com.bbcnews.automation.pageobjects.VideoPageObjects.playButton
import com.bbcnews.automation.pageobjects.VideoPageObjects.playbackControls
import com.bbcnews.automation.pageobjects.VideoPageObjects.smpElapsedTime
import com.bbcnews.automation.pageobjects.VideoPageObjects.smpExitFullScreenButton
import com.bbcnews.automation.pageobjects.VideoPageObjects.smpFullScreenButton
import com.bbcnews.automation.pageobjects.VideoPageObjects.smpLiveIcon
import com.bbcnews.automation.pageobjects.VideoPageObjects.smpPauseButton
import com.bbcnews.automation.pageobjects.VideoPageObjects.smpSeekBar
import com.bbcnews.automation.pageobjects.VideoPageObjects.smpVolumeButton
import com.bbcnews.automation.pageobjects.VideoPageObjects.topStoriesVideo
import com.bbcnews.automation.pageobjects.VideoPageObjects.transportControls
import com.bbcnews.automation.pageobjects.VideoPageObjects.videoArticleSearch
import com.bbcnews.automation.pageobjects.VideoPageObjects.videoDetailPage
import com.bbcnews.automation.pageobjects.VideoPageObjects.videoDetailPageText
import com.bbcnews.automation.pageobjects.VideoPageObjects.videoWallElements
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.StartsActivity
import io.appium.java_client.android.connection.ConnectionStateBuilder
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import io.appium.java_client.remote.MobileCapabilityType
import io.qameta.allure.Story
import org.openqa.selenium.By
import org.openqa.selenium.ScreenOrientation
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.support.PageFactory
import org.testng.Assert.*
import org.testng.ITestResult
import org.testng.annotations.AfterMethod
import org.testng.annotations.AfterTest
import org.testng.annotations.BeforeTest
import org.testng.annotations.Test
import java.io.File
import java.lang.System.getProperty
import java.net.URL
import java.time.Duration
import com.bbcnews.automation.pageobjects.HomePageObject.familyEducationTopic as familyEducationTopic1

class BBCNewsRegressionTestKotlin {

    private var deviceName: String? = null
    private var appiumPort: String? = null
    private var deviceid: String? = null
    private var appPath: String? = null

    private lateinit var file: File
    private lateinit var androidDriver: AndroidDriver<MobileElement>

    @BeforeTest
    fun runTest() {
        readDeviceDetailsCommandPrompt()
        setUp()
        checkConnection(androidDriver)
        /**
         *  setting the view mode to Portrait , since on Hive sometime device might be in Landscape mode
         */
        val orientation = androidDriver.orientation
        if (orientation == ScreenOrientation.LANDSCAPE) {
            androidDriver.rotate(ScreenOrientation.PORTRAIT)
        }
        initialiseObjects()
    }

    private fun readDeviceDetailsCommandPrompt() {
        deviceid = getProperty("DeviceID")
        deviceName = getProperty("DeviceName")
        appPath = getProperty("AppPath")
        appiumPort = getProperty("AppiumPort")

        println("Passed The Device ID is $deviceid")
        println("Passed The Device Name is $deviceName")
        println("Passed The Appium port is $appiumPort")
        println("Passed The Application path  is $appPath")
    }

    private fun setUp() {
        //  appiumStart.startAppium(Integer.parseInt(Appium_Port));
        val appiumUrl = "http://127.0.0.1:$appiumPort/wd/hub"
        println("Appium Server Address : - $appiumUrl")
        val capabilities = DesiredCapabilities()
        capabilities.setCapability(MobileCapabilityType.UDID, deviceid)
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "bbcnews")
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2")
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android")
        capabilities.setCapability("appiumversion", "1.8.1")
        capabilities.setCapability("app", appPath)
        capabilities.setCapability("appPackage", "bbc.mobile.news.uk.internal")
        capabilities.setCapability("appActivity", "bbc.mobile.news.v3.app.TopLevelActivity")
        capabilities.setCapability("--session-override", true)
        capabilities.setCapability("ignoreUnimportantViews", true)
        androidDriver = AndroidDriver(URL(appiumUrl), capabilities)
    }

    private fun initialiseObjects() {
        PageFactory.initElements(AppiumFieldDecorator(androidDriver), HomePageObject)

        PageFactory.initElements(AppiumFieldDecorator(androidDriver), MyNewsPageObject)

        PageFactory.initElements(AppiumFieldDecorator(androidDriver), BasePageObject)

        PageFactory.initElements(AppiumFieldDecorator(androidDriver), VideoPageObjects)

        PageFactory.initElements(AppiumFieldDecorator(androidDriver), PopularPageObjects)

        PageFactory.initElements(AppiumFieldDecorator(androidDriver), MyTopicsPageObject)

        emptyFolder(screenshotPath)

        createAReportHive("Regression", deviceName.toString(), deviceid.toString())

        androidDriver.context("NATIVE_APP")
        file = File(screenshotPath)
        val screenshot = file.absolutePath
        println("The ScreenShot Path is $screenshot")
    }

    @Test(priority = 1, description = "Launching the app")
    fun testOpenNewsApp() {
        tapButton(androidDriver, okButton, false)
        tapButton(androidDriver, noThanksButton, false)

        if (isElementPresent(androidDriver, By.id("bbc.mobile.news.uk.internal:id/error_retry")))
        //    !androidDriver.findElement(By.id("bbc.mobile.news.uk.internal:id/error_retry")).isDisplayed)
        {
            androidDriver.findElement(By.id("bbc.mobile.news.uk.internal:id/error_retry")).click()
            //wait.until(extenttestReport.elementFoundAndClicked(By.id("bbc.mobile.news.uk.internal:id/error_retry")));
        }
    }

    @Test(priority = 2, description = "Test to check whether all links present on Home Page")
    fun testTopStories() {
        startTest("Checking the HomePage", "Checking the HomePage", "HomePage")
        isElementSelected(topStories)

        assertDisplayingElements(androidDriver,
                topStories,
                myNews,
                popular,
                video,
                search,
                menuButton
        )
    }

    /**
     * commented out as VideoOfTheDay isn't displayed  on Home page
     */

//    @Test(priority = 3, description = "Test to check Video of the day displayed and swipe through all the videos")
//    fun testVideoOfTheDayDisplayed() {
//            startTest("VideoOftheDay", "Scroll to a Video of the day", "HomePage")
//            sleepmethod(1000)
//            scrolltoElement(androidDriver, videoOfTheDayWatch)
//            elementDisplayed(androidDriver, videoOfTheDayWatchNext)
//            elementDisplayed(androidDriver, promoCounter)
//            elementDisplayed(androidDriver, videoOfTheDayPromoSummary)
//            elementDisplayed(androidDriver, videoOfTheDayTitle)
//            Assert.assertEquals("Videos of the day", videoOfTheDayTitle.getText())
//            Assert.assertEquals("WATCH", videoOfTheDayWatchNext.getText())
//            Assert.assertEquals("7", promoCounter.getText())
//            Assert.assertEquals("Swipe through the latest news videos", videoOfTheDayPromoSummary.getText())
//            tapButton(androidDriver, videoOfTheDayButton, false)
//            scrolltoEndofStories(androidDriver, newsStreamProgress, videsofthedayRelease, checkBackLater)
//            pressBack()
//    }

    @Test(priority = 3, description = "Test to scroll to a topic on home page and select a particular topic and add to MyNews")
    fun testToCheckTopicsTopStores() {
        startTest("Scrolling to topics", "Scroll to a Topics on Home Page", "HomePage")

        //scrolls to Reality Check topics on Top Stories page
        scrollToElement(androidDriver, educationTopics)
        tapButton(androidDriver, educationTopics!!, false)
        if (!isElementPresent(androidDriver, By.id("bbc.mobile.news.uk.internal:id/menu_follow"))) {
            System.out.println("Scrolling up")
            verticalSwipe(androidDriver, "Up")
        }
        elementDisplayed(androidDriver, familyEducationTopic1)
        System.out.println("Topics is :-" + familyEducationTopic1?.text)

        for (i in 0 until topicsPageElements.size) {
            isElementPresent(androidDriver, By.id(topicsPageElements[i]))
        }
        tapButton(androidDriver, myNewsAddTopics, false)
        textPresent(androidDriver, "Family & Education", "added to")
        elementDisplayed(androidDriver, manageYourTopics)
        tapButton(androidDriver, backButton, false)


        //scrolls to health topics on Top Stories page
        scrollToElement(androidDriver, technologyTopic)
        tapButton(androidDriver, technologyTopic, false)
        if (!isElementPresent(androidDriver, By.id("bbc.mobile.news.uk.internal:id/menu_follow"))) {
            System.out.println("Scrolling up")
            verticalSwipe(androidDriver, "Up")
        }
        System.out.println("The Topic is " + technologyTopic?.text)
        elementDisplayed(androidDriver, technologyTopic)
        System.out.println("Topics is :-" + technologyTopic?.text)

        for (i in 0 until topicsPageElements.size) {
            isElementPresent(androidDriver, By.id(topicsPageElements[i]))
        }

        tapButton(androidDriver, myNewsAddTopics, false)
        textPresent(androidDriver, "Technology", "added to")
        elementDisplayed(androidDriver, manageYourTopics)
        tapButton(androidDriver, backButton, false)
    }

//    @Test(priority = 4, description = "Test To Check the topics added from top stories are displayed under MyNews")
//    fun testMyNewsTopStoriesTopics() {
//        try {
//            startTest("Removing Added Topics", "Test to check Topics on MyNews page", "MyNews")
//            tapButton(androidDriver, myNews, false)
//            tapButton(androidDriver, editMyNews, false)
//
//            assertDisplayingElements(androidDriver,
//                    technologyTopic,
//                    familyEducationTopic
//            )
//
//            tapButton(androidDriver, removetopics, false)
//            // textPresent(androidDriver, "Family & Education", "removed from")
//            tapButton(androidDriver, removetopics, false)
//            // textPresent(androidDriver, "Technology", "removed from")
//            // pressBack()
//            tapButton(androidDriver, backButton, false)
//        } catch (e: StaleElementReferenceException) {
//            // todo: remove this!!! failing without it
//        }
//    }

    @Test(priority = 5, description = "Test for Checking whether Location service works")
    @Story("MyNews")
    fun testAllowLocation() {
        startTest("Allowing Location Service ", "Checking whether Location service works ", "MyNews")
        tapButton(androidDriver, myNews, false)//,file.getAbsolutePath());
        tapButton(androidDriver, myNewsStartButton, false)
        tapButton(androidDriver, allowLocation, false)
        tapButton(androidDriver, allowLocationPermission, false)
        pressBack()
    }

    @Test(priority = 6, description = "Test to check MyNews page and asserting whether all links displayed")
    fun testMyNews() {
        startTest("Checking Elements on MyNews Page", "Test to check MyNews page", "MyNews")
        tapButton(androidDriver, myNews, false)
        assertDisplayingElements(androidDriver,
                myNewsSummary,
                myNewsTitle,
                addNewsButton
        )
        assertEquals(myNewsTitleText, myNewsTitle?.text, "Text Mesaaged")
        assertEquals(myNewsSummaryText, myNewsSummary?.text, "Text Mesaaged")
    }

    // @Test(dependsOnMethods = {"testMyNews"})
    @Test(priority = 7, description = "Test to check on My News Add Topic screen and asserting all links are displayed")
    fun testAddingTopicsPage() {
        startTest("Checking Elements on Edit Mynews Page", "Test to check Edit MyNews page", "MyNews")
        tapButton(androidDriver, myNewsStartButton, false)
        elementIsSelected(addTopics)

        assertDisplayingElements(androidDriver,
                myTopics,
                // locationButton
                editMyTopics,
                localNews
        )

        tapButton(androidDriver, myTopics, false)//,file.getAbsolutePath());
        elementIsSelected(myTopics)
        assertEquals(myTopicEmptyViewText, myTopicEmptyView?.text, "Text Mesaaged")
    }

    // @Test(dependsOnMethods = {"testAddingTopicsPage"})
    @Test(priority = 8, description = "Test to add Topics under MyNews")
    fun testAddingTopicsToMyNewsPage() {
        startTest("Adding Topics ", "Test to check added Topics to MyNews page", "MyNews")
        tapButton(androidDriver, addTopics, false)

        assertEquals("Manchester", localNewsDisplayed?.text)
        elementDisplayed(androidDriver, localNewsDisplayed)

        scrollToElement(androidDriver, addEnglandTopicButton)
        tapButton(androidDriver, addEnglandTopicButton, false)
        // textPresent(androidDriver, "England", "added to")

        scrollToElement(androidDriver, addAfricaTopicButton)
        tapButton(androidDriver, addAfricaTopicButton, false)

        scrollToElement(androidDriver, addEuTopicButton)
        tapButton(androidDriver, addEuTopicButton, false)

        scrollToElement(androidDriver, addMortgagesTopicButton)
        tapButton(androidDriver, addMortgagesTopicButton, false)
        //  textPresent(androidDriver, "Mortgages", "added to")

        scrollToElement(androidDriver, addYouTubeTopicButton)
        tapButton(androidDriver, addYouTubeTopicButton, false)
        //  textPresent(androidDriver, "YouTube", "added to")
    }

    @Test(priority = 9, description = "Test to check whether selected topics are displayed under Added Topics in MyNews")
    fun testCheckAddedTopics() {
        startTest("My Topics page", "Test to check added Topics MyNews page", "MyNews")
        tapButton(androidDriver, myTopics, false)

        assertDisplayingElements(androidDriver,
                englandTopic,
                africaTopic,
                europeanTopic,
                mortgagesTopic,
                youTubeTopic
        )
    }

    @Test(priority = 10, description = "Test to display the Ordering of the Topics")
    fun testCheckOrderingOfTopicsAdded() {
        startTest("My Topics Ordering", "Test to display the Ordering of the Topics", "MyNews")
        readRecyclerView(androidDriver, "Topics Before Re-Ordering :- ")
        System.out.println("The Text at get(0) is " + androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='1']/android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='1']")).text)
        System.out.println("The Text at get(1) is " + androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='1']/android.widget.RelativeLayout[@index='1']/android.widget.TextView[@index='1']")).text)
        System.out.println("The Text at get(2) is " + androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='1']/android.widget.RelativeLayout[@index='2']/android.widget.TextView[@index='1']")).text)
        System.out.println("The Text at get(3) is " + androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='1']/android.widget.RelativeLayout[@index='3']/android.widget.TextView[@index='1']")).text)
        System.out.println("The Text at get(4) is " + androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='1']/android.widget.RelativeLayout[@index='4']/android.widget.TextView[@index='1']")).text)
        assertEquals("England", androidDriver.findElement(By.xpath("//android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='1']")).text, "Test Matched")
        pressBack()
    }

    @Test(priority = 11, description = "Test to select each of the topics displayed under MyNews ")
    fun testSelectedAddedTopics() {
        startTest("Checking Added Topics on Mynews page", "Selecting Added Topics", "MyNews")
        waitFor(1000)

        assertDisplayingElements(androidDriver,
                englandTopic,
                europeanTopic,
                africaTopic
        )

        tapButton(androidDriver, africaTopic, false)
        for (i in 0 until topicsPageElements.size) {
            isElementPresent(androidDriver, By.id(topicsPageElements[i]))
        }
        pressBack()
        tapButton(androidDriver, europeanTopic, false)
        for (i in 0 until topicsPageElements.size) {
            isElementPresent(androidDriver, By.id(topicsPageElements[i]))
        }
        pressBack()
        tapButton(androidDriver, englandTopic, false)
        for (i in 0 until topicsPageElements.size) {
            isElementPresent(androidDriver, By.id(topicsPageElements[i]))
        }
        pressBack()
    }


    @Test(priority = 12, description = "Test to re-arrange topics from top to bottom")
    fun testCheckReOrderingOfTopicsAdded() {
        startTest("Re Arrange Topics from Top-to-Bottom", "Test to re-arrange topics from top to bottom", "MyNews")
        tapButton(androidDriver, editMyNews, false)

        val england = androidDriver.findElementsById("bbc.mobile.news.uk.internal:id/grab_handle")[0]
        val youTubeTopic = androidDriver.findElementsById("bbc.mobile.news.uk.internal:id/grab_handle")[4]

        elementDragDrop(androidDriver, england, youTubeTopic)

        readRecyclerView(androidDriver, "Topics After  Re-Ordering :- ")

        System.out.println("The Text at get(3) is " + androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='1']/android.widget.RelativeLayout[@index='3']/android.widget.TextView[@index='1']")).text)
        assertEquals("England", androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='1']/android.widget.RelativeLayout[@index='3']/android.widget.TextView[@index='1']")).text, "Test Matched")

        System.out.println("The Text at get(0) is " + androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='1']/android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='1']")).text)
        assertNotEquals("England", androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='1']/android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='1']")).text, "Test Matched")
        assertEquals("Africa", androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='1']/android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='1']")).text, "Test Matched")

        pressBack()
    }

    @Test(priority = 13, description = "Test to check whether the Menu Options are displayed")
    fun testCheckMenuItems() {
        startTest("Checking the MenuItems", "Checking Menu Items ", "Menu")
        tapButton(androidDriver, menuButton, false)

        assertDisplayingElements(androidDriver,
                settings,
                internalSettings,
                otherBbcApps,
                appInfo
        )
        pressBack()
    }

    @Test(priority = 14, description = "Test to play a Live video from Video page and asserting on whether playback controls are displayed")
    fun testVideoPage() {
        startTest("Playing a Live Video", "Checking the Video Page", "Live Video")
        tapButton(androidDriver, video, false)
        tapButton(androidDriver, bbcNewsChannel, false)

        assertDisplayingElements(androidDriver,
                liveMediaItemCaption,
                navigateBack,
                shareStory
        )
        tapButton(androidDriver, accessibilityPlay, false)
        waitFor(1400)
        tapButton(androidDriver, smpFullScreenButton, false)
        waitFor(1400)

        if (isElementPresent(androidDriver, By.id("bbc.mobile.news.uk.internal:id/smp_play_button"))) {
            tapButton(androidDriver, playButton, false)
        }

        tapButton(androidDriver, transportControls, false)
        tapButton(androidDriver, transportControls, false)

        assertDisplayingElements(androidDriver,
                smpPauseButton,
                smpExitFullScreenButton,
                smpLiveIcon,
                smpVolumeButton,
                smpSeekBar
        )
    }

    @Test(priority = 15, description = "Test to check whether video plays in landscape mode")
    fun playingLandscape() {
        startTest("Checking Live Video in Landscape", "Checking the Video in Landscape Mode", "Live Video")
        androidDriver.rotate(ScreenOrientation.LANDSCAPE)
        tapButton(androidDriver, transportControls, false)
        tapButton(androidDriver, transportControls, false)

        assertDisplayingElements(androidDriver,
                smpPauseButton,
                smpExitFullScreenButton,
                smpLiveIcon,
                smpVolumeButton,
                smpSeekBar
        )
    }

    @Test(priority = 16, description = "Test to scrub video playback ")
    fun scrubbingVideoPlayback() {
        androidDriver.rotate(ScreenOrientation.PORTRAIT)
        startTest("Checking Live Video Scrubbing", "Checking the Live Video in Portrait Mode and seeking", "Live Video")
        seeking(smpSeekBar, .30, "forward")
        isElementPresent(androidDriver, By.id("bbc.mobile.news.uk.internal:id/smpSeekBar"))
        tapButton(androidDriver, smpExitFullScreenButton, false)
        pressBack()
    }

    @Test(priority = 17, description = "Test to check for search results")
    fun testSearchStories() {
        startTest("Search for an Topics", "Checking Search Topics", "Search")
        tapButton(androidDriver, searchButton, false)
        enterText(searchField, "India")
        waitFor(2000)

        val searchTopicsText = getText(searchHeading)
        //androidDriver.findElement(By.xpath("android.widget.TextView[@text='Topics (5)']")).text
        //getText( searchHeading)
        assertEquals(searchTopicsText, "Topics (5)", "matched")
        waitFor(1000)

        val searchRelatedHeadingText = getText(searchHeading2)
        assertEquals(searchRelatedHeadingText, "Articles related to \"India\"")

        tapButton(androidDriver, cancelSearch, false)
        val searchTopicsText1 = getText(searchHeading)
        assertEquals(searchTopicsText1, "In The News Now", "matched")

        waitFor(1000)
        val searchRelatedHeadingText2 = getText(searchHeading2)
        assertEquals(searchRelatedHeadingText2, "More Topics", "matched")

        //assertEquals(searchHeading4.getText(),"My Topics","matched");
        tapButton(androidDriver, backButton, false)

    }

    @Test(priority = 18, description = "Test to search for a Topic and navigate to topic page")
    fun testSelectSearchResult() {
        startTest("Navigate to Topic Detail Page", "Test to search for a Topic and navigate to topic page", "Search")
        tapButton(androidDriver, searchButton, false)
        searchField?.clear()
        enterText(searchField, searchText)
        waitFor(700)
        assertEquals(searchText, searchKeyword?.text, "Text Matched")
        tapButton(androidDriver, searchKeyword, false)

        assertEquals(searchText, getText(headlineTitle))
        tapButton(androidDriver, backButton, false)
        pressBack()
        tapButton(androidDriver, backButton, false)
    }

    @Test(priority = 19, description = "Test Checking an Topic and adding to MyNews")
    fun testSearchTopic() {
        startTest("Search and Adding Topic to Mynews", "Test Checking an Topic and adding to MyNews", "Search")
        tapButton(androidDriver, searchButton, false)
        // searchField.clear()
        enterText(searchField, "India")
        waitFor(700)
        tapButton(androidDriver, article, false)

        assertEquals(articleLayoutName?.text, articleLayoutName?.text, "Text Matched")
        assertEquals(articleLastUpdated?.text, articleLastUpdated?.text, "Test Matched")
        tapButton(androidDriver, myNewsAddTopics, false)
    }

    @Test(priority = 20, description = "Test Checking an Article page without an Item Image Badge")
    fun testArticleItemWithoutItemBadge() {
        startTest("Article without ItemImage Badge", "Test Checking an Article page without an Item Image Badge", "Search")
        scrollToElement(androidDriver, articleItemWithoutItemBadge)
        tapButton(androidDriver, articleItemWithoutItemBadge, false)

        var i = 0
        while (i < articleDetailPageLinks.size && i < articleItemWithImageBadge.size) {
            isElementPresent(androidDriver, By.id(articleDetailPageLinks[i]))
            assertEquals(articleItemWithoutImageBadge[i], androidDriver.findElement(By.id(articleDetailPageLinks[i])).text, "Test matched")
            i++
        }
        pressBack()
    }

    @Test(priority = 21, description = "Test Checking an Article page with an Item Image Badge")
    fun testArticleItemWithItemBadge() {
        startTest("Article with ItemImage Badge", "Checking an Article page without an Item Image Badge", "Search")
        scrollToElement(androidDriver, articleItemWithItemBadge)
        tapButton(androidDriver, articleItemWithItemBadge, false)
        assertDisplayingElements(androidDriver, articleImageBadge)
        assertEquals("EPA", articleImageBadge?.text, "Text Matched")

        var i = 0
        while (i < articleDetailPageLinks.size && i < articleItemWithImageBadge.size) {
            isElementPresent(androidDriver, By.id(articleDetailPageLinks[i]))
            assertEquals(articleItemWithImageBadge[i], androidDriver.findElement(By.id(articleDetailPageLinks[i])).text, "Test matched")
            i++
        }

        pressBack()
        tapButton(androidDriver, backButton, false)
        tapButton(androidDriver, cancelSearch, false)
    }

    @Test(priority = 22, description = "Test to search for an particular article")
    fun testSearchArticle() {
        startTest("Searching a Particular article", "Test to search for an particular article", "Search")
        tapButton(androidDriver, searchButton, false)
        // searchField.clear();
        enterText(searchField, "A rape victim's two-year wait for justice")
        //androidDriver.hideKeyboard();
        tapButton(androidDriver, articleSearch, false)
        waitFor(500)

        var i = 0
        while (i < articlePageDetail.size && i < articlePageDetailElements.size) {
            isElementPresent(androidDriver, By.id(articlePageDetailElements[i]))
            assertEquals(articlePageDetail[i], androidDriver.findElement(By.id(articlePageDetailElements[i])).text, "Test matched")
            i++
        }
        tapButton(androidDriver, navigateBack, false)
        tapButton(androidDriver, backButton, false)
    }

    @Test(priority = 23, description = "Test to search for an particular video article")
    fun testOnDemandVideoPlayback() {
        startTest("Playing a Particular OnDemand Video", "Test to search ana play a on-demand video", "OnDemandVideo")
        tapButton(androidDriver, search, false)
        enterText(searchField, "egypt court imposes jail")
        waitForScreenToLoad(androidDriver, videoArticleSearch, 3)

        assertEquals("Articles related to \"egypt court imposes jail\"", searchHeading?.text)
        //androidDriver.findElement(By.id("bbc.mobile.news.uk.internal:id/heading")).getText())
        elementDisplayed(androidDriver, androidDriver.findElement(By.id("bbc.mobile.news.uk.internal:id/contentCardTitle")))
        elementDisplayed(androidDriver, androidDriver.findElement(By.id("bbc.mobile.news.uk.internal:id/content_card_last_updated")))

        val videoTitle = videoArticleSearch?.text
        //val videolastupdated = androidDriver.findElement(By.id("bbc.mobile.news.uk.internal:id/content_card_last_updated")).text

        tapButton(androidDriver, videoArticleSearch, false)
        assertEquals(videoTitle, androidDriver.findElement(By.id("bbc.mobile.news.uk.internal:id/headlineTitle")).text)
        assertEquals("31 Dec 2018", androidDriver.findElement(By.id("bbc.mobile.news.uk.internal:id/headlineInfo")).text)

        var i = 0
        while (i < videoDetailPage.size && i < videoDetailPageText.size) {

            isElementPresent(androidDriver, By.id(videoDetailPage[i]))
            assertEquals(videoDetailPageText[i], androidDriver.findElement(By.id(videoDetailPage[i])).text)
            i++
        }
    }

    @Test(priority = 24, description = "Test to seek forward videoplayback")
    fun testSeekingVideoForward() {
        startTest("Seeking Video Forward", "Test to search ana play a on-demand video", "OnDemandVideo")
        tapButton(androidDriver, accessibilityPlay, false)
        seeking(smpSeekBar, .50, "forward")
        elapsedTimeForward = smpElapsedTime?.text
    }

    @Test(priority = 25, description = "Test to seek forward videoplayback")
    fun testSeekingVideoBackward() {
        startTest("Seeking Video Backward", "Test to search ana play a on-demand video", "OnDemandVideo")
        seeking(smpSeekBar, .30, "backward")
        elapsedTimeBackward = smpElapsedTime?.text
        assertNotEquals(elapsedTimeForward, elapsedTimeBackward)
    }

    @Test(priority = 26, description = "Test to check Related Stories and Topics of an Article")
    fun testRelatedStoriesArticle() {
        startTest("Checking for Related Story Article", "Test to check Related Stories of an Article", "Related Stories/Topics")
        scrollToElement(androidDriver, relatedStoriesArticle)
        elementDisplayed(androidDriver, relatedStories)
        tapButton(androidDriver, relatedStoriesArticle, false)
        for (i in 0 until mostReadPopularLinks.size) {
            isElementPresent(androidDriver, By.id(mostReadPopularLinks[i]))
        }
        if (shareStory?.isDisplayed!!) {
            verticalSwipe(androidDriver, "Up")
        }
        tapButton(androidDriver, navigateBack, false)
    }

    @Test(priority = 27, description = "Test to check Related Topics of an Article")
    fun testRelatedTopicArticle() {
        startTest("Checking for Related Topic Article", "Test to check Related Topics of an Article", "Related Stories/Topics")
        scrollToElement(androidDriver, relatedTopicsArticle)
        elementDisplayed(androidDriver, relatedTopics)
        tapButton(androidDriver, relatedTopicsArticle, false)
        assertEquals("Egypt", androidDriver.findElement(By.id("bbc.mobile.news.uk.internal:id/title")).text)
        assertEquals("Add topic", androidDriver.findElement(By.id("bbc.mobile.news.uk.internal:id/menu_follow")).getAttribute("contentDescription"))
        for (i in 0 until topicsPageElements.size) {
            isElementPresent(androidDriver, By.id(topicsPageElements[i]))
        }
        tapButton(androidDriver, backButton, false)
        pressBack()
        tapButton(androidDriver, backButton, false)
    }

    @Test(priority = 28, description = "Test to check the T&C , PrivacyPolicy from Menu options")
    fun testCheckTermsPrivacyPolicy() {
        startTest("Checking T&C Privacy Policy", "Checking T&C and privacy Policy", "Menu")
        tapButton(androidDriver, menuButton, false)
        tapButton(androidDriver, menuAppInfo, false)
        tapButton(androidDriver, termsConditions, false)
        pressBack()
        tapButton(androidDriver, privacyPolicy, false)
        pressBack()
        tapButton(androidDriver, backButton, false)
    }

    @Test(priority = 29, description = "Playing a video from Video page")
    fun testTopStoriesVideo() {
        startTest("Playing a OnDemand Video", "Test to play a video from Video page", "OnDemandVideo")
        tapButton(androidDriver, video, false)
        //commented out as Top Stories link isn't displayed
        //elementDisplayed(androidDriver, topStories)
//        scrollToElement(androidDriver, topStoriesVideo)
//        elementDisplayed(androidDriver, topStoriesVideoPlayTime)
//        elementDisplayed(androidDriver, topStoriesVideoContentCardTitle)
//        elementDisplayed(androidDriver, topStoriesVideoContentCardLink)
//        elementDisplayed(androidDriver, topStoriesVideoContentCardInfo)

        tapButton(androidDriver, topStoriesVideo, false)
        tapButton(androidDriver, accessibilityPlay, false)
        // androidDriver.findElementByAccessibilityId("Play").click();
        transportControls?.click()
        transportControls?.click()
        for (i in 0 until popularVideoElements.size) {
            isElementPresent(androidDriver, By.id(popularVideoElements[i]))
        }
        pressBack()
    }

    @Test(priority = 30, description = "App Backgrounding")
    fun testAppBackground() {
        startTest("App Background ", "Test to check backgrouding the app and reopen and checking same page opens", "App Background")
        popular?.click()
        androidDriver.runAppInBackground(Duration.ofSeconds(30))
        (androidDriver as StartsActivity).currentActivity()

        assertTrue(popular?.isSelected!!)
    }

    @Test(priority = 31, description = "Test to check the Popular page and also to check Most Read Displayed")
    fun testPopularPage() {
        startTest("Checking PopularPage", "Checking Popular Page", "Popular")
        tapButton(androidDriver, popular, false)
        elementDisplayed(androidDriver, mostRead)
    }

    @Test(priority = 32, description = "Test to select one Article from Most Read  Article from Popular Page")
    fun testMostReadPopular() {
        startTest("Checking Article from Most Read Section", "Checking Most Read Popular", "Popular")
        elementDisplayed(androidDriver, mostRead)
        tapButton(androidDriver, mostReadArticle, false)
    }


    @Test(priority = 33, description = "Test to check whether the Most Watched heading displayed in Popular Page")
    fun testMostWatched() {
        pressBack()
        startTest("Checking Most Popular Section", "Checking Most Watched", "Popular")
        scrollToElement(androidDriver, popularMostWatched)
        elementDisplayed(androidDriver, popularMostWatched)
    }

    @Test(priority = 34, description = "Test to check whether the Most Watched heading displayed in Popular Page")
    fun testMostWatchedArticle() {
        startTest("Checking Most Watched Article ", "Checking Most Watched", "Popular")
        scrollToElement(androidDriver, mostWatchedArticleVideo)
        System.out.println("The Element selected is  :- " + mostWatchedArticleVideo?.text)
        mostWatchedArticleVideo?.click()
        if (mostPopular?.isDisplayed!!) {
            verticalSwipe(androidDriver, "Up")
        }
        for (i in 0 until videoWallElements.size) {
            isElementPresent(androidDriver, By.id(videoWallElements[i]))
        }
        pressBack()
    }

    @Test(priority = 35, description = "Test re-arrange topics from bottom to top")
    fun testArrangeTopicsFromBottomToTop() {
        startTest("Re Arrange Topics from Bottom-to-Top", "Test re-arrange topics from bottom to top", "MyNews")
        tapButton(androidDriver, myNews, false)
        tapButton(androidDriver, editMyNews, false)

        val india = androidDriver.findElementsById("bbc.mobile.news.uk.internal:id/grab_handle")[5]
        val europe = androidDriver.findElementsById("bbc.mobile.news.uk.internal:id/grab_handle")[0]

        elementDragDrop(androidDriver, india, europe)
        readRecyclerView(androidDriver, "Topics After  Re-Ordering :- ")

        assertNotEquals("Rape in India", androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='1']/android.widget.RelativeLayout[@index='5']/android.widget.TextView[@index='1']")).text, "Test Didn't Matched")
        assertEquals("Rape in India", androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='1']/android.widget.RelativeLayout[@index='1']/android.widget.TextView[@index='1']")).text, "Test Matched")
        // assertEquals("European Union",androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='1']/android.widget.RelativeLayout[@index='2']/android.widget.TextView[@index='1']")).getText(), "Test Matched");
        assertEquals("YouTube", androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='1']/android.widget.RelativeLayout[@index='5']/android.widget.TextView[@index='1']")).text, "Test Matched")
        tapButton(androidDriver, removeTopics, false)
        tapButton(androidDriver, removeTopics, false)
        pressBack()
    }

    @Test(priority = 36, description = "Test to check the offline scenario of the app")
    fun testCheckOfflineScenario() {
        startTest("Going OffLine", "Checking apps offline scenario", "Offline")
        val state = androidDriver.setConnection(ConnectionStateBuilder()
                .withWiFiDisabled()
                .build())
        androidDriver.connection = state
//        waitForScreenToLoad(androidDriver,topStories,10);
//        tapButton(androidDriver,topStories,false);
//        scrollToElement(androidDriver, videoOfTheDayWatch);
//        tapButton(androidDriver, videoOfTheDayButton, false);
//        assertEquals("You're not connected to the internet.", snackbar.getText(), "Text Matched");
    }

    @Test(priority = 37, description = "Test to play a  video, while device offline")
    fun testPlayingVideoOffline() {
        startTest("VideoPlayback-Offline", "Checking the Video while device offline", "Offline")
        tapButton(androidDriver, video, false)
        tapButton(androidDriver, bbcNewsChannel, false)
        elementDisplayed(androidDriver, liveMediaItemCaption)
        elementDisplayed(androidDriver, navigateBack)
        elementDisplayed(androidDriver, shareStory)
        tapButton(androidDriver, accessibilityPlay, false)
        elementDisplayed(androidDriver, smpErrorMessage)
        elementDisplayed(androidDriver, smpErrorOkButton)
        elementDisplayed(androidDriver, smpRetryButton)
        val state = androidDriver.setConnection(ConnectionStateBuilder()
                .withWiFiEnabled()
                .build())
        androidDriver.connection = state
        System.out.println("The Connection state is " + state.isWiFiEnabled)
        waitFor(1000)
        assertTrue(state.isWiFiEnabled)
        pressBack()
        tapButton(androidDriver, myNews, false)
        tapButton(androidDriver, popular, false)
    }

    @Test(priority = 38, description = "Test to play a  video, while device online")
    fun testPlayingVideoOnLine() {
        startTest("VideoPlayback-Online", "Checking the Video while device Online", "Offline")
        tapButton(androidDriver, video, false)
        tapButton(androidDriver, bbcNewsChannel, false)
        tapButton(androidDriver, accessibilityPlay, false)
        tapButton(androidDriver, navigateBack, false)
    }

    @Test(priority = 39, description = "Test to select An Article from the England Topics under MyNews ")
    fun testSelectArticleTopic() {
        startTest("Selecting a Article from Africa Topics", "Test to select An Article from the Africa Topics under MyNews", "MyNews")
        tapButton(androidDriver, myNews, false)
        tapButton(androidDriver, englandTopic, false)
        tapButton(androidDriver, topicArticle, false)
        assertDisplayingElements(androidDriver, englandTopic)
        pressBack()
    }

    @Test(priority = 40, description = "Test to select An Video Article from the England Topics under MyNews ")
    fun testSelectVideoArticleTopic() {
        startTest("Select a Video Article from Africa Topic", "Test to select An Video Article from the Africa Topics under MyNews", "MyNews")
        scrollToElement(androidDriver, myNewsRecyclerView)
        tapButton(androidDriver, topicVideoArticle, false)
        assertDisplayingElements(androidDriver, englandTopic)

        for (i in 0 until videoWallElements.size) {
            isElementPresent(androidDriver, By.id(videoWallElements[i]))
        }

        tapButton(androidDriver, accessibilityPlay, false)
        waitFor(1300)

        for (i in 0 until playbackControls.size) {
            isElementPresent(androidDriver, By.id(playbackControls[i]))
        }

        pressBack()
        tapButton(androidDriver, backButton, false)
    }

    /**
     * commented out as Video of the day isn't displayed
     */
//    @Test(priority = 42, description = "Test to check the offline scenario of the app")
//    fun testCheckOnlineScenario() {
//        startTest("VideOfTheDay - Online", "Checking apps offline scenario", "Offline")
//        tapButton(androidDriver, topStories, false)
//        scrollToElement(androidDriver, videoOfTheDayWatch)
//        tapButton(androidDriver, videoOfTheDayButton, false)
//        //extenttestReport.isElementPresent(androidDriver,By.id("bbc.mobile.news.uk:id/snackbar_text"));
//        pressBack()
//    }

    @AfterMethod
    fun getResult(result: ITestResult) {
        getTestResult(androidDriver, result)
    }

    @AfterTest
    fun tearDown() {
        publishReport()
        androidDriver.closeApp()
        androidDriver.removeApp("bbc.mobile.news.uk.internal")
        androidDriver.quit()
    }
}
