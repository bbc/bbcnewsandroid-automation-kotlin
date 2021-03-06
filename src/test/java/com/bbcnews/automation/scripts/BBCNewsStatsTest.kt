package com.bbcnews.automation.scripts

import com.bbcnews.automation.commonfunctions.AppiumViewActions.selectView
import com.bbcnews.automation.commonfunctions.AppiumViewActions.startTest
import com.bbcnews.automation.pageobjects.BasePageObject.myNews
import com.bbcnews.automation.pageobjects.BasePageObject.popular
import com.bbcnews.automation.pageobjects.BasePageObject.searchButton
import com.bbcnews.automation.pageobjects.BasePageObject.topStories
import com.bbcnews.automation.pageobjects.BasePageObject.video
import com.bbcnews.automation.pageobjects.StatsTestData
import com.bbcnews.automation.testutils.CharlesProxy
import com.bbcnews.automation.testutils.TestSetup
import com.bbcnews.automation.testutils.TestSetup.androidDriver
import io.qameta.allure.Severity
import io.qameta.allure.SeverityLevel
import io.qameta.allure.Story
import org.testng.annotations.BeforeTest
import org.testng.annotations.Test
import java.io.IOException

class BBCNewsStatsTest : BbcTestCase("Regression") {

    private val charlesProxy = CharlesProxy()
    private val statsTestData = StatsTestData()

    @BeforeTest
    fun beforeEachTest() {
        setUp()
        androidDriver = TestSetup.setAndroidDriver()
    }

    @Test(priority = 2, description = "Test to navigate around app for generate stats")
    @Story("Home")
    @Severity(SeverityLevel.CRITICAL)
    fun statsTestCheckHomePage() {
        try {
            startTest("HomePage", "Checking the HomePage", "Smoke")
            selectView(androidDriver, topStories)
            selectView(androidDriver, myNews)
            selectView(androidDriver, popular)
            selectView(androidDriver, video)
            selectView(androidDriver, searchButton)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    @Test(priority = 3, description = "Test to stop the charles recording ")
    @Throws(Exception::class)
    fun statsTestStopCharlesRecord() {
        try {
            charlesProxy.stopCharlesSession()
            Thread.sleep(2000)
        } catch (e: AssertionError) {
            throw e
        }
    }

    @Test(priority = 4, description = "Test to download the charles recording session")
    @Throws(Exception::class)
    fun statsTestDownloadCharlesRecord() {
        try {
            charlesProxy.downloadCharlesSession()
            Thread.sleep(2000)
        } catch (e: AssertionError) {
            throw e
        }
    }

    @Test(priority = 5, description = "Test to convert the charles session to CSV format")
    @Throws(Exception::class)
    fun statsTestConvertCharlesSessionToCSV() {
        try {
            charlesProxy.convertToCSV()
            Thread.sleep(2000)
            charlesProxy.stopCharles()
        } catch (e: AssertionError) {
            throw e
        }
    }

    @Test(priority = 6, description = "Test to check the compared the downloaded stats")
    fun statsTestBBVNewsBasicStats() {
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
    fun statsTestCheckTopStoresStats() {
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
    fun statsTestCheckMyNewsStats() {
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
    fun statsTestCheckPopularPageStats() {
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
    fun statsTestCheckVideoPageStats() {
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
    fun statsTestCheckPopularStats() {
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
