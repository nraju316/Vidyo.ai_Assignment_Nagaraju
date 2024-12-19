//Print were used for debugging purpose

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;


public class task01 {
    public static void main(String[] args) {
        // Set the path for the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "E:\\chromedriver-win64\\chromedriver.exe");

        // Initialize a WebDriver instance
        WebDriver driver = new ChromeDriver();

        try {
            // Open the website
            driver.get("https://app.quso.ai/auth/login-with-email");

            // Maximize the browser window
            driver.manage().window().maximize();

            // Initialize WebDriverWait with a timeout of 10 seconds
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Wait for the email input field (type="email") to be visible and enter the username
            WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));
            emailField.sendKeys("vikram0812+intern@proton.me");

            // Wait for the password input field (type="password") to be visible and enter the password
            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
            passwordField.sendKeys("Intern@2024");

            // Wait for the login button to be clickable and click it
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
            loginButton.click();

            // Wait for the URL to change to the target URL
            wait.until(ExpectedConditions.urlToBe("https://app.quso.ai/home"));
            System.out.println("Login successful! URL changed to: " + driver.getCurrentUrl());

            // Wait for the "AI Video Generator" text to be visible and click on it
            WebElement aiVideoGenerator = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='text-sm font-medium' and text()='AI Video Generator']")));
            aiVideoGenerator.click();
            System.out.println("Clicked on 'AI Video Generator' successfully!");

            // Wait for the textarea to become visible
            WebElement textArea = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("textarea[placeholder*='summarize your script']")));

            // Generate random text
            String[] words = {"AI", "video", "automation", "script", "test", "random", "example"};
            Random random = new Random();
            StringBuilder randomText = new StringBuilder();
            for (int i = 0; i < 5; i++) { // Add 5 random words
                randomText.append(words[random.nextInt(words.length)]).append(" ");
            }

            // Enter the random text into the textarea
            textArea.sendKeys(randomText.toString().trim());
            System.out.println("Entered random text: " + randomText);
            
         // Wait for the button to be clickable and click it
            WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("describe-script-continue-button")));
            continueButton.click();
            System.out.println("Clicked on the 'Continue' button successfully!");


         // Wait for the button with ID 'text-to-video-generate-video-button' to be clickable and click it
            WebElement generateButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("text-to-video-generate-video-button")));
            generateButton.click();
            System.out.println("Clicked on the 'Generate Script' button successfully!");

            
         // Wait for the "Generate Video" button to be clickable and click it
            WebElement generateVideoButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("text-to-video-generate-video-button")));
            generateVideoButton.click();
            System.out.println("Clicked on the 'Generate Video' button successfully!");

            
            
         // Wait for the "Processing..." text to be visible
            WebDriverWait waitForProcessing = new WebDriverWait(driver, Duration.ofSeconds(30));
            waitForProcessing.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("div.text-base.font-semibold.text-garlic-100")
            ));
            System.out.println("Processing found");

            
         // Fetch the value of the input element below the "Processing..." element
            WebElement inputElement = driver.findElement(By.cssSelector("input.text-brand-grease"));
            String inputValue = inputElement.getAttribute("value");
            System.out.println("Input text value: " + inputValue);
            
            
            
            // Wait for the "Processing..." text to disappear
            WebDriverWait waitForProcessingDisappearance = new WebDriverWait(driver, Duration.ofSeconds(200));
            waitForProcessingDisappearance.until(ExpectedConditions.invisibilityOfElementLocated(
                By.cssSelector("div.mt-1.text-xs.font-medium.text-garlic-500")
            ));
            System.out.println("Processing text disappeared");
            
         // Click on the input element
            inputElement.click();
            System.out.println("Input element clicked.");
            
            
 //THERE IS A BUG WHICH IS NOT ALLOWING THE USER TO DOWNLOAD FROM CUSTOM BACKGROUND STYLE HENCE I AM CLICKING ON STOCK BACKGROUND STYLE           
            
         // Wait until the "Stock" option is visible
            WebDriverWait waitForStockOption = new WebDriverWait(driver, Duration.ofSeconds(120));
            waitForStockOption.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("text-to-video-background-video-type-stock")
            ));

            // Now click the "Stock" option since it is visible
            WebElement stockOption = driver.findElement(By.id("text-to-video-background-video-type-stock"));
            stockOption.click();
            System.out.println("Stock option clicked");
            
            
         // Wait for the first video element to be visible
            WebDriverWait waitForVideo = new WebDriverWait(driver, Duration.ofSeconds(120));
            waitForVideo.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("div.relative.z-20.flex.h-\\[114px\\] .LazyLoad.is-visible video")
            ));

            // Find the first video element
            WebElement firstVideo = driver.findElement(By.cssSelector("div.relative.z-20.flex.h-\\[114px\\] .LazyLoad.is-visible video"));

            // Click on the video
            firstVideo.click();
            System.out.println("First video clicked");


            
            
         // Wait for the download button to be available and clickable
            WebDriverWait waitForDownloadButton = new WebDriverWait(driver, Duration.ofSeconds(30));
            WebElement downloadButton = waitForDownloadButton.until(ExpectedConditions.elementToBeClickable(
                By.id("text-to-video-download-button")
            ));

            // Click the download button
            downloadButton.click();
            System.out.println("Download button clicked and Download has been started");
            


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser after 5 seconds (for demonstration purposes)
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //driver.quit();
        }
    }
}
