package com.bbcnews.automation.scripts

import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.checkConnection
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.createAReportHive
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.elementDisplayed
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.elementDragDrop
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.elementIsSelected
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.enterText
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.getTestResult
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.getText
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.isElementPresent
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.isElementSelected
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.publishReport
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.readRecyclerView
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.scrollToElement
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.scrollToEndOfStories
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
import com.bbcnews.automation.pageobjects.BasePageObject.articleDetailPageLinksRelease
import com.bbcnews.automation.pageobjects.BasePageObject.articleImageBadge
import com.bbcnews.automation.pageobjects.BasePageObject.articleItemWithImageBadge
import com.bbcnews.automation.pageobjects.BasePageObject.articleItemWithItemBadge
import com.bbcnews.automation.pageobjects.BasePageObject.articleItemWithoutImageBadge
import com.bbcnews.automation.pageobjects.BasePageObject.articleItemWithoutItemBadge
import com.bbcnews.automation.pageobjects.BasePageObject.articleLastUpdated
import com.bbcnews.automation.pageobjects.BasePageObject.articleLayoutName
import com.bbcnews.automation.pageobjects.BasePageObject.articlePageDetail
import com.bbcnews.automation.pageobjects.BasePageObject.articlePageDetailElementsRelease
import com.bbcnews.automation.pageobjects.BasePageObject.articleSearch
import com.bbcnews.automation.pageobjects.BasePageObject.backButton
import com.bbcnews.automation.pageobjects.BasePageObject.cancelSearch
import com.bbcnews.automation.pageobjects.BasePageObject.errorRetryButton
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
import com.bbcnews.automation.pageobjects.BasePageObject.topicsPageElementsRelease
import com.bbcnews.automation.pageobjects.BasePageObject.video
import com.bbcnews.automation.pageobjects.HomePageObject.checkBackLater
import com.bbcnews.automation.pageobjects.HomePageObject.educationTopics
import com.bbcnews.automation.pageobjects.HomePageObject.familyEducationTopic
import com.bbcnews.automation.pageobjects.HomePageObject.newsStreamProgress
import com.bbcnews.automation.pageobjects.HomePageObject.promoCounter
import com.bbcnews.automation.pageobjects.HomePageObject.technologyTopic
import com.bbcnews.automation.pageobjects.HomePageObject.videoOfTheDayButton
import com.bbcnews.automation.pageobjects.HomePageObject.videoOfTheDayPromoSummary
import com.bbcnews.automation.pageobjects.HomePageObject.videoOfTheDayTitle
import com.bbcnews.automation.pageobjects.HomePageObject.videoOfTheDayWatch
import com.bbcnews.automation.pageobjects.HomePageObject.videoOfTheDayWatchNext
import com.bbcnews.automation.testutils.TestUtility.emptyFolder
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.StartsActivity
import io.appium.java_client.android.connection.ConnectionStateBuilder
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import io.appium.java_client.remote.AndroidMobileCapabilityType
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
import java.net.URL
import java.time.Duration
import java.util.*

class BBCNewsReleaseBuildRegressionTest {

    private var capabilities = DesiredCapabilities()
    private var deviceid: String? = null
    private var deviceName: String? = null
    private var appPath: String? = null
    private var appiumPort: String? = null

    private lateinit var homePageObject: HomePageObject
    private lateinit var androidDriver: AndroidDriver<MobileElement>
    private lateinit var myNewsPageObject: MyNewsPageObject
    private lateinit var videoPageObject: VideoPageObjects
    private lateinit var popularPageObject: PopularPageObjects
    private lateinit var myTopicsPageObject: MyTopicsPageObject

    @BeforeTest
    private fun runTest() {
        readDeviceDetailsCommandPrompt()
        setUp()
        checkConnection(androidDriver)
        initialiseObjects()
    }

    private fun readDeviceDetailsCommandPrompt() {
        //  Deviceos_Name = System.getProperty("DeviceOS");
        // deviceosName = getProperty("DeviceOS")
        deviceid = System.getProperty("DeviceID")
        deviceName = System.getProperty("DeviceName")
        appPath = System.getProperty("AppPath")
        appiumPort = System.getProperty("AppiumPort")
        // println("Passed The Device OS is $deviceosName")
        println("Passed The Device ID is $deviceid")
        println("Passed The Device Name is $deviceName")
        println("Passed The Appium port is $appiumPort")
        println("Passed The Application path  is $appPath")
    }

