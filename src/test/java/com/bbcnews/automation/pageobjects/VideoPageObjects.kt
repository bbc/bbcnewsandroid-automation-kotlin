package com.bbcnews.automation.pageobjects

import io.appium.java_client.MobileElement
import io.appium.java_client.pagefactory.AndroidBy
import io.appium.java_client.pagefactory.AndroidFindAll
import io.appium.java_client.pagefactory.AndroidFindBy

object VideoPageObjects {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Video']")
    lateinit var video: MobileElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='BBC News Channel']")
    lateinit var bbcNewsChannel: MobileElement

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/media_item_caption"), AndroidBy(id = "bbc.mobile.news.uk:id/media_item_caption"))
    lateinit var liveMediaItemCaption: MobileElement

    @AndroidFindBy(accessibility = "Play button")
    lateinit var accessibilityPlay: MobileElement

    @AndroidFindBy(accessibility = "Pause button")
    lateinit var accessibilityPause: MobileElement

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/smp_pause_button"), AndroidBy(id = "bbc.mobile.news.uk:id/smp_pause_button"))
    lateinit var smpPauseButton: MobileElement

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/smp_play_pause_container"))
    lateinit var smpPlayPauseButton: MobileElement

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk:id/smp_placeholder_play_button"), AndroidBy(accessibility = "Play"))
    lateinit var smpPlaceholderPlayButton: MobileElement

    @AndroidFindBy(accessibility = "volume")
    lateinit var smpVolumeButton: MobileElement

    @AndroidFindBy(accessibility = "Fullscreen")
    lateinit var smpFullScreenButton: MobileElement

    @AndroidFindBy(accessibility = "exit fullscreen")
    lateinit var smpExitFullScreenButton: MobileElement

    @AndroidFindAll(
            AndroidBy(id = "bbc.mobile.news.uk.internal:id/smp_seek_bar"),
            AndroidBy(id = "bbc.mobile.news.uk:id/smp_seek_bar"))
    lateinit var smpSeekBar: MobileElement

    @AndroidFindAll(
            AndroidBy(id = "bbc.mobile.news.uk.internal:id/smp_live_icon"),
            AndroidBy(accessibility = "live content"))
    lateinit var smpLiveIcon: MobileElement

    @AndroidFindAll(
            AndroidBy(id = "bbc.mobile.news.uk.internal:id/smp_playout_window_inset"),
            AndroidBy(id = "bbc.mobile.news.uk:id/smp_playout_window_inset"))
    lateinit var transportControls: MobileElement

    @AndroidFindAll(
            AndroidBy(id = "bbc.mobile.news.uk.internal:id/smp_play_button"),
            AndroidBy(id = "bbc.mobile.news.uk:id/smp_play_button"))
    lateinit var playButton: MobileElement

    val videosOfTheDayRelease = arrayOf("bbc.mobile.news.uk.internal:id/newstream_duration", "bbc.mobile.news.uk.internal:id/newstream_title", "bbc.mobile.news.uk.internal:id/newstream_summary", "bbc.mobile.news.uk:id/teaser_media_info_icon")

    val videoDetailPage = arrayOf("bbc.mobile.news.uk.internal:id/media_item_caption", "bbc.mobile.news.uk.internal:id/headline_title", "bbc.mobile.news.uk.internal:id/headline_info", "bbc.mobile.news.uk.internal:id/headline_link")

    val videoDetailPageText = arrayOf("In Egypt, fake news becomes weapon of choice to crush dissent", "Amal Fathy: Egypt court imposes jail term over harassment video", "31 Dec 2018", "Middle East")

    val videoDetailPageRelease = arrayOf("bbc.mobile.news.uk:id/media_item_caption", "bbc.mobile.news.uk:id/headline_title", "bbc.mobile.news.uk:id/headline_info", "bbc.mobile.news.uk:id/headline_link")

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Amal Fathy: Egypt court imposes jail term over harassment video' and @index='1']")
    lateinit var videoArticleSearch: MobileElement

    val playbackControls = arrayOf(
            "bbc.mobile.news.uk.internal:id/smp_pause_button",
            "bbc.mobile.news.uk.internal:id/smp_seek_bar",
            "bbc.mobile.news.uk.internal:id/smp_fullscreen_button",
            "bbc.mobile.news.uk.internal:id/smp_duration",
            "bbc.mobile.news.uk.internal:id/smp_elapsed"
    )

    val playbackControlsRelease = arrayOf(
            "bbc.mobile.news.uk:id/smp_pause_button",
            "bbc.mobile.news.uk:id/smp_seek_bar",
            "bbc.mobile.news.uk:id/smp_fullscreen_button",
            "bbc.mobile.news.uk:id/smp_duration",
            "bbc.mobile.news.uk:id/smp_elapsed"
    )

    val videoWallElements = arrayOf(
            "bbc.mobile.news.uk.internal:id/smp_placeholder_play_button",
            "bbc.mobile.news.uk.internal:id/videoTitleTimestamp",
            "bbc.mobile.news.uk.internal:id/videoTitleTopic",
            "bbc.mobile.news.uk.internal:id/videoSummary"
    )

    val videoWallElementsRelease = arrayOf(
            "bbc.mobile.news.uk:id/smp_placeholder_play_button",
            "bbc.mobile.news.uk:id/videoTitleTimestamp",
            "bbc.mobile.news.uk:id/videoTitleTopic",
            "bbc.mobile.news.uk:id/videoSummary"
    )

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='3']")
    lateinit var topStoriesVideo: MobileElement

    @AndroidFindAll(AndroidBy(id = "bbc.mobile.news.uk.internal:id/smp_elapsed"), AndroidBy(id = "bbc.mobile.news.uk:id/smp_elapsed"))
    lateinit var smpElapsedTime: MobileElement

    lateinit var elapsedTimeForward: String
    lateinit var elapsedTimeBackward: String
}
