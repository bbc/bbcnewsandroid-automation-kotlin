package com.bbcnews.automation.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class VideoPageObjects {

    public VideoPageObjects() {

    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Video']")
    public MobileElement video;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='BBC News Channel']")
    public MobileElement bbcNewsChannel;

    @AndroidFindAll({
            @AndroidBy(id = "bbc.mobile.news.uk.internal:id/content_card_title"),
            @AndroidBy(id = "bbc.mobile.news.uk:id/content_card_title")
    })
    public MobileElement liveBbcChannel;

    @AndroidFindAll({
            @AndroidBy(id = "bbc.mobile.news.uk.internal:id/media_item_caption"),
            @AndroidBy(id = "bbc.mobile.news.uk:id/media_item_caption")
    })
    public MobileElement liveMediaItemCaption;

    @AndroidFindBy(accessibility = "Play")
    public MobileElement smpPlaceholderPlayButton;

    @AndroidFindBy(accessibility = "Pause")
    public MobileElement smpPlaceholderPauseButton;

    @AndroidFindAll({
            @AndroidBy(id = "bbc.mobile.news.uk.internal:id/smp_pause_button"),
            @AndroidBy(id = "bbc.mobile.news.uk:id/smp_pause_button")
    })
    public MobileElement smpPauseButton;

    @AndroidFindBy(accessibility = "volume")
    public MobileElement smpVolumeButton;

    @AndroidFindBy(accessibility = "Fullscreen")
    public MobileElement smpFullScreenButton;

    @AndroidFindBy(accessibility = "exit fullscreen")
    public MobileElement smpExitFullScreenButton;

    @AndroidFindAll({
            @AndroidBy(id = "bbc.mobile.news.uk.internal:id/smp_seek_bar"),
            @AndroidBy(id = "bbc.mobile.news.uk:id/smp_seek_bar")
    })
    public MobileElement smpSeekBar;

    @AndroidFindAll({
            @AndroidBy(id = "bbc.mobile.news.uk.internal:id/smp_live_icon"),
            @AndroidBy(accessibility = "live content")
    })
    public MobileElement smpLiveIcon;

    @AndroidFindAll({
            @AndroidBy(id = "bbc.mobile.news.uk.internal:id/smp_playout_window_inset"),
            @AndroidBy(id = "bbc.mobile.news.uk:id/smp_playout_window_inset")
    })
    public MobileElement transportControls;

    @AndroidFindAll({
            @AndroidBy(id = "bbc.mobile.news.uk.internal:id/smp_play_button"),
            @AndroidBy(id = "bbc.mobile.news.uk:id/smp_play_button")
    })
    public MobileElement playButton;

    public String[] videosOfTheDay = {
            "bbc.mobile.news.uk.internal:id/newstream_duration",
            "bbc.mobile.news.uk.internal:id/newstream_title",
            "bbc.mobile.news.uk.internal:id/newstream_summary"
    };

    public String[] videosOfTheDayRelease = {
            "bbc.mobile.news.uk.internal:id/newstream_duration",
            "bbc.mobile.news.uk.internal:id/newstream_title",
            "bbc.mobile.news.uk.internal:id/newstream_summary",
            "bbc.mobile.news.uk:id/teaser_media_info_icon"
    };

    @AndroidFindBy(accessibility = "play video content")
    public MobileElement videoOfTheDayPlay;

    @AndroidFindAll({
            @AndroidBy(id = "bbc.mobile.news.uk.internal:id/newstream_duration"),
            @AndroidBy(id = "bbc.mobile.news.uk:id/newstream_duration")
    })
    public MobileElement videoOfTheDayDuration;

    @AndroidFindAll({
            @AndroidBy(id = "bbc.mobile.news.uk.internal:id/newstream_title"),
            @AndroidBy(id = "bbc.mobile.news.uk:id/newstream_title")
    })
    public MobileElement videoOfTheDayTitle;

    @AndroidFindAll({
            @AndroidBy(id = "bbc.mobile.news.uk.internal:id/newstream_summary"),
            @AndroidBy(id = "bbc.mobile.news.uk:id/newstream_summary")
    })
    public MobileElement videoOfTheDaySummary;

    public String[] videoDetailPage = {
            "bbc.mobile.news.uk.internal:id/media_item_caption",
            "bbc.mobile.news.uk.internal:id/headline_title",
            "bbc.mobile.news.uk.internal:id/headline_info",
            "bbc.mobile.news.uk.internal:id/headline_link"
    };

    public String[] videoDetailPageText = {
            "In Egypt, fake news becomes weapon of choice to crush dissent",
            "Amal Fathy: Egypt court imposes jail term over harassment video",
            "31 Dec 2018",
            "Middle East"
    };

    public String[] videoDetailPageRelease = {
            "bbc.mobile.news.uk:id/media_item_caption",
            "bbc.mobile.news.uk:id/headline_title",
            "bbc.mobile.news.uk:id/headline_info",
            "bbc.mobile.news.uk:id/headline_link"
    };

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Amal Fathy: Egypt court imposes jail term over harassment video' and @index='1']")
    public MobileElement videoArticleSearch;

    public String[] playbackControls = {
            "bbc.mobile.news.uk.internal:id/smp_pause_button",
            "bbc.mobile.news.uk.internal:id/smp_seek_bar",
            "bbc.mobile.news.uk.internal:id/smp_fullscreen_button",
            "bbc.mobile.news.uk.internal:id/smp_duration",
            "bbc.mobile.news.uk.internal:id/smp_elapsed"
    };

    public String[] playbackControlsRelease = {
            "bbc.mobile.news.uk:id/smp_pause_button",
            "bbc.mobile.news.uk:id/smp_seek_bar",
            "bbc.mobile.news.uk:id/smp_fullscreen_button",
            "bbc.mobile.news.uk:id/smp_duration",
            "bbc.mobile.news.uk:id/smp_elapsed"
    };

    public String[] videoWallElements = {
            "bbc.mobile.news.uk.internal:id/smp_placeholder_play_button",
            // "bbc.mobile.news.uk.internal:id/videoTitleHeadline",
            "bbc.mobile.news.uk.internal:id/videoTitleTimestamp",
            "bbc.mobile.news.uk.internal:id/videoTitleTopic",
            "bbc.mobile.news.uk.internal:id/videoSummary"
    };

    public String[] videoWallElementsRelease = {
            "bbc.mobile.news.uk:id/smp_placeholder_play_button",
            // "bbc.mobile.news.uk.internal:id/videoTitleHeadline",
            "bbc.mobile.news.uk:id/videoTitleTimestamp",
            "bbc.mobile.news.uk:id/videoTitleTopic",
            "bbc.mobile.news.uk:id/videoSummary"
    };

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Top Stories']")
    public MobileElement topStories;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='3']")
    public MobileElement topStoriesVideo;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='1']/android.view.ViewGroup[@index='0']/android.widget.LinearLayout[@index='1']/android.widget.TextView[@index='1']")
    public MobileElement topStoriesVideoPlayTime;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='1']/android.view.ViewGroup[@index='0']/android.widget.TextView[@index='2']")
    public MobileElement topStoriesVideoContentCardTitle;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='1']/android.view.ViewGroup[@index='0']/android.widget.TextView[@index='3']")
    public MobileElement topStoriesVideoContentCardInfo;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='1']/android.view.ViewGroup[@index='0']/android.widget.TextView[@index='4']")
    public MobileElement topStoriesVideoContentCardLink;

    @AndroidFindAll({
            @AndroidBy(id = "bbc.mobile.news.uk.internal:id/smp_elapsed"),
            @AndroidBy(id = "bbc.mobile.news.uk:id/smp_elapsed")
    })
    public MobileElement smpElapsedTime;

    public String elapsedTimeForward;

    public String elapsedTimeBackward;
}
