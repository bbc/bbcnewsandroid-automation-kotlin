package com.bbcnews.automation.commonfunctions

import com.aventstack.extentreports.ExtentReports
import com.aventstack.extentreports.ExtentTest
import com.aventstack.extentreports.Status
import com.aventstack.extentreports.markuputils.ExtentColor
import com.aventstack.extentreports.markuputils.MarkupHelper
import com.aventstack.extentreports.reporter.ExtentHtmlReporter
import com.aventstack.extentreports.reporter.configuration.ChartLocation
import com.aventstack.extentreports.reporter.configuration.Theme
import com.bbcnews.automation.commonfunctions.FilePaths.resultsFilePath
import com.bbcnews.automation.testutils.PlatformTouchAction
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.connection.ConnectionStateBuilder
import io.appium.java_client.android.nativekey.AndroidKey
import io.appium.java_client.android.nativekey.KeyEvent
import io.appium.java_client.touch.WaitOptions
import io.appium.java_client.touch.offset.ElementOption
import io.appium.java_client.touch.offset.PointOption
import org.apache.commons.io.FileUtils
import org.openqa.selenium.*
import org.openqa.selenium.NoSuchElementException
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import org.testng.Assert.*
import org.testng.ITestResult
import ru.yandex.qatools.ashot.AShot
import java.awt.Toolkit
import java.awt.image.PixelGrabber
import java.io.*
import java.nio.file.Files
import java.nio.file.Paths
import java.text.SimpleDateFormat
import java.time.Duration
import java.util.*
import java.util.Arrays.equals
import javax.imageio.ImageIO

object CommonFunctionKotlin {

    private lateinit var extent: ExtentReports
    private lateinit var htmlReporter: ExtentHtmlReporter
    private lateinit var androidDriver: AndroidDriver<MobileElement>

    var test: ExtentTest? = null

    fun startReport(reportName: String) {
        val deviceOsName = System.getProperty("DeviceOS")
        val deviceId = System.getProperty("DeviceID")
        val deviceName = System.getProperty("DeviceName")

        val curDate = Date()
        println(curDate.toString())

        println("resultsFilePath is $resultsFilePath")
        Thread.sleep(4000)

        val reportFolder = extentResultFolder(resultsFilePath)
        println("reportFolder is $reportFolder")
        Thread.sleep(4000)

        //htmlReporter = new ExtentHtmlReporter(reportFolder+File.separator+reportName+device_name+dateName+".html");
        htmlReporter = ExtentHtmlReporter("$reportFolder$reportName$deviceName.html")
        extent = ExtentReports()
        extent.attachReporter(htmlReporter)

        htmlReporter.setAppendExisting(true)

        extent.setSystemInfo("Device ID", deviceId)
        extent.setSystemInfo("Firmware version", deviceOsName)
        extent.setSystemInfo("Device Name ", deviceName)
        extent.setSystemInfo("Run Started on", curDate.toString())

        htmlReporter.config().chartVisibilityOnOpen = true
        htmlReporter.config().documentTitle = "BBC News Android Report "
        htmlReporter.config().reportName = "Test Report"
        htmlReporter.config().testViewChartLocation = ChartLocation.TOP
        htmlReporter.config().theme = Theme.STANDARD
        htmlReporter.config().timeStampFormat = "EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'"
    }

    fun startTest(testName: String, testDescription: String, category: String) {
        test = extent.createTest(testName, testDescription)
        test?.assignCategory(category)
    }

    fun publishReport() = extent.flush()

    /**
     * Appium Android default method
     * even though the AndroidKeycode is deprecated in latest appium and java client
     *
     * @param, androidDriver, only works with Android
     */
    fun navigateBack(androidDriver: AndroidDriver<MobileElement>) {
        //androidDriver.pressKeyCode(AndroidKeyCode.BACK);
        androidDriver.pressKey(KeyEvent(AndroidKey.BACK))
    }

