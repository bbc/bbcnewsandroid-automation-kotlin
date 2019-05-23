package com.bbcnews.automation.testdata

object FilePaths {

    private val workingDirectory: String = System.getProperty("user.dir")

    val resultsFilePath = "$workingDirectory/Results"
    val screenshotPath = "$workingDirectory/Screenshots/"

}