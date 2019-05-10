package com.bbcnews.automation.scripts

import com.bbcnews.automation.commonfunctions.AppiumViewActions.checkConnection
import com.bbcnews.automation.commonfunctions.AppiumViewActions.emptyFolders
import com.bbcnews.automation.commonfunctions.AppiumViewActions.getTestResult
import com.bbcnews.automation.commonfunctions.AppiumViewActions.publishReport
import com.bbcnews.automation.testutils.TestSetup.androidDriver
import com.bbcnews.automation.testutils.TestSetup.printDeviceDetailsFromCommandPrompt
import com.bbcnews.automation.testutils.TestSetup.setActivity
import com.bbcnews.automation.testutils.TestSetup.setUpTest
import org.testng.ITestResult
import org.testng.annotations.AfterMethod
import org.testng.annotations.AfterTest
import org.testng.annotations.BeforeTest
import java.io.IOException

open class BbcTestCase(private val description: String) {

    private val mainActivity = "bbc.mobile.news.v3.app.TopLevelActivity"
    private val beforeScreenshots = "./Screenshots/Before"
    private val afterScreenshots = "./Screenshots/After"
    private val bbcNewsApp = "bbc.mobile.news.uk.internal"

    @BeforeTest
    fun runTest() {
        printDeviceDetailsFromCommandPrompt()
        setActivity(mainActivity)
        checkConnection(androidDriver)
        setUpTest(description)
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
        emptyFolders(beforeScreenshots, afterScreenshots)
        androidDriver.closeApp()
        androidDriver.removeApp(bbcNewsApp)
        androidDriver.quit()
    }

}