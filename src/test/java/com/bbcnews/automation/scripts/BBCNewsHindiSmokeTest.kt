package com.bbcnews.automation.scripts

import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin
import com.bbcnews.automation.commonfunctions.FilePaths.screenshotPath
import com.bbcnews.automation.commonfunctions.ScreenActions.pressBack
import com.bbcnews.automation.commonfunctions.ScreenAssertions.assertDisplayingElements
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject
import com.bbcnews.automation.pageobjects.HomePageObject
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
import java.net.URL

class BBCNewsHindiSmokeTest {

    private var capabilities = DesiredCapabilities()
    private var deviceid: String? = null
    private var deviceName: String? = null
    private var appPath: String? = null
    private var appiumPort: String? = null
    private var commonFunctionKotlin = CommonFunctionKotlin()
    private var testutility = TestUtility()

    private lateinit var file: File
    private lateinit var androidDriver: AndroidDriver<MobileElement>
    private lateinit var bbcNewsHindiPageObject: BBCNewsHindiPageObject

    @BeforeTest
    fun runTest() {
        readDeviceDetailsCommandPrompt()
        setUp()
        commonFunctionKotlin.checkConnection(androidDriver)
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
        val homePageObject = HomePageObject()

        PageFactory.initElements(AppiumFieldDecorator(androidDriver), homePageObject)

        bbcNewsHindiPageObject = BBCNewsHindiPageObject()
        PageFactory.initElements(AppiumFieldDecorator(androidDriver), bbcNewsHindiPageObject)

        testutility.emptyFolder(screenshotPath)

        commonFunctionKotlin.createAReportHive("Regression", deviceName.toString(), deviceid.toString())

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
        assertEquals("ओके", bbcNewsHindiPageObject.bbchindi_okbutton.text, "Text Matched")
        assertEquals("बीबीसी न्यूज़ आपको नोटिफ़िकेशंस भेजना चाहता है. आप कभी भी सेटिंग्स में जाकर बदलाव कर सकते हैं.", bbcNewsHindiPageObject.bbchindi_message.text)
        commonFunctionKotlin.tapButton(androidDriver, bbcNewsHindiPageObject.bbchindi_okbutton, false)
        commonFunctionKotlin.tapButton(androidDriver, bbcNewsHindiPageObject.nothanksbutton, false)
    }

    @Test(priority = 2, description = "Check the links on the Home page after app launched")
    fun testCheckHomePage() {
        commonFunctionKotlin.startTest("HomePage", "Checking the HomePage", "Smoke")
        commonFunctionKotlin.tapButton(androidDriver, bbcNewsHindiPageObject.bbchindi_homepage, false)
        assertTrue(bbcNewsHindiPageObject.bbchindi_homepage.isSelected)

        assertDisplayingElements(androidDriver, 
                bbcNewsHindiPageObject.mainitem_layout_name,
                bbcNewsHindiPageObject.mainitem_layout_last_updated
        )

        commonFunctionKotlin.tapButton(androidDriver, bbcNewsHindiPageObject.article, false)
        if (!bbcNewsHindiPageObject.frontpage.isDisplayed) {
            System.out.println("Scrolling up")
            commonFunctionKotlin.verticalSwipe(androidDriver, "Up")
        }

        assertDisplayingElements(androidDriver, 
                bbcNewsHindiPageObject.imageitembadge,
                bbcNewsHindiPageObject.headlinetitle,
                bbcNewsHindiPageObject.headlineinfo,
                bbcNewsHindiPageObject.headlineauthorname,
                bbcNewsHindiPageObject.headlineauthortitle
        )

        pressBack()
    }

