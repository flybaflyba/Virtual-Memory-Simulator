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
		
		PageTableEntry pte = new PageTableEntry(false, false);
		
		System.out.println(pte.inMemory);
		
		Memory memory = new Memory();
		
//		for(PageTableEntry p : memory.pageTableEntries) {
//			System.out.println(p);
//		}
//		
		ArrayList<String> data = new ArrayList<>();
		data = readFile("C:/fall2020classes/cs415/VirtualMemory/bin/vm/VMInput1.txt");
		
//		System.out.println(data);
		
		ArrayList<ArrayList<PageTableEntry>> pageTables = new ArrayList<>();
		pageTables.add(null);
		
		for(String s : data) {
			String[] line = s.split(" ");
			if(line[0].equals("new")) {
				System.out.println("***************************\n new page table create at index before: " + line[1]);
				ArrayList<PageTableEntry> pageTable = new ArrayList<>();
				for(int i=0; i<64;i++) {
					pageTable.add(new PageTableEntry(false, false));
				}
				pageTables.add(pageTable);
				System.out.println("create a page table with size: " + Integer.toString(pageTable.size()));
				
			} else if (line[0].equals("switch")) {
				System.out.println("***************************\n switch page table to index before: " + line[1]);
			} else if (line[0].equals("access")) {
				System.out.println("access attempt: " + line[1]);
			} else {
				System.out.println("Unknown token");
			}
			
		}
		
		System.out.println("Total page tables: " + Integer.toString(pageTables.size()));
		
		System.out.println(pageTables.get(1).get(0));
		
	}

}
