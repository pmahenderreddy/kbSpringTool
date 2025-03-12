import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.StringTokenizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RenameFiles {
	public static final Logger logger = LoggerFactory.getLogger(RenameFiles.class);

	// Method to sanitize the filenames by removing invalid characters
	private static String sanitizeFilename(String filename, String invalidChars) {
		for (int i = 0; i < invalidChars.length(); i++) {
			char invalidChar = invalidChars.charAt(i);
			filename = filename.replace(String.valueOf(invalidChar), "_"); // Replace invalid char with "_"
		}
		return filename;
	}

	public static void main(String[] args) throws Exception {
		// java RenameFiles "D:\KB\01 - Java etc\in28minutes-02-Learn Spring Boot 3 in 100 Steps - Beginner to Expert"
		if (args.length < 1) {
			logger.error("Missing parameter(s) \nExample: java " + RenameFiles.class.getName() + " <folder>");
			System.exit(1);
		}

		String folderPath = args[0];
		String textFilePath = folderPath + File.separator + "Map-Old-New-Names.txt";

		// List of invalid characters for filenames
		String invalidChars = "\\/:*?\"<>|";
		String delim = ":";

		// Read the new names from the text file
		List<String> namesOldNew = Files.readAllLines(Paths.get(textFilePath));
		for (int i = 0; i < namesOldNew.size(); i++) {
			StringTokenizer tokenizer = new StringTokenizer(namesOldNew.get(i), delim);
			String oldName = tokenizer.nextToken().trim();
			String newName = tokenizer.nextToken().trim();

			// Sanitize the new name by removing invalid characters
			newName = sanitizeFilename(newName, invalidChars);
			try {
				File oldFile = new File(folderPath + File.separator + oldName);
				if (oldFile.exists()) {
					File newFile = new File(folderPath + File.separator + newName);
					if (!newFile.exists()) {
						if (oldFile.renameTo(newFile)) {
							logger.info("Renamed: " + oldFile.getName() + " -> " + newFile.getName());
						} else {
							logger.warn("Failed to rename: " + oldFile.getName());
						}
					} else {
						logger.warn("Target file already exists with name : " + newFile.getName());
					}
				} else {
					logger.warn("Source file does not exists with name : " + oldFile.getName());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
