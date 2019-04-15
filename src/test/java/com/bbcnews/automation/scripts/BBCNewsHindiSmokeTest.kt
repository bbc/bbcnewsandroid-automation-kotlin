package com.bbcnews.automation.scripts

import com.aventstack.extentreports.ExtentTest
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin
import com.bbcnews.automation.commonfunctions.FilePaths.screenshotPath
import com.bbcnews.automation.commonfunctions.ScreenActions.pressBack
import com.bbcnews.automation.commonfunctions.ScreenAssertions.assertDisplayingElements
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject
import com.bbcnews.automation.pageobjects.HomePageObject
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

class BBCNewsHindiSmokeTest {

    private var capabilities = DesiredCapabilities()

    private var deviceid: String? = null
    private var deviceName: String? = null
    private var appPath: String? = null
    private var appiumPort: String? = null
    private lateinit var file: File
    internal var test: ExtentTest? = null

    private lateinit var androidDriver: AndroidDriver<MobileElement>
    private lateinit var bbcNewsHindiPageObject: BBCNewsHindiPageObject

    private var commonFunctionKotlin = CommonFunctionKotlin()
    private var testutility = Testutility()

    @BeforeTest
    @Throws(Exception::class)
    fun runTest() {
        try {
            readDeviceDetailsCommandPrompt()
            setUp()
            commonFunctionKotlin.checkConnection(androidDriver)
            launchBbcNews()
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    private fun readDeviceDetailsCommandPrompt() {
        try {
            deviceid = System.getProperty("DeviceID")
            deviceName = System.getProperty("DeviceName")
            appPath = System.getProperty("AppPath")
            appiumPort = System.getProperty("appiumPort")
            System.out.println("Passed The Device ID is $deviceid")
            System.out.println("Passed The Device Name is $deviceName")
            System.out.println("Passed The Appium port is $appiumPort")
            System.out.println("Passed The Application path  is $appPath")
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun setUp() {
        try {
            val appiumUrl = "http://127.0.0.1:$appiumPort/wd/hub"

            System.out.println("Appium Server Address : - $appiumUrl")
            capabilities = DesiredCapabilities()
            capabilities.setCapability(MobileCapabilityType.UDID, deviceid)
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "bbcnews")
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2")
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android")
            capabilities.setCapability("appiumversion", "1.8.1")
            capabilities.setCapability("app", appPath)
            capabilities.setCapability("appPackage", "uk.co.bbc.hindi.internal")
            capabilities.setCapability("appActivity", "bbc.mobile.news.v3.app.TopLevelActivity")
            capabilities.setCapability(MobileCapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, true)
            capabilities.setCapability("autoAcceptAlerts", true)
            capabilities.setCapability("--session-override", true)
            androidDriver = AndroidDriver(URL(appiumUrl), capabilities)
        } catch (e: Exception) {
        }
    }

    private fun launchBbcNews() {
        try {
            val homePageObject = HomePageObject()

            PageFactory.initElements(AppiumFieldDecorator(androidDriver), homePageObject)

            bbcNewsHindiPageObject = BBCNewsHindiPageObject()
            PageFactory.initElements(AppiumFieldDecorator(androidDriver), bbcNewsHindiPageObject)

            testutility.emptyFolder(screenshotPath)

            commonFunctionKotlin.createrReportHive("Regression", deviceName.toString(), deviceid.toString())

            androidDriver.context("NATIVE_APP")
            file = File(screenshotPath)
            val screenshot = file.absolutePath
            System.out.println("The ScreenShot Path is $screenshot")

            val orientation = androidDriver.orientation
            if (orientation == ScreenOrientation.LANDSCAPE) {
                androidDriver.rotate(ScreenOrientation.PORTRAIT)
            }

        } catch (e: NullPointerException) {
            e.printStackTrace()
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    @Test(priority = 1, description = "launching the app ")
    @Story("Home")
    @Severity(SeverityLevel.CRITICAL)
    @Throws(Exception::class)
    fun testOpenNewsApp() {
        try {

            assertEquals("ओके", bbcNewsHindiPageObject.bbcHindiOkButton.text, "Text Matched")
            assertEquals("बीबीसी न्यूज़ आपको नोटिफ़िकेशंस भेजना चाहता है. आप कभी भी सेटिंग्स में जाकर बदलाव कर सकते हैं.", bbcNewsHindiPageObject.bbcHindiMessage.text)
            commonFunctionKotlin.tapButton(androidDriver, bbcNewsHindiPageObject.bbcHindiOkButton, false)
            commonFunctionKotlin.tapButton(androidDriver, bbcNewsHindiPageObject.noThanksButton, false)

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    @Test(priority = 2, description = "Check the links on the Home page after app launched")
    fun testCheckHomePage() = try {
        commonFunctionKotlin.startTest("HomePage", "Checking the HomePage", "Smoke")
        commonFunctionKotlin.tapButton(androidDriver, bbcNewsHindiPageObject.bbcHindiHomepage, false)
        assertTrue(bbcNewsHindiPageObject.bbcHindiHomepage.isSelected)

        assertDisplayingElements(
                bbcNewsHindiPageObject.mainItemLayoutName,
                bbcNewsHindiPageObject.mainItemLayoutLastUpdated
        )

        commonFunctionKotlin.tapButton(androidDriver, bbcNewsHindiPageObject.article, false)
        if (!bbcNewsHindiPageObject.frontPage.isDisplayed) {
            System.out.println("Scrolling up")
            commonFunctionKotlin.verticalSwipe(androidDriver, "Up")
        }

        assertDisplayingElements(
                bbcNewsHindiPageObject.imageItemBadge,
                bbcNewsHindiPageObject.headlineTitle,
                bbcNewsHindiPageObject.headlineInfo,
                bbcNewsHindiPageObject.headlineAuthorName,
                bbcNewsHindiPageObject.headlineAuthorTitle
        )

        pressBack()

    } catch (e: Exception) {
    }

    @Test(priority = 3, description = "checking the india page")
    @Throws(Exception::class)
    fun testIndiaPage() {
        commonFunctionKotlin.startTest("IndiaPage", "Checking the IndiaPage", "Smoke")
        commonFunctionKotlin.tapButton(androidDriver, bbcNewsHindiPageObject.bbcHindiIndia, false)
        assertTrue(bbcNewsHindiPageObject.bbcHindiIndia.isSelected)
        assertDisplayingElements(
                bbcNewsHindiPageObject.mainItemLayoutName,
                bbcNewsHindiPageObject.mainItemLayoutLastUpdated
        )

        commonFunctionKotlin.tapButton(androidDriver, bbcNewsHindiPageObject.article, false)

        assertDisplayingElements(
                bbcNewsHindiPageObject.imageItemBadge,
                bbcNewsHindiPageObject.headlineTitle,
                bbcNewsHindiPageObject.headlineInfo,
                bbcNewsHindiPageObject.headlineAuthorName,
                bbcNewsHindiPageObject.headlineAuthorTitle
        )

        commonFunctionKotlin.scrolltoElement(androidDriver, bbcNewsHindiPageObject.relatedTopics)

        assertDisplayingElements(bbcNewsHindiPageObject.relatedArticles)
        pressBack()
    }

    @Test(priority = 3, description = "checking the international page")
    @Throws(Exception::class)
    fun testInternationalPage() {
        commonFunctionKotlin.startTest("InternationalaPage", "Checking the InternationalPage", "Smoke")
        commonFunctionKotlin.tapButton(androidDriver, bbcNewsHindiPageObject.bbcHindiInternational, false)
        assertTrue(bbcNewsHindiPageObject.bbcHindiInternational.isSelected)

        assertDisplayingElements(
                bbcNewsHindiPageObject.mainItemLayoutName,
                bbcNewsHindiPageObject.mainItemLayoutLastUpdated
        )

        commonFunctionKotlin.tapButton(androidDriver, bbcNewsHindiPageObject.article, false)

        assertDisplayingElements(
                bbcNewsHindiPageObject.headlineTitle,
                bbcNewsHindiPageObject.headlineInfo
        )

        pressBack()
    }


    @Test(priority = 4, description = "checking the Entertainment page")
    @Throws(Exception::class)
    fun testEntertainmentPage() {
        commonFunctionKotlin.startTest("EntertainmentPage", "Checking the EntertainmentPage", "Smoke")
        commonFunctionKotlin.tapButton(androidDriver, bbcNewsHindiPageObject.bbcHindiEntertainment, false)
        assertTrue(bbcNewsHindiPageObject.bbcHindiEntertainment.isSelected)
        assertDisplayingElements(
                bbcNewsHindiPageObject.mainItemLayoutName,
                bbcNewsHindiPageObject.mainItemLayoutLastUpdated
        )

        commonFunctionKotlin.tapButton(androidDriver, bbcNewsHindiPageObject.article, false)

        assertDisplayingElements(
                //bbcNewsHindiPageObject.imageItemBadge,
                bbcNewsHindiPageObject.headlineTitle,
                bbcNewsHindiPageObject.headlineInfo)


        commonFunctionKotlin.scrolltoElement(androidDriver, bbcNewsHindiPageObject.relatedTopics)
        assertDisplayingElements(bbcNewsHindiPageObject.relatedArticles)

        pressBack()
    }

    @Test(priority = 5, description = "checking the Sports page")
    @Throws(Exception::class)
    fun testSportsPage() {
        commonFunctionKotlin.startTest("Sports", "Checking the Sports", "Smoke")
        commonFunctionKotlin.tapButton(androidDriver, bbcNewsHindiPageObject.bbcHindiSports, false)
        assertTrue(bbcNewsHindiPageObject.bbcHindiSports.isSelected)

        assertDisplayingElements(
                bbcNewsHindiPageObject.mainItemLayoutName,
                bbcNewsHindiPageObject.mainItemLayoutLastUpdated
        )

        commonFunctionKotlin.tapButton(androidDriver, bbcNewsHindiPageObject.article, false)

        assertDisplayingElements(
                bbcNewsHindiPageObject.imageItemBadge,
                bbcNewsHindiPageObject.headlineTitle,
                bbcNewsHindiPageObject.headlineInfo,
                bbcNewsHindiPageObject.imageItemCaption
        )

        commonFunctionKotlin.scrolltoElement(androidDriver, bbcNewsHindiPageObject.relatedTopics)
        assertDisplayingElements(bbcNewsHindiPageObject.relatedArticles)

        pressBack()
    }

    @Test(priority = 6, description = "checking the Radio page")
    @Throws(Exception::class)
    fun testRadioPage() {
        commonFunctionKotlin.startTest("Radio", "Checking the Radio", "Smoke")
        commonFunctionKotlin.tapButton(androidDriver, bbcNewsHindiPageObject.bbcHindiRadio, false)
        assertTrue(bbcNewsHindiPageObject.bbcHindiRadio.isSelected)

        commonFunctionKotlin.elementDisplayed(androidDriver, bbcNewsHindiPageObject.headlineTitle)
        assertEquals("सुनिए", bbcNewsHindiPageObject.headlineTitle.text)
        commonFunctionKotlin.elementDisplayed(androidDriver, bbcNewsHindiPageObject.headlineInfo)
        assertEquals("12 अप्रै 2018", bbcNewsHindiPageObject.headlineInfo.text)

        commonFunctionKotlin.elementDisplayed(androidDriver, bbcNewsHindiPageObject.radioPageText)
        assertEquals("नमस्कार भारत  (06.30IST - 07.00IST)", bbcNewsHindiPageObject.radioPageText.text)

        commonFunctionKotlin.elementDisplayed(androidDriver, bbcNewsHindiPageObject.radioPageTextDaily)
        assertEquals("दिनभर (19.30IST - 20.00IST)", bbcNewsHindiPageObject.radioPageTextDaily.text)
    }

    @Test(priority = 7, description = "checking the Science&Technology page")
    @Throws(Exception::class)
    fun testScienceTechnologyPage() {
        commonFunctionKotlin.startTest("Science&Technology", "Checking the Science&Technology", "Smoke")
        commonFunctionKotlin.tapButton(androidDriver, bbcNewsHindiPageObject.bbcHindiScienceTechnology, false)
        assertTrue(bbcNewsHindiPageObject.bbcHindiScienceTechnology.isSelected)

        assertDisplayingElements(
                bbcNewsHindiPageObject.mainItemLayoutName,
                bbcNewsHindiPageObject.mainItemLayoutLastUpdated
        )

        commonFunctionKotlin.tapButton(androidDriver, bbcNewsHindiPageObject.article, false)

        assertDisplayingElements(
                bbcNewsHindiPageObject.headlineTitle,
                bbcNewsHindiPageObject.headlineInfo
        )

        commonFunctionKotlin.scrolltoElement(androidDriver, bbcNewsHindiPageObject.relatedTopics)

        pressBack()
    }

    @Test(priority = 8, description = "checking the Science&Technology page")
    @Throws(Exception::class)
    fun testLookAtPage() {
        commonFunctionKotlin.startTest("LookAt", "Checking the Science&LookAt Page", "Smoke")
        commonFunctionKotlin.tapButton(androidDriver, bbcNewsHindiPageObject.bbcHindiLookAt, false)
        assertTrue(bbcNewsHindiPageObject.bbcHindiLookAt.isSelected)

        assertDisplayingElements(
                bbcNewsHindiPageObject.mainItemLayoutName,
                bbcNewsHindiPageObject.mainItemLayoutLastUpdated
        )

        commonFunctionKotlin.tapButton(androidDriver, bbcNewsHindiPageObject.article, false)

        assertDisplayingElements(
                bbcNewsHindiPageObject.playButton,
                bbcNewsHindiPageObject.mediaItemCaption,
                bbcNewsHindiPageObject.headlineTitle,
                bbcNewsHindiPageObject.headlineInfo
        )

        commonFunctionKotlin.tapButton(androidDriver, bbcNewsHindiPageObject.playButton, false)

        assertDisplayingElements(
                bbcNewsHindiPageObject.volumeButton,
                bbcNewsHindiPageObject.fullScreenButton,
                bbcNewsHindiPageObject.seekBar,
                bbcNewsHindiPageObject.pauseButton
        )

        pressBack()
    }

    @Test(priority = 9, description = "checking the Pictures  page")
    @Throws(Exception::class)
    fun testPicturesPage() {
        commonFunctionKotlin.startTest("Pictures", "Checking the Pictures Page", "Smoke")
        commonFunctionKotlin.tapButton(androidDriver, bbcNewsHindiPageObject.bbcHindiThePhotos, false)
        assertTrue(bbcNewsHindiPageObject.bbcHindiThePhotos.isSelected)

        assertDisplayingElements(
                bbcNewsHindiPageObject.mainItemLayoutName,
                bbcNewsHindiPageObject.mainItemLayoutLastUpdated
        )

        commonFunctionKotlin.tapButton(androidDriver, bbcNewsHindiPageObject.article, false)

        assertDisplayingElements(
                bbcNewsHindiPageObject.picturesTitle,
                bbcNewsHindiPageObject.picturesSubtitle
        )

        for (i in 0..6) {
            val images = androidDriver.findElement(By.xpath("//android.widget.ImageView[@index='$i']"))
            images.isDisplayed
        }
        pressBack()
    }

    @Test(priority = 10, description = "checking the Social  page")
    @Throws(Exception::class)
    fun testSocialPage() {
        commonFunctionKotlin.startTest("Social", "Checking the Social Page", "Smoke")
        commonFunctionKotlin.tapButton(androidDriver, bbcNewsHindiPageObject.bbcHindiSocial, false)
        assertTrue(bbcNewsHindiPageObject.bbcHindiSocial.isSelected)

        assertDisplayingElements(
                bbcNewsHindiPageObject.mainItemLayoutName,
                bbcNewsHindiPageObject.mainItemLayoutLastUpdated
        )

        commonFunctionKotlin.tapButton(androidDriver, bbcNewsHindiPageObject.article, false)

        assertDisplayingElements(
                bbcNewsHindiPageObject.headlineTitle,
                bbcNewsHindiPageObject.headlineInfo
        )

        pressBack()
    }

    @Test(priority = 11, description = "Checking the MoreOptions Menu")
    @Story("MoreOptions")
    @Severity(SeverityLevel.CRITICAL)
    @Throws(Exception::class)
    fun testMenuItems() {
        try {
            commonFunctionKotlin.startTest("MoreOptions", "Checking the MoreOptions Menu", "Smoke")
            commonFunctionKotlin.tapButton(androidDriver, bbcNewsHindiPageObject.bbcMoreOptions, false)

            assertDisplayingElements(
                    bbcNewsHindiPageObject.bbcHindiHelp,
                    //  bbcNewsHindiPageObject.bbcHindiInternalSettings,
                    bbcNewsHindiPageObject.bbcHindiSettings,
                    bbcNewsHindiPageObject.bbcHindiPleaseContact,
                    bbcNewsHindiPageObject.bbcHindiOtherBbcApplications)
            pressBack()

        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    @Test(priority = 12, description = "Checking the More Settings Options Menu")
    @Story("MoreOptions")
    @Severity(SeverityLevel.CRITICAL)
    @Throws(Exception::class)
    fun testMoreSettingsOptions() {
        try {
            commonFunctionKotlin.startTest("MoreOptions", "Checking the More Settings Options Menu", "Smoke")
            commonFunctionKotlin.tapButton(androidDriver, bbcNewsHindiPageObject.bbcHindiMoreSettings, false)

            assertDisplayingElements(
                    // bbcNewsHindiPageObject.bbcHindiLocalNews,
                    bbcNewsHindiPageObject.bbcHindiTopics
            )
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    @Test(priority = 13, description = "Checking the More Settings Options Topics")
    @Story("MoreOptions-Topics")
    @Severity(SeverityLevel.CRITICAL)
    @Throws(Exception::class)
    fun testMoreSettingsOptions_Topics() {
        try {
            commonFunctionKotlin.startTest("MoreOptionsTopics", "Checking the More Settings Options Topics", "Smoke")
            //  commonFunctionKotlin.tapButton(androidDriver,bbcNewsHindiPageObject.bbcHindiTopicsCollapseGroup,false);
            assertDisplayingElements(
                    bbcNewsHindiPageObject.hindiHomepage,
                    bbcNewsHindiPageObject.hindiBharath,
                    bbcNewsHindiPageObject.hindiEntertainment,
                    bbcNewsHindiPageObject.hindiInternational,
                    bbcNewsHindiPageObject.hindiLookAt,
                    bbcNewsHindiPageObject.hindiPhotos,
                    bbcNewsHindiPageObject.hindiScience,
                    bbcNewsHindiPageObject.hindiPhotos,
                    bbcNewsHindiPageObject.hindiSocial)
        } catch (e: Exception) {
            e.printStackTrace()
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
        androidDriver.quit()
    }

}