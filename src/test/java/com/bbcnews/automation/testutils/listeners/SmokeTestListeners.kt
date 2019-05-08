package com.bbcnews.automation.testutils.listeners

import com.bbcnews.automation.testutils.listeners.TestListeners.getTestMethodName
import com.bbcnews.automation.testutils.listeners.TestListeners.printBbcNewsSuiteResult
import com.bbcnews.automation.testutils.listeners.TestListeners.printBbcNewsSuiteTestResultWithFiles
import com.tesults.tesults.Results
import org.testng.ITestContext
import org.testng.ITestListener
import org.testng.ITestResult
import java.util.*

class SmokeTestListeners : ITestListener {

    private val testCases = ArrayList<Map<String, Any>>()

    override fun onTestStart(result: ITestResult) {
        when {
            result.status == ITestResult.STARTED -> println("on test method " + getTestMethodName(result) + " start")
        }
    }

    override fun onStart(context: ITestContext) = println("Starting test: " + context.name)
    override fun onTestSuccess(result: ITestResult) = printBbcNewsSuiteTestResultWithFiles(result, "passed")
    override fun onTestFailure(result: ITestResult) = printBbcNewsSuiteTestResultWithFiles(result, "failed")
    override fun onTestSkipped(result: ITestResult) = printBbcNewsSuiteResult(result, "skipped")

    override fun onTestFailedButWithinSuccessPercentage(result: ITestResult) =
            println("test failed but within success % " + getTestMethodName(result))

    override fun onFinish(context: ITestContext) {
        println("Finishing test: " + context.name)

        val data = HashMap<String, Any>()
        data["target"] = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6ImE5YTJkZDlhLWFhODQtNGUxYy1iODJlLWUxMDc4NjIzYzVmMy0xNTUxOTcwMzY4OTA0IiwiZXhwIjo0MTAyNDQ0ODAwMDAwLCJ2ZXIiOiIwIiwic2VzIjoiOWM3MzFlODUtNzJkMC00NWUxLTk0Y2QtNDMxMjZiMDY2NmJkIiwidHlwZSI6InQifQ.uVod8nG0sp4Ng6L3JFLDTtbewFEAx1tEQTzvgZHUZZg"

        val results = HashMap<String, Any>()
        results["cases"] = testCases
        data["results"] = results

        // Upload
        val response = Results.upload(data)
        println("success: " + response["success"])
        println("message: " + response["message"])
        println("errors: " + response["errors"])
        println("warnings: " + response["warnings"])
    }
}
