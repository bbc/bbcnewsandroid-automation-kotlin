package com.bbcnews.automation.scripts

import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.createAReportHive
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.getTestResult
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.publishReport
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.startTest
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.tapButton
import com.bbcnews.automation.commonfunctions.FilePaths.screenshotPath
import com.bbcnews.automation.pageobjects.*
import com.bbcnews.automation.testutils.CharlesProxy
import com.bbcnews.automation.testutils.TestUtility
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import io.appium.java_client.remote.MobileCapabilityType
import io.qameta.allure.Severity
import io.qameta.allure.SeverityLevel
import io.qameta.allure.Story
import org.openqa.selenium.ScreenOrientation
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.support.PageFactory
import org.testng.ITestResult
import org.testng.annotations.AfterMethod
import org.testng.annotations.AfterTest
import org.testng.annotations.BeforeTest
import org.testng.annotations.Test
import java.io.File
import java.io.IOException
import java.net.URL

class BBCNewsStatsTest {

    private var capabilities = DesiredCapabilities()
    private var deviceOsName: String? = null
    private var deviceId: String? = null
    private var deviceName: String? = null
    private var appPath: String? = null
    private var appiumPort: String? = null
    private var testUtility = TestUtility()
    private var charlesProxy = CharlesProxy()
    private var statsTestData = StatsTestData()

    private lateinit var file: File
    private lateinit var homePageObject: HomePageObject
    private lateinit var androidDriver: AndroidDriver<MobileElement>
    private lateinit var myNewsPageObject: MyNewsPageObject
    private lateinit var videoPageObject: VideoPageObjects
    private lateinit var popularPageObject: PopularPageObjects
    private lateinit var basePageObjectModel: BasePageObject

