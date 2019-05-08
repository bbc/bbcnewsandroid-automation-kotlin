package com.bbcnews.automation.pageobjects

import io.appium.java_client.MobileElement
import io.appium.java_client.pagefactory.AndroidBy
import io.appium.java_client.pagefactory.AndroidFindAll
import io.appium.java_client.pagefactory.AndroidFindBy

object VideoPageObjects {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Video']")
    val video: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='BBC News Channel']")
    val bbcNewsChannel: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/content_card_title"), AndroidBy(id = "bbc.mobile.news.uk:id/content_card_title"))
    val liveBbcChannel: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/media_item_caption"), AndroidBy(id = "bbc.mobile.news.uk:id/media_item_caption"))
    val liveMediaItemCaption: MobileElement? = null

    @AndroidFindBy(accessibility = "Play button")
    val accessibilityPlay: MobileElement? = null

    @AndroidFindBy(accessibility = "Pause button")
    val accessibilityPause: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/smp_pause_button"), AndroidBy(id = "bbc.mobile.news.uk:id/smp_pause_button"))
    val smpPauseButton: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/smp_play_pause_container"))
    val smpPlayPauseButton: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk:id/smp_placeholder_play_button"), AndroidBy(accessibility = "Play"))
    val smpPlaceholderPlayButton: MobileElement? = null

    @AndroidFindBy(accessibility = "volume")
    val smpVolumeButton: MobileElement? = null

    @AndroidFindBy(accessibility = "Fullscreen")
    val smpFullScreenButton: MobileElement? = null

    @AndroidFindBy(accessibility = "exit fullscreen")
    val smpExitFullScreenButton: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/smp_seek_bar"), AndroidBy(id = "bbc.mobile.news.uk:id/smp_seek_bar"))
    val smpSeekBar: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/smp_live_icon"), AndroidBy(accessibility = "live content"))
    val smpLiveIcon: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/smp_playout_window_inset"), AndroidBy(id = "bbc.mobile.news.uk:id/smp_playout_window_inset"))
    val transportControls: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/smp_play_button"), AndroidBy(id = "bbc.mobile.news.uk:id/smp_play_button"))
    val playButton: MobileElement? = null

    val videosOfTheDay = arrayOf("bbc.mobile.news.uk.internal:id/newstream_duration", "bbc.mobile.news.uk.internal:id/newstream_title", "bbc.mobile.news.uk.internal:id/newstream_summary")

    val videosOfTheDayRelease = arrayOf("bbc.mobile.news.uk.internal:id/newstream_duration", "bbc.mobile.news.uk.internal:id/newstream_title", "bbc.mobile.news.uk.internal:id/newstream_summary", "bbc.mobile.news.uk:id/teaser_media_info_icon")

    @AndroidFindBy(accessibility = "play video content")
    val videoOfTheDayPlay: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/newstream_duration"), AndroidBy(id = "bbc.mobile.news.uk:id/newstream_duration"))
    val videoOfTheDayDuration: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/newstream_title"), AndroidBy(id = "bbc.mobile.news.uk:id/newstream_title"))
    val videoOfTheDayTitle: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/newstream_summary"), AndroidBy(id = "bbc.mobile.news.uk:id/newstream_summary"))
    val videoOfTheDaySummary: MobileElement? = null

    val videoDetailPage = arrayOf("bbc.mobile.news.uk.internal:id/media_item_caption", "bbc.mobile.news.uk.internal:id/headline_title", "bbc.mobile.news.uk.internal:id/headline_info", "bbc.mobile.news.uk.internal:id/headline_link")

    val videoDetailPageText = arrayOf("In Egypt, fake news becomes weapon of choice to crush dissent", "Amal Fathy: Egypt court imposes jail term over harassment video", "31 Dec 2018", "Middle East")

    val videoDetailPageRelease = arrayOf("bbc.mobile.news.uk:id/media_item_caption", "bbc.mobile.news.uk:id/headline_title", "bbc.mobile.news.uk:id/headline_info", "bbc.mobile.news.uk:id/headline_link")

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Amal Fathy: Egypt court imposes jail term over harassment video' and @index='1']")
    val videoArticleSearch: MobileElement? = null

    val playbackControls = arrayOf("bbc.mobile.news.uk.internal:id/smp_pause_button", "bbc.mobile.news.uk.internal:id/smp_seek_bar", "bbc.mobile.news.uk.internal:id/smp_fullscreen_button", "bbc.mobile.news.uk.internal:id/smp_duration", "bbc.mobile.news.uk.internal:id/smp_elapsed")

    val playbackControlsRelease = arrayOf("bbc.mobile.news.uk:id/smp_pause_button", "bbc.mobile.news.uk:id/smp_seek_bar", "bbc.mobile.news.uk:id/smp_fullscreen_button", "bbc.mobile.news.uk:id/smp_duration", "bbc.mobile.news.uk:id/smp_elapsed")

    val videoWallElements = arrayOf("bbc.mobile.news.uk.internal:id/smp_placeholder_play_button",
            // "bbc.mobile.news.uk.internal:id/videoTitleHeadline",
            "bbc.mobile.news.uk.internal:id/videoTitleTimestamp", "bbc.mobile.news.uk.internal:id/videoTitleTopic", "bbc.mobile.news.uk.internal:id/videoSummary")

    val videoWallElementsRelease = arrayOf("bbc.mobile.news.uk:id/smp_placeholder_play_button",
            // "bbc.mobile.news.uk.internal:id/videoTitleHeadline",
            "bbc.mobile.news.uk:id/videoTitleTimestamp", "bbc.mobile.news.uk:id/videoTitleTopic", "bbc.mobile.news.uk:id/videoSummary")

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Top Stories']")
    val topStories: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='3']")
    val topStoriesVideo: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='1']/android.view.ViewGroup[@index='0']/android.widget.LinearLayout[@index='1']/android.widget.TextView[@index='1']")
    val topStoriesVideoPlayTime: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='1']/android.view.ViewGroup[@index='0']/android.widget.TextView[@index='2']")
    val topStoriesVideoContentCardTitle: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='1']/android.view.ViewGroup[@index='0']/android.widget.TextView[@index='3']")
    val topStoriesVideoContentCardInfo: MobileElement? = null

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='1']/android.view.ViewGroup[@index='0']/android.widget.TextView[@index='4']")
    val topStoriesVideoContentCardLink: MobileElement? = null

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/smp_elapsed"), AndroidBy(id = "bbc.mobile.news.uk:id/smp_elapsed"))
    val smpElapsedTime: MobileElement? = null

    var elapsedTimeForward: String? = null

    var elapsedTimeBackward: String? = null
}
