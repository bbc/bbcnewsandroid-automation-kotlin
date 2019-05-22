package com.bbcnews.automation.testutils

import com.bbcnews.automation.commonfunctions.AppiumViewActions.extentResultFolder
import java.io.File
import java.io.IOException
import java.lang.Runtime.getRuntime

class CharlesProxy {

    private val charlesconfig = "./charles/BBCNews.config"
    private val charlesRecord = "curl -v -x http://localhost:8888 http://control.charles/recording/start"
    private val charlesSessionDownload = "curl -o session.chls -x http://localhost:8888 http://control.charles/session/download"
    private val charlesStop = "curl -v -x http://localhost:8888 http://control.charles/recording/stop"
    private val startCharles = "Charles -config"
    private val stopCharles = "killall Charles"
    private val runTime: Runtime = getRuntime()
    private val charlesFolder = extentResultFolder("CharlesFolder")
    private val files = File(charlesFolder)

    fun startCharles() {
        //val dir = File("./charles/BBCNews.config")
        try {
            // Process pr = runTime.exec("charles");
            runTime.exec("charles -config ./charles/charlesproxy.config &")
            System.out.println("Starting Charles ")
        } catch (e: IOException) {
        }
    }

    fun stopCharles() {
        try {
            runTime.exec("killall charles")
            System.out.println("Stopping Charles ")
        } catch (e: IOException) {
        }
    }

    fun convertToCSV() {
        try {
            runTime.exec("charles convert session.chls session.csv")
            Thread.sleep(2000)
        } catch (e: IOException) {
        } catch (e: InterruptedException) {
        }

    }

    fun convertToCSV(fromFileName: String, toFileName: String) {
        try {
            runTime.exec("charles convert " + files.canonicalFile + File.separator + fromFileName + " " + files.canonicalFile + File.separator + toFileName + "")
            Thread.sleep(3000)
            System.out.println("Converting Charles Session")
        } catch (e: IOException) {
        } catch (e: InterruptedException) {
        }
    }

    @Throws(InterruptedException::class)
    fun downloadCharlesSession() {
        try {
            runTime.exec("curl -o session.chls -x http://localhost:8888 http://control.charles/session/download")
            Thread.sleep(3000)
        } catch (e: IOException) {
        }
    }

    @Throws(InterruptedException::class)
    fun downloadCharlesSession(filename: String) {
        try {
            runTime.exec("curl -o " + files.canonicalFile + File.separator + filename + " -x http://localhost:8888 http://control.charles/session/download")
            System.out.println("Downloading Charles Session")
            Thread.sleep(3000)
        } catch (e: IOException) {
        }
    }

    fun startCharlesSession() {
        try {
            runTime.exec("curl -v -x http://localhost:8888 http://control.charles/recording/start")
            System.out.println("Starting Charles Session")
            Thread.sleep(2000)
        } catch (e: Exception) {
        }
    }

    fun stopCharlesSession() {
        try {
            //Process p5 = Runtime.getRuntime().exec(charlesStop);
            runTime.exec("curl -v -x http://localhost:8888 http://control.charles/recording/stop")
            System.out.println("Stopping Charles Session")
            Thread.sleep(2000)
        } catch (e: Exception) {
        }
    }
}
