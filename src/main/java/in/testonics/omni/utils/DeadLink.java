package in.testonics.omni.utils;

import in.testonics.omni.utils.MultiThread.MultiThreadingWithRunnable;
import in.testonics.omni.web.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DeadLink {

    private int numberOfThreads = 1;
    private static Map<String,String> links = new ConcurrentHashMap<>();
    private String BASE_URL_CHECK= "";
    private int urlSizeToCheck = 1;
    private String BASE_URL = "";
    private static final String xpathToURLs = "//*[@href and not(contains(@style,'none')) and not(contains(@type,'hidden'))]";

    public void setNumberOfThreads(int numberOfThreads){
        this.numberOfThreads = numberOfThreads;
    }

    public void setBaseURL(String baseURL){
        this.BASE_URL = baseURL;
    }

    public void setBaseURLCheck(String baseURLCheck){
        this.BASE_URL_CHECK = baseURLCheck;
    }

    public void setUrlSizeToCheck(int urlSizeToCheck){
        this.urlSizeToCheck = urlSizeToCheck;
    }

    public void findDeadLinks() throws InterruptedException {
        List<Thread> threads = new ArrayList<>();

        getListOfURLs();
        links = setBaseURLCheck(links);
        links = setUrlSizeCheck(links);

        for (int i = 0; i < numberOfThreads; i++) {
            String link = links.keySet().iterator().next();
            Thread thread = new Thread(new MultiThreadingWithRunnable(link));
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads){
            thread.join();
        }

        System.out.println("List Of URLs : " + new MultiThreadingWithRunnable().getURLs());
    }

    private Map<String,String> setUrlSizeCheck(Map<String,String> links){
        Map<String,String> urls = new ConcurrentHashMap<>();
        for (Map.Entry mapElement : links.entrySet()) {
            String link= mapElement.getKey().toString();
            link = link.replace("http://","");
            link = link.replace("https://","");
            if (link.split("/").length>urlSizeToCheck){
                urls.put(mapElement.getKey().toString(),"alive");
            }
        }
        return urls;
    }

    private Map<String,String> setBaseURLCheck(Map<String,String> links) {
        Map<String, String> urls = new ConcurrentHashMap<>();
        for (Map.Entry mapElement : links.entrySet()) {
            String link = mapElement.getKey().toString();
            if (!"".equals(BASE_URL_CHECK) && link.contains(BASE_URL_CHECK)) {
                urls.put(link, "alive");
            }
        }
        return urls;
    }

    private void getListOfURLs(){
        WebDriver driver = Browser.getWebDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(BASE_URL);
        List<WebElement> listOfLinks = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpathToURLs)));
        for (WebElement webElement: listOfLinks){
            String url = webElement.getAttribute("href");
            links.put(url,"alive");
        }
        driver.quit();
    }

}
