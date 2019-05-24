package com.bbcnews.automation.commonfunctions

import com.bbcnews.automation.commonfunctions.AppiumViewActions.generalSwipe
import com.bbcnews.automation.commonfunctions.AppiumViewActions.navigateBack
import com.bbcnews.automation.commonfunctions.AppiumViewActions.smallSwipeUp
import com.bbcnews.automation.pageobjects.BasePageObject.copyrightFooter
import com.bbcnews.automation.pageobjects.BasePageObject.navigateBack
import com.bbcnews.automation.pageobjects.BasePageObject.topStories
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import org.openqa.selenium.NoSuchElementException

object ScreenActions {

    private lateinit var androidDriver: AndroidDriver<MobileElement>

    fun pressBack() = navigateBack(androidDriver)

    fun scrollDownToElement(appiumDriver: AppiumDriver<MobileElement>, element: MobileElement) {
        for (i in 0..10) {
            val elementIsDisplayed: Boolean = element.isDisplayed

            if (!elementIsDisplayed) scrollDownIfNotShowingFooter(appiumDriver, element)
            else break

        }
    }

    private fun scrollDownIfNotShowingFooter(appiumDriver: AppiumDriver<MobileElement>, element: MobileElement) {
        val footerIsDisplayed = copyrightFooter.isDisplayed

        if (!footerIsDisplayed) smallSwipeUp(appiumDriver)
        else println("Could not find element in scrollview. \n Element searched: $element \n")
    }

    fun goBackToHomeScreen() {
        for (i in 0..3) try {
            topStories.click()
            break
        } catch (e: NoSuchElementException) {
            navigateBack.click()
        }
    }

    fun generalSwipeUp(appiumDriver: AppiumDriver<MobileElement>) = generalSwipe(appiumDriver, "Up")
    fun generalSwipeDown(appiumDriver: AppiumDriver<MobileElement>) = generalSwipe(appiumDriver, "Down")
    fun generalSwipeLeft(appiumDriver: AppiumDriver<MobileElement>) = generalSwipe(appiumDriver, "Left")
    fun generalSwipeRight(appiumDriver: AppiumDriver<MobileElement>) = generalSwipe(appiumDriver, "Right")

}