    private fun setUp() {
        //commented out to start appium server, as this taken care by hive, to run locally un-comment below line of code
        //appiumStart.startAppium(Integer.parseInt(Appium_Port));
        //  AppiumManager.startAppium(Integer.parseInt(Appium_Port));
        val appiumUrl = "http://127.0.0.1:$appiumPort/wd/hub"

        System.out.println("Appium Server Address : - $appiumUrl")
        capabilities = DesiredCapabilities()
        capabilities.setCapability(MobileCapabilityType.UDID, deviceid)
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "bbcnews")
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2")
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android")
        capabilities.setCapability("appiumversion", "1.8.1")
        capabilities.setCapability("app", appPath)
        capabilities.setCapability("appPackage", "bbc.mobile.news.uk")
        capabilities.setCapability("appActivity", "bbc.mobile.news.v3.app.TopLevelActivity")
        capabilities.setCapability("autoAcceptAlerts", true)
        capabilities.setCapability("--session-override", true)
        capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true)
        androidDriver = AndroidDriver(URL(appiumUrl), capabilities)
    }


    private fun initialiseObjects() {
        PageFactory.initElements(AppiumFieldDecorator(androidDriver), homePageObject)

        myNewsPageObject = MyNewsPageObject()
        PageFactory.initElements(AppiumFieldDecorator(androidDriver), myNewsPageObject)

        PageFactory.initElements(AppiumFieldDecorator(androidDriver), BasePageObject)

        videoPageObject = VideoPageObjects()
        PageFactory.initElements(AppiumFieldDecorator(androidDriver), videoPageObject)

        popularPageObject = PopularPageObjects()
        PageFactory.initElements(AppiumFieldDecorator(androidDriver), popularPageObject)

        myTopicsPageObject = MyTopicsPageObject()
        PageFactory.initElements(AppiumFieldDecorator(androidDriver), myTopicsPageObject)

        emptyFolder(screenshotPath)

        createAReportHive("Regression", deviceName.toString(), deviceid.toString())

        androidDriver.context("NATIVE_APP")

        val screenshotPath = File(screenshotPath).absolutePath
        System.out.println("The ScreenShot Path is $screenshotPath")

        val orientation = androidDriver.orientation
        if (orientation != ScreenOrientation.LANDSCAPE) {
        } else {
            androidDriver.rotate(ScreenOrientation.PORTRAIT)
        }
    }

    @Test(priority = 1, description = "Launching the app")
    fun testOpenNewsApp() {
        tapButton(androidDriver, okButton, false)
        tapButton(androidDriver, noThanksButton, false)

        if (errorRetryButton?.isDisplayed!!) {
            tapButton(androidDriver, errorRetryButton, false)
        }
    }

    @Test(priority = 2, description = "Test to check whether all links present on Home Page")
    fun testTopStories() {
        startTest("Checking the HomePage", "Checking the HomePage", "HomePage")
        isElementSelected(topStories)
        elementDisplayed(androidDriver, topStories)
        elementDisplayed(androidDriver, myNews)
        elementDisplayed(androidDriver, popular)
        elementDisplayed(androidDriver, video)
        elementDisplayed(androidDriver, search)
        elementDisplayed(androidDriver, menuButton)
    }

    @Test(priority = 3, description = "Test to check Video of the day displayed and swipe through all the videos")
    fun testVideoOfTheDayDisplayed() {
        startTest("VideoOfTheDay", "Scroll to a Video of the day", "HomePage")
        waitFor(1000)
        scrollToElement(androidDriver, videoOfTheDayWatch)

        assertDisplayingElements(androidDriver,
                videoOfTheDayWatchNext,
                promoCounter,
                videoOfTheDayPromoSummary,
                videoOfTheDayTitle
        )

        assertEquals("Videos of the day", videoOfTheDayTitle?.text)
        assertEquals("WATCH", videoOfTheDayWatchNext?.text)
        assertEquals("7", promoCounter?.text)
        assertEquals("Swipe through the latest news videos", videoOfTheDayPromoSummary?.text)

        tapButton(androidDriver, videoOfTheDayButton, false)
        scrollToEndOfStories(androidDriver, newsStreamProgress, videoPageObject.videosOfTheDayRelease, checkBackLater)
        pressBack()
    }

    @Test(priority = 4, description = "Test to scroll to a topic on home page and select a particular topic and add to MyNews")
    fun testToCheckTopicsTopStores() {
        startTest("Scrolling to topics", "Scroll to a Topics on Home Page", "HomePage")

        //scrolls to Reality Check topics on Top Stories page
        scrollToElement(androidDriver, educationTopics)
        tapButton(androidDriver, educationTopics, false)

        if (!isElementPresent(androidDriver, By.id("bbc.mobile.news.uk.internal:id/menu_follow"))) {
            System.out.println("Scrolling up")
            verticalSwipe(androidDriver, "Up")
        }

        assertDisplayingElements(androidDriver, familyEducationTopic)
        System.out.println("Topics is :-" + familyEducationTopic?.text)

        for (i in 0 until topicsPageElementsRelease.size) {
            isElementPresent(androidDriver, By.id(topicsPageElementsRelease[i]))
        }
        tapButton(androidDriver, myNewsPageObject.myNewsAddTopics, false)
        textPresent(androidDriver, "Family & Education", "added to")
        assertDisplayingElements(androidDriver, myNewsPageObject.manageYourTopics)
        tapButton(androidDriver, backButton, false)

        //scrolls to health topics on Top Stories page
        scrollToElement(androidDriver, technologyTopic)
        tapButton(androidDriver, technologyTopic, false)

        if (!isElementPresent(androidDriver, By.id("bbc.mobile.news.uk.internal:id/menu_follow"))) {
            System.out.println("Scrolling up")
            verticalSwipe(androidDriver, "Up")
        }

        System.out.println("The Topic is: " + technologyTopic?.text)

        assertDisplayingElements(androidDriver, technologyTopic)
        System.out.println("Topics is :-" + technologyTopic?.text)

        for (i in 0 until topicsPageElementsRelease.size) {
            isElementPresent(androidDriver, By.id(topicsPageElementsRelease[i]))
        }

        tapButton(androidDriver, myNewsPageObject.myNewsAddTopics, false)
        textPresent(androidDriver, "Technology", "added to")
        assertDisplayingElements(androidDriver, myNewsPageObject.manageYourTopics)
        tapButton(androidDriver, backButton, false)
    }

    @Test(priority = 5, description = "Test To Check the topics added from top stories are displayed under MyNews")
    fun testMyNewsTopStoriesTopics() {
        startTest("Removing Added Topics", "Test to check Topics on MyNews page", "MyNews")
        tapButton(androidDriver, myNews, false)
        tapButton(androidDriver, myNewsPageObject.editMyNews, false)

        assertDisplayingElements(androidDriver,
                technologyTopic,
                familyEducationTopic
        )

        tapButton(androidDriver, myNewsPageObject.removeTopics, false)
        textPresent(androidDriver, "Family & Education", "removed from")
        tapButton(androidDriver, myNewsPageObject.removeTopics, false)
        textPresent(androidDriver, "Technology", "removed from")
        // pressBack()
        tapButton(androidDriver, backButton, false)
    }

    @Test(priority = 6, description = "Test for Checking whether Location service works")
    @Story("MyNews")
    fun testAllowLocation() {
        startTest("Allowing Location Service ", "Checking whether Location service works ", "MyNews")
        tapButton(androidDriver, myNews, false)//,file.getAbsolutePath());
        tapButton(androidDriver, myNewsPageObject.myNewsStartButton, false)
        tapButton(androidDriver, myNewsPageObject.allowLocation, false)
        tapButton(androidDriver, myNewsPageObject.allowLocationPermission, false)
        pressBack()
    }

    @Test(priority = 7, description = "Test to check MyNews page and asserting whether all links displayed")
    fun testMyNews() {
        startTest("Checking Elements on MyNews Page", "Test to check MyNews page", "MyNews")
        tapButton(androidDriver, myNews, false)
        elementDisplayed(androidDriver, myNewsPageObject.myNewsSummary)
        elementDisplayed(androidDriver, myNewsPageObject.myNewsTitle)
        elementDisplayed(androidDriver, myNewsPageObject.addNewsButton)
        assertEquals(myNewsPageObject.myNewsTitleText, myNewsPageObject.myNewsTitle.text, "Text Mesaaged")
        assertEquals(myNewsPageObject.myNewsSummaryText, myNewsPageObject.myNewsSummary.text, "Text Mesaaged")
    }

    // @Test(dependsOnMethods = {"testMyNews"})
    @Test(priority = 8, description = "Test to check on My News Add Topic screen and asserting all links are displayed")
    fun testAddingTopicsPage() {
        startTest("Checking Elements on Edit Mynews Page", "Test to check Edit MyNews page", "MyNews")
        tapButton(androidDriver, myNewsPageObject.myNewsStartButton, false)
        elementIsSelected(myNewsPageObject.addTopics)
        elementDisplayed(androidDriver, myNewsPageObject.myTopics)
        //elementDisplayed(androidDriver, myNewsPageObject.locationButton);
        elementDisplayed(androidDriver, myNewsPageObject.editMyTopics)
        elementDisplayed(androidDriver, myNewsPageObject.localNews)
        tapButton(androidDriver, myNewsPageObject.myTopics, false)//,file.getAbsolutePath());
        elementIsSelected(myNewsPageObject.myTopics)
        assertEquals(myNewsPageObject.myTopicEmptyViewText, myNewsPageObject.myTopicEmptyView.text, "Text Mesaaged")
    }


    // @Test(dependsOnMethods = {"testAddingTopicsPage"})
    @Test(priority = 9, description = "Test to add Topics under MyNews")
    fun testAddingTopicsToMyNewsPage() {
        startTest("Adding Topics ", "Test to check added Topics to MyNews page", "MyNews")
        tapButton(androidDriver, myNewsPageObject.addTopics, false)

        assertEquals("London", myNewsPageObject.localNewsDisplayed.text)
        elementDisplayed(androidDriver, myNewsPageObject.localNewsDisplayed)

        scrollToElement(androidDriver, myTopicsPageObject.addEnglandTopicButton)
        tapButton(androidDriver, myTopicsPageObject.addEnglandTopicButton, false)
        textPresent(androidDriver, "England", "added to")

        scrollToElement(androidDriver, myTopicsPageObject.addAfricaTopicButton)
        tapButton(androidDriver, myTopicsPageObject.addAfricaTopicButton, false)

        scrollToElement(androidDriver, myTopicsPageObject.addEuTopicButton)
        tapButton(androidDriver, myTopicsPageObject.addEuTopicButton, false)

        scrollToElement(androidDriver, myTopicsPageObject.addMortgagesTopicButton)
        tapButton(androidDriver, myTopicsPageObject.addMortgagesTopicButton, false)
        textPresent(androidDriver, "Mortgages", "added to")

        scrollToElement(androidDriver, myTopicsPageObject.addYouTubeTopicButton)
        tapButton(androidDriver, myTopicsPageObject.addYouTubeTopicButton, false)
        textPresent(androidDriver, "YouTube", "added to")
    }

    @Test(priority = 10, description = "Test to check whether selected topics are displayed under Added Topics in MyNews")
    fun testCheckAddedTopics() {
        startTest("My Topics page", "Test to check added Topics MyNews page", "MyNews")
        tapButton(androidDriver, myNewsPageObject.myTopics, false)
        elementDisplayed(androidDriver, myTopicsPageObject.englandTopic)
        elementDisplayed(androidDriver, myTopicsPageObject.africaTopic)
        elementDisplayed(androidDriver, myTopicsPageObject.europeanTopic)
        elementDisplayed(androidDriver, myTopicsPageObject.mortgagesTopic)
        elementDisplayed(androidDriver, myTopicsPageObject.youTubeTopic)
    }


    @Test(priority = 11, description = "Test to display the Ordering of the Topics")
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

    @Test(priority = 12, description = "Test to select each of the topics displayed under MyNews ")
    fun testSelectedAddedTopics() {
        startTest("Checking Added Topics on Mynews page", "Selecting Added Topics", "MyNews")
        waitFor(1000)
        elementDisplayed(androidDriver, myTopicsPageObject.englandTopic)
        elementDisplayed(androidDriver, myTopicsPageObject.europeanTopic)
        elementDisplayed(androidDriver, myTopicsPageObject.africaTopic)
        tapButton(androidDriver, myTopicsPageObject.englandTopic, false)
        for (i in 0 until topicsPageElementsRelease.size) {
            isElementPresent(androidDriver, By.id(topicsPageElementsRelease[i]))
        }
        pressBack()
        tapButton(androidDriver, myTopicsPageObject.europeanTopic, false)
        for (i in 0 until topicsPageElementsRelease.size) {
            isElementPresent(androidDriver, By.id(topicsPageElementsRelease[i]))
        }
        pressBack()
        tapButton(androidDriver, myTopicsPageObject.africaTopic, false)
        for (i in 0 until topicsPageElementsRelease.size) {
            isElementPresent(androidDriver, By.id(topicsPageElementsRelease[i]))
        }
    }

    @Test(priority = 13, description = "Test to select An Article from the Africa Topics under MyNews ")
    fun testSelectArticleAsiaTopic() {
        startTest("Selecting a Article from Asia Topics", "Test to select An Article from the Asia Topics under MyNews", "MyNews")
        tapButton(androidDriver, myNewsPageObject.topicArticle, false)
        pressBack()
    }

    @Test(priority = 14, description = "Test to select An Video Article from the Africa Topics under MyNews ")
    fun testSelectVideoArticleAsiaTopic() {
        startTest("Select a Video Article from Asia Topic", "Test to select An Video Article from the Asia Topics under MyNews", "MyNews")
        scrollToElement(androidDriver, myNewsPageObject.myNewsRecyclerView)
        tapButton(androidDriver, myNewsPageObject.topicVideoArticle, false)
        for (i in 0 until videoPageObject.videoWallElementsRelease.size) {
            isElementPresent(androidDriver, By.id(videoPageObject.videoWallElementsRelease[i]))
        }
        tapButton(androidDriver, videoPageObject.accessibilityPlay, false)
        waitFor(1300)
        for (i in 0 until videoPageObject.playbackControlsRelease.size) {
            isElementPresent(androidDriver, By.id(videoPageObject.playbackControlsRelease[i]))
        }
        pressBack()
        tapButton(androidDriver, backButton, false)
    }


    @Test(priority = 15, description = "Test to re-arrange topics from top to bottom")
    @Throws(Exception::class)
    fun testCheckReOrderingOfTopicsAdded() {
        startTest("Re Arrange Topics from Top-to-Bottom", "Test to re-arrange topics from top to bottom", "MyNews")
        tapButton(androidDriver, myNewsPageObject.editMyNews, false)

        val africa = androidDriver.findElementsById("bbc.mobile.news.uk.internal:id/grab_handle")[1]
        val youTubeTopic = androidDriver.findElementsById("bbc.mobile.news.uk.internal:id/grab_handle")[4]

        elementDragDrop(androidDriver, africa, youTubeTopic)

        readRecyclerView(androidDriver, "Topics After  Re-Ordering :- ")

        System.out.println("The Text at get(3) is " + androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='1']/android.widget.RelativeLayout[@index='3']/android.widget.TextView[@index='1']")).text)
        assertEquals("Africa", androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='1']/android.widget.RelativeLayout[@index='3']/android.widget.TextView[@index='1']")).text, "Test Matched")

//        System.out.println("The Text at get(0) is " + androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='1']/android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='1']")).text)
//        Assert.assertNotEquals("Brexit", androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='1']/android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='1']")).text, "Test Matched")

        pressBack()
    }

    //@Test(dependsOnMethods = {"testcheckMostWatched"})
    @Test(priority = 16, description = "Test to check whether the menu options are displayed")
    fun testMenuItems() {
        startTest("Checking the MenuItems", "Checking Menu Items ", "Menu")
        tapButton(androidDriver, menuButton, false)
        elementDisplayed(androidDriver, settings)
        elementDisplayed(androidDriver, internalSettings)
        elementDisplayed(androidDriver, otherBbcApps)
        elementDisplayed(androidDriver, appInfo)
        pressBack()
    }

    @Test(priority = 17, description = "Test to play a Live video from Video page and asserting on whether playback controls are displayed")
    fun testVideoPage() {
        startTest("Playing a Live Video", "Checking the Video Page", "Live Video")
        tapButton(androidDriver, video, false)
        tapButton(androidDriver, videoPageObject.bbcNewsChannel, false)
        elementDisplayed(androidDriver, videoPageObject.liveMediaItemCaption)
        elementDisplayed(androidDriver, navigateBack)
        elementDisplayed(androidDriver, shareStory)
        tapButton(androidDriver, videoPageObject.accessibilityPlay, false)
        waitFor(1400)
        tapButton(androidDriver, videoPageObject.smpFullScreenButton, false)
        waitFor(1400)
        try {
            if (isElementPresent(androidDriver, By.id("bbc.mobile.news.uk:id/smp_play_button"))) {
                tapButton(androidDriver, videoPageObject.playButton, false)
            }
        } catch (e: NoSuchElementException) {
        }

        tapButton(androidDriver, videoPageObject.transportControls, false)
        tapButton(androidDriver, videoPageObject.transportControls, false)
        elementDisplayed(androidDriver, videoPageObject.smpPauseButton)
        elementDisplayed(androidDriver, videoPageObject.smpExitFullScreenButton)
        elementDisplayed(androidDriver, videoPageObject.smpLiveIcon)
        elementDisplayed(androidDriver, videoPageObject.smpVolumeButton)
        elementDisplayed(androidDriver, videoPageObject.smpSeekBar)
    }

    @Test(priority = 18, description = "Test to check whether video plays in landscape mode")
    fun playingLandscape() {
        startTest("Checking live video in landscape", "Checking video in landscape mode", "Live Video")
        androidDriver.rotate(ScreenOrientation.LANDSCAPE)
        tapButton(androidDriver, videoPageObject.transportControls, false)
        tapButton(androidDriver, videoPageObject.transportControls, false)
        elementDisplayed(androidDriver, videoPageObject.smpPauseButton)
        elementDisplayed(androidDriver, videoPageObject.smpExitFullScreenButton)
        elementDisplayed(androidDriver, videoPageObject.smpLiveIcon)
        elementDisplayed(androidDriver, videoPageObject.smpVolumeButton)
        elementDisplayed(androidDriver, videoPageObject.smpSeekBar)
    }

    @Test(priority = 19, description = "Test to scrub video playback ")
    fun scrubbingVideoPlayback() {
        androidDriver.rotate(ScreenOrientation.PORTRAIT)
        startTest("Checking Live Video Scrubbing", "Checking the Live Video in Portrait Mode and seeking", "Live Video")
        seeking(videoPageObject.smpSeekBar, .30, "forward")
        isElementPresent(androidDriver, By.id("bbc.mobile.news.uk.internal:id/smpSeekBar"))
        tapButton(androidDriver, videoPageObject.smpExitFullScreenButton, false)
        pressBack()
    }

    @Test(priority = 20, description = "Test to check for search results")
    fun testSearchStories() {
        startTest("Search for an Topics", "Checking Search Topics", "Search")
        tapButton(androidDriver, searchButton, false)
        enterText(searchField, "India")
        waitFor(800)

        val searchTopicsText = getText(searchHeading)
        assertEquals(searchTopicsText, "Topics (5)", "matched")
        waitFor(800)

        val searchRelatedHeadingText = getText(searchHeading2)
        assertEquals(searchRelatedHeadingText, "Articles related to \"India\"")

        tapButton(androidDriver, cancelSearch, false)

        val searchTopicsText1 = getText(searchHeading)
        assertEquals(searchTopicsText1, "In The News Now", "matched")
        waitFor(800)

        val searchRelatedHeadingText2 = getText(searchHeading2)
        assertEquals(searchRelatedHeadingText2, "More Topics", "matched")

        //Assert.assertEquals(searchHeading4.getText(),"My Topics","matched");
        tapButton(androidDriver, backButton, false)
    }

    @Test(priority = 21, description = "Test to search for a Topic and navigate to topic page")
    fun testSelectSearchResult() {
        startTest("Navigate to Topic Detail Page", "Test to search for a Topic and navigate to topic page", "Search")
        tapButton(androidDriver, searchButton, false)
        searchField?.clear()
        enterText(searchField, searchText)
        waitFor(700)
        assertEquals(searchText, searchKeyword?.text, "Text Matched")
        tapButton(androidDriver, searchKeyword, false)
        val title = getText(headlineTitle)
        assertEquals(searchText, title)
        tapButton(androidDriver, backButton, false)
        pressBack()
        tapButton(androidDriver, backButton, false)
    }

    @Test(priority = 22, description = "Test Checking an Topic and adding to MyNews")
    fun testSearchTopic() {
        startTest("Search and Adding Topic to Mynews", "Test Checking an Topic and adding to MyNews", "Search")
        tapButton(androidDriver, searchButton, false)
        searchField?.clear()
        enterText(searchField, "India")
        waitFor(700)
        tapButton(androidDriver, article, false)

        assertEquals("The women who fought to ban alcohol", articleLayoutName?.text)
        assertEquals("4th Jan", articleLastUpdated?.text)
        tapButton(androidDriver, myNewsPageObject.myNewsAddTopics, false)
    }

    @Test(priority = 23, description = "Test Checking an Article page without an Item Image Badge")
    fun testArticleItemWithoutItemBadge() {
        startTest("Article without ItemImage Badge", "Test Checking an Article page without an Item Image Badge", "Search")
        scrollToElement(androidDriver, articleItemWithoutItemBadge)
        tapButton(androidDriver, articleItemWithoutItemBadge, false)

        var i = 0
        while (i < articleDetailPageLinksRelease.size && i < articleItemWithImageBadge.size) {
            isElementPresent(androidDriver, By.id(articleDetailPageLinksRelease[i]))
            assertEquals(articleItemWithoutImageBadge[i], androidDriver.findElement(By.id(articleDetailPageLinksRelease[i])).text, "Test matched")
            i++
        }

        pressBack()
    }

    @Test(priority = 24, description = "Test Checking an Article page with an Item Image Badge")
    fun testArticleItemWithItemBadge() {
        startTest("Article with ItemImage Badge", "Checking an Article page without an Item Image Badge", "Search")
        scrollToElement(androidDriver, articleItemWithItemBadge)
        tapButton(androidDriver, articleItemWithItemBadge, false)
        elementDisplayed(androidDriver, articleImageBadge)
        assertEquals("EPA", articleImageBadge?.text, "Text Matched")
        var i = 0
        while (i < articleDetailPageLinksRelease.size && i < articleItemWithImageBadge.size) {
            isElementPresent(androidDriver, By.id(articleDetailPageLinksRelease[i]))
            assertEquals(articleItemWithImageBadge[i], androidDriver.findElement(By.id(articleDetailPageLinksRelease[i])).text, "Test matched")
            i++
        }

        pressBack()
        tapButton(androidDriver, backButton, false)
        tapButton(androidDriver, cancelSearch, false)
    }


    @Test(priority = 25, description = "Test to search for an particular article")
    fun testSearchArticle() {
        startTest("Searching a Particular article", "Test to search for an particular article", "Search")
        tapButton(androidDriver, searchButton, false)
        // searchField.clear();
        enterText(searchField, "A rape victim's two-year wait for justice")
        //androidDriver.hideKeyboard();
        tapButton(androidDriver, articleSearch, false)
        waitFor(500)

        var i = 0
        while (i < articlePageDetail.size && i < articlePageDetailElementsRelease.size) {
            isElementPresent(androidDriver, By.id(articlePageDetailElementsRelease[i]))
            assertEquals(articlePageDetail[i], androidDriver.findElement(By.id(articlePageDetailElementsRelease[i])).text, "Test matched")
            i++
        }
        tapButton(androidDriver, navigateBack, false)
        tapButton(androidDriver, backButton, false)
    }

    @Test(priority = 26, description = "Test to search for an particular video article")
    fun testOnDemandVideoPlayback() {
        startTest("Playing a Particular OnDemand Video", "Test to search ana play a on-demand video", "OnDemandVideo")
        tapButton(androidDriver, search, false)
        enterText(searchField, "Egypt court imposes jail")
        waitForScreenToLoad(androidDriver, videoPageObject.videoArticleSearch, 3)
        // androidDriver.hideKeyboard();
        // scrollToElement(androidDriver, videoPageObject.videoArticleSearch);
        tapButton(androidDriver, videoPageObject.videoArticleSearch, false)
        //waitForScreenToLoad(androidDriver, videoPageObject.accessibilityPlay, 3);
        var i = 0
        while (i < videoPageObject.videoDetailPageRelease.size && i < videoPageObject.videoDetailPageText.size) {

            isElementPresent(androidDriver, By.id(videoPageObject.videoDetailPageRelease[i]))
            assertEquals(videoPageObject.videoDetailPageText[i], androidDriver.findElement(By.id(videoPageObject.videoDetailPageRelease[i])).text)
            i++
        }
    }

    @Test(priority = 27, description = "Test to seek forward videoplayback")
    fun testSeekVideoForward() {
        startTest("Seeking Video Forward", "Test to search ana play a on-demand video", "OnDemandVideo")
        tapButton(androidDriver, videoPageObject.accessibilityPlay, false)
        seeking(videoPageObject.smpSeekBar, .50, "forward")
        videoPageObject.elapsedTimeForward = videoPageObject.smpElapsedTime.text
    }

    @Test(priority = 28, description = "Test to seek forward videoplayback")
    fun testSeekVideoBack() {
        startTest("Seeking Video Backward", "Test to search ana play a on-demand video", "OnDemandVideo")
        seeking(videoPageObject.smpSeekBar, .30, "backward")
        videoPageObject.elapsedTimeBackward = videoPageObject.smpElapsedTime.text
        assertNotEquals(videoPageObject.elapsedTimeForward, videoPageObject.elapsedTimeBackward)
    }

    @Test(priority = 29, description = "Test to check Related Stories and Topics of an Article")
    fun testRelatedStoriesArticle() {
        startTest("Checking for Related Story Article", "Test to check Related Stories of an Article", "Related Stories/Topics")
        scrollToElement(androidDriver, popularPageObject.relatedStoriesArticle)
        elementDisplayed(androidDriver, relatedStories)
        tapButton(androidDriver, popularPageObject.relatedStoriesArticle, false)
        for (i in 0 until popularPageObject.mostReadPopularLinksRelease.size) {
            isElementPresent(androidDriver, By.id(popularPageObject.mostReadPopularLinksRelease[i]))
        }
        if (shareStory?.isDisplayed!!) {
            verticalSwipe(androidDriver, "Up")
        }
        tapButton(androidDriver, navigateBack, false)
    }

    @Test(priority = 30, description = "Test to check Related Topics of an Article")
    fun testRelatedTopicArticle() {
        startTest("Checking for Related Topic Article", "Test to check Related Topics of an Article", "Related Stories/Topics")
        scrollToElement(androidDriver, popularPageObject.relatedTopicsArticle)
        elementDisplayed(androidDriver, relatedTopics)
        tapButton(androidDriver, popularPageObject.relatedTopicsArticle, false)
        assertEquals("Egypt", androidDriver.findElement(By.id("bbc.mobile.news.uk.internal:id/title")).text)
        assertEquals("Add topic", androidDriver.findElement(By.id("bbc.mobile.news.uk.internal:id/menu_follow")).getAttribute("contentDescription"))
        for (i in 0 until topicsPageElementsRelease.size) {
            isElementPresent(androidDriver, By.id(topicsPageElementsRelease[i]))
        }
        tapButton(androidDriver, backButton, false)
        pressBack()
        tapButton(androidDriver, backButton, false)
    }

    @Test(priority = 31, description = "Test to check the T&C , PrivacyPolicy from Menu options")
    fun testTermsPrivacyPolicy() {
        startTest("Checking T&C Privacy Policy", "Checking T&C and privacy Policy", "Menu")
        tapButton(androidDriver, menuButton, false)
        tapButton(androidDriver, menuAppInfo, false)
        tapButton(androidDriver, termsConditions, false)
        pressBack()
        tapButton(androidDriver, privacyPolicy, false)
        pressBack()
        tapButton(androidDriver, backButton, false)
    }

    @Test(priority = 32, description = "Playing a video from Video page")
    fun testTopStoriesVideo() {
        startTest("Playing a OnDemand Video", "Test to play a video from Video page", "OnDemandVideo")
        tapButton(androidDriver, video, false)
        elementDisplayed(androidDriver, videoPageObject.topStories)
        // elementDisplayed(androidDriver, videoPageObject.topStoriesVideoPlayTime)
        // elementDisplayed(androidDriver, videoPageObject.topstoriesvideolayoutname)
        scrollToElement(androidDriver, videoPageObject.topStoriesVideo)
        tapButton(androidDriver, videoPageObject.topStoriesVideo, false)
        tapButton(androidDriver, videoPageObject.accessibilityPlay, false)
        // androidDriver.findElementByAccessibilityId("Play").click();
        videoPageObject.transportControls.click()
        videoPageObject.transportControls.click()
        for (i in 0 until popularPageObject.popularVideoElementsRelease.size) {
            isElementPresent(androidDriver, By.id(popularPageObject.popularVideoElementsRelease[i]))
        }
        pressBack()
    }

    @Test(priority = 33, description = "App Backgrounding")
    fun testAppBackground() {
        startTest("App Background ", "Test to check backgrouding the app and reopen and checking same page opens", "App Background")
        popular?.click()
        androidDriver.runAppInBackground(Duration.ofSeconds(30))
        (androidDriver as StartsActivity).currentActivity()
        assertTrue(popular?.isSelected!!)
    }

    @Test(priority = 34, description = "Test to check the Popular page and also to check Most Read Displayed")
    fun testPopularPage() {
        startTest("Checking PopularPage", "Checking Popular Page", "Popular")
        tapButton(androidDriver, popularPageObject.popular, false)
        elementDisplayed(androidDriver, popularPageObject.mostRead)
    }

    @Test(priority = 35, description = "Test to select one Article from Most Read  Article from Popular Page")
    fun testCheckMostReadPopular() {
        startTest("Checking Article from Most Read Section", "Checking Most Read Popular", "Popular")
        elementDisplayed(androidDriver, popularPageObject.mostRead)
        tapButton(androidDriver, popularPageObject.mostReadArticle, false)
        //            for(int i=0;i<popularPageObject.mostReadPopularLinks.length;i++)
        //            {
        //                isElementPresent(androidDriver,By.id(popularPageObject.mostReadPopularLinks[i]));
        //            }
    }

    @Test(priority = 36, description = "Test to check whether the Most Watched heading displayed in Popular Page")
    fun testMostWatched() {
        pressBack()
        startTest("Checking Most Popular Section", "Checking Most Watched", "Popular")
        scrollToElement(androidDriver, popularPageObject.popularMostWatched)
        elementDisplayed(androidDriver, popularPageObject.popularMostWatched)
    }

    @Test(priority = 37, description = "Test to check whether the Most Watched heading displayed in Popular Page")
    fun testMostWatchedArticle() {
        startTest("Checking Most Watched Article ", "Checking Most Watched", "Popular")
        scrollToElement(androidDriver, popularPageObject.mostWatchedArticleVideo)
        System.out.println("The Element selected is  :- " + popularPageObject.mostWatchedArticleVideo.text)
        popularPageObject.mostWatchedArticleVideo.click()
        if (!popularPageObject.mostPopular.isDisplayed) {
            verticalSwipe(androidDriver, "Up")
        }
        for (i in 0 until videoPageObject.videoWallElementsRelease.size) {
            isElementPresent(androidDriver, By.id(videoPageObject.videoWallElementsRelease[i]))
        }
        pressBack()
    }

    @Test(priority = 38, description = "Test re-arrange topics from bottom to top")
    fun testArrangeTopicsFromBottomToTop() {
        startTest("Re Arrange Topics from Bottom-to-Top", "Test re-arrange topics from bottom to top", "MyNews")
        tapButton(androidDriver, myNews, false)
        tapButton(androidDriver, myNewsPageObject.editMyNews, false)

        val india = androidDriver.findElementsById("bbc.mobile.news.uk.internal:id/grab_handle")[5]
        val europe = androidDriver.findElementsById("bbc.mobile.news.uk.internal:id/grab_handle")[0]

        elementDragDrop(androidDriver, india, europe)
        readRecyclerView(androidDriver, "Topics After  Re-Ordering :- ")

        assertNotEquals("Rape in India", androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='1']/android.widget.RelativeLayout[@index='5']/android.widget.TextView[@index='1']")).text, "Test Didn't Matched")
        assertEquals("Rape in India", androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='1']/android.widget.RelativeLayout[@index='1']/android.widget.TextView[@index='1']")).text, "Test Matched")
        // Assert.assertEquals("European Union",androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='1']/android.widget.RelativeLayout[@index='2']/android.widget.TextView[@index='1']")).getText(), "Test Matched");
        assertEquals("YouTube", androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='1']/android.widget.RelativeLayout[@index='5']/android.widget.TextView[@index='1']")).text, "Test Matched")
        pressBack()
    }

    @Test(priority = 39, description = "Test to check the offline scenario of the app")
    fun testOfflineScenario() {
        startTest("Going OffLine", "Checking apps offline scenario", "Offline")
        val state = androidDriver.setConnection(ConnectionStateBuilder()
                .withWiFiDisabled()
                .build())
        androidDriver.connection = state
        //        waitForScreenToLoad(androidDriver,topStories,10);
        //        tapButton(androidDriver,topStories,false);
        //        scrollToElement(androidDriver, videoOfTheDayWatch);
        //        tapButton(androidDriver, videoOfTheDayButton, false);
        //        Assert.assertEquals("You're not connected to the internet.", myNewsPageObject.snackbar.getText(), "Text Matched");
    }

    @Test(priority = 40, description = "Test to play a  video, while device offline")
    fun testPlayingVideoOffline() {
        startTest("VideoPlayback-Offline", "Checking the Video while device offline", "Offline")
        tapButton(androidDriver, video, false)
        tapButton(androidDriver, videoPageObject.bbcNewsChannel, false)
        elementDisplayed(androidDriver, videoPageObject.liveMediaItemCaption)
        elementDisplayed(androidDriver, navigateBack)
        elementDisplayed(androidDriver, shareStory)
        tapButton(androidDriver, videoPageObject.accessibilityPlay, false)
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

    @Test(priority = 41, description = "Test to play a  video, while device online")
    fun testPlayingVideoOnLine() {
        startTest("VideoPlayback-Online", "Checking the Video while device Online", "Offline")
        tapButton(androidDriver, video, false)
        tapButton(androidDriver, videoPageObject.bbcNewsChannel, false)
        tapButton(androidDriver, videoPageObject.accessibilityPlay, false)
        isElementPresent(androidDriver, By.id("bbc.mobile.news.uk:id/smp_error_message"))
        isElementPresent(androidDriver, By.id("bbc.mobile.news.uk:id/smp_retry_button"))
        isElementPresent(androidDriver, By.id("bbc.mobile.news.uk:id/smp_error_button"))
        pressBack()
    }

    @AfterMethod
    fun getResult(result: ITestResult) = getTestResult(androidDriver, result)

    @AfterTest
    fun tearDown() {
        publishReport()
        androidDriver.closeApp()
        androidDriver.removeApp("bbc.mobile.news.uk")
        androidDriver.quit()
    }
}