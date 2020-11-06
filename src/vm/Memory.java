package vm;


public class Memory {
	
	PageTableEntry[] pageTableEntries = new PageTableEntry[30]; 
	int at = 0;
	

	public Memory() {
		// TODO Auto-generated constructor stub
	}
	
	public void getFreePageFrame(PageTableEntry pageTableEntry) {
		System.out.println("memory is at this position: " + Integer.toString(at));
		
		if(pageTableEntries[at] != null) {
			System.out.println("kick out the old one");
			pageTableEntries[at].inMemory = false; // kick out old one 
		}
		pageTableEntries[at] = pageTableEntry; // set to the new one
		
		// round robin method 
		if (at == 29) {
			at = 0;
		} else {
			at ++;
		}
		
	}

}
