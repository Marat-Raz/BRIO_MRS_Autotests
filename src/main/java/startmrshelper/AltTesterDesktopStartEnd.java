package startmrshelper;

import java.io.File;
import java.io.IOException;

public class AltTesterDesktopStartEnd {

  static Process altTesterDesktop = null;

  public static void altTesterDesktopStarter() {
    ProcessBuilder pb = new ProcessBuilder(
        "C:\\Program Files\\BrioAltTesterDesktop\\BrioAltTesterDesktopUnity.exe");
    pb.directory(new File("C:\\Program Files\\BrioAltTesterDesktop\\"));
    try {
      altTesterDesktop = pb.start();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void altTesterDesktopDestroy() {
    altTesterDesktop.destroy();
  }

}
