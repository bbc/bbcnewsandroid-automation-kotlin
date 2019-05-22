package com.bbcnews.automation.commonfunctions

import com.bbcnews.automation.commonfunctions.AppiumViewActions.checkIfDisplayingElement
import io.appium.java_client.MobileElement

object ScreenAssertions {

    fun assertDisplayingElements(vararg elements: MobileElement) {
        for (element in elements) checkIfDisplayingElement(element)
    }

}