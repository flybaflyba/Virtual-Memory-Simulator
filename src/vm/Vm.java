package vm;

public class Vm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Aloha Virtual Memory");
		
		PageTableEntry pte = new PageTableEntry(false, false);
		
		System.out.println(pte.inMemory);
		
		Memory memory = new Memory();
		
		
		for(PageTableEntry p:memory.pageTableEntries) {
			System.out.println(p);
		}
		
	}

}
