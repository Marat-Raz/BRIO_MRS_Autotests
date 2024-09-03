import java.io.File;
import java.io.IOException;

public class AltTesterDesktopStartEnd {
    static Process AltTesterDesktop = null;

    public static void AltTesterDesktopStarter() {
        ProcessBuilder pb = new ProcessBuilder("C:\\Program Files\\BrioAltTesterDesktop\\BrioAltTesterDesktopUnity.exe");
        pb.directory(new File("C:\\Program Files\\BrioAltTesterDesktop\\"));
        try {
            AltTesterDesktop = pb.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void AltTesterDesktopDestroy() {
        AltTesterDesktop.destroy();
    }

}
