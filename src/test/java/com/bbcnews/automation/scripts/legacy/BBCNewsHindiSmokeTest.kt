package com.bbcnews.automation.scripts.legacy

import com.bbcnews.automation.commonfunctions.AppiumViewActions.elementDisplayed
import com.bbcnews.automation.commonfunctions.AppiumViewActions.selectView
import com.bbcnews.automation.commonfunctions.AppiumViewActions.startTest
import com.bbcnews.automation.commonfunctions.ScreenActions.pressBack
import com.bbcnews.automation.commonfunctions.ScreenActions.scrollDownToElement
import com.bbcnews.automation.commonfunctions.ScreenActions.generalSwipeUp
import com.bbcnews.automation.commonfunctions.ScreenAssertions.assertDisplayingElements
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.article
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.bbcHindiEntertainment
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.bbcHindiHelp
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.bbcHindiHomepage
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.bbcHindiIndia
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.bbcHindiInternational
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.bbcHindiLookAt
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.bbcHindiMoreSettings
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.bbcHindiOtherBbcApplications
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.bbcHindiPleaseContact
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.bbcHindiRadio
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.bbcHindiScienceTechnology
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.bbcHindiSettings
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.bbcHindiSocial
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.bbcHindiSports
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.bbcHindiThePhotos
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.bbcHindiTopics
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.bbcMoreOptions
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.frontPage
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.fullScreenButton
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.headlineAuthorName
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.headlineAuthorTitle
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.headlineInfo
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.headlineTitle
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.hindiBharath
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.hindiEntertainment
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.hindiHomepage
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.hindiInternational
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.hindiLookAt
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.hindiPhotos
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.hindiScience
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.hindiSocial
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.imageItemBadge
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.imageItemCaption
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.mainItemLayoutLastUpdated
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.mainItemLayoutName
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.mediaItemCaption
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.pauseButton
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.picturesSubtitle
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.picturesTitle
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.playButton
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.radioPageText
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.radioPageTextDaily
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.relatedArticles
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.relatedTopics
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.seekBar
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.volumeButton
import com.bbcnews.automation.scripts.BbcTestCase
import com.bbcnews.automation.testutils.TestSetup
import com.bbcnews.automation.testutils.TestSetup.androidDriver
import io.qameta.allure.Severity
import io.qameta.allure.SeverityLevel
import io.qameta.allure.Story
import org.openqa.selenium.By
import org.testng.Assert.assertEquals
import org.testng.Assert.assertTrue
import org.testng.annotations.BeforeTest
import org.testng.annotations.Test

class BBCNewsHindiSmokeTest : BbcTestCase("Regression") {

    @BeforeTest
    fun beforeEachTest() {
        setUp()
        androidDriver = TestSetup.setAndroidDriver()
    }

    @Test(priority = 2, description = "Check the links on the Home page after app launched")
    fun testCheckHindiHomePage() {
        startTest("HomePage", "Checking the HomePage", "Smoke")
        selectView(androidDriver, bbcHindiHomepage)
        assertTrue(bbcHindiHomepage.isSelected)

        assertDisplayingElements(mainItemLayoutName,
                mainItemLayoutLastUpdated
        )

        selectView(androidDriver, article)
        if (frontPage.isDisplayed) {
            System.out.println("Scrolling up")
            generalSwipeUp(androidDriver)
        }

        assertDisplayingElements(imageItemBadge,
                headlineTitle,
                headlineInfo,
                headlineAuthorName,
                headlineAuthorTitle
        )
        pressBack()
    }

    @Test(priority = 3, description = "checking the india page")
    fun testIndiaPage() {
        startTest("IndiaPage", "Checking the IndiaPage", "Smoke")
        selectView(androidDriver, bbcHindiIndia)
        assertTrue(bbcHindiIndia.isSelected)
        assertDisplayingElements(mainItemLayoutName,
                mainItemLayoutLastUpdated
        )

        selectView(androidDriver, article)

        assertDisplayingElements(imageItemBadge,
                headlineTitle,
                headlineInfo,
                headlineAuthorName,
                headlineAuthorTitle
        )

        scrollDownToElement(androidDriver, relatedTopics)

        assertDisplayingElements(relatedArticles)
        pressBack()
    }

    @Test(priority = 3, description = "checking the international page")
    fun testHindiInternationalPage() {
        startTest("InternationalPage", "Checking the InternationalPage", "Smoke")
        selectView(androidDriver, bbcHindiInternational)
        assertTrue(bbcHindiInternational.isSelected)

        assertDisplayingElements(mainItemLayoutName,
                mainItemLayoutLastUpdated
        )

        selectView(androidDriver, article)

        assertDisplayingElements(headlineTitle,
                headlineInfo
        )

        pressBack()
    }

    @Test(priority = 4, description = "checking the Entertainment page")
    fun testHindiEntertainmentPage() {
        startTest("EntertainmentPage", "Checking the EntertainmentPage", "Smoke")
        selectView(androidDriver, bbcHindiEntertainment)
        assertTrue(bbcHindiEntertainment.isSelected)
        assertDisplayingElements(mainItemLayoutName,
                mainItemLayoutLastUpdated
        )

        selectView(androidDriver, article)

        assertDisplayingElements(headlineTitle,
                //imageItemBadge,
                headlineInfo
        )

        scrollDownToElement(androidDriver, relatedTopics)
        assertDisplayingElements(relatedArticles)

        pressBack()
    }

