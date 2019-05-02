package com.bbcnews.automation.scripts

import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.checkConnection
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.createAReportHive
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.elementDisplayed
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.getTestResult
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.publishReport
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.scrollToElement
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.startTest
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.tapButton
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.verticalSwipe
import com.bbcnews.automation.commonfunctions.FilePaths.screenshotPath
import com.bbcnews.automation.commonfunctions.ScreenActions.pressBack
import com.bbcnews.automation.commonfunctions.ScreenAssertions.assertDisplayingElements
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject
import com.bbcnews.automation.pageobjects.HomePageObject
import com.bbcnews.automation.testutils.TestUtility.emptyFolder
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
import java.net.URL

class BBCNewsHindiSmokeTest {

    private var capabilities = DesiredCapabilities()
    private var deviceid: String? = null
    private var deviceName: String? = null
    private var appPath: String? = null
    private var appiumPort: String? = null

    private lateinit var file: File
    private lateinit var androidDriver: AndroidDriver<MobileElement>
    private lateinit var bbcNewsHindiPageObject: BBCNewsHindiPageObject

    @BeforeTest
    fun runTest() {
        readDeviceDetailsCommandPrompt()
        setUp()
        checkConnection(androidDriver)
        launchBbcNews()
    }

    private fun readDeviceDetailsCommandPrompt() {
        deviceid = System.getProperty("DeviceID")
        deviceName = System.getProperty("DeviceName")
        appPath = System.getProperty("AppPath")
        appiumPort = System.getProperty("appiumPort")
        System.out.println("Passed The Device ID is $deviceid")
        System.out.println("Passed The Device Name is $deviceName")
        System.out.println("Passed The Appium port is $appiumPort")
        System.out.println("Passed The Application path  is $appPath")
    }

    private fun setUp() {
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
    }

    private fun launchBbcNews() {
        PageFactory.initElements(AppiumFieldDecorator(androidDriver), HomePageObject)

        bbcNewsHindiPageObject = BBCNewsHindiPageObject()
        PageFactory.initElements(AppiumFieldDecorator(androidDriver), bbcNewsHindiPageObject)

        emptyFolder(screenshotPath)

        createAReportHive("Regression", deviceName.toString(), deviceid.toString())

        androidDriver.context("NATIVE_APP")
        file = File(screenshotPath)
        val screenshot = file.absolutePath
        System.out.println("The ScreenShot Path is $screenshot")

        val orientation = androidDriver.orientation
        if (orientation == ScreenOrientation.LANDSCAPE) {
            androidDriver.rotate(ScreenOrientation.PORTRAIT)
        }
    }

    @Test(priority = 1, description = "launching the app ")
    @Story("Home")
    @Severity(SeverityLevel.CRITICAL)
    fun testOpenNewsApp() {
        assertEquals("ओके", bbcNewsHindiPageObject.bbcHindiOkButton.text, "Text Matched")
        assertEquals("बीबीसी न्यूज़ आपको नोटिफ़िकेशंस भेजना चाहता है. आप कभी भी सेटिंग्स में जाकर बदलाव कर सकते हैं.", bbcNewsHindiPageObject.bbcHindiMessage.text)
        tapButton(androidDriver, bbcNewsHindiPageObject.bbcHindiOkButton, false)
        tapButton(androidDriver, bbcNewsHindiPageObject.noThanksButton, false)
    }

    @Test(priority = 2, description = "Check the links on the Home page after app launched")
    fun testCheckHomePage() {
        startTest("HomePage", "Checking the HomePage", "Smoke")
        tapButton(androidDriver, bbcNewsHindiPageObject.bbcHindiHomepage, false)
        assertTrue(bbcNewsHindiPageObject.bbcHindiHomepage.isSelected)

        assertDisplayingElements(androidDriver,
                bbcNewsHindiPageObject.mainItemLayoutName,
                bbcNewsHindiPageObject.mainItemLayoutLastUpdated
        )

        tapButton(androidDriver, bbcNewsHindiPageObject.article, false)
        if (!bbcNewsHindiPageObject.frontPage.isDisplayed) {
            System.out.println("Scrolling up")
            verticalSwipe(androidDriver, "Up")
        }

        assertDisplayingElements(androidDriver,
                bbcNewsHindiPageObject.imageItemBadge,
                bbcNewsHindiPageObject.headlineTitle,
                bbcNewsHindiPageObject.headlineInfo,
                bbcNewsHindiPageObject.headlineAuthorName,
                bbcNewsHindiPageObject.headlineAuthorTitle
        )

        pressBack()
    }

