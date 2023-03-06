package in.testonics.omni.frameworks;

import in.testonics.omni.Interface.Omni;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

public class PW implements Omni {

    static Playwright playwright;
    public String url = "https://www.google.com";
    static Page page;

    public void setDriver(){
        playwright = Playwright.create();
    }

    public Playwright getDriver(){
        return playwright;
    }

    public void closeDriver(){
        playwright.close();
    }

    public void navigate(){
        com.microsoft.playwright.Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome").setSlowMo(50));
        page = browser.newContext().newPage();
        page.navigate(url);
    }

    @Override
    public void click(Object element) {
        Locator locator = getLocator(element);
        locator.click();
    }

    @Override
    public void enter(Object element, String value) {
        Locator locator = getLocator(element);
        locator.fill(value);
        locator.press("Enter");
    }

    @Override
    public void select(Object element, Object value) {
        Locator locator = getLocator(element);
        locator.selectOption((String) value);
    }

    private Locator getLocator(Object element){
        return page.locator((String) element);
    }
}
