package AtvHash;

public class main {
	
	public static void main(String[] args) {
		
		HashTable hash = new HashTable(10, 20, 4);
		
		System.out.println("Tamanho da tabela antes do resize: " + hash.capacidade);
		
		hash.imprime();

		hash.insere("Helton");
		hash.insere("Hilton");
		hash.insere("Clara");
		hash.insere("João");
		hash.insere("Sophia");
		hash.insere("Gabriel");
		hash.insere("Matheus");
		
//		hash.remove("Matheus");
		
		System.out.println(hash.busca("Matheus"));;
		
		


       

//        System.out.println("Tamanho da tabela após o resize: " + hash.capacidade);
    
        
        hash.imprime();
	}
	
	
}
