package nl.orhun;

import com.sun.net.httpserver.SimpleFileServer;
import com.sun.net.httpserver.SimpleFileServer.OutputLevel;
import java.net.InetSocketAddress;
import java.net.URISyntaxException;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;

public class A3_SimpleFileServer {

  @Test
  void simpeFileServer() throws URISyntaxException {
    Path resourcesRoot = Path.of(A3_SimpleFileServer.class.getResource("/A2Input.txt").toURI());
    SimpleFileServer.createFileServer(new InetSocketAddress(8080), resourcesRoot.getParent(), OutputLevel.INFO).start();
  }

}
