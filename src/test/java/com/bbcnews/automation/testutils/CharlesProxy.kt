package com.bbcnews.automation.testutils

import com.bbcnews.automation.commonfunctions.CommonFunctionKotlin.extentResultFolder
import java.io.*

class CharlesProxy {

    var charlesconfig = "./charles/BBCNews.config"
    var charlesRecord = "curl -v -x http://localhost:8888 http://control.charles/recording/start"
    var charlesSessionDownload = "curl -o session.chls -x http://localhost:8888 http://control.charles/session/download"
    var charlesStop = "curl -v -x http://localhost:8888 http://control.charles/recording/stop"
    var startCharles = "Charles -config"
    var stopCharles = "killall Charles"

    var rt: Runtime = Runtime.getRuntime()

    var charlesFolder = extentResultFolder("CharlesFolder")
    var files = File(charlesFolder)


    fun startCharles() {
        //val dir = File("./charles/BBCNews.config")
        try {
            // Process pr = rt.exec("charles");
            rt.exec("charles -config ./charles/charlesproxy.config &")
            System.out.println("Starting Charles ")
        } catch (e: IOException) {

        }

    }


    fun stopCharles() {
        try {
            rt.exec("killall charles")
            System.out.println("Stopping Charles ")
        } catch (e: IOException) {

        }

    }

    fun convertToCSV() {
        try {
           rt.exec("charles convert session.chls session.csv")
            Thread.sleep(2000)
        } catch (e: IOException) {
        } catch (e: InterruptedException) {
        }

    }

    fun convertToCSV(fromFileName: String, toFileName: String) {
        try {
           rt.exec("charles convert " + files.canonicalFile + File.separator + fromFileName + " " + files.canonicalFile + File.separator + toFileName + "")
            Thread.sleep(3000)
            System.out.println("Converting Charles Session")
        } catch (e: IOException) {
        } catch (e: InterruptedException) {
        }

    }

    @Throws(InterruptedException::class)
    fun downloadCharlesSession() {
        try {
            rt.exec("curl -o session.chls -x http://localhost:8888 http://control.charles/session/download")
            Thread.sleep(3000)
        } catch (e: IOException) {
        }

    }


    @Throws(InterruptedException::class)
    fun downloadCharlesSession(filename: String) {
        try {

             rt.exec("curl -o " + files.getCanonicalFile() + File.separator + filename + " -x http://localhost:8888 http://control.charles/session/download")
            System.out.println("Downloading Charles Session")
            Thread.sleep(3000)
        } catch (e: IOException) {
        }

    }

    fun startCharlesSession() {
        try {
           rt.exec("curl -v -x http://localhost:8888 http://control.charles/recording/start")
            System.out.println("Starting Charles Session")
            Thread.sleep(2000)
        } catch (e: Exception) {
        }

    }

    fun stopCharlesSession() {
        try {
            //Process p5 = Runtime.getRuntime().exec(charlesStop);
           rt.exec("curl -v -x http://localhost:8888 http://control.charles/recording/stop")
            System.out.println("Stopping Charles Session")
            Thread.sleep(2000)
        } catch (e: Exception) {
        }

    }

}
