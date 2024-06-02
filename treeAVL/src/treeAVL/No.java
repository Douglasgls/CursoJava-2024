package treeAVL;

public class No {

	private int info;
	private int balanceamento;
	private No pai;
	private No direita;
	private No esquerda;
	
	public No() {}

	public No(int info, int balanceamento, No pai, No direita, No esquerda) {
		this.info = info;
		this.balanceamento = balanceamento;
		this.pai = pai;
		this.direita = direita;
		this.esquerda = esquerda;
	}



	public int getInfo() {
		return info;
	}


	public void setInfo(int info) {
		this.info = info;
	}


	public int getBalanceamento() {
		return balanceamento;
	}


	public void setBalanceamento(int balanceamento) {
		this.balanceamento = balanceamento;
	}


	public No getPai() {
		return pai;
	}


	public void setPai(No pai) {
		this.pai = pai;
	}


	public No getDireita() {
		return direita;
	}


	public void setDireita(No direita) {
		this.direita = direita;
	}


	public No getEsquerda() {
		return esquerda;
	}


	public void setEsquerda(No esquerda) {
		this.esquerda = esquerda;
	}
	
	
	
	
	
	
}
