package treeAVL;

public class main {

	public static void main(String[] args) {
		
		
		AVL arvoreAVL = new AVL(50);
		
		arvoreAVL.insere(40);
		arvoreAVL.insere(60);
		arvoreAVL.insere(30);
		arvoreAVL.remover(40);
		arvoreAVL.insere(45);
		arvoreAVL.remover(60);
		arvoreAVL.remover(50);
		arvoreAVL.remover(45);
		arvoreAVL.remover(30);

		
		arvoreAVL.preOrdem();
		
	}

}