    @Test(priority = 5, description = "checking the Sports page")
    fun testHindiSportsPage() {
        startTest("Sports", "Checking the Sports", "Smoke")
        selectView(androidDriver, bbcHindiSports)
        assertTrue(bbcHindiSports.isSelected)

        assertDisplayingElements(mainItemLayoutName,
                mainItemLayoutLastUpdated
        )

        selectView(androidDriver, article)

        assertDisplayingElements(imageItemBadge,
                headlineTitle,
                headlineInfo,
                imageItemCaption
        )

        scrollDownToElement(androidDriver, relatedTopics)
        assertDisplayingElements(relatedArticles)

        pressBack()
    }

    @Test(priority = 6, description = "checking the Radio page")
    fun testHindiRadioPage() {
        startTest("Radio", "Checking the Radio", "Smoke")
        selectView(androidDriver, bbcHindiRadio)
        assertTrue(bbcHindiRadio.isSelected)

        elementDisplayed(androidDriver, headlineTitle)
        assertEquals("सुनिए", headlineTitle.text)
        elementDisplayed(androidDriver, headlineInfo)
        assertEquals("12 अप्रै 2018", headlineInfo.text)

        elementDisplayed(androidDriver, radioPageText)
        assertEquals("नमस्कार भारत  (06.30IST - 07.00IST)", radioPageText.text)

        elementDisplayed(androidDriver, radioPageTextDaily)
        assertEquals("दिनभर (19.30IST - 20.00IST)", radioPageTextDaily.text)
    }

    @Test(priority = 7, description = "checking the Science&Technology page")
    fun testHindiScienceTechnologyPage() {
        startTest("Science&Technology", "Checking the Science&Technology", "Smoke")
        selectView(androidDriver, bbcHindiScienceTechnology)
        assertTrue(bbcHindiScienceTechnology.isSelected)

        assertDisplayingElements(mainItemLayoutName,
                mainItemLayoutLastUpdated
        )

        selectView(androidDriver, article)

        assertDisplayingElements(headlineTitle,
                headlineInfo
        )

        scrollDownToElement(androidDriver, relatedTopics)

        pressBack()
    }

    @Test(priority = 8, description = "checking the Science&Technology page")
    fun testHindiLookAtPage() {
        startTest("LookAt", "Checking the Science&LookAt Page", "Smoke")
        selectView(androidDriver, bbcHindiLookAt)
        assertTrue(bbcHindiLookAt.isSelected)

        assertDisplayingElements(mainItemLayoutName,
                mainItemLayoutLastUpdated
        )

        selectView(androidDriver, article)

        assertDisplayingElements(playButton,
                mediaItemCaption,
                headlineTitle,
                headlineInfo
        )

        selectView(androidDriver, playButton)

        assertDisplayingElements(volumeButton,
                fullScreenButton,
                seekBar,
                pauseButton
        )

        pressBack()
    }

    @Test(priority = 9, description = "checking the Pictures  page")
    fun testHindiPicturesPage() {
        startTest("Pictures", "Checking the Pictures Page", "Smoke")
        selectView(androidDriver, bbcHindiThePhotos)
        assertTrue(bbcHindiThePhotos.isSelected)

        assertDisplayingElements(mainItemLayoutName,
                mainItemLayoutLastUpdated
        )

        selectView(androidDriver, article)

        assertDisplayingElements(picturesTitle,
                picturesSubtitle
        )

        for (i in 0..6) {
            val images = androidDriver.findElement(By.xpath("//android.widget.ImageView[@index='$i']"))
            images.isDisplayed
        }
        pressBack()
    }

    @Test(priority = 10, description = "checking the Social  page")
    fun testHindiSocialPage() {
        startTest("Social", "Checking the Social Page", "Smoke")
        selectView(androidDriver, bbcHindiSocial)
        assertTrue(bbcHindiSocial.isSelected)

        assertDisplayingElements(mainItemLayoutName,
                mainItemLayoutLastUpdated
        )

        selectView(androidDriver, article)

        assertDisplayingElements(headlineTitle,
                headlineInfo
        )

        pressBack()
    }

    @Test(priority = 11, description = "Checking the MoreOptions Menu")
    @Story("MoreOptions")
    @Severity(SeverityLevel.CRITICAL)
    fun testHindiMenuItems() {
        startTest("MoreOptions", "Checking the MoreOptions Menu", "Smoke")
        selectView(androidDriver, bbcMoreOptions)

        assertDisplayingElements(bbcHindiHelp,
                bbcHindiSettings,
                //  bbcHindiInternalSettings,
                bbcHindiPleaseContact,
                bbcHindiOtherBbcApplications)
        pressBack()
    }

    @Test(priority = 12, description = "Checking the More Settings Options Menu")
    @Story("MoreOptions")
    @Severity(SeverityLevel.CRITICAL)
    fun testHindiMoreSettingsOptions() {
        startTest("MoreOptions", "Checking the More Settings Options Menu", "Smoke")
        selectView(androidDriver, bbcHindiMoreSettings)

        assertDisplayingElements(bbcHindiTopics
        )
    }

    @Test(priority = 13, description = "Checking the More Settings Options Topics")
    @Story("MoreOptions-Topics")
    @Severity(SeverityLevel.CRITICAL)
    fun testHindiMoreSettingsOptionsTopics() {
        startTest("MoreOptionsTopics", "Checking the More Settings Options Topics", "Smoke")
        //  tapButton(androidDriver,BBCNewsHindiPageObject.bbcHindiTopicsCollapseGroup,false);
        assertDisplayingElements(hindiHomepage,
                hindiBharath,
                hindiEntertainment,
                hindiInternational,
                hindiLookAt,
                hindiScience,
                hindiPhotos,
                hindiSocial)
    }

}
