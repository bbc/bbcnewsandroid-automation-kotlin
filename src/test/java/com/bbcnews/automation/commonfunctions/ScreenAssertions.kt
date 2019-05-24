package com.bbcnews.automation.commonfunctions

import com.bbcnews.automation.commonfunctions.AppiumViewActions.checkIfDisplayingElement
import com.bbcnews.automation.pageobjects.IndexPageObjects
import io.appium.java_client.MobileElement
import org.testng.Assert.assertEquals

object ScreenAssertions {

    fun assertDisplayingElements(vararg elements: MobileElement) {
        for (element in elements) checkIfDisplayingElement(element)
    }

    fun assertIndexTitleMatches(topic: String) {
        assertEquals(IndexPageObjects.indexTitle.text, topic)
    }
}