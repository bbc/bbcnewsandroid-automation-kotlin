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
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.article
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.bbcHindiEntertainment
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.bbcHindiHelp
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.bbcHindiHomepage
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.bbcHindiIndia
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.bbcHindiInternational
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.bbcHindiLookAt
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.bbcHindiMessage
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.bbcHindiMoreSettings
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.bbcHindiOkButton
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.bbcHindiOtherBbcApplications
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.bbcHindiPleaseContact
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.bbcHindiRadio
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.bbcHindiScienceTechnology
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.bbcHindiSettings
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.bbcHindiSocial
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.bbcHindiSports
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.bbcHindiThePhotos
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.bbcHindiTopics
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.bbcMoreOptions
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.frontPage
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.fullScreenButton
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.headlineAuthorName
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.headlineAuthorTitle
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.headlineInfo
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.headlineTitle
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.hindiBharath
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.hindiEntertainment
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.hindiHomepage
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.hindiInternational
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.hindiLookAt
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.hindiPhotos
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.hindiScience
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.hindiSocial
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.imageItemBadge
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.imageItemCaption
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.mainItemLayoutLastUpdated
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.mainItemLayoutName
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.mediaItemCaption
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.noThanksButton
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.pauseButton
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.picturesSubtitle
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.picturesTitle
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.playButton
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.radioPageText
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.radioPageTextDaily
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.relatedArticles
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.relatedTopics
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.seekBar
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.volumeButton
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

        PageFactory.initElements(AppiumFieldDecorator(androidDriver), BBCNewsHindiPageObject)

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
        assertEquals("ओके", bbcHindiOkButton?.text, "Text Matched")
        assertEquals("बीबीसी न्यूज़ आपको नोटिफ़िकेशंस भेजना चाहता है. आप कभी भी सेटिंग्स में जाकर बदलाव कर सकते हैं.", bbcHindiMessage?.text)
        tapButton(androidDriver, bbcHindiOkButton, false)
        tapButton(androidDriver, noThanksButton, false)
    }

    @Test(priority = 2, description = "Check the links on the Home page after app launched")
    fun testCheckHomePage() {
        startTest("HomePage", "Checking the HomePage", "Smoke")
        tapButton(androidDriver, bbcHindiHomepage, false)
        assertTrue(bbcHindiHomepage?.isSelected!!)

        assertDisplayingElements(androidDriver,
                mainItemLayoutName,
                mainItemLayoutLastUpdated
        )

        tapButton(androidDriver, article, false)
        if (frontPage?.isDisplayed!!) {
            System.out.println("Scrolling up")
            verticalSwipe(androidDriver, "Up")
        }

        assertDisplayingElements(androidDriver,
                imageItemBadge,
                headlineTitle,
                headlineInfo,
                headlineAuthorName,
                headlineAuthorTitle
        )

        pressBack()
    }

    @Test(priority = 3, description = "checking the india page")
    fun testIndiaPage() {
        startTest("IndiaPage", "Checking the IndiaPage", "Smoke")
        tapButton(androidDriver, bbcHindiIndia, false)
        assertTrue(bbcHindiIndia?.isSelected!!)
        assertDisplayingElements(androidDriver,
                mainItemLayoutName,
                mainItemLayoutLastUpdated
        )

        tapButton(androidDriver, article, false)

        assertDisplayingElements(androidDriver,
                imageItemBadge,
                headlineTitle,
                headlineInfo,
                headlineAuthorName,
                headlineAuthorTitle
        )

        scrollToElement(androidDriver, relatedTopics)

        assertDisplayingElements(androidDriver, relatedArticles)
        pressBack()
    }

    @Test(priority = 3, description = "checking the international page")
    fun testInternationalPage() {
        startTest("InternationalPage", "Checking the InternationalPage", "Smoke")
        tapButton(androidDriver, bbcHindiInternational, false)
        assertTrue(bbcHindiInternational?.isSelected!!)

        assertDisplayingElements(androidDriver,
                mainItemLayoutName,
                mainItemLayoutLastUpdated
        )

        tapButton(androidDriver, article, false)

        assertDisplayingElements(androidDriver,
                headlineTitle,
                headlineInfo
        )

        pressBack()
    }

    @Test(priority = 4, description = "checking the Entertainment page")
    fun testEntertainmentPage() {
        startTest("EntertainmentPage", "Checking the EntertainmentPage", "Smoke")
        tapButton(androidDriver, bbcHindiEntertainment, false)
        assertTrue(bbcHindiEntertainment?.isSelected!!)
        assertDisplayingElements(androidDriver,
                mainItemLayoutName,
                mainItemLayoutLastUpdated
        )

        tapButton(androidDriver, article, false)

        assertDisplayingElements(androidDriver,
                //imageItemBadge,
                headlineTitle,
                headlineInfo
        )

        scrollToElement(androidDriver, relatedTopics)
        assertDisplayingElements(androidDriver, relatedArticles)

        pressBack()
    }

    @Test(priority = 5, description = "checking the Sports page")
    fun testSportsPage() {
        startTest("Sports", "Checking the Sports", "Smoke")
        tapButton(androidDriver, bbcHindiSports, false)
        assertTrue(bbcHindiSports?.isSelected!!)

        assertDisplayingElements(androidDriver,
                mainItemLayoutName,
                mainItemLayoutLastUpdated
        )

        tapButton(androidDriver, article, false)

        assertDisplayingElements(androidDriver,
                imageItemBadge,
                headlineTitle,
                headlineInfo,
                imageItemCaption
        )

        scrollToElement(androidDriver, relatedTopics)
        assertDisplayingElements(androidDriver, relatedArticles)

        pressBack()
    }

    @Test(priority = 6, description = "checking the Radio page")
    fun testRadioPage() {
        startTest("Radio", "Checking the Radio", "Smoke")
        tapButton(androidDriver, bbcHindiRadio, false)
        assertTrue(bbcHindiRadio?.isSelected!!)

        elementDisplayed(androidDriver, headlineTitle)
        assertEquals("सुनिए", headlineTitle?.text)
        elementDisplayed(androidDriver, headlineInfo)
        assertEquals("12 अप्रै 2018", headlineInfo?.text)

        elementDisplayed(androidDriver, radioPageText)
        assertEquals("नमस्कार भारत  (06.30IST - 07.00IST)", radioPageText?.text)

        elementDisplayed(androidDriver, radioPageTextDaily)
        assertEquals("दिनभर (19.30IST - 20.00IST)", radioPageTextDaily?.text)
    }

    @Test(priority = 7, description = "checking the Science&Technology page")
    fun testScienceTechnologyPage() {
        startTest("Science&Technology", "Checking the Science&Technology", "Smoke")
        tapButton(androidDriver, bbcHindiScienceTechnology, false)
        assertTrue(bbcHindiScienceTechnology?.isSelected!!)

        assertDisplayingElements(androidDriver,
                mainItemLayoutName,
                mainItemLayoutLastUpdated
        )

        tapButton(androidDriver, article, false)

        assertDisplayingElements(androidDriver,
                headlineTitle,
                headlineInfo
        )

        scrollToElement(androidDriver, relatedTopics)

        pressBack()
    }

    @Test(priority = 8, description = "checking the Science&Technology page")
    fun testLookAtPage() {
        startTest("LookAt", "Checking the Science&LookAt Page", "Smoke")
        tapButton(androidDriver, bbcHindiLookAt, false)
        assertTrue(bbcHindiLookAt?.isSelected!!)

        assertDisplayingElements(androidDriver,
                mainItemLayoutName,
                mainItemLayoutLastUpdated
        )

        tapButton(androidDriver, article, false)

        assertDisplayingElements(androidDriver,
                playButton,
                mediaItemCaption,
                headlineTitle,
                headlineInfo
        )

        tapButton(androidDriver, playButton, false)

        assertDisplayingElements(androidDriver,
                volumeButton,
                fullScreenButton,
                seekBar,
                pauseButton
        )

        pressBack()
    }

    @Test(priority = 9, description = "checking the Pictures  page")
    fun testPicturesPage() {
        startTest("Pictures", "Checking the Pictures Page", "Smoke")
        tapButton(androidDriver, bbcHindiThePhotos, false)
        assertTrue(bbcHindiThePhotos?.isSelected!!)

        assertDisplayingElements(androidDriver,
                mainItemLayoutName,
                mainItemLayoutLastUpdated
        )

        tapButton(androidDriver, article, false)

        assertDisplayingElements(androidDriver,
                picturesTitle,
                picturesSubtitle
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
        tapButton(androidDriver, bbcHindiSocial, false)
        assertTrue(bbcHindiSocial?.isSelected!!)

        assertDisplayingElements(androidDriver,
                mainItemLayoutName,
                mainItemLayoutLastUpdated
        )

        tapButton(androidDriver, article, false)

        assertDisplayingElements(androidDriver,
                headlineTitle,
                headlineInfo
        )

        pressBack()
    }

    @Test(priority = 11, description = "Checking the MoreOptions Menu")
    @Story("MoreOptions")
    @Severity(SeverityLevel.CRITICAL)
    fun testMenuItems() {
        startTest("MoreOptions", "Checking the MoreOptions Menu", "Smoke")
        tapButton(androidDriver, bbcMoreOptions, false)

        assertDisplayingElements(androidDriver,
                bbcHindiHelp,
                //  bbcHindiInternalSettings,
                bbcHindiSettings,
                bbcHindiPleaseContact,
                bbcHindiOtherBbcApplications)
        pressBack()
    }

    @Test(priority = 12, description = "Checking the More Settings Options Menu")
    @Story("MoreOptions")
    @Severity(SeverityLevel.CRITICAL)
    fun testMoreSettingsOptions() {
        startTest("MoreOptions", "Checking the More Settings Options Menu", "Smoke")
        tapButton(androidDriver, bbcHindiMoreSettings, false)

        assertDisplayingElements(androidDriver,
                // bbcHindiLocalNews,
                bbcHindiTopics
        )
    }

    @Test(priority = 13, description = "Checking the More Settings Options Topics")
    @Story("MoreOptions-Topics")
    @Severity(SeverityLevel.CRITICAL)
    fun testMoreSettingsOptions_Topics() {
        startTest("MoreOptionsTopics", "Checking the More Settings Options Topics", "Smoke")
        //  tapButton(androidDriver,BBCNewsHindiPageObject.bbcHindiTopicsCollapseGroup,false);
        assertDisplayingElements(androidDriver,
                hindiHomepage,
                hindiBharath,
                hindiEntertainment,
                hindiInternational,
                hindiLookAt,
                hindiScience,
                hindiPhotos,
                hindiSocial)
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
