package com.bbcnews.automation.scripts

import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin
import com.bbcnews.automation.pageobjects.*


import com.bbcnews.automation.testutils.Testutility
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import io.appium.java_client.remote.MobileCapabilityType
import io.qameta.allure.Severity
import io.qameta.allure.SeverityLevel
import io.qameta.allure.Story
import org.openqa.selenium.By
import org.openqa.selenium.ScreenOrientation
import org.openqa.selenium.StaleElementReferenceException
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.support.PageFactory
import org.testng.Assert
import org.testng.ITestResult
import org.testng.annotations.*
import java.io.File
import java.io.IOException
import java.net.URL
import java.time.Duration

class BBCNewsSmokeTestKotlin : CommonFunctionKotlin() {
    private var capabilities = DesiredCapabilities()
    private var deviceid: String? = null
    private var deviceName: String? = null
    private var appPath: String? = null
    private var appiumPort: String? = null
    private lateinit var file: File
    private var testutility = Testutility()
    private lateinit var homePageObject: HomePageObject

    private lateinit var androidDriver: AndroidDriver<MobileElement>

    private lateinit var myNewsPageObject: MyNewsPageObject
    private lateinit var vidoePageObject: VideoPageObjects
    private lateinit var popularPageObject: PopularPageObjects
    private lateinit var basePageObjectModel: BasePageObject
    private lateinit var myTopicsPageObject: MyTopicsPageObject


    override var workingDirectory = System.getProperty("user.dir")
    private val screenshotpath = "./Screenshots/"
    private val reportPath = "./Reports/"

