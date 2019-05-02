package com.bbcnews.automation.commonfunctions

import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver

object ScreenAssertions {

    private var commonFunctionKotlin = CommonFunctionKotlin()

    fun assertDisplayingElements(driver: AndroidDriver<MobileElement>, vararg elements: MobileElement) {
        for (element in elements) {
            commonFunctionKotlin.elementDisplayed(driver, element)
        }
    }
}