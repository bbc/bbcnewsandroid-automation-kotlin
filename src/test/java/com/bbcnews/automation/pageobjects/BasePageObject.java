package com.bbcnews.automation.pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePageObject {

    AppiumDriver<MobileElement> appiumDriver;

    public BasePageObject() {
    }

    @AndroidFindBy(accessibility = "Navigate up")
    public MobileElement navigate_back;

    @AndroidFindBy(id = "android:id/button1")
    public MobileElement okButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='GO TO SETTINGS']")
    public MobileElement settingsButton;

    @AndroidFindBy(accessibility = "Back")
    public MobileElement backButton;

    @AndroidFindBy(id = "android:id/button2")
    public MobileElement noThanksButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Top Stories']")
    public MobileElement topStories;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='My News']")
    public MobileElement myNews;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Popular']")
    public MobileElement popular;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Video']")
    public MobileElement video;

    @AndroidFindBy(accessibility = "Search")
    public MobileElement searchButton;

    @AndroidFindBy(accessibility = "Share story")
    public MobileElement shareStory;

    @AndroidFindAll({
            @AndroidBy(id = "bbc.mobile.news.uk.internal:id/action_search"),
            @AndroidBy(id = "bbc.mobile.news.uk:id/action_search"),
            @AndroidBy(accessibility = "Search")
    })
    public MobileElement search;

    public String[] topicsPageElements = {
            "bbc.mobile.news.uk.internal:id/item_image",
            "bbc.mobile.news.uk.internal:id/item_layout_name",
            "bbc.mobile.news.uk.internal:id/item_layout_last_updated",
            "bbc.mobile.news.uk.internal:id/item_layout_home_section"
    };

    public String[] topicsPageElementsRelease = {
            "bbc.mobile.news.uk:id/item_image",
            "bbc.mobile.news.uk:id/item_layout_name",
            "bbc.mobile.news.uk:id/item_layout_last_updated",
            "bbc.mobile.news.uk:id/item_layout_home_section"
    };

     @AndroidFindAll({
                    @AndroidBy(id = "bbc.mobile.news.uk.internal:id/item_layout_name"),
                    @AndroidBy(id = "bbc.mobile.news.uk:id/item_layout_name")
    })
    public MobileElement itemLayoutName;

    @AndroidFindAll({
            @AndroidBy(id = "bbc.mobile.news.uk.internal:id/item_layout_last_updated"),
            @AndroidBy(id = "bbc.mobile.news.uk:id/item_layout_last_updated")
    })
    public MobileElement item_layout_last_updated;

    @AndroidFindAll({
            @AndroidBy(id = "bbc.mobile.news.uk.internal:id/item_layout_home_section"),
            @AndroidBy(id = "bbc.mobile.news.uk:id/item_layout_home_section")
    })
    public MobileElement item_layout_home_section;

    @AndroidFindBy(accessibility = "Show navigation menu drawer")
    public MobileElement menuButton;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Settings']")
    public MobileElement settings;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='App info']")
    public MobileElement appInfo;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Other BBC apps']")
    public MobileElement otherBbcApps;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Internal Settings']")
    public MobileElement InternalSettings;

    public String[] menuOptions = {
            "//android.widget.CheckedTextView[@text='Settings']",
            "//android.widget.CheckedTextView[@text='App info']",
            "//android.widget.CheckedTextView[@text='Other BBC apps']",
            "//android.widget.CheckedTextView[@text='Internal Settings']"
    };

    @AndroidFindAll({
            @AndroidBy(id = "bbc.mobile.news.uk.internal:id/search"),
            @AndroidBy(id = "bbc.mobile.news.uk:id/search")
    })

    public MobileElement searchField;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Brexit' and @index='0']")
    public MobileElement searchKeyword;

    @AndroidFindAll({
            @AndroidBy(id = "bbc.mobile.news.uk.internal:id/title"),
            @AndroidBy(id = "bbc.mobile.news.uk:id/title")
    })
    public MobileElement headlineTitle;

    @AndroidFindAll({
            @AndroidBy(xpath = "//android.widget.TextView[contains(@resource-id,'bbc.mobile.news.uk.internal:id/heading') and @index='0']"),
            @AndroidBy(xpath = "//android.widget.TextView[contains(@resource-id,'bbc.mobile.news.uk:id/heading') and @index='0']")
    })
    public MobileElement searchHeading;

    @AndroidFindAll({
            @AndroidBy(xpath = "//android.widget.TextView[@resource-id='bbc.mobile.news.uk.internal:id/heading' and @index='2']"),
            @AndroidBy(xpath = "//android.widget.TextView[@resource-id='bbc.mobile.news.uk:id/heading' and @index='2']")
    })
    public MobileElement searchHeading2;

    @AndroidFindAll({
            @AndroidBy(xpath = "//android.widget.TextView[@resource-id='bbc.mobile.news.uk.internal:id/heading' and @index='4']"),
            @AndroidBy(xpath = "//android.widget.TextView[@resource-id='bbc.mobile.news.uk:id/heading' and @index='4']")
    })
    public MobileElement searchHeading4;

    @AndroidFindAll({
            @AndroidBy(xpath = "//bbc.mobile.news.uk.internal:id/chip_item[@index='1']"),
            @AndroidBy(xpath = "//bbc.mobile.news.uk:id/chip_item[@index='1']")
    })

    public MobileElement searchSuggest1;

    public static String searchSuggest1Text = "India";

    @AndroidFindAll({
            @AndroidBy(xpath = "//bbc.mobile.news.uk.internal:id/chip_item[@index='2']"),
            @AndroidBy(xpath = "//bbc.mobile.news.uk:id/chip_item[@index='2']")
    })

    public MobileElement searchSuggest2;

    public static String searchSuggest2Text = "India-Pakistan independence";

    @AndroidFindAll({
            @AndroidBy(xpath = "//bbc.mobile.news.uk.internal:id/chip_item[@index='3']"),
            @AndroidBy(xpath = "//bbc.mobile.news.uk.internal:id/chip_item[@index='3']")
    })

    public MobileElement searchSuggest3;

    public static String searchSuggest3Text = "Rape in India";

    @AndroidFindBy(accessibility = "Cancel search")
    public MobileElement cancelSearch;

    public String subDirectory = "Screenshots";

    public String screenshotPaths;

    public String searchText = "Brexit";

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='UK Politics added to My News']")
    public MobileElement alertText;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='UNDO' and @index='1']")
    public MobileElement undoButton;

    public String alertTextUk = "UK Politics added to My News";

    public String alertTextBusiness = "Business added to My News";

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Rape in India']")
    public MobileElement article;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='3']/android.view.ViewGroup[@index='0']/android.widget.ImageView[@index='0']")
    public MobileElement articleSearch;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='How social media helped catch rape suspect' and @index='1']")
    public MobileElement articleItemWithItemBadge;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='India bishop accused of rape arrested' and @index='1']")
    public MobileElement articleItemWithoutItemBadge;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[6]/bbc.mobile.news.uk.internal:id/main_view[0]/android.widget.ImageView[@index='0']")
    public MobileElement articleItemImage;

    @AndroidFindAll({
            @AndroidBy(xpath = "//android.widget.TextView[contains(@resource-id,'bbc.mobile.news.uk.internal:id/item_layout_name') and @index='0']"),
            @AndroidBy(xpath = "//android.widget.TextView[contains(@resource-id,'bbc.mobile.news.uk:id/item_layout_name') and @index='0']")
    })

    public MobileElement articleLayoutName;

    @AndroidFindAll({
            @AndroidBy(xpath = "//android.widget.TextView[contains(@resource-id,'bbc.mobile.news.uk.internal:id/item_layout_last_updated') and @index='0']"),
            @AndroidBy(xpath = "//android.widget.TextView[contains(@resource-id,'bbc.mobile.news.uk:id/item_layout_last_updated') and @index='0']")
    })

    public MobileElement articleLastUpdated;

    @AndroidFindAll({
            @AndroidBy(xpath = "//android.widget.TextView[contains(@resource-id,'bbc.mobile.news.uk.internal:id/item_layout_home_section') and @index='0']"),
            @AndroidBy(xpath = "//android.widget.TextView[contains(@resource-id,'bbc.mobile.news.uk:id/item_layout_home_section') and @index='0']")
    })

    public MobileElement articleHomeSection;

    public String[] articleDetailPageLinks = {
            "bbc.mobile.news.uk.internal:id/image_item_caption",
            "bbc.mobile.news.uk.internal:id/headline_title",
            "bbc.mobile.news.uk.internal:id/headline_info",
            "bbc.mobile.news.uk.internal:id/headline_link"
    };

    public String[] articleDetailPageLinksRelease = {
            "bbc.mobile.news.uk:id/image_item_caption",
            "bbc.mobile.news.uk:id/headline_title",
            "bbc.mobile.news.uk:id/headline_info",
            "bbc.mobile.news.uk:id/headline_link"
    };

    public String[] articleItemWithImageBadge = {
            "Hundreds of people poured onto the streets demanding justice for the girl",
            "How India viral messages helped catch rape suspect",
            "10 Jul 2018",
            "India"
    };

    public String[] articleItemWithoutImageBadge = {
            "Bishop Franco Mulakkal denies wrongoing",
            "India bishop accused of rape arrested in Kerala",
            "21 Sep 2018",
            "India"
    };

    public String[] articlePageDetail = {
            "India man held for rape of British woman in Goa",
            "21 Dec 2018",
            "India"
    };

    public String[] articlePageDetailElements = {
            "bbc.mobile.news.uk.internal:id/headline_title",
            "bbc.mobile.news.uk.internal:id/headline_info",
            "bbc.mobile.news.uk.internal:id/headline_link"
    };

    public String[] articlePageDetailElementsRelease = {
            "bbc.mobile.news.uk:id/headline_title",
            "bbc.mobile.news.uk:id/headline_info",
            "bbc.mobile.news.uk:id/headline_link"
    };

    @AndroidFindAll({
            @AndroidBy(id = "bbc.mobile.news.uk.internal:id/image_item_badge"),
            @AndroidBy(id = "bbc.mobile.news.uk:id/image_item_badge")
    })
    public MobileElement articleImageBadge;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Related stories']")
    public MobileElement relatedStories;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Related topics']")
    public MobileElement relatedTopics;

    @AndroidFindAll({
            @AndroidBy(id = "bbc.mobile.news.uk.internal:id/smp_error_message"),
            @AndroidBy(id = "bbc.mobile.news.uk:id/smp_error_message")
    })
    public MobileElement smpErrorMessage;

    @AndroidFindAll({
            @AndroidBy(id = "bbc.mobile.news.uk.internal:id/smp_error_button"),
            @AndroidBy(id = "bbc.mobile.news.uk:id/smp_error_button")
    })
    public MobileElement smpErrorOkButton;

    @AndroidFindAll({
            @AndroidBy(id = "bbc.mobile.news.uk.internal:id/smp_retry_button"),
            @AndroidBy(id = "bbc.mobile.news.uk:id/smp_retry_button")
    })
    public MobileElement smpRetryButton;

    @AndroidFindAll({
            @AndroidBy(id = "bbc.mobile.news.uk.internal:id/error_retry"),
            @AndroidBy(id = "bbc.mobile.news.uk:id/error_retry")
    })
    public MobileElement errorRetryButton;

    @AndroidFindBy(xpath = "//android.widget.ListView[@index='0']")
    public MobileElement appInfoListView;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='App info']")
    public MobileElement menuAppInfo;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Terms of use']")
    public MobileElement termsConditions;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Privacy policy']")
    public MobileElement privacyPolicy;

    @FindBy(xpath = "//*[contains(text(), 'A few rules for us and you')]")
    public WebElement termsOfUseText;

    @FindBy(xpath = "//*[contains(text(), 'Keeping your info safe & sound')]")
    public WebElement privacyPolicyText;

    @FindBy(xpath = "//*[contains(text(), 'Your Information & Privacy')]")
    public WebElement getPrivacyPolicyText;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Internal Settings']")
    public MobileElement internalSettings;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='CPS Content']")
    public MobileElement cpsContent;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Trevor TEST (Direct)' and @index='4']")
    public MobileElement trevorTest;

    @AndroidFindBy(id = "bbc.mobile.news.uk.internal:id/snackbar_action")
    @AndroidFindAll({
            @AndroidBy(id = "bbc.mobile.news.uk.internal:id/snackbar_action"),
            @AndroidBy(id = "bbc.mobile.news.uk:id/snackbar_action")
    })
    public MobileElement reloadButton;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Settings']")
    public MobileElement menuSettings;

}
