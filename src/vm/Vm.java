package vm;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Vm {

	private static ArrayList<String> readFile(String file) throws IOException {	
		ArrayList<String> data = new ArrayList<>();
		
		FileInputStream fileInputStream = new FileInputStream(file);
		InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		String string = "";
		while((string = bufferedReader.readLine()) != null) {
//			System.out.println(string);
			data.add(string);
		}
		bufferedReader.close();
		
		return data;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Aloha Virtual Memory");
		
		Memory memory = new Memory();
		
//		for(PageTableEntry p : memory.pageTableEntries) {
//			System.out.println(p);
//		}
//		
		ArrayList<String> data = new ArrayList<>();
		data = readFile("C:/fall2020classes/cs415/VirtualMemory/VMInput.txt");
		
//		System.out.println(data);
		
		// this is a collection of all page tables 
		ArrayList<ArrayList<PageTableEntry>> pageTables = new ArrayList<>();
		pageTables.add(null); // add a null at index 0, so that we can just use the number after new to be the index of the new page table
		
		// this is the current page table being used 
		ArrayList<PageTableEntry> currentPageTable = new ArrayList<>();
	
		
		for(String s : data) {
			String[] line = s.split(" ");
			if(line[0].equals("new")) {
				System.out.println("***************************\n new page table create at index: " + line[1]);
				ArrayList<PageTableEntry> pageTable = new ArrayList<>();
				for(int i=0; i<64;i++) {
					pageTable.add(new PageTableEntry(false, false));
				}
				pageTables.add(pageTable);
				System.out.println(" create a page table with size: " + Integer.toString(pageTable.size()));
				
			} else if (line[0].equals("switch")) {
				System.out.println("***************************\n switch page table to index: " + line[1]);
				currentPageTable = pageTables.get(Integer.parseInt(line[1]));
				System.out.println(" (find current page table in page tables list:) \n we are at page table index: " + Integer.toString(pageTables.indexOf(currentPageTable)));
			} else if (line[0].equals("access")) {
//				System.out.println("access attempt: " + line[1]);
			} else {
				System.out.println("Unknown token");
			}
			
			
			
			
		}
		
		System.out.println("Total page tables: " + Integer.toString(pageTables.size()));
		
	
		
	}

}
