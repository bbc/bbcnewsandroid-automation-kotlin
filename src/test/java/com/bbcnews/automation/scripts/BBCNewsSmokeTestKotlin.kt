package com.bbcnews.automation.scripts


import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin
import com.bbcnews.automation.commonfunctions.FilePaths.screenshotPath
import com.bbcnews.automation.commonfunctions.ScreenAssertions.assertDisplayingElements
import com.bbcnews.automation.pageobjects.*
import com.bbcnews.automation.testutils.TestUtility
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import io.appium.java_client.remote.MobileCapabilityType
import io.qameta.allure.Severity
import io.qameta.allure.SeverityLevel
import io.qameta.allure.Story
import org.openqa.selenium.By
import org.openqa.selenium.ScreenOrientation
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.support.PageFactory
import org.testng.Assert.assertEquals
import org.testng.Assert.assertTrue
import org.testng.ITestResult
import org.testng.annotations.AfterMethod
import org.testng.annotations.AfterTest
import org.testng.annotations.BeforeTest
import org.testng.annotations.Test
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
    private var testUtility = TestUtility()
    private lateinit var file: File
    private lateinit var homePageObject: HomePageObject
    private lateinit var androidDriver: AndroidDriver<MobileElement>
    private lateinit var myNewsPageObject: MyNewsPageObject
    private lateinit var videoPageObject: VideoPageObjects
    private lateinit var popularPageObject: PopularPageObjects
    private lateinit var basePageObjectModel: BasePageObject
    private lateinit var myTopicsPageObject: MyTopicsPageObject

    @BeforeTest
    fun runTest() {
        readDeviceDetailsCommandPrompt()
        setUp()
        /**
         *  since on Hive, sometimes device wifi might be turned off
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
    }

    /**
     *  gets the details of the device, app path , appium port which are passed through command prompt
     */

    private fun readDeviceDetailsCommandPrompt() {
        deviceid = System.getProperty("DeviceID")
        deviceName = System.getProperty("DeviceName")
        appPath = System.getProperty("AppPath")
        appiumPort = System.getProperty("AppiumPort")
        println("Passed The Device ID is $deviceid")
        println("Passed The Device Name is $deviceName")
        println("Passed The Appium port is $appiumPort")
        println("Passed The Application path  is $appPath")
    }

    /**
     *
     * setup the desired capabilities based on the parameter set
     */
    private fun setUp() {
        //  appiumStart.startAppium(Integer.parseInt(Appium_Port));
        val appiumUrl = "http://127.0.0.1:$appiumPort/wd/hub"
        println("Appium Server Address : - $appiumUrl")
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
        androidDriver = AndroidDriver(URL(appiumUrl), capabilities)
    }

    private fun initialiseObjects() {
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

        testUtility.emptyFolder(screenshotPath)

        // startReport("SmokeTest");
        createAReportHive("SmokeTest", deviceName.toString(), deviceid.toString())
        //createAReportHive("SmokeTest", Deviceos_Name, Device_Name, Device_id)

        androidDriver.context("NATIVE_APP")
        file = File(screenshotPath)
        val screenshot = file.absolutePath
        println("The ScreenShot Path is $screenshot")
    }

    /**
     * launches the app and ignores the pop up message
     */
    @Test(priority = 1, description = "Launching the app")
    fun testOpenNewsApp() {
        tapButton(androidDriver, basePageObjectModel.okButton, false)
        tapButton(androidDriver, basePageObjectModel.noThanksButton, false)

        try {
            androidDriver.findElement(By.id("bbc.mobile.news.uk.internal:id/error_retry")).click()
        } catch (e: Exception) {
            // if the retry button is not present then do nothing
        }

    }

    /**
     * uncomment if you want to check the screenshot compare tests
     */
    @Test(priority = 2, description = "takes the screenshot of the topStories, myNews, popular,video and menu page")
    @Throws(IOException::class)
    fun testTakeScreenshotsOfPages() {
        tapButton(androidDriver, basePageObjectModel.topStories, false)
        testUtility.screenshot(androidDriver, "Before", "topStories")
        tapButton(androidDriver, basePageObjectModel.myNews, false)
        testUtility.screenshot(androidDriver, "Before", "myNews")
        tapButton(androidDriver, basePageObjectModel.popular, false)
        testUtility.screenshot(androidDriver, "Before", "popular")
        tapButton(androidDriver, basePageObjectModel.video, false)
        testUtility.screenshot(androidDriver, "Before", "video")
        tapButton(androidDriver, basePageObjectModel.menuButton, false)
        testUtility.screenshot(androidDriver, "Before", "menu")
        navigateBack(androidDriver)
    }

    @Test(priority = 2, description = "Check the links on the Home page after app launched")
    @Story("Home")
    @Severity(SeverityLevel.CRITICAL)
    fun testCheckHomePage() {
        androidDriver.runAppInBackground(Duration.ofSeconds(30))
        startTest("HomePage", "Checking the HomePage", "Smoke")
        tapButton(androidDriver, basePageObjectModel.topStories, false)
        assertTrue(basePageObjectModel.topStories.isSelected)
        assertDisplayingElements(androidDriver,
                basePageObjectModel.itemLayoutName,
                basePageObjectModel.item_layout_home_section,
                basePageObjectModel.item_layout_last_updated,
                basePageObjectModel.myNews,
                basePageObjectModel.popular,
                basePageObjectModel.video,
                basePageObjectModel.menuButton,
                basePageObjectModel.search
        )
    }

    @Test(priority = 3, description = "Test to check the MyNews page")
    @Story("MyNews")
    @Severity(SeverityLevel.CRITICAL)
    fun testAllowLocation() {
        startTest("MyNews", "Checking the MyNews", "Smoke")
        tapButton(androidDriver, basePageObjectModel.myNews, false)
        tapButton(androidDriver, myNewsPageObject.mynews_startButton, false)
        tapButton(androidDriver, myNewsPageObject.allow_location, false)
        tapButton(androidDriver, myNewsPageObject.allowlocation_premission, false)
        navigateBack(androidDriver)
    }

    @Test(priority = 4, description = "Test to check the popular page")
    @Story("Popular")
    @Severity(SeverityLevel.CRITICAL)
    fun testPopularPage() {
        startTest("PopularPage", "Checking the Popular", "Smoke")
        tapButton(androidDriver, basePageObjectModel.popular, false)
        assertTrue(basePageObjectModel.popular.isSelected)
        assertDisplayingElements(androidDriver, popularPageObject.mostread)
        assertEquals("Most Read", popularPageObject.mostread.text, "Text Matched")
    }

    @Test(priority = 5, description = "checking that most watched displayed in popular page")
    @Story("Popular")
    @Severity(SeverityLevel.CRITICAL)
    fun testMostWatched() {
        startTest("PopularPage", "Checking most watched displayed the Popular", "Smoke")
        scrollToElement(androidDriver, popularPageObject.popularmostwatched)
        assertEquals("Most Watched", popularPageObject.popularmostwatched.text, "Text Matched")
    }

    @Test(priority = 6, description = "Test to check the Mynews page")
    @Story("MyNews")
    @Severity(SeverityLevel.CRITICAL)
    fun testMyNewsPage() {
        startTest("MyNews", "Checking the MyNews", "Smoke")
        tapButton(androidDriver, basePageObjectModel.myNews, false)

        assertTrue(basePageObjectModel.myNews.isSelected)

        assertDisplayingElements(androidDriver,
                myNewsPageObject.mynews_summary,
                myNewsPageObject.mynewstitle,
                myNewsPageObject.addnews_button
        )

        assertEquals(myNewsPageObject.mynewstitle_text, myNewsPageObject.mynewstitle.text, "Text matched")
        assertEquals(myNewsPageObject.mynewssummary_text, myNewsPageObject.mynews_summary.text, "Text matched")
    }

    /**
     * Adding the topics to MyNews
     */
    @Test(priority = 7, description = "Test to check the adding the topics to MyNews page")
    @Severity(SeverityLevel.CRITICAL)
    fun testAddingTopicsToMyNewsPage() {
        startTest("MyNews", "Adding topics to MyNews", "Smoke")
        tapButton(androidDriver, myNewsPageObject.mynews_startButton, false)
        tapButton(androidDriver, myNewsPageObject.addtopics, false)

        assertEquals("Manchester", myNewsPageObject.localnews_displayed.text)
        assertDisplayingElements(androidDriver, myNewsPageObject.localnews_displayed)

        scrollToElement(androidDriver, myTopicsPageObject.walestopic)
        tapButton(androidDriver, myTopicsPageObject.walestopic, false)
        textPresent(androidDriver, "Wales", "added to")

        scrollToElement(androidDriver, myTopicsPageObject.worldtopic)
        tapButton(androidDriver, myTopicsPageObject.worldtopic, false)
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
            tapButton(androidDriver, myNewsPageObject.mytopics, false)
            assertDisplayingElements(androidDriver,
                    myTopicsPageObject.Walestopic,
                    myTopicsPageObject.Worldtopic
            )
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
        startTest("MyNews", "Checking Added topics in MyNews", "Smoke")

        assertDisplayingElements(androidDriver,
                myTopicsPageObject.Walestopic,
                myTopicsPageObject.Worldtopic
        )
    }

    /**
     * removing one of the topics(England) from MyNews-Added Topics
     */

    @Test(priority = 10, description = "Test To remove topics which are displayed under MyNews")
    @Throws(Exception::class)
    fun testMyNewsRemoveTopics() {
        startTest("Removing Added Topics", "Test to check Topics on MyNews page", "MyNews")
        tapButton(androidDriver, basePageObjectModel.myNews, false)
        tapButton(androidDriver, myNewsPageObject.editMyNews, false)

        assertDisplayingElements(androidDriver,
                myTopicsPageObject.Walestopic,
                myTopicsPageObject.Worldtopic
        )

        tapButton(androidDriver, myNewsPageObject.removetopics, false)
        tapButton(androidDriver, basePageObjectModel.backButton, false)
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
        System.out.println("The size of cards are$total")

//            for (cardimage in contentImages) {
//                tapButton(androidDriver, cardimage, false)
//                navigateBack(androidDriver)
//            }
        for (i in 0 until total) {
            assertDisplayingElements(androidDriver,
                    contentCardTitle[i],
                    contentCardUpdated[i]
            )
        }

        tapButton(androidDriver, myNewsPageObject.showmore, false)

        scrollToElement(androidDriver, myNewsPageObject.showless)
        System.out.println("\"Show less\" text= " + myNewsPageObject.showless.text)

        tapButton(androidDriver, myNewsPageObject.showless, false)
        assertDisplayingElements(androidDriver, myNewsPageObject.showmore)
        System.out.println("\"Show more\" text= " + myNewsPageObject.showmore.text)
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
        tapButton(androidDriver, basePageObjectModel.menuButton, false)

        assertDisplayingElements(androidDriver,
                basePageObjectModel.appInfo,
                basePageObjectModel.otherBbcApps,
                basePageObjectModel.InternalSettings,
                basePageObjectModel.settings
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
        tapButton(androidDriver, basePageObjectModel.video, false)
        // aShotScreenshot(androidDriver,"After","VideoPage")
        assertTrue(basePageObjectModel.video.isSelected)
        // assertDisplayingElements(androidDriver,videoPageObject.liveBbcChannel)
        tapButton(androidDriver, videoPageObject.bbcNewsChannel, false)//,file.getAbsolutePath())
        assertDisplayingElements(androidDriver, videoPageObject.liveMediaItemCaption)
        try {
            if (!basePageObjectModel.shareStory.isDisplayed) {
                verticalSwipe(androidDriver, "Up")

                assertDisplayingElements(androidDriver, basePageObjectModel.shareStory)
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
    fun testCheckLiveVideoSeeking() {
        startTest("VideopageSeeking", "Test to whether you can scrub the Live Video ", "Smoke")

        tapButton(androidDriver, videoPageObject.transportControls, false)
        tapButton(androidDriver, videoPageObject.transportControls, false)

        assertDisplayingElements(androidDriver,
                videoPageObject.smpLiveIcon,
                videoPageObject.smpVolumeButton,
                videoPageObject.smpSeekBar
        )

        tapButton(androidDriver, videoPageObject.bbcNewsChannel, false)

        waitForScreenToLoad(androidDriver, videoPageObject.smpPlaceholderPlayButton, 1)
        tapButton(androidDriver, videoPageObject.smpPlaceholderPlayButton, false)

        try {
            videoPlaybackSeeking(androidDriver, videoPageObject.smpSeekBar, 0.30)
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
            waitFor(1000)
            assertEquals(basePageObjectModel.searchText, basePageObjectModel.searchKeyword.text, "Text Matched")
            tapButton(androidDriver, basePageObjectModel.searchKeyword, false)
            val title = getText(basePageObjectModel.headlineTitle)
            assertEquals(basePageObjectModel.searchText, title)
            tapButton(androidDriver, basePageObjectModel.backButton, false)
            navigateBack(androidDriver)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    /**
     * un-comment if you want to check the screenshot compare tests
     */
    @Test(priority = 16, description = "takes the screenshot of the Top Stories, My News, Popular, Video, and Menu pages")
    @Throws(IOException::class)
    fun testTakeScreenShotAfter() {
        tapButton(androidDriver, basePageObjectModel.topStories, false)
        testUtility.screenshot(androidDriver, "After", "topStories")
        tapButton(androidDriver, basePageObjectModel.myNews, false)
        testUtility.screenshot(androidDriver, "After", "myNews")
        tapButton(androidDriver, basePageObjectModel.popular, false)
        testUtility.screenshot(androidDriver, "After", "popular")
        tapButton(androidDriver, basePageObjectModel.video, false)
        testUtility.screenshot(androidDriver, "After", "video")
        tapButton(androidDriver, basePageObjectModel.menuButton, false)
        testUtility.screenshot(androidDriver, "After", "menu")
        navigateBack(androidDriver)
    }

    /**
     * un-comment if you want to check the screenshot compare tests
     */
//    @Test(priority = 17, description = "Compares the images")
//    @Throws(IOException::class)
//    fun testCompareImages()
//    {
//        startTest("CompareImages", "Compares the HomePage", "Smoke")
//         testUtility.compareTwoImages()
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
        testUtility.emptyFolder("./Screenshots/Before")
        testUtility.emptyFolder("./Screenshots/After")
        androidDriver.closeApp()
        androidDriver.removeApp("bbc.mobile.news.uk.internal")
        androidDriver.quit()
    }
}