package com.bbcnews.automation.pageobjects

import java.io.BufferedReader
import java.io.FileNotFoundException
import java.io.FileReader
import java.io.IOException
import java.util.*

class StatsTestData {

    var bbcNewsBasicStats = arrayOf("ptag=Android", "apid=bbc.mobile.news.uk.internal", "type=screen", "action=view", "vtag=2.10.2", "apvr=%5B5%2E5%2E0%2E91%5D", "x2=%5Bmobile%2Dapp%5D", "x3=%5Bnews%5D", "x8=%5Becho%5Fandroid%2D17%2E1%2E0%5D", "manufacturer=samsung", "model=SM-G925F")
    var topStories = arrayOf("p=news.page", "x7=5Bindex%2Dhome%5D")
    var popularPage = arrayOf("p=news%2Emost%5Fpopular%2Epage", "x7=%5Blist%2Ddatadriven%5D")
    var videoPage = arrayOf("p=video%5Fand%5Faudio%3A%3Atop%5Fstories%3A%3Anews%2Evideo%5Fand%5Faudio%2Etop%5Fstories%2Epage", "x7=%5Bindex%2Dsection%5D")
    var myNews = arrayOf("p=news%2Emynews%2Eunconfigured%2Epage", "x7=%5Blist%2Dpersonalised%2Dactive%5D")
    var searchStats = arrayOf("p=news%2Esearch%2Epage", "x7=%5Bsearch%5D")
    var settingsStats = arrayOf("p=news%2Esettings%2Epage", "x7=%5Bsettings%5D")
    var csvFile = "./CharlesFolder/BBCNews.csv"

    @Throws(InterruptedException::class, IOException::class)
    fun compareStatsData(csvFile: String, statsData: Array<String>) {
        // String csvFile = "./CharlesFolder/BBCNews.csv";
        var br: BufferedReader? = null
        val line: String
        val cvsSplitBy = ","
        var country: Array<String>?
        var staturl: Array<String>?
        val aListColors = ArrayList<String>()

        try {
            br = BufferedReader(FileReader(csvFile))
            line = br.readLine()
            while (line != null) {
                // use comma as separator
                country = line.split(cvsSplitBy.toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
                staturl = country[0].split("&".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
                for (i in staturl.indices) {
                    if (!aListColors.contains(staturl[i])) {
                        aListColors.add(staturl[i])
                    }
                }
            }

            staturl = aListColors.toTypedArray()
            for (i in staturl.indices) {
                for (j in statsData.indices) {
                    if (staturl[i].equals(statsData[j], ignoreCase = true)) {
                        val matchedStats = staturl[i]
                        println("The New Generated Stats " + matchedStats.replace("[-+^:,%2E5BD3AF]".toRegex(), ""))
                    }
                }
            }


        } catch (e: FileNotFoundException) {
            e.printStackTrace()

        } finally {
            if (br != null) {
                try {
                    br.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }
    }
}
