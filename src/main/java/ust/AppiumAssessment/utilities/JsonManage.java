package ust.AppiumAssessment.utilities;

import java.io.File;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
public class JsonManage {
  
	private static final ObjectMapper objectMapper = new ObjectMapper();
// read data from json
   
	public static Map<String, String> readJsonFromFile(String filePath) throws IOException {
        return objectMapper.readValue(new File(filePath), Map.class);
    }
}