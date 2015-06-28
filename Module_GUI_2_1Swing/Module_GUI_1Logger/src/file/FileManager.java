package file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileManager {

	// ATTRIBUTES
	private Scanner scan;

	// FILES TO READ
	private String fileToRead_Left;
	private String fileToRead_Right;

	// FILES TO WRITE
	private String fileToWrite_Left;
	private String fileToWrite_Right;

	// LEFT JTABLE
	private ArrayList<String> listRowsFromFile_Left = new ArrayList<String>();
	private ArrayList<String> listRowsPrintToFile_Left = new ArrayList<String>();

	// RIGHT JTABLE
	private ArrayList<String> listRowsFromFile_Right = new ArrayList<String>();
	private ArrayList<String> listRowsPrintToFile_Right = new ArrayList<String>();

	// OPEN FILE
	public void open() {

		try {
			scan = new Scanner(new File(
					"/home/atafs/Downloads/CCMAgent_args[0].txt"));
		} catch (Exception e) {
			System.err.println("ERROR TEST: NOT WORKING");
		}
	}

	// OPEN FILE
	public void open(String fileToRead) {
		try {
			scan = new Scanner(new File(fileToRead));
		} catch (Exception e) {
			System.err.println("ERROR TEST: NOT WORKING");
		}
	}

	// READ FROM FILE AND RETURN A LIST WITH ITS VALUES
	public ArrayList<String> read(ArrayList<String> listRowsFromFile) {
                
                //CLEAN THE LIST
               for (int i = 0; i < listRowsFromFile.size(); i++) {
                   listRowsFromFile.remove(listRowsFromFile.get(i));
                }
               
               //ADD DATA TO THE LIST
		do {
                    listRowsFromFile.add(scan.next());
		} while (scan.hasNext());

		System.out.println("SUCCESS: SCANNING AND LIST THE FILE...");
		scan.close();
		return listRowsFromFile_Left;
	}

	// WRITE TO FILE
	public void writeToFile(String fileToWrite) {
		try {

			File file = new File(fileToWrite);

			// CHECK IF FILE EXISTS
			if (!file.exists()) {
				file.createNewFile();
			}

			// WRITE TO FILE
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);

			for (int i = listRowsPrintToFile_Left.size() - 1; i >= 0; i--) {
				bw.write(listRowsPrintToFile_Left.get(i));
				bw.write("\n"); // paragraph
			}
			bw.close();
			listRowsPrintToFile_Left.removeAll(listRowsPrintToFile_Left);

			System.out.println("SUCCESS: PRINTING TO FILE...");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// GETTERS AND SETTERS
	public ArrayList<String> getListRowsFromFile_Left() {
		return listRowsFromFile_Left;
	}

	public ArrayList<String> getListRowsPrintToFile_Left() {
		return listRowsPrintToFile_Left;
	}

	public ArrayList<String> getListRowsFromFile_Right() {
		return listRowsFromFile_Right;
	}

	public ArrayList<String> getListRowsPrintToFile_Right() {
		return listRowsPrintToFile_Right;
	}

	public String getFileToWrite_Left() {
		return fileToWrite_Left;
	}

	public void setFileToWrite_Left(String fileToWrite_Left) {
		this.fileToWrite_Left = fileToWrite_Left;
	}

	public String getFileToWrite_Right() {
		return fileToWrite_Right;
	}

	public void setFileToWrite_Right(String fileToWrite_Right) {
		this.fileToWrite_Right = fileToWrite_Right;
	}

	public String getFileToRead_Left() {
		return fileToRead_Left;
	}

	public void setFileToRead_Left(String fileToRead_Left) {
		this.fileToRead_Left = fileToRead_Left;
	}

	public String getFileToRead_Right() {
		return fileToRead_Right;
	}

	public void setFileToRead_Right(String fileToRead_Right) {
		this.fileToRead_Right = fileToRead_Right;
	}

}
