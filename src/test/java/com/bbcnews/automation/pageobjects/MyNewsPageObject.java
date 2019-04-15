package com.bbcnews.automation.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MyNewsPageObject {

    public MyNewsPageObject()
    {

    }


    @AndroidFindAll(
            {
                    @AndroidBy(id = "bbc.mobile.news.uk.internal:id/title"),
                    @AndroidBy(id = "bbc.mobile.news.uk:id/title")
            }
    )
    public MobileElement mynewstitle;

    @AndroidFindBy(accessibility = "OK, let's get started Button:")
    public MobileElement mynews_startButton;


    @AndroidFindAll(
            {
                    @AndroidBy(id = "bbc.mobile.news.uk.internal:id/summary"),
                    @AndroidBy(id = "bbc.mobile.news.uk:id/summary")
            }
    )
    public MobileElement mynews_summary;


    @AndroidFindAll(
            {
                    @AndroidBy(id = "bbc.mobile.news.uk.internal:id/icon"),
                    @AndroidBy(id = "bbc.mobile.news.uk:id/icon")
            }
    )
    public MobileElement addnews_button;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='My Topics']")
    public MobileElement mytopics;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Add Topics']")
    public MobileElement addtopics;

    @AndroidFindBy(accessibility = "Topic heading,Local news")
    public MobileElement localnews;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Allow location']")
    public MobileElement allow_location;

    @AndroidFindBy(id="com.android.packageinstaller:id/permission_allow_button")
    public MobileElement allowlocation_premission;

    @AndroidFindBy(id="com.android.packageinstaller:id/permission_deny_button")
    public MobileElement allowlocation_permission_deny;

    @AndroidFindAll(
            {
                    @AndroidBy(id = "bbc.mobile.news.uk.internal:id/request_permission"),
                    @AndroidBy(id = "bbc.mobile.news.uk:id/request_permission")
            }
    )
    public MobileElement location_button;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Edit My News']")
    public MobileElement editMyTopics;

    @AndroidFindAll(
            {
                    @AndroidBy(id="bbc.mobile.news.uk.internal:id/emptyTextView"),
                    @AndroidBy(id="bbc.mobile.news.uk:id/emptyTextView")
            }
    )
    public MobileElement mytopic_emptyview;



    public  String mynewstitle_text="Add Topics to create your own personal news feed";

    public  String mynewssummary_text="All the latest stories from your topics will appear here.";

    public  String mytopic_emptyview_text="Your added topics will be displayed here";

    @AndroidFindBy(accessibility = "Add topic")
    public  MobileElement mynews_addtopics;

    @AndroidFindBy(accessibility="Edit My News")
    public MobileElement editMyNews;

    @AndroidFindBy(accessibility = "Remove topic")
    public MobileElement removetopics;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Manchester']")
    public MobileElement localnews_displayed;

    @AndroidFindBy(xpath = "//android.support.v7.widget.RecyclerView[@index='3']")
    public MobileElement mynewsrecyclerview;

    @AndroidFindBy(accessibility = "Audio and Video")
    public MobileElement asiavideoaudiosection;

    public String articlepageelements[] =
            {       //"bbc.mobile.news.uk.internal:id/image_item_badge",
                    "bbc.mobile.news.uk.internal:id/headline_info",
                    "bbc.mobile.news.uk.internal:id/headline_title",
                    "bbc.mobile.news.uk.internal:id/image_item",
                    "bbc.mobile.news.uk.internal:id/headline_link",
            };

    public String articlepageelements_Release[] =
            {       //"bbc.mobile.news.uk:id/image_item_badge",
                    "bbc.mobile.news.uk:id/headline_info",
                    "bbc.mobile.news.uk:id/headline_title",
                    "bbc.mobile.news.uk:id/image_item",
                    "bbc.mobile.news.uk:id/headline_link",
            };



    public String articlepageview[] =
            {       "bbc.mobile.news.uk.internal:id/itemLayoutName",
                    "bbc.mobile.news.uk.internal:id/itemLayoutLastUpdated",
                    "bbc.mobile.news.uk.internal:id/itemLayoutHomeSection"
            };


    public String articlepageview_Release[] =
            {       "bbc.mobile.news.uk:id/itemLayoutName",
                    "bbc.mobile.news.uk:id/itemLayoutLastUpdated",
                    "bbc.mobile.news.uk:id/itemLayoutHomeSection"
            };

    @AndroidFindBy(accessibility = "Manage your topics")
    public MobileElement manageyourtopics;

    @AndroidFindBy(xpath="//bbc.mobile.news.uk.internal:id/recyclerview[@index='1']/android.widget.RelativeLayout[@index='4']/android.widget.ImageView[@index='0']")
    public MobileElement removetopiccymru;


    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='2']")
    //android.widget.RelativeLayout[@index='0']/android.widget.ImageView[@index='0']")
    public MobileElement topicarticle;


    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='1']/android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='1']")
    public MobileElement item_layout_name;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='1']/android.widget.RelativeLayout[@index='0']/android.widget.LinearLayout[@index='2']/android.widget.LinearLayout[@index='0']/android.widget.TextView[@index='0']")
    public MobileElement item_layout_last_updated;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='1']/android.widget.RelativeLayout[@index='0']/android.widget.LinearLayout[@index='2']/android.widget.LinearLayout[@index='0']/android.widget.TextView[@index='2']")
    public MobileElement item_layout_home_section;

    @AndroidFindBy(xpath = "//android.support.v7.widget.RecyclerView[@index='3']/android.widget.FrameLayout[@index='2']/android.widget.RelativeLayout[@index='0']/android.widget.ImageView[@index='0']")
    public MobileElement topicvideoarticle;

    @AndroidFindBy(xpath = "//android.support.v7.widget.RecyclerView[@index='3']/android.widget.FrameLayout[@index='0']/android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='1']")
    public MobileElement videoitem_layout_primary_time;

    @AndroidFindBy(xpath = "//android.support.v7.widget.RecyclerView[@index='3']/android.widget.FrameLayout[@index='0']/android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='2']")
    public MobileElement videoitem_layout_name;

    @AndroidFindBy(xpath = "//android.support.v7.widget.RecyclerView[@index='3']/android.widget.FrameLayout[@index='0']/android.widget.RelativeLayout[@index='0']/android.widget.LinearLayout[@index='3']/android.widget.LinearLayout[@index='0']/android.widget.TextView[@index='0']")
    public MobileElement videoitem_layout_last_updated;

    @AndroidFindBy(xpath = "//android.support.v7.widget.RecyclerView[@index='3']/android.widget.FrameLayout[@index='0']/android.widget.RelativeLayout[@index='0']/android.widget.LinearLayout[@index='3']/android.widget.LinearLayout[@index='0']/android.widget.TextView[@index='2']")
    public MobileElement videoitem_layout_home_section;


    @AndroidFindAll(
            {
                    @AndroidBy(id = "bbc.mobile.news.uk.internal:id/snackbar_text"),
                    @AndroidBy(id = "bbc.mobile.news.uk:id/snackbar_text")
            }
    )
    public  MobileElement snackbar;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='OK, got it']")
    public MobileElement okgotit;

    @AndroidFindBy(xpath="//android.widget.TextView[@tex'More']")
    public MobileElement morebutton;


    @AndroidFindAll(
            {
                  @AndroidBy(xpath="//android.widget.TextView[contains(@resource-id,'bbc.mobile.news.uk.internal:id/item_layout_header_title') and @text='Wales']"),
                  @AndroidBy(xpath="//android.widget.TextView[contains(@resource-id,'bbc.mobile.news.uk:id/item_layout_header_title') and @text='Wales']")
            }
    )
    public MobileElement topictitle;

 @AndroidFindAll(
         {
                 @AndroidBy(id ="bbc.mobile.news.uk.internal:id/showmore_title"),
                 @AndroidBy(id ="bbc.mobile.news.uk:id/showmore_title")
         }
 )

 public MobileElement showmore;


 @AndroidFindBy(xpath = "//android.widget.TextView[@text='Less']")
 public MobileElement showless;



}

