package common;

import java.io.IOException;
import java.util.Map;

public class Base {

    public static Map<String, Object> dataFromJsonFile;

    static {
        String env = System.getProperty("env") == null ? "qa" : System.getProperty("env");

        try {
            dataFromJsonFile = JsonUtils.getJsonDataFromBase("airLines/qa/airLinesApiData.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
