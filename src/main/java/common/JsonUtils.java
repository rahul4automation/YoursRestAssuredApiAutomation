package common;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import  java.io.File;
import java.io.IOException;

public class JsonUtils {

    /* Read the data from Json file Using map */

    private static ObjectMapper objectMapper =new ObjectMapper();
    public static  Map<String,String> getJsonDataAsMap(String jsonFileName) throws IOException
    {
         String completeJsonFilePath=System.getProperty("user.dir") + "/src/test/resources/" + jsonFileName;
        Map<String,String> data=objectMapper.readValue(new File(completeJsonFilePath), new TypeReference<Map<String,String>>(){});
        return data;
    }
}
