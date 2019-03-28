package com.bbcnews.automation.commonfunctions

import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver

object ScreenAssertions {

    private var commonFunctionKotlin = CommonFunctionKotlin()
    private lateinit var androidDriver: AndroidDriver<MobileElement>

    fun assertDisplayingElements(vararg elements: MobileElement) {
        for (element in elements) {
            commonFunctionKotlin.elementDisplayed(androidDriver, element)
        }
    }
}