    @Test(priority = 3, description = "checking the india page")
    fun testIndiaPage() {
        startTest("IndiaPage", "Checking the IndiaPage", "Smoke")
        tapButton(androidDriver, bbcNewsHindiPageObject.bbcHindiIndia, false)
        assertTrue(bbcNewsHindiPageObject.bbcHindiIndia.isSelected)
        assertDisplayingElements(androidDriver,
                bbcNewsHindiPageObject.mainItemLayoutName,
                bbcNewsHindiPageObject.mainItemLayoutLastUpdated
        )

        tapButton(androidDriver, bbcNewsHindiPageObject.article, false)

        assertDisplayingElements(androidDriver,
                bbcNewsHindiPageObject.imageItemBadge,
                bbcNewsHindiPageObject.headlineTitle,
                bbcNewsHindiPageObject.headlineInfo,
                bbcNewsHindiPageObject.headlineAuthorName,
                bbcNewsHindiPageObject.headlineAuthorTitle
        )

        scrollToElement(androidDriver, bbcNewsHindiPageObject.relatedTopics)

        assertDisplayingElements(androidDriver, bbcNewsHindiPageObject.relatedArticles)
        pressBack()
    }

    @Test(priority = 3, description = "checking the international page")
    fun testInternationalPage() {
        startTest("InternationalPage", "Checking the InternationalPage", "Smoke")
        tapButton(androidDriver, bbcNewsHindiPageObject.bbcHindiInternational, false)
        assertTrue(bbcNewsHindiPageObject.bbcHindiInternational.isSelected)

        assertDisplayingElements(androidDriver,
                bbcNewsHindiPageObject.mainItemLayoutName,
                bbcNewsHindiPageObject.mainItemLayoutLastUpdated
        )

        tapButton(androidDriver, bbcNewsHindiPageObject.article, false)

        assertDisplayingElements(androidDriver,
                bbcNewsHindiPageObject.headlineTitle,
                bbcNewsHindiPageObject.headlineInfo
        )

        pressBack()
    }

    @Test(priority = 4, description = "checking the Entertainment page")
    fun testEntertainmentPage() {
        startTest("EntertainmentPage", "Checking the EntertainmentPage", "Smoke")
        tapButton(androidDriver, bbcNewsHindiPageObject.bbcHindiEntertainment, false)
        assertTrue(bbcNewsHindiPageObject.bbcHindiEntertainment.isSelected)
        assertDisplayingElements(androidDriver,
                bbcNewsHindiPageObject.mainItemLayoutName,
                bbcNewsHindiPageObject.mainItemLayoutLastUpdated
        )

        tapButton(androidDriver, bbcNewsHindiPageObject.article, false)

        assertDisplayingElements(androidDriver,
                //bbcNewsHindiPageObject.imageItemBadge,
                bbcNewsHindiPageObject.headlineTitle,
                bbcNewsHindiPageObject.headlineInfo)


        scrollToElement(androidDriver, bbcNewsHindiPageObject.relatedTopics)
        assertDisplayingElements(androidDriver, bbcNewsHindiPageObject.relatedArticles)

        pressBack()
    }

