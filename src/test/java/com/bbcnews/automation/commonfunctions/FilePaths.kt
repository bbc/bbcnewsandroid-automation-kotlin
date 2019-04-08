package com.bbcnews.automation.commonfunctions

object FilePaths {

    private val workingDirectory: String = System.getProperty("user.dir")

    val resultsFilePath = "$workingDirectory/Results"
    val screenshotPath = "$workingDirectory/Screenshots/"

}