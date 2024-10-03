package order;

import java.util.Random;

public class MergeSort {
	
	
	public int[] RandomArry(int size, int min, int max) {
		Random random = new Random();
		int[] arrayAleatorio = new int[size];
		
		for (int i = 0; i < arrayAleatorio.length; i++) {
			arrayAleatorio[i] = random.nextInt(min, max);
		}
		
		return arrayAleatorio;
		
	}
	
	
	public float mergeSort30(int[] randomArray){
		long inicio = System.currentTimeMillis();
		int[] arr = sort(randomArray, 0, randomArray.length-1);
		long fim = System.currentTimeMillis();
		return (fim - inicio);
	}
	
	public float mergeSort30_50000(){
		float tempo = 0;
		for (int i = 0; i < 30; i++) {

			int[] randomArray = RandomArry(50000, 0, 10000);
			
			long inicio = System.currentTimeMillis();
			
			int[] arr = sort(randomArray, 0, randomArray.length-1);
			
			long fim = System.currentTimeMillis();
			
			tempo+= fim - inicio;
		}
		return tempo / 30;
	}
	
	public float mergeSort30_100000(){
		float tempo = 0;
		for (int i = 0; i < 30; i++) {
			
			int[] randomArray = RandomArry(100000, 0, 10000);
			
			long inicio = System.currentTimeMillis();
			
			int[] arr = sort(randomArray, 0, randomArray.length-1);
			
			long fim = System.currentTimeMillis();
			
			tempo+= fim - inicio;
		}
		return tempo / 30;
	}
	
	public float mergeSort30_200000(){
		float tempo = 0;
		for (int i = 0; i < 30; i++) {
			
			int[] randomArray = RandomArry(200000, 0, 10000);
			
			long inicio = System.currentTimeMillis();
			
			int[] arr = sort(randomArray, 0, randomArray.length-1);
			
			long fim = System.currentTimeMillis();
			
			tempo+= fim - inicio;
		}
		return tempo / 30;
	}
	
	public int[] sort(int vetor[], int low, int high){
        if (low < high) {
            int m = (low + high) / 2;

            sort(vetor, low, m);
            sort(vetor, m + 1, high);

            merge(vetor, low, m, high);
        }
        return vetor;
    }
	
	static void merge(int arr[], int low, int middle, int high){
		
        int leftSize = middle - low + 1;
        int rigthSize = high - middle;

        int left[] = new int[leftSize];
        int rigth[] = new int[rigthSize];

        for (int i = 0; i < leftSize; ++i)
            left[i] = arr[low + i];
        for (int j = 0; j < rigthSize; ++j)
            rigth[j] = arr[middle + 1 + j];

        int i = 0, j = 0;

        int k = low;
        while (i < leftSize && j < rigthSize) {
            if (left[i] <= rigth[j]) {
                arr[k] = left[i];
                i++;
            }
            else {
                arr[k] = rigth[j];
                j++;
            }
            k++;
        }

        while (i < leftSize) {
            arr[k] = left[i];
            i++;
            k++;
        }

        while (j < rigthSize) {
            arr[k] = rigth[j];
            j++;
            k++;
        }
    }
	
}
