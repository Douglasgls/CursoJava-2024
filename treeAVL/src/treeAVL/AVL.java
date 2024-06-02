package treeAVL;

public class AVL {
	
	private No raiz;
	
	
	public AVL( int info) {
		No newRaiz = new No(info, 0 , null , null , null);
		this.raiz = newRaiz;
		return;
	}
	
	public No getRoot() {
		return raiz;
	}
	
	public void setRaiz(No raiz) {
		this.raiz = raiz;
	}
	
	private boolean empty() {
		return raiz ==  null;
	}
	
	public int altDirEsq(No atual) {
		
		int SubDireitaEsquerda = 0;
		if(atual == null || atual.getEsquerda() == null) {
		return 0;
		}else {
			SubDireitaEsquerda = altDirEsq(atual.getEsquerda()) + 1;
		}
		
		return SubDireitaEsquerda;
}
	
	public int alturaDir(No atual) {
		if(atual == null || atual.getDireita() == null) {
			return 0;
		}
		else {
        	int direita = alturaDir(atual.getDireita()) + 1;
        	
        	int subEsquerda = altDirEsq(atual.getDireita()) + 1;
        	
        	if(subEsquerda > direita) {
        		return subEsquerda;
        	}
        	else {
        		
        		return direita;
        	}
		}
		
	}
	
	public int altEsqDir(No atual) {
		
		int SubEsquerdaDireita = 0;
		if(atual == null || atual.getDireita() == null) {
			return 0;
		}else {
			SubEsquerdaDireita = altDirEsq(atual.getDireita()) + 1;
		}
		
		return SubEsquerdaDireita;
	}

	public int alturaEsq(No atual) {
		int esquerda = 0;
		if(atual == null || atual.getEsquerda() == null) {
			return 0;
		}
		else {
			esquerda = alturaEsq(atual.getEsquerda()) + 1;
			
			int subDireita = altEsqDir(atual.getEsquerda()) + 1;
        	
        	if(subDireita > esquerda) {
        		return subDireita;
        	}
        	else {
        		
        		return esquerda;
        	}
		}
		
	}

	public int fatorBalanceamento(No atual) {
		
	    if (atual == null) {
	        return 0;
	    }

	    int alturaDireita = alturaDir(atual);
	    int alturaEsquerda = alturaEsq(atual);
	    
	    return  (alturaEsquerda) - (alturaDireita) ;
		
	}
	
	public void preOrdem() {
		preOrdem(getRoot());
	}
	
	public void preOrdem(No atual) {
		if(atual != null) {
			System.out.print(atual.getInfo() + "(" +  fatorBalanceamento(atual) + ")" + ", ");
			preOrdem(atual.getEsquerda());
			preOrdem(atual.getDireita());
		}
		
	}
	
	public void rotacaoSimplesDireita(No original) {
		if (original == null ) {
			return;
		}
		
		No filhoMaisEsquerda = original.getEsquerda();
		No filhoDireitaNovaRaiz = filhoMaisEsquerda.getDireita(); 
		
//		System.out.println(filhoMaisEsquerda.getInfo());
		
		
		if(original.getPai() == null) {
			this.raiz = filhoMaisEsquerda;
		}
		
		filhoMaisEsquerda.setDireita(original);
		
		if(original.getPai() != null) {
		    if(original.getPai().getEsquerda() == original) {
		        original.getPai().setEsquerda(filhoMaisEsquerda);
		    } else {
		        original.getPai().setDireita(filhoMaisEsquerda);
		    }
		}
		filhoMaisEsquerda.setPai(original.getPai() != null ? original.getPai() : null);
		original.setPai(filhoMaisEsquerda);
		
		if(filhoDireitaNovaRaiz != null) {
			filhoDireitaNovaRaiz.setPai(original);
		}
		
		original.setEsquerda(filhoDireitaNovaRaiz);
	}
	
	public void rotacaoSimplesEsquerda(No original) {
		
		if(original == null) {
			return;
		}
		
		No filhoMaisDireita = original.getDireita();

		filhoMaisDireita.setPai(original.getPai() != null ? original.getPai() : null);
		
//		Aponta o pai do original para a novaRaiz
		if(original.getPai() != null) {
	        if(original.getPai().getEsquerda() == original) {
	            original.getPai().setEsquerda(filhoMaisDireita);
	        } else {
	            original.getPai().setDireita(filhoMaisDireita);
	        }
	    }
		else {
			this.raiz = filhoMaisDireita;
		}
		
//		Filho mais a direita vira Pai da Antiga Raiz
		original.setPai(filhoMaisDireita);
		
//		Os filho esquerdo do no mais a direita(novaRaiz) vai para a direita da antiga raiz 
		original.setDireita(filhoMaisDireita.getEsquerda());
		
//		Atualiza o pai do filho a esquerda da nova raiz para o original
		if(filhoMaisDireita.getEsquerda() != null) {
	        filhoMaisDireita.getEsquerda().setPai(original);
	    }
		
//		O filho mais a direita aponta para seu antigo pai 
		filhoMaisDireita.setEsquerda(original);

	}
	
	public void rotacaoDuplaEsquerda(No original) {
		
		rotacaoSimplesDireita(original.getDireita());
		
		rotacaoSimplesEsquerda(original);
		
		
	}
	
