package order;

import java.util.Random;

public class QuickSort {
	
	
	public QuickSort() {
		
	}
	
	
	public int[] RandomArry(int size, int min, int max) {
		Random random = new Random();
		int[] arrayAleatorio = new int[size];
		
		for (int i = 0; i < arrayAleatorio.length; i++) {
			arrayAleatorio[i] = random.nextInt(min, max);
		}
		
		return arrayAleatorio;
		
	}
	
	public float quickSort30(int[] arrays) {
	    long inicio = System.currentTimeMillis();
	    quickSort(arrays, 0, arrays.length - 1);
	    long fim = System.currentTimeMillis();
	    return (fim - inicio);
	}
	
	public float quickSort30_50000(){
		float tempo = 0;
		for (int i = 0; i < 30; i++) {

			int[] randomArray = RandomArry(50000, 0, 10000);
			
			long inicio = System.currentTimeMillis();
			
			int[] arr = quickSort(randomArray, 0, randomArray.length-1);
			
			long fim = System.currentTimeMillis();
			
			tempo+= fim - inicio;
		}
		return tempo / 30;
	}
	
	public float quickSort30_100000(){
		float tempo = 0;
		for (int i = 0; i < 30; i++) {
			
			int[] randomArray = RandomArry(100000, 0, 10000);
			
			long inicio = System.currentTimeMillis();
			
			int[] arr = quickSort(randomArray, 0, randomArray.length-1);
			
			long fim = System.currentTimeMillis();
			
			tempo+= fim - inicio;
		}
		
		return tempo / 30;
		
		
	}
	
	public float quickSort30_200000(){
		float tempo = 0;
		for (int i = 0; i < 30; i++) {
			
			int[] randomArray = RandomArry(200000, 0, 10000);
			
			long inicio = System.currentTimeMillis();
			
			int[] arr = quickSort(randomArray, 0, randomArray.length-1);
			
			long fim = System.currentTimeMillis();
			
			tempo+= fim - inicio;
		}
		return tempo / 30;
	}

	public int[] quickSort(int[] vetor, int inicio, int fim) {
		if (inicio < fim) {
			int posicaoPivo = particao(vetor, inicio, fim);
			quickSort(vetor, inicio, posicaoPivo - 1);
			quickSort(vetor, posicaoPivo + 1, fim);

		}
		return vetor;
	}

	public static int particao(int[] vetor, int inicio, int fim) {
	    int meio = inicio + (fim - inicio) / 2;
	    int pivo = vetor[meio];
	    int i = inicio;
	    int j = fim;
	    
	    while (i <= j) {
	        while (vetor[i] < pivo) {
	            i++;
	        }
	        while (vetor[j] > pivo) {
	            j--;
	        }
	        if (i <= j) {
	            int temp = vetor[i];
	            vetor[i] = vetor[j];
	            vetor[j] = temp;
	            i++;
	            j--;
	        }
	    }
	    return i;
	}

	
	
}
