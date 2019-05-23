package com.bbcnews.automation.scripts

import com.bbcnews.automation.commonfunctions.AppiumViewActions.checkConnection
import com.bbcnews.automation.commonfunctions.AppiumViewActions.createAReportHive
import com.bbcnews.automation.commonfunctions.AppiumViewActions.dismissDialogs
import com.bbcnews.automation.commonfunctions.AppiumViewActions.emptyFolders
import com.bbcnews.automation.commonfunctions.AppiumViewActions.getTestResult
import com.bbcnews.automation.commonfunctions.AppiumViewActions.publishReport
import com.bbcnews.automation.testdata.FilePaths.screenshotPath
import com.bbcnews.automation.testutils.TestSetup.androidDriver
import com.bbcnews.automation.testutils.TestSetup.deviceId
import com.bbcnews.automation.testutils.TestSetup.deviceName
import com.bbcnews.automation.testutils.TestSetup.initialisePageObjects
import com.bbcnews.automation.testutils.TestSetup.printDeviceDetailsFromCommandPrompt
import com.bbcnews.automation.testutils.TestSetup.rotateToPortrait
import com.bbcnews.automation.testutils.TestSetup.setActivity
import com.bbcnews.automation.testutils.TestSetup.setAndroidDriver
import com.bbcnews.automation.testutils.TestSetup.unlockDevice
import org.junit.After
import org.testng.ITestResult
import org.testng.annotations.AfterMethod
import java.io.IOException

abstract class BbcTestCase(private val description: String) {

    private val mainActivity = "bbc.mobile.news.v3.app.TopLevelActivity"
    private val beforeScreenshots = "./Screenshots/Before"
    private val afterScreenshots = "./Screenshots/After"
    private val bbcNewsApp = "bbc.mobile.news.uk.internal"


    fun setUp() {
        printDeviceDetailsFromCommandPrompt()
        emptyFolders(screenshotPath)
        createAReportHive(description, deviceName, deviceId)

        setActivity(mainActivity)

        androidDriver = setAndroidDriver()
        androidDriver.context("NATIVE_APP")

        checkConnection(androidDriver)
        initialisePageObjects(androidDriver)
        unlockDevice(androidDriver)
        rotateToPortrait(androidDriver)
        dismissDialogs(androidDriver, 3)
    }


    @AfterMethod
    fun getResult(result: ITestResult) {
        try {
            getTestResult(androidDriver, result)
        } catch (e: IOException) {
        }
    }

    @After
    fun tearDown() {
        publishReport()
        emptyFolders(beforeScreenshots, afterScreenshots)
        androidDriver.closeApp()
        androidDriver.removeApp(bbcNewsApp)
        androidDriver.quit()
    }

}