	private void rotacaoDuplaDireita(No original) {
		
		rotacaoSimplesEsquerda(original.getEsquerda());
		
		rotacaoSimplesDireita(original);
				
	}
	
	public void balanceamentoArvore(No original) {
		
		if(original == null){
			return; 
		}
		
		boolean isRoot = (original.getPai() == null);
		
		while(true) {
		
		 	int fb;
		 	
	        if (isRoot) {
	            fb = fatorBalanceamento(original);
	        } else {
	            fb = fatorBalanceamento(original.getPai());
	        }
	
			if(fb >= 2) {
				if(fatorBalanceamento(original.getEsquerda()) <= -1) {
					if(isRoot) {
						rotacaoDuplaDireita(original);
					}else {
						rotacaoDuplaDireita(original.getPai());
					}
				}
				
				else if(fatorBalanceamento(original) >= 1) {
					if(isRoot) {
						rotacaoSimplesDireita(original);
					}else {
						rotacaoSimplesDireita(original.getPai());
					}
				}
			}
			else if(fb <= -2) {
				
	//			Lembre do Joelho que é o motivo do balanceamento duplo
				if(fatorBalanceamento(original) >= 1) {
					if(isRoot) {
						rotacaoDuplaEsquerda(original);
					}else {
						rotacaoDuplaEsquerda(original.getPai());
					}
				}
				
				else if(fatorBalanceamento(original) <= -1) {
					if(isRoot) {
						rotacaoSimplesEsquerda(original);
					}else {
						rotacaoSimplesEsquerda(original.getPai());
					}
				}
			}
			
			if (!isRoot && original.getPai() != null) {
	            original = original.getPai();
	            isRoot = (original.getPai() == null);
	        } else {
	            break;
	        }
		}		
}
	
	public No getSucessorOrAntecessor(No original) {
		
		  if (original == null) {
		        return null;
		    }
		  
		 if(original.getDireita() == null) {
			 No antecessor = original.getEsquerda();
			 while (antecessor.getDireita() != null) {
				 antecessor = antecessor.getDireita();
			    }
				return antecessor;
		 }
		
		 No sucessor = original.getDireita();
		 
	    while (sucessor.getEsquerda() != null) {
	        sucessor = sucessor.getEsquerda();
	    }
		return sucessor;		
	}
	
	public void insere(int info) {
		
		insere(info,getRoot());
	}
	
	public void insere(int info, No original) {

		if(empty()) {
			No newNo = new No(info,0,null,null,null);
			setRaiz(newNo);
			return;
		}else if(info > original.getInfo()) {
			
			if(original.getDireita() != null) {
				insere(info, original.getDireita());
			}else {
				No newNo = new No(info,0, original,null,null);
				original.setDireita(newNo);
				No newNoRef = newNo;
				
				No novoNoPai = newNo.getPai();
				while(novoNoPai != null) {
					int novoBalanceamento = fatorBalanceamento(novoNoPai);
					novoNoPai.setBalanceamento(novoBalanceamento);
					novoNoPai = novoNoPai.getPai();
				}
				balanceamentoArvore(newNoRef);
				return;
			}
		}else {
			if(original.getEsquerda() != null) {
				 insere(info,original.getEsquerda());
			 }else {
				 No newNo = new No(info,0,original,null,null);
				 original.setEsquerda(newNo);
				 
				 No newNoRef = newNo;
				 No novoNoPai = newNo.getPai();
					while(novoNoPai != null) {
						int novoBalanceamento = fatorBalanceamento(novoNoPai);
						novoNoPai.setBalanceamento(novoBalanceamento);
						novoNoPai = novoNoPai.getPai();
					}
					balanceamentoArvore(newNoRef);
					return;
			 }
		}
	}

	
	public void remover(int info) {		
		No isNull = remover(info, this.raiz);
		
		if(isNull == null) {
			this.raiz = null;
			System.out.println("Àrvore vazia!");
			return;
		}
	}

	public No remover(int info, No original) {
		
		if(original == null) {
			return null;
		}
		if (info < original.getInfo()) {
			original.setEsquerda(remover(info, original.getEsquerda()));
		}else if (info > original.getInfo()){
			original.setDireita(remover(info,original.getDireita()));
		}else {
		  if (original.getEsquerda() == null && original.getDireita() == null) {
			  	return null;
	        }
		  else if(original.getEsquerda() == null) {
			  original.getDireita().setPai(original.getPai() != null ? original.getPai() : null);
			  if(getRoot() == original) {
				  this.raiz = original.getDireita();
			  }
			  return original.getDireita();
		  }
		  else if(original.getDireita() == null) {
			  original.getEsquerda().setPai(original.getPai() != null ? original.getPai() : null);
			  if(getRoot() == original) {
				  this.raiz = original.getEsquerda();
			  }
			  return original.getEsquerda();
		  }
		  else {
			  No  sucessor = getSucessorOrAntecessor(original);
			  
			  original.setInfo(sucessor.getInfo());
			  original.setDireita(remover(sucessor.getInfo(),original.getDireita()));
			  
		  }
		}
		
		balanceamentoArvore(original);
		
		return original;
		
	}



}


