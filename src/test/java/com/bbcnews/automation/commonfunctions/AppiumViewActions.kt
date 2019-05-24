package com.bbcnews.automation.commonfunctions

import com.aventstack.extentreports.ExtentReports
import com.aventstack.extentreports.ExtentTest
import com.aventstack.extentreports.Status
import com.aventstack.extentreports.markuputils.ExtentColor
import com.aventstack.extentreports.markuputils.MarkupHelper
import com.aventstack.extentreports.reporter.ExtentHtmlReporter
import com.aventstack.extentreports.reporter.configuration.ChartLocation
import com.aventstack.extentreports.reporter.configuration.Theme
import com.bbcnews.automation.pageobjects.BasePageObject
import com.bbcnews.automation.testdata.FilePaths.resultsFilePath
import com.bbcnews.automation.testutils.TestSetup.deviceId
import com.bbcnews.automation.testutils.TestSetup.deviceName
import com.bbcnews.automation.testutils.TestSetup.deviceOsName
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.connection.ConnectionStateBuilder
import io.appium.java_client.android.nativekey.AndroidKey
import io.appium.java_client.android.nativekey.KeyEvent
import io.appium.java_client.touch.WaitOptions.waitOptions
import io.appium.java_client.touch.offset.ElementOption
import io.appium.java_client.touch.offset.PointOption.point
import org.apache.commons.io.FileUtils
import org.openqa.selenium.*
import org.openqa.selenium.NoSuchElementException
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import org.testng.Assert.*
import org.testng.ITestResult
import org.testng.ITestResult.*
import ru.yandex.qatools.ashot.AShot
import java.awt.Toolkit
import java.awt.image.PixelGrabber
import java.io.*
import java.nio.file.Files
import java.nio.file.Paths
import java.text.SimpleDateFormat
import java.time.Duration.ofMillis
import java.util.*
import java.util.Arrays.equals
import javax.imageio.ImageIO

object AppiumViewActions {

    private var extent = ExtentReports()
    private val reportFolder = extentResultFolder(resultsFilePath)

    var test: ExtentTest? = null

    fun startReport(reportName: String) {
        val curDate = Date()
        println(curDate.toString())

        println("resultsFilePath is $resultsFilePath")
        Thread.sleep(2000)

        println("Report folder is $reportFolder")
        Thread.sleep(2000)

        val htmlReporter = ExtentHtmlReporter("$reportFolder$reportName$deviceName.html")

        extent.attachReporter(htmlReporter)
        extent.setSystemInfo("Device ID", deviceId)
        extent.setSystemInfo("Firmware version", deviceOsName)
        extent.setSystemInfo("Device Name ", deviceName)
        extent.setSystemInfo("Run started on", curDate.toString())

        htmlReporter.setAppendExisting(true)
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
        androidDriver.pressKey(KeyEvent(AndroidKey.BACK))
    }

    fun selectView(androidDriver: AndroidDriver<MobileElement>, view: MobileElement?) =
            tapButton(androidDriver, view, false)

    fun dismissDialogs(androidDriver: AndroidDriver<MobileElement>, numberOfTries: Int) {
        (0..numberOfTries).forEach { _ -> dismissDialog(androidDriver) }
    }

    private fun dismissDialog(androidDriver: AndroidDriver<MobileElement>) {
        val dialogOnScreen = isElementPresent(androidDriver, By.ById("android:id/button1"))

        when {
            dialogOnScreen -> tapButton(androidDriver, BasePageObject.dialog_yes, false)
        }
    }

    /**
     * Function on click on any button or link on the app
     *
     * @param, driverType, element Type
     * boolean to take screenshot ( true = takes screenshot and attached to testReport, fail= wont take screenshot)
     * Screenshot path
     */
    private fun tapButton(appiumDriver: AppiumDriver<MobileElement>, element: MobileElement?, takeScreenshot: Boolean) {
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
        androidDriver.runAppInBackground(ofMillis(duration))
    }

    /**
     * Function to wait until the screen is fully loaded
     * @param, driver, element and seconds to wait for page to load
     */
    fun waitForScreenToLoad(driver: AppiumDriver<MobileElement>, element: MobileElement?, seconds: Int) {
        val wait = WebDriverWait(driver, seconds.toLong())
        wait.until<WebElement>(ExpectedConditions.visibilityOf(element))
    }

