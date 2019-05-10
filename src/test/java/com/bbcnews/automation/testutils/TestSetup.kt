package com.bbcnews.automation.testutils

import com.bbcnews.automation.commonfunctions.AppiumViewActions.checkConnection
import com.bbcnews.automation.commonfunctions.AppiumViewActions.createAReportHive
import com.bbcnews.automation.commonfunctions.AppiumViewActions.emptyFolders
import com.bbcnews.automation.commonfunctions.FilePaths.screenshotPath
import com.bbcnews.automation.pageobjects.*
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import io.appium.java_client.remote.MobileCapabilityType
import org.openqa.selenium.ScreenOrientation
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.support.PageFactory
import java.io.File
import java.net.URL

object TestSetup {

    lateinit var androidDriver: AndroidDriver<MobileElement>
    private var capabilities = DesiredCapabilities()
    private var deviceid: String? = null
    private var deviceName: String? = null
    private var appPath: String? = null
    private var appiumPort: String? = null

    /**
     * setup the desired capabilities based on the parameter set
     */
    fun setActivity(appPackage: String) {
        //commented out to start appium server, as this taken care by hive, to run locally un-comment below line of code
        //  appiumStart.startAppium(Integer.parseInt(Appium_Port))

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
        capabilities.setCapability("appActivity", appPackage)
        capabilities.setCapability("--session-override", true)
        capabilities.setCapability("autoAcceptAlerts", true)

        androidDriver = AndroidDriver(URL(appiumUrl), capabilities)
    }

    fun setUpTest(reportName: String) {
        initialisePageObjects()
        rotateToPortrait()
        unlockDevice()
        checkConnection(androidDriver)
        emptyFolders(screenshotPath)
        createAReportHive(reportName, deviceName.toString(), deviceid.toString())

        androidDriver.context("NATIVE_APP")

        val screenshotPath = File(screenshotPath).absolutePath
        println("The screenshot path is: $screenshotPath")
    }

    /**
     *  gets the details of the device, app path , appium port which are passed through command prompt
     */
    fun printDeviceDetailsFromCommandPrompt() {
        deviceid = System.getProperty("DeviceID")
        deviceName = System.getProperty("DeviceName")
        appPath = System.getProperty("AppPath")
        appiumPort = System.getProperty("AppiumPort")
        println("The Device ID is: $deviceid")
        println("The Device Name is: $deviceName")
        println("The Appium port is: $appiumPort")
        println("The Application path is: $appPath")
    }

    private fun rotateToPortrait() {
        val orientation = androidDriver.orientation
        if (orientation != ScreenOrientation.LANDSCAPE) {
        } else {
            androidDriver.rotate(ScreenOrientation.PORTRAIT)
        }
    }

    private fun unlockDevice() {
        val locked = androidDriver.isDeviceLocked
        if (locked) androidDriver.unlockDevice()
    }

    private fun initialisePageObjects() {
        val pageObjects = arrayOf(
                HomePageObject,
                MyNewsPageObject,
                BasePageObject,
                VideoPageObjects,
                PopularPageObjects,
                MyTopicsPageObject,
                BBCNewsHindiPageObject,
                CommonPageObjects
        )

        for (pageObject in pageObjects)
            PageFactory.initElements(AppiumFieldDecorator(androidDriver), pageObject)
    }

}
