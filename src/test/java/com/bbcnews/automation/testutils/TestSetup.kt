package com.bbcnews.automation.testutils

import com.bbcnews.automation.testdata.FilePaths
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
    var capabilities = DesiredCapabilities()
    val deviceId: String = System.getProperty("DeviceID")
    val deviceName: String = System.getProperty("DeviceName")
    val deviceOsName: String = System.getProperty("DeviceOS")
    private val appPath: String = System.getProperty("AppPath")
    private val appiumPort: String = System.getProperty("AppiumPort")
    private val appiumUrl: String = "http://127.0.0.1:$appiumPort/wd/hub"
    private val screenshotPath: String = File(FilePaths.screenshotPath).absolutePath

    fun setActivity(appPackage: String) {
        capabilities = DesiredCapabilities()
        capabilities.setCapability(MobileCapabilityType.UDID, deviceId)
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "bbcnews")
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2")
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android")
        capabilities.setCapability("appiumversion", "1.8.1")
        capabilities.setCapability("app", appPath)
        capabilities.setCapability("appPackage", "bbc.mobile.news.uk.internal")
        capabilities.setCapability("appActivity", appPackage)
        capabilities.setCapability("--session-override", true)
        capabilities.setCapability("autoAcceptAlerts", true)
    }

    fun setAndroidDriver(): AndroidDriver<MobileElement> = AndroidDriver(URL(appiumUrl), capabilities)

    fun printDeviceDetailsFromCommandPrompt() = println(
            "Test details: \n" +
                    "Device ID: $deviceId \n" +
                    "Device name: $deviceName \n" +
                    "Device OS version: $deviceOsName \n" +
                    "Appium port: $appiumPort \n" +
                    "Appium server address: - $appiumUrl \n" +
                    "Application path: $appPath \n" +
                    "Screenshot folder path: $screenshotPath"
    )

    fun rotateToPortrait(androidDriver: AndroidDriver<MobileElement>) {
        val orientation = androidDriver.orientation
        if (orientation != ScreenOrientation.LANDSCAPE) {
        } else {
            androidDriver.rotate(ScreenOrientation.PORTRAIT)
        }
    }

    fun unlockDevice(androidDriver: AndroidDriver<MobileElement>) {
        val locked = androidDriver.isDeviceLocked
        if (locked) androidDriver.unlockDevice()
    }

    fun initialisePageObjects(androidDriver: AndroidDriver<MobileElement>) {
        val pageObjects = arrayOf(
                HomePageObject,
                MyNewsPageObject,
                BasePageObject,
                VideoPageObjects,
                PopularPageObjects,
                MyTopicsPageObject,
                BBCNewsHindiPageObject,
                CommonPageObjects,
                IndexPageObjects
        )

        for (pageObject in pageObjects)
            PageFactory.initElements(AppiumFieldDecorator(androidDriver), pageObject)
    }

}
