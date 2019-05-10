package com.bbcnews.automation.scripts

import com.bbcnews.automation.commonfunctions.AppiumViewActions.elementDisplayed
import com.bbcnews.automation.commonfunctions.AppiumViewActions.elementDragDrop
import com.bbcnews.automation.commonfunctions.AppiumViewActions.elementIsSelected
import com.bbcnews.automation.commonfunctions.AppiumViewActions.enterText
import com.bbcnews.automation.commonfunctions.AppiumViewActions.getText
import com.bbcnews.automation.commonfunctions.AppiumViewActions.isElementPresent
import com.bbcnews.automation.commonfunctions.AppiumViewActions.isElementSelected
import com.bbcnews.automation.commonfunctions.AppiumViewActions.readRecyclerView
import com.bbcnews.automation.commonfunctions.AppiumViewActions.scrollToElement
import com.bbcnews.automation.commonfunctions.AppiumViewActions.scrollToEndOfStories
import com.bbcnews.automation.commonfunctions.AppiumViewActions.seeking
import com.bbcnews.automation.commonfunctions.AppiumViewActions.selectView
import com.bbcnews.automation.commonfunctions.AppiumViewActions.startTest
import com.bbcnews.automation.commonfunctions.AppiumViewActions.textPresent
import com.bbcnews.automation.commonfunctions.AppiumViewActions.verticalSwipe
import com.bbcnews.automation.commonfunctions.AppiumViewActions.waitFor
import com.bbcnews.automation.commonfunctions.AppiumViewActions.waitForScreenToLoad
import com.bbcnews.automation.commonfunctions.ScreenActions.pressBack
import com.bbcnews.automation.commonfunctions.ScreenAssertions.assertDisplayingElements
import com.bbcnews.automation.pageobjects.BasePageObject.appInfo
import com.bbcnews.automation.pageobjects.BasePageObject.article
import com.bbcnews.automation.pageobjects.BasePageObject.articleDetailPageLinksRelease
import com.bbcnews.automation.pageobjects.BasePageObject.articleImageBadge
import com.bbcnews.automation.pageobjects.BasePageObject.articleItemWithImageBadge
import com.bbcnews.automation.pageobjects.BasePageObject.articleItemWithItemBadge
import com.bbcnews.automation.pageobjects.BasePageObject.articleItemWithoutImageBadge
import com.bbcnews.automation.pageobjects.BasePageObject.articleItemWithoutItemBadge
import com.bbcnews.automation.pageobjects.BasePageObject.articleLastUpdated
import com.bbcnews.automation.pageobjects.BasePageObject.articleLayoutName
import com.bbcnews.automation.pageobjects.BasePageObject.articlePageDetail
import com.bbcnews.automation.pageobjects.BasePageObject.articlePageDetailElementsRelease
import com.bbcnews.automation.pageobjects.BasePageObject.articleSearch
import com.bbcnews.automation.pageobjects.BasePageObject.backButton
import com.bbcnews.automation.pageobjects.BasePageObject.cancelSearch
import com.bbcnews.automation.pageobjects.BasePageObject.errorRetryButton
import com.bbcnews.automation.pageobjects.BasePageObject.headlineTitle
import com.bbcnews.automation.pageobjects.BasePageObject.internalSettings
import com.bbcnews.automation.pageobjects.BasePageObject.menuAppInfo
import com.bbcnews.automation.pageobjects.BasePageObject.menuButton
import com.bbcnews.automation.pageobjects.BasePageObject.myNews
import com.bbcnews.automation.pageobjects.BasePageObject.navigateBack
import com.bbcnews.automation.pageobjects.BasePageObject.noThanksButton
import com.bbcnews.automation.pageobjects.BasePageObject.okButton
import com.bbcnews.automation.pageobjects.BasePageObject.otherBbcApps
import com.bbcnews.automation.pageobjects.BasePageObject.popular
import com.bbcnews.automation.pageobjects.BasePageObject.privacyPolicy
import com.bbcnews.automation.pageobjects.BasePageObject.relatedStories
import com.bbcnews.automation.pageobjects.BasePageObject.relatedTopics
import com.bbcnews.automation.pageobjects.BasePageObject.search
import com.bbcnews.automation.pageobjects.BasePageObject.searchButton
import com.bbcnews.automation.pageobjects.BasePageObject.searchField
import com.bbcnews.automation.pageobjects.BasePageObject.searchHeading
import com.bbcnews.automation.pageobjects.BasePageObject.searchHeading2
import com.bbcnews.automation.pageobjects.BasePageObject.searchKeyword
import com.bbcnews.automation.pageobjects.BasePageObject.searchText
import com.bbcnews.automation.pageobjects.BasePageObject.settings
import com.bbcnews.automation.pageobjects.BasePageObject.shareStory
import com.bbcnews.automation.pageobjects.BasePageObject.smpErrorMessage
import com.bbcnews.automation.pageobjects.BasePageObject.smpErrorOkButton
import com.bbcnews.automation.pageobjects.BasePageObject.smpRetryButton
import com.bbcnews.automation.pageobjects.BasePageObject.termsConditions
import com.bbcnews.automation.pageobjects.BasePageObject.topStories
import com.bbcnews.automation.pageobjects.BasePageObject.topicsPageElementsRelease
import com.bbcnews.automation.pageobjects.BasePageObject.video
import com.bbcnews.automation.pageobjects.HomePageObject.checkBackLater
import com.bbcnews.automation.pageobjects.HomePageObject.educationTopics
import com.bbcnews.automation.pageobjects.HomePageObject.familyEducationTopic
import com.bbcnews.automation.pageobjects.HomePageObject.newsStreamProgress
import com.bbcnews.automation.pageobjects.HomePageObject.promoCounter
import com.bbcnews.automation.pageobjects.HomePageObject.technologyTopic
import com.bbcnews.automation.pageobjects.HomePageObject.videoOfTheDayButton
import com.bbcnews.automation.pageobjects.HomePageObject.videoOfTheDayPromoSummary
import com.bbcnews.automation.pageobjects.HomePageObject.videoOfTheDayTitle
import com.bbcnews.automation.pageobjects.HomePageObject.videoOfTheDayWatch
import com.bbcnews.automation.pageobjects.HomePageObject.videoOfTheDayWatchNext
import com.bbcnews.automation.pageobjects.MyNewsPageObject
import com.bbcnews.automation.pageobjects.MyNewsPageObject.addNewsButton
import com.bbcnews.automation.pageobjects.MyNewsPageObject.addTopics
import com.bbcnews.automation.pageobjects.MyNewsPageObject.allowLocation
import com.bbcnews.automation.pageobjects.MyNewsPageObject.allowLocationPermission
import com.bbcnews.automation.pageobjects.MyNewsPageObject.editMyTopics
import com.bbcnews.automation.pageobjects.MyNewsPageObject.localNews
import com.bbcnews.automation.pageobjects.MyNewsPageObject.localNewsDisplayed
import com.bbcnews.automation.pageobjects.MyNewsPageObject.myNewsStartButton
import com.bbcnews.automation.pageobjects.MyNewsPageObject.myNewsSummary
import com.bbcnews.automation.pageobjects.MyNewsPageObject.myNewsSummaryText
import com.bbcnews.automation.pageobjects.MyNewsPageObject.myNewsTitle
import com.bbcnews.automation.pageobjects.MyNewsPageObject.myNewsTitleText
import com.bbcnews.automation.pageobjects.MyNewsPageObject.myTopicEmptyView
import com.bbcnews.automation.pageobjects.MyNewsPageObject.myTopics
import com.bbcnews.automation.pageobjects.MyTopicsPageObject
import com.bbcnews.automation.pageobjects.MyTopicsPageObject.addAfricaTopicButton
import com.bbcnews.automation.pageobjects.MyTopicsPageObject.addEnglandTopicButton
import com.bbcnews.automation.pageobjects.MyTopicsPageObject.addEuTopicButton
import com.bbcnews.automation.pageobjects.MyTopicsPageObject.addMortgagesTopicButton
import com.bbcnews.automation.pageobjects.MyTopicsPageObject.africaTopic
import com.bbcnews.automation.pageobjects.MyTopicsPageObject.englandTopic
import com.bbcnews.automation.pageobjects.MyTopicsPageObject.europeanTopic
import com.bbcnews.automation.pageobjects.MyTopicsPageObject.mortgagesTopic
import com.bbcnews.automation.pageobjects.MyTopicsPageObject.youTubeTopic
import com.bbcnews.automation.pageobjects.PopularPageObjects.mostPopular
import com.bbcnews.automation.pageobjects.PopularPageObjects.mostRead
import com.bbcnews.automation.pageobjects.PopularPageObjects.mostReadArticle
import com.bbcnews.automation.pageobjects.PopularPageObjects.mostReadPopularLinksRelease
import com.bbcnews.automation.pageobjects.PopularPageObjects.mostWatchedArticleVideo
import com.bbcnews.automation.pageobjects.PopularPageObjects.popularMostWatched
import com.bbcnews.automation.pageobjects.PopularPageObjects.popularVideoElementsRelease
import com.bbcnews.automation.pageobjects.PopularPageObjects.relatedStoriesArticle
import com.bbcnews.automation.pageobjects.PopularPageObjects.relatedTopicsArticle
import com.bbcnews.automation.pageobjects.VideoPageObjects.accessibilityPlay
import com.bbcnews.automation.pageobjects.VideoPageObjects.bbcNewsChannel
import com.bbcnews.automation.pageobjects.VideoPageObjects.elapsedTimeBackward
import com.bbcnews.automation.pageobjects.VideoPageObjects.elapsedTimeForward
import com.bbcnews.automation.pageobjects.VideoPageObjects.liveMediaItemCaption
import com.bbcnews.automation.pageobjects.VideoPageObjects.playButton
import com.bbcnews.automation.pageobjects.VideoPageObjects.playbackControlsRelease
import com.bbcnews.automation.pageobjects.VideoPageObjects.smpElapsedTime
import com.bbcnews.automation.pageobjects.VideoPageObjects.smpExitFullScreenButton
import com.bbcnews.automation.pageobjects.VideoPageObjects.smpFullScreenButton
import com.bbcnews.automation.pageobjects.VideoPageObjects.smpLiveIcon
import com.bbcnews.automation.pageobjects.VideoPageObjects.smpPauseButton
import com.bbcnews.automation.pageobjects.VideoPageObjects.smpSeekBar
import com.bbcnews.automation.pageobjects.VideoPageObjects.smpVolumeButton
import com.bbcnews.automation.pageobjects.VideoPageObjects.topStoriesVideo
import com.bbcnews.automation.pageobjects.VideoPageObjects.transportControls
import com.bbcnews.automation.pageobjects.VideoPageObjects.videoArticleSearch
import com.bbcnews.automation.pageobjects.VideoPageObjects.videoDetailPageRelease
import com.bbcnews.automation.pageobjects.VideoPageObjects.videoDetailPageText
import com.bbcnews.automation.pageobjects.VideoPageObjects.videoWallElementsRelease
import com.bbcnews.automation.pageobjects.VideoPageObjects.videosOfTheDayRelease
import io.appium.java_client.android.StartsActivity
import io.appium.java_client.android.connection.ConnectionStateBuilder
import io.qameta.allure.Story
import org.openqa.selenium.By
import org.openqa.selenium.ScreenOrientation
import org.testng.Assert.*
import org.testng.annotations.Test
import java.time.Duration
import java.util.*