    @Test(priority = 3, description = "checking the india page")
    fun testIndiaPage() {
        commonFunctionKotlin.startTest("IndiaPage", "Checking the IndiaPage", "Smoke")
        commonFunctionKotlin.tapButton(androidDriver, bbcNewsHindiPageObject.bbchindi_india, false)
        assertTrue(bbcNewsHindiPageObject.bbchindi_india.isSelected)
        assertDisplayingElements(androidDriver, 
                bbcNewsHindiPageObject.mainitem_layout_name,
                bbcNewsHindiPageObject.mainitem_layout_last_updated
        )

        commonFunctionKotlin.tapButton(androidDriver, bbcNewsHindiPageObject.article, false)

        assertDisplayingElements(androidDriver, 
                bbcNewsHindiPageObject.imageitembadge,
                bbcNewsHindiPageObject.headlinetitle,
                bbcNewsHindiPageObject.headlineinfo,
                bbcNewsHindiPageObject.headlineauthorname,
                bbcNewsHindiPageObject.headlineauthortitle
        )

        commonFunctionKotlin.scrollToElement(androidDriver, bbcNewsHindiPageObject.relatedtopics)

        assertDisplayingElements(androidDriver,  bbcNewsHindiPageObject.relatedarticles)
        pressBack()
    }

    @Test(priority = 3, description = "checking the international page")
    fun testInternationalPage() {
        commonFunctionKotlin.startTest("InternationalPage", "Checking the InternationalPage", "Smoke")
        commonFunctionKotlin.tapButton(androidDriver, bbcNewsHindiPageObject.bbchindi_international, false)
        assertTrue(bbcNewsHindiPageObject.bbchindi_international.isSelected)

        assertDisplayingElements(androidDriver, 
                bbcNewsHindiPageObject.mainitem_layout_name,
                bbcNewsHindiPageObject.mainitem_layout_last_updated
        )

        commonFunctionKotlin.tapButton(androidDriver, bbcNewsHindiPageObject.article, false)

        assertDisplayingElements(androidDriver, 
                bbcNewsHindiPageObject.headlinetitle,
                bbcNewsHindiPageObject.headlineinfo
        )

        pressBack()
    }

    @Test(priority = 4, description = "checking the Entertainment page")
    fun testEntertainmentPage() {
        commonFunctionKotlin.startTest("EntertainmentPage", "Checking the EntertainmentPage", "Smoke")
        commonFunctionKotlin.tapButton(androidDriver, bbcNewsHindiPageObject.bbchindi_entertainment, false)
        assertTrue(bbcNewsHindiPageObject.bbchindi_entertainment.isSelected)
        assertDisplayingElements(androidDriver,
                bbcNewsHindiPageObject.mainitem_layout_name,
                bbcNewsHindiPageObject.mainitem_layout_last_updated
        )

        commonFunctionKotlin.tapButton(androidDriver, bbcNewsHindiPageObject.article, false)

        assertDisplayingElements(androidDriver,
                //bbcNewsHindiPageObject.imageitembadge,
                bbcNewsHindiPageObject.headlinetitle,
                bbcNewsHindiPageObject.headlineinfo)


        commonFunctionKotlin.scrollToElement(androidDriver, bbcNewsHindiPageObject.relatedtopics)
        assertDisplayingElements(androidDriver, bbcNewsHindiPageObject.relatedarticles)

        pressBack()
    }

    @Test(priority = 5, description = "checking the Sports page")
    fun testSportsPage() {
        commonFunctionKotlin.startTest("Sports", "Checking the Sports", "Smoke")
        commonFunctionKotlin.tapButton(androidDriver, bbcNewsHindiPageObject.bbchindi_sports, false)
        assertTrue(bbcNewsHindiPageObject.bbchindi_sports.isSelected)

        assertDisplayingElements(androidDriver,
                bbcNewsHindiPageObject.mainitem_layout_name,
                bbcNewsHindiPageObject.mainitem_layout_last_updated
        )

        commonFunctionKotlin.tapButton(androidDriver, bbcNewsHindiPageObject.article, false)

        assertDisplayingElements(androidDriver,
                bbcNewsHindiPageObject.imageitembadge,
                bbcNewsHindiPageObject.headlinetitle,
                bbcNewsHindiPageObject.headlineinfo,
                bbcNewsHindiPageObject.imageitemcaption
        )

        commonFunctionKotlin.scrollToElement(androidDriver, bbcNewsHindiPageObject.relatedtopics)
        assertDisplayingElements(androidDriver, bbcNewsHindiPageObject.relatedarticles)

        pressBack()
    }

