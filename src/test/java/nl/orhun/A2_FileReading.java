package nl.orhun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;

class A2_FileReading {

  @Test
  void readClasspathResource() {
    URL resource = A2_FileReading.class.getResource("/A2Input.txt");
    try {
      String content = Files.readString(Path.of(resource.toURI()));
      System.out.println(content);
    } catch (IOException | URISyntaxException e) {
      throw new RuntimeException(e);
    }
  }

  @Test
  void readClassPathInputStreamWithBufferedReader() {
    InputStream in = A2_FileReading.class.getResourceAsStream("/A2Input.txt");

    StringBuilder content = new StringBuilder();
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
      char[] buffer = new char[4]; // 4 is the chunk that will be read
      while (reader.read(buffer, 0, buffer.length) != -1) {
        System.out.println(new String(buffer));
        content.append(new String(buffer));
      }
    } catch (Exception e) {
      throw new RuntimeException("Oops", e);
    }
    System.out.println("\nResult:");
    System.out.println(content);
  }

}