class BBCNewsReleaseBuildRegressionTest : BbcTestCase("Regression") {

    @Test(priority = 1, description = "Launching the app")
    fun testOpenNewsApp() {
        selectView(okButton)
        selectView(noThanksButton)

        if (errorRetryButton.isDisplayed) {
            selectView(errorRetryButton)
        }
    }

    @Test(priority = 2, description = "Test to check whether all links present on Home Page")
    fun testTopStories() {
        startTest("Checking the HomePage", "Checking the HomePage", "HomePage")
        isElementSelected(topStories)
        elementDisplayed(androidDriver, topStories)
        elementDisplayed(androidDriver, myNews)
        elementDisplayed(androidDriver, popular)
        elementDisplayed(androidDriver, video)
        elementDisplayed(androidDriver, search)
        elementDisplayed(androidDriver, menuButton)
    }

    @Test(priority = 3, description = "Test to check Video of the day displayed and swipe through all the videos")
    fun testVideoOfTheDayDisplayed() {
        startTest("VideoOfTheDay", "Scroll to a Video of the day", "HomePage")
        waitFor(1000)
        scrollToElement(androidDriver, videoOfTheDayWatch)

        assertDisplayingElements(androidDriver,
                videoOfTheDayWatchNext,
                promoCounter,
                videoOfTheDayPromoSummary,
                videoOfTheDayTitle
        )

        assertEquals("Videos of the day", videoOfTheDayTitle.text)
        assertEquals("WATCH", videoOfTheDayWatchNext.text)
        assertEquals("7", promoCounter.text)
        assertEquals("Swipe through the latest news videos", videoOfTheDayPromoSummary.text)

        selectView(videoOfTheDayButton)
        scrollToEndOfStories(androidDriver, newsStreamProgress, videosOfTheDayRelease, checkBackLater)
        pressBack()
    }

