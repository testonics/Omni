package org.testonics.omni.frameworks;

public class Omni {
    public static String framework = "Selenium";
    public static String SELENIUM = "SELENIUM";
    public static String PLAYWRIGHT = "PLAYWRIGHT";
    public static String ANDROID = "ANDROID";

    Selenium selenium = new Selenium();
    PW pw = new PW();
    Android android = new Android();

    public void setDriver(){
        framework = framework.toUpperCase();
        if (framework.equals(SELENIUM)){
            selenium.setDriver();
        }else if (framework.equals(PLAYWRIGHT)){
            pw.setDriver();
        }else if(framework.equals(ANDROID)){
            android.setDriver();
        }else{
            System.out.println("Framework " + framework + " is not correct");
        }
    }


    public Object getDriver(){
        framework = framework.toUpperCase();
        if (framework.equals(SELENIUM)){
            return selenium.getDriver();
        }else if (framework.equals(PLAYWRIGHT)){
            return pw.getDriver();
        }else if(framework.equals(ANDROID)){
            return android.getDriver();
        }else{
            return "Framework " + framework + " is not correct";
        }
    }

    public void navigate(){
        if (framework.equals(SELENIUM)){
            selenium.navigate();
        }else if (framework.equals(PLAYWRIGHT)){
            pw.navigate();
        }else if(framework.equals(ANDROID)){
            android.setDriver();
        }else{
            System.out.println("Framework " + framework + " is not correct");
        }
    }

    public void close(){
        if (framework.equals(SELENIUM)){
            selenium.closeDriver();
        }else if (framework.equals(PLAYWRIGHT)){
            pw.closeDriver();
        }else if(framework.equals(ANDROID)){
            android.setDriver();
        }else{
            System.out.println("Framework " + framework + " is not correct");
        }
    }

    public void click(Object element) {
        if (framework.equals(SELENIUM)){
            selenium.click(element);
        }else if (framework.equals(PLAYWRIGHT)){
            pw.click(element);
        }else if(framework.equals(ANDROID)){
            android.setDriver();
        }else{
            System.out.println("Framework " + framework + " is not correct");
        }
    }

    public void enter(Object element, String value) {
        if (framework.equals(SELENIUM)){
            selenium.enter(element,value);
        }else if (framework.equals(PLAYWRIGHT)){
            pw.enter(element,value);
        }else if(framework.equals(ANDROID)){
            android.setDriver();
        }else{
            System.out.println("Framework " + framework + " is not correct");
        }
    }

    public void select(Object element, Object value) {
        if (framework.equals(SELENIUM)){
            selenium.select(element,value);
        }else if (framework.equals(PLAYWRIGHT)){
            pw.select(element,value);
        }else if(framework.equals(ANDROID)){
            android.setDriver();
        }else{
            System.out.println("Framework " + framework + " is not correct");
        }
    }


}