    @Test(priority = 6, description = "checking the Radio page")
    fun testRadioPage() {
        commonFunctionKotlin.startTest("Radio", "Checking the Radio", "Smoke")
        commonFunctionKotlin.tapButton(androidDriver, bbcNewsHindiPageObject.bbchindi_radio, false)
        assertTrue(bbcNewsHindiPageObject.bbchindi_radio.isSelected)

        commonFunctionKotlin.elementDisplayed(androidDriver, bbcNewsHindiPageObject.headlinetitle)
        assertEquals("सुनिए", bbcNewsHindiPageObject.headlinetitle.text)
        commonFunctionKotlin.elementDisplayed(androidDriver, bbcNewsHindiPageObject.headlineinfo)
        assertEquals("12 अप्रै 2018", bbcNewsHindiPageObject.headlineinfo.text)

        commonFunctionKotlin.elementDisplayed(androidDriver, bbcNewsHindiPageObject.radiopagetext)
        assertEquals("नमस्कार भारत  (06.30IST - 07.00IST)", bbcNewsHindiPageObject.radiopagetext.text)

        commonFunctionKotlin.elementDisplayed(androidDriver, bbcNewsHindiPageObject.radiopagetextdaily)
        assertEquals("दिनभर (19.30IST - 20.00IST)", bbcNewsHindiPageObject.radiopagetextdaily.text)
    }

    @Test(priority = 7, description = "checking the Science&Technology page")
    fun testScienceTechnologyPage() {
        commonFunctionKotlin.startTest("Science&Technology", "Checking the Science&Technology", "Smoke")
        commonFunctionKotlin.tapButton(androidDriver, bbcNewsHindiPageObject.bbchindi_sciencetechnology, false)
        assertTrue(bbcNewsHindiPageObject.bbchindi_sciencetechnology.isSelected)

        assertDisplayingElements(androidDriver,
                bbcNewsHindiPageObject.mainitem_layout_name,
                bbcNewsHindiPageObject.mainitem_layout_last_updated
        )

        commonFunctionKotlin.tapButton(androidDriver, bbcNewsHindiPageObject.article, false)

        assertDisplayingElements(androidDriver,
                bbcNewsHindiPageObject.headlinetitle,
                bbcNewsHindiPageObject.headlineinfo
        )

        commonFunctionKotlin.scrollToElement(androidDriver, bbcNewsHindiPageObject.relatedtopics)

        pressBack()
    }

    @Test(priority = 8, description = "checking the Science&Technology page")
    fun testLookAtPage() {
        commonFunctionKotlin.startTest("LookAt", "Checking the Science&LookAt Page", "Smoke")
        commonFunctionKotlin.tapButton(androidDriver, bbcNewsHindiPageObject.bbchindi_lookat, false)
        assertTrue(bbcNewsHindiPageObject.bbchindi_lookat.isSelected)

        assertDisplayingElements(androidDriver,
                bbcNewsHindiPageObject.mainitem_layout_name,
                bbcNewsHindiPageObject.mainitem_layout_last_updated
        )

        commonFunctionKotlin.tapButton(androidDriver, bbcNewsHindiPageObject.article, false)

        assertDisplayingElements(androidDriver,
                bbcNewsHindiPageObject.playbutton,
                bbcNewsHindiPageObject.mediaitemcaption,
                bbcNewsHindiPageObject.headlinetitle,
                bbcNewsHindiPageObject.headlineinfo
        )

        commonFunctionKotlin.tapButton(androidDriver, bbcNewsHindiPageObject.playbutton, false)

        assertDisplayingElements(androidDriver,
                bbcNewsHindiPageObject.volumebutton,
                bbcNewsHindiPageObject.Fullscreenbutton,
                bbcNewsHindiPageObject.seekbar,
                bbcNewsHindiPageObject.pausebutton
        )

        pressBack()
    }

    @Test(priority = 9, description = "checking the Pictures  page")
    fun testPicturesPage() {
        commonFunctionKotlin.startTest("Pictures", "Checking the Pictures Page", "Smoke")
        commonFunctionKotlin.tapButton(androidDriver, bbcNewsHindiPageObject.bbchindi_thephotos, false)
        assertTrue(bbcNewsHindiPageObject.bbchindi_thephotos.isSelected)

        assertDisplayingElements(androidDriver,
                bbcNewsHindiPageObject.mainitem_layout_name,
                bbcNewsHindiPageObject.mainitem_layout_last_updated
        )

        commonFunctionKotlin.tapButton(androidDriver, bbcNewsHindiPageObject.article, false)

        assertDisplayingElements(androidDriver,
                bbcNewsHindiPageObject.picturestitle,
                bbcNewsHindiPageObject.picturessubtitle
        )

        for (i in 0..6) {
            val images = androidDriver.findElement(By.xpath("//android.widget.ImageView[@index='$i']"))
            images.isDisplayed
        }
        pressBack()
    }