    @Test(priority = 4, description = "Test to scroll to a topic on home page and select a particular topic and add to MyNews")
    fun testToCheckTopicsTopStores() {
        startTest("Scrolling to topics", "Scroll to a Topics on Home Page", "HomePage")

        //scrolls to Reality Check topics on Top Stories page
        scrollToElement(androidDriver, educationTopics)
        selectView(educationTopics)

        if (!isElementPresent(androidDriver, By.id("bbc.mobile.news.uk.internal:id/menu_follow"))) {
            System.out.println("Scrolling up")
            verticalSwipe(androidDriver, "Up")
        }

        assertDisplayingElements(androidDriver, familyEducationTopic)
        System.out.println("Topics is :-" + familyEducationTopic.text)

        for (i in 0 until topicsPageElementsRelease.size) {
            isElementPresent(androidDriver, By.id(topicsPageElementsRelease[i]))
        }
        selectView(MyNewsPageObject.myNewsAddTopics)
        textPresent(androidDriver, "Family & Education", "added to")
        assertDisplayingElements(androidDriver, MyNewsPageObject.manageYourTopics)
        selectView(backButton)

        //scrolls to health topics on Top Stories page
        scrollToElement(androidDriver, technologyTopic)
        selectView(technologyTopic)

        if (!isElementPresent(androidDriver, By.id("bbc.mobile.news.uk.internal:id/menu_follow"))) {
            System.out.println("Scrolling up")
            verticalSwipe(androidDriver, "Up")
        }

        System.out.println("The Topic is: " + technologyTopic.text)

        assertDisplayingElements(androidDriver, technologyTopic)
        System.out.println("Topics is :-" + technologyTopic.text)

        for (i in 0 until topicsPageElementsRelease.size) {
            isElementPresent(androidDriver, By.id(topicsPageElementsRelease[i]))
        }

        selectView(MyNewsPageObject.myNewsAddTopics)
        textPresent(androidDriver, "Technology", "added to")
        assertDisplayingElements(androidDriver, MyNewsPageObject.manageYourTopics)
        selectView(backButton)
    }