    /**
     * Function on click on any button or link on the app
     *
     * @param, driverType, element Type
     * boolean to take screenshot ( true = takes screenshot and attached to testReport, fail= wont take screenshot)
     * Screenshot path
     */
    fun tapButton(appiumDriver: AppiumDriver<MobileElement>, element: MobileElement?, takeScreenshot: Boolean) {
        waitForScreenToLoad(appiumDriver, element, 3)
        element?.click()
        Thread.sleep(800)
        if (takeScreenshot) {
            val screenShotPath = getScreenshot(appiumDriver, element?.text)
            println("Taken screenshot path is $screenShotPath")
            test?.log(Status.INFO, "Screenshot Attached:-" + test?.addScreenCaptureFromPath(screenShotPath))

        }
    }

    fun appbackground(androidDriver: AndroidDriver<MobileElement>, duration: Long) {
        androidDriver.runAppInBackground(Duration.ofMillis(duration))
    }

    fun tapButtons(appiumDriver: AppiumDriver<MobileElement>, element: MobileElement?, takeScreenshot: Boolean) {
        waitForScreenToLoad(appiumDriver, element, 3)
        element?.click()
        Thread.sleep(2000)

        when {
            takeScreenshot -> {
                val screenshotPath = getScreenshot(appiumDriver, element?.text.toString())
                println("Path for screenshot is $screenshotPath")
                test?.log(Status.INFO, "Screenshot attached:-" + test?.addScreenCaptureFromPath(screenshotPath))
            }
        }
    }

    /**
     * Function to wait until the screen is fully loaded
     * @param, driver, element and seconds to wait for page to load
     */

    fun waitForScreenToLoad(driver: AppiumDriver<MobileElement>, element: MobileElement?, seconds: Int) {
        val wait = WebDriverWait(driver, seconds.toLong())
        wait.until<WebElement>(ExpectedConditions.visibilityOf(element))
    }

//    open fun waitForScreenToLoads(driver: AppiumDriver<MobileElement>, element: MobileElement?, seconds: Int) {
//
//        val wait = WebDriverWait(driver, seconds.toLong())
//        wait.until<WebElement>(ExpectedConditions.visibilityOf(element))
//
//    }

    /**
     * @param, drivertype, screenshot path, screenshot name
     * attaches the screenshot to the test report
     */
    private fun getScreenshot(appiumDriver: AppiumDriver<MobileElement>, screenshotName: String?): String {
        try {
            val dateName = SimpleDateFormat("dd-M-yyyy hh:mm").format(Date())
            val takeScreenshot = appiumDriver as TakesScreenshot
            val source = takeScreenshot.getScreenshotAs(OutputType.FILE)
            val file = File(extentResultFolder("Screenshots").toString())
            val destination = file.absolutePath + File.separator + screenshotName + "_" + dateName + ".png"

            println("the ScreenShot  Folder is :- " + file.absolutePath)
            println("Screenshot path name:------$destination")

            FileUtils.copyFile(source, File(destination))

            println("ScreenShot Taken")
            return destination

        } catch (e: Exception) {
            println("Exception While Taking screenshot" + e.message)
            return e.message.toString()
        }

    }

    /**
     * Function to create a folder with the project path
     * @param, Directory path
     */
    fun extentResultFolder(path: String): String? {
        try {
            // Create one directory
            val success = File(path).mkdirs()

            // Create multiple directories
            if (success) println("Directories: $path created")

        } catch (e: Exception) {
            System.err.println("Error: " + e.message)
        }

        return path
    }


    /**
     * Function to scroll to an element, if the list if very big
     *
     * @param, driverType, element to be scrolled, screenshot
     */
    fun scrollToElement(appiumDriver: AppiumDriver<MobileElement>, element: MobileElement?) {
        for (i in 0..20) {
            try {
                element?.isDisplayed
                break
            } catch (e: Exception) {
                verticalSwipe(appiumDriver, "Down")
            }
        }
    }

