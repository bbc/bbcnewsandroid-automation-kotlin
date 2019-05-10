package com.bbcnews.automation.scripts

import com.bbcnews.automation.commonfunctions.AppiumViewActions.elementDisplayed
import com.bbcnews.automation.commonfunctions.AppiumViewActions.scrollToElement
import com.bbcnews.automation.commonfunctions.AppiumViewActions.selectView
import com.bbcnews.automation.commonfunctions.AppiumViewActions.startTest
import com.bbcnews.automation.commonfunctions.AppiumViewActions.verticalSwipe
import com.bbcnews.automation.commonfunctions.ScreenActions.pressBack
import com.bbcnews.automation.commonfunctions.ScreenAssertions.assertDisplayingElements
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.article
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.bbcHindiEntertainment
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.bbcHindiHelp
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.bbcHindiHomepage
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.bbcHindiIndia
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.bbcHindiInternational
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.bbcHindiLookAt
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.bbcHindiMessage
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.bbcHindiMoreSettings
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.bbcHindiOkButton
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
import com.bbcnews.automation.pageobjects.BBCNewsHindiPageObject.noThanksButton
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
import com.bbcnews.automation.testutils.TestSetup.androidDriver
import io.qameta.allure.Severity
import io.qameta.allure.SeverityLevel
import io.qameta.allure.Story
import org.openqa.selenium.By
import org.testng.Assert.assertEquals
import org.testng.Assert.assertTrue
import org.testng.annotations.Test

class BBCNewsHindiSmokeTest : BbcTestCase("Regression") {

    @Test(priority = 1, description = "launching the app ")
    @Story("Home")
    @Severity(SeverityLevel.CRITICAL)
    fun testOpenNewsApp() {
        assertEquals("ओके", bbcHindiOkButton?.text, "Text Matched")
        assertEquals("बीबीसी न्यूज़ आपको नोटिफ़िकेशंस भेजना चाहता है. आप कभी भी सेटिंग्स में जाकर बदलाव कर सकते हैं.", bbcHindiMessage?.text)
        selectView(bbcHindiOkButton)
        selectView(noThanksButton)
    }

