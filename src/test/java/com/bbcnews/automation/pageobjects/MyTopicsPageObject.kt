package com.bbcnews.automation.pageobjects

import io.appium.java_client.MobileElement
import io.appium.java_client.pagefactory.AndroidFindBy

object MyTopicsPageObject {

    @AndroidFindBy(accessibility = "Button: Add England to My News")
    val addEnglandTopicButton: MobileElement? = null

    @AndroidFindBy(accessibility = "Button: Add World to My News")
    val addWorldTopicButton: MobileElement? = null

    @AndroidFindBy(accessibility = "Button: Add Wales to My News")
    val addWalesTopicButton: MobileElement? = null

    @AndroidFindBy(accessibility = "Button: Add Africa to My News")
    val addAfricaTopicButton: MobileElement? = null

    @AndroidFindBy(accessibility = "Button: Add European Union to My News")
    val addEuTopicButton: MobileElement? = null

    @AndroidFindBy(accessibility = "Button: Add Mortgages to My News")
    val addMortgagesTopicButton: MobileElement? = null

    @AndroidFindBy(accessibility = "Button: Add YouTube to My News")
    val addYouTubeTopicButton: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Africa']")
    val africaTopic: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='England']")
    val englandTopic: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Wales']")
    val walesTopic: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='World']")
    val worldTopic: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='European Union']")
    val europeanTopic: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Mortgages']")
    val mortgagesTopic: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='YouTube']")
    val youTubeTopic: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Education']")
    val educationTopic: MobileElement? = null

}
