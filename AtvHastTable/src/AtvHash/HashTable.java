package AtvHash;

import java.util.LinkedList;

public class HashTable {
	
	public LinkedList<String>[] tabela;
	public int size;
	public int capacidade;
	public int margem; 
	public int MediaElementos;
	
	
	public HashTable(int n, int margem, int a) {
		this.margem = margem;
		this.capacidade = n /a;
		this.tabela = new LinkedList[capacidade];
		for (int i = 0; i < capacidade; i++) {
			tabela[i] = new LinkedList<>();
		}
		this.size = 0;
		this.MediaElementos = a;
	}
		
	public int hash(String k) {
		int hash = 1;
		for (int i = 0; i < k.length(); i++) {
			hash = hash + k.charAt(i) * (i + 1);
		}
		return Math.abs(hash) % capacidade;
	}
	
	public void remonta() {
		int novaCapacidade = capacidade * 2;
		@SuppressWarnings("unchecked")
		LinkedList<String>[] novaTabela = new LinkedList[novaCapacidade];
		
		for (int i = 0; i < novaCapacidade; i++) {
			novaTabela[i] = new LinkedList<>();
		}
		
		this.capacidade = novaCapacidade;
		
		for (int i = 0; i < tabela.length; i++) {
	        for (String str : tabela[i]) {
	            int novaPosicao = hash(str);
	            novaTabela[novaPosicao].add(str);
	        }
	    }
		
		
		
		
		this.tabela = novaTabela;
		
		
	}
	
	public void insere(String k) {
		int posicaoK = hash(k);
		
		if(!tabela[posicaoK].contains(k)) {
			tabela[posicaoK].add(k);
			size++;
		}
		
		int elementosPorPosicao = (int) (MediaElementos * (1 + (margem / 100.0)));
		
		
		for (int i = 0; i < tabela.length; i++) {
			if(tabela[i].size() >= elementosPorPosicao) {
				remonta();
				break;
			}
		}
	}
	
	public boolean busca(String k) {
		int posicao = hash(k);
		
		if(tabela[posicao].contains(k)) {
			return true;
		}
		return false;
	}
	
	public void remove(String k) {
		int posicao = hash(k);
		
		if(tabela[posicao].contains(k)) {
			tabela[posicao].remove(k);
			size--;
		}
	}
	
	public void imprime() {
		for (int i = 0; i < tabela.length; i++) {
			System.out.println(tabela[i] );
			
		}
	}
	
}
