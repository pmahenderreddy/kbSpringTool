import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ExtractRequestUrls {
	public static void main(String[] args) throws IOException {
		String jsonString = Files.readString(Paths.get("D:\\KB\\regex-all.har"));

		try {
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode rootNode = objectMapper.readTree(jsonString);

			// Traverse the JSON and get the 'log' array
			JsonNode dataArray = rootNode.path("log");
			JsonNode entriesArray = dataArray.path("entries");
			
			// Loop through each object in the "data" array and extract "request_url"
			for (JsonNode entry : entriesArray) {
				//if (200 == entry.path("response").path("status").numberValue().intValue()) {
				if ("200".equals(entry.path("response").path("status").asText())) { // success
					String requestUrl = entry.path("request").path("url").asText();
					if (requestUrl.indexOf("index.m3u8") != -1) { // found
						System.out.println(requestUrl);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
