package atividade01ListaDC;

public class Main {

	public static void main(String[] args) {
		Lista Lista = new Lista();
		

		Lista.insere(5);
		Lista.insere(4);
		Lista.insere(3);
		Lista.insere(2);
		Lista.insere(1);
		System.out.println(Lista.imprime());
		Lista.remove(5,false);
		Lista.remove(4,false);
		Lista.remove(3,false);
		Lista.remove(2,false);
		Lista.remove(1,false);
		System.out.println(Lista.imprime());
		
		
		

	
		

	}

}
