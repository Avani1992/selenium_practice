from selenium import  webdriver
import time
from logfile import *

driver=webdriver.Firefox(executable_path=r'C:\\Users\\Kothiya.kuman\\Desktop\\Testing\\selenium_sw\\geckodriver-v0.26.0-win64\\geckodriver.exe')
logger = logging.getLogger()
logger.setLevel(logging.INFO)
def test_checkGoogle_Url():
    logger.info("Open the Firefox browser..")
    logger.info('--------------------------------------------------------------------------------------')
    logger.info('test_checkGoogle_Url..............')

    e_url='https://www.google.com/?gws_rd=ssl'
    logger.info("Enter Google URL...")
    logger.info('We are redirecting to the Google Webpage...')
    driver.get('http://www.google.com')
    a_url=driver.current_url
    logger.info('actual_url')
    logger.info(a_url)
    logger.info('expected_url')
    logger.info(e_url)
    if(a_url==e_url):
        logger.info("test_checkGoogle_URL: Passed...")
    else:
        logger.info("test_checkGoogle_URL: Failed...")
    time.sleep(3)





def test_current_Url():
    logger.info('--------------------------------------------------------------------------------------')
    logger.info('test_current_Url..............')
    ex_url='https://online.actitime.com/tcs1/administration/manage_licenses.do'
    logger.info("Enter Actitime URL...")
    logger.info('enter correct username, password and click on Login Button and check it is redirected to the homepage.')
    driver.get("https://online.actitime.com/tcs1/login.do")
    logger.info("Enter username=kkj28kumanj@gmail.com")
    driver.find_element_by_id('username').send_keys('kkj28kumanj@gmail.com')
    logger.info("Enter password=manager")
    driver.find_element_by_name('pwd').send_keys('manager')
    logger.info("click on the Login button.")
    driver.find_element_by_xpath("//a[@id='loginButton']//div[contains(text(),'Login')]").click()
    time.sleep(4)

    text=driver.current_url
    logger.info('current_url')
    logger.info(text)
    logger.info('expected_url')
    logger.info(ex_url)
    if(text==ex_url):
        logger.info("test_current_Url: Passed..")
    else:
        logger.info("test_current_Url: Failed..")
    print(text)


def test_checkbox():
    logger.info('--------------------------------------------------------------------------------------')
    logger.info('test_checkbox..............')
    logger.info('Goto the Actitime webpage....')
    logger.info('click on the checkbox')
    driver.get("https://online.actitime.com/tcs1/login.do")
    chkbox = driver.find_element_by_id('keepLoggedInCheckBox')
    chkbox.click()

    if (chkbox.is_selected()):

            logger.info("test_checkbox: Passed..")
            print("Yes")
    else:
        logger.info("test_checkbox: Failed...")
        print("No")



def test_alert_popup():
    logger.info('--------------------------------------------------------------------------------------')
    logger.info('test_alert_popup..............')
    logger.info('Enter the GSRTC webpage url....')
    logger.info('check whether alert popup displayed when we click on search button..')
    ex_data=" 'From' place is required."
    print(ex_data)

    driver.get('https://gsrtc.in/site/')
    logger.info('Click on the search button.')
    driver.find_element_by_xpath("//button[@id='cboxClose']").click()
    time.sleep(2)
    driver.find_element_by_xpath(
        "//div[@id='menu1']//button[@class='btn btn-primary btn-md'][contains(text(),'Search')]").click()

    alert = driver.switch_to.alert

    time.sleep(2)
    data = alert.text

    print("Alert msg: ", data)
    alert.accept()

    if(data==ex_data):
        logger.info("test_alert_popup: Passed..")
    else:
        logger.info("test_alert_popup: Failed..")

    time.sleep(2)


def test_multielement():
    logger.info('--------------------------------------------------------------------------------------')
    logger.info('test_multielement..............')
    logger.info('enter the Google webpage url..')
    ex_list=['manual testing','manual','manual scavenging','manual testing interview questions','manual meaning','manual testing jobs','manually','manual testing pdf','manual testing tools'
]

    driver.get('http://www.google.com')
    logger.info('Enter the manual in google searchtextbox')
    driver.find_element_by_name('q').send_keys('manual')
    time.sleep(7)
    lists = driver.find_elements_by_xpath("//span[contains(.,'manual')]")  # list of all links which contain manual in it.

    size = len(lists)
    ac_list=list()
    for i in range(0, size):
        text = lists[i].text  # retrieve text from list.
        print(text)
        ac_list.append(text)
    if(ac_list==ex_list):
        logger.info("test_multielement:Passed...")
    else:
        logger.info("test_multielement: Failed..")
    driver.close()
    logger.info('--------------------------------------------------------------------------------------')
    logger.info("Close the browser")

test_checkGoogle_Url()
test_checkbox()
test_current_Url()
test_alert_popup()
test_multielement()