    /**
     * Function to seek vertical on the app.
     * Startx remains constant
     * StartY and EndY are the two main parameters to swipe vertically
     * @param, driverType
     */

    fun verticalSwipe(driver: AppiumDriver<MobileElement>, swipingdirection: String) {
        val dimension = driver.manage().window().size
        val height = dimension.getHeight()
        val width = dimension.getWidth()
        val startX = width / 2
        val startY = (height * 0.75).toInt()
        val endY = (height * 0.35).toInt()

//        val action = TouchAction(performsTouchActions = driver)
//        action.press(PointOption.point(startX, startY))
//                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
//                .moveTo(PointOption.point(startX, endY)).release().perform()
        if (swipingdirection == "Down") {
            PlatformTouchAction(driver).press(PointOption.point(startX, startY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                    .moveTo(PointOption.point(startX, endY)).release().perform()
        } else if (swipingdirection == "Up") {
            PlatformTouchAction(driver).press(PointOption.point(startX, endY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                    .moveTo(PointOption.point(startX, startY)).release().perform()
        }
    }

    fun waitFor(seconds: Long) = Thread.sleep(seconds)

    /**
     * Function to seek the video, you need pass the percentage of seeking
     * @param appiumDriver
     * @param element
     * @param d
     * @throws InterruptedException
     */

    fun livevideoseeking(appiumDriver: AppiumDriver<MobileElement>, element: MobileElement, d: Double) {
        val startX = element.location.getX()
        val endX = element.size.width
        val yAxis = element.location.getY()
        val moveToXDirectionAt = (endX * d).toInt()

        PlatformTouchAction(appiumDriver)
                .press(PointOption.point(startX, yAxis))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(moveToXDirectionAt, yAxis))
                .release()
                .perform()
    }


    /**
    Function to enter the text into a textfeld
    @param, driverType, element and string that's need to be entered
     */
    fun entersearchtext(element: MobileElement, searchkey: String) {
        element.sendKeys(searchkey)
    }


    /**
     * Function to check whether an Element is present or not
     */
    fun isElementPresent(appiumDriver: AppiumDriver<MobileElement>, locatorKey: By): Boolean {
        return try {
            appiumDriver.findElement(locatorKey)
            test?.log(Status.PASS, appiumDriver.findElement(locatorKey).text + "Element Present")
            true

        } catch (e: NoSuchElementException) {
            test?.log(Status.INFO, appiumDriver.findElement(locatorKey).text + "Element Not Present")
            false
        }
    }

    /**
     * Function to check whether an element is displayed , return true if present else fail
     * If true, then the element text will be attached the report name. If element text not present, it uses the
     * element attribute
     *
     * @param, drivertype, element name
     */
    fun elementDisplayed(appiumDriver: AppiumDriver<MobileElement>, element: MobileElement?) {
        try {
            waitForScreenToLoad(appiumDriver, element, 3)
            assertTrue(element?.isDisplayed!!)
            if (element.isDisplayed) {
                if (element.text?.isEmpty()!!) {
                    test?.log(Status.PASS, element.getAttribute("contentDescription") + "  Displayed")
                } else {
                    test?.log(Status.PASS, element.text + "  Displayed")
                }

            } else {
                test?.log(Status.FAIL, element.text + "  is not Displayed")
            }

        } catch (e: AssertionError) {
            e.printStackTrace()
            println("Element $element not found")
            fail()
        }
    }

    fun getTestResult(appiumDriver: AppiumDriver<MobileElement>, result: ITestResult) {
        when {
            result.status == ITestResult.FAILURE -> {
                test?.fail(MarkupHelper.createLabel(result.name + " Test Case is FAILED", ExtentColor.RED))
                test?.fail(result.throwable)
                try {
                    val screenshotPath = getScreenshot(appiumDriver, result.name)
                    test?.log(Status.FAIL, "Failed" + test?.addScreenCaptureFromPath(screenshotPath))
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
            result.status == ITestResult.SUCCESS -> test?.pass(MarkupHelper.createLabel(result.name + " Test Case is PASSED", ExtentColor.GREEN))
            result.status == ITestResult.SKIP -> {
                test?.skip(MarkupHelper.createLabel(result.name + " Test Case is SKIPPED", ExtentColor.YELLOW))
                test?.skip(result.throwable)
            }
        }

    }


    /**
     * function to create a ExtentReport
     * @reportName
     * @deviceOS, @deviceName, @deviceId
     */
    @Throws(Exception::class)
    fun createAReportHive(reportName: String, deviceName: String, deviceId: String) {

        val curDate = Date()
        println(curDate.toString())

        // val dateName = SimpleDateFormat("hh:mm").format(Date())

        val reportFolder = extentResultFolder(resultsFilePath)
        println("Report folder is $reportFolder")

        val subDirectory = "Results"
        val resultsPaths: String
        resultsPaths = extentResultFolder(subDirectory).toString()
        val file = File(resultsPaths)
        println("the Result path Folder is :- " + file.absolutePath)

        htmlReporter = ExtentHtmlReporter(file.absolutePath + File.separator + reportName + ".html")//"_"+deviceName+"_"+deviceOS+ ".html");
        extent = ExtentReports()
        extent.attachReporter(htmlReporter)
        htmlReporter.setAppendExisting(false)
        extent.setSystemInfo("Device ID", deviceId)
        extent.setSystemInfo("Device Name ", deviceName)
        extent.setSystemInfo("Run Started on", curDate.toString())

        htmlReporter.config().chartVisibilityOnOpen = true
        htmlReporter.config().documentTitle = "BBC News Android Report "
        htmlReporter.config().reportName = "Automation Test Report"
        htmlReporter.config().testViewChartLocation = ChartLocation.TOP
        htmlReporter.config().theme = Theme.STANDARD
        htmlReporter.config().timeStampFormat = "EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'"
    }


    /**
     * Function to scroll on TopStories - Videos and Stories carousel
     * @param, driverType, element and path for screenshot to be taken
     */
    fun scrollToEndOfStories(appiumDriver: AppiumDriver<MobileElement>, element: MobileElement?,
                             elements: Array<String>, element2: MobileElement?) {
        // val flag = false
        for (i in 0..20) {
            try {
                waitForScreenToLoad(appiumDriver, element, 5)
                Thread.sleep(800)
                val elementTitle = element?.text
                test?.log(Status.INFO, elementTitle)
                for (j in elements.indices) {
                    isElementPresent(appiumDriver, By.id(elements[j]))
                    test?.log(Status.PASS, elements[j])
                }
                Thread.sleep(800)
                element2?.isDisplayed
                //element?.click();
                break
            } catch (e: Exception) {

                horizontalSwipe(appiumDriver)

            }

        }
    }

    /**
     * Function to seek horizontal on the app.
     * Yaxis remains horizontal
     * StartXaxis and endXaxis are the two main parameters to swipe vertically
     * @param, driverType
     */
    private fun horizontalSwipe(driver: AppiumDriver<MobileElement>) {
        val dimension = driver.manage().window().size
        val height = dimension.getHeight()
        val width = dimension.getWidth()
        val startXAxis = (width * 0.90).toInt()
        val yAxis = (height * 0.20).toInt()
        val endXAxis = (width * 0.10).toInt()

//         val action = TouchAction(driver)
//         action.press(PointOption.point(startXAxis, YAxis))
//                 .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
//                 .moveTo(PointOption.point(endXAxis, YAxis)).release().perform()

        PlatformTouchAction(driver).press(PointOption.point(startXAxis, yAxis))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endXAxis, yAxis)).release().perform()
    }

    fun isElementSelected(element: MobileElement?): Boolean {
        return if (element?.isSelected!!) {
            test?.log(Status.INFO, "Element selected")
            true
        } else {
            test?.log(Status.INFO, "Element not selected")
            false
        }
    }

    fun enterText(element: MobileElement?, searchKey: String) = element?.sendKeys(searchKey)

    fun getText(element: MobileElement?): String = element?.text!!

    /**
     * Returns all png images from a directory in an array.
     * @param directory                 the directory to start with
     * @param descendIntoSubDirectories should we include sub directories?
     * @return an ArrayList<String> containing all the files or nul if none are found..
     * @throws IOException
    </String> */
    @Throws(IOException::class)
    fun getAllImages(directory: File, descendIntoSubDirectories: Boolean): ArrayList<String> {
        val resultList = ArrayList<String>(256)
        val files = directory.listFiles()

        for (file in files) {
            if (file != null && file.name.toLowerCase().endsWith(".png")) {
                resultList.add(file.canonicalPath)
            }
            if (descendIntoSubDirectories && file.isDirectory) {
                val tmp = getAllImages(file, true)
                resultList.addAll(tmp)
            }
        }
        return if (resultList.size > 0) resultList
        else null!!
    }


    /**
     * Function which compares the two images by pixels and by dimension
     *
     * @throws IOException
     */
    @Throws(IOException::class)
    fun compareTwoImages() {
        val expected = File("./Screenshots/Before")
        val actual = File("./Screenshots/After")

        val expectedResults: ArrayList<String> = getAllImages(expected, false)
        val expectedImages = expectedResults.toTypedArray()

        val actualResults: ArrayList<String> = getAllImages(actual, false)
        val actualImages = actualResults.toArray(arrayOfNulls<String>(actualResults.size))
        var i = 0
        while (i < expectedImages.size && i < actualImages.size) {
            println("Expected Image :=" + expectedImages[i])
            println("Actual Image :=" + actualImages[i])

            compareImage(File(expectedImages[i]), File(actualImages[i]))
            processImage(expectedImages[i], actualImages[i])
            i++
        }
    }


    /**
     * Function to compare two images and display the difference
     */
    private fun compareImage(fileA: File, fileB: File): Float {
        var percentage = 0f
        try {
            // take buffer data from both image files //
            val biA = ImageIO.read(fileA)
            val biB = ImageIO.read(fileB)
            val dbA = biA.data.dataBuffer
            val dbB = biB.data.dataBuffer
            val sizeA = dbA.size
            val sizeB = dbB.size
            var count = 0

            // compare data-buffer objects //
            if (sizeA == sizeB) {
                for (i in 0 until sizeA) {
                    if (dbA.getElem(i) == dbB.getElem(i)) count += 1
                }

                percentage = (count * 100 / sizeA).toFloat()
                println("Image Difference Percentage --> :- $percentage")
                test?.log(Status.PASS, "Image Difference Percentage --> :- $percentage")

            } else {
                println("Both the images are not of same size")
                test?.log(Status.FAIL, "Both the images are not of same size")
            }

        } catch (e: Exception) {
            println("Failed to compare image files ...")
        }

        return percentage
    }


    /**
     * Function to compare the images by pixel
     * @param expected
     * @param actual
     */
    private fun processImage(expected: String?, actual: String?) {
        val imageSrc = Toolkit.getDefaultToolkit().getImage(expected)
        val imageCom = Toolkit.getDefaultToolkit().getImage(actual)

        try {
            val grab1 = PixelGrabber(imageSrc, 0, 0, -1, -1, false)
            val grab2 = PixelGrabber(imageCom, 0, 0, -1, -1, false)

            var data1: IntArray? = null

            if (grab1.grabPixels()) {
                //    val width = grab1.getWidth()
                //   val height = grab1.getHeight()
                //data1 = IntArray(width * height)
                data1 = grab1.pixels as IntArray?
            }

            var data2: IntArray? = null

            if (grab2.grabPixels()) {
                //    val width = grab2.getWidth()
                //  val height = grab2.getHeight()
                //data2 = IntArray(width * height)
                data2 = grab2.pixels as IntArray?
            }

            println("Pixels equal: " + equals(data1, data2))
            test?.log(Status.INFO, "Pixels equal: " + equals(data1, data2))

        } catch (e1: InterruptedException) {
            e1.printStackTrace()
        }

    }


    @Throws(IOException::class)
    fun screenshot(driver: AndroidDriver<MobileElement>, folder: String, imageName: String) {
        val dateName = SimpleDateFormat("dd-M-yyyy hh:mm").format(Date())
        val directory = "Screenshots"
        val screenshotPaths = extentResultFolder(directory)

        extentResultFolder(folder)

        File(screenshotPaths)
        // success = (new File(strManyDirectories)).mkdirs();

        val myScreenshot = AShot().takeScreenshot(driver)
        val screenshotFolder = Paths.get(directory, folder)
        if (Files.notExists(screenshotFolder))
            Files.createDirectory(screenshotFolder)
        // To save the screenshot in desired location

        ImageIO.write(
                myScreenshot.image,
                "PNG",
                File(screenshotFolder.toString() + File.separator + imageName + dateName + ".png")
        )
    }

    /**
     * Function to seek forward on the video/audio playing
     * @param, driverType, Element type
     * double the seeking position ex(.30) means 30% seek
     */
    @Throws(InterruptedException::class)
    fun videoPlaybackSeeking(driver: AppiumDriver<MobileElement>, element: MobileElement, d: Double, seekingtype: String) {
        val startX = element.location.getX()
        println("Start x: $startX")

        val endX = element.size.getWidth()
        println("End x: $endX")

        val yAxis = element.location.getY()
        println("Y axis: $yAxis")

        val moveToXDirectionAt = (endX * d).toInt()
        println("Moving seek bar at $moveToXDirectionAt in x direction.")
        Thread.sleep(3000)

        if (seekingtype.equals("forward", ignoreCase = true)) {
            PlatformTouchAction(driver).press(PointOption.point(startX, yAxis))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                    .moveTo(PointOption.point(moveToXDirectionAt, yAxis)).release().perform()

        } else if (seekingtype.equals("backward", ignoreCase = true)) {
            PlatformTouchAction(driver).press(PointOption.point(endX, yAxis))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                    .moveTo(PointOption.point(moveToXDirectionAt, yAxis)).release().perform()
        }
    }

    fun elementDragDrop(androidDriver: AndroidDriver<MobileElement>, elementFrom: MobileElement, elementTo: MobileElement) {
        PlatformTouchAction(androidDriver)
                .longPress(ElementOption.element(elementFrom))
                .moveTo(ElementOption.element(elementTo))
                .release()
                .perform()
    }

    /**
     * function to read the text from a recyclerview
     * @param androidDriver
     */
    fun readRecyclerView(androidDriver: AndroidDriver<MobileElement>, text: String) {
        val elements = androidDriver
                .findElementByClassName("android.support.v7.widget.RecyclerView")
                .findElements(By.id("bbc.mobile.news.uk.internal:id/text"))

        for (element in elements) {
            //System.out.println("Topics After  Re-Ordering :- "+element?.getText());
            test?.log(Status.INFO, text + element?.text)
        }
    }


    @Throws(InterruptedException::class, IOException::class)
    fun comapreStatsData(csv: String, statsData: Array<String>) {
        var br: BufferedReader? = null
        val line: String
        val cvsSplitBy = ","
        var country: Array<String>?
        var statUrl: Array<String>?

        try {
            br = BufferedReader(FileReader(csv))
            line = br.readLine()
            while (false) {
                // use comma as separator
                country = line.split(cvsSplitBy.toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
                statUrl = country[0].split("&".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
                println("Stat's URL " + country[0])
                for (i in statUrl.indices) {

//                    System.out.println("The New Generated Stats " + staturl[i]);
                    for (j in statsData.indices) {
                        if (statUrl[i].equals(statsData[j], ignoreCase = true)) {

                            assertEquals(statUrl[i], statsData[j], "Stat's Matched")
                            val matchedStats = statUrl[i]
                            println("The New Generated Stats $matchedStats")
//                            list.add(staturl[i].toString()))
                        }
                    }
                }
            }

        } catch (e: FileNotFoundException) {
            e.printStackTrace()

        } finally {
            when {
                br != null -> try {
                    br.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }
    }


    /**
     * function to check whether WiFi Connection enabled or not.
     * If not, enables the WiFi Connection
     * @param androidDriver
     */
    fun checkConnection(androidDriver: AndroidDriver<MobileElement>) {
        val state = androidDriver.setConnection(ConnectionStateBuilder()
                .withWiFiEnabled()
                .build())

        System.out.println("The WiFi status is " + state.isWiFiEnabled)

        if (!state.isWiFiEnabled) androidDriver.connection = state
    }

    /**
     *
     */
    fun textPresent(appiumDriver: AppiumDriver<MobileElement>, text: String, text1: String) {
        val textPresent = appiumDriver.findElement(By.xpath("//android.widget.TextView[@text='$text $text1 My News']"))
        test?.log(Status.PASS, "Element Present" + textPresent.text)
    }

    /**
     * Function to seek the video, you need pass the percentage of seeking
     * @param driver
     * @param element
     * @param d
     * @throws InterruptedException
     */
    @Throws(InterruptedException::class)
    fun videoPlaybackSeeking(driver: AppiumDriver<MobileElement>, element: MobileElement?, d: Double) {
        val startX = element?.location?.getX()
        System.out.println("startX :$startX")

        val endX = element?.size?.getWidth()
        System.out.println("endX  :$endX")

        val yAxis = element?.location?.getY()
        System.out.println("yAxis  :$yAxis")

        val moveToXDirectionAt = (endX?.times(d))?.toInt()
        System.out.println("Moving seek bar at $moveToXDirectionAt In X direction.")
        Thread.sleep(3000)

        PlatformTouchAction(driver).press(PointOption.point(startX!!, yAxis!!))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(moveToXDirectionAt!!, yAxis)).release().perform()
    }


    /**
     * Function to seek forward on the video/audio playing
     * @param, driverType, Element type
     * double the seeking position ex(.30) means 30% seek
     */
    fun seeking(element: MobileElement?, double: Double, seekingDirection: String) {
        val elementWidth = element?.size?.getWidth()
        val startX = element?.location?.getX()
        val endX = (elementWidth?.times(double))?.toInt()

        when (seekingDirection) {
            "forward" -> seekFromPointToPoint(element!!, startX!!, endX!!)
            "backward" -> seekFromPointToPoint(element!!, elementWidth!!, endX!!)
        }
    }

    private fun seekFromPointToPoint(element: MobileElement, xStart: Int, xFinish: Int) {
        val yAxis = element.location.getY()

        PlatformTouchAction(androidDriver)
                .press(PointOption.point(xStart, yAxis))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(xFinish, yAxis))
                .release()
                .perform()
    }

    fun elementIsSelected(element: MobileElement?): Boolean {
        return if (element?.isSelected!!) {
            test?.log(Status.INFO, "Element selected")
            true
        } else {
            test?.log(Status.INFO, "Element not selected")
            false
        }
    }

    fun getElements(appiumDriver: AppiumDriver<MobileElement>, elementID: String) {
        val elements = appiumDriver.findElements(By.id(elementID))

        System.out.println("Element count: " + elements.size)
        System.out.println("Element text: \n")
        for (element in elements) System.out.println(element?.text + "\n")
    }

//    /**
//     *
//     * @param locator
//     * @return
//     */
//
//    fun elementFoundAndClicked(locator: By): ExpectedCondition<Boolean> {
//        return object : ExpectedCondition<Boolean> {
//            @Override
//            fun apply(driver: appiumDriver): Boolean {
//                val el = driver.findElement(locator)
//                el.click()
//                return true
//            }
//        }
//    }

}
