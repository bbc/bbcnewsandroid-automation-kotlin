package com.bbcnews.automation.commonfunctions

import com.bbcnews.automation.commonfunctions.AppiumViewActions.elementDisplayed
import com.bbcnews.automation.pageobjects.BasePageObject
import com.bbcnews.automation.testutils.TestSetup
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver

object ScreenAssertions {

    fun assertDisplayingElements(driver: AndroidDriver<MobileElement>, vararg elements: MobileElement) {
        for (element in elements) {
            elementDisplayed(driver, element)
        }
    }

    fun assertOnHomePage() {
        try {
            AppiumViewActions.selectView(TestSetup.androidDriver, BasePageObject.navigateBack)
        } catch (e: NoSuchElementException) {
            // Ignore if already on the main screen
            assertDisplayingElements(TestSetup.androidDriver, BasePageObject.menuButton)
        }
    }
}