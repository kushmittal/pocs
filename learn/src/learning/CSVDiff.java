package learning;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

/**
 * 
 * @author Paul Portela
 *
 */

public class CSVDiff {
	private ArrayList<String[]> diffFile;
	private File newFile;
	private File oldFile;
	private Map<String, String[]> newFileContents;
	private Map<String, String[]> oldFileContents;
	private String[] pkNewFile;
	private String[] pkOldFile;
	private CSVWriter writer;
	private Set<String> linesOnlyNew;
	private Set<String> linesOnlyOld;
	
	public CSVDiff(File f1, File f2) throws FileNotFoundException, IOException {
		this.newFile = f1;
		this.oldFile = f2;
		writer = new CSVWriter(new FileWriter("/home/impadmin/Downloads/output.csv"));
		newFileContents = new HashMap<String, String[]>();
		oldFileContents = new HashMap<String, String[]>();
		diffFile = new ArrayList<String[]>();
		
		CSVReader readerNew = new CSVReader(new FileReader(newFile));
		CSVReader readerOld = new CSVReader(new FileReader(oldFile));
		List<String[]> newFileLines = readerNew.readAll();
		List<String[]> oldFileLines = readerOld.readAll();
		pkNewFile = new String[newFileLines.size()];
		pkOldFile = new String[oldFileLines.size()];
		
		newFileLines.get(1)[0] = "x";
		oldFileLines.get(1)[0] = "x";
		for(int i = 0; i < newFileLines.size(); i++) {
			String[] line = newFileLines.get(i);
			pkNewFile[i] = line[0];
			newFileContents.put(line[0], line);
		}
		
		for(int i = 0; i < oldFileLines.size(); i++) {
			String[] line = oldFileLines.get(i);
			pkOldFile[i] = line[0];
			oldFileContents.put(line[0], line);
		}
		
		linesOnlyNew = new HashSet<String>(Arrays.asList(pkNewFile));
		linesOnlyOld = new HashSet<String>(Arrays.asList(pkOldFile)); 
		linesOnlyNew.removeAll(linesOnlyOld);
		Set<String> tmpSet = new HashSet<String>(Arrays.asList(pkNewFile));
		linesOnlyOld.removeAll(tmpSet);
		
		readerNew.close();
		readerOld.close();
	}
	
	/**
	 * Set the first row of table
	 */
	private void writeFirstRow() {
		/** Writing table attributes to first row **/
		String[] firstNewRow = newFileContents.get(pkNewFile[0]);
		String[] firstOldRow = newFileContents.get(pkOldFile[0]);
		String[] tmpRow;
		if (firstNewRow != null && firstOldRow != null) {
			tmpRow = new String[firstNewRow.length * 3 - 1];
			tmpRow[0] = "new-" + firstNewRow[0]; // Account Name
			tmpRow[1] = "old-" + firstOldRow[0]; // Account Name
			int index = 1;
			for (int i = 2; i < tmpRow.length; i = i + 3) {
				tmpRow[i] = "new-" + firstNewRow[index];
				tmpRow[1 + i] = "old-" + firstOldRow[index];
				tmpRow[2 + i] = "diff";
				index++;
			}
			diffFile.add(tmpRow);
		}
	}
	
	/**
	 * Sets new, old, and diff values for each column
	 * @throws IOException
	 */
	private void writeDiffValues() throws IOException {
		String[] tmpRow;
		for(int i = 1; i < pkNewFile.length; i++) {
			String pkNew = pkNewFile[i];
			String[] nextNewRow = newFileContents.get(pkNew);
			String[] oldRow = oldFileContents.get(pkNew);
			tmpRow = new String[nextNewRow.length * 3 - 1];
			if(oldRow != null) {
				tmpRow[0] = nextNewRow[0];
				tmpRow[1] = oldRow[0];
				int index = 1;
				for (int j = 2; j < tmpRow.length; j = j + 3) {
					Double newValue = tryDoubleParse(nextNewRow[index]);
					Double oldValue = tryDoubleParse(oldRow[index]);
					if (newValue != null && oldValue != null) {
						double diff = newValue - oldValue;
						tmpRow[j] = newValue + "";
						tmpRow[j + 1] = oldValue + "";
						tmpRow[j + 2] = diff + "";
					}
					else {
						tmpRow[j] = nextNewRow[index] + "";
						tmpRow[j + 1] = oldRow[index] + "";
						tmpRow[j + 2] = "N/A";
					}
					index++;
				}
				diffFile.add(tmpRow);
			}
			
		}
	}
	
	private void writeMissingLines() {
		String[] onlyNew = (String[]) linesOnlyNew.toArray(new String[linesOnlyNew.size()]);
		String[] onlyOld = (String[]) linesOnlyOld.toArray(new String[linesOnlyOld.size()]);
		for(int i = 0; i < linesOnlyNew.size(); i++) {
			int index = 1;
			String[] line = newFileContents.get(onlyNew[i]);
			String[] tmp = new String[line.length * 3 - 1];
			tmp[0] = line[0];
			for(int j = 2; j < tmp.length; j = j + 3) {
				tmp[j] = line[index];
				index++;
			}
			insertLine(tmp);
		}
		for(int i = 0; i < linesOnlyOld.size(); i++) {
			int index = 1;
			String[] line = oldFileContents.get(onlyOld[i]);
			String[] tmp = new String[line.length * 3 - 1];
			tmp[0] = line[0];
			for(int j = 3; j < tmp.length; j = j + 3) {
				tmp[j] = line[index];
				index++;
			}
			insertLine(tmp);
		}
	}
	
	private void insertLine(String[] line) {
		int index = 1;
		String[] pk = line[0].split(" ");
		String[] pkDiffFile = diffFile.get(index)[0].split(" ");
		while(pk[0].compareToIgnoreCase(pkDiffFile[0]) >= 0) {
			index++;
			pkDiffFile = diffFile.get(index)[0].split(" ");;
		}
		diffFile.add(index, line);
	}
	
	public void getDiffCSV() throws IOException {
		writeFirstRow();
		writeDiffValues();
		writeMissingLines();
		writer.writeAll(diffFile);
		writer.close();
	}

	private static Double tryDoubleParse(String text) {
		try {
			return new Double(text);
		}
		catch (NumberFormatException e) {
			return (Double) null;
		}
	}
}
