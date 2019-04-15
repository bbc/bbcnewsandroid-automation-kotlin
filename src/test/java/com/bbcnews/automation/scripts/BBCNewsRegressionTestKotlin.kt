package com.bbcnews.automation.scripts

import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin
import com.bbcnews.automation.commonfunctions.FilePaths.screenshotPath
import com.bbcnews.automation.commonfunctions.ScreenActions.pressBack
import com.bbcnews.automation.commonfunctions.ScreenAssertions.assertDisplayingElements
import com.bbcnews.automation.pageobjects.*
import com.bbcnews.automation.testutils.TestUtility
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.StartsActivity
import io.appium.java_client.android.connection.ConnectionStateBuilder
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import io.appium.java_client.remote.MobileCapabilityType
import io.qameta.allure.Story
import org.openqa.selenium.By
import org.openqa.selenium.ScreenOrientation
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.support.PageFactory
import org.testng.Assert
import org.testng.Assert.*
import org.testng.ITestResult
import org.testng.annotations.AfterMethod
import org.testng.annotations.AfterTest
import org.testng.annotations.BeforeTest
import org.testng.annotations.Test
import java.io.File
import java.lang.System.getProperty
import java.net.URL
import java.time.Duration

class BBCNewsRegressionTestKotlin {

    private var commonFunctionKotlin = CommonFunctionKotlin()
    private var capabilities = DesiredCapabilities()
    private var testutility = TestUtility()
    private var deviceName: String? = null
    private var appiumPort: String? = null
    private var deviceid: String? = null
    private var appPath: String? = null

    private lateinit var file: File
    private lateinit var homePageObject: HomePageObject
    private lateinit var androidDriver: AndroidDriver<MobileElement>
    private lateinit var myNewsPageObject: MyNewsPageObject
    private lateinit var basePageObject: BasePageObject
    private lateinit var videoPageObject: VideoPageObjects
    private lateinit var popularPageObject: PopularPageObjects
    private lateinit var myTopicsPageObject: MyTopicsPageObject

    @BeforeTest
    fun runTest() {
        readDeviceDetailsCommandPrompt()
        setUP()
        commonFunctionKotlin.checkConnection(androidDriver)
        /**
         *  setting the view mode to Portrait , since on Hive sometime device might be in Landscape mode
         */
        val orientation = androidDriver.orientation
        if (orientation == ScreenOrientation.LANDSCAPE) {
            androidDriver.rotate(ScreenOrientation.PORTRAIT)
        }
        initialiseObjects()
    }

    private fun readDeviceDetailsCommandPrompt() {
        deviceid = getProperty("DeviceID")
        deviceName = getProperty("DeviceName")
        appPath = getProperty("AppPath")
        appiumPort = getProperty("AppiumPort")

        println("Passed The Device ID is $deviceid")
        println("Passed The Device Name is $deviceName")
        println("Passed The Appium port is $appiumPort")
        println("Passed The Application path  is $appPath")
    }

    private fun setUP() {
        //  appiumStart.startAppium(Integer.parseInt(Appium_Port));
        val appiumurl = "http://127.0.0.1:$appiumPort/wd/hub"
        println("Appium Server Address : - $appiumurl")
        capabilities = DesiredCapabilities()
        capabilities.setCapability(MobileCapabilityType.UDID, deviceid)
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "bbcnews")
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2")
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android")
        capabilities.setCapability("appiumversion", "1.8.1")
        capabilities.setCapability("app", appPath)
        capabilities.setCapability("appPackage", "bbc.mobile.news.uk.internal")
        capabilities.setCapability("appActivity", "bbc.mobile.news.v3.app.TopLevelActivity")
        capabilities.setCapability("--session-override", true)
        capabilities.setCapability("ignoreUnimportantViews", true)
        androidDriver = AndroidDriver(URL(appiumurl), capabilities)
    }

    private fun initialiseObjects() {
        homePageObject = HomePageObject()
        PageFactory.initElements(AppiumFieldDecorator(androidDriver), homePageObject)

        myNewsPageObject = MyNewsPageObject()
        PageFactory.initElements(AppiumFieldDecorator(androidDriver), myNewsPageObject)

        basePageObject = BasePageObject()
        PageFactory.initElements(AppiumFieldDecorator(androidDriver), basePageObject)

        videoPageObject = VideoPageObjects()
        PageFactory.initElements(AppiumFieldDecorator(androidDriver), videoPageObject)

        popularPageObject = PopularPageObjects()
        PageFactory.initElements(AppiumFieldDecorator(androidDriver), popularPageObject)

        myTopicsPageObject = MyTopicsPageObject()
        PageFactory.initElements(AppiumFieldDecorator(androidDriver), myTopicsPageObject)

        testutility.emptyFolder(screenshotPath)

        commonFunctionKotlin.createAReportHive("Regression", deviceName.toString(), deviceid.toString())

        androidDriver.context("NATIVE_APP")
        file = File(screenshotPath)
        val screenshot = file.absolutePath
        println("The ScreenShot Path is $screenshot")
    }

    @Test(priority = 1, description = "Launching the app")
    fun testOpenNewsApp() {
        commonFunctionKotlin.tapButton(androidDriver, basePageObject.okButton, false)
        commonFunctionKotlin.tapButton(androidDriver, basePageObject.noThanksButton, false)

        if (commonFunctionKotlin.isElementPresent(androidDriver, By.id("bbc.mobile.news.uk.internal:id/error_retry")))
        //    !androidDriver.findElement(By.id("bbc.mobile.news.uk.internal:id/error_retry")).isDisplayed)
        {
            androidDriver.findElement(By.id("bbc.mobile.news.uk.internal:id/error_retry")).click()
            //wait.until(extenttestReport.elementFoundAndClicked(By.id("bbc.mobile.news.uk.internal:id/error_retry")));
        }
    }

    @Test(priority = 2, description = "Test to check whether all links present on Home Page")
    fun testTopStories() {
        commonFunctionKotlin.startTest("Checking the HomePage", "Checking the HomePage", "HomePage")
        commonFunctionKotlin.isElementSelected(basePageObject.topStories)

        assertDisplayingElements(androidDriver,
                basePageObject.topStories,
                basePageObject.myNews,
                basePageObject.popular,
                basePageObject.video,
                basePageObject.search,
                basePageObject.menuButton
        )
    }

    /**
     * commented out as VideoOfTheDay isn't displayed  on Home page
     */