    @Test(priority = 5, description = "Test To Check the topics added from top stories are displayed under MyNews")
    fun testMyNewsTopStoriesTopics() {
        startTest("Removing Added Topics", "Test to check Topics on MyNews page", "MyNews")
        selectView(myNews)
        selectView(MyNewsPageObject.editMyNews)

        assertDisplayingElements(androidDriver,
                technologyTopic,
                familyEducationTopic
        )

        selectView(MyNewsPageObject.removeTopics)
        textPresent(androidDriver, "Family & Education", "removed from")
        selectView(MyNewsPageObject.removeTopics)
        textPresent(androidDriver, "Technology", "removed from")
        // pressBack()
        selectView(backButton)
    }

    @Test(priority = 6, description = "Test for Checking whether Location service works")
    @Story("MyNews")
    fun testAllowLocation() {
        startTest("Allowing Location Service ", "Checking whether Location service works ", "MyNews")
        selectView(myNews)//,file.getAbsolutePath());
        selectView(myNewsStartButton)
        selectView(allowLocation)
        selectView(allowLocationPermission)
        pressBack()
    }

    @Test(priority = 7, description = "Test to check MyNews page and asserting whether all links displayed")
    fun testMyNews() {
        startTest("Checking Elements on MyNews Page", "Test to check MyNews page", "MyNews")
        selectView(myNews)
        elementDisplayed(androidDriver, myNewsSummary)
        elementDisplayed(androidDriver, myNewsTitle)
        elementDisplayed(androidDriver, addNewsButton)
        assertEquals(myNewsTitleText, myNewsTitle.text, "Text Mesaaged")
        assertEquals(myNewsSummaryText, myNewsSummary.text, "Text Mesaaged")
    }

    // @Test(dependsOnMethods = {"testMyNews"})
    @Test(priority = 8, description = "Test to check on My News Add Topic screen and asserting all links are displayed")
    fun testAddingTopicsPage() {
        startTest("Checking Elements on Edit Mynews Page", "Test to check Edit MyNews page", "MyNews")
        selectView(myNewsStartButton)
        elementIsSelected(addTopics)
        elementDisplayed(androidDriver, myTopics)
        //elementDisplayed(androidDriver, MyNewsPageObject.locationButton);
        elementDisplayed(androidDriver, editMyTopics)
        elementDisplayed(androidDriver, localNews)
        selectView(myTopics)//,file.getAbsolutePath());
        elementIsSelected(myTopics)
        assertEquals(MyNewsPageObject.myTopicEmptyViewText, myTopicEmptyView.text, "Text Mesaaged")
    }

    // @Test(dependsOnMethods = {"testAddingTopicsPage"})
    @Test(priority = 9, description = "Test to add Topics under MyNews")
    fun testAddingTopicsToMyNewsPage() {
        startTest("Adding Topics ", "Test to check added Topics to MyNews page", "MyNews")
        selectView(addTopics)

        assertEquals("London", localNewsDisplayed.text)
        elementDisplayed(androidDriver, localNewsDisplayed)

        scrollToElement(androidDriver, addEnglandTopicButton)
        selectView(addEnglandTopicButton)
        textPresent(androidDriver, "England", "added to")

        scrollToElement(androidDriver, addAfricaTopicButton)
        selectView(addAfricaTopicButton)

        scrollToElement(androidDriver, addEuTopicButton)
        selectView(addEuTopicButton)

        scrollToElement(androidDriver, addMortgagesTopicButton)
        selectView(addMortgagesTopicButton)
        textPresent(androidDriver, "Mortgages", "added to")

        scrollToElement(androidDriver, MyTopicsPageObject.addYouTubeTopicButton)
        selectView(MyTopicsPageObject.addYouTubeTopicButton)
        textPresent(androidDriver, "YouTube", "added to")
    }

    @Test(priority = 10, description = "Test to check whether selected topics are displayed under Added Topics in MyNews")
    fun testCheckAddedTopics() {
        startTest("My Topics page", "Test to check added Topics MyNews page", "MyNews")
        selectView(myTopics)
        elementDisplayed(androidDriver, englandTopic)
        elementDisplayed(androidDriver, africaTopic)
        elementDisplayed(androidDriver, europeanTopic)
        elementDisplayed(androidDriver, mortgagesTopic)
        elementDisplayed(androidDriver, youTubeTopic)
    }

    @Test(priority = 11, description = "Test to display the Ordering of the Topics")
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

    @Test(priority = 12, description = "Test to select each of the topics displayed under MyNews ")
    fun testSelectedAddedTopics() {
        startTest("Checking Added Topics on Mynews page", "Selecting Added Topics", "MyNews")
        waitFor(1000)
        elementDisplayed(androidDriver, englandTopic)
        elementDisplayed(androidDriver, europeanTopic)
        elementDisplayed(androidDriver, africaTopic)
        selectView(englandTopic)
        for (i in 0 until topicsPageElementsRelease.size) {
            isElementPresent(androidDriver, By.id(topicsPageElementsRelease[i]))
        }
        pressBack()
        selectView(europeanTopic)
        for (i in 0 until topicsPageElementsRelease.size) {
            isElementPresent(androidDriver, By.id(topicsPageElementsRelease[i]))
        }
        pressBack()
        selectView(africaTopic)
        for (i in 0 until topicsPageElementsRelease.size) {
            isElementPresent(androidDriver, By.id(topicsPageElementsRelease[i]))
        }
    }

