import  pytest
from  selenium import webdriver

@pytest.fixture
def test_chromedriver():
    return [webdriver.Chrome(executable_path=r'C:\\Users\\Kothiya.kuman\\Desktop\\Testing\\selenium_sw\\chromedriver_win32 (1)\\chromedriver.exe')]