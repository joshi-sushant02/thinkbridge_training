//java program to search
class LinearSearch{
    LinearSearch(int element,int[] array){
        int i=-1;
        for (i = 0; i < array.length ; i++) {
            if(array[i] == element){
                break;
            }
        }
        if(i==-1){
            System.out.println("Element was not found");
        }else{
            System.out.println("Element was found at index "+i);
        }


    }

}

//Java program to search element using Binary Search
class BinarySearch {

    int binarySearch(int arr[], int x)
    {
        int l = 0, r = arr.length ;
        while (l <= r) {
            int m = (l + r) / 2;
            if (arr[m] == x) {
                return m;
            }                            // if element found return index
            if (arr[m] < x)             // If element greater, ignore left half
                l = m + 1;
            else
                r = m - 1;             // If element is smaller, ignore right half
        }

        return -1;                     // if element is not present then return -1;
    }
}


// Java program to implement Jump Search.
class JumpSearch {
     int jumpSearch(int[] arr, int x) {
        int n = arr.length;

        int step = (int) Math.floor(Math.sqrt(n));     // Finding block size to be jumped

        int prev = 0;
        for (int minStep = Math.min(step, n) - 1; arr[minStep] < x; minStep = Math.min(step, n) - 1) {   // Finding the block where element is present (if it is present)
            prev = step;
            step += (int) Math.floor(Math.sqrt(n));
            if (prev >= n)
                return -1;
        }
        while (arr[prev] < x) {                           // Implement a linear search for x.
            prev++;
            if (prev == Math.min(step, n))               // If we reached next block or end of array, element is not present.
                return -1;
        }
        if (arr[prev] == x)
            return prev;                         // If element is found, return index

        return -1;                               // If element is not found return -1;




    }
}

//Driver class
public class Search {
    public static void main(String[] args) {
        int arr[]= {1,10,20,2,30,3,4,20};
        LinearSearch ls= new LinearSearch(30,arr);
        BinarySearch bs= new BinarySearch();
        int pos30=bs.binarySearch(arr,10);
        System.out.println("Element was found at index "+pos30);
        JumpSearch js= new JumpSearch();
        int pos20=js.jumpSearch(arr,20);
        System.out.println("Element was found at index "+pos20);

    }
}
