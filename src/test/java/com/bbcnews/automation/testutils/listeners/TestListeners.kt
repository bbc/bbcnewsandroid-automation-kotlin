package com.bbcnews.automation.testutils.listeners

import org.testng.ITestResult
import java.lang.System.getProperty

object TestListeners {

    private val testCases = ArrayList<Map<String, Any>>()

    fun getTestMethodName(result: ITestResult): String = result.method.constructorOrMethod.name

    fun printBbcNewsSuiteTestResultWithFiles(fullTestResult: ITestResult, resultDescription: String) {
        printBbcNewsSuiteResult(fullTestResult, resultDescription)

        val testCase = HashMap<String, Any>()

        testCase["files"] = ArrayList<String>()
        testCases.add(testCase)
    }

    fun printBbcNewsSuiteResult(result: ITestResult, resultDescription: String) {
        val testMethod = "Test method: " + getTestMethodName(result)
        val testResult = "Test result: $resultDescription"
        println(testMethod + "\n" + testResult)

        val testCase = HashMap<String, Any>()
        testCase["name"] = getTestMethodName(result)
        testCase["suite"] = "BBCNewsSuite"
        testCase["result"] = resultDescription
        testCase["_DeviceName"] = getProperty("DeviceName")
        testCase["_DeviceOS"] = getProperty("DeviceOS")
        testCases.add(testCase)
    }
}