import java.util.Arrays;

//Java program for Selection Sort
class SelectionSort {
    int array[];

    SelectionSort(int array[]) {
        this.array = array;
        System.out.print("Array before Sorting: ");
        System.out.println(Arrays.toString(array));
    }

    void selectionSort() {
        int length = array.length;

        for (int i = 0; i < length - 1; i++) {      //traverse each element
            int idx = i;
            for (int j = i + 1; j < length; j++) {
                if (array[j] < array[idx]) {       // Select the minimum element in each loop.
                    idx = j;
                }
            }
            int temp = array[i];                  // swap minimum element to it's right position
            array[i] = array[idx];
            array[idx] = temp;
        }
        System.out.print("Array after Selection Sort: ");
        System.out.println(Arrays.toString(array));
    }
}

//Java program for Bubble Sort
class BubbleSort {
    int array[];
    BubbleSort(int array[]){
        this.array=array;
        System.out.print("Array before Sorting: ");
        System.out.println(Arrays.toString(array));
    }
    void bubbleSort() {
        int length = array.length;


        for (int i = 0; i < length - 1; i++)            //traverse each element

            for (int j = 0; j < length - i - 1; j++)

                if (array[j] > array[j + 1]) {         // compare two adjacent elements
                    int temp = array[j];               // swap elements
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
        System.out.print("Array after Bubble Sort: ");
        System.out.println(Arrays.toString(array));
    }
}

//Java program for Merge Sort
class MergeSort {
    int array[];
    MergeSort(int array[]){
        this.array=array;
        System.out.print("Array before Sorting: ");
        System.out.println(Arrays.toString(array));
        sort(0, array.length-1);
        System.out.print("Array after Merge Sort: ");
        System.out.println(Arrays.toString(array));

    }
    void merge(int l, int m, int r)          //merge left and right part
    {

        int n1 = m - l + 1;                             // get array sizes
        int n2 = r - m;


        int Left[] = new int[n1];                       //create temp arrays
        int Right[] = new int[n2];


        for (int i = 0; i < n1; ++i)                   //store data from main array to temp
            Left[i] = array[l + i];
        for (int j = 0; j < n2; ++j)
            Right[j] = array[m + 1 + j];


        int i = 0, j = 0;
        int k = l;
        // actual algorithm to merge arrays
        while (i < n1 && j < n2) {
            if (Left[i] <= Right[j]) {
                array[k] = Left[i];
                i++;
            } else {
                array[k] = Right[j];
                j++;
            }
            k++;
        }


        while (i < n1) {                         //add remaining elements of left array if any
            array[k] = Left[i];
            i++;
            k++;
        }

        while (j < n2) {                        //add remaining elements of right array if any
            array[k] = Right[j];
            j++;
            k++;
        }


    }

    void sort(int l, int r)        //recursive merge function
    {
        if (l < r) {

            int m = l + (r - l) / 2;          // Find the middle index


            sort(l, m);                  // sort 1st half
            sort(m + 1, r);           // sort 2nd half


            merge(l, m, r);            // merge two halves
        }
    }
}

//Driver class
class Sort{
    public static void main(String[] args) {
        int arr[]= {1,10,20,2,30,3,4,20};
        SelectionSort ss= new SelectionSort(arr);
        ss.selectionSort();
        BubbleSort bs= new BubbleSort(arr);
        bs.bubbleSort();
        MergeSort ms= new MergeSort(arr);

    }
}