    @Test(priority = 13, description = "Test to select An Article from the Africa Topics under MyNews ")
    fun testSelectArticleAsiaTopic() {
        startTest("Selecting a Article from Asia Topics", "Test to select An Article from the Asia Topics under MyNews", "MyNews")
        selectView(MyNewsPageObject.topicArticle)
        pressBack()
    }

    @Test(priority = 14, description = "Test to select An Video Article from the Africa Topics under MyNews ")
    fun testSelectVideoArticleAsiaTopic() {
        startTest("Select a Video Article from Asia Topic", "Test to select An Video Article from the Asia Topics under MyNews", "MyNews")
        scrollToElement(androidDriver, MyNewsPageObject.myNewsRecyclerView)
        selectView(MyNewsPageObject.topicVideoArticle)
        for (i in 0 until videoWallElementsRelease.size) {
            isElementPresent(androidDriver, By.id(videoWallElementsRelease[i]))
        }
        selectView(accessibilityPlay)
        waitFor(1300)
        for (i in 0 until playbackControlsRelease.size) {
            isElementPresent(androidDriver, By.id(playbackControlsRelease[i]))
        }
        pressBack()
        selectView(backButton)
    }

    @Test(priority = 15, description = "Test to re-arrange topics from top to bottom")
    @Throws(Exception::class)
    fun testCheckReOrderingOfTopicsAdded() {
        startTest("Re Arrange Topics from Top-to-Bottom", "Test to re-arrange topics from top to bottom", "MyNews")
        selectView(MyNewsPageObject.editMyNews)

        val africa = androidDriver.findElementsById("bbc.mobile.news.uk.internal:id/grab_handle")[1]
        val youTubeTopic = androidDriver.findElementsById("bbc.mobile.news.uk.internal:id/grab_handle")[4]

        elementDragDrop(androidDriver, africa, youTubeTopic)

        readRecyclerView(androidDriver, "Topics After  Re-Ordering :- ")

        System.out.println("The Text at get(3) is " + androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='1']/android.widget.RelativeLayout[@index='3']/android.widget.TextView[@index='1']")).text)
        assertEquals("Africa", androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='1']/android.widget.RelativeLayout[@index='3']/android.widget.TextView[@index='1']")).text, "Test Matched")

//        System.out.println("The Text at get(0) is " + androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='1']/android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='1']")).text)
//        Assert.assertNotEquals("Brexit", androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='1']/android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='1']")).text, "Test Matched")

        pressBack()
    }

    //@Test(dependsOnMethods = {"testcheckMostWatched"})
    @Test(priority = 16, description = "Test to check whether the menu options are displayed")
    fun testMenuItems() {
        startTest("Checking the MenuItems", "Checking Menu Items ", "Menu")
        selectView(menuButton)
        elementDisplayed(androidDriver, settings)
        elementDisplayed(androidDriver, internalSettings)
        elementDisplayed(androidDriver, otherBbcApps)
        elementDisplayed(androidDriver, appInfo)
        pressBack()
    }

    @Test(priority = 17, description = "Test to play a Live video from Video page and asserting on whether playback controls are displayed")
    fun testVideoPage() {
        startTest("Playing a Live Video", "Checking the Video Page", "Live Video")
        selectView(video)
        selectView(bbcNewsChannel)
        elementDisplayed(androidDriver, liveMediaItemCaption)
        elementDisplayed(androidDriver, navigateBack)
        elementDisplayed(androidDriver, shareStory)
        selectView(accessibilityPlay)
        waitFor(1400)
        selectView(smpFullScreenButton)
        waitFor(1400)
        try {
            if (isElementPresent(androidDriver, By.id("bbc.mobile.news.uk:id/smp_play_button"))) {
                selectView(playButton)
            }
        } catch (e: NoSuchElementException) {
        }

        selectView(transportControls)
        selectView(transportControls)
        elementDisplayed(androidDriver, smpPauseButton)
        elementDisplayed(androidDriver, smpExitFullScreenButton)
        elementDisplayed(androidDriver, smpLiveIcon)
        elementDisplayed(androidDriver, smpVolumeButton)
        elementDisplayed(androidDriver, smpSeekBar)
    }

    @Test(priority = 18, description = "Test to check whether video plays in landscape mode")
    fun playingLandscape() {
        startTest("Checking live video in landscape", "Checking video in landscape mode", "Live Video")
        androidDriver.rotate(ScreenOrientation.LANDSCAPE)
        selectView(transportControls)
        selectView(transportControls)
        elementDisplayed(androidDriver, smpPauseButton)
        elementDisplayed(androidDriver, smpExitFullScreenButton)
        elementDisplayed(androidDriver, smpLiveIcon)
        elementDisplayed(androidDriver, smpVolumeButton)
        elementDisplayed(androidDriver, smpSeekBar)
    }

