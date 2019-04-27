package algos;

public class SortintAlgos {

	public static void main(String[] args) {

		int a[] = {3,8,2,4,5,7,1,6,4};
		printArr(a);
		//quickSort(a, 0, a.length-1);
		mergeSort(a, 0, a.length-1);
		printArr(a);
	}
// QuickSort Starts
	public static void quickSort(int a[], int l, int r) {
		if(r<=l) {
			return;
		}
		int p = partition(a, l, r);
		quickSort(a, l, p-1);
		quickSort(a, p+1, r);
	}
	
	public static int partition(int a[], int l, int r) {
		
		int pivot = a[r];
		int i=l-1;
		int j=l;
		while(j<r) {
			if(a[j]<pivot) {
				i++;
				swap(a,i,j);
			}
			j++;
		}
		swap(a, i+1, r);
		return i+1;
	}
// QuickSort Ends
	
// MergeSort Starts
	public static void mergeSort(int a[], int l, int r) {
		if(r<=l) {
			return;
		}
		
		int mid = (l+r) /2;
		mergeSort(a, l, mid);
		mergeSort(a, mid+1, r);
		merge(a, l, mid, r);
	}
	
	public static void merge(int[] a, int l, int m, int r) {
		int k = l, nA = m-l+1, nB = r-m, i=0, j=0;
		int lftAr[] = new int[nA];
		int rytAr[] = new int[nB];
		
		for(int p=0;p<nA;p++) {
			lftAr[p] = a[l+p];
		}
		for(int q=0;q<nB;q++) {
			rytAr[q] = a[m+1+q];
		}
		
		while(i<nA && j<nB) {
			if(lftAr[i]<rytAr[j]) {
				a[k++] = lftAr[i];
				i++;
			}
			else {
				a[k++] = rytAr[j];
				j++;
			}
		}
		while(i<nA) {
			a[k++] = lftAr[i];
			i++;
		}
		while(j<nB) {
			a[k++] = rytAr[j];
			j++;
		}
	}
// MergeSort Ends
	
	public static void swap(int a[], int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	
	public static void printArr(int a[]) {
		for(int x : a) {
			System.out.print(x);
		}
		System.out.println();
	}
}
