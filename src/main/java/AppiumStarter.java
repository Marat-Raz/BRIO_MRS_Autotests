import java.io.IOException;

public class AppiumStarter {
    public static void startAppiumServerUsingCommandPrompt() {
        Runtime runtime = Runtime.getRuntime();
        try {
            Process appiumServer = runtime.exec("cmd.exe /c start cmd.exe /k appium");
            }
        catch (IOException e) {
            e.printStackTrace();
            }
    }

    public static void stopAppiumServerUsingCommandPrompt() {
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("taskkill /F /IM node.exe");
            runtime.exec("taskkill /F /IM cmd.exe");
            }
        catch (IOException e) {
            e.printStackTrace();
            }
    }
}