    @Test(priority = 19, description = "Test to scrub video playback ")
    fun scrubbingVideoPlayback() {
        androidDriver.rotate(ScreenOrientation.PORTRAIT)
        startTest("Checking Live Video Scrubbing", "Checking the Live Video in Portrait Mode and seeking", "Live Video")
        seeking(smpSeekBar, .30, "forward")
        isElementPresent(androidDriver, By.id("bbc.mobile.news.uk.internal:id/smpSeekBar"))
        selectView(smpExitFullScreenButton)
        pressBack()
    }

    @Test(priority = 20, description = "Test to check for search results")
    fun testSearchStories() {
        startTest("Search for an Topics", "Checking Search Topics", "Search")
        selectView(searchButton)
        enterText(searchField, "India")
        waitFor(800)

        val searchTopicsText = getText(searchHeading)
        assertEquals(searchTopicsText, "Topics (5)", "matched")
        waitFor(800)

        val searchRelatedHeadingText = getText(searchHeading2)
        assertEquals(searchRelatedHeadingText, "Articles related to \"India\"")

        selectView(cancelSearch)

        val searchTopicsText1 = getText(searchHeading)
        assertEquals(searchTopicsText1, "In The News Now", "matched")
        waitFor(800)

        val searchRelatedHeadingText2 = getText(searchHeading2)
        assertEquals(searchRelatedHeadingText2, "More Topics", "matched")

        //Assert.assertEquals(searchHeading4.getText(),"My Topics","matched");
        selectView(backButton)
    }

    @Test(priority = 21, description = "Test to search for a Topic and navigate to topic page")
    fun testSelectSearchResult() {
        startTest("Navigate to Topic Detail Page", "Test to search for a Topic and navigate to topic page", "Search")
        selectView(searchButton)
        searchField.clear()
        enterText(searchField, searchText)
        waitFor(700)
        assertEquals(searchText, searchKeyword.text, "Text Matched")
        selectView(searchKeyword)
        val title = getText(headlineTitle)
        assertEquals(searchText, title)
        selectView(backButton)
        pressBack()
        selectView(backButton)
    }

    @Test(priority = 22, description = "Test Checking an Topic and adding to MyNews")
    fun testSearchTopic() {
        startTest("Search and Adding Topic to Mynews", "Test Checking an Topic and adding to MyNews", "Search")
        selectView(searchButton)
        searchField.clear()
        enterText(searchField, "India")
        waitFor(700)
        selectView(article)

        assertEquals("The women who fought to ban alcohol", articleLayoutName.text)
        assertEquals("4th Jan", articleLastUpdated.text)
        selectView(MyNewsPageObject.myNewsAddTopics)
    }

    @Test(priority = 23, description = "Test Checking an Article page without an Item Image Badge")
    fun testArticleItemWithoutItemBadge() {
        startTest("Article without ItemImage Badge", "Test Checking an Article page without an Item Image Badge", "Search")
        scrollToElement(androidDriver, articleItemWithoutItemBadge)
        selectView(articleItemWithoutItemBadge)

        var i = 0
        while (i < articleDetailPageLinksRelease.size && i < articleItemWithImageBadge.size) {
            isElementPresent(androidDriver, By.id(articleDetailPageLinksRelease[i]))
            assertEquals(articleItemWithoutImageBadge[i], androidDriver.findElement(By.id(articleDetailPageLinksRelease[i])).text, "Test matched")
            i++
        }

        pressBack()
    }

    @Test(priority = 24, description = "Test Checking an Article page with an Item Image Badge")
    fun testArticleItemWithItemBadge() {
        startTest("Article with ItemImage Badge", "Checking an Article page without an Item Image Badge", "Search")
        scrollToElement(androidDriver, articleItemWithItemBadge)
        selectView(articleItemWithItemBadge)
        elementDisplayed(androidDriver, articleImageBadge)
        assertEquals("EPA", articleImageBadge.text, "Text Matched")
        var i = 0
        while (i < articleDetailPageLinksRelease.size && i < articleItemWithImageBadge.size) {
            isElementPresent(androidDriver, By.id(articleDetailPageLinksRelease[i]))
            assertEquals(articleItemWithImageBadge[i], androidDriver.findElement(By.id(articleDetailPageLinksRelease[i])).text, "Test matched")
            i++
        }

        pressBack()
        selectView(backButton)
        selectView(cancelSearch)
    }

    @Test(priority = 25, description = "Test to search for an particular article")
    fun testSearchArticle() {
        startTest("Searching a Particular article", "Test to search for an particular article", "Search")
        selectView(searchButton)
        // searchField.clear();
        enterText(searchField, "A rape victim's two-year wait for justice")
        //androidDriver.hideKeyboard();
        selectView(articleSearch)
        waitFor(500)

        var i = 0
        while (i < articlePageDetail.size && i < articlePageDetailElementsRelease.size) {
            isElementPresent(androidDriver, By.id(articlePageDetailElementsRelease[i]))
            assertEquals(articlePageDetail[i], androidDriver.findElement(By.id(articlePageDetailElementsRelease[i])).text, "Test matched")
            i++
        }
        selectView(navigateBack)
        selectView(backButton)
    }