    /**
     * @param, appiumDriver, screenshot path, screenshot name
     * attaches the screenshot to the test report
     */
    private fun getScreenshot(appiumDriver: AppiumDriver<MobileElement>, screenshotName: String?): String {
        try {
            val dateName = SimpleDateFormat("dd-M-yyyy hh:mm").format(Date())
            val takeScreenshot = appiumDriver as TakesScreenshot
            val source = takeScreenshot.getScreenshotAs(OutputType.FILE)
            val file = File(extentResultFolder("Screenshots").toString())
            val destination = file.absolutePath + File.separator + screenshotName + "_" + dateName + ".png"

            println("The screenshot folder is: " + file.absolutePath)
            println("Screenshot path: $destination")

            FileUtils.copyFile(source, File(destination))

            println("ScreenShot taken")
            return destination

        } catch (e: Exception) {
            println("Exception while taking screenshot " + e.message)
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

    fun smallSwipeUp(driver: AppiumDriver<MobileElement>) {
        val dimension = driver.manage().window().size
        val height = dimension.getHeight()
        val highPoint = (height * 0.50).toInt() // 0 = top of screen
        val lowPoint = (height * 0.60).toInt() // 1 = bottom of screen

        swipeVerticallyFromTo(driver, lowPoint, highPoint)
    }

    fun generalSwipe(driver: AppiumDriver<MobileElement>, swipingDirection: String) {
        val dimension = driver.manage().window().size
        val width = dimension.getWidth()
        val height = dimension.getHeight()

        val left = (width * 0.75).toInt() // 1 = left side
        val right = (width * 0.25).toInt() // 0 = right side
        val highPoint = (height * 0.45).toInt() // 0 = top of screen
        val lowPoint = (height * 0.65).toInt() // 1 = bottom of screen

        // Remember swiping is the opposite direction to scrolling, so you generalSwipe down to scroll up
        when (swipingDirection) {
            "Left" -> swipeHorizontallyFromTo(driver, right, left)
            "Right" -> swipeHorizontallyFromTo(driver, left, right)
            "Down" -> swipeVerticallyFromTo(driver, highPoint, lowPoint)
            "Up" -> swipeVerticallyFromTo(driver, lowPoint, highPoint)
        }
    }

    fun swipeElement(driver: AppiumDriver<MobileElement>, element: MobileElement, swipingDirection: String) {
        val elementXPoint = element.center.getX()
        val elementYPoint = element.center.getY()

        val dimension = driver.manage().window().size
        val width = dimension.getWidth()
        val height = dimension.getHeight()
        val xLeft = (width * 0.75).toInt() // 1 = left side
        val xRight = (width * 0.25).toInt() // 0 = right side
        val yHigh = (height * 0.45).toInt() // 0 = top of screen
        val yLow = (height * 0.65).toInt() // 1 = bottom of screen

        when(swipingDirection) {
            "Left" -> swipeFromTo(driver, xRight, elementYPoint, xLeft, elementYPoint)
            "Right" -> swipeFromTo(driver, xLeft, elementYPoint, xRight, elementYPoint)

            "Down" -> swipeFromTo(driver, yHigh, elementXPoint, yLow, elementXPoint)
            "Up" -> swipeFromTo(driver, yLow, elementXPoint, yHigh, elementXPoint)
        }
    }

    private fun swipeVerticallyFromTo(driver: AppiumDriver<MobileElement>, fromYPosition: Int, toYPosition: Int) {
        val screenSize = driver.manage().window().size
        val width = screenSize.getWidth()
        val middleOfScreen = width / 2

        swipeFromTo(driver = driver,
                fromXPosition = middleOfScreen, fromYPosition = fromYPosition,
                toXPosition = middleOfScreen, toYPosition = toYPosition
        )
    }

    private fun swipeHorizontallyFromTo(driver: AppiumDriver<MobileElement>, fromXPosition: Int, toXPosition: Int) {
        val screenSize = driver.manage().window().size
        val height = screenSize.getHeight()
        val yAxis = (height * 0.20).toInt()

        swipeFromTo(driver = driver,
                fromXPosition = fromXPosition, fromYPosition = yAxis,
                toXPosition = toXPosition, toYPosition = yAxis
        )
    }

    private fun swipeFromTo(driver: AppiumDriver<MobileElement>, fromXPosition: Int, fromYPosition: Int, toXPosition: Int, toYPosition: Int) {
        PlatformTouchAction(driver)
                .press(point(fromXPosition, fromYPosition))
                .waitAction(waitOptions(ofMillis(100)))
                .moveTo(point(toXPosition, toYPosition))
                .release()
                .perform()
    }

    fun waitFor(seconds: Long) = Thread.sleep(seconds)

    /**
     * Function to seek the video, you need pass the percentage of seeking
     * @param appiumDriver
     * @param element
     * @param d
     * @throws InterruptedException
     */
    fun seekLiveVideo(appiumDriver: AppiumDriver<MobileElement>, element: MobileElement, d: Double) {
        val startX = element.location.getX()
        val endX = element.size.width
        val yAxis = element.location.getY()
        val moveToXDirectionAt = (endX * d).toInt()

        PlatformTouchAction(appiumDriver)
                .press(point(startX, yAxis))
                .waitAction(waitOptions(ofMillis(1000)))
                .moveTo(point(moveToXDirectionAt, yAxis))
                .release()
                .perform()
    }

    /**
    Function to enter the text into a text field
    @param, driverType, element, and string to be entered
     */
    fun enterSearchText(element: MobileElement, searchKey: String) {
        element.sendKeys(searchKey)
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
     * @param, driver type, element name
     */
    fun elementDisplayed(appiumDriver: AppiumDriver<MobileElement>, element: MobileElement) {
        try {
            waitForScreenToLoad(appiumDriver, element, 2)
            checkIfDisplayingElement(element)
        } catch (e: AssertionError) {
            e.printStackTrace()
            println("Element $element not found")
            fail()
        }
    }

    fun checkIfDisplayingElement(element: MobileElement) = assertTrue(element.isDisplayed)

    fun getTestResult(appiumDriver: AppiumDriver<MobileElement>, result: ITestResult) {
        when (result.status) {
            SUCCESS -> test?.pass(MarkupHelper.createLabel(result.name + " Test Case is PASSED", ExtentColor.GREEN))

            FAILURE -> {
                test?.fail(MarkupHelper.createLabel(result.name + " Test case is FAILED", ExtentColor.RED))
                test?.fail(result.throwable)
                try {
                    val screenshotPath = getScreenshot(appiumDriver, result.name)
                    test?.log(Status.FAIL, "Failed" + test?.addScreenCaptureFromPath(screenshotPath))
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
            SKIP -> {
                test?.skip(MarkupHelper.createLabel(result.name + " Test case is SKIPPED", ExtentColor.YELLOW))
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

        val htmlReporter = ExtentHtmlReporter(file.absolutePath + File.separator + reportName + ".html")//"_"+deviceName+"_"+deviceOS+ ".html");
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
                this.generalSwipe(appiumDriver, "Left")
            }
        }
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
            PlatformTouchAction(driver).press(point(startX, yAxis))
                    .waitAction(waitOptions(ofMillis(1000)))
                    .moveTo(point(moveToXDirectionAt, yAxis)).release().perform()

        } else if (seekingtype.equals("backward", ignoreCase = true)) {
            PlatformTouchAction(driver).press(point(endX, yAxis))
                    .waitAction(waitOptions(ofMillis(1000)))
                    .moveTo(point(moveToXDirectionAt, yAxis)).release().perform()
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

//                    System.out.println("The New Generated Stats " + statUrl[i]);
                    for (j in statsData.indices) {
                        if (statUrl[i].equals(statsData[j], ignoreCase = true)) {

                            assertEquals(statUrl[i], statsData[j], "Stat's Matched")
                            val matchedStats = statUrl[i]
                            println("The New Generated Stats $matchedStats")
//                            list.add(statUrl[i].toString()))
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

        PlatformTouchAction(driver).press(point(startX!!, yAxis!!))
                .waitAction(waitOptions(ofMillis(1000)))
                .moveTo(point(moveToXDirectionAt!!, yAxis)).release().perform()
    }

    /**
     * Function to seek forward on the video/audio playing
     * @param, driverType, Element type
     * double the seeking position ex(.30) means 30% seek
     */
    fun seeking(androidDriver: AndroidDriver<MobileElement>, element: MobileElement?, double: Double, seekingDirection: String) {
        val elementWidth = element?.size?.getWidth()
        val startX = element?.location?.getX()
        val endX = (elementWidth?.times(double))?.toInt()

        when (seekingDirection) {
            "forward" -> seekFromPointToPoint(androidDriver, element, startX!!, endX!!)
            "backward" -> seekFromPointToPoint(androidDriver, element!!, elementWidth!!, endX!!)
        }
    }

    private fun seekFromPointToPoint(androidDriver: AndroidDriver<MobileElement>, element: MobileElement?, xStart: Int, xFinish: Int) {
        val yAxis = element?.location?.getY()

        PlatformTouchAction(androidDriver)
                .press(yAxis?.let { point(xStart, it) })
                .waitAction(waitOptions(ofMillis(1000)))
                .moveTo(yAxis?.let { point(xFinish, it) })
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

    /**
     * Function to empty the  result and screenshot folder
     * @param
     * folder name
     */
    fun emptyFolders(vararg filePaths: String) {
        for (filepath in filePaths) {
            val file = File(filepath)

            if (file.isDirectory) {
                val myFiles = file.list()
                for (i in myFiles!!.indices) {
                    val myFile = File(file, myFiles[i])
                    myFile.delete()
                }
            }
        }
    }

}
