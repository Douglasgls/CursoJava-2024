package Resumo;

public class ListaLigada {
	
	No ref;
	
	
	public ListaLigada() {
		
	}
	
	public void insere(int info) {
		
		No newInfo = new No(info,null);
		
		if(ref != null) {			
			No atual = ref;
			No atualMenos1 = null;
			do {
				if(info <= atual.getInfo()) {
					newInfo.setProx(atual);
					atualMenos1.setProx(newInfo);
					if(atual == ref) {
						ref = newInfo;
						return;
					}
				}
				atual = atual.getProx();
				atualMenos1 = atual;
			}while(atual != null && atual.getProx().getInfo() < info);
			
			
		}
		else {
			ref = newInfo;
		}
	}
	
	
	public void imprimir() {
		if(ref == null) {
			System.out.println("Lista vazia");
			return;
		}else {
			No atual = ref;
			do {
				System.out.println(atual.getInfo());
				atual = atual.getProx();
			}while(atual != null);
		}
		
	}
	

}