    @Test(priority = 26, description = "Test to search for an particular video article")
    fun testOnDemandVideoPlayback() {
        startTest("Playing a Particular OnDemand Video", "Test to search ana play a on-demand video", "OnDemandVideo")
        selectView(search)
        enterText(searchField, "Egypt court imposes jail")
        waitForScreenToLoad(androidDriver, videoArticleSearch, 3)
        // androidDriver.hideKeyboard();
        // scrollToElement(androidDriver, videoArticleSearch);
        selectView(videoArticleSearch)
        //waitForScreenToLoad(androidDriver, accessibilityPlay, 3);
        var i = 0
        while (i < videoDetailPageRelease.size && i < videoDetailPageText.size) {

            isElementPresent(androidDriver, By.id(videoDetailPageRelease[i]))
            assertEquals(videoDetailPageText[i], androidDriver.findElement(By.id(videoDetailPageRelease[i])).text)
            i++
        }
    }

    @Test(priority = 27, description = "Test to seek forward videoplayback")
    fun testSeekVideoForward() {
        startTest("Seeking Video Forward", "Test to search ana play a on-demand video", "OnDemandVideo")
        selectView(accessibilityPlay)
        seeking(smpSeekBar, .50, "forward")
        elapsedTimeForward = smpElapsedTime.text
    }

    @Test(priority = 28, description = "Test to seek forward videoplayback")
    fun testSeekVideoBack() {
        startTest("Seeking Video Backward", "Test to search ana play a on-demand video", "OnDemandVideo")
        seeking(smpSeekBar, .30, "backward")
        elapsedTimeBackward = smpElapsedTime.text
        assertNotEquals(elapsedTimeForward, elapsedTimeBackward)
    }

    @Test(priority = 29, description = "Test to check Related Stories and Topics of an Article")
    fun testRelatedStoriesArticle() {
        startTest("Checking for Related Story Article", "Test to check Related Stories of an Article", "Related Stories/Topics")
        scrollToElement(androidDriver, relatedStoriesArticle)
        elementDisplayed(androidDriver, relatedStories)
        selectView(relatedStoriesArticle)
        for (i in 0 until mostReadPopularLinksRelease.size) {
            isElementPresent(androidDriver, By.id(mostReadPopularLinksRelease[i]))
        }
        if (shareStory.isDisplayed) {
            verticalSwipe(androidDriver, "Up")
        }
        selectView(navigateBack)
    }

    @Test(priority = 30, description = "Test to check Related Topics of an Article")
    fun testRelatedTopicArticle() {
        startTest("Checking for Related Topic Article", "Test to check Related Topics of an Article", "Related Stories/Topics")
        scrollToElement(androidDriver, relatedTopicsArticle)
        elementDisplayed(androidDriver, relatedTopics)
        selectView(relatedTopicsArticle)
        assertEquals("Egypt", androidDriver.findElement(By.id("bbc.mobile.news.uk.internal:id/title")).text)
        assertEquals("Add topic", androidDriver.findElement(By.id("bbc.mobile.news.uk.internal:id/menu_follow")).getAttribute("contentDescription"))
        for (i in 0 until topicsPageElementsRelease.size) {
            isElementPresent(androidDriver, By.id(topicsPageElementsRelease[i]))
        }
        selectView(backButton)
        pressBack()
        selectView(backButton)
    }

    @Test(priority = 31, description = "Test to check the T&C , PrivacyPolicy from Menu options")
    fun testTermsPrivacyPolicy() {
        startTest("Checking T&C Privacy Policy", "Checking T&C and privacy Policy", "Menu")
        selectView(menuButton)
        selectView(menuAppInfo)
        selectView(termsConditions)
        pressBack()
        selectView(privacyPolicy)
        pressBack()
        selectView(backButton)
    }

    @Test(priority = 32, description = "Playing a video from Video page")
    fun testTopStoriesVideo() {
        startTest("Playing a OnDemand Video", "Test to play a video from Video page", "OnDemandVideo")
        selectView(video)
        elementDisplayed(androidDriver, topStories)
        // elementDisplayed(androidDriver, topStoriesVideoPlayTime)
        // elementDisplayed(androidDriver, topstoriesvideolayoutname)
        scrollToElement(androidDriver, topStoriesVideo)
        selectView(topStoriesVideo)
        selectView(accessibilityPlay)
        // androidDriver.findElementByAccessibilityId("Play").click();
        transportControls.click()
        transportControls.click()
        for (i in 0 until popularVideoElementsRelease.size) {
            isElementPresent(androidDriver, By.id(popularVideoElementsRelease[i]))
        }
        pressBack()
    }

    @Test(priority = 33, description = "App Backgrounding")
    fun testAppBackground() {
        startTest("App Background ", "Test to check backgrouding the app and reopen and checking same page opens", "App Background")
        popular.click()
        androidDriver.runAppInBackground(Duration.ofSeconds(30))
        (androidDriver as StartsActivity).currentActivity()
        assertTrue(popular.isSelected)
    }

    @Test(priority = 34, description = "Test to check the Popular page and also to check Most Read Displayed")
    fun testPopularPage() {
        startTest("Checking PopularPage", "Checking Popular Page", "Popular")
        selectView(popular)
        elementDisplayed(androidDriver, mostRead)
    }

