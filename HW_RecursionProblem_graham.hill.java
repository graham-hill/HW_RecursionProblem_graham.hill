import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    
    // Literal 11 Element Array 
    static int[] _arr = {96, 61, 18, 85, 24, 62, 45, 3, 68, 57, 78};
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arg = in.nextInt();
        PrintLine("Console Input: " + arg);
        
        OutputArray(_arr);
        Arrays.sort(_arr);
        OutputArray(_arr);
        
        int _cnt = _arr.length;
        int[] arr = Arrays.copyOfRange(_arr, 0, _cnt);
        int idx = BinarySearch(arr, arg);
        
        PrintLine("Index: " + idx + "; Value: " + _arr[idx]);
    }
    
    static int BinarySearch(int[] arr, int value){
        return BinarySearch(arr, value, 0);
    }
    
    static int BinarySearch(int[] arr, int value, int idxOff){
        int len = arr.length;
        int retIdx = -1;
        
        if(len == 2){
            if(arr[0]== value){
                retIdx = idxOff;
            } else if(arr[1] == value) {
                retIdx = idxOff+1;
            }
        } else {
            int max = arr.length-1;
            int midIdx = max/2;
            System.out.println("Mid Idx: " + midIdx + "; Max Idx: " + max + "; Index Offset: " + idxOff + "; Array: " + Arrays.toString(arr));
            
            if(value == arr[midIdx]) {
                retIdx = midIdx;
            } else {
                if(value < arr[midIdx]){
                    int[] newArray = Arrays.copyOfRange(arr, 0, midIdx);
                    
                    retIdx = BinarySearch(newArray, value);
                } else if(arr[midIdx] < value){
                    int[] newArray = Arrays.copyOfRange(arr, midIdx, max);
                    idxOff += midIdx;
                    
                    retIdx = BinarySearch(newArray, value, idxOff);
                }
            }
        }
        
        return retIdx;
    }
    
    static void OutputArray(String[] arr){
        PrintLine("Array: " + Arrays.toString(arr));
    }
    static void OutputArray(int[] arr){
        PrintLine("Array: " + Arrays.toString(arr));
    }
    
    static void PrintLine(String msg){
        System.out.println(msg);
    }
}