package AtvHash;

import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

class teste {

	@Test
	void test() {
		HashTable hashtable = new HashTable(10,20,5);
		
		hashtable.insere("Douglas");
		hashtable.insere("João");
		hashtable.insere("Maria");
		hashtable.insere("Pedro");
		hashtable.insere("Sara");
		
		assertEquals(true, hashtable.busca("Douglas"));
		assertEquals(true, hashtable.busca("Maria"));
		assertEquals(true, hashtable.busca("Pedro"));
	}
	
	@Test
	void test02() {
		// Adiciona mais do que o esperado, deve retornar o uma nova capacidade dobrada.
		HashTable hashtable = new HashTable(10,20,5);
		
		hashtable.insere("Douglas");
		hashtable.insere("João");
		hashtable.insere("Maria");
		hashtable.insere("Pedro");
		hashtable.insere("Sara");
		
		hashtable.insere("lara");
		hashtable.insere("Silvio");
		hashtable.insere("Vitoria");
		hashtable.insere("kaio");
		hashtable.insere("silva");
		
		//  m = 10/5 = 2, tendo uma mergem de 20% de 5 = 1 quando Lucia for adicionada seu valor de 10 deve dobra
		hashtable.insere("Lucia");
		
		assertEquals(4, hashtable.capacidade);
	}
	
	@Test
	void test03() {
		HashTable hashtable = new HashTable(10,20,5);
		
		hashtable.insere("Douglas");
		hashtable.insere("João");
		hashtable.insere("Maria");
		hashtable.insere("Pedro");
		hashtable.insere("Sara");
		hashtable.insere("Claudia");
		hashtable.insere("Marcos");
		hashtable.insere("mango");
		hashtable.insere("Marcia");
		hashtable.insere("Suelen");
		
		hashtable.remove("Sara");
		
		assertEquals(false, hashtable.busca("Sara"));
	}
	
	
	@Test
	void testeInsercao500Hastable() {
		HashTable hash = new HashTable(500,20,100);
		
		long tempoInicial = System.nanoTime();

		for (int i = 0; i < 500; i++) {
			hash.insere("Elemento"+i);
		}
		
		long tempoFinal = System.nanoTime();
		
		float tempoExecucao = (tempoFinal - tempoInicial) / 1_000_000.0f;
		
		System.out.println("Tempo de inserção para 500 elementos no HashTable: " + tempoExecucao + " ms");
		
	}
	
	@Test
	void testInsercao500ElementosHashMap() {
	    HashMap<Integer, String> hashMap = new HashMap<>();

	    long tempoInicial = System.nanoTime();

	    for (int i = 0; i < 500; i++) {
	        String elemento = "Elemento" + i;  
	        hashMap.put(i, elemento);
	    }

	    long tempoFinal = System.nanoTime();  
	    
	    float tempoExecucao = (tempoFinal - tempoInicial) / 1_000_000.0f; 
	    System.out.println("Tempo de inserção para 500 elementos no HashMap: " + tempoExecucao + " ms");
	}
	
	@Test
	void testeremocao5000Hastable() {
		HashTable hash = new HashTable(5000,20,1000);
		

		for (int i = 0; i < 5000; i++) {
			hash.insere("Elemento"+i);
		}
		
		long tempoInicial = System.nanoTime();
		for (int i = 0; i < 5000; i++) {
			hash.remove("Elemento"+i);
		}
		
		long tempoFinal = System.nanoTime();
		
		float tempoExecucao = (tempoFinal - tempoInicial) / 1_000_000.0f;
		
		System.out.println("Tempo de remoção para 500 elementos no HashTable: " + tempoExecucao + " ms");
		
	}
	
	@Test
	void testRemocao5000ElementosHashMap() {
	    HashMap<Integer, String> hashMap = new HashMap<>();


	    for (int i = 0; i < 5000; i++) {
	        String elemento = "Elemento" + i;  
	        hashMap.put(i, elemento);
	    }
	    
	    long tempoInicial = System.nanoTime();
	    

	    for (int i = 0; i < 5000; i++) {
	        hashMap.remove(i); 
	    }

	    long tempoFinal = System.nanoTime();  
	    
	    float tempoExecucao = (tempoFinal - tempoInicial) / 1_000_000.0f; 
	    System.out.println("Tempo de remoção para 500 elementos no HashMap: " + tempoExecucao + " ms");
	}
	
	@Test
	void testeBuscaHastable() {
		HashTable hash = new HashTable(5000,20,1000);
		

		for (int i = 0; i < 5000; i++) {
			hash.insere("Elemento"+i);
		}
		
		long tempoInicial = System.nanoTime();
		
		boolean test = hash.busca("Elemento499");
		
		long tempoFinal = System.nanoTime();
		
		float tempoExecucao = (tempoFinal - tempoInicial) / 1_000_000.0f;
		
		System.out.println("Tempo de busca para 500 elementos no HashTable: " + tempoExecucao + " ms " + "Encontrou  o elemento ? " + test );
		
	}
	
	@Test
	void testeBuscaHashMap() {
	    HashMap<Integer, String> hashMap = new HashMap<>();

	    for (int i = 0; i < 5000; i++) {
	        hashMap.put(i, "Elemento" + i);
	    }

	    long tempoInicial = System.nanoTime();

	    boolean test = hashMap.containsValue("Elemento499");

	    long tempoFinal = System.nanoTime();

	    float tempoExecucao = (tempoFinal - tempoInicial) / 1_000_000.0f;

	    System.out.println("Tempo de busca para 5000 elementos no HashMap: " + tempoExecucao + " ms " + "Encontrou o elemento? " + test);
	}

	

}
