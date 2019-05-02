package com.bbcnews.automation.commonfunctions

import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.elementDisplayed
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver

object ScreenAssertions {

    fun assertDisplayingElements(driver: AndroidDriver<MobileElement>, vararg elements: MobileElement?) {
        for (element in elements) {
            elementDisplayed(driver, element)
        }
    }
}