package com.Sauce.Base;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenshot {
    
    public String getScreenshot(WebDriver driver, String methodname) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File des = new File(System.getProperty("user.dir")+"/test-output/" + methodname + ".png");
            Files.copy(src.toPath(), des.toPath(), StandardCopyOption.REPLACE_EXISTING);
            return des.getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
