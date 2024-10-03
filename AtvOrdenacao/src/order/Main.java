package order;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		BubbleSort bubbleSort = new BubbleSort();
		QuickSort quickSort = new QuickSort();
		MergeSort mergeSort = new  MergeSort();
		
		float qs50k = 0;
		float qs100k = 0;
		float qs200k = 0;
		
		float ms50k = 0;
		float ms100k = 0;
		float ms200k = 0;
		
		float bs50k = 0;
		float bs100k = 0;
		float bs200k = 0;
				
		float tempo_qs_50000 = 0;
		float tempo_qs_100000 = 0;
		float tempo_qs_200000 = 0;
		
		float tempo_ms_50000 = 0;
		float tempo_ms_100000 = 0;
		float tempo_ms_200000 = 0;
		
		float tempo_bs_50000 = 0;
		float tempo_bs_100000 = 0;
		float tempo_bs_200000 = 0;
        
        // 50000
		for (int i = 0; i < 30; i++) {
			int[] randomArray50000 = RandomArry(50000, 0, 10000);
			ms50k = mergeSort.mergeSort30(randomArray50000);
			qs50k = quickSort.quickSort30(randomArray50000);
			bs50k = bubbleSort.bubbleSort30(randomArray50000);
			tempo_qs_50000 += qs50k;
			tempo_ms_50000 += ms50k;
			tempo_bs_50000+=bs50k;
			
		}
		
//		// 100000 
		for (int i = 0; i < 30; i++) {
			int[] randomArray100000 = RandomArry(100000, 0, 10000);
			ms100k = mergeSort.mergeSort30(randomArray100000);
			qs100k = quickSort.quickSort30(randomArray100000);
			bs100k = bubbleSort.bubbleSort30(randomArray100000);
			tempo_qs_100000 += qs100k;
			tempo_ms_100000 += ms100k;
			tempo_bs_100000 += bs100k;
		}
		
		// 200000 
		for (int i = 0; i < 30; i++) {
			int[] randomArray200000 = RandomArry(200000, 0, 10000);
			ms200k = mergeSort.mergeSort30(randomArray200000);
			qs200k = quickSort.quickSort30(randomArray200000);
			bs200k = bubbleSort.bubbleSort30(randomArray200000);
			tempo_qs_200000 += qs200k;
			tempo_ms_200000 += ms200k;
			tempo_bs_200000 += bs200k;
			
		}
		
		
		System.out.println("Tempo médio do QuickSort com um array aleatório de tamanho 50.000 30x: " + tempo_qs_50000/30 + " milissegundos");
		System.out.println("Tempo médio do QuickSort com um array aleatório de tamanho 100.000 30x: " + tempo_qs_100000/30 + " milissegundos");
		System.out.println("Tempo médio do QuickSort com um array aleatório de tamanho 200.000 30x: " + tempo_qs_200000/30 + " milissegundos");
		
		System.out.println();
		
		System.out.println("Tempo médio do MergeSort com um array aleatório de tamanho 50.000 30x: " + tempo_ms_50000/30 + " milissegundos");
		System.out.println("Tempo médio do MergeSort com um array aleatório de tamanho 100.000 30x: " + tempo_ms_100000/30 + " milissegundos");
		System.out.println("Tempo médio do MergeSort com um array aleatório de tamanho 200.000 30x: " + tempo_ms_200000/30 + " milissegundos");

		System.out.println();
		
		System.out.println("Tempo médio do BubbleSort com um array aleatório de tamanho 50.000 30x: " + tempo_bs_50000/30 + " milissegundos");
		System.out.println("Tempo médio do BubbleSort com um array aleatório de tamanho 100.000 30x: " + tempo_bs_100000/30 + " milissegundos");
		System.out.println("Tempo médio do BubbleSort com um array aleatório de tamanho 200.000 30x: " + tempo_bs_200000/30 + " milissegundos");
	
	}
	public static int[] RandomArry(int size, int min, int max) {
		Random random = new Random();
		int[] arrayAleatorio = new int[size];
		
		for (int i = 0; i < arrayAleatorio.length; i++) {
			arrayAleatorio[i] = random.nextInt(min, max);
		}
		
		return arrayAleatorio;
		
	}
};


