package order;

import java.util.Random;

public class BubbleSort {
	
	public BubbleSort() {}
	
	public int[] RandomArry(int size, int min, int max) {
		Random random = new Random();
		int[] arrayAleatorio = new int[size];
		
		for (int i = 0; i < arrayAleatorio.length; i++) {
			arrayAleatorio[i] = random.nextInt(min, max);
		}
		return arrayAleatorio;
	}
	
	public float bubbleSort30(int[] randomArray){
		long inicio = System.currentTimeMillis();
		int[] arr = bubbleSort(randomArray);
		long fim = System.currentTimeMillis();
		return ( fim - inicio);
	}
	
	public float bubbleSort30_50000(){
		float tempo = 0;
		for (int i = 0; i < 30; i++) {

			int[] randomArray = RandomArry(50000, 0, 10000);
			
			long inicio = System.currentTimeMillis();
			
			int[] arr = bubbleSort(randomArray);
			
			long fim = System.currentTimeMillis();
			
			tempo+= fim - inicio;
		}
		return tempo / 30;
	}
	
	public float bubbleSort30_100000(){
		float tempo = 0;
		for (int i = 0; i < 30; i++) {
			
			int[] randomArray = RandomArry(100000, 0, 10000);
			
			long inicio = System.currentTimeMillis();
			
			int[] arr = bubbleSort(randomArray);
			
			long fim = System.currentTimeMillis();
			
			tempo+= fim - inicio;
		}
		return tempo / 30;
	}
	
	public float bubbleSort30_200000(){
		float tempo = 0;
		for (int i = 0; i < 30; i++) {
			
			int[] randomArray = RandomArry(200000, 0, 10000);
			
			long inicio = System.currentTimeMillis();
			
			int[] arr = bubbleSort(randomArray);
			
			long fim = System.currentTimeMillis();
			
			tempo+= fim - inicio;
		}
		return tempo / 30;
	}
	
	public int[] bubbleSort(int vetor[]) {
		
		int tamanho = vetor.length;
		for (int i = 0; i < vetor.length; i++) {
			for (int j = 0; j < (tamanho - i - 1); j++) {
				if(vetor[j] > vetor[j+1]) {
					int temp = vetor[j];
					vetor[j] = vetor[j+1];
					vetor[j+1] = temp;
				}
			}
		}
		return vetor;
	}
	
}