    @Test(priority = 2, description = "Check the links on the Home page after app launched")
    fun testCheckHindiHomePage() {
        startTest("HomePage", "Checking the HomePage", "Smoke")
        selectView(bbcHindiHomepage)
        assertTrue(bbcHindiHomepage?.isSelected!!)

        assertDisplayingElements(androidDriver,
                mainItemLayoutName,
                mainItemLayoutLastUpdated
        )

        selectView(article)
        if (frontPage?.isDisplayed!!) {
            System.out.println("Scrolling up")
            verticalSwipe(androidDriver, "Up")
        }

        assertDisplayingElements(androidDriver,
                imageItemBadge,
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
        selectView(bbcHindiIndia)
        assertTrue(bbcHindiIndia?.isSelected!!)
        assertDisplayingElements(androidDriver,
                mainItemLayoutName,
                mainItemLayoutLastUpdated
        )

        selectView(article)

        assertDisplayingElements(androidDriver,
                imageItemBadge,
                headlineTitle,
                headlineInfo,
                headlineAuthorName,
                headlineAuthorTitle
        )

        scrollToElement(androidDriver, relatedTopics)

        assertDisplayingElements(androidDriver, relatedArticles)
        pressBack()
    }

    @Test(priority = 3, description = "checking the international page")
    fun testHindiInternationalPage() {
        startTest("InternationalPage", "Checking the InternationalPage", "Smoke")
        selectView(bbcHindiInternational)
        assertTrue(bbcHindiInternational?.isSelected!!)

        assertDisplayingElements(androidDriver,
                mainItemLayoutName,
                mainItemLayoutLastUpdated
        )

        selectView(article)

        assertDisplayingElements(androidDriver,
                headlineTitle,
                headlineInfo
        )

        pressBack()
    }

    @Test(priority = 4, description = "checking the Entertainment page")
    fun testHindiEntertainmentPage() {
        startTest("EntertainmentPage", "Checking the EntertainmentPage", "Smoke")
        selectView(bbcHindiEntertainment)
        assertTrue(bbcHindiEntertainment?.isSelected!!)
        assertDisplayingElements(androidDriver,
                mainItemLayoutName,
                mainItemLayoutLastUpdated
        )

        selectView(article)

        assertDisplayingElements(androidDriver,
                //imageItemBadge,
                headlineTitle,
                headlineInfo
        )

        scrollToElement(androidDriver, relatedTopics)
        assertDisplayingElements(androidDriver, relatedArticles)

        pressBack()
    }

    @Test(priority = 5, description = "checking the Sports page")
    fun testHindiSportsPage() {
        startTest("Sports", "Checking the Sports", "Smoke")
        selectView(bbcHindiSports)
        assertTrue(bbcHindiSports?.isSelected!!)

        assertDisplayingElements(androidDriver,
                mainItemLayoutName,
                mainItemLayoutLastUpdated
        )

        selectView(article)

        assertDisplayingElements(androidDriver,
                imageItemBadge,
                headlineTitle,
                headlineInfo,
                imageItemCaption
        )

        scrollToElement(androidDriver, relatedTopics)
        assertDisplayingElements(androidDriver, relatedArticles)

        pressBack()
    }

    @Test(priority = 6, description = "checking the Radio page")
    fun testHindiRadioPage() {
        startTest("Radio", "Checking the Radio", "Smoke")
        selectView(bbcHindiRadio)
        assertTrue(bbcHindiRadio?.isSelected!!)

        elementDisplayed(androidDriver, headlineTitle)
        assertEquals("सुनिए", headlineTitle?.text)
        elementDisplayed(androidDriver, headlineInfo)
        assertEquals("12 अप्रै 2018", headlineInfo?.text)

        elementDisplayed(androidDriver, radioPageText)
        assertEquals("नमस्कार भारत  (06.30IST - 07.00IST)", radioPageText?.text)

        elementDisplayed(androidDriver, radioPageTextDaily)
        assertEquals("दिनभर (19.30IST - 20.00IST)", radioPageTextDaily?.text)
    }

    @Test(priority = 7, description = "checking the Science&Technology page")
    fun testHindiScienceTechnologyPage() {
        startTest("Science&Technology", "Checking the Science&Technology", "Smoke")
        selectView(bbcHindiScienceTechnology)
        assertTrue(bbcHindiScienceTechnology?.isSelected!!)

        assertDisplayingElements(androidDriver,
                mainItemLayoutName,
                mainItemLayoutLastUpdated
        )

        selectView(article)

        assertDisplayingElements(androidDriver,
                headlineTitle,
                headlineInfo
        )

        scrollToElement(androidDriver, relatedTopics)

        pressBack()
    }

    @Test(priority = 8, description = "checking the Science&Technology page")
    fun testHindiLookAtPage() {
        startTest("LookAt", "Checking the Science&LookAt Page", "Smoke")
        selectView(bbcHindiLookAt)
        assertTrue(bbcHindiLookAt?.isSelected!!)

        assertDisplayingElements(androidDriver,
                mainItemLayoutName,
                mainItemLayoutLastUpdated
        )

        selectView(article)

        assertDisplayingElements(androidDriver,
                playButton,
                mediaItemCaption,
                headlineTitle,
                headlineInfo
        )

        selectView(playButton)

        assertDisplayingElements(androidDriver,
                volumeButton,
                fullScreenButton,
                seekBar,
                pauseButton
        )

        pressBack()
    }

    @Test(priority = 9, description = "checking the Pictures  page")
    fun testHindiPicturesPage() {
        startTest("Pictures", "Checking the Pictures Page", "Smoke")
        selectView(bbcHindiThePhotos)
        assertTrue(bbcHindiThePhotos?.isSelected!!)

        assertDisplayingElements(androidDriver,
                mainItemLayoutName,
                mainItemLayoutLastUpdated
        )

        selectView(article)

        assertDisplayingElements(androidDriver,
                picturesTitle,
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
        selectView(bbcHindiSocial)
        assertTrue(bbcHindiSocial?.isSelected!!)

        assertDisplayingElements(androidDriver,
                mainItemLayoutName,
                mainItemLayoutLastUpdated
        )

        selectView(article)

        assertDisplayingElements(androidDriver,
                headlineTitle,
                headlineInfo
        )

        pressBack()
    }

    @Test(priority = 11, description = "Checking the MoreOptions Menu")
    @Story("MoreOptions")
    @Severity(SeverityLevel.CRITICAL)
    fun testHindiMenuItems() {
        startTest("MoreOptions", "Checking the MoreOptions Menu", "Smoke")
        selectView(bbcMoreOptions)

        assertDisplayingElements(androidDriver,
                bbcHindiHelp,
                //  bbcHindiInternalSettings,
                bbcHindiSettings,
                bbcHindiPleaseContact,
                bbcHindiOtherBbcApplications)
        pressBack()
    }

    @Test(priority = 12, description = "Checking the More Settings Options Menu")
    @Story("MoreOptions")
    @Severity(SeverityLevel.CRITICAL)
    fun testHindiMoreSettingsOptions() {
        startTest("MoreOptions", "Checking the More Settings Options Menu", "Smoke")
        selectView(bbcHindiMoreSettings)

        assertDisplayingElements(androidDriver,
                // bbcHindiLocalNews,
                bbcHindiTopics
        )
    }

    @Test(priority = 13, description = "Checking the More Settings Options Topics")
    @Story("MoreOptions-Topics")
    @Severity(SeverityLevel.CRITICAL)
    fun testHindiMoreSettingsOptionsTopics() {
        startTest("MoreOptionsTopics", "Checking the More Settings Options Topics", "Smoke")
        //  tapButton(androidDriver,BBCNewsHindiPageObject.bbcHindiTopicsCollapseGroup,false);
        assertDisplayingElements(androidDriver,
                hindiHomepage,
                hindiBharath,
                hindiEntertainment,
                hindiInternational,
                hindiLookAt,
                hindiScience,
                hindiPhotos,
                hindiSocial)
    }

}
