package com.bbcnews.automation.commonfunctions

import com.bbcnews.automation.commonfunctions.AppiumViewActions.navigateBack
import com.bbcnews.automation.commonfunctions.AppiumViewActions.verticalSwipe
import com.bbcnews.automation.commonfunctions.ScreenAssertions.assertDisplayingElements
import com.bbcnews.automation.pageobjects.BasePageObject.copyrightFooter
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import org.openqa.selenium.NoSuchElementException

object ScreenActions {

    private lateinit var androidDriver: AndroidDriver<MobileElement>

    fun pressBack() = navigateBack(androidDriver)

    @Throws(java.lang.Exception::class)
    fun scrollDownToElement(appiumDriver: AppiumDriver<MobileElement>, element: MobileElement) {
        for (i in 0..10) {
            try {
                assertDisplayingElements(element)
            } catch (e: NoSuchElementException) {
                if (!copyrightFooter.isDisplayed) {
                    generalScrollUp(appiumDriver)
                } else {
                    println("Could not find element in scrollview. \n Element searched: $element \n")
                    throw e
                }
            }
        }
    }

    fun generalScrollUp(appiumDriver: AppiumDriver<MobileElement>) = verticalSwipe(appiumDriver, "Up")
    fun generalScrollDown(appiumDriver: AppiumDriver<MobileElement>) = verticalSwipe(appiumDriver, "Down")

}