package com.bbcnews.automation.scripts

import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.checkConnection
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.createAReportHive
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.elementDisplayed
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.elementDragDrop
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.elementIsSelected
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.enterText
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.getTestResult
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.getText
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.isElementPresent
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.isElementSelected
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.publishReport
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.readRecyclerView
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.scrollToElement
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.seeking
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.startTest
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.tapButton
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.textPresent
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.verticalSwipe
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.waitFor
import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.waitForScreenToLoad
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
        checkConnection(androidDriver)
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

        createAReportHive("Regression", deviceName.toString(), deviceid.toString())

        androidDriver.context("NATIVE_APP")
        file = File(screenshotPath)
        val screenshot = file.absolutePath
        println("The ScreenShot Path is $screenshot")
    }

    @Test(priority = 1, description = "Launching the app")
    fun testOpenNewsApp() {
        tapButton(androidDriver, basePageObject.okButton, false)
        tapButton(androidDriver, basePageObject.noThanksButton, false)

        if (isElementPresent(androidDriver, By.id("bbc.mobile.news.uk.internal:id/error_retry")))
        //    !androidDriver.findElement(By.id("bbc.mobile.news.uk.internal:id/error_retry")).isDisplayed)
        {
            androidDriver.findElement(By.id("bbc.mobile.news.uk.internal:id/error_retry")).click()
            //wait.until(extenttestReport.elementFoundAndClicked(By.id("bbc.mobile.news.uk.internal:id/error_retry")));
        }
    }

    @Test(priority = 2, description = "Test to check whether all links present on Home Page")
    fun testTopStories() {
        startTest("Checking the HomePage", "Checking the HomePage", "HomePage")
        isElementSelected(basePageObject.topStories)

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
//            startTest("VideoOftheDay", "Scroll to a Video of the day", "HomePage")
//            sleepmethod(1000)
//            scrolltoElement(androidDriver, homePageObject.videoOfTheDayWatch)
//            elementDisplayed(androidDriver, homePageObject.videoOfTheDayWatchNext)
//            elementDisplayed(androidDriver, homePageObject.promoCounter)
//            elementDisplayed(androidDriver, homePageObject.videoOfTheDayPromoSummary)
//            elementDisplayed(androidDriver, homePageObject.videoOfTheDayTitle)
//            Assert.assertEquals("Videos of the day", homePageObject.videoOfTheDayTitle.getText())
//            Assert.assertEquals("WATCH", homePageObject.videoOfTheDayWatchNext.getText())
//            Assert.assertEquals("7", homePageObject.promoCounter.getText())
//            Assert.assertEquals("Swipe through the latest news videos", homePageObject.videoOfTheDayPromoSummary.getText())
//            tapButton(androidDriver, homePageObject.videoOfTheDayButton, false)
//            scrolltoEndofStories(androidDriver, homePageObject.newsStreamProgress, videoPageObject.videsofthedayRelease, homePageObject.checkBackLater)
//            pressBack()
//    }

    @Test(priority = 3, description = "Test to scroll to a topic on home page and select a particular topic and add to MyNews")
    fun testToCheckTopicsTopStores() {
        startTest("Scrolling to topics", "Scroll to a Topics on Home Page", "HomePage")

        //scrolls to Reality Check topics on Top Stories page
        scrollToElement(androidDriver, homePageObject.educationTopics)
        tapButton(androidDriver, homePageObject.educationTopics, false)
        if (!isElementPresent(androidDriver, By.id("bbc.mobile.news.uk.internal:id/menu_follow"))) {
            System.out.println("Scrolling up")
            verticalSwipe(androidDriver, "Up")
        }
        elementDisplayed(androidDriver, homePageObject.familyEducationTopic)
        System.out.println("Topics is :-" + homePageObject.familyEducationTopic.text)

        for (i in 0 until basePageObject.topicsPageElements.size) {
            isElementPresent(androidDriver, By.id(basePageObject.topicsPageElements[i]))
        }
        tapButton(androidDriver, myNewsPageObject.myNewsAddTopics, false)
        textPresent(androidDriver, "Family & Education", "added to")
        elementDisplayed(androidDriver, myNewsPageObject.manageYourTopics)
        tapButton(androidDriver, basePageObject.backButton, false)


        //scrolls to health topics on Top Stories page
        scrollToElement(androidDriver, homePageObject.technologyTopic)
        tapButton(androidDriver, homePageObject.technologyTopic, false)
        if (!isElementPresent(androidDriver, By.id("bbc.mobile.news.uk.internal:id/menu_follow"))) {
            System.out.println("Scrolling up")
            verticalSwipe(androidDriver, "Up")
        }
        System.out.println("The Topic is " + homePageObject.technologyTopic.text)
        elementDisplayed(androidDriver, homePageObject.technologyTopic)
        System.out.println("Topics is :-" + homePageObject.technologyTopic.text)
        for (i in 0 until basePageObject.topicsPageElements.size) {
            isElementPresent(androidDriver, By.id(basePageObject.topicsPageElements[i]))
        }
        tapButton(androidDriver, myNewsPageObject.myNewsAddTopics, false)
        textPresent(androidDriver, "Technology", "added to")
        elementDisplayed(androidDriver, myNewsPageObject.manageYourTopics)
        tapButton(androidDriver, basePageObject.backButton, false)
    }

//    @Test(priority = 4, description = "Test To Check the topics added from top stories are displayed under MyNews")
//    fun testMyNewsTopStoriesTopics() {
//        try {
//            startTest("Removing Added Topics", "Test to check Topics on MyNews page", "MyNews")
//            tapButton(androidDriver, basePageObject.myNews, false)
//            tapButton(androidDriver, myNewsPageObject.editMyNews, false)
//
//            assertDisplayingElements(androidDriver,
//                    homePageObject.technologyTopic,
//                    homePageObject.familyEducationTopic
//            )
//
//            tapButton(androidDriver, myNewsPageObject.removetopics, false)
//            // textPresent(androidDriver, "Family & Education", "removed from")
//            tapButton(androidDriver, myNewsPageObject.removetopics, false)
//            // textPresent(androidDriver, "Technology", "removed from")
//            // pressBack()
//            tapButton(androidDriver, basePageObject.backButton, false)
//        } catch (e: StaleElementReferenceException) {
//            // todo: remove this!!! failing without it
//        }
//    }

    @Test(priority = 5, description = "Test for Checking whether Location service works")
    @Story("MyNews")
    fun testAllowLocation() {
        startTest("Allowing Location Service ", "Checking whether Location service works ", "MyNews")
        tapButton(androidDriver, basePageObject.myNews, false)//,file.getAbsolutePath());
        tapButton(androidDriver, myNewsPageObject.myNewsStartButton, false)
        tapButton(androidDriver, myNewsPageObject.allowLocation, false)
        tapButton(androidDriver, myNewsPageObject.allowLocationPermission, false)
        pressBack()
    }

    @Test(priority = 6, description = "Test to check MyNews page and asserting whether all links displayed")
    fun testMyNews() {
        startTest("Checking Elements on MyNews Page", "Test to check MyNews page", "MyNews")
        tapButton(androidDriver, basePageObject.myNews, false)
        assertDisplayingElements(androidDriver,
                myNewsPageObject.myNewsSummary,
                myNewsPageObject.myNewsTitle,
                myNewsPageObject.addNewsButton
        )
        assertEquals(myNewsPageObject.myNewsTitleText, myNewsPageObject.myNewsTitle.text, "Text Mesaaged")
        assertEquals(myNewsPageObject.myNewsSummaryText, myNewsPageObject.myNewsSummary.text, "Text Mesaaged")
    }

    // @Test(dependsOnMethods = {"testMyNews"})
    @Test(priority = 7, description = "Test to check on My News Add Topic screen and asserting all links are displayed")
    fun testAddingTopicsPage() {
        startTest("Checking Elements on Edit Mynews Page", "Test to check Edit MyNews page", "MyNews")
        tapButton(androidDriver, myNewsPageObject.myNewsStartButton, false)
        elementIsSelected(myNewsPageObject.addTopics)

        assertDisplayingElements(androidDriver,
                myNewsPageObject.myTopics,
                // myNewsPageObject.locationButton
                myNewsPageObject.editMyTopics,
                myNewsPageObject.localNews
        )

        tapButton(androidDriver, myNewsPageObject.myTopics, false)//,file.getAbsolutePath());
        elementIsSelected(myNewsPageObject.myTopics)
        assertEquals(myNewsPageObject.myTopicEmptyViewText, myNewsPageObject.myTopicEmptyView.text, "Text Mesaaged")
    }

    // @Test(dependsOnMethods = {"testAddingTopicsPage"})
    @Test(priority = 8, description = "Test to add Topics under MyNews")
    fun testAddingTopicsToMyNewsPage() {
        startTest("Adding Topics ", "Test to check added Topics to MyNews page", "MyNews")
        tapButton(androidDriver, myNewsPageObject.addTopics, false)

        assertEquals("Manchester", myNewsPageObject.localNewsDisplayed.text)
        elementDisplayed(androidDriver, myNewsPageObject.localNewsDisplayed)

        scrollToElement(androidDriver, myTopicsPageObject.addEnglandTopicButton)
        tapButton(androidDriver, myTopicsPageObject.addEnglandTopicButton, false)
        // textPresent(androidDriver, "England", "added to")

        scrollToElement(androidDriver, myTopicsPageObject.addAfricaTopicButton)
        tapButton(androidDriver, myTopicsPageObject.addAfricaTopicButton, false)

        scrollToElement(androidDriver, myTopicsPageObject.addEuTopicButton)
        tapButton(androidDriver, myTopicsPageObject.addEuTopicButton, false)

        scrollToElement(androidDriver, myTopicsPageObject.addMortgagesTopicButton)
        tapButton(androidDriver, myTopicsPageObject.addMortgagesTopicButton, false)
        //  textPresent(androidDriver, "Mortgages", "added to")

        scrollToElement(androidDriver, myTopicsPageObject.addYouTubeTopicButton)
        tapButton(androidDriver, myTopicsPageObject.addYouTubeTopicButton, false)
        //  textPresent(androidDriver, "YouTube", "added to")
    }

    @Test(priority = 9, description = "Test to check whether selected topics are displayed under Added Topics in MyNews")
    fun testCheckAddedTopics() {
        startTest("My Topics page", "Test to check added Topics MyNews page", "MyNews")
        tapButton(androidDriver, myNewsPageObject.myTopics, false)

        assertDisplayingElements(androidDriver,
                myTopicsPageObject.englandTopic,
                myTopicsPageObject.africaTopic,
                myTopicsPageObject.europeanTopic,
                myTopicsPageObject.mortgagesTopic,
                myTopicsPageObject.youTubeTopic
        )
    }

    @Test(priority = 10, description = "Test to display the Ordering of the Topics")
    fun testCheckOrderingOfTopicsAdded() {
        startTest("My Topics Ordering", "Test to display the Ordering of the Topics", "MyNews")
        readRecyclerView(androidDriver, "Topics Before Re-Ordering :- ")
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
        startTest("Checking Added Topics on Mynews page", "Selecting Added Topics", "MyNews")
        waitFor(1000)

        assertDisplayingElements(androidDriver,
                myTopicsPageObject.englandTopic,
                myTopicsPageObject.europeanTopic,
                myTopicsPageObject.africaTopic
        )

        tapButton(androidDriver, myTopicsPageObject.africaTopic, false)
        for (i in 0 until basePageObject.topicsPageElements.size) {
            isElementPresent(androidDriver, By.id(basePageObject.topicsPageElements[i]))
        }
        pressBack()
        tapButton(androidDriver, myTopicsPageObject.europeanTopic, false)
        for (i in 0 until basePageObject.topicsPageElements.size) {
            isElementPresent(androidDriver, By.id(basePageObject.topicsPageElements[i]))
        }
        pressBack()
        tapButton(androidDriver, myTopicsPageObject.englandTopic, false)
        for (i in 0 until basePageObject.topicsPageElements.size) {
            isElementPresent(androidDriver, By.id(basePageObject.topicsPageElements[i]))
        }
        pressBack()
    }


    @Test(priority = 12, description = "Test to re-arrange topics from top to bottom")
    fun testCheckReOrderingOfTopicsAdded() {
        startTest("Re Arrange Topics from Top-to-Bottom", "Test to re-arrange topics from top to bottom", "MyNews")
        tapButton(androidDriver, myNewsPageObject.editMyNews, false)

        val england = androidDriver.findElementsById("bbc.mobile.news.uk.internal:id/grab_handle")[0]
        val youTubeTopic = androidDriver.findElementsById("bbc.mobile.news.uk.internal:id/grab_handle")[4]

        elementDragDrop(androidDriver, england, youTubeTopic)

        readRecyclerView(androidDriver, "Topics After  Re-Ordering :- ")

        System.out.println("The Text at get(3) is " + androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='1']/android.widget.RelativeLayout[@index='3']/android.widget.TextView[@index='1']")).text)
        assertEquals("England", androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='1']/android.widget.RelativeLayout[@index='3']/android.widget.TextView[@index='1']")).text, "Test Matched")

        System.out.println("The Text at get(0) is " + androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='1']/android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='1']")).text)
        assertNotEquals("England", androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='1']/android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='1']")).text, "Test Matched")
        assertEquals("Africa", androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='1']/android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='1']")).text, "Test Matched")

        pressBack()
    }

    @Test(priority = 13, description = "Test to check whether the Menu Options are displayed")
    fun testCheckMenuItems() {
        startTest("Checking the MenuItems", "Checking Menu Items ", "Menu")
        tapButton(androidDriver, basePageObject.menuButton, false)

        assertDisplayingElements(androidDriver,
                basePageObject.settings,
                basePageObject.InternalSettings,
                basePageObject.otherBbcApps,
                basePageObject.appInfo
        )
        pressBack()
    }

    @Test(priority = 14, description = "Test to play a Live video from Video page and asserting on whether playback controls are displayed")
    fun testVideoPage() {
        startTest("Playing a Live Video", "Checking the Video Page", "Live Video")
        tapButton(androidDriver, basePageObject.video, false)
        tapButton(androidDriver, videoPageObject.bbcNewsChannel, false)

        assertDisplayingElements(androidDriver,
                videoPageObject.liveMediaItemCaption,
                basePageObject.navigate_back,
                basePageObject.shareStory
        )
        tapButton(androidDriver, videoPageObject.accessibilityPlay, false)
        waitFor(1400)
        tapButton(androidDriver, videoPageObject.smpFullScreenButton, false)
        waitFor(1400)

        if (isElementPresent(androidDriver, By.id("bbc.mobile.news.uk.internal:id/smp_play_button"))) {
            tapButton(androidDriver, videoPageObject.playButton, false)
        }

        tapButton(androidDriver, videoPageObject.transportControls, false)
        tapButton(androidDriver, videoPageObject.transportControls, false)

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
        startTest("Checking Live Video in Landscape", "Checking the Video in Landscape Mode", "Live Video")
        androidDriver.rotate(ScreenOrientation.LANDSCAPE)
        tapButton(androidDriver, videoPageObject.transportControls, false)
        tapButton(androidDriver, videoPageObject.transportControls, false)

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
        startTest("Checking Live Video Scrubbing", "Checking the Live Video in Portrait Mode and seeking", "Live Video")
        seeking(videoPageObject.smpSeekBar, .30, "forward")
        isElementPresent(androidDriver, By.id("bbc.mobile.news.uk.internal:id/smpSeekBar"))
        tapButton(androidDriver, videoPageObject.smpExitFullScreenButton, false)
        pressBack()
    }

    @Test(priority = 17, description = "Test to check for search results")
    fun testSearchStories() {
        startTest("Search for an Topics", "Checking Search Topics", "Search")
        tapButton(androidDriver, basePageObject.searchButton, false)
        enterText(basePageObject.searchField, "India")
        waitFor(2000)

        val searchTopicsText = getText(basePageObject.searchHeading)
        //androidDriver.findElement(By.xpath("android.widget.TextView[@text='Topics (5)']")).text
        //getText( basePageObject.searchHeading)
        assertEquals(searchTopicsText, "Topics (5)", "matched")
        waitFor(1000)

        val searchRelatedHeadingText = getText(basePageObject.searchHeading2)
        assertEquals(searchRelatedHeadingText, "Articles related to \"India\"")

        tapButton(androidDriver, basePageObject.cancelSearch, false)
        val searchTopicsText1 = getText(basePageObject.searchHeading)
        assertEquals(searchTopicsText1, "In The News Now", "matched")

        waitFor(1000)
        val searchRelatedHeadingText2 = getText(basePageObject.searchHeading2)
        assertEquals(searchRelatedHeadingText2, "More Topics", "matched")

        //Assert.assertEquals(basePageObject.searchHeading4.getText(),"My Topics","matched");
        tapButton(androidDriver, basePageObject.backButton, false)

    }

    @Test(priority = 18, description = "Test to search for a Topic and navigate to topic page")
    fun testSelectSearchResult() {
        startTest("Navigate to Topic Detail Page", "Test to search for a Topic and navigate to topic page", "Search")
        tapButton(androidDriver, basePageObject.searchButton, false)
        basePageObject.searchField.clear()
        enterText(basePageObject.searchField, basePageObject.searchText)
        waitFor(700)
        assertEquals(basePageObject.searchText, basePageObject.searchKeyword.text, "Text Matched")
        tapButton(androidDriver, basePageObject.searchKeyword, false)

        assertEquals(basePageObject.searchText, getText(basePageObject.headlineTitle))
        tapButton(androidDriver, basePageObject.backButton, false)
        pressBack()
        tapButton(androidDriver, basePageObject.backButton, false)
    }

    @Test(priority = 19, description = "Test Checking an Topic and adding to MyNews")
    fun testSearchTopic() {
        startTest("Search and Adding Topic to Mynews", "Test Checking an Topic and adding to MyNews", "Search")
        tapButton(androidDriver, basePageObject.searchButton, false)
        // basePageObject.searchField.clear()
        enterText(basePageObject.searchField, "India")
        waitFor(700)
        tapButton(androidDriver, basePageObject.article, false)

        assertEquals(basePageObject.articleLayoutName.text, basePageObject.articleLayoutName.text, "Text Matched")
        assertEquals(basePageObject.articleLastUpdated.text, basePageObject.articleLastUpdated.text, "Test Matched")
        tapButton(androidDriver, myNewsPageObject.myNewsAddTopics, false)
    }

    @Test(priority = 20, description = "Test Checking an Article page without an Item Image Badge")
    fun testArticleItemWithoutItemBadge() {
        startTest("Article without ItemImage Badge", "Test Checking an Article page without an Item Image Badge", "Search")
        scrollToElement(androidDriver, basePageObject.articleItemWithoutItemBadge)
        tapButton(androidDriver, basePageObject.articleItemWithoutItemBadge, false)

        var i = 0
        while (i < basePageObject.articleDetailPageLinks.size && i < basePageObject.articleItemWithImageBadge.size) {
            isElementPresent(androidDriver, By.id(basePageObject.articleDetailPageLinks[i]))
            assertEquals(basePageObject.articleItemWithoutImageBadge[i], androidDriver.findElement(By.id(basePageObject.articleDetailPageLinks[i])).text, "Test matched")
            i++
        }
        pressBack()
    }

    @Test(priority = 21, description = "Test Checking an Article page with an Item Image Badge")
    fun testArticleItemWithItemBadge() {
        startTest("Article with ItemImage Badge", "Checking an Article page without an Item Image Badge", "Search")
        scrollToElement(androidDriver, basePageObject.articleItemWithItemBadge)
        tapButton(androidDriver, basePageObject.articleItemWithItemBadge, false)
        assertDisplayingElements(androidDriver, basePageObject.articleImageBadge)
        assertEquals("EPA", basePageObject.articleImageBadge.text, "Text Matched")

        var i = 0
        while (i < basePageObject.articleDetailPageLinks.size && i < basePageObject.articleItemWithImageBadge.size) {
            isElementPresent(androidDriver, By.id(basePageObject.articleDetailPageLinks[i]))
            assertEquals(basePageObject.articleItemWithImageBadge[i], androidDriver.findElement(By.id(basePageObject.articleDetailPageLinks[i])).text, "Test matched")
            i++
        }

        pressBack()
        tapButton(androidDriver, basePageObject.backButton, false)
        tapButton(androidDriver, basePageObject.cancelSearch, false)
    }

    @Test(priority = 22, description = "Test to search for an particular article")
    fun testSearchArticle() {
        startTest("Searching a Particular article", "Test to search for an particular article", "Search")
        tapButton(androidDriver, basePageObject.searchButton, false)
        // basePageObject.searchField.clear();
        enterText(basePageObject.searchField, "A rape victim's two-year wait for justice")
        //androidDriver.hideKeyboard();
        tapButton(androidDriver, basePageObject.articleSearch, false)
        waitFor(500)

        var i = 0
        while (i < basePageObject.articlePageDetail.size && i < basePageObject.articlePageDetailElements.size) {
            isElementPresent(androidDriver, By.id(basePageObject.articlePageDetailElements[i]))
            assertEquals(basePageObject.articlePageDetail[i], androidDriver.findElement(By.id(basePageObject.articlePageDetailElements[i])).text, "Test matched")
            i++
        }
        tapButton(androidDriver, basePageObject.navigate_back, false)
        tapButton(androidDriver, basePageObject.backButton, false)
    }

    @Test(priority = 23, description = "Test to search for an particular video article")
    fun testOnDemandVideoPlayback() {
        startTest("Playing a Particular OnDemand Video", "Test to search ana play a on-demand video", "OnDemandVideo")
        tapButton(androidDriver, basePageObject.search, false)
        enterText(basePageObject.searchField, "egypt court imposes jail")
        waitForScreenToLoad(androidDriver, videoPageObject.videoArticleSearch, 3)

        assertEquals("Articles related to \"egypt court imposes jail\"", basePageObject.searchHeading.text)
        //androidDriver.findElement(By.id("bbc.mobile.news.uk.internal:id/heading")).getText())
        elementDisplayed(androidDriver, androidDriver.findElement(By.id("bbc.mobile.news.uk.internal:id/contentCardTitle")))
        elementDisplayed(androidDriver, androidDriver.findElement(By.id("bbc.mobile.news.uk.internal:id/content_card_last_updated")))

        val videoTitle = videoPageObject.videoArticleSearch.text
        //val videolastupdated = androidDriver.findElement(By.id("bbc.mobile.news.uk.internal:id/content_card_last_updated")).text

        tapButton(androidDriver, videoPageObject.videoArticleSearch, false)
        assertEquals(videoTitle, androidDriver.findElement(By.id("bbc.mobile.news.uk.internal:id/headlineTitle")).text)
        assertEquals("31 Dec 2018", androidDriver.findElement(By.id("bbc.mobile.news.uk.internal:id/headlineInfo")).text)

        var i = 0
        while (i < videoPageObject.videoDetailPage.size && i < videoPageObject.videoDetailPageText.size) {

            isElementPresent(androidDriver, By.id(videoPageObject.videoDetailPage[i]))
            assertEquals(videoPageObject.videoDetailPageText[i], androidDriver.findElement(By.id(videoPageObject.videoDetailPage[i])).text)
            i++
        }
    }

    @Test(priority = 24, description = "Test to seek forward videoplayback")
    fun testSeekingVideoForward() {
        startTest("Seeking Video Forward", "Test to search ana play a on-demand video", "OnDemandVideo")
        tapButton(androidDriver, videoPageObject.accessibilityPlay, false)
        seeking(videoPageObject.smpSeekBar, .50, "forward")
        videoPageObject.elapsedTimeForward = videoPageObject.smpElapsedTime.text
    }

    @Test(priority = 25, description = "Test to seek forward videoplayback")
    fun testSeekingVideoBackward() {
        startTest("Seeking Video Backward", "Test to search ana play a on-demand video", "OnDemandVideo")
        seeking(videoPageObject.smpSeekBar, .30, "backward")
        videoPageObject.elapsedTimeBackward = videoPageObject.smpElapsedTime.text
        assertNotEquals(videoPageObject.elapsedTimeForward, videoPageObject.elapsedTimeBackward)
    }

    @Test(priority = 26, description = "Test to check Related Stories and Topics of an Article")
    fun testRelatedStoriesArticle() {
        startTest("Checking for Related Story Article", "Test to check Related Stories of an Article", "Related Stories/Topics")
        scrollToElement(androidDriver, popularPageObject.relatedStoriesArticle)
        elementDisplayed(androidDriver, basePageObject.relatedStories)
        tapButton(androidDriver, popularPageObject.relatedStoriesArticle, false)
        for (i in 0 until popularPageObject.mostReadPopularLinks.size) {
            isElementPresent(androidDriver, By.id(popularPageObject.mostReadPopularLinks[i]))
        }
        if (!basePageObject.shareStory.isDisplayed) {
            verticalSwipe(androidDriver, "Up")
        }
        tapButton(androidDriver, basePageObject.navigate_back, false)
    }

    @Test(priority = 27, description = "Test to check Related Topics of an Article")
    fun testRelatedTopicArticle() {
        startTest("Checking for Related Topic Article", "Test to check Related Topics of an Article", "Related Stories/Topics")
        scrollToElement(androidDriver, popularPageObject.relatedTopicsArticle)
        elementDisplayed(androidDriver, basePageObject.relatedTopics)
        tapButton(androidDriver, popularPageObject.relatedTopicsArticle, false)
        assertEquals("Egypt", androidDriver.findElement(By.id("bbc.mobile.news.uk.internal:id/title")).text)
        assertEquals("Add topic", androidDriver.findElement(By.id("bbc.mobile.news.uk.internal:id/menu_follow")).getAttribute("contentDescription"))
        for (i in 0 until basePageObject.topicsPageElements.size) {
            isElementPresent(androidDriver, By.id(basePageObject.topicsPageElements[i]))
        }
        tapButton(androidDriver, basePageObject.backButton, false)
        pressBack()
        tapButton(androidDriver, basePageObject.backButton, false)
    }

    @Test(priority = 28, description = "Test to check the T&C , PrivacyPolicy from Menu options")
    fun testCheckTermsPrivacyPolicy() {
        startTest("Checking T&C Privacy Policy", "Checking T&C and privacy Policy", "Menu")
        tapButton(androidDriver, basePageObject.menuButton, false)
        tapButton(androidDriver, basePageObject.menuAppInfo, false)
        tapButton(androidDriver, basePageObject.termsConditions, false)
        pressBack()
        tapButton(androidDriver, basePageObject.privacyPolicy, false)
        pressBack()
        tapButton(androidDriver, basePageObject.backButton, false)
    }

    @Test(priority = 29, description = "Playing a video from Video page")
    fun testTopStoriesVideo() {
        startTest("Playing a OnDemand Video", "Test to play a video from Video page", "OnDemandVideo")
        tapButton(androidDriver, basePageObject.video, false)
        //commented out as Top Stories link isn't displayed
        //elementDisplayed(androidDriver, videoPageObject.topStories)
//        scrollToElement(androidDriver, videoPageObject.topStoriesVideo)
//        elementDisplayed(androidDriver, videoPageObject.topStoriesVideoPlayTime)
//        elementDisplayed(androidDriver, videoPageObject.topStoriesVideoContentCardTitle)
//        elementDisplayed(androidDriver, videoPageObject.topStoriesVideoContentCardLink)
//        elementDisplayed(androidDriver, videoPageObject.topStoriesVideoContentCardInfo)

        tapButton(androidDriver, videoPageObject.topStoriesVideo, false)
        tapButton(androidDriver, videoPageObject.accessibilityPlay, false)
        // androidDriver.findElementByAccessibilityId("Play").click();
        videoPageObject.transportControls.click()
        videoPageObject.transportControls.click()
        for (i in 0 until popularPageObject.popularVideoElements.size) {
            isElementPresent(androidDriver, By.id(popularPageObject.popularVideoElements[i]))
        }
        pressBack()
    }

    @Test(priority = 30, description = "App Backgrounding")
    fun testAppBackground() {
        startTest("App Background ", "Test to check backgrouding the app and reopen and checking same page opens", "App Background")
        basePageObject.popular.click()
        androidDriver.runAppInBackground(Duration.ofSeconds(30))
        (androidDriver as StartsActivity).currentActivity()

        assertTrue(basePageObject.popular.isSelected)
    }

    @Test(priority = 31, description = "Test to check the Popular page and also to check Most Read Displayed")
    fun testPopularPage() {
        startTest("Checking PopularPage", "Checking Popular Page", "Popular")
        tapButton(androidDriver, popularPageObject.popular, false)
        elementDisplayed(androidDriver, popularPageObject.mostRead)
    }

    @Test(priority = 32, description = "Test to select one Article from Most Read  Article from Popular Page")
    fun testMostReadPopular() {
        startTest("Checking Article from Most Read Section", "Checking Most Read Popular", "Popular")
        elementDisplayed(androidDriver, popularPageObject.mostRead)
        tapButton(androidDriver, popularPageObject.mostReadArticle, false)
    }


    @Test(priority = 33, description = "Test to check whether the Most Watched heading displayed in Popular Page")
    fun testMostWatched() {
        pressBack()
        startTest("Checking Most Popular Section", "Checking Most Watched", "Popular")
        scrollToElement(androidDriver, popularPageObject.popularMostWatched)
        elementDisplayed(androidDriver, popularPageObject.popularMostWatched)
    }

    @Test(priority = 34, description = "Test to check whether the Most Watched heading displayed in Popular Page")
    fun testMostWatchedArticle() {
        startTest("Checking Most Watched Article ", "Checking Most Watched", "Popular")
        scrollToElement(androidDriver, popularPageObject.mostWatchedArticleVideo)
        System.out.println("The Element selected is  :- " + popularPageObject.mostWatchedArticleVideo.text)
        popularPageObject.mostWatchedArticleVideo.click()
        if (!popularPageObject.mostPopular.isDisplayed) {
            verticalSwipe(androidDriver, "Up")
        }
        for (i in 0 until videoPageObject.videoWallElements.size) {
            isElementPresent(androidDriver, By.id(videoPageObject.videoWallElements[i]))
        }
        pressBack()
    }

    @Test(priority = 35, description = "Test re-arrange topics from bottom to top")
    fun testArrangeTopicsFromBottomToTop() {
        startTest("Re Arrange Topics from Bottom-to-Top", "Test re-arrange topics from bottom to top", "MyNews")
        tapButton(androidDriver, basePageObject.myNews, false)
        tapButton(androidDriver, myNewsPageObject.editMyNews, false)

        val india = androidDriver.findElementsById("bbc.mobile.news.uk.internal:id/grab_handle")[5]
        val europe = androidDriver.findElementsById("bbc.mobile.news.uk.internal:id/grab_handle")[0]

        elementDragDrop(androidDriver, india, europe)
        readRecyclerView(androidDriver, "Topics After  Re-Ordering :- ")

        assertNotEquals("Rape in India", androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='1']/android.widget.RelativeLayout[@index='5']/android.widget.TextView[@index='1']")).text, "Test Didn't Matched")
        assertEquals("Rape in India", androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='1']/android.widget.RelativeLayout[@index='1']/android.widget.TextView[@index='1']")).text, "Test Matched")
        // Assert.assertEquals("European Union",androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='1']/android.widget.RelativeLayout[@index='2']/android.widget.TextView[@index='1']")).getText(), "Test Matched");
        assertEquals("YouTube", androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='1']/android.widget.RelativeLayout[@index='5']/android.widget.TextView[@index='1']")).text, "Test Matched")
        tapButton(androidDriver, myNewsPageObject.removeTopics, false)
        tapButton(androidDriver, myNewsPageObject.removeTopics, false)
        pressBack()
    }

    @Test(priority = 36, description = "Test to check the offline scenario of the app")
    fun testCheckOfflineScenario() {
        startTest("Going OffLine", "Checking apps offline scenario", "Offline")
        val state = androidDriver.setConnection(ConnectionStateBuilder()
                .withWiFiDisabled()
                .build())
        androidDriver.connection = state
//        waitForScreenToLoad(androidDriver,basePageObject.topStories,10);
//        tapButton(androidDriver,basePageObject.topStories,false);
//        scrollToElement(androidDriver, homePageObject.videoOfTheDayWatch);
//        tapButton(androidDriver, homePageObject.videoOfTheDayButton, false);
//        Assert.assertEquals("You're not connected to the internet.", myNewsPageObject.snackbar.getText(), "Text Matched");
    }

    @Test(priority = 37, description = "Test to play a  video, while device offline")
    fun testPlayingVideoOffline() {
        startTest("VideoPlayback-Offline", "Checking the Video while device offline", "Offline")
        tapButton(androidDriver, basePageObject.video, false)
        tapButton(androidDriver, videoPageObject.bbcNewsChannel, false)
        elementDisplayed(androidDriver, videoPageObject.liveMediaItemCaption)
        elementDisplayed(androidDriver, basePageObject.navigate_back)
        elementDisplayed(androidDriver, basePageObject.shareStory)
        tapButton(androidDriver, videoPageObject.accessibilityPlay, false)
        elementDisplayed(androidDriver, basePageObject.smpErrorMessage)
        elementDisplayed(androidDriver, basePageObject.smpErrorOkButton)
        elementDisplayed(androidDriver, basePageObject.smpRetryButton)
        val state = androidDriver.setConnection(ConnectionStateBuilder()
                .withWiFiEnabled()
                .build())
        androidDriver.connection = state
        System.out.println("The Connection state is " + state.isWiFiEnabled)
        waitFor(1000)
        assertTrue(state.isWiFiEnabled)
        pressBack()
        tapButton(androidDriver, basePageObject.myNews, false)
        tapButton(androidDriver, basePageObject.popular, false)
    }

    @Test(priority = 38, description = "Test to play a  video, while device online")
    fun testPlayingVideoOnLine() {
        startTest("VideoPlayback-Online", "Checking the Video while device Online", "Offline")
        tapButton(androidDriver, basePageObject.video, false)
        tapButton(androidDriver, videoPageObject.bbcNewsChannel, false)
        tapButton(androidDriver, videoPageObject.accessibilityPlay, false)
        tapButton(androidDriver, basePageObject.navigate_back, false)
    }

    @Test(priority = 39, description = "Test to select An Article from the England Topics under MyNews ")
    fun testSelectArticleTopic() {
        startTest("Selecting a Article from Africa Topics", "Test to select An Article from the Africa Topics under MyNews", "MyNews")
        tapButton(androidDriver, basePageObject.myNews, false)
        tapButton(androidDriver, myTopicsPageObject.englandTopic, false)
        tapButton(androidDriver, myNewsPageObject.topicArticle, false)
        assertDisplayingElements(androidDriver, myTopicsPageObject.englandTopic)
        pressBack()
    }

    @Test(priority = 40, description = "Test to select An Video Article from the England Topics under MyNews ")
    fun testSelectVideoArticleTopic() {
        startTest("Select a Video Article from Africa Topic", "Test to select An Video Article from the Africa Topics under MyNews", "MyNews")
        scrollToElement(androidDriver, myNewsPageObject.myNewsRecyclerView)
        tapButton(androidDriver, myNewsPageObject.topicVideoArticle, false)
        assertDisplayingElements(androidDriver, myTopicsPageObject.englandTopic)

        for (i in 0 until videoPageObject.videoWallElements.size) {
            isElementPresent(androidDriver, By.id(videoPageObject.videoWallElements[i]))
        }

        tapButton(androidDriver, videoPageObject.accessibilityPlay, false)
        waitFor(1300)

        for (i in 0 until videoPageObject.playbackControls.size) {
            isElementPresent(androidDriver, By.id(videoPageObject.playbackControls[i]))
        }

        pressBack()
        tapButton(androidDriver, basePageObject.backButton, false)
    }

    /**
     * commented out as Video of the day isn't displayed
     */
//    @Test(priority = 42, description = "Test to check the offline scenario of the app")
//    fun testCheckOnlineScenario() {
//        startTest("VideOfTheDay - Online", "Checking apps offline scenario", "Offline")
//        tapButton(androidDriver, basePageObject.topStories, false)
//        scrollToElement(androidDriver, homePageObject.videoOfTheDayWatch)
//        tapButton(androidDriver, homePageObject.videoOfTheDayButton, false)
//        //extenttestReport.isElementPresent(androidDriver,By.id("bbc.mobile.news.uk:id/snackbar_text"));
//        pressBack()
//    }

    @AfterMethod
    fun getResult(result: ITestResult) {
        getTestResult(androidDriver, result)
    }

    @AfterTest
    fun tearDown() {
        publishReport()
        androidDriver.closeApp()
        androidDriver.removeApp("bbc.mobile.news.uk.internal")
        androidDriver.quit()
    }
}
