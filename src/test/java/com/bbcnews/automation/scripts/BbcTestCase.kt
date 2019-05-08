package com.bbcnews.automation.scripts

import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.checkConnection
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.emptyFolder
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.getTestResult
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.publishReport
import com.bbcnews.automation.testutils.TestSetup.androidDriver
import com.bbcnews.automation.testutils.TestSetup.readDeviceDetailsCommandPrompt
import com.bbcnews.automation.testutils.TestSetup.setActivity
import com.bbcnews.automation.testutils.TestSetup.setUpTest
import org.testng.ITestResult
import org.testng.annotations.AfterMethod
import org.testng.annotations.AfterTest
import org.testng.annotations.BeforeTest
import java.io.IOException

open class TestCase(
        private val activity: String,
        private val testType: String
) {

    @BeforeTest
    fun runTest() {
        readDeviceDetailsCommandPrompt()
        setActivity(activity)
        checkConnection(androidDriver)
        setUpTest(testType)
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
        emptyFolder("./Screenshots/Before")
        emptyFolder("./Screenshots/After")
        androidDriver.closeApp()
        androidDriver.removeApp("bbc.mobile.news.uk.internal")
        androidDriver.quit()
    }

}