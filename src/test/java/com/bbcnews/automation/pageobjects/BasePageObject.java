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


    @AndroidFindBy(id="android:id/button1")
    public MobileElement okbutton;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='GO TO SETTINGS']")
    public MobileElement settingsButton;

    @AndroidFindBy(accessibility = "Back")
    public MobileElement backButton;


    @AndroidFindBy(id="android:id/button2")
    public MobileElement nothanksbutton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Top Stories']")
    public MobileElement topstories;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='My News']")
    public MobileElement mynews;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Popular']")
    public MobileElement popular;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Video']")
    public MobileElement video;

    @AndroidFindBy(accessibility = "Search")
    public MobileElement searchbutton;

    @AndroidFindBy(accessibility = "Share story")
    public MobileElement sharestory;


    @AndroidFindAll(
            {
                    @AndroidBy(id = "bbc.mobile.news.uk.internal:id/action_search"),
                    @AndroidBy(id = "bbc.mobile.news.uk:id/action_search"),
                    @AndroidBy(accessibility = "Search")
            }
    )
    public MobileElement search;

    public String[] topicspageelemnets =
            {
                    "bbc.mobile.news.uk.internal:id/item_image",
                    "bbc.mobile.news.uk.internal:id/item_layout_name",
                    "bbc.mobile.news.uk.internal:id/item_layout_last_updated",
                    "bbc.mobile.news.uk.internal:id/item_layout_home_section"
            };

    public String[] topicspageelemnets_Release =
            {
                    "bbc.mobile.news.uk:id/item_image",
                    "bbc.mobile.news.uk:id/item_layout_name",
                    "bbc.mobile.news.uk:id/item_layout_last_updated",
                    "bbc.mobile.news.uk:id/item_layout_home_section"
            };

   // @AndroidFindBy(id = "bbc.mobile.news.uk.internal:id/item_layout_name")
    @AndroidFindAll(
            {
                    @AndroidBy(id="bbc.mobile.news.uk.internal:id/item_layout_name"),
                    @AndroidBy(id="bbc.mobile.news.uk:id/item_layout_name")
            }
    )
    public MobileElement item_layout_name;

   // @AndroidFindBy(id = "bbc.mobile.news.uk.internal:id/item_layout_last_updated")
    @AndroidFindAll(
            {
                    @AndroidBy(id="bbc.mobile.news.uk.internal:id/item_layout_last_updated"),
                    @AndroidBy(id="bbc.mobile.news.uk:id/item_layout_last_updated")
            }
    )
    public MobileElement item_layout_last_updated;


    @AndroidFindAll(
            {
                    @AndroidBy(id="bbc.mobile.news.uk.internal:id/item_layout_home_section"),
                    @AndroidBy(id="bbc.mobile.news.uk:id/item_layout_home_section")
            }
    )
    public MobileElement item_layout_home_section;

    @AndroidFindBy(accessibility = "Show navigation menu drawer")
    public MobileElement menubutton;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Settings']")
    public MobileElement settings;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='App info']")
    public MobileElement Appinfo;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Other BBC apps']")
    public MobileElement OtherBBCapps;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Internal Settings']")
    public MobileElement InternalSettings;

    public String menuoptions[] = {"//android.widget.CheckedTextView[@text='Settings']",
            "//android.widget.CheckedTextView[@text='App info']",
            "//android.widget.CheckedTextView[@text='Other BBC apps']",
            "//android.widget.CheckedTextView[@text='Internal Settings']"};

    @AndroidFindAll(
            {
                    @AndroidBy(id="bbc.mobile.news.uk.internal:id/search"),
                    @AndroidBy(id="bbc.mobile.news.uk:id/search")
            }
    )
    public MobileElement searchfield;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Brexit' and @index='0']")
    public MobileElement searchkeyword;


    @AndroidFindAll(
            {
                    @AndroidBy(id = "bbc.mobile.news.uk.internal:id/title"),
                    @AndroidBy(id = "bbc.mobile.news.uk:id/title")
            }
    )
    public MobileElement headlinetitle;


    @AndroidFindAll(
            {
                    @AndroidBy(xpath = "//android.widget.TextView[contains(@resource-id,'bbc.mobile.news.uk.internal:id/heading') and @index='0']"),
                    @AndroidBy(xpath = "//android.widget.TextView[contains(@resource-id,'bbc.mobile.news.uk:id/heading') and @index='0']")
            }
    )
    public MobileElement searchheading;


   @AndroidFindAll(
           {
                   @AndroidBy(xpath = "//android.widget.TextView[@resource-id='bbc.mobile.news.uk.internal:id/heading' and @index='2']"),
                   @AndroidBy(xpath = "//android.widget.TextView[@resource-id='bbc.mobile.news.uk:id/heading' and @index='2']")
           }
   )
    public MobileElement searchheading2;


    @AndroidFindAll(
            {
                    @AndroidBy(xpath = "//android.widget.TextView[@resource-id='bbc.mobile.news.uk.internal:id/heading' and @index='4']"),
                    @AndroidBy(xpath = "//android.widget.TextView[@resource-id='bbc.mobile.news.uk:id/heading' and @index='4']")
            }
    )
    public MobileElement searchheading4;


    @AndroidFindAll(
            {
                    @AndroidBy(xpath = "//bbc.mobile.news.uk.internal:id/chip_item[@index='1']"),
                    @AndroidBy(xpath = "//bbc.mobile.news.uk:id/chip_item[@index='1']")
            }
    )
    public MobileElement searchsuggest1;


    public static String searchsuggest1_text = "India";


    @AndroidFindAll(
            {
                    @AndroidBy(xpath = "//bbc.mobile.news.uk.internal:id/chip_item[@index='2']"),
                    @AndroidBy(xpath = "//bbc.mobile.news.uk:id/chip_item[@index='2']")
            }
    )
    public MobileElement searchsuggest2;


    public static String searchsuggest2_text = "India-Pakistan independence";


    @AndroidFindAll(
            {
                    @AndroidBy(xpath = "//bbc.mobile.news.uk.internal:id/chip_item[@index='3']"),
                    @AndroidBy(xpath = "//bbc.mobile.news.uk.internal:id/chip_item[@index='3']")
            }
    )
    public MobileElement searchsuggest3;


    public static String searchsuggest3_text = "Rape in India";

    @AndroidFindBy(accessibility = "Cancel search")
    public MobileElement cancelSearch;

    public  String SubDirectory = "Screenshots";

    public  String ScreenshotPaths;

    public  String searchtext = "Brexit";


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='UK Politics added to My News']")
    public MobileElement alert_text;


    @AndroidFindBy(xpath = "//android.widget.Button[@text='UNDO' and @index='1']")
    public MobileElement undo_button;

    public String alert_text_uk = "UK Politics added to My News";

    public String alert_text_business = "Business added to My News";

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Rape in India']")
    public MobileElement article;



    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='3']/android.view.ViewGroup[@index='0']/android.widget.ImageView[@index='0']")
    public MobileElement articlesearch;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='How social media helped catch rape suspect' and @index='1']")
    public MobileElement artictleitem_withitembadge;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='India bishop accused of rape arrested' and @index='1']")
    public MobileElement artictleitem_withoutitembadge;

    @AndroidFindBy(xpath="//android.widget.FrameLayout[6]/bbc.mobile.news.uk.internal:id/main_view[0]/android.widget.ImageView[@index='0']")
    public  MobileElement articleitem_image;



    @AndroidFindAll(
            {
                    @AndroidBy(xpath = "//android.widget.TextView[contains(@resource-id,'bbc.mobile.news.uk.internal:id/item_layout_name') and @index='0']"),
                    @AndroidBy(xpath = "//android.widget.TextView[contains(@resource-id,'bbc.mobile.news.uk:id/item_layout_name') and @index='0']")
            }
    )
    public MobileElement articlelayout_name;



    @AndroidFindAll(
            {
                    @AndroidBy(xpath = "//android.widget.TextView[contains(@resource-id,'bbc.mobile.news.uk.internal:id/item_layout_last_updated') and @index='0']"),
                    @AndroidBy(xpath = "//android.widget.TextView[contains(@resource-id,'bbc.mobile.news.uk:id/item_layout_last_updated') and @index='0']")
            }
    )
    public MobileElement articlellast_updated;



    @AndroidFindAll(
            {
                    @AndroidBy(xpath="//android.widget.TextView[contains(@resource-id,'bbc.mobile.news.uk.internal:id/item_layout_home_section') and @index='0']"),
                    @AndroidBy(xpath="//android.widget.TextView[contains(@resource-id,'bbc.mobile.news.uk:id/item_layout_home_section') and @index='0']")
            }
    )
    public MobileElement articlelhome_section;




    public String articledetailpagelinks[] =
            {
                    "bbc.mobile.news.uk.internal:id/image_item_caption",
                    "bbc.mobile.news.uk.internal:id/headline_title",
                    "bbc.mobile.news.uk.internal:id/headline_info",
                    "bbc.mobile.news.uk.internal:id/headline_link"};

    public String articledetailpagelinks_Release[] =
            {
                    "bbc.mobile.news.uk:id/image_item_caption",
                    "bbc.mobile.news.uk:id/headline_title",
                    "bbc.mobile.news.uk:id/headline_info",
                    "bbc.mobile.news.uk:id/headline_link"
            };


    public String articleitemwithimagebadge [] =
            {

                    "Hundreds of people poured onto the streets demanding justice for the girl",
                    "How India viral messages helped catch rape suspect",
                    "10 Jul 2018",
                    "India"
            };

    public String articleitemwithoutimagebadge [] =
            {
                    "Bishop Franco Mulakkal denies wrongoing",
                    "India bishop accused of rape arrested in Kerala",
                    "21 Sep 2018",
                    "India"
            };

    public String articlepagedetail [] =
            {
                    "India man held for rape of British woman in Goa",
                    "21 Dec 2018",
                    "India"
            };

    public String articlepagedetailelements[] =
            {       "bbc.mobile.news.uk.internal:id/headline_title",
                    "bbc.mobile.news.uk.internal:id/headline_info",
                    "bbc.mobile.news.uk.internal:id/headline_link"
            };

    public String articlepagedetailelements_Release[] =
            {       "bbc.mobile.news.uk:id/headline_title",
                    "bbc.mobile.news.uk:id/headline_info",
                    "bbc.mobile.news.uk:id/headline_link"
            };




    @AndroidFindAll(
            {
                    @AndroidBy(id = "bbc.mobile.news.uk.internal:id/image_item_badge"),
                    @AndroidBy(id = "bbc.mobile.news.uk:id/image_item_badge")
            }
    )
    public MobileElement article_imagebade;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='Related stories']")
    public MobileElement relatedstories;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='Related topics']")
    public MobileElement relatedtopics;


    @AndroidFindAll(
            {
                    @AndroidBy(id="bbc.mobile.news.uk.internal:id/smp_error_message"),
                    @AndroidBy(id="bbc.mobile.news.uk:id/smp_error_message")
            }
    )
    public MobileElement smperrormessage;


   @AndroidFindAll(
           {
                   @AndroidBy(id="bbc.mobile.news.uk.internal:id/smp_error_button"),
                   @AndroidBy(id="bbc.mobile.news.uk:id/smp_error_button")
           }
   )
   public MobileElement smperrorokbutton;


    @AndroidFindAll(
            {
                    @AndroidBy(id="bbc.mobile.news.uk.internal:id/smp_retry_button"),
                    @AndroidBy(id="bbc.mobile.news.uk:id/smp_retry_button")
            }
    )
    public MobileElement smpretrybuton;

    @AndroidFindAll(
            {
                    @AndroidBy(id= "bbc.mobile.news.uk.internal:id/error_retry"),
                    @AndroidBy(id= "bbc.mobile.news.uk:id/error_retry")
            }
    )
    public MobileElement errorRetryButton;


    @AndroidFindBy(xpath="//android.widget.ListView[@index='0']")
    public MobileElement appinfolistview;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='App info']")
    public MobileElement menuappinfo;



    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Terms of use']")
    public MobileElement termsconditions;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Privacy policy']")
    public MobileElement privacypolicy;

    @FindBy(xpath="//*[contains(text(), 'A few rules for us and you')]")
    public WebElement termofustext;

    @FindBy(xpath="//*[contains(text(), 'Keeping your info safe & sound')]")
    public WebElement privacypolicytext;

    @FindBy(xpath="//*[contains(text(), 'Your Information & Privacy')]")
    public WebElement getPrivacypolicytext;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Internal Settings']")
    public MobileElement internalsettings;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='CPS Content']")
    public MobileElement cpscontent;

    @AndroidFindBy(xpath="//android.widget.CheckedTextView[@text='Trevor TEST (Direct)' and @index='4']")
    public MobileElement trevortest;


    @AndroidFindBy(id="bbc.mobile.news.uk.internal:id/snackbar_action")
    @AndroidFindAll(
            {
                    @AndroidBy(id="bbc.mobile.news.uk.internal:id/snackbar_action"),
                    @AndroidBy(id="bbc.mobile.news.uk:id/snackbar_action")
            }
    )
    public MobileElement reloadButton;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Settings']")
    public MobileElement menusettings;








}
