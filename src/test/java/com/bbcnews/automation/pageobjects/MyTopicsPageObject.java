package com.bbcnews.automation.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MyTopicsPageObject {

    public MyTopicsPageObject() {

    }

    @AndroidFindBy(accessibility = "Button: Add England to My News")
    public MobileElement addEnglandTopicButton;

    @AndroidFindBy(accessibility = "Button: Add World to My News")
    public MobileElement addWorldTopicButton;

    @AndroidFindBy(accessibility = "Button: Add Wales to My News")
    public MobileElement addWalesTopicButton;

    @AndroidFindBy(accessibility = "Button: Add Africa to My News")
    public MobileElement addAfricaTopicButton;

    @AndroidFindBy(accessibility = "Button: Add European Union to My News")
    public MobileElement addEuTopicButton;

    @AndroidFindBy(accessibility = "Button: Add Mortgages to My News")
    public MobileElement addMortgagesTopicButton;

    @AndroidFindBy(accessibility = "Button: Add YouTube to My News")
    public MobileElement addYouTubeTopicButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Africa']")
    public MobileElement africaTopic;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='England']")
    public MobileElement englandTopic;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Wales']")
    public MobileElement walesTopic;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='World']")
    public MobileElement worldTopic;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='European Union']")
    public MobileElement europeanTopic;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Mortgages']")
    public MobileElement mortgagesTopic;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='YouTube']")
    public MobileElement youTubeTopic;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Education']")
    public MobileElement educationTopic;

}