//    @Test(priority = 3, description = "Test to check Video of the day displayed and swipe through all the videos")
//    fun testVideoOfTheDayDisplayed() {
//            commonFunctionKotlin.startTest("VideoOftheDay", "Scroll to a Video of the day", "HomePage")
//            commonFunctionKotlin.waitFor(1000)
//            commonFunctionKotlin.scrollToElement(androidDriver, homePageObject.videoOfTheDayWatch)
//            commonFunctionKotlin.elementDisplayed(androidDriver, homePageObject.videoOfTheDayWatchText)
//            commonFunctionKotlin.elementDisplayed(androidDriver, homePageObject.promoCounter)
//            commonFunctionKotlin.elementDisplayed(androidDriver, homePageObject.videoOfTheDayPromoSummary)
//            commonFunctionKotlin.elementDisplayed(androidDriver, homePageObject.videoOfTheDayTitle)
//            Assert.assertEquals("Videos of the day", homePageObject.videoOfTheDayTitle.getText())
//            Assert.assertEquals("WATCH", homePageObject.videoOfTheDayWatchText.getText())
//            Assert.assertEquals("7", homePageObject.promoCounter.getText())
//            Assert.assertEquals("Swipe through the latest news videos", homePageObject.videoOfTheDayPromoSummary.getText())
//            commonFunctionKotlin.tapButton(androidDriver, homePageObject.videoOfTheDayButton, false)
//            commonFunctionKotlin.scrollToEndOfStories(androidDriver, homePageObject.newsStreamProgress, videoPageObject.videsofthedayRelease, homePageObject.checkBackLater)
//            pressBack()
//    }

    @Test(priority = 3, description = "Test to scroll to a topic on home page and select a particular topic and add to MyNews")
    fun testToCheckTopicsTopStores() {
        commonFunctionKotlin.startTest("Scrolling to topics", "Scroll to a Topics on Home Page", "HomePage")

        //scrolls to Reality Check topics on Top Stories page
        commonFunctionKotlin.scrollToElement(androidDriver, homePageObject.educationTopics)
        commonFunctionKotlin.tapButton(androidDriver, homePageObject.educationTopics, false)
        if (!commonFunctionKotlin.isElementPresent(androidDriver, By.id("bbc.mobile.news.uk.internal:id/menu_follow"))) {
            System.out.println("Scrolling up")
            commonFunctionKotlin.verticalSwipe(androidDriver, "Up")
        }
        commonFunctionKotlin.elementDisplayed(androidDriver, homePageObject.familyEducationTopic)
        System.out.println("Topics is :-" + homePageObject.familyEducationTopic.text)

        for (i in 0 until basePageObject.topicsPageElements.size) {
            commonFunctionKotlin.isElementPresent(androidDriver, By.id(basePageObject.topicsPageElements[i]))
        }
        commonFunctionKotlin.tapButton(androidDriver, myNewsPageObject.mynews_addtopics, false)
        commonFunctionKotlin.textPresent(androidDriver, "Family & Education", "added to")
        commonFunctionKotlin.elementDisplayed(androidDriver, myNewsPageObject.manageyourtopics)
        commonFunctionKotlin.tapButton(androidDriver, basePageObject.backButton, false)


        //scrolls to health topics on Top Stories page
        commonFunctionKotlin.scrollToElement(androidDriver, homePageObject.technologyTopic)
        commonFunctionKotlin.tapButton(androidDriver, homePageObject.technologyTopic, false)
        if (!commonFunctionKotlin.isElementPresent(androidDriver, By.id("bbc.mobile.news.uk.internal:id/menu_follow"))) {
            System.out.println("Scrolling up")
            commonFunctionKotlin.verticalSwipe(androidDriver, "Up")
        }
        System.out.println("The Topic is " + homePageObject.technologyTopic.text)
        commonFunctionKotlin.elementDisplayed(androidDriver, homePageObject.technologyTopic)
        System.out.println("Topics is :-" + homePageObject.technologyTopic.text)
        for (i in 0 until basePageObject.topicsPageElements.size) {
            commonFunctionKotlin.isElementPresent(androidDriver, By.id(basePageObject.topicsPageElements[i]))
        }
        commonFunctionKotlin.tapButton(androidDriver, myNewsPageObject.mynews_addtopics, false)
        commonFunctionKotlin.textPresent(androidDriver, "Technology", "added to")
        commonFunctionKotlin.elementDisplayed(androidDriver, myNewsPageObject.manageyourtopics)
        commonFunctionKotlin.tapButton(androidDriver, basePageObject.backButton, false)
    }

    @Test(priority = 4, description = "Test To Check the topics added from top stories are displayed under MyNews")
    fun testMyNewsTopStoriesTopics() {
        commonFunctionKotlin.startTest("Removing Added Topics", "Test to check Topics on MyNews page", "MyNews")
        commonFunctionKotlin.tapButton(androidDriver, basePageObject.myNews, false)
        commonFunctionKotlin.tapButton(androidDriver, myNewsPageObject.editMyNews, false)

        assertDisplayingElements(androidDriver,
                homePageObject.technologyTopic,
                homePageObject.familyEducationTopic
        )

        commonFunctionKotlin.tapButton(androidDriver, myNewsPageObject.removetopics, false)
        // commonFunctionKotlin.textPresent(androidDriver, "Family & Education", "removed from")
        commonFunctionKotlin.tapButton(androidDriver, myNewsPageObject.removetopics, false)
        // commonFunctionKotlin.textPresent(androidDriver, "Technology", "removed from")
        // pressBack()
        commonFunctionKotlin.tapButton(androidDriver, basePageObject.backButton, false)

    }

    @Test(priority = 5, description = "Test for Checking whether Location service works")
    @Story("MyNews")
    fun testAllowLocation() {
        commonFunctionKotlin.startTest("Allowing Location Service ", "Checking whether Location service works ", "MyNews")
        commonFunctionKotlin.tapButton(androidDriver, basePageObject.myNews, false)//,file.getAbsolutePath());
        commonFunctionKotlin.tapButton(androidDriver, myNewsPageObject.mynews_startButton, false)
        commonFunctionKotlin.tapButton(androidDriver, myNewsPageObject.allow_location, false)
        commonFunctionKotlin.tapButton(androidDriver, myNewsPageObject.allowlocation_premission, false)
        pressBack()
    }

    @Test(priority = 6, description = "Test to check MyNews page and asserting whether all links displayed")
    fun testMyNews() {
        commonFunctionKotlin.startTest("Checking Elements on MyNews Page", "Test to check MyNews page", "MyNews")
        commonFunctionKotlin.tapButton(androidDriver, basePageObject.myNews, false)
        assertDisplayingElements(androidDriver,
                myNewsPageObject.mynews_summary,
                myNewsPageObject.mynewstitle,
                myNewsPageObject.addnews_button
        )
        assertEquals(myNewsPageObject.mynewstitle_text, myNewsPageObject.mynewstitle.text, "Text Mesaaged")
        assertEquals(myNewsPageObject.mynewssummary_text, myNewsPageObject.mynews_summary.text, "Text Mesaaged")
    }

    // @Test(dependsOnMethods = {"testMyNews"})
    @Test(priority = 7, description = "Test to check on My News Add Topic screen and asserting all links are displayed")
    fun testAddingTopicsPage() {
        commonFunctionKotlin.startTest("Checking Elements on Edit Mynews Page", "Test to check Edit MyNews page", "MyNews")
        commonFunctionKotlin.tapButton(androidDriver, myNewsPageObject.mynews_startButton, false)
        commonFunctionKotlin.elementIsSelected(myNewsPageObject.addtopics)

        assertDisplayingElements(androidDriver,
                myNewsPageObject.mytopics,
                // myNewsPageObject.location_button
                myNewsPageObject.editMyTopics,
                myNewsPageObject.localnews
        )

        commonFunctionKotlin.tapButton(androidDriver, myNewsPageObject.mytopics, false)//,file.getAbsolutePath());
        commonFunctionKotlin.elementIsSelected(myNewsPageObject.mytopics)
        assertEquals(myNewsPageObject.mytopic_emptyview_text, myNewsPageObject.mytopic_emptyview.text, "Text Mesaaged")
    }

    // @Test(dependsOnMethods = {"testAddingTopicsPage"})
    @Test(priority = 8, description = "Test to add Topics under MyNews")
    fun testAddingTopicsToMyNewsPage() {
        commonFunctionKotlin.startTest("Adding Topics ", "Test to check added Topics to MyNews page", "MyNews")
        commonFunctionKotlin.tapButton(androidDriver, myNewsPageObject.addtopics, false)

        Assert.assertEquals("Manchester", myNewsPageObject.localnews_displayed.text)
        commonFunctionKotlin.elementDisplayed(androidDriver, myNewsPageObject.localnews_displayed)

        commonFunctionKotlin.scrollToElement(androidDriver, myTopicsPageObject.englandtopic)
        commonFunctionKotlin.tapButton(androidDriver, myTopicsPageObject.englandtopic, false)
        // commonFunctionKotlin.textPresent(androidDriver, "England", "added to")

        commonFunctionKotlin.scrollToElement(androidDriver, myTopicsPageObject.africatopic)
        commonFunctionKotlin.tapButton(androidDriver, myTopicsPageObject.africatopic, false)

        commonFunctionKotlin.scrollToElement(androidDriver, myTopicsPageObject.europeuniontopic)
        commonFunctionKotlin.tapButton(androidDriver, myTopicsPageObject.europeuniontopic, false)

        commonFunctionKotlin.scrollToElement(androidDriver, myTopicsPageObject.mortgagestopic)
        commonFunctionKotlin.tapButton(androidDriver, myTopicsPageObject.mortgagestopic, false)
        //  commonFunctionKotlin.textPresent(androidDriver, "Mortgages", "added to")

        commonFunctionKotlin.scrollToElement(androidDriver, myTopicsPageObject.youtubetopic)
        commonFunctionKotlin.tapButton(androidDriver, myTopicsPageObject.youtubetopic, false)
        //  commonFunctionKotlin.textPresent(androidDriver, "YouTube", "added to")
    }

    @Test(priority = 9, description = "Test to check whether selected topics are displayed under Added Topics in MyNews")
    fun testCheckAddedTopics() {
        commonFunctionKotlin.startTest("My Topics page", "Test to check added Topics MyNews page", "MyNews")
        commonFunctionKotlin.tapButton(androidDriver, myNewsPageObject.mytopics, false)

        assertDisplayingElements(androidDriver,
                myTopicsPageObject.Englandtopic,
                myTopicsPageObject.Africatopic,
                myTopicsPageObject.Europeantopic,
                myTopicsPageObject.Mortgagestopic,
                myTopicsPageObject.Youtubetopic
        )
    }

    @Test(priority = 10, description = "Test to display the Ordering of the Topics")
    fun testCheckOrderingOfTopicsAdded() {
        commonFunctionKotlin.startTest("My Topics Ordering", "Test to display the Ordering of the Topics", "MyNews")
        commonFunctionKotlin.readRecyclerView(androidDriver, "Topics Before Re-Ordering :- ")
        System.out.println("The Text at get(0) is " + androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='1']/android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='1']")).text)
        System.out.println("The Text at get(1) is " + androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='1']/android.widget.RelativeLayout[@index='1']/android.widget.TextView[@index='1']")).text)
        System.out.println("The Text at get(2) is " + androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='1']/android.widget.RelativeLayout[@index='2']/android.widget.TextView[@index='1']")).text)
        System.out.println("The Text at get(3) is " + androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='1']/android.widget.RelativeLayout[@index='3']/android.widget.TextView[@index='1']")).text)
        System.out.println("The Text at get(4) is " + androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='1']/android.widget.RelativeLayout[@index='4']/android.widget.TextView[@index='1']")).text)
        assertEquals("England", androidDriver.findElement(By.xpath("//android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='1']")).text, "Test Matched")
        pressBack()
    }

    @Test(priority = 11, description = "Test to select each of the topics displayed under MyNews ")
    fun testSelectedAddedTopics() {
        commonFunctionKotlin.startTest("Checking Added Topics on Mynews page", "Selecting Added Topics", "MyNews")
        commonFunctionKotlin.waitFor(1000)

        assertDisplayingElements(androidDriver,
                myTopicsPageObject.Englandtopic,
                myTopicsPageObject.Europeantopic,
                myTopicsPageObject.Africatopic
        )

        commonFunctionKotlin.tapButton(androidDriver, myTopicsPageObject.Africatopic, false)
        for (i in 0 until basePageObject.topicsPageElements.size) {
            commonFunctionKotlin.isElementPresent(androidDriver, By.id(basePageObject.topicsPageElements[i]))
        }
        pressBack()
        commonFunctionKotlin.tapButton(androidDriver, myTopicsPageObject.Europeantopic, false)
        for (i in 0 until basePageObject.topicsPageElements.size) {
            commonFunctionKotlin.isElementPresent(androidDriver, By.id(basePageObject.topicsPageElements[i]))
        }
        pressBack()
        commonFunctionKotlin.tapButton(androidDriver, myTopicsPageObject.Englandtopic, false)
        for (i in 0 until basePageObject.topicsPageElements.size) {
            commonFunctionKotlin.isElementPresent(androidDriver, By.id(basePageObject.topicsPageElements[i]))
        }
        pressBack()
    }


    @Test(priority = 12, description = "Test to re-arrange topics from top to bottom")
    fun testCheckReOrderingOfTopicsAdded() {
        commonFunctionKotlin.startTest("Re Arrange Topics from Top-to-Bottom", "Test to re-arrange topics from top to bottom", "MyNews")
        commonFunctionKotlin.tapButton(androidDriver, myNewsPageObject.editMyNews, false)

        val england = androidDriver.findElementsById("bbc.mobile.news.uk.internal:id/grab_handle")[0]
        val youTubeTopic = androidDriver.findElementsById("bbc.mobile.news.uk.internal:id/grab_handle")[4]

        commonFunctionKotlin.elementDragDrop(androidDriver, england, youTubeTopic)

        commonFunctionKotlin.readRecyclerView(androidDriver, "Topics After  Re-Ordering :- ")

        System.out.println("The Text at get(3) is " + androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='1']/android.widget.RelativeLayout[@index='3']/android.widget.TextView[@index='1']")).text)
        assertEquals("England", androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='1']/android.widget.RelativeLayout[@index='3']/android.widget.TextView[@index='1']")).text, "Test Matched")

        System.out.println("The Text at get(0) is " + androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='1']/android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='1']")).text)
        assertNotEquals("England", androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='1']/android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='1']")).text, "Test Matched")
        assertEquals("Africa", androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='1']/android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='1']")).text, "Test Matched")

        pressBack()
    }

    @Test(priority = 13, description = "Test to check whether the Menu Options are displayed")
    fun testCheckMenuItems() {
        commonFunctionKotlin.startTest("Checking the MenuItems", "Checking Menu Items ", "Menu")
        commonFunctionKotlin.tapButton(androidDriver, basePageObject.menuButton, false)

        assertDisplayingElements(androidDriver,
                basePageObject.settings,
                basePageObject.InternalSettings,
                basePageObject.otherBbcApps,
                basePageObject.appInfo
        )
        pressBack()
    }

    @Test(priority = 14, description = "Test to play a Live video from Vide page and asserting on whether playback controls are displayed")
    fun testVideoPage() {
        commonFunctionKotlin.startTest("Playing a Live Video", "Checking the Video Page", "Live Video")
        commonFunctionKotlin.tapButton(androidDriver, basePageObject.video, false)
        commonFunctionKotlin.tapButton(androidDriver, videoPageObject.bbcNewsChannel, false)

        assertDisplayingElements(androidDriver,
                videoPageObject.liveMediaItemCaption,
                basePageObject.navigate_back,
                basePageObject.shareStory
        )
        commonFunctionKotlin.tapButton(androidDriver, videoPageObject.smpPlaceholderPlayButton, false)
        commonFunctionKotlin.waitFor(1400)
        commonFunctionKotlin.tapButton(androidDriver, videoPageObject.smpFullScreenButton, false)
        commonFunctionKotlin.waitFor(1400)

        if (commonFunctionKotlin.isElementPresent(androidDriver, By.id("bbc.mobile.news.uk.internal:id/smp_play_button"))) {
            commonFunctionKotlin.tapButton(androidDriver, videoPageObject.playButton, false)
        }

        commonFunctionKotlin.tapButton(androidDriver, videoPageObject.transportControls, false)
        commonFunctionKotlin.tapButton(androidDriver, videoPageObject.transportControls, false)

        assertDisplayingElements(androidDriver,
                videoPageObject.smpPauseButton,
                videoPageObject.smpExitFullScreenButton,
                videoPageObject.smpLiveIcon,
                videoPageObject.smpVolumeButton,
                videoPageObject.smpSeekBar
        )
    }

    @Test(priority = 15, description = "Test to check whether video plays in landscape mode")
    fun playingLandscape() {
        commonFunctionKotlin.startTest("Checking Live Video in Landscape", "Checking the Video in Landscape Mode", "Live Video")
        androidDriver.rotate(ScreenOrientation.LANDSCAPE)
        commonFunctionKotlin.tapButton(androidDriver, videoPageObject.transportControls, false)
        commonFunctionKotlin.tapButton(androidDriver, videoPageObject.transportControls, false)

        assertDisplayingElements(androidDriver,
                videoPageObject.smpPauseButton,
                videoPageObject.smpExitFullScreenButton,
                videoPageObject.smpLiveIcon,
                videoPageObject.smpVolumeButton,
                videoPageObject.smpSeekBar
        )
    }

    @Test(priority = 16, description = "Test to scrub video playback ")
    fun scrubbingVideoPlayback() {
        androidDriver.rotate(ScreenOrientation.PORTRAIT)
        commonFunctionKotlin.startTest("Checking Live Video Scrubbing", "Checking the Live Video in Portrait Mode and seeking", "Live Video")
        commonFunctionKotlin.seeking(videoPageObject.smpSeekBar, .30, "forward")
        commonFunctionKotlin.isElementPresent(androidDriver, By.id("bbc.mobile.news.uk.internal:id/smpSeekBar"))
        commonFunctionKotlin.tapButton(androidDriver, videoPageObject.smpExitFullScreenButton, false)
        pressBack()
    }

    @Test(priority = 17, description = "Test to check for search results")
    fun testSearchStories() {
        commonFunctionKotlin.startTest("Search for an Topics", "Checking Search Topics", "Search")
        commonFunctionKotlin.tapButton(androidDriver, basePageObject.searchButton, false)
        commonFunctionKotlin.enterText(basePageObject.searchField, "India")
        commonFunctionKotlin.waitFor(2000)

        val searchTopicsText = commonFunctionKotlin.getText(basePageObject.searchHeading)
        //androidDriver.findElement(By.xpath("android.widget.TextView[@text='Topics (5)']")).text
        //commonFunctionKotlin.getText( basePageObject.searchHeading)
        assertEquals(searchTopicsText, "Topics (5)", "matched")
        commonFunctionKotlin.waitFor(1000)

        val searchRelatedHeadingText = commonFunctionKotlin.getText(basePageObject.searchHeading2)
        assertEquals(searchRelatedHeadingText, "Articles related to \"India\"")

        commonFunctionKotlin.tapButton(androidDriver, basePageObject.cancelSearch, false)
        val searchTopicsText1 = commonFunctionKotlin.getText(basePageObject.searchHeading)
        assertEquals(searchTopicsText1, "In The News Now", "matched")

        commonFunctionKotlin.waitFor(1000)
        val searchRelatedHeadingText2 = commonFunctionKotlin.getText(basePageObject.searchHeading2)
        assertEquals(searchRelatedHeadingText2, "More Topics", "matched")

        //Assert.assertEquals(basePageObject.searchHeading4.getText(),"My Topics","matched");
        commonFunctionKotlin.tapButton(androidDriver, basePageObject.backButton, false)

    }

    @Test(priority = 18, description = "Test to search for a Topic and navigate to topic page")
    fun testSelectSearchResult() {
        commonFunctionKotlin.startTest("Navigate to Topic Detail Page", "Test to search for a Topic and navigate to topic page", "Search")
        commonFunctionKotlin.tapButton(androidDriver, basePageObject.searchButton, false)
        basePageObject.searchField.clear()
        commonFunctionKotlin.enterText(basePageObject.searchField, basePageObject.searchText)
        commonFunctionKotlin.waitFor(700)
        assertEquals(basePageObject.searchText, basePageObject.searchKeyword.text, "Text Matched")
        commonFunctionKotlin.tapButton(androidDriver, basePageObject.searchKeyword, false)

        assertEquals(basePageObject.searchText, commonFunctionKotlin.getText(basePageObject.headlineTitle))
        commonFunctionKotlin.tapButton(androidDriver, basePageObject.backButton, false)
        pressBack()
        commonFunctionKotlin.tapButton(androidDriver, basePageObject.backButton, false)
    }

    @Test(priority = 19, description = "Test Checking an Topic and adding to MyNews")
    fun testSearchTopic() {
        commonFunctionKotlin.startTest("Search and Adding Topic to Mynews", "Test Checking an Topic and adding to MyNews", "Search")
        commonFunctionKotlin.tapButton(androidDriver, basePageObject.searchButton, false)
        // basePageObject.searchField.clear()
        commonFunctionKotlin.enterText(basePageObject.searchField, "India")
        commonFunctionKotlin.waitFor(700)
        commonFunctionKotlin.tapButton(androidDriver, basePageObject.article, false)

        assertEquals(basePageObject.articleLayoutName.text, basePageObject.articleLayoutName.text, "Text Matched")
        assertEquals(basePageObject.articleLastUpdated.text, basePageObject.articleLastUpdated.text, "Test Matched")
        commonFunctionKotlin.tapButton(androidDriver, myNewsPageObject.mynews_addtopics, false)
    }

    @Test(priority = 20, description = "Test Checking an Article page without an Item Image Badge")
    fun testArticleItemWithoutItemBadge() {
        commonFunctionKotlin.startTest("Article without ItemImage Badge", "Test Checking an Article page without an Item Image Badge", "Search")
        commonFunctionKotlin.scrollToElement(androidDriver, basePageObject.articleItemWithoutItemBadge)
        commonFunctionKotlin.tapButton(androidDriver, basePageObject.articleItemWithoutItemBadge, false)

        var i = 0
        while (i < basePageObject.articleDetailPageLinks.size && i < basePageObject.articleItemWithImageBadge.size) {
            commonFunctionKotlin.isElementPresent(androidDriver, By.id(basePageObject.articleDetailPageLinks[i]))
            assertEquals(basePageObject.articleItemWithoutImageBadge[i], androidDriver.findElement(By.id(basePageObject.articleDetailPageLinks[i])).text, "Test matched")
            i++
        }
        pressBack()
    }

    @Test(priority = 21, description = "Test Checking an Article page with an Item Image Badge")
    fun testArticleItemWithItemBadge() {
        commonFunctionKotlin.startTest("Article with ItemImage Badge", "Checking an Article page without an Item Image Badge", "Search")
        commonFunctionKotlin.scrollToElement(androidDriver, basePageObject.articleItemWithItemBadge)
        commonFunctionKotlin.tapButton(androidDriver, basePageObject.articleItemWithItemBadge, false)
        assertDisplayingElements(androidDriver, basePageObject.articleImageBadge)
        assertEquals("EPA", basePageObject.articleImageBadge.text, "Text Matched")

        var i = 0
        while (i < basePageObject.articleDetailPageLinks.size && i < basePageObject.articleItemWithImageBadge.size) {
            commonFunctionKotlin.isElementPresent(androidDriver, By.id(basePageObject.articleDetailPageLinks[i]))
            assertEquals(basePageObject.articleItemWithImageBadge[i], androidDriver.findElement(By.id(basePageObject.articleDetailPageLinks[i])).text, "Test matched")
            i++
        }

        pressBack()
        commonFunctionKotlin.tapButton(androidDriver, basePageObject.backButton, false)
        commonFunctionKotlin.tapButton(androidDriver, basePageObject.cancelSearch, false)
    }


    @Test(priority = 22, description = "Test to search for an particular article")
    fun testSearchArticle() {
        commonFunctionKotlin.startTest("Searching a Particular article", "Test to search for an particular article", "Search")
        commonFunctionKotlin.tapButton(androidDriver, basePageObject.searchButton, false)
        // basePageObject.searchField.clear();
        commonFunctionKotlin.enterText(basePageObject.searchField, "A rape victim's two-year wait for justice")
        //androidDriver.hideKeyboard();
        commonFunctionKotlin.tapButton(androidDriver, basePageObject.articleSearch, false)
        commonFunctionKotlin.waitFor(500)

        var i = 0
        while (i < basePageObject.articlePageDetail.size && i < basePageObject.articlePageDetailElements.size) {
            commonFunctionKotlin.isElementPresent(androidDriver, By.id(basePageObject.articlePageDetailElements[i]))
            assertEquals(basePageObject.articlePageDetail[i], androidDriver.findElement(By.id(basePageObject.articlePageDetailElements[i])).text, "Test matched")
            i++
        }
        commonFunctionKotlin.tapButton(androidDriver, basePageObject.navigate_back, false)
        commonFunctionKotlin.tapButton(androidDriver, basePageObject.backButton, false)
    }

    @Test(priority = 23, description = "Test to search for an particular video article")
    fun testOnDemandVideoPlayback() {
        commonFunctionKotlin.startTest("Playing a Particular OnDemand Video", "Test to search ana play a on-demand video", "OnDemandVideo")
        commonFunctionKotlin.tapButton(androidDriver, basePageObject.search, false)
        commonFunctionKotlin.enterText(basePageObject.searchField, "egypt court imposes jail")
        commonFunctionKotlin.waitForScreenToLoad(androidDriver, videoPageObject.videoArticleSearch, 3)

        assertEquals("Articles related to \"egypt court imposes jail\"", basePageObject.searchHeading.text)
        //androidDriver.findElement(By.id("bbc.mobile.news.uk.internal:id/heading")).getText())
        commonFunctionKotlin.elementDisplayed(androidDriver, androidDriver.findElement(By.id("bbc.mobile.news.uk.internal:id/content_card_title")))
        commonFunctionKotlin.elementDisplayed(androidDriver, androidDriver.findElement(By.id("bbc.mobile.news.uk.internal:id/content_card_last_updated")))

        val videoTitle = videoPageObject.videoArticleSearch.text
        //val videolastupdated = androidDriver.findElement(By.id("bbc.mobile.news.uk.internal:id/content_card_last_updated")).text

        commonFunctionKotlin.tapButton(androidDriver, videoPageObject.videoArticleSearch, false)
        assertEquals(videoTitle, androidDriver.findElement(By.id("bbc.mobile.news.uk.internal:id/headline_title")).text)
        assertEquals("31 Dec 2018", androidDriver.findElement(By.id("bbc.mobile.news.uk.internal:id/headline_info")).text)

        var i = 0
        while (i < videoPageObject.videoDetailPage.size && i < videoPageObject.videoDetailPageText.size) {

            commonFunctionKotlin.isElementPresent(androidDriver, By.id(videoPageObject.videoDetailPage[i]))
            assertEquals(videoPageObject.videoDetailPageText[i], androidDriver.findElement(By.id(videoPageObject.videoDetailPage[i])).text)
            i++
        }
    }

    @Test(priority = 24, description = "Test to seek forward videoplayback")
    fun testSeekingVideoForward() {
        commonFunctionKotlin.startTest("Seeking Video Forward", "Test to search ana play a on-demand video", "OnDemandVideo")
        commonFunctionKotlin.tapButton(androidDriver, videoPageObject.smpPlaceholderPlayButton, false)
        commonFunctionKotlin.seeking(videoPageObject.smpSeekBar, .50, "forward")
        videoPageObject.elapsedTimeForward = videoPageObject.smpElapsedTime.text
    }

    @Test(priority = 25, description = "Test to seek forward videoplayback")
    fun testSeekingVideoBackward() {
        commonFunctionKotlin.startTest("Seeking Video Backward", "Test to search ana play a on-demand video", "OnDemandVideo")
        commonFunctionKotlin.seeking(videoPageObject.smpSeekBar, .30, "backward")
        videoPageObject.elapsedTimeBackward = videoPageObject.smpElapsedTime.text
        assertNotEquals(videoPageObject.elapsedTimeForward, videoPageObject.elapsedTimeBackward)
    }

    @Test(priority = 26, description = "Test to check Related Stories and Topics of an Article")
    fun testRelatedStoriesArticle() {
        commonFunctionKotlin.startTest("Checking for Related Story Article", "Test to check Related Stories of an Article", "Related Stories/Topics")
        commonFunctionKotlin.scrollToElement(androidDriver, popularPageObject.relatedstorieArticle)
        commonFunctionKotlin.elementDisplayed(androidDriver, basePageObject.relatedStories)
        commonFunctionKotlin.tapButton(androidDriver, popularPageObject.relatedstorieArticle, false)
        for (i in 0 until popularPageObject.mostreadpopularlinks.size) {
            commonFunctionKotlin.isElementPresent(androidDriver, By.id(popularPageObject.mostreadpopularlinks[i]))
        }
        if (!basePageObject.shareStory.isDisplayed) {
            commonFunctionKotlin.verticalSwipe(androidDriver, "Up")
        }
        commonFunctionKotlin.tapButton(androidDriver, basePageObject.navigate_back, false)
    }

    @Test(priority = 27, description = "Test to check Related Topics of an Article")
    fun testRelatedTopicArticle() {
        commonFunctionKotlin.startTest("Checking for Related Topic Article", "Test to check Related Topics of an Article", "Related Stories/Topics")
        commonFunctionKotlin.scrollToElement(androidDriver, popularPageObject.relatedtopicsArticle)
        commonFunctionKotlin.elementDisplayed(androidDriver, basePageObject.relatedTopics)
        commonFunctionKotlin.tapButton(androidDriver, popularPageObject.relatedtopicsArticle, false)
        assertEquals("Egypt", androidDriver.findElement(By.id("bbc.mobile.news.uk.internal:id/title")).text)
        assertEquals("Add topic", androidDriver.findElement(By.id("bbc.mobile.news.uk.internal:id/menu_follow")).getAttribute("contentDescription"))
        for (i in 0 until basePageObject.topicsPageElements.size) {
            commonFunctionKotlin.isElementPresent(androidDriver, By.id(basePageObject.topicsPageElements[i]))
        }
        commonFunctionKotlin.tapButton(androidDriver, basePageObject.backButton, false)
        pressBack()
        commonFunctionKotlin.tapButton(androidDriver, basePageObject.backButton, false)
    }

    @Test(priority = 28, description = "Test to check the T&C , PrivacyPolicy from Menu options")
    fun testCheckTermsPrivacyPolicy() {
        commonFunctionKotlin.startTest("Checking T&C Privacy Policy", "Checking T&C and privacy Policy", "Menu")
        commonFunctionKotlin.tapButton(androidDriver, basePageObject.menuButton, false)
        commonFunctionKotlin.tapButton(androidDriver, basePageObject.menuAppInfo, false)
        commonFunctionKotlin.tapButton(androidDriver, basePageObject.termsConditions, false)
        pressBack()
        commonFunctionKotlin.tapButton(androidDriver, basePageObject.privacyPolicy, false)
        pressBack()
        commonFunctionKotlin.tapButton(androidDriver, basePageObject.backButton, false)
    }

    @Test(priority = 29, description = "Playing a video from Video page")
    fun testTopStoriesVideo() {
        commonFunctionKotlin.startTest("Playing a OnDemand Video", "Test to play a video from Video page", "OnDemandVideo")
        commonFunctionKotlin.tapButton(androidDriver, basePageObject.video, false)
        //commented out as Top Stories link isn't displayed
        //commonFunctionKotlin.elementDisplayed(androidDriver, videoPageObject.topStories)
//        commonFunctionKotlin.scrollToElement(androidDriver, videoPageObject.topStoriesVideo)
//        commonFunctionKotlin.elementDisplayed(androidDriver, videoPageObject.topStoriesVideoPlayTime)
//        commonFunctionKotlin.elementDisplayed(androidDriver, videoPageObject.topStoriesVideoContentCardTitle)
//        commonFunctionKotlin.elementDisplayed(androidDriver, videoPageObject.topStoriesVideoContentCardLink)
//        commonFunctionKotlin.elementDisplayed(androidDriver, videoPageObject.topStoriesVideoContentCardInfo)

        commonFunctionKotlin.tapButton(androidDriver, videoPageObject.topStoriesVideo, false)
        commonFunctionKotlin.tapButton(androidDriver, videoPageObject.smpPlaceholderPlayButton, false)
        // androidDriver.findElementByAccessibilityId("Play").click();
        videoPageObject.transportControls.click()
        videoPageObject.transportControls.click()
        for (i in 0 until popularPageObject.popularvideoelements.size) {
            commonFunctionKotlin.isElementPresent(androidDriver, By.id(popularPageObject.popularvideoelements[i]))
        }
        pressBack()
    }

    @Test(priority = 30, description = "App Backgrounding")
    fun testAppBackground() {
        commonFunctionKotlin.startTest("App Background ", "Test to check backgrouding the app and reopen and checking same page opens", "App Background")
        basePageObject.popular.click()
        androidDriver.runAppInBackground(Duration.ofSeconds(30))
        (androidDriver as StartsActivity).currentActivity()

        assertTrue(basePageObject.popular.isSelected)
    }

    @Test(priority = 31, description = "Test to check the Popular page and also to check Most Read Displayed")
    fun testPopularPage() {
        commonFunctionKotlin.startTest("Checking PopularPage", "Checking Popular Page", "Popular")
        commonFunctionKotlin.tapButton(androidDriver, popularPageObject.popular, false)
        commonFunctionKotlin.elementDisplayed(androidDriver, popularPageObject.mostread)
    }

    @Test(priority = 32, description = "Test to select one Article from Most Read  Article from Popular Page")
    fun testMostReadPopular() {
        commonFunctionKotlin.startTest("Checking Article from Most Read Section", "Checking Most Read Popular", "Popular")
        commonFunctionKotlin.elementDisplayed(androidDriver, popularPageObject.mostread)
        commonFunctionKotlin.tapButton(androidDriver, popularPageObject.mostRead_article, false)
    }


    @Test(priority = 33, description = "Test to check whether the Most Watched heading displayed in Popular Page")
    fun testMostWatched() {
        pressBack()
        commonFunctionKotlin.startTest("Checking Most Popular Section", "Checking Most Watched", "Popular")
        commonFunctionKotlin.scrollToElement(androidDriver, popularPageObject.popularmostwatched)
        commonFunctionKotlin.elementDisplayed(androidDriver, popularPageObject.popularmostwatched)
    }

    @Test(priority = 34, description = "Test to check whether the Most Watched heading displayed in Popular Page")
    fun testMostWatchedArticle() {
        commonFunctionKotlin.startTest("Checking Most Watched Article ", "Checking Most Watched", "Popular")
        commonFunctionKotlin.scrollToElement(androidDriver, popularPageObject.mostwatchedartcilevideo)
        System.out.println("The Element selected is  :- " + popularPageObject.mostwatchedartcilevideo.text)
        popularPageObject.mostwatchedartcilevideo.click()
        if (!popularPageObject.mostpopular.isDisplayed) {
            commonFunctionKotlin.verticalSwipe(androidDriver, "Up")
        }
        for (i in 0 until videoPageObject.videoWallElements.size) {
            commonFunctionKotlin.isElementPresent(androidDriver, By.id(videoPageObject.videoWallElements[i]))
        }
        pressBack()
    }

    @Test(priority = 35, description = "Test re-arrange topics from bottom to top")
    fun testArrangeTopicsFromBottomToTop() {
        commonFunctionKotlin.startTest("Re Arrange Topics from Bottom-to-Top", "Test re-arrange topics from bottom to top", "MyNews")
        commonFunctionKotlin.tapButton(androidDriver, basePageObject.myNews, false)
        commonFunctionKotlin.tapButton(androidDriver, myNewsPageObject.editMyNews, false)

        val india = androidDriver.findElementsById("bbc.mobile.news.uk.internal:id/grab_handle")[5]
        val europe = androidDriver.findElementsById("bbc.mobile.news.uk.internal:id/grab_handle")[0]

        commonFunctionKotlin.elementDragDrop(androidDriver, india, europe)
        commonFunctionKotlin.readRecyclerView(androidDriver, "Topics After  Re-Ordering :- ")

        assertNotEquals("Rape in India", androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='1']/android.widget.RelativeLayout[@index='5']/android.widget.TextView[@index='1']")).text, "Test Didn't Matched")
        assertEquals("Rape in India", androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='1']/android.widget.RelativeLayout[@index='1']/android.widget.TextView[@index='1']")).text, "Test Matched")
        // Assert.assertEquals("European Union",androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='1']/android.widget.RelativeLayout[@index='2']/android.widget.TextView[@index='1']")).getText(), "Test Matched");
        assertEquals("YouTube", androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='1']/android.widget.RelativeLayout[@index='5']/android.widget.TextView[@index='1']")).text, "Test Matched")
        commonFunctionKotlin.tapButton(androidDriver, myNewsPageObject.removetopics, false)
        commonFunctionKotlin.tapButton(androidDriver, myNewsPageObject.removetopics, false)
        pressBack()
    }

    @Test(priority = 36, description = "Test to check the offline scenario of the app")
    fun testCheckOfflineScenario() {
        commonFunctionKotlin.startTest("Going OffLine", "Checking apps offline scenario", "Offline")
        val state = androidDriver.setConnection(ConnectionStateBuilder()
                .withWiFiDisabled()
                .build())
        androidDriver.connection = state
//        commonFunctionKotlin.waitForScreenToLoad(androidDriver,basePageObject.topStories,10);
//        commonFunctionKotlin.tapButton(androidDriver,basePageObject.topStories,false);
//        commonFunctionKotlin.scrollToElement(androidDriver, homePageObject.videoOfTheDayWatch);
//        commonFunctionKotlin.tapButton(androidDriver, homePageObject.videoOfTheDayButton, false);
//        Assert.assertEquals("You're not connected to the internet.", myNewsPageObject.snackbar.getText(), "Text Matched");
    }

    @Test(priority = 37, description = "Test to play a  video, while device offline")
    fun testPlayingVideoOffline() {
        commonFunctionKotlin.startTest("VideoPlayback-Offline", "Checking the Video while device offline", "Offline")
        commonFunctionKotlin.tapButton(androidDriver, basePageObject.video, false)
        commonFunctionKotlin.tapButton(androidDriver, videoPageObject.bbcNewsChannel, false)
        commonFunctionKotlin.elementDisplayed(androidDriver, videoPageObject.liveMediaItemCaption)
        commonFunctionKotlin.elementDisplayed(androidDriver, basePageObject.navigate_back)
        commonFunctionKotlin.elementDisplayed(androidDriver, basePageObject.shareStory)
        commonFunctionKotlin.tapButton(androidDriver, videoPageObject.smpPlaceholderPlayButton, false)
        commonFunctionKotlin.elementDisplayed(androidDriver, basePageObject.smpErrorMessage)
        commonFunctionKotlin.elementDisplayed(androidDriver, basePageObject.smpErrorOkButton)
        commonFunctionKotlin.elementDisplayed(androidDriver, basePageObject.smpRetryButton)
        val state = androidDriver.setConnection(ConnectionStateBuilder()
                .withWiFiEnabled()
                .build())
        androidDriver.connection = state
        System.out.println("The Connection state is " + state.isWiFiEnabled)
        commonFunctionKotlin.waitFor(1000)
        assertTrue(state.isWiFiEnabled)
        pressBack()
        commonFunctionKotlin.tapButton(androidDriver, basePageObject.myNews, false)
        commonFunctionKotlin.tapButton(androidDriver, basePageObject.popular, false)
    }

    @Test(priority = 38, description = "Test to play a  video, while device online")
    fun testPlayingVideoOnLine() {
        commonFunctionKotlin.startTest("VideoPlayback-Online", "Checking the Video while device Online", "Offline")
        commonFunctionKotlin.tapButton(androidDriver, basePageObject.video, false)
        commonFunctionKotlin.tapButton(androidDriver, videoPageObject.bbcNewsChannel, false)
        commonFunctionKotlin.tapButton(androidDriver, videoPageObject.smpPlaceholderPlayButton, false)
        commonFunctionKotlin.tapButton(androidDriver, basePageObject.navigate_back, false)
    }

    @Test(priority = 39, description = "Test to select An Article from the England Topics under MyNews ")
    fun testSelectArticleTopic() {
        commonFunctionKotlin.startTest("Selecting a Article from Africa Topics", "Test to select An Article from the Africa Topics under MyNews", "MyNews")
        commonFunctionKotlin.tapButton(androidDriver, basePageObject.myNews, false)
        commonFunctionKotlin.tapButton(androidDriver, myTopicsPageObject.Englandtopic, false)
        commonFunctionKotlin.tapButton(androidDriver, myNewsPageObject.topicarticle, false)
        assertDisplayingElements(androidDriver, myTopicsPageObject.Englandtopic)
        pressBack()
    }

    @Test(priority = 40, description = "Test to select An Video Article from the England Topics under MyNews ")
    fun testSelectVideoArticleTopic() {
        commonFunctionKotlin.startTest("Select a Video Article from Africa Topic", "Test to select An Video Article from the Africa Topics under MyNews", "MyNews")
        commonFunctionKotlin.scrollToElement(androidDriver, myNewsPageObject.mynewsrecyclerview)
        commonFunctionKotlin.tapButton(androidDriver, myNewsPageObject.topicvideoarticle, false)
        assertDisplayingElements(androidDriver, myTopicsPageObject.Englandtopic)

        for (i in 0 until videoPageObject.videoWallElements.size) {
            commonFunctionKotlin.isElementPresent(androidDriver, By.id(videoPageObject.videoWallElements[i]))
        }

        commonFunctionKotlin.tapButton(androidDriver, videoPageObject.smpPlaceholderPlayButton, false)
        commonFunctionKotlin.waitFor(1300)

        for (i in 0 until videoPageObject.playbackControls.size) {
            commonFunctionKotlin.isElementPresent(androidDriver, By.id(videoPageObject.playbackControls[i]))
        }

        pressBack()
        commonFunctionKotlin.tapButton(androidDriver, basePageObject.backButton, false)
    }

    /**
     * commented out as Video of the day isn't displayed
     */
//    @Test(priority = 42, description = "Test to check the offline scenario of the app")
//    fun testCheckOnlineScenario() {
//        commonFunctionKotlin.startTest("VideOfTheDay - Online", "Checking apps offline scenario", "Offline")
//        commonFunctionKotlin.tapButton(androidDriver, basePageObject.topStories, false)
//        commonFunctionKotlin.scrollToElement(androidDriver, homePageObject.videoOfTheDayWatch)
//        commonFunctionKotlin.tapButton(androidDriver, homePageObject.videoOfTheDayButton, false)
//        //extenttestReport.isElementPresent(androidDriver,By.id("bbc.mobile.news.uk:id/snackbar_text"));
//        pressBack()
//    }

    @AfterMethod
    fun getResult(result: ITestResult) {
        commonFunctionKotlin.getTestResult(androidDriver, result)
    }

    @AfterTest
    fun tearDown() {
        commonFunctionKotlin.publishReport()
        androidDriver.closeApp()
        androidDriver.removeApp("bbc.mobile.news.uk.internal")
        androidDriver.quit()
    }
}
