import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

class ScreenshotCapturer {

    public static void main(String[] args) {
        try {
            // Create a Robot instance
            Robot robot = new Robot();

            // Define the screen dimensions (full screen)
            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());

            // Capture the screenshot
            BufferedImage screenshot = robot.createScreenCapture(screenRect);

            // Generate file name with timestamp
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String fileName = "screenshot_" + timeStamp + ".png";

            // Save the screenshot to the current directory
            File outputFile = new File(fileName);
            ImageIO.write(screenshot, "png", outputFile);

            System.out.println("Screenshot saved successfully: " + outputFile.getAbsolutePath());

        } catch (AWTException | IOException e) {
            System.out.println("Error taking screenshot: " + e.getMessage());
        }
    }
}