    @Test(priority = 5, description = "checking the Sports page")
    fun testSportsPage() {
        startTest("Sports", "Checking the Sports", "Smoke")
        tapButton(androidDriver, bbcNewsHindiPageObject.bbcHindiSports, false)
        assertTrue(bbcNewsHindiPageObject.bbcHindiSports.isSelected)

        assertDisplayingElements(androidDriver,
                bbcNewsHindiPageObject.mainItemLayoutName,
                bbcNewsHindiPageObject.mainItemLayoutLastUpdated
        )

        tapButton(androidDriver, bbcNewsHindiPageObject.article, false)

        assertDisplayingElements(androidDriver,
                bbcNewsHindiPageObject.imageItemBadge,
                bbcNewsHindiPageObject.headlineTitle,
                bbcNewsHindiPageObject.headlineInfo,
                bbcNewsHindiPageObject.imageItemCaption
        )

        scrollToElement(androidDriver, bbcNewsHindiPageObject.relatedTopics)
        assertDisplayingElements(androidDriver, bbcNewsHindiPageObject.relatedArticles)

        pressBack()
    }

    @Test(priority = 6, description = "checking the Radio page")
    fun testRadioPage() {
        startTest("Radio", "Checking the Radio", "Smoke")
        tapButton(androidDriver, bbcNewsHindiPageObject.bbcHindiRadio, false)
        assertTrue(bbcNewsHindiPageObject.bbcHindiRadio.isSelected)

        elementDisplayed(androidDriver, bbcNewsHindiPageObject.headlineTitle)
        assertEquals("सुनिए", bbcNewsHindiPageObject.headlineTitle.text)
        elementDisplayed(androidDriver, bbcNewsHindiPageObject.headlineInfo)
        assertEquals("12 अप्रै 2018", bbcNewsHindiPageObject.headlineInfo.text)

        elementDisplayed(androidDriver, bbcNewsHindiPageObject.radioPageText)
        assertEquals("नमस्कार भारत  (06.30IST - 07.00IST)", bbcNewsHindiPageObject.radioPageText.text)

        elementDisplayed(androidDriver, bbcNewsHindiPageObject.radioPageTextDaily)
        assertEquals("दिनभर (19.30IST - 20.00IST)", bbcNewsHindiPageObject.radioPageTextDaily.text)
    }

    @Test(priority = 7, description = "checking the Science&Technology page")
    fun testScienceTechnologyPage() {
        startTest("Science&Technology", "Checking the Science&Technology", "Smoke")
        tapButton(androidDriver, bbcNewsHindiPageObject.bbcHindiScienceTechnology, false)
        assertTrue(bbcNewsHindiPageObject.bbcHindiScienceTechnology.isSelected)

        assertDisplayingElements(androidDriver,
                bbcNewsHindiPageObject.mainItemLayoutName,
                bbcNewsHindiPageObject.mainItemLayoutLastUpdated
        )

        tapButton(androidDriver, bbcNewsHindiPageObject.article, false)

        assertDisplayingElements(androidDriver,
                bbcNewsHindiPageObject.headlineTitle,
                bbcNewsHindiPageObject.headlineInfo
        )

        scrollToElement(androidDriver, bbcNewsHindiPageObject.relatedTopics)

        pressBack()
    }

    @Test(priority = 8, description = "checking the Science&Technology page")
    fun testLookAtPage() {
        startTest("LookAt", "Checking the Science&LookAt Page", "Smoke")
        tapButton(androidDriver, bbcNewsHindiPageObject.bbcHindiLookAt, false)
        assertTrue(bbcNewsHindiPageObject.bbcHindiLookAt.isSelected)

        assertDisplayingElements(androidDriver,
                bbcNewsHindiPageObject.mainItemLayoutName,
                bbcNewsHindiPageObject.mainItemLayoutLastUpdated
        )

        tapButton(androidDriver, bbcNewsHindiPageObject.article, false)

        assertDisplayingElements(androidDriver,
                bbcNewsHindiPageObject.playButton,
                bbcNewsHindiPageObject.mediaItemCaption,
                bbcNewsHindiPageObject.headlineTitle,
                bbcNewsHindiPageObject.headlineInfo
        )

        tapButton(androidDriver, bbcNewsHindiPageObject.playButton, false)

        assertDisplayingElements(androidDriver,
                bbcNewsHindiPageObject.volumeButton,
                bbcNewsHindiPageObject.fullScreenButton,
                bbcNewsHindiPageObject.seekBar,
                bbcNewsHindiPageObject.pauseButton
        )

        pressBack()
    }