    @Test(priority = 35, description = "Test to select one Article from Most Read  Article from Popular Page")
    fun testCheckMostReadPopular() {
        startTest("Checking Article from Most Read Section", "Checking Most Read Popular", "Popular")
        elementDisplayed(androidDriver, mostRead)
        selectView(mostReadArticle)
        //            for(int i=0;i<mostReadPopularLinks.length;i++)
        //            {
        //                isElementPresent(androidDriver,By.id(mostReadPopularLinks[i]));
        //            }
    }

    @Test(priority = 36, description = "Test to check whether the Most Watched heading displayed in Popular Page")
    fun testMostWatched() {
        pressBack()
        startTest("Checking Most Popular Section", "Checking Most Watched", "Popular")
        scrollToElement(androidDriver, popularMostWatched)
        elementDisplayed(androidDriver, popularMostWatched)
    }

    @Test(priority = 37, description = "Test to check whether the Most Watched heading displayed in Popular Page")
    fun testMostWatchedArticle() {
        startTest("Checking Most Watched Article ", "Checking Most Watched", "Popular")
        scrollToElement(androidDriver, mostWatchedArticleVideo)
        System.out.println("The Element selected is  :- " + mostWatchedArticleVideo.text)
        mostWatchedArticleVideo.click()
        if (mostPopular.isDisplayed) {
            verticalSwipe(androidDriver, "Up")
        }
        for (i in 0 until videoWallElementsRelease.size) {
            isElementPresent(androidDriver, By.id(videoWallElementsRelease[i]))
        }
        pressBack()
    }

    @Test(priority = 38, description = "Test re-arrange topics from bottom to top")
    fun testArrangeTopicsFromBottomToTop() {
        startTest("Re Arrange Topics from Bottom-to-Top", "Test re-arrange topics from bottom to top", "MyNews")
        selectView(myNews)
        selectView(MyNewsPageObject.editMyNews)

        val india = androidDriver.findElementsById("bbc.mobile.news.uk.internal:id/grab_handle")[5]
        val europe = androidDriver.findElementsById("bbc.mobile.news.uk.internal:id/grab_handle")[0]

        elementDragDrop(androidDriver, india, europe)
        readRecyclerView(androidDriver, "Topics After  Re-Ordering :- ")

        assertNotEquals("Rape in India", androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='1']/android.widget.RelativeLayout[@index='5']/android.widget.TextView[@index='1']")).text, "Test Didn't Matched")
        assertEquals("Rape in India", androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='1']/android.widget.RelativeLayout[@index='1']/android.widget.TextView[@index='1']")).text, "Test Matched")
        // Assert.assertEquals("European Union",androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='1']/android.widget.RelativeLayout[@index='2']/android.widget.TextView[@index='1']")).getText(), "Test Matched");
        assertEquals("YouTube", androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='1']/android.widget.RelativeLayout[@index='5']/android.widget.TextView[@index='1']")).text, "Test Matched")
        pressBack()
    }

    @Test(priority = 39, description = "Test to check the offline scenario of the app")
    fun testOfflineScenario() {
        startTest("Going OffLine", "Checking apps offline scenario", "Offline")
        val state = androidDriver.setConnection(ConnectionStateBuilder()
                .withWiFiDisabled()
                .build())
        androidDriver.connection = state
        //        waitForScreenToLoad(androidDriver,topStories,10);
        //        tapButton(androidDriver,topStories,false);
        //        scrollToElement(androidDriver, videoOfTheDayWatch);
        //        selectView(videoOfTheDayButton);
        //        Assert.assertEquals("You're not connected to the internet.", MyNewsPageObject.snackbar.getText(), "Text Matched");
    }

    @Test(priority = 40, description = "Test to play a  video, while device offline")
    fun testPlayingVideoOffline() {
        startTest("VideoPlayback-Offline", "Checking the Video while device offline", "Offline")
        selectView(video)
        selectView(bbcNewsChannel)
        elementDisplayed(androidDriver, liveMediaItemCaption)
        elementDisplayed(androidDriver, navigateBack)
        elementDisplayed(androidDriver, shareStory)
        selectView(accessibilityPlay)
        elementDisplayed(androidDriver, smpErrorMessage)
        elementDisplayed(androidDriver, smpErrorOkButton)
        elementDisplayed(androidDriver, smpRetryButton)

        val state = androidDriver.setConnection(ConnectionStateBuilder()
                .withWiFiEnabled()
                .build())
        androidDriver.connection = state
        System.out.println("The Connection state is " + state.isWiFiEnabled)
        waitFor(1000)
        assertTrue(state.isWiFiEnabled)
        pressBack()
        selectView(myNews)
        selectView(popular)
    }

    @Test(priority = 41, description = "Test to play a  video, while device online")
    fun testPlayingVideoOnLine() {
        startTest("VideoPlayback-Online", "Checking the Video while device Online", "Offline")
        selectView(video)
        selectView(bbcNewsChannel)
        selectView(accessibilityPlay)
        isElementPresent(androidDriver, By.id("bbc.mobile.news.uk:id/smp_error_message"))
        isElementPresent(androidDriver, By.id("bbc.mobile.news.uk:id/smp_retry_button"))
        isElementPresent(androidDriver, By.id("bbc.mobile.news.uk:id/smp_error_button"))
        pressBack()
    }

}
