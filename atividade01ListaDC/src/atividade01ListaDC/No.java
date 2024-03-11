package atividade01ListaDC;

public class No {
	private int valor;
	private No proximo;
	private No anterior;
	
	public No() {}

	public No(int valor, No proximo, No anterior) {
		super();
		this.valor = valor;
		this.proximo = proximo;
		this.anterior = anterior;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public No getProximo() {
		return proximo;
	}

	public void setProximo(No proximo) {
		this.proximo = proximo;
	}

	public No getAnterior() {
		return anterior;
	}

	public void setAnterior(No anterior) {
		this.anterior = anterior;
	};
}
