package demos;

import java.util.List;

import utilities.Excel;

public class DataReaders {

	public static void main(String[] args) {
		//readCSV();
		readXLS();

	}
	
	public static void readCSV() {
		String filename = "/Users/smyung/Documents/JavaProject/UserAccounts.csv";
		List <String[]> records = utilities.CSV.get(filename);
		
		// Iterating through the list
		for (String[] record : records) {
			for (String field : record) {
				System.out.println(field);
			}
		}
	}
	
	public static void readXLS() {
		
		String filename = "/Users/smyung/Documents/JavaProject/logIn.xls";
		String[][] data = Excel.get(filename);
		for (String[] record : data) {
			System.out.println("\nNEW RECORD");
			System.out.println(record[0]);
			System.out.println(record[1]);
			System.out.println(record[2]);
		}
	}

}
