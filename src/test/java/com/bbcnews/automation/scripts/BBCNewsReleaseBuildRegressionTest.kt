package com.bbcnews.automation.scripts

import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin
import com.bbcnews.automation.commonfunctions.FilePaths.screenshotPath
import com.bbcnews.automation.commonfunctions.ScreenActions.pressBack
import com.bbcnews.automation.commonfunctions.ScreenAssertions.assertDisplayingElements
import com.bbcnews.automation.pageobjects.*
import com.bbcnews.automation.testutils.Testutility
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
import org.openqa.selenium.StaleElementReferenceException
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.support.PageFactory
import org.testng.Assert.*
import org.testng.ITestResult
import org.testng.annotations.AfterMethod
import org.testng.annotations.AfterTest
import org.testng.annotations.BeforeTest
import org.testng.annotations.Test
import java.io.File
import java.io.IOException
import java.net.URL
import java.time.Duration
import java.util.*

class BBCNewsReleaseBuildRegressionTest {

    private var capabilities = DesiredCapabilities()
    private var deviceosName: String? = null
    private var deviceid: String? = null
    private var deviceName: String? = null
    private var appPath: String? = null
    private var appiumPort: String? = null
    private lateinit var file: File

    private var commonFunctionKotlin = CommonFunctionKotlin()
    private var testutility = Testutility()

    private lateinit var homePageObject: HomePageObject
    private lateinit var androidDriver: AndroidDriver<MobileElement>
    private lateinit var myNewsPageObject: MyNewsPageObject
    private lateinit var basePageObject: BasePageObject
    private lateinit var videoPageObject: VideoPageObjects
    private lateinit var popularPageObject: PopularPageObjects
    private lateinit var myTopicsPageObject: MyTopicsPageObject

    @BeforeTest
    private fun runTest() {
        try {
            readDeviceDetailsCommandPrompt()
            setUP()
            commonFunctionKotlin.checkConnection(androidDriver)
            initialiseobjects()

        } catch (e: Exception) {
            e.printStackTrace()
        }

    }


    private fun readDeviceDetailsCommandPrompt() {

        try {
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
        } catch (e: Exception) {
            e.printStackTrace()

        }

    }