    @BeforeTest
    fun runTest() {

        try {

            readDeviceDetailsCommandPrompt()
            setUP()
            /**
             *  checking the connection , since on Hive, sometime device wifi might be in turned OFF
             */
            checkConnection(androidDriver)
            /**
             *  setting the view mode to Portrait , since on Hive, sometime device might be in Landscape mode
             */
            val orientation = androidDriver.orientation
            if (orientation == ScreenOrientation.LANDSCAPE) {
                androidDriver.rotate(ScreenOrientation.PORTRAIT)
            }
            /**
             *  Unlocking device
             */
            val locked = androidDriver.isDeviceLocked
            if (locked) {
                androidDriver.unlockDevice()
            }
            initialiseobjects()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    /**
     *  gets the details of the device, app path , appium port which are passed through command prompt
     */

    private fun readDeviceDetailsCommandPrompt() {
        try {

            deviceid = System.getProperty("DeviceID")
            deviceName = System.getProperty("DeviceName")
            appPath = System.getProperty("AppPath")
            appiumPort = System.getProperty("AppiumPort")
            println("Passed The Device ID is $deviceid")
            println("Passed The Device Name is $deviceName")
            println("Passed The Appium port is $appiumPort")
            println("Passed The Application path  is $appPath")
        } catch (e: Exception) {
            e.printStackTrace()

        }

    }

    /**
     *
     * setup the desired capabilities based on the parameter set
     */

    private fun setUP() {
        try {
            //  appiumStart.startAppium(Integer.parseInt(Appium_Port));
            val appiumurl = "http://127.0.0.1:$appiumPort/wd/hub"
            println("Appium Server Address : - $appiumurl")
            capabilities = DesiredCapabilities()
            capabilities.setCapability(MobileCapabilityType.UDID, deviceid)
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "bbcnews")
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2")
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android")
            capabilities.setCapability("appiumversion", "1.8.1")
            capabilities.setCapability("app", appPath)
            capabilities.setCapability("appPackage", "bbc.mobile.news.uk.internal")
            capabilities.setCapability("appActivity", "bbc.mobile.news.v3.app.TopLevelActivity")
            capabilities.setCapability("--session-override", true)
            androidDriver = AndroidDriver(URL(appiumurl), capabilities)
        } catch (e: Exception) {
        }
    }

    /**
     *
     * function to initialise the page objects for Home page, Video page, popular page
     */
    private fun initialiseobjects() {
        try {
            homePageObject = HomePageObject()
            PageFactory.initElements(AppiumFieldDecorator(androidDriver), homePageObject)

            myNewsPageObject = MyNewsPageObject()
            PageFactory.initElements(AppiumFieldDecorator(androidDriver), myNewsPageObject)

            basePageObjectModel = BasePageObject()
            PageFactory.initElements(AppiumFieldDecorator(androidDriver), basePageObjectModel)

            vidoePageObject = VideoPageObjects()
            PageFactory.initElements(AppiumFieldDecorator(androidDriver), vidoePageObject)

            popularPageObject = PopularPageObjects()
            PageFactory.initElements(AppiumFieldDecorator(androidDriver), popularPageObject)

            myTopicsPageObject = MyTopicsPageObject()
            PageFactory.initElements(AppiumFieldDecorator(androidDriver), myTopicsPageObject)


            testutility.emptyFolder(screenshotpath)
            testutility.emptyFolder(reportPath)


            createrReportHive("SmokeTest", deviceName.toString(), deviceid.toString())

            androidDriver.context("NATIVE_APP")
            file = File(screenshotpath)
            val screenshot = file.absolutePath
            println("The ScreenShot Path is $screenshot")


        } catch (e: NullPointerException) {
            e.printStackTrace()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    /**
     * launches the app and ignores the pop up message
     */
    @Test(priority = 1, description = "Launching the app")
    fun testOpenNewsApp() {
        try {

            tapButton(androidDriver, basePageObjectModel.okbutton, false)

            tapButton(androidDriver, basePageObjectModel.yesbutton, false)
            try {
                if (androidDriver.findElement(By.id("bbc.mobile.news.uk.internal:id/error_retry")).isDisplayed) {
                    androidDriver.findElement(By.id("bbc.mobile.news.uk.internal:id/error_retry")).click()

                }
            } catch (e:NoSuchElementException) {
            }

        } catch (e: Exception) {
        }

    }


    /**
     * This tests will be ignored from execution as we don't want to run this screen compare test
     * to run this tests remove the groups = ["ignoreTest"] from @test
     */

    @Test(groups = ["ignoreTest"], priority = 2, description = "takes the screenshot of the topstories, mynews, popular,video and menu page")
    @Throws(IOException::class)
    fun testtakeScreenshotsofPages() {
        tapButton(androidDriver, basePageObjectModel.topstories, false)
        testutility.AshotScreenshot(androidDriver, "Before", "topstories")
        tapButton(androidDriver, basePageObjectModel.mynews, false)
        testutility.AshotScreenshot(androidDriver, "Before", "mynews")
        tapButton(androidDriver, basePageObjectModel.popular, false)
        testutility.AshotScreenshot(androidDriver, "Before", "popular")
        tapButton(androidDriver, basePageObjectModel.video, false)
        testutility.AshotScreenshot(androidDriver, "Before", "video")
        tapButton(androidDriver, basePageObjectModel.menubutton, false)
        testutility.AshotScreenshot(androidDriver, "Before", "menu")
        navigateBack(androidDriver)
    }

    /**
     * after app launches, checks the top stories page and assertion
     */

    @Test(priority = 4, description = "Check the links on the Home page after app launched")
    fun testCheckHomePage() {
        try {

            startTest("HomePage", "Checking the HomePage", "Smoke")
            tapButton(androidDriver, basePageObjectModel.topstories, false)
            Assert.assertTrue(basePageObjectModel.topstories.isSelected)
            elementDisplayed(androidDriver, basePageObjectModel.mynews)
            elementDisplayed(androidDriver, basePageObjectModel.popular)
            elementDisplayed(androidDriver, basePageObjectModel.video)
            elementDisplayed(androidDriver, basePageObjectModel.menubutton)
            elementDisplayed(androidDriver, basePageObjectModel.search)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    /**

     * This tests will be ignored from execution as we don't want to run this screen compare test
     * to run this tests remove the groups = ["ignoreTest"] from @test
     * Ignoring this tests as VOD isn't displayed
     */

    @Test(priority = 5, description = "Test to check Video of the day displayed and swipe through all the videos")
    fun testVideoofthedayDisplayed() {
        try {
            startTest("VideoOftheDay", "Scroll to a Video of the day", "HomePage")
            sleepmethod(1000)
            scrolltoElement(androidDriver, homePageObject.videoOftheDay_watch)
            elementDisplayed(androidDriver, homePageObject.watchvideo)
            elementDisplayed(androidDriver, homePageObject.promocounter)
            Assert.assertEquals("WATCH", homePageObject.watchvideo.text)
            Assert.assertEquals("7", homePageObject.promocounter.text)
            tapButton(androidDriver, homePageObject.videooftheday_button, false)
            navigateBack(androidDriver)
        } catch (e: AssertionError) {
            throw e
        }

    }

    /**
     * checks the mynews page by allowing the location services
     */

    @Test(priority = 6, description = "Test to check the Mynews page")
    fun testAllowLocation() {

            startTest("MyNews", "Checking the MyNews", "Smoke")
            tapButton(androidDriver, basePageObjectModel.mynews, false)
            tapButton(androidDriver, myNewsPageObject.mynews_startButton, false)
            tapButton(androidDriver, myNewsPageObject.allow_location, false)
            tapButton(androidDriver, myNewsPageObject.allowlocation_premission, false)
            navigateBack(androidDriver)

    }

    /**
     * checks the popular page most read
     */
    @Test(priority = 7, description = "Test to check the  popular page")
    fun testPopularPage() {
        try {
            startTest("PopularPage", "Checking the Popular", "Smoke")
            tapButton(androidDriver, basePageObjectModel.popular, false)
            Assert.assertTrue(basePageObjectModel.popular.isSelected)
            elementDisplayed(androidDriver, popularPageObject.mostread)
            Assert.assertEquals("Most Read", popularPageObject.mostread.text, "Text Matched")
        } catch (e: AssertionError) {
            e.printStackTrace()
        }

    }

    /**
     * checks the popular most watched
     */

    @Test(priority = 8, description = "checking that most watched displayed in popular page")
    fun testcheckMostWatched() {
        try {
            startTest("PopularPage", "Checking most watched displayed the Popular", "Smoke")
            scrolltoElement(androidDriver, popularPageObject.popularmostwatched)
            Assert.assertEquals("Most Watched", popularPageObject.popularmostwatched.text, "Text Matched")
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }


    /**
     * check the MyNews Page
     *
     */

    @Test(priority = 9, description = "Test to check the Mynews page")
    fun testMyNewsPage() {
        try {
            startTest("MyNews", "Checking the MyNews", "Smoke")
            tapButton(androidDriver, basePageObjectModel.mynews, false)
            Assert.assertTrue(basePageObjectModel.mynews.isSelected)
            elementDisplayed(androidDriver, myNewsPageObject.mynews_summary)
            elementDisplayed(androidDriver, myNewsPageObject.mynewstitle)
            elementDisplayed(androidDriver, myNewsPageObject.mynews_startButton)
            Assert.assertEquals(myNewsPageObject.mynewstitle_text, myNewsPageObject.mynewstitle.text, "Text matched")
            Assert.assertEquals(myNewsPageObject.mynewssummary_text, myNewsPageObject.mynews_summary.text, "Text matched")
        } catch (e: AssertionError) {
            e.printStackTrace()
        }

    }

    /**
     * Adding the topics to MyNews
     */
    @Test(priority = 10, description = "Test to check the adding the topics to MyNews page")
    fun testAddingTopicstoMyNewsPage() {
        try {
            startTest("MyNews", "Adding topics to MyNews", "Smoke")
            tapButton(androidDriver, myNewsPageObject.mynews_startButton, false)
            tapButton(androidDriver, myNewsPageObject.addtopics, false)

            /**
             * When running locally. please comment out below two lines of code. since when you run locally
             * the based on Location. it will be London and to run it on Hive. The location will be Manchester
             */
            Assert.assertEquals("Manchester", myNewsPageObject.localnews_displayed.text)
            elementDisplayed(androidDriver, myNewsPageObject.localnews_displayed)

            scrolltoElement(androidDriver, myTopicsPageObject.walestopic)
            tapButton(androidDriver, myTopicsPageObject.walestopic, false)
            textpresent(androidDriver, "Wales", "added to")

            scrolltoElement(androidDriver, myTopicsPageObject.worldtopic)
            tapButton(androidDriver, myTopicsPageObject.worldtopic, false)
        }catch (e : AssertionError){}

    }


    /**
     * Checked the selected topics are getting displayed under Added Topics
     */

    @Test(priority = 11, description = "Test to check whether selected topics displayed under MyTopics page")
    fun testCheckAddedTopicsUnderMyTopics() {
        try {
            startTest("MyTopics", "Checking Added topics in MyTopics", "Smoke")
            tapButton(androidDriver, myNewsPageObject.mytopics, false)
            elementDisplayed(androidDriver, myTopicsPageObject.Walestopic)
            elementDisplayed(androidDriver, myTopicsPageObject.Worldtopic)
            navigateBack(androidDriver)
        } catch (e: Exception) {
        }
    }

    /**
     * Checks for Added topics displayed under My News page
     */

    @Test(priority = 12, description = "Test to check whether added topics displayed under MyNews page")
    fun testCheckAddedTopicsUnderMyNews() {
        try {
            startTest("MyNews", "Checking Added topics in MyNews", "Smoke")
            elementDisplayed(androidDriver, myTopicsPageObject.Walestopic)
            elementDisplayed(androidDriver, myTopicsPageObject.Worldtopic)

        } catch (e: Exception) {
        }

    }


    /**
     * removing one of the topics(England) from MyNews-Added Topics
     */

    @Test(priority = 13, description = "Test To remove topics which are displayed under MyNews")
    fun testMyNewsRemoveTopics() {
            startTest("Removing Added Topics", "Test to check Topics on MyNews page", "MyNews")
            tapButton(androidDriver, basePageObjectModel.mynews, false)
            tapButton(androidDriver, myNewsPageObject.editMyNews, false)
            try {
                elementDisplayed(androidDriver, myTopicsPageObject.Walestopic)
                elementDisplayed(androidDriver, myTopicsPageObject.Worldtopic)
            } catch (e: Exception) {
                e.printStackTrace()
            }

            tapButton(androidDriver, myNewsPageObject.removetopics, false)
            tapButton(androidDriver, basePageObjectModel.backButton, false)


    }

    /**
     * Checks the Articles from Topics page, Checks for More button and checks for Less button displayed
     */


    @Test(priority = 14, description = "Test to check the Articles displayed under topics of MyNews page")
    fun testCheckArtcilesofTopics() {
            startTest("MyNews", "Checking the Articles displayed under topics of MyNews Page", "Smoke")
            val contentImages = androidDriver.findElements(By.id("bbc.mobile.news.uk.internal:id/content_card_image"))
            val contentCardTitle = androidDriver.findElements(By.id("bbc.mobile.news.uk.internal:id/content_card_title"))
            val contentCardUpdated = androidDriver.findElements(By.id("bbc.mobile.news.uk.internal:id/content_card_last_updated"))
            val total = contentImages.size
            System.out.println("The size of cards are$total")
            for (i in 0 until total) {

                elementDisplayed(androidDriver, contentCardTitle[i])
                elementDisplayed(androidDriver, contentCardUpdated[i])
            }

            tapButton(androidDriver, myNewsPageObject.showmore, false)

            scrolltoElement(androidDriver, myNewsPageObject.showless)
            System.out.println("The text of  are:- " + myNewsPageObject.showless.text)
            tapButton(androidDriver, myNewsPageObject.showless, false)
            elementDisplayed(androidDriver, myNewsPageObject.showmore)
            System.out.println("The text of  are:- " + myNewsPageObject.showmore.text)

    }

    /**
     * Open the Menu items and assert whether links are displayed properly
     */
    @Test(priority = 15, description = "Test to Check the Menu Options ")
    @Throws(Exception::class, AssertionError::class)
    fun testMenuPage() {
        startTest("Menu", "Checking the Menu Items", "Smoke")
        tapButton(androidDriver, basePageObjectModel.menubutton, false)//,file.getAbsolutePath());
        elementDisplayed(androidDriver, basePageObjectModel.Appinfo)
        elementDisplayed(androidDriver, basePageObjectModel.OtherBBCapps)
        elementDisplayed(androidDriver, basePageObjectModel.settings)
        elementDisplayed(androidDriver, basePageObjectModel.internalsettings)
        navigateBack(androidDriver)
    }

    /**
     * check the live video on video page
     */

    @Test(priority = 16, description = "Test to check the Video page and selecting the live video for playback and asserting the playback controls")
    @Throws(Exception::class, AssertionError::class)
    fun testVideoPage() {
        startTest("Videopgae", "Checking the Video", "Smoke")
        tapButton(androidDriver, basePageObjectModel.video, false)
        Assert.assertTrue(basePageObjectModel.video.isSelected)
        tapButton(androidDriver, vidoePageObject.bbcnewsChannel, false)//,file.getAbsolutePath());
        elementDisplayed(androidDriver, vidoePageObject.live_media_item_caption)
        try {
            if (!basePageObjectModel.sharestory.isDisplayed) {
                verticalSwipe(androidDriver, "Up")
                elementDisplayed(androidDriver, basePageObjectModel.sharestory)
            }
        } catch (e: NoSuchElementException) {
        }

        tapButton(androidDriver, vidoePageObject.smp_placeholder_play_button, false)

    }


    /**
     * check the live video  seeking
     */
    @Test(priority = 17, description = "Test to check whether you can scrub the Live Video and Live Text shouldn't be displayed")
    fun testCheckLiveVideoSeeking() {

        startTest("VideopageSeeking", "Test to whether you can scrub the Live Video ", "Smoke")

        tapButton(androidDriver, vidoePageObject.transportcontrol, false)
        tapButton(androidDriver, vidoePageObject.transportcontrol, false)
        elementDisplayed(androidDriver, vidoePageObject.smpliveicon)
        elementDisplayed(androidDriver, vidoePageObject.smp_volume_button)
        elementDisplayed(androidDriver, vidoePageObject.smp_seek_bar)
        tapButton(androidDriver, vidoePageObject.bbcnewsChannel, false)
        tapButton(androidDriver, vidoePageObject.smp_placeholder_play_button, false)
        try {
            videoplaybackseeking(androidDriver, vidoePageObject.smp_seek_bar, 0.30)
            isElementPresent(androidDriver, By.id("bbc.mobile.news.uk.internal:id/smp_live_icon"))
        } catch (e: Exception) {
        }

        navigateBack(androidDriver)
    }

    /**
     * check to search for a topic
     */
    @Test(priority = 18, description = "Test to check for search results")
    fun testSearchStories() {

        startTest("Search", "Checking for Search Topics", "Smoke")
        tapButton(androidDriver, basePageObjectModel.searchbutton, false)
        enterText(basePageObjectModel.searchfield, basePageObjectModel.searchtext)
        sleepmethod(1000)
        Assert.assertEquals(basePageObjectModel.searchtext, basePageObjectModel.searchkeyword.text, "Text Matched")
        tapButton(androidDriver, basePageObjectModel.searchkeyword, false)
        tapButton(androidDriver, basePageObjectModel.backButton, false)
        navigateBack(androidDriver)
    }

        /**
         * This tests will be ignored from execution as we don't want to run this screen compare test
         * to run this tests remove the groups = ["ignoreTest"] from @test
         */

        @Test(groups = ["ignoreTest"], priority = 19, description = "compares the screenshot of the topstories, mynews, popular,video and menu page")
        @Throws(IOException::class)
        fun testtakescreenshotafter() {
            tapButton(androidDriver, basePageObjectModel.topstories, false)
            testutility.AshotScreenshot(androidDriver, "After", "topstories")
            tapButton(androidDriver, basePageObjectModel.mynews, false)
            testutility.AshotScreenshot(androidDriver, "After", "mynews")
            tapButton(androidDriver, basePageObjectModel.popular, false)
            testutility.AshotScreenshot(androidDriver, "After", "popular")
            tapButton(androidDriver, basePageObjectModel.video, false)
            testutility.AshotScreenshot(androidDriver, "After", "video")
            tapButton(androidDriver, basePageObjectModel.menubutton, false)
            testutility.AshotScreenshot(androidDriver, "After", "menu")
            navigateBack(androidDriver)
        }


        /**
         * This tests will be ignored from execution as we don't want to run this screen compare test
         * to run this tests remove the groups = ["ignoreTest"] from @test
         */

        @Test(groups = ["ignoreTest"], priority = 20, description = "Compares the images")
        @Throws(IOException::class)
        fun testcomparetheimages() {
            startTest("CompraeImage", "Compares the HomePage", "Smoke")
            testutility.comparetwoimages()

        }


        /**
         * Adding the result based on Test execution status. If failed, then a Screenshot will be attached to the reports.
         */
        @AfterMethod
        fun getResult(result: ITestResult) {
            try {
                getTestResult(androidDriver, result)
            } catch (e: IOException) {
            }

        }

        @AfterTest
        fun tearDown() {
            publishReport()
            testutility.emptyFolder("./Screenshots/Before")
            testutility.emptyFolder("./Screenshots/After")
            androidDriver.closeApp()
            androidDriver.removeApp("bbc.mobile.news.uk.internal")
            androidDriver.quit()

        }
    }
