package com.bbcnews.automation.scripts

import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.startTest
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.tapButton
import com.bbcnews.automation.pageobjects.BasePageObject.cpsContent
import com.bbcnews.automation.pageobjects.BasePageObject.internalSettings
import com.bbcnews.automation.pageobjects.BasePageObject.menuButton
import com.bbcnews.automation.pageobjects.BasePageObject.myNews
import com.bbcnews.automation.pageobjects.BasePageObject.navigateBack
import com.bbcnews.automation.pageobjects.BasePageObject.noThanksButton
import com.bbcnews.automation.pageobjects.BasePageObject.okButton
import com.bbcnews.automation.pageobjects.BasePageObject.popular
import com.bbcnews.automation.pageobjects.BasePageObject.reloadButton
import com.bbcnews.automation.pageobjects.BasePageObject.searchButton
import com.bbcnews.automation.pageobjects.BasePageObject.topStories
import com.bbcnews.automation.pageobjects.BasePageObject.trevorTest
import com.bbcnews.automation.pageobjects.BasePageObject.video
import com.bbcnews.automation.pageobjects.StatsTestData
import com.bbcnews.automation.testutils.CharlesProxy
import com.bbcnews.automation.testutils.TestSetup.androidDriver
import io.qameta.allure.Severity
import io.qameta.allure.SeverityLevel
import io.qameta.allure.Story
import org.testng.annotations.Test
import java.io.IOException

class BBCNewsStatsTest : TestCase(
        "bbc.mobile.news.v3.app.TopLevelActivity",
        "Regression"
) {

    private val charlesProxy = CharlesProxy()
    private val statsTestData = StatsTestData()

    @Test(priority = 1, description = "launching the app and start the Charles ")
    @Story("Home")
    @Severity(SeverityLevel.CRITICAL)
    @Throws(Exception::class)
    fun testOpenNewsApp() {
        try {
            tapButton(androidDriver, okButton, false)
            tapButton(androidDriver, noThanksButton, false)
            tapButton(androidDriver, menuButton, false)
            tapButton(androidDriver, internalSettings, false)
            tapButton(androidDriver, cpsContent, false)
            tapButton(androidDriver, trevorTest, false)
            tapButton(androidDriver, navigateBack, false)
            tapButton(androidDriver, reloadButton, false)
            charlesProxy.startCharlesSession()

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    @Test(priority = 2, description = "Test to navigate around app for generate stats")
    @Story("Home")
    @Severity(SeverityLevel.CRITICAL)
    fun testCheckHomePage() {
        try {
            startTest("HomePage", "Checking the HomePage", "Smoke")
            tapButton(androidDriver, topStories, false)
            tapButton(androidDriver, myNews, false)
            tapButton(androidDriver, popular, false)
            tapButton(androidDriver, video, false)
            tapButton(androidDriver, searchButton, false)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    @Test(priority = 3, description = "Test to stop the charles recording ")
    @Throws(Exception::class)
    fun testStopCharlesRecord() {
        try {
            charlesProxy.stopCharlesSession()
            Thread.sleep(2000)
        } catch (e: AssertionError) {
            throw e
        }
    }

    @Test(priority = 4, description = "Test to download the charles recording session")
    @Throws(Exception::class)
    fun testDownloadCharlesRecord() {
        try {
            charlesProxy.downloadCharlesSession()
            Thread.sleep(2000)
        } catch (e: AssertionError) {
            throw e
        }
    }

    @Test(priority = 5, description = "Test to convert the charles session to CSV format")
    @Throws(Exception::class)
    fun testConvertCharlesSessionToCSV() {
        try {
            charlesProxy.convertToCSV()
            Thread.sleep(2000)
            charlesProxy.stopCharles()
        } catch (e: AssertionError) {
            throw e
        }
    }

    @Test(priority = 6, description = "Test to check the compared the downloaded stats")
    fun testBBVNewsBasicStats() {
        startTest("BasicStats", "Test to check the compared the downloaded stats", "Stat's")
        try {
            statsTestData.compareStatsData(statsTestData.csvFile, statsTestData.bbcNewsBasicStats)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    @Test(priority = 7, description = "Test to check the TopStores Page downloaded stats")
    fun testCheckTopStoresStats() {
        startTest("TopStores", "Test to check the TopStores Page downloaded stats", "TopStoriesStat's")
        try {
            statsTestData.compareStatsData(statsTestData.csvFile, statsTestData.topStories)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    @Test(priority = 8, description = "Test to check the MyNews Page downloaded stats")
    fun testCheckMyNewsStats() {
        startTest("MyNews", "Test to check the MyNews Page downloaded stats", "MyNews Stat's")
        try {
            statsTestData.compareStatsData(statsTestData.csvFile, statsTestData.myNews)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    @Test(priority = 9, description = "Test to check the Popular Page downloaded stats")
    fun testCheckPopularPageStats() {
        startTest("Popular", "Test to check the Popular Page downloaded stats", "Popular Stat's")
        try {
            statsTestData.compareStatsData(statsTestData.csvFile, statsTestData.popularPage)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    @Test(priority = 10, description = "Test to check the Video Page downloaded stats")
    fun testCheckVideoPageStats() {
        startTest("Video", "Test to check the Video Page downloaded stats", "Video Stat's")
        try {
            statsTestData.compareStatsData(statsTestData.csvFile, statsTestData.videoPage)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    @Test(priority = 11, description = "Test to check the Search Page downloaded stats")
    fun testCheckPopularStats() {
        startTest("Search", "Test to check the Search Page downloaded stats", "Search Stat's")
        try {
            statsTestData.compareStatsData(statsTestData.csvFile, statsTestData.searchStats)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

}
