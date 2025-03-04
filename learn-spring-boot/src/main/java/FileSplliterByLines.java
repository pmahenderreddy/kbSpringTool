import java.io.File;
import java.io.FileOutputStream;
import java.util.Scanner;

public class FileSplliterByLines {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		FileSplliterByLines.splitFileByLines(
				"D:\\myGitHub\\kbSpringTool\\learn-spring-boot\\src\\main\\resources\\split-staging\\source.txt", 5);
	}

	public static void splitFileByLines(String sourceFilePath, int nrLines) throws Exception {
		File sourceFile = new File(sourceFilePath);
		Scanner inFile = new Scanner(sourceFile);
		boolean isNext = false;
		byte[] nlBytes = "\n".getBytes();
		int fileNr = 0;
		while (inFile.hasNext()) {
			File newFile = new File(sourceFile.getParent() + "/file-part-" + (++fileNr) + ".bat");
			FileOutputStream outFile = new FileOutputStream(newFile, true);
			System.out.println(fileNr+" file created "+newFile.getName());

			for (int i = 0; i < nrLines; i++) {
				if (inFile.hasNext()) {
					if (i > 0) {
						outFile.write(nlBytes);
					}
					outFile.write(inFile.nextLine().getBytes());
				}
			}
			outFile.close();
		}
	}

}
