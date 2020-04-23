import  pytest
import time
from logfile import *
logger = logging.getLogger()
logger.setLevel(logging.INFO)

def test_checkGoogle_Url(test_chromedriver):
    logger.info("Enter Google URL...")
    driver=test_chromedriver[0]
    driver.get('http://www.google.com')
    time.sleep(3)
    driver.close()

def test_current_Url(test_chromedriver):
    driver = test_chromedriver[0]
    logger.info("Enter Actitime URL...")
    driver.get("https://online.actitime.com/tcs1/login.do")
    logger.info("Enter username=kkj28kumanj@gmail.com")
    driver.find_element_by_id('username').send_keys('kkj28kumanj@gmail.com')
    logger.info("Enter password=manager")
    driver.find_element_by_name('pwd').send_keys('manager')
    logger.info("click on the Login button.")
    driver.find_element_by_xpath("//a[@id='loginButton']//div[contains(text(),'Login')]").click()
    time.sleep(4)

    text=driver.current_url
    logger.info('Current url=',text)
    print(text)
    driver.close()

def test_checkbox(test_chromedriver):
    driver = test_chromedriver[0]
    logger.info('Click on the checkbox')
    driver.get("https://online.actitime.com/tcs1/login.do")
    chkbox = driver.find_element_by_id('keepLoggedInCheckBox')
    chkbox.click()
    if (chkbox.is_selected()):
        print("Yes")
    else:
        print("No")

    driver.close()

def test_alert_popup(test_chromedriver):
    driver = test_chromedriver[0]
    logger.info('Enter the GSRTC webpage url..')
    driver.get('https://gsrtc.in/site/')
    logger.info('Click on the search button.')
    driver.find_element_by_xpath("//button[@id='cboxClose']").click()
    time.sleep(2)
    driver.find_element_by_xpath(
        "//div[@id='menu1']//button[@class='btn btn-primary btn-md'][contains(text(),'Search')]").click()

    alert = driver.switch_to.alert

    time.sleep(2)
    data = alert.text
    logger.info('Alert msg=',data)
    print("Alert msg: ", data)
    alert.accept()
    time.sleep(2)
    driver.close()

def test_multielement(test_chromedriver):
    driver = test_chromedriver[0]
    logger.info("Enter the Google webpage url")
    driver.get('http://www.google.com')
    logger.info('Enter the manual in google searchtextbox')
    driver.find_element_by_name('q').send_keys('manual')
    time.sleep(7)
    lists = driver.find_elements_by_xpath("//span[contains(.,'manual')]")  # list of all links which contain manual in it.

    size = len(lists)

    for i in range(0, size):
        text = lists[i].text  # retrieve text from list.
        print(text)
        logger.info(text)
    driver.close()
    logger.info("Close the browser")



