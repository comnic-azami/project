package jp.co.comnic.lesson.azami;

import java.util.Arrays;

public class SortExample {
	public static void main(String[] args) {
		int[] array = { 10,9,8,7,6,5,4,3,2,1 };
		
		System.out.print("スタート　");
		System.out.println(Arrays.toString(array));
		
		insertionSort(array);
		System.out.print("終了　");
		System.out.println(Arrays.toString(array));
//
//		bubleSort(array);
//
//		System.out.println(Arrays.toString(array));

	}
	private static void insertionSort(int[] array) {
        for (int j = 1; j < array.length; j++) {
            int key = array[j];
            int i = j - 1;
            for (i=j - 1; i>= 0 && array[i] > key;i--) {
                array[i + 1] = array[i];
                
            }
            array[i + 1] = key;
            System.out.println(Arrays.toString(array));
        }
        System.out.println(Arrays.toString(array));
	}

	private static void bubleSort(int[] array) {

		for (int i = array.length; i > 0; i--) {
			for (int j = 0; j < i-1; j++) {
				if (array[j] > array[j + 1]) {
					swap(array, j);
				}
			}
			System.out.println(Arrays.toString(array));
		}

	}

	private static void swap(int[] array, int j) {
		int stac;
		stac = array[j];
		array[j] = array[j + 1];
		array[j + 1] = stac;
	}

}
