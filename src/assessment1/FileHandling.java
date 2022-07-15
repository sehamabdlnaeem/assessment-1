package assessment1;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class FileHandling {

	static final String filePath = "/Users/sehamabdlnaeem/Desktop/simplilearn-JAVA/Assessments/assessment-1/files/";

	public void addFile(Scanner sc) {
		System.out.println("Please type the file name\n");
		String fileNameInput = sc.next();
		fileNameInput = new String(fileNameInput.concat(".txt"));
		File file = new File(filePath + fileNameInput);
		try {
			file.createNewFile();
			System.out.println("File Name:  " + file.getName() + " has been created successfully");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public void searchFile(Scanner sc, String[] pathnames) {
		System.out.println(
				"Please type the name of the file you want to search for with extension (from the list below): \n");
		for (String path : pathnames) {
			System.out.println(path);
		}
		String input = sc.next();
		input = new String(input.toLowerCase());

			File file = new File(filePath + input);
			if(file.exists()) {
				System.out.println("\n" + file.getName() + " file exists ");
			}else {
				System.out.println("\n" + file.getName() + " file does not exists ");
			}
		}

	

	public void deleteFile(Scanner sc, String[] pathnames) {
		System.out.println(
				"Please type the name of the file you want to delete with extension (from the list below): \n");

		for (String path : pathnames) {
			System.out.println(path);
		}
		String input = sc.next();
		File file = new File(filePath + input);

		try {

			if (file.delete()) {
				System.out.println(file.getName() + " has been deleted successfully");

			} else {
				System.out.println(" File not available");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String args[]) {
		// variables
		String[] pathnames = null;

		Scanner sc = new Scanner(System.in);

		// create an object of Main
		FileHandling FileHandlingObject = new FileHandling();

		// file
		File file = new File(filePath);
		pathnames = file.list();

		System.out.println("\n\t	WELCOME");

		int userInput = 0;
		while (userInput != 3) {
			System.out.println(
					"\nPlease select from the options below:\n 1. Return Current files\n 2. Return details\n 3. Exit");
			System.out.println("PLEASE TYPE '1', '2' or '3'\n");
			userInput = sc.nextInt();
			if (userInput == 1) {
				Arrays.sort(pathnames);
				try {
					for (String path : pathnames) {
						System.out.println(path);
					}
				} catch (NullPointerException er) {
					System.out.print(er);
				}
			} else if (userInput == 3) {
				break;
			} else if (userInput == 2) {
				int input;
				System.out.println(
						"\nPlease select from the options below:\n 1. Add a file\n 2. Delete a file\n 3. Search for a file\n 4. Go back");
				System.out.println("PLEASE TYPE '1', '2' or '3' or '4'\n");
				input = sc.nextInt();
				if (input == 1) {
					FileHandlingObject.addFile(sc);
				} else if (input == 2) {
					FileHandlingObject.deleteFile(sc, pathnames);
				} else if (input == 3) {
					FileHandlingObject.searchFile(sc, pathnames);
				}

			} else {
				System.out.print("PLEASE TYPE AGAIN \n");
			}
		}
	}

}