    @BeforeTest
    @Throws(Exception::class)
    fun runTest() {
        try {
            readDeviceDetailsCommandPrompt()
            charlesProxy.startCharles()
            setUp()
            initialiseObjects()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun readDeviceDetailsCommandPrompt() {
        try {
            deviceOsName = System.getProperty("DeviceOS")
            deviceId = System.getProperty("DeviceID")
            deviceName = System.getProperty("DeviceName")
            appPath = System.getProperty("AppPath")
            appiumPort = System.getProperty("AppiumPort")
            println("Passed The Device OS is $deviceOsName")
            println("Passed The Device ID is $deviceId")
            println("Passed The Device Name is $deviceName")
            println("Passed The Appium port is $appiumPort")
            println("Passed The Application path  is $appPath")
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun setUp() {
        try {
            //  appiumStart.startAppium(Integer.parseInt(Appium_Port));
            val appiumUrl = "http://127.0.0.1:$appiumPort/wd/hub"
            println("Appium Server Address : - $appiumUrl")
            capabilities = DesiredCapabilities()
            capabilities.setCapability(MobileCapabilityType.UDID, deviceId)
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
        } catch (e: Exception) {
        }
    }

    private fun initialiseObjects() = try {
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

        testUtility.emptyFolder(screenshotPath)

        createAReportHive("Regression", deviceName.toString(), deviceId.toString())

        androidDriver.context("NATIVE_APP")
        file = File(screenshotPath)
        val screenshot = file.absolutePath
        println("The ScreenShot Path is $screenshot")

        val orientation = androidDriver.orientation
        if (orientation != ScreenOrientation.LANDSCAPE) {
            androidDriver.rotate(ScreenOrientation.PORTRAIT)
        } else {
        }
    } catch (e: NullPointerException) {
        e.printStackTrace()
    } catch (e: Exception) {
        e.printStackTrace()
    }

    @Test(priority = 1, description = "launching the app and start the Charles ")
    @Story("Home")
    @Severity(SeverityLevel.CRITICAL)
    @Throws(Exception::class)
    fun testOpenNewsApp() {
        try {
            tapButton(androidDriver, basePageObjectModel.okButton, false)
            tapButton(androidDriver, basePageObjectModel.noThanksButton, false)
            tapButton(androidDriver, basePageObjectModel.menuButton, false)
            tapButton(androidDriver, basePageObjectModel.internalSettings, false)
            tapButton(androidDriver, basePageObjectModel.cpsContent, false)
            tapButton(androidDriver, basePageObjectModel.trevorTest, false)
            tapButton(androidDriver, basePageObjectModel.navigate_back, false)
            tapButton(androidDriver, basePageObjectModel.reloadButton, false)
            charlesProxy.startCharlesSession()

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    @Test(priority = 2, description = "Test to navigate around app for generate stats")
    @Story("Home")
    @Severity(SeverityLevel.CRITICAL)
    fun testCheckHomePage() {
        try {
            startTest("HomePage", "Checking the HomePage", "Smoke")
            tapButton(androidDriver, basePageObjectModel.topStories, false)
            tapButton(androidDriver, basePageObjectModel.myNews, false)
            tapButton(androidDriver, basePageObjectModel.popular, false)
            tapButton(androidDriver, basePageObjectModel.video, false)
            tapButton(androidDriver, basePageObjectModel.searchButton, false)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    @Test(priority = 3, description = "Test to stop the charles recording ")
    @Throws(Exception::class)
    fun testStopCharlesRecord() {
        try {
            charlesProxy.stopCharlesSession()
            Thread.sleep(2000)
        } catch (e: AssertionError) {
            throw e
        }
    }

    @Test(priority = 4, description = "Test to download the charles recording session")
    @Throws(Exception::class)
    fun testDownloadCharlesRecord() {
        try {
            charlesProxy.downloadCharlesSession()
            Thread.sleep(2000)
        } catch (e: AssertionError) {
            throw e
        }
    }

    @Test(priority = 5, description = "Test to convert the charles session to CSV format")
    @Throws(Exception::class)
    fun testConvertCharlesSessionToCSV() {
        try {
            charlesProxy.convertToCSV()
            Thread.sleep(2000)
            charlesProxy.stopCharles()
        } catch (e: AssertionError) {
            throw e
        }
    }

    @Test(priority = 6, description = "Test to check the compared the downloaded stats")
    fun testBBVNewsBasicStats() {
        startTest("BasicStats", "Test to check the compared the downloaded stats", "Stat's")
        try {
            statsTestData.compareStatsData(statsTestData.csvFile, statsTestData.bbcNewsBasicStats)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    @Test(priority = 7, description = "Test to check the TopStores Page downloaded stats")
    fun testCheckTopStoresStats() {
        startTest("TopStores", "Test to check the TopStores Page downloaded stats", "TopStoriesStat's")
        try {
            statsTestData.compareStatsData(statsTestData.csvFile, statsTestData.topStories)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }

    }

    @Test(priority = 8, description = "Test to check the MyNews Page downloaded stats")
    fun testCheckMyNewsStats() {
        startTest("MyNews", "Test to check the MyNews Page downloaded stats", "MyNews Stat's")
        try {
            statsTestData.compareStatsData(statsTestData.csvFile, statsTestData.myNews)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    @Test(priority = 9, description = "Test to check the Popular Page downloaded stats")
    fun testCheckPopularPageStats() {
        startTest("Popular", "Test to check the Popular Page downloaded stats", "Popular Stat's")
        try {
            statsTestData.compareStatsData(statsTestData.csvFile, statsTestData.popularPage)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    @Test(priority = 10, description = "Test to check the Video Page downloaded stats")
    fun testCheckVideoPageStats() {
        startTest("Video", "Test to check the Video Page downloaded stats", "Video Stat's")
        try {
            statsTestData.compareStatsData(statsTestData.csvFile, statsTestData.videoPage)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    @Test(priority = 11, description = "Test to check the Search Page downloaded stats")
    fun testCheckPopularStats() {
        startTest("Search", "Test to check the Search Page downloaded stats", "Search Stat's")
        try {
            statsTestData.compareStatsData(statsTestData.csvFile, statsTestData.searchStats)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

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
        androidDriver.closeApp()
        androidDriver.quit()
    }

}


