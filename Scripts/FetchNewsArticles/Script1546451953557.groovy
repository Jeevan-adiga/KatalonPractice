import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('https://www.nytimes.com/')

WebUI.waitForJQueryLoad(120)

allInternalLinks = CustomKeywords.'com.custom.keywords.CustomKeywordUtils.getWebElements'('//a[contains(@href,\'nytimes.com\') and contains(@href,\'pgtype\')]')

WebUI.waitForPageLoad(120)

for (int i = 0; i < 10; i++) {
    WebUI.waitForPageLoad(120)

    WebUI.waitForElementVisible(findTestObject('HomePage/homePageBanner'), 30)

    CustomKeywords.'com.custom.keywords.CustomKeywordUtils.clickElement'(allInternalLinks.get(i))

    WebUI.waitForElementVisible(findTestObject('NewsDetails/newsHeader'), 120)

    newsBody = WebUI.getText(findTestObject('NewsDetails/newsBody'))

    newsHeader = WebUI.getText(findTestObject('NewsDetails/newsHeader'))

    WebUI.click(findTestObject('NewsDetails/logo'))
}

WebUI.closeBrowser()

