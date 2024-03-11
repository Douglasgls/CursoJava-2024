package atividade01ListaDC;


public class Lista {
	
	private No ref;
	
	
	
	public Lista() {}
	
	
	public void insere(int info) {
		if(ref == null) { 
			No newNo = new No(info,null,null);
			newNo.setAnterior(newNo);
			newNo.setProximo(newNo);
			ref = newNo;
		}else {
			No newNo = new No(info,ref,ref.getAnterior());
			ref.getAnterior().setProximo(newNo);
			ref.setAnterior(newNo);
			ref = newNo;
		}
	}
	
	public String imprime() {
		if(ref == null) {
			return "lista vazia";
		} 
		
	    StringBuilder builder = new StringBuilder();
	    No atual = ref;
	    
	    
	    builder.append("Sentido normal:");
	    do {
	        builder.append(atual.getValor()).append(" ");
	        atual = atual.getProximo();
	    } while (atual != ref);
	    
	    builder.append("  Sentido contrário:");
	    atual = ref.getAnterior();
	    do {
	        builder.append(atual.getValor()).append(" ");
	        atual = atual.getAnterior();
	    } while (atual != ref.getAnterior());
	    
	    return builder.toString();
	    
	
	}
	
	public void remove(int info, boolean duplicados) {
		
		No atual = ref;

		do {
			
			if(atual == null) {
				break;
			}
			
			if(atual.getProximo() == ref && atual.getAnterior() == ref || atual == null ) {
				ref = null;
				return;
			}
			if (atual.getValor() == info) {
				
				if (atual == ref) {
				    ref.getAnterior().setProximo(atual.getProximo());
				    ref.getProximo().setAnterior(atual.getAnterior());
				    ref = atual.getProximo();
				} else {
					atual.getProximo().setAnterior(atual.getAnterior());
					atual.getAnterior().setProximo(atual.getProximo());
				}
					
				if (!duplicados) {
			        return;
				}
			}
			
			atual = atual.getProximo();
			
		}while(atual != ref);
		
			
			

		
		
	}
}
