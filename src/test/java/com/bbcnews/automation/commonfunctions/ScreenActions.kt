package com.bbcnews.automation.commonfunctions

import com.bbcnews.automation.commonfunctions.AppiumViewActions.navigateBack
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver

object ScreenActions {

    private lateinit var androidDriver: AndroidDriver<MobileElement>

    fun pressBack() = navigateBack(androidDriver)

}