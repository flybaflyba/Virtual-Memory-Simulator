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
			System.out.println(string);
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
		
//		for(PageTableEntry p:memory.pageTableEntries) {
//			System.out.println(p);
//		}
//		
		
		ArrayList<String> data = new ArrayList<>();
		
		data = readFile("C:/fall2020classes/cs415/VirtualMemory/bin/vm/VMInput1.txt");
		System.out.println(data);
		

		
		
		
	}

}
