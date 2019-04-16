package com.bbcnews.automation.scripts

import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin
import com.bbcnews.automation.commonfunctions.FilePaths.screenshotPath
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
    private lateinit var videoPageObject: VideoPageObjects
    private lateinit var popularPageObject: PopularPageObjects
    private lateinit var basePageObjectModel: BasePageObject
    private lateinit var myTopicsPageObject: MyTopicsPageObject

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
            initialiseObjects()
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
    private fun initialiseObjects() {
        try {
            homePageObject = HomePageObject()
            PageFactory.initElements(AppiumFieldDecorator(androidDriver), homePageObject)

            myNewsPageObject = MyNewsPageObject()
            PageFactory.initElements(AppiumFieldDecorator(androidDriver), myNewsPageObject)

            basePageObjectModel = BasePageObject()
            PageFactory.initElements(AppiumFieldDecorator(androidDriver), basePageObjectModel)

            videoPageObject = VideoPageObjects()
            PageFactory.initElements(AppiumFieldDecorator(androidDriver), videoPageObject)

            popularPageObject = PopularPageObjects()
            PageFactory.initElements(AppiumFieldDecorator(androidDriver), popularPageObject)

            myTopicsPageObject = MyTopicsPageObject()
            PageFactory.initElements(AppiumFieldDecorator(androidDriver), myTopicsPageObject)

            testutility.emptyFolder(screenshotPath)

            // startReport("SmokeTest");
            createrReportHive("SmokeTest", deviceName.toString(), deviceid.toString())
            //createrReportHive("SmokeTest", Deviceos_Name, Device_Name, Device_id)

            androidDriver.context("NATIVE_APP")
            file = File(screenshotPath)
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

            tapButton(androidDriver, basePageObjectModel.okButton, false)
            tapButton(androidDriver, basePageObjectModel.noThanksButton, false)
            try {
                if (androidDriver.findElement(By.id("bbc.mobile.news.uk.internal:id/error_retry")).isDisplayed) {
                    androidDriver.findElement(By.id("bbc.mobile.news.uk.internal:id/error_retry")).click()

                }
            } catch (e: org.openqa.selenium.NoSuchElementException) {
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    /**
     * un-comment if you want to check the screenshot compare tests
     */

//    @Test(priority = 2, description = "takes the screenshot of the topStories, myNews, popular,video and menu page")
//    @Throws(IOException::class)
//    fun testtakeScreenshotsofPages() {
//        tapButton(androidDriver, basePageObjectModel.topStories, false)
//        testutility.AshotScreenshot(androidDriver, "Before", "topStories")
//        tapButton(androidDriver, basePageObjectModel.myNews, false)
//        testutility.AshotScreenshot(androidDriver, "Before", "myNews")
//        tapButton(androidDriver, basePageObjectModel.popular, false)
//        testutility.AshotScreenshot(androidDriver, "Before", "popular")
//        tapButton(androidDriver, basePageObjectModel.video, false)
//        testutility.AshotScreenshot(androidDriver, "Before", "video")
//        tapButton(androidDriver, basePageObjectModel.menuButton, false)
//        testutility.AshotScreenshot(androidDriver, "Before", "menu")
//        navigateBack(androidDriver)
//    }

    /**
     * after app launches, checks the top stories page and assertion
     */

    @Test(priority = 2, description = "Check the links on the Home page after app launched")
    @Story("Home")
    @Severity(SeverityLevel.CRITICAL)
    fun testCheckHomePage() {
        try {
            androidDriver.runAppInBackground(Duration.ofSeconds(30))
            startTest("HomePage", "Checking the HomePage", "Smoke")
            tapButton(androidDriver, basePageObjectModel.topStories, false)
            Assert.assertTrue(basePageObjectModel.topStories.isSelected)
            elementDisplayed(androidDriver, basePageObjectModel.itemLayoutName)
            elementDisplayed(androidDriver, basePageObjectModel.itemLayoutHomeSection)
            elementDisplayed(androidDriver, basePageObjectModel.itemLayoutLastUpdated)
            elementDisplayed(androidDriver, basePageObjectModel.myNews)
            elementDisplayed(androidDriver, basePageObjectModel.popular)
            elementDisplayed(androidDriver, basePageObjectModel.video)
            elementDisplayed(androidDriver, basePageObjectModel.menuButton)
            elementDisplayed(androidDriver, basePageObjectModel.search)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    /**
     * checks the myNews page by allowing the location services
     */

    @Test(priority = 3, description = "Test to check the Mynews page")
    @Story("MyNews")
    @Severity(SeverityLevel.CRITICAL)
    @Throws(Exception::class)
    fun testAllowLocation() {
        try {
            startTest("MyNews", "Checking the MyNews", "Smoke")
            tapButton(androidDriver, basePageObjectModel.myNews, false)//,file.getAbsolutePath());
            tapButton(androidDriver, myNewsPageObject.myNewsStartButton, false)
            tapButton(androidDriver, myNewsPageObject.allowLocation, false)
            tapButton(androidDriver, myNewsPageObject.allowLocationPermission, false)
            navigateBack(androidDriver)
        } catch (e: AssertionError) {
            e.printStackTrace()
        }

    }


    /**
     * checks the popular page most read
     */
    @Test(priority = 4, description = "Test to check the  popular page")
    @Story("Popular")
    @Severity(SeverityLevel.CRITICAL)
    @Throws(Exception::class)
    fun testPopularPage() {
        try {
            startTest("PopularPage", "Checking the Popular", "Smoke")
            tapButton(androidDriver, basePageObjectModel.popular, false)//,file.getAbsolutePath());
            Assert.assertTrue(basePageObjectModel.popular.isSelected)
            elementDisplayed(androidDriver, popularPageObject.mostRead)
            Assert.assertEquals("Most Read", popularPageObject.mostRead.text, "Text Matched")
        } catch (e: AssertionError) {
            e.printStackTrace()
        }

    }

    /**
     * checks the popular most watched
     */

    @Test(priority = 5, description = "checking that most watched displayed in popular page")
    @Story("Popular")
    @Severity(SeverityLevel.CRITICAL)
    fun testCheckMostWatched() {
        try {
            startTest("PopularPage", "Checking most watched displayed the Popular", "Smoke")
            scrolltoElement(androidDriver, popularPageObject.popularMostWatched)
            Assert.assertEquals("Most Watched", popularPageObject.popularMostWatched.text, "Text Matched")
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }


    /**
     * check the MyNews Page
     *
     */

    @Test(priority = 6, description = "Test to check the Mynews page")
    @Story("MyNews")
    @Severity(SeverityLevel.CRITICAL)
    @Throws(Exception::class)
    fun testMyNewsPage() {
        try {
            startTest("MyNews", "Checking the MyNews", "Smoke")
            tapButton(androidDriver, basePageObjectModel.myNews, false)//,file.getAbsolutePath());
            Assert.assertTrue(basePageObjectModel.myNews.isSelected)
            elementDisplayed(androidDriver, myNewsPageObject.myNewsSummary)
            elementDisplayed(androidDriver, myNewsPageObject.myNewsTitle)
            elementDisplayed(androidDriver, myNewsPageObject.addNewsButton)
            Assert.assertEquals(myNewsPageObject.myNewsTitleText, myNewsPageObject.myNewsTitle.text, "Text matched")
            Assert.assertEquals(myNewsPageObject.myNewsSummaryText, myNewsPageObject.myNewsSummary.text, "Text matched")
        } catch (e: AssertionError) {
            e.printStackTrace()
        }

    }

    /**
     * Adding the topics to MyNews
     */
    @Test(priority = 7, description = "Test to check the adding the topics to MyNews page")
    @Severity(SeverityLevel.CRITICAL)
    @Throws(Exception::class)
    fun testAddingTopicsToMyNewsPage() {
        try {
            startTest("MyNews", "Adding topics to MyNews", "Smoke")
            tapButton(androidDriver, myNewsPageObject.myNewsStartButton, false)
            tapButton(androidDriver, myNewsPageObject.addTopics, false)

            Assert.assertEquals("Manchester", myNewsPageObject.localNewsDisplayed.text)
            elementDisplayed(androidDriver, myNewsPageObject.localNewsDisplayed)

            scrolltoElement(androidDriver, myTopicsPageObject.addWalesTopicButton)
            tapButton(androidDriver, myTopicsPageObject.addWalesTopicButton, false)
            textpresent(androidDriver, "Wales", "added to")

            scrolltoElement(androidDriver, myTopicsPageObject.addWorldTopicButton)
            tapButton(androidDriver, myTopicsPageObject.addWorldTopicButton, false)


        } catch (e: StaleElementReferenceException) {
            e.printStackTrace()
        }

    }


    /**
     * Checked the selected topics are getting displayed under Added Topics
     */

    @Test(priority = 8, description = "Test to check whether selected topics displayed under MyTopics page")
    @Story("MyTopics")
    @Severity(SeverityLevel.CRITICAL)
    fun testCheckAddedTopicsUnderMyTopics() {
        try {
            startTest("MyTopics", "Checking Added topics in MyTopics", "Smoke")
            tapButton(androidDriver, myNewsPageObject.myTopics, false)
            elementDisplayed(androidDriver, myTopicsPageObject.walesTopic)
            elementDisplayed(androidDriver, myTopicsPageObject.worldTopic)
            navigateBack(androidDriver)
        } catch (e: Exception) {
        }
    }

    /**
     * Checks for Added topics displayed under My News page
     */

    @Test(priority = 9, description = "Test to check whether added topics displayed under MyNews page")
    @Story("MyNews")
    @Severity(SeverityLevel.CRITICAL)
    fun testCheckAddedTopicsUnderMyNews() {
        try {
            startTest("MyNews", "Checking Added topics in MyNews", "Smoke")
            elementDisplayed(androidDriver, myTopicsPageObject.walesTopic)
            elementDisplayed(androidDriver, myTopicsPageObject.worldTopic)

        } catch (e: Exception) {
        }

    }


    /**
     * removing one of the topics(England) from MyNews-Added Topics
     */
    @Test(priority = 10, description = "Test To remove topics which are displayed under MyNews")
    @Throws(Exception::class)
    fun testMyNewsRemoveTopics() {
        try {
            startTest("Removing Added Topics", "Test to check Topics on MyNews page", "MyNews")
            tapButton(androidDriver, basePageObjectModel.myNews, false)
            tapButton(androidDriver, myNewsPageObject.editMyNews, false)
            try {
                elementDisplayed(androidDriver, myTopicsPageObject.walesTopic)
                elementDisplayed(androidDriver, myTopicsPageObject.worldTopic)
            } catch (e: Exception) {
                e.printStackTrace()
            }

            tapButton(androidDriver, myNewsPageObject.removeTopics, false)
            tapButton(androidDriver, basePageObjectModel.backButton, false)

        } catch (e: NullPointerException) {

        }
    }

    /**
     * Checks the Articles from Topics page, Checks for More button and checks for Less button displayed
     */
    @Test(priority = 11, description = "Test to check the Articles displayed under topics of MyNews page")
    @Throws(Exception::class)
    fun testCheckArticlesOfTopics() {
        try {
            startTest("MyNews", "Checking the Articles displayed under topics of MyNews Page", "Smoke")
            val contentImages = androidDriver.findElements(By.id("bbc.mobile.news.uk.internal:id/content_card_image"))
            val contentCardTitle = androidDriver.findElements(By.id("bbc.mobile.news.uk.internal:id/contentCardTitle"))
            val contentCardUpdated = androidDriver.findElements(By.id("bbc.mobile.news.uk.internal:id/content_card_last_updated"))
            val total = contentImages.size
            System.out.println("The size of cards are$total")

//            for (cardimage in contentImages) {
//                tapButton(androidDriver, cardimage, false)
//                navigateBack(androidDriver)
//            }
            for (i in 0 until total) {

                elementDisplayed(androidDriver, contentCardTitle[i])
                elementDisplayed(androidDriver, contentCardUpdated[i])
            }

            tapButton(androidDriver, myNewsPageObject.showMore, false)

            scrolltoElement(androidDriver, myNewsPageObject.showLess)
            System.out.println("The text of  are:- " + myNewsPageObject.showLess.text)
            tapButton(androidDriver, myNewsPageObject.showLess, false)
            elementDisplayed(androidDriver, myNewsPageObject.showMore)
            System.out.println("The text of  are:- " + myNewsPageObject.showMore.text)


        } catch (e: Exception) {
        }

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
        tapButton(androidDriver, basePageObjectModel.menuButton, false)//,file.getAbsolutePath());
        elementDisplayed(androidDriver, basePageObjectModel.appInfo)
        elementDisplayed(androidDriver, basePageObjectModel.otherBbcApps)
        elementDisplayed(androidDriver, basePageObjectModel.InternalSettings)
        elementDisplayed(androidDriver, basePageObjectModel.settings)
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
        startTest("Videopgae", "Checking the Video", "Smoke")
        tapButton(androidDriver, basePageObjectModel.video, false)
        // AshotScreenshot(androidDriver,"After","VideoPage");
        Assert.assertTrue(basePageObjectModel.video.isSelected)
        // elementDisplayed(androidDriver, videoPageObject.liveBbcChannel);
        tapButton(androidDriver, videoPageObject.bbcNewsChannel, false)//,file.getAbsolutePath());
        elementDisplayed(androidDriver, videoPageObject.liveMediaItemCaption)
        try {
            if (!basePageObjectModel.shareStory.isDisplayed) {
                verticalSwipe(androidDriver, "Up")
                elementDisplayed(androidDriver, basePageObjectModel.shareStory)
            }
        } catch (e: NoSuchElementException) {
        }

        tapButton(androidDriver, videoPageObject.smpPlaceholderPlayButton, false)

    }


    /**
     * check the live video  seeking
     */
    @Test(priority = 14, description = "Test to check whether you can scrub the Live Video and Live Text shouldn't be displayed")
    @Story("VideoPage")
    @Severity(SeverityLevel.CRITICAL)
    @Throws(AssertionError::class, Exception::class)
    fun testCheckLiveVideoSeeking() {

        startTest("VideopageSeeking", "Test to whether you can scrub the Live Video ", "Smoke")

        tapButton(androidDriver, videoPageObject.transportControls, false)
        tapButton(androidDriver, videoPageObject.transportControls, false)
        elementDisplayed(androidDriver, videoPageObject.smpLiveIcon)
        elementDisplayed(androidDriver, videoPageObject.smpVolumeButton)
        elementDisplayed(androidDriver, videoPageObject.smpSeekBar)
        tapButton(androidDriver, videoPageObject.bbcNewsChannel, false)
        tapButton(androidDriver, videoPageObject.smpPlaceholderPlayButton, false)
        try {
            videoplaybackseeking(androidDriver, videoPageObject.smpSeekBar, 0.30)
            isElementPresent(androidDriver, By.id("bbc.mobile.news.uk.internal:id/smpLiveIcon"))
        } catch (e: Exception) {
        }

        navigateBack(androidDriver)
    }

    /**
     * check to search for a topic
     */
    @Test(priority = 15, description = "Test to check for search results")
    fun testSearchStories() {
        try {
            startTest("Search", "Checking for Search Topics", "Smoke")
            tapButton(androidDriver, basePageObjectModel.searchButton, false)
            enterText(basePageObjectModel.searchField, basePageObjectModel.searchText)
            sleepmethod(1000)
            Assert.assertEquals(basePageObjectModel.searchText, basePageObjectModel.searchKeyword.text, "Text Matched")
            tapButton(androidDriver, basePageObjectModel.searchKeyword, false)
            val title = getText(basePageObjectModel.headlineTitle)
            Assert.assertEquals(basePageObjectModel.searchText, title)
            tapButton(androidDriver, basePageObjectModel.backButton, false)
            navigateBack(androidDriver)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    /**
     * un-comment if you want to check the screenshot compare tests
     */
//    @Test(priority = 16, description = "takes the screenshot of the topStories, myNews, popular,video and menu page")
//    @Throws(IOException::class)
//    fun testtakescreenshotafter()
//    {
//        tapButton(androidDriver, basePageObjectModel.topStories, false)
//        testutility.AshotScreenshot(androidDriver, "After", "topStories")
//        tapButton(androidDriver, basePageObjectModel.myNews, false)
//        testutility.AshotScreenshot(androidDriver, "After", "myNews")
//        tapButton(androidDriver, basePageObjectModel.popular, false)
//        testutility.AshotScreenshot(androidDriver, "After", "popular")
//        tapButton(androidDriver, basePageObjectModel.video, false)
//        testutility.AshotScreenshot(androidDriver, "After", "video")
//        tapButton(androidDriver, basePageObjectModel.menuButton, false)
//        testutility.AshotScreenshot(androidDriver, "After", "menu")
//        navigateBack(androidDriver)
//    }
//
//

    /**
     * un-comment if you want to check the screenshot compare tests
     */
//    @Test(priority = 17, description = "Compares the images")
//    @Throws(IOException::class)
//    fun testcomparetheimages()
//    {
//        startTest("CompraeImage", "Compares the HomePage", "Smoke")
//         testutility.comparetwoimages()
//
//    }


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