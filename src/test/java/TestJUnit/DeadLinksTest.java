package TestJUnit;

import org.testonics.omni.utils.DeadLink;

public class DeadLinksTest {

    public static void main(String[] args) throws InterruptedException {
        DeadLink deadLink = new DeadLink();

        deadLink.setBaseURL("https://www.google.com");
        deadLink.setBaseURLCheck("google.com");
        deadLink.setUrlSizeToCheck(1);
        deadLink.setNumberOfThreads(5);

        deadLink.findDeadLinks();
    }
}
