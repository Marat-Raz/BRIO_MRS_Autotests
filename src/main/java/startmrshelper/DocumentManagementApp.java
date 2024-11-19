package startmrshelper;

import java.io.File;
import java.io.IOException;

public class DocumentManagementApp {

  static Process brioDocsApi = null;

  public static void startDocumentManagement(String mrsStartFolder) throws InterruptedException {
    ProcessBuilder pb = new ProcessBuilder(
        mrsStartFolder + "DocumentManagement\\Brio.Docs.Api.exe");
    pb.directory(new File(mrsStartFolder + "DocumentManagement"));
    try {
      brioDocsApi = pb.start();
    } catch (IOException e) {
      e.printStackTrace();
    }
    Thread.sleep(1000);
  }

  public static void documentManagementDestroy() {
    brioDocsApi.destroy();
  }
}
