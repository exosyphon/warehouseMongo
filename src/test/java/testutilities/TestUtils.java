package testutilities;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.apache.commons.io.IOUtils;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

public class TestUtils {
  private static JsonParser parser = new JsonParser();

  public static String readFixture(String fixtureName) throws IOException {
    return IOUtils.toString(TestUtils.class.getResourceAsStream("/fixtures" + fixtureName));
  }

  public static String readJsonFixture(String fixtureName) throws IOException {
    return readJsonFixture(fixtureName, Collections.emptyMap());
  }

  public static String readJsonFixture(String fixtureName, Map<String, Object> values) throws IOException {
    String jsonAsString = IOUtils.toString(TestUtils.class.getResourceAsStream("/fixtures/" + fixtureName));

    for (Map.Entry<String, Object> entry : values.entrySet()) {
      jsonAsString = jsonAsString.replaceAll("==" + entry.getKey() + "==", entry.getValue().toString());
    }

    if (null != jsonAsString && jsonAsString.length() > 0) {
      jsonAsString = jsonAsString.trim();
      JsonElement jsonElement = parser.parse(jsonAsString);
      if (jsonAsString.startsWith("[")) {
        return jsonElement.getAsJsonArray().toString();
      } else {
        return jsonElement.getAsJsonObject().toString();
      }
    }

    throw new IOException("Cannot find fixture: " + fixtureName);
  }

  public static String asHtml(String htmlString) {
    return Jsoup.parse(htmlString.replaceAll("\\r?\\n *", "")).toString();
  }
}
