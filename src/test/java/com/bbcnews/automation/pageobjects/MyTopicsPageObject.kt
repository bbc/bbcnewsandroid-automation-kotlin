package com.bbcnews.automation.pageobjects

import io.appium.java_client.MobileElement
import io.appium.java_client.pagefactory.AndroidFindBy

object MyTopicsPageObject {

    @AndroidFindBy(accessibility = "Button: Add England to My News")
    lateinit var addEnglandTopicButton: MobileElement

    @AndroidFindBy(accessibility = "Button: Add World to My News")
    lateinit var addWorldTopicButton: MobileElement

    @AndroidFindBy(accessibility = "Button: Add Wales to My News")
    lateinit var addWalesTopicButton: MobileElement

    @AndroidFindBy(accessibility = "Button: Add Africa to My News")
    lateinit var addAfricaTopicButton: MobileElement

    @AndroidFindBy(accessibility = "Button: Add European Union to My News")
    lateinit var addEuTopicButton: MobileElement

    @AndroidFindBy(accessibility = "Button: Add Mortgages to My News")
    lateinit var addMortgagesTopicButton: MobileElement

    @AndroidFindBy(accessibility = "Button: Add YouTube to My News")
    lateinit var addYouTubeTopicButton: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Africa']")
    lateinit var africaTopic: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='England']")
    lateinit var englandTopic: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Wales']")
    lateinit var walesTopic: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='World']")
    lateinit var worldTopic: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='European Union']")
    lateinit var europeanTopic: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Mortgages']")
    lateinit var mortgagesTopic: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='YouTube']")
    lateinit var youTubeTopic: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Education']")
    lateinit var educationTopic: MobileElement

}
