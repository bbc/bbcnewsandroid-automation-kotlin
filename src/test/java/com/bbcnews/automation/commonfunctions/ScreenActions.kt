package com.bbcnews.automation.commonfunctions

import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver

object ScreenActions {

    private var commonFunctionKotlin = CommonFunctionKotlin()
    private lateinit var androidDriver: AndroidDriver<MobileElement>

    fun pressBack() = commonFunctionKotlin.navigateBack(androidDriver)

}