    @Test(priority = 9, description = "checking the Pictures  page")
    fun testPicturesPage() {
        startTest("Pictures", "Checking the Pictures Page", "Smoke")
        tapButton(androidDriver, bbcNewsHindiPageObject.bbcHindiThePhotos, false)
        assertTrue(bbcNewsHindiPageObject.bbcHindiThePhotos.isSelected)

        assertDisplayingElements(androidDriver,
                bbcNewsHindiPageObject.mainItemLayoutName,
                bbcNewsHindiPageObject.mainItemLayoutLastUpdated
        )

        tapButton(androidDriver, bbcNewsHindiPageObject.article, false)

        assertDisplayingElements(androidDriver,
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
    fun testSocialPage() {
        startTest("Social", "Checking the Social Page", "Smoke")
        tapButton(androidDriver, bbcNewsHindiPageObject.bbcHindiSocial, false)
        assertTrue(bbcNewsHindiPageObject.bbcHindiSocial.isSelected)

        assertDisplayingElements(androidDriver,
                bbcNewsHindiPageObject.mainItemLayoutName,
                bbcNewsHindiPageObject.mainItemLayoutLastUpdated
        )

        tapButton(androidDriver, bbcNewsHindiPageObject.article, false)

        assertDisplayingElements(androidDriver,
                bbcNewsHindiPageObject.headlineTitle,
                bbcNewsHindiPageObject.headlineInfo
        )

        pressBack()
    }

    @Test(priority = 11, description = "Checking the MoreOptions Menu")
    @Story("MoreOptions")
    @Severity(SeverityLevel.CRITICAL)
    fun testMenuItems() {
        startTest("MoreOptions", "Checking the MoreOptions Menu", "Smoke")
        tapButton(androidDriver, bbcNewsHindiPageObject.bbcMoreOptions, false)

        assertDisplayingElements(androidDriver,
                bbcNewsHindiPageObject.bbcHindiHelp,
                //  bbcNewsHindiPageObject.bbcHindiInternalSettings,
                bbcNewsHindiPageObject.bbcHindiSettings,
                bbcNewsHindiPageObject.bbcHindiPleaseContact,
                bbcNewsHindiPageObject.bbcHindiOtherBbcApplications)
        pressBack()
    }

    @Test(priority = 12, description = "Checking the More Settings Options Menu")
    @Story("MoreOptions")
    @Severity(SeverityLevel.CRITICAL)
    fun testMoreSettingsOptions() {
        startTest("MoreOptions", "Checking the More Settings Options Menu", "Smoke")
        tapButton(androidDriver, bbcNewsHindiPageObject.bbcHindiMoreSettings, false)

        assertDisplayingElements(androidDriver,
                // bbcNewsHindiPageObject.bbcHindiLocalNews,
                bbcNewsHindiPageObject.bbcHindiTopics
        )
    }

    @Test(priority = 13, description = "Checking the More Settings Options Topics")
    @Story("MoreOptions-Topics")
    @Severity(SeverityLevel.CRITICAL)
    fun testMoreSettingsOptions_Topics() {
        startTest("MoreOptionsTopics", "Checking the More Settings Options Topics", "Smoke")
        //  tapButton(androidDriver,bbcNewsHindiPageObject.bbcHindiTopicsCollapseGroup,false);
        assertDisplayingElements(androidDriver,
                bbcNewsHindiPageObject.hindiHomepage,
                bbcNewsHindiPageObject.hindiBharath,
                bbcNewsHindiPageObject.hindiEntertainment,
                bbcNewsHindiPageObject.hindiInternational,
                bbcNewsHindiPageObject.hindiLookAt,
                bbcNewsHindiPageObject.hindiPhotos,
                bbcNewsHindiPageObject.hindiScience,
                bbcNewsHindiPageObject.hindiPhotos,
                bbcNewsHindiPageObject.hindiSocial)
    }

    @AfterMethod
    fun getResult(result: ITestResult) {
        getTestResult(androidDriver, result)
    }

    @AfterTest
    fun tearDown() {
        publishReport()
        androidDriver.closeApp()
        androidDriver.quit()
    }

}
