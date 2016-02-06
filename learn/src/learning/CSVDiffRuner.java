package learning;

import java.io.File;
import java.io.IOException;

public class CSVDiffRuner {
	public static void main(String[] args) throws IOException {
		try{
			File f1 = new File(args[0]);
			File f2 = new File(args[1]);
			CSVDiff no = new CSVDiff(f1, f2);
			no.getDiffCSV();
			System.out.println("a");
		}
		catch(Exception ex) {
			System.out.println("Invalid files or wrong command format");
			System.out.println("Command format: java newFile.csv oldFile.csv");
		}
	}
}