    private fun setUP() {
        try {

            //commented out to start appium server, as this taken care by hive, to run locally un-comment below line of code
            //appiumStart.startAppium(Integer.parseInt(Appium_Port));
            //  AppiumManager.startAppium(Integer.parseInt(Appium_Port));
            val appium_url = "http://127.0.0.1:$appiumPort/wd/hub"
            System.out.println("Appium Server Address : - $appium_url")
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
            androidDriver = AndroidDriver(URL(appium_url), capabilities)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }


    private fun initialiseobjects() = try {
        homePageObject = HomePageObject()
        PageFactory.initElements(AppiumFieldDecorator(androidDriver), homePageObject)

        myNewsPageObject = MyNewsPageObject()
        PageFactory.initElements(AppiumFieldDecorator(androidDriver), myNewsPageObject)

        basePageObject = BasePageObject()
        PageFactory.initElements(AppiumFieldDecorator(androidDriver), basePageObject)

        videoPageObject = VideoPageObjects()
        PageFactory.initElements(AppiumFieldDecorator(androidDriver), videoPageObject)

        popularPageObject = PopularPageObjects()
        PageFactory.initElements(AppiumFieldDecorator(androidDriver), popularPageObject)

        myTopicsPageObject = MyTopicsPageObject()
        PageFactory.initElements(AppiumFieldDecorator(androidDriver), myTopicsPageObject)

        testutility.emptyFolder(screenshotPath)

        commonFunctionKotlin.createrReportHive("Regression", deviceName.toString(), deviceid.toString())

        androidDriver.context("NATIVE_APP")
        val file = File(screenshotPath)
        val screenshot = file.absolutePath
        System.out.println("The ScreenShot Path is $screenshot")

        val orientation = androidDriver.orientation
        if (orientation != ScreenOrientation.LANDSCAPE) {
        } else {
            androidDriver.rotate(ScreenOrientation.PORTRAIT)
        }
    } catch (e: NullPointerException) {
        e.printStackTrace()
    }


    @Test(priority = 1, description = "Launching the app")
    fun testOpenNewsApp() {
        try {

            commonFunctionKotlin.tapButton(androidDriver, basePageObject.okButton, false)
            commonFunctionKotlin.tapButton(androidDriver, basePageObject.noThanksButton, false)
            try {
                if (basePageObject.errorRetryButton.isDisplayed) {
                    commonFunctionKotlin.tapButton(androidDriver, basePageObject.errorRetryButton, false)
                }
            } catch (e: org.openqa.selenium.NoSuchElementException) {
            }


        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    @Test(priority = 2, description = "Test to check whether all links present on Home Page")
    fun testTopStories() {
        try {
            commonFunctionKotlin.startTest("Checking the HomePage", "Checking the HomePage", "HomePage")
            commonFunctionKotlin.iselementSelected(basePageObject.topStories)
            commonFunctionKotlin.elementDisplayed(androidDriver, basePageObject.topStories)
            commonFunctionKotlin.elementDisplayed(androidDriver, basePageObject.myNews)
            commonFunctionKotlin.elementDisplayed(androidDriver, basePageObject.popular)
            commonFunctionKotlin.elementDisplayed(androidDriver, basePageObject.video)
            commonFunctionKotlin.elementDisplayed(androidDriver, basePageObject.search)
            commonFunctionKotlin.elementDisplayed(androidDriver, basePageObject.menuButton)

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


    @Test(priority = 3, description = "Test to check Video of the day displayed and swipe through all the videos")
    @Throws(Exception::class)
    fun testVideoOfTheDayDisplayed() {
        try {
            commonFunctionKotlin.startTest("VideoOftheDay", "Scroll to a Video of the day", "HomePage")
            commonFunctionKotlin.sleepmethod(1000)
            commonFunctionKotlin.scrolltoElement(androidDriver, homePageObject.videoOfTheDayWatch)

            assertDisplayingElements(
                    homePageObject.videoOfTheDayWatchNext,
                    homePageObject.promoCounter,
                    homePageObject.videoOfTheDayPromoSummary,
                    homePageObject.videoOfTheDayTitle
            )

            assertEquals("Videos of the day", homePageObject.videoOfTheDayTitle.text)
            assertEquals("WATCH", homePageObject.videoOfTheDayWatchNext.text)
            assertEquals("7", homePageObject.promoCounter.text)
            assertEquals("Swipe through the latest news videos", homePageObject.videoOfTheDayPromoSummary.text)

            commonFunctionKotlin.tapButton(androidDriver, homePageObject.videoOfTheDayButton, false)
            commonFunctionKotlin.scrolltoEndofStories(androidDriver, homePageObject.newsStreamProgress, videoPageObject.videosOfTheDayRelease, homePageObject.checkBackLater)
            pressBack()
        } catch (e: AssertionError) {
            throw e
        }
    }

    @Test(priority = 4, description = "Test to scroll to a topic on home page and select a particular topic and add to MyNews")
    @Throws(Exception::class)
    fun testToCheckTopicsTopStores() {
        try {
            commonFunctionKotlin.startTest("Scrolling to topics", "Scroll to a Topics on Home Page", "HomePage")

            //scrolls to Reality Check topics on Top Stories page
            commonFunctionKotlin.scrolltoElement(androidDriver, homePageObject.educationTopics)
            commonFunctionKotlin.tapButton(androidDriver, homePageObject.educationTopics, false)

            if (!commonFunctionKotlin.isElementPresent(androidDriver, By.id("bbc.mobile.news.uk.internal:id/menu_follow"))) {
                System.out.println("Scrolling up")
                commonFunctionKotlin.verticalSwipe(androidDriver, "Up")
            }

            assertDisplayingElements(homePageObject.familyEducationTopic)
            System.out.println("Topics is :-" + homePageObject.familyEducationTopic.text)

            for (i in 0 until basePageObject.topicsPageElementsRelease.size) {
                commonFunctionKotlin.isElementPresent(androidDriver, By.id(basePageObject.topicsPageElementsRelease[i]))
            }
            commonFunctionKotlin.tapButton(androidDriver, myNewsPageObject.myNewsAddTopics, false)
            commonFunctionKotlin.textpresent(androidDriver, "Family & Education", "added to")
            assertDisplayingElements(myNewsPageObject.manageYourTopics)
            commonFunctionKotlin.tapButton(androidDriver, basePageObject.backButton, false)

            //scrolls to health topics on Top Stories page
            commonFunctionKotlin.scrolltoElement(androidDriver, homePageObject.technologyTopic)
            commonFunctionKotlin.tapButton(androidDriver, homePageObject.technologyTopic, false)

            if (!commonFunctionKotlin.isElementPresent(androidDriver, By.id("bbc.mobile.news.uk.internal:id/menu_follow"))) {
                System.out.println("Scrolling up")
                commonFunctionKotlin.verticalSwipe(androidDriver, "Up")
            }

            System.out.println("The Topic is " + homePageObject.technologyTopic.text)

            assertDisplayingElements(homePageObject.technologyTopic)
            System.out.println("Topics is :-" + homePageObject.technologyTopic.text)

            for (i in 0 until basePageObject.topicsPageElementsRelease.size) {
                commonFunctionKotlin.isElementPresent(androidDriver, By.id(basePageObject.topicsPageElementsRelease[i]))
            }

            commonFunctionKotlin.tapButton(androidDriver, myNewsPageObject.myNewsAddTopics, false)
            commonFunctionKotlin.textpresent(androidDriver, "Technology", "added to")
            assertDisplayingElements(myNewsPageObject.manageYourTopics)
            commonFunctionKotlin.tapButton(androidDriver, basePageObject.backButton, false)

        } catch (e: Exception) {
        }

    }

    @Test(priority = 5, description = "Test To Check the topics added from top stories are displayed under MyNews")
    @Throws(Exception::class)
    fun testMyNewsTopStoriesTopics() {
        try {
            commonFunctionKotlin.startTest("Removing Added Topics", "Test to check Topics on MyNews page", "MyNews")
            commonFunctionKotlin.tapButton(androidDriver, basePageObject.myNews, false)
            commonFunctionKotlin.tapButton(androidDriver, myNewsPageObject.editMyNews, false)
            try {
                assertDisplayingElements(
                        homePageObject.technologyTopic,
                        homePageObject.familyEducationTopic
                )
            } catch (e: Exception) {
                e.printStackTrace()
            }

            commonFunctionKotlin.tapButton(androidDriver, myNewsPageObject.removeTopics, false)
            commonFunctionKotlin.textpresent(androidDriver, "Family & Education", "removed from")
            commonFunctionKotlin.tapButton(androidDriver, myNewsPageObject.removeTopics, false)
            commonFunctionKotlin.textpresent(androidDriver, "Technology", "removed from")
            // pressBack()
            commonFunctionKotlin.tapButton(androidDriver, basePageObject.backButton, false)

        } catch (e: StaleElementReferenceException) {

        }
    }

    @Test(priority = 6, description = "Test for Checking whether Location service works")
    @Story("MyNews")
    @Throws(Exception::class)
    fun testAllowLocation() {
        try {
            commonFunctionKotlin.startTest("Allowing Location Service ", "Checking whether Location service works ", "MyNews")
            commonFunctionKotlin.tapButton(androidDriver, basePageObject.myNews, false)//,file.getAbsolutePath());
            commonFunctionKotlin.tapButton(androidDriver, myNewsPageObject.myNewsStartButton, false)
            commonFunctionKotlin.tapButton(androidDriver, myNewsPageObject.allowLocation, false)
            commonFunctionKotlin.tapButton(androidDriver, myNewsPageObject.allowLocationPermission, false)
            pressBack()
        } catch (e: AssertionError) {
            e.printStackTrace()
        }
    }

    @Test(priority = 7, description = "Test to check MyNews page and asserting whether all links displayed")
    @Throws(Exception::class)
    fun testMyNews() = try {
        commonFunctionKotlin.startTest("Checking Elements on MyNews Page", "Test to check MyNews page", "MyNews")
        commonFunctionKotlin.tapButton(androidDriver, basePageObject.myNews, false)
        commonFunctionKotlin.elementDisplayed(androidDriver, myNewsPageObject.myNewsSummary)
        commonFunctionKotlin.elementDisplayed(androidDriver, myNewsPageObject.myNewsTitle)
        commonFunctionKotlin.elementDisplayed(androidDriver, myNewsPageObject.addNewsButton)
        assertEquals(myNewsPageObject.myNewsTitleText, myNewsPageObject.myNewsTitle.text, "Text Mesaaged")
        assertEquals(myNewsPageObject.myNewsSummaryText, myNewsPageObject.myNewsSummary.text, "Text Mesaaged")
    } catch (e: NullPointerException) {
    }

    // @Test(dependsOnMethods = {"testMyNews"})
    @Test(priority = 8, description = "Test to check on My News Add Topic screen and asserting all links are displayed")
    @Throws(Exception::class)
    fun testAddingTopicsPage() {
        try {
            commonFunctionKotlin.startTest("Checking Elements on Edit Mynews Page", "Test to check Edit MyNews page", "MyNews")
            commonFunctionKotlin.tapButton(androidDriver, myNewsPageObject.myNewsStartButton, false)
            commonFunctionKotlin.elementIsSelected(myNewsPageObject.addTopics)
            commonFunctionKotlin.elementDisplayed(androidDriver, myNewsPageObject.myTopics)
            //commonFunctionKotlin.elementDisplayed(androidDriver, myNewsPageObject.locationButton);
            commonFunctionKotlin.elementDisplayed(androidDriver, myNewsPageObject.editMyTopics)
            commonFunctionKotlin.elementDisplayed(androidDriver, myNewsPageObject.localNews)
            commonFunctionKotlin.tapButton(androidDriver, myNewsPageObject.myTopics, false)//,file.getAbsolutePath());
            commonFunctionKotlin.elementIsSelected(myNewsPageObject.myTopics)
            assertEquals(myNewsPageObject.myTopicEmptyViewText, myNewsPageObject.myTopicEmptyView.text, "Text Mesaaged")
        } catch (e: NullPointerException) {
        }

    }


    // @Test(dependsOnMethods = {"testAddingTopicsPage"})
    @Test(priority = 9, description = "Test to add Topics under MyNews")
    @Throws(Exception::class)
    fun testAddingTopicstoMyNewsPage() {
        try {
            commonFunctionKotlin.startTest("Adding Topics ", "Test to check added Topics to MyNews page", "MyNews")
            commonFunctionKotlin.tapButton(androidDriver, myNewsPageObject.addTopics, false)

            assertEquals("London", myNewsPageObject.localNewsDisplayed.text)
            commonFunctionKotlin.elementDisplayed(androidDriver, myNewsPageObject.localNewsDisplayed)

            commonFunctionKotlin.scrolltoElement(androidDriver, myTopicsPageObject.addEnglandTopicButton)
            commonFunctionKotlin.tapButton(androidDriver, myTopicsPageObject.addEnglandTopicButton, false)
            commonFunctionKotlin.textpresent(androidDriver, "England", "added to")

            commonFunctionKotlin.scrolltoElement(androidDriver, myTopicsPageObject.addAfricaTopicButton)
            commonFunctionKotlin.tapButton(androidDriver, myTopicsPageObject.addAfricaTopicButton, false)

            commonFunctionKotlin.scrolltoElement(androidDriver, myTopicsPageObject.addEuTopicButton)
            commonFunctionKotlin.tapButton(androidDriver, myTopicsPageObject.addEuTopicButton, false)

            commonFunctionKotlin.scrolltoElement(androidDriver, myTopicsPageObject.addMortgagesTopicButton)
            commonFunctionKotlin.tapButton(androidDriver, myTopicsPageObject.addMortgagesTopicButton, false)
            commonFunctionKotlin.textpresent(androidDriver, "Mortgages", "added to")

            commonFunctionKotlin.scrolltoElement(androidDriver, myTopicsPageObject.addYouTubeTopicButton)
            commonFunctionKotlin.tapButton(androidDriver, myTopicsPageObject.addYouTubeTopicButton, false)
            commonFunctionKotlin.textpresent(androidDriver, "YouTube", "added to")
        } catch (e: NullPointerException) {
        }

    }

    @Test(priority = 10, description = "Test to check whether selected topics are displayed under Added Topics in MyNews")
    @Throws(Exception::class)
    fun testCheckAddedTopics() {
        try {
            commonFunctionKotlin.startTest("My Topics page", "Test to check added Topics MyNews page", "MyNews")
            commonFunctionKotlin.tapButton(androidDriver, myNewsPageObject.myTopics, false)
            commonFunctionKotlin.elementDisplayed(androidDriver, myTopicsPageObject.englandTopic)
            commonFunctionKotlin.elementDisplayed(androidDriver, myTopicsPageObject.africaTopic)
            commonFunctionKotlin.elementDisplayed(androidDriver, myTopicsPageObject.europeanTopic)
            commonFunctionKotlin.elementDisplayed(androidDriver, myTopicsPageObject.mortgagesTopic)
            commonFunctionKotlin.elementDisplayed(androidDriver, myTopicsPageObject.youTubeTopic)
        } catch (e: NullPointerException) {
        }

    }


    @Test(priority = 11, description = "Test to display the Ordering of the Topics")
    @Throws(Exception::class)
    fun testCheckOrderingofTopicsAdded() = try {
        commonFunctionKotlin.startTest("My Topics Ordering", "Test to display the Ordering of the Topics", "MyNews")
        commonFunctionKotlin.readRecyclerView(androidDriver, "Topics Before Re-Ordering :- ")
        System.out.println("The Text at get(0) is " + androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='1']/android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='1']")).text)
        System.out.println("The Text at get(1) is " + androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='1']/android.widget.RelativeLayout[@index='1']/android.widget.TextView[@index='1']")).text)
        System.out.println("The Text at get(2) is " + androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='1']/android.widget.RelativeLayout[@index='2']/android.widget.TextView[@index='1']")).text)
        System.out.println("The Text at get(3) is " + androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='1']/android.widget.RelativeLayout[@index='3']/android.widget.TextView[@index='1']")).text)
        System.out.println("The Text at get(4) is " + androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='1']/android.widget.RelativeLayout[@index='4']/android.widget.TextView[@index='1']")).text)
        assertEquals("England", androidDriver.findElement(By.xpath("//android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='1']")).text, "Test Matched")
        pressBack()

    } catch (e: NullPointerException) {
    }

    @Test(priority = 12, description = "Test to select each of the topics displayed under MyNews ")
    @Throws(Exception::class)
    fun testSelectedAddedTopics() {
        try {
            commonFunctionKotlin.startTest("Checking Added Topics on Mynews page", "Selecting Added Topics", "MyNews")
            commonFunctionKotlin.sleepmethod(1000)
            commonFunctionKotlin.elementDisplayed(androidDriver, myTopicsPageObject.englandTopic)
            commonFunctionKotlin.elementDisplayed(androidDriver, myTopicsPageObject.europeanTopic)
            commonFunctionKotlin.elementDisplayed(androidDriver, myTopicsPageObject.africaTopic)
            commonFunctionKotlin.tapButton(androidDriver, myTopicsPageObject.englandTopic, false)
            for (i in 0 until basePageObject.topicsPageElementsRelease.size) {
                commonFunctionKotlin.isElementPresent(androidDriver, By.id(basePageObject.topicsPageElementsRelease[i]))
            }
            pressBack()
            commonFunctionKotlin.tapButton(androidDriver, myTopicsPageObject.europeanTopic, false)
            for (i in 0 until basePageObject.topicsPageElementsRelease.size) {
                commonFunctionKotlin.isElementPresent(androidDriver, By.id(basePageObject.topicsPageElementsRelease[i]))
            }
            pressBack()
            commonFunctionKotlin.tapButton(androidDriver, myTopicsPageObject.africaTopic, false)
            for (i in 0 until basePageObject.topicsPageElementsRelease.size) {
                commonFunctionKotlin.isElementPresent(androidDriver, By.id(basePageObject.topicsPageElementsRelease[i]))
            }

        } catch (e: StaleElementReferenceException) {
        }

    }

    @Test(priority = 13, description = "Test to select An Article from the Africa Topics under MyNews ")
    @Throws(Exception::class)
    fun testSelectArticleAsiaTopic() {
        try {
            commonFunctionKotlin.startTest("Selecting a Article from Asia Topics", "Test to select An Article from the Asia Topics under MyNews", "MyNews")
            commonFunctionKotlin.tapButton(androidDriver, myNewsPageObject.topicArticle, false)
            pressBack()

        } catch (e: StaleElementReferenceException) {
        }

    }

    @Test(priority = 14, description = "Test to select An Video Article from the Africa Topics under MyNews ")
    @Throws(Exception::class)
    fun testSelectVideoArticleAsiaTopic() {
        try {
            commonFunctionKotlin.startTest("Select a Video Article from Asia Topic", "Test to select An Video Article from the Asia Topics under MyNews", "MyNews")
            commonFunctionKotlin.scrolltoElement(androidDriver, myNewsPageObject.myNewsRecyclerView)
            commonFunctionKotlin.tapButton(androidDriver, myNewsPageObject.topicVideoArticle, false)
            for (i in 0 until videoPageObject.videoWallElementsRelease.size) {
                commonFunctionKotlin.isElementPresent(androidDriver, By.id(videoPageObject.videoWallElementsRelease[i]))
            }
            commonFunctionKotlin.tapButton(androidDriver, videoPageObject.smpPlaceholderPlayButton, false)
            commonFunctionKotlin.sleepmethod(1300)
            for (i in 0 until videoPageObject.playbackControlsRelease.size) {
                commonFunctionKotlin.isElementPresent(androidDriver, By.id(videoPageObject.playbackControlsRelease[i]))
            }
            pressBack()
            commonFunctionKotlin.tapButton(androidDriver, basePageObject.backButton, false)
        } catch (e: StaleElementReferenceException) {
        }

    }


    @Test(priority = 15, description = "Test to re-arrange topics from top to bottom")
    @Throws(Exception::class)
    fun testCheckReOrderingofTopicsAdded() = try {
        commonFunctionKotlin.startTest("Re Arrange Topics from Top-to-Bottom", "Test to re-arrange topics from top to bottom", "MyNews")
        commonFunctionKotlin.tapButton(androidDriver, myNewsPageObject.editMyNews, false)

        val africa = androidDriver.findElementsById("bbc.mobile.news.uk.internal:id/grab_handle")[1]
        val youtubetopic = androidDriver.findElementsById("bbc.mobile.news.uk.internal:id/grab_handle")[4]

        commonFunctionKotlin.elementdragdrop(androidDriver, africa, youtubetopic)

        commonFunctionKotlin.readRecyclerView(androidDriver, "Topics After  Re-Ordering :- ")

        System.out.println("The Text at get(3) is " + androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='1']/android.widget.RelativeLayout[@index='3']/android.widget.TextView[@index='1']")).text)
        assertEquals("Africa", androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='1']/android.widget.RelativeLayout[@index='3']/android.widget.TextView[@index='1']")).text, "Test Matched")

//        System.out.println("The Text at get(0) is " + androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='1']/android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='1']")).text)
//        Assert.assertNotEquals("Brexit", androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='1']/android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='1']")).text, "Test Matched")

        pressBack()

    } catch (e: NullPointerException) {
    }


    //@Test(dependsOnMethods = {"testcheckMostWatched"})
    @Test(priority = 16, description = "Test to check whether the Menu Options are displayed")
    @Throws(Exception::class)
    fun testcheckMenuItems() {
        try {
            commonFunctionKotlin.startTest("Checking the MenuItems", "Checking Menu Items ", "Menu")
            commonFunctionKotlin.tapButton(androidDriver, basePageObject.menuButton, false)
            commonFunctionKotlin.elementDisplayed(androidDriver, basePageObject.settings)
            commonFunctionKotlin.elementDisplayed(androidDriver, basePageObject.InternalSettings)
            commonFunctionKotlin.elementDisplayed(androidDriver, basePageObject.otherBbcApps)
            commonFunctionKotlin.elementDisplayed(androidDriver, basePageObject.appInfo)
            pressBack()
        } catch (e: NullPointerException) {
        }

    }


    @Test(priority = 17, description = "Test to play a Live video from Vide page and asserting on whether playback controls are displayed")
    @Throws(Exception::class)
    fun testVideopage() {
        try {
            commonFunctionKotlin.startTest("Playing a Live Video", "Checking the Video Page", "Live Video")
            commonFunctionKotlin.tapButton(androidDriver, basePageObject.video, false)
            commonFunctionKotlin.tapButton(androidDriver, videoPageObject.bbcNewsChannel, false)
            commonFunctionKotlin.elementDisplayed(androidDriver, videoPageObject.liveMediaItemCaption)
            commonFunctionKotlin.elementDisplayed(androidDriver, basePageObject.navigate_back)
            commonFunctionKotlin.elementDisplayed(androidDriver, basePageObject.shareStory)
            commonFunctionKotlin.tapButton(androidDriver, videoPageObject.smpPlaceholderPlayButton, false)
            commonFunctionKotlin.sleepmethod(1400)
            commonFunctionKotlin.tapButton(androidDriver, videoPageObject.smpFullScreenButton, false)
            commonFunctionKotlin.sleepmethod(1400)
            try {
                if (commonFunctionKotlin.isElementPresent(androidDriver, By.id("bbc.mobile.news.uk:id/smp_play_button"))) {
                    commonFunctionKotlin.tapButton(androidDriver, videoPageObject.playButton, false)
                }
            } catch (e: NoSuchElementException) {
            }

            commonFunctionKotlin.tapButton(androidDriver, videoPageObject.transportControls, false)
            commonFunctionKotlin.tapButton(androidDriver, videoPageObject.transportControls, false)
            commonFunctionKotlin.elementDisplayed(androidDriver, videoPageObject.smpPauseButton)
            commonFunctionKotlin.elementDisplayed(androidDriver, videoPageObject.smpExitFullScreenButton)
            commonFunctionKotlin.elementDisplayed(androidDriver, videoPageObject.smpLiveIcon)
            commonFunctionKotlin.elementDisplayed(androidDriver, videoPageObject.smpVolumeButton)
            commonFunctionKotlin.elementDisplayed(androidDriver, videoPageObject.smpSeekBar)
        } catch (e: NullPointerException) {
        }

    }

    @Test(priority = 18, description = "Test to check whether video plays in Landspace mode")
    @Throws(Exception::class)
    fun playingLandspace() {
        commonFunctionKotlin.startTest("Checking Live Video in Landscape", "Checking the Video in Landscape Mode", "Live Video")
        androidDriver.rotate(ScreenOrientation.LANDSCAPE)
        commonFunctionKotlin.tapButton(androidDriver, videoPageObject.transportControls, false)
        commonFunctionKotlin.tapButton(androidDriver, videoPageObject.transportControls, false)
        commonFunctionKotlin.elementDisplayed(androidDriver, videoPageObject.smpPauseButton)
        commonFunctionKotlin.elementDisplayed(androidDriver, videoPageObject.smpExitFullScreenButton)
        commonFunctionKotlin.elementDisplayed(androidDriver, videoPageObject.smpLiveIcon)
        commonFunctionKotlin.elementDisplayed(androidDriver, videoPageObject.smpVolumeButton)
        commonFunctionKotlin.elementDisplayed(androidDriver, videoPageObject.smpSeekBar)

    }

    @Test(priority = 19, description = "Test to scrub thise video playback ")
    @Throws(InterruptedException::class)
    fun scrubbingvideoplayback() {
        androidDriver.rotate(ScreenOrientation.PORTRAIT)
        commonFunctionKotlin.startTest("Checking Live Video Scrubbing", "Checking the Live Video in Portrait Mode and seeking", "Live Video")
        commonFunctionKotlin.seeking(androidDriver, videoPageObject.smpSeekBar, .30, "forward")
        commonFunctionKotlin.isElementPresent(androidDriver, By.id("bbc.mobile.news.uk.internal:id/smpSeekBar"))
        commonFunctionKotlin.tapButton(androidDriver, videoPageObject.smpExitFullScreenButton, false)
        pressBack()
    }

    @Test(priority = 20, description = "Test to check for search results")
    fun testSearchStories() {
        try {
            commonFunctionKotlin.startTest("Search for an Topics", "Checking Search Topics", "Search")
            commonFunctionKotlin.tapButton(androidDriver, basePageObject.searchButton, false)
            commonFunctionKotlin.enterText(basePageObject.searchField, "India")
            commonFunctionKotlin.sleepmethod(800)

            val searchTopicsText = commonFunctionKotlin.getText(basePageObject.searchHeading)
            assertEquals(searchTopicsText, "Topics (5)", "matched")
            commonFunctionKotlin.sleepmethod(800)

            val searchRelatedHeadingText = commonFunctionKotlin.getText(basePageObject.searchHeading2)
            assertEquals(searchRelatedHeadingText, "Articles related to \"India\"")

            commonFunctionKotlin.tapButton(androidDriver, basePageObject.cancelSearch, false)

            val searchTopicsText1 = commonFunctionKotlin.getText(basePageObject.searchHeading)
            assertEquals(searchTopicsText1, "In The News Now", "matched")
            commonFunctionKotlin.sleepmethod(800)

            val searchRelatedHeadingText2 = commonFunctionKotlin.getText(basePageObject.searchHeading2)
            assertEquals(searchRelatedHeadingText2, "More Topics", "matched")

            //Assert.assertEquals(basePageObject.searchHeading4.getText(),"My Topics","matched");
            commonFunctionKotlin.tapButton(androidDriver, basePageObject.backButton, false)

        } catch (e: AssertionError) {
            throw e
        }

    }

    @Test(priority = 21, description = "Test to search for a Topic and navigate to topic page")
    fun testSelectSearchResult() {
        try {
            commonFunctionKotlin.startTest("Navigate to Topic Detail Page", "Test to search for a Topic and navigate to topic page", "Search")
            commonFunctionKotlin.tapButton(androidDriver, basePageObject.searchButton, false)
            basePageObject.searchField.clear()
            commonFunctionKotlin.enterText(basePageObject.searchField, basePageObject.searchText)
            commonFunctionKotlin.sleepmethod(700)
            assertEquals(basePageObject.searchText, basePageObject.searchKeyword.text, "Text Matched")
            commonFunctionKotlin.tapButton(androidDriver, basePageObject.searchKeyword, false)
            val title = commonFunctionKotlin.getText(basePageObject.headlineTitle)
            assertEquals(basePageObject.searchText, title)
            commonFunctionKotlin.tapButton(androidDriver, basePageObject.backButton, false)
            pressBack()
            commonFunctionKotlin.tapButton(androidDriver, basePageObject.backButton, false)
            // }

        } catch (e: AssertionError) {
            throw e
        }

    }

    @Test(priority = 22, description = "Test Checking an Topic and adding to MyNews")
    @Throws(Exception::class, AssertionError::class)
    fun testSearchTopic() {
        try {
            commonFunctionKotlin.startTest("Search and Adding Topic to Mynews", "Test Checking an Topic and adding to MyNews", "Search")
            commonFunctionKotlin.tapButton(androidDriver, basePageObject.searchButton, false)
            basePageObject.searchField.clear()
            commonFunctionKotlin.enterText(basePageObject.searchField, "India")
            commonFunctionKotlin.sleepmethod(700)
            commonFunctionKotlin.tapButton(androidDriver, basePageObject.article, false)

            assertEquals("The women who fought to ban alcohol", basePageObject.articleLayoutName.text)
            assertEquals("4th Jan", basePageObject.articleLastUpdated.text)
            commonFunctionKotlin.tapButton(androidDriver, myNewsPageObject.myNewsAddTopics, false)
        } catch (e: AssertionError) {
            throw e
        }

    }

    @Test(priority = 23, description = "Test Checking an Article page without an Item Image Badge")
    @Throws(Exception::class, AssertionError::class)
    fun testArtictleItemWithoutItemBadge() {
        try {
            commonFunctionKotlin.startTest("Article without ItemImage Badge", "Test Checking an Article page without an Item Image Badge", "Search")
            commonFunctionKotlin.scrolltoElement(androidDriver, basePageObject.articleItemWithoutItemBadge)
            commonFunctionKotlin.tapButton(androidDriver, basePageObject.articleItemWithoutItemBadge, false)

            var i = 0
            while (i < basePageObject.articleDetailPageLinksRelease.size && i < basePageObject.articleItemWithImageBadge.size) {
                commonFunctionKotlin.isElementPresent(androidDriver, By.id(basePageObject.articleDetailPageLinksRelease[i]))
                assertEquals(basePageObject.articleItemWithoutImageBadge[i], androidDriver.findElement(By.id(basePageObject.articleDetailPageLinksRelease[i])).text, "Test matched")
                i++
            }

            pressBack()

        } catch (e: AssertionError) {
            throw e
        }

    }

    @Test(priority = 24, description = "Test Checking an Article page with an Item Image Badge")
    @Throws(Exception::class)
    fun testArtictleItemWithItemBadge() {
        try {

            commonFunctionKotlin.startTest("Article with ItemImage Badge", "Checking an Article page without an Item Image Badge", "Search")
            commonFunctionKotlin.scrolltoElement(androidDriver, basePageObject.articleItemWithItemBadge)
            commonFunctionKotlin.tapButton(androidDriver, basePageObject.articleItemWithItemBadge, false)
            commonFunctionKotlin.elementDisplayed(androidDriver, basePageObject.articleImageBadge)
            assertEquals("EPA", basePageObject.articleImageBadge.text, "Text Matched")
            var i = 0
            while (i < basePageObject.articleDetailPageLinksRelease.size && i < basePageObject.articleItemWithImageBadge.size) {
                commonFunctionKotlin.isElementPresent(androidDriver, By.id(basePageObject.articleDetailPageLinksRelease[i]))
                assertEquals(basePageObject.articleItemWithImageBadge[i], androidDriver.findElement(By.id(basePageObject.articleDetailPageLinksRelease[i])).text, "Test matched")
                i++
            }

            pressBack()
            commonFunctionKotlin.tapButton(androidDriver, basePageObject.backButton, false)
            commonFunctionKotlin.tapButton(androidDriver, basePageObject.cancelSearch, false)
        } catch (e: AssertionError) {
            throw e
        }

    }


    @Test(priority = 25, description = "Test to search for an particular article")
    @Throws(Exception::class)
    fun testSearchArticle() {
        try {
            commonFunctionKotlin.startTest("Searching a Particular article", "Test to search for an particular article", "Search")
            commonFunctionKotlin.tapButton(androidDriver, basePageObject.searchButton, false)
            // basePageObject.searchField.clear();
            commonFunctionKotlin.enterText(basePageObject.searchField, "A rape victim's two-year wait for justice")
            //androidDriver.hideKeyboard();
            commonFunctionKotlin.tapButton(androidDriver, basePageObject.articleSearch, false)
            commonFunctionKotlin.sleepmethod(500)

            var i = 0
            while (i < basePageObject.articlePageDetail.size && i < basePageObject.articlePageDetailElementsRelease.size) {
                commonFunctionKotlin.isElementPresent(androidDriver, By.id(basePageObject.articlePageDetailElementsRelease[i]))
                assertEquals(basePageObject.articlePageDetail[i], androidDriver.findElement(By.id(basePageObject.articlePageDetailElementsRelease[i])).text, "Test matched")
                i++
            }
            commonFunctionKotlin.tapButton(androidDriver, basePageObject.navigate_back, false)
            commonFunctionKotlin.tapButton(androidDriver, basePageObject.backButton, false)

        } catch (e: AssertionError) {
            throw e
        }

    }

    @Test(priority = 26, description = "Test to search for an particular video article")
    @Throws(Exception::class)
    fun testondemandvideoplyback() {
        try {

            commonFunctionKotlin.startTest("Playing a Particular OnDemand Video", "Test to search ana play a on-demand video", "OnDemandVideo")
            commonFunctionKotlin.tapButton(androidDriver, basePageObject.search, false)
            commonFunctionKotlin.enterText(basePageObject.searchField, "Egypt court imposes jail")
            commonFunctionKotlin.waitForScreenToLoad(androidDriver, videoPageObject.videoArticleSearch, 3)
            // androidDriver.hideKeyboard();
            // commonFunctionKotlin.scrolltoElement(androidDriver, videoPageObject.videoArticleSearch);
            commonFunctionKotlin.tapButton(androidDriver, videoPageObject.videoArticleSearch, false)
            //commonFunctionKotlin.waitForScreenToLoad(androidDriver, videoPageObject.smpPlaceholderPlayButton, 3);
            var i = 0
            while (i < videoPageObject.videoDetailPageRelease.size && i < videoPageObject.videoDetailPageText.size) {

                commonFunctionKotlin.isElementPresent(androidDriver, By.id(videoPageObject.videoDetailPageRelease[i]))
                assertEquals(videoPageObject.videoDetailPageText[i], androidDriver.findElement(By.id(videoPageObject.videoDetailPageRelease[i])).text)
                i++
            }
        } catch (e: AssertionError) {
            throw e

        }

    }

    @Test(priority = 27, description = "Test to seek forward videoplayback")
    @Throws(InterruptedException::class)
    fun testseekingvideoforward() {
        commonFunctionKotlin.startTest("Seeking Video Forward", "Test to search ana play a on-demand video", "OnDemandVideo")
        commonFunctionKotlin.tapButton(androidDriver, videoPageObject.smpPlaceholderPlayButton, false)
        commonFunctionKotlin.seeking(androidDriver, videoPageObject.smpSeekBar, .50, "forward")
        videoPageObject.elapsedTimeForward = videoPageObject.smpElapsedTime.text
    }

    @Test(priority = 28, description = "Test to seek forward videoplayback")
    @Throws(InterruptedException::class)
    fun testseekingvideobackward() {
        commonFunctionKotlin.startTest("Seeking Video Backward", "Test to search ana play a on-demand video", "OnDemandVideo")
        commonFunctionKotlin.seeking(androidDriver, videoPageObject.smpSeekBar, .30, "backward")
        videoPageObject.elapsedTimeBackward = videoPageObject.smpElapsedTime.text
        assertNotEquals(videoPageObject.elapsedTimeForward, videoPageObject.elapsedTimeBackward)

    }

    @Test(priority = 29, description = "Test to check Related Stories and Topics of an Article")
    @Throws(Exception::class)
    fun testRelatedStoriesArticle() {
        commonFunctionKotlin.startTest("Checking for Related Story Article", "Test to check Related Stories of an Article", "Related Stories/Topics")
        commonFunctionKotlin.scrolltoElement(androidDriver, popularPageObject.relatedStoriesArticle)
        commonFunctionKotlin.elementDisplayed(androidDriver, basePageObject.relatedStories)
        commonFunctionKotlin.tapButton(androidDriver, popularPageObject.relatedStoriesArticle, false)
        for (i in 0 until popularPageObject.mostReadPopularLinksRelease.size) {
            commonFunctionKotlin.isElementPresent(androidDriver, By.id(popularPageObject.mostReadPopularLinksRelease[i]))
        }
        if (!basePageObject.shareStory.isDisplayed) {
            commonFunctionKotlin.verticalSwipe(androidDriver, "Up")
        }
        commonFunctionKotlin.tapButton(androidDriver, basePageObject.navigate_back, false)
    }

    @Test(priority = 30, description = "Test to check Related Topics of an Article")
    @Throws(Exception::class)
    fun testRelatedTopicArticle() {

        commonFunctionKotlin.startTest("Checking for Related Topic Article", "Test to check Related Topics of an Article", "Related Stories/Topics")
        commonFunctionKotlin.scrolltoElement(androidDriver, popularPageObject.relatedTopicsArticle)
        commonFunctionKotlin.elementDisplayed(androidDriver, basePageObject.relatedTopics)
        commonFunctionKotlin.tapButton(androidDriver, popularPageObject.relatedTopicsArticle, false)
        assertEquals("Egypt", androidDriver.findElement(By.id("bbc.mobile.news.uk.internal:id/title")).text)
        assertEquals("Add topic", androidDriver.findElement(By.id("bbc.mobile.news.uk.internal:id/menu_follow")).getAttribute("contentDescription"))
        for (i in 0 until basePageObject.topicsPageElementsRelease.size) {
            commonFunctionKotlin.isElementPresent(androidDriver, By.id(basePageObject.topicsPageElementsRelease[i]))
        }
        commonFunctionKotlin.tapButton(androidDriver, basePageObject.backButton, false)
        pressBack()
        commonFunctionKotlin.tapButton(androidDriver, basePageObject.backButton, false)

    }

    @Test(priority = 31, description = "Test to check the T&C , PrivacyPolicy from Menu options")
    fun testcheckTermsPrivacyPolicy() {
        commonFunctionKotlin.startTest("Checking T&C Privacy Policy", "Checking T&C and privacy Policy", "Menu")
        commonFunctionKotlin.tapButton(androidDriver, basePageObject.menuButton, false)
        commonFunctionKotlin.tapButton(androidDriver, basePageObject.menuAppInfo, false)
        commonFunctionKotlin.tapButton(androidDriver, basePageObject.termsOfUse, false)
        pressBack()
        commonFunctionKotlin.tapButton(androidDriver, basePageObject.privacyPolicy, false)
        pressBack()
        commonFunctionKotlin.tapButton(androidDriver, basePageObject.backButton, false)
    }


    @Test(priority = 32, description = "Playing a video from Video page")
    @Throws(Exception::class)
    fun testTopStoriesvideo() {

        commonFunctionKotlin.startTest("Playing a OnDemand Video", "Test to play a video from Video page", "OnDemandVideo")
        commonFunctionKotlin.tapButton(androidDriver, basePageObject.video, false)
        commonFunctionKotlin.elementDisplayed(androidDriver, videoPageObject.topStories)
        // commonFunctionKotlin.elementDisplayed(androidDriver, videoPageObject.topStoriesVideoPlayTime)
        // commonFunctionKotlin.elementDisplayed(androidDriver, videoPageObject.topstoriesvideolayoutname)
        commonFunctionKotlin.scrolltoElement(androidDriver, videoPageObject.topStoriesVideo)
        commonFunctionKotlin.tapButton(androidDriver, videoPageObject.topStoriesVideo, false)
        commonFunctionKotlin.tapButton(androidDriver, videoPageObject.smpPlaceholderPlayButton, false)
        // androidDriver.findElementByAccessibilityId("Play").click();
        videoPageObject.transportControls.click()
        videoPageObject.transportControls.click()
        for (i in 0 until popularPageObject.popularVideoElementsRelease.size) {
            commonFunctionKotlin.isElementPresent(androidDriver, By.id(popularPageObject.popularVideoElementsRelease[i]))
        }
        pressBack()
    }


    @Test(priority = 33, description = "App Backgrounding")
    fun testAppbackground() {
        commonFunctionKotlin.startTest("App Background ", "Test to check backgrouding the app and reopen and checking same page opens", "App Background")
        basePageObject.popular.click()
        androidDriver.runAppInBackground(Duration.ofSeconds(30))
        (androidDriver as StartsActivity).currentActivity()
        try {
            assertTrue(basePageObject.popular.isSelected)
        } catch (e: AssertionError) {
            throw e
        }

    }

    @Test(priority = 34, description = "Test to check the Popular page and also to check Most Read Displayed")
    @Throws(Exception::class)
    fun testPopularPage() {
        try {
            commonFunctionKotlin.startTest("Checking PopularPage", "Checking Popular Page", "Popular")
            commonFunctionKotlin.tapButton(androidDriver, popularPageObject.popular, false)
            commonFunctionKotlin.elementDisplayed(androidDriver, popularPageObject.mostRead)
        } catch (e: AssertionError) {
        }

    }

    @Test(priority = 35, description = "Test to select one Article from Most Read  Article from Popular Page")
    @Throws(Exception::class)
    fun testCheckMostReadPopular() {
        try {
            commonFunctionKotlin.startTest("Checking Article from Most Read Section", "Checking Most Read Popular", "Popular")
            commonFunctionKotlin.elementDisplayed(androidDriver, popularPageObject.mostRead)
            commonFunctionKotlin.tapButton(androidDriver, popularPageObject.mostReadArticle, false)
            //            for(int i=0;i<popularPageObject.mostReadPopularLinks.length;i++)
            //            {
            //                commonFunctionKotlin.isElementPresent(androidDriver,By.id(popularPageObject.mostReadPopularLinks[i]));
            //            }

        } catch (e: NullPointerException) {
        }

    }


    @Test(priority = 36, description = "Test to check whether the Most Watched heading displayed in Popular Page")
    @Throws(Exception::class)
    fun testcheckMostWatched() {
        try {
            pressBack()
            commonFunctionKotlin.startTest("Checking Most Popular Section", "Checking Most Watched", "Popular")
            commonFunctionKotlin.scrolltoElement(androidDriver, popularPageObject.popularMostWatched)
            commonFunctionKotlin.elementDisplayed(androidDriver, popularPageObject.popularMostWatched)

        } catch (e: NullPointerException) {
        }

    }


    @Test(priority = 37, description = "Test to check whether the Most Watched heading displayed in Popular Page")
    @Throws(Exception::class)
    fun testcheckMostWatchedArticle() {
        try {

            commonFunctionKotlin.startTest("Checking Most Watched Article ", "Checking Most Watched", "Popular")
            commonFunctionKotlin.scrolltoElement(androidDriver, popularPageObject.mostWatchedArticleVideo)
            System.out.println("The Element selected is  :- " + popularPageObject.mostWatchedArticleVideo.text)
            popularPageObject.mostWatchedArticleVideo.click()
            if (!popularPageObject.mostPopular.isDisplayed) {
                commonFunctionKotlin.verticalSwipe(androidDriver, "Up")
            }
            for (i in 0 until videoPageObject.videoWallElementsRelease.size) {
                commonFunctionKotlin.isElementPresent(androidDriver, By.id(videoPageObject.videoWallElementsRelease[i]))
            }
            pressBack()

        } catch (e: NullPointerException) {
        }

    }

    @Test(priority = 38, description = "Test re-arrange topics from bottom to top")
    fun testArrangeTopicsFromBottomToTop() {
        commonFunctionKotlin.startTest("Re Arrange Topics from Bottom-to-Top", "Test re-arrange topics from bottom to top", "MyNews")
        commonFunctionKotlin.tapButton(androidDriver, basePageObject.myNews, false)
        commonFunctionKotlin.tapButton(androidDriver, myNewsPageObject.editMyNews, false)

        val india = androidDriver.findElementsById("bbc.mobile.news.uk.internal:id/grab_handle")[5]
        val europe = androidDriver.findElementsById("bbc.mobile.news.uk.internal:id/grab_handle")[0]

        commonFunctionKotlin.elementdragdrop(androidDriver, india, europe)
        commonFunctionKotlin.readRecyclerView(androidDriver, "Topics After  Re-Ordering :- ")

        assertNotEquals("Rape in India", androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='1']/android.widget.RelativeLayout[@index='5']/android.widget.TextView[@index='1']")).text, "Test Didn't Matched")
        assertEquals("Rape in India", androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='1']/android.widget.RelativeLayout[@index='1']/android.widget.TextView[@index='1']")).text, "Test Matched")
        // Assert.assertEquals("European Union",androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='1']/android.widget.RelativeLayout[@index='2']/android.widget.TextView[@index='1']")).getText(), "Test Matched");
        assertEquals("YouTube", androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='1']/android.widget.RelativeLayout[@index='5']/android.widget.TextView[@index='1']")).text, "Test Matched")
        pressBack()
    }


    @Test(priority = 39, description = "Test to check the offline scenario of the app")
    fun testcheckofflinescenario() {
        commonFunctionKotlin.startTest("Going OffLine", "Checking apps offline scenario", "Offline")
        val state = androidDriver.setConnection(ConnectionStateBuilder()
                .withWiFiDisabled()
                .build())
        androidDriver.connection = state
        //        commonFunctionKotlin.waitForScreenToLoad(androidDriver,basePageObject.topStories,10);
        //        commonFunctionKotlin.tapButton(androidDriver,basePageObject.topStories,false);
        //        commonFunctionKotlin.scrolltoElement(androidDriver, homePageObject.videoOfTheDayWatch);
        //        commonFunctionKotlin.tapButton(androidDriver, homePageObject.videoOfTheDayButton, false);
        //        Assert.assertEquals("You're not connected to the internet.", myNewsPageObject.snackbar.getText(), "Text Matched");
    }

    @Test(priority = 40, description = "Test to play a  video, while device offline")
    @Throws(Exception::class)
    fun testplayingvideooffline() {
        try {
            commonFunctionKotlin.startTest("VideoPlayback-Offline", "Checking the Video while device offline", "Offline")
            commonFunctionKotlin.tapButton(androidDriver, basePageObject.video, false)
            commonFunctionKotlin.tapButton(androidDriver, videoPageObject.bbcNewsChannel, false)
            commonFunctionKotlin.elementDisplayed(androidDriver, videoPageObject.liveMediaItemCaption)
            commonFunctionKotlin.elementDisplayed(androidDriver, basePageObject.navigate_back)
            commonFunctionKotlin.elementDisplayed(androidDriver, basePageObject.shareStory)
            commonFunctionKotlin.tapButton(androidDriver, videoPageObject.smpPlaceholderPlayButton, false)
            commonFunctionKotlin.elementDisplayed(androidDriver, basePageObject.smpErrorMessage)
            commonFunctionKotlin.elementDisplayed(androidDriver, basePageObject.smpErrorOkButton)
            commonFunctionKotlin.elementDisplayed(androidDriver, basePageObject.smpRetryButton)
            val state = androidDriver.setConnection(ConnectionStateBuilder()
                    .withWiFiEnabled()
                    .build())
            androidDriver.connection = state
            System.out.println("The Connection state is " + state.isWiFiEnabled)
            commonFunctionKotlin.sleepmethod(1000)
            assertTrue(state.isWiFiEnabled)
            pressBack()
            commonFunctionKotlin.tapButton(androidDriver, basePageObject.myNews, false)
            commonFunctionKotlin.tapButton(androidDriver, basePageObject.popular, false)

        } catch (e: Exception) {
        }

    }


    @Test(priority = 41, description = "Test to play a  video, while device online")
    @Throws(Exception::class)
    fun testPlayingVideoOnLine() {
        try {

            commonFunctionKotlin.startTest("VideoPlayback-Online", "Checking the Video while device Online", "Offline")
            commonFunctionKotlin.tapButton(androidDriver, basePageObject.video, false)
            commonFunctionKotlin.tapButton(androidDriver, videoPageObject.bbcNewsChannel, false)
            commonFunctionKotlin.tapButton(androidDriver, videoPageObject.smpPlaceholderPlayButton, false)
            commonFunctionKotlin.isElementPresent(androidDriver, By.id("bbc.mobile.news.uk:id/smp_error_message"))
            commonFunctionKotlin.isElementPresent(androidDriver, By.id("bbc.mobile.news.uk:id/smp_retry_button"))
            commonFunctionKotlin.isElementPresent(androidDriver, By.id("bbc.mobile.news.uk:id/smp_error_button"))
            pressBack()

        } catch (e: Exception) {

        }

    }

    @AfterMethod
    fun getResult(result: ITestResult) {
        try {
            commonFunctionKotlin.getTestResult(androidDriver, result)
        } catch (e: IOException) {
        }
    }

    @AfterTest
    fun tearDown() {
        commonFunctionKotlin.publishReport()
        androidDriver.closeApp()
        androidDriver.removeApp("bbc.mobile.news.uk")
        androidDriver.quit()
    }
}