    @Test(priority = 10, description = "checking the Social  page")
    fun testSocialPage() {
        commonFunctionKotlin.startTest("Social", "Checking the Social Page", "Smoke")
        commonFunctionKotlin.tapButton(androidDriver, bbcNewsHindiPageObject.bbchindi_social, false)
        assertTrue(bbcNewsHindiPageObject.bbchindi_social.isSelected)

        assertDisplayingElements(androidDriver,
                bbcNewsHindiPageObject.mainitem_layout_name,
                bbcNewsHindiPageObject.mainitem_layout_last_updated
        )

        commonFunctionKotlin.tapButton(androidDriver, bbcNewsHindiPageObject.article, false)

        assertDisplayingElements(androidDriver,
                bbcNewsHindiPageObject.headlinetitle,
                bbcNewsHindiPageObject.headlineinfo
        )

        pressBack()
    }

    @Test(priority = 11, description = "Checking the MoreOptions Menu")
    @Story("MoreOptions")
    @Severity(SeverityLevel.CRITICAL)
    fun testMenuItems() {
        commonFunctionKotlin.startTest("MoreOptions", "Checking the MoreOptions Menu", "Smoke")
        commonFunctionKotlin.tapButton(androidDriver, bbcNewsHindiPageObject.bbc_moreoptions, false)

        assertDisplayingElements(androidDriver,
                bbcNewsHindiPageObject.bbchindi_help,
                //  bbcNewsHindiPageObject.bbchindi_Internalsettings,
                bbcNewsHindiPageObject.bbchindi_settings,
                bbcNewsHindiPageObject.bbchindi_pleasecontact,
                bbcNewsHindiPageObject.bbchindi_OtherBBCapplications)
        pressBack()
    }

    @Test(priority = 12, description = "Checking the More Settings Options Menu")
    @Story("MoreOptions")
    @Severity(SeverityLevel.CRITICAL)
    fun testMoreSettingsOptions() {
        commonFunctionKotlin.startTest("MoreOptions", "Checking the More Settings Options Menu", "Smoke")
        commonFunctionKotlin.tapButton(androidDriver, bbcNewsHindiPageObject.bbchindi_Moresettings, false)

        assertDisplayingElements(androidDriver,
                // bbcNewsHindiPageObject.bbchindi_localnews,
                bbcNewsHindiPageObject.bbchindi_topics
        )
    }

    @Test(priority = 13, description = "Checking the More Settings Options Topics")
    @Story("MoreOptions-Topics")
    @Severity(SeverityLevel.CRITICAL)
    fun testMoreSettingsOptions_Topics() {
        commonFunctionKotlin.startTest("MoreOptionsTopics", "Checking the More Settings Options Topics", "Smoke")
        //  commonFunctionKotlin.tapButton(androidDriver,bbcNewsHindiPageObject.bbchindi_topics_collapsegroup,false);
        assertDisplayingElements(androidDriver,
                bbcNewsHindiPageObject.hindihomepage,
                bbcNewsHindiPageObject.hindibharath,
                bbcNewsHindiPageObject.hindienrairnment,
                bbcNewsHindiPageObject.hindiinternatonal,
                bbcNewsHindiPageObject.hindilookat,
                bbcNewsHindiPageObject.hindiphotos,
                bbcNewsHindiPageObject.hindiscience,
                bbcNewsHindiPageObject.hindiphotos,
                bbcNewsHindiPageObject.hindisocial)
    }

    @AfterMethod
    fun getResult(result: ITestResult) {
        commonFunctionKotlin.getTestResult(androidDriver, result)
    }

    @AfterTest
    fun tearDown() {
        commonFunctionKotlin.publishReport()
        androidDriver.closeApp()
        androidDriver.quit()
    }

}
