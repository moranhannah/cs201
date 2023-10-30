import java.util.Arrays;

/**
 * A Sorted Array List Data Structure.
 * Hannah Moran
 */

public class SortedArrayList {

    //Instance Variables
    // Num of integers currently stored
    private int size = 0;
    // The current capacity of the array
    private int capacity;
    //
    private int[] data;
    private int[] newData;
    
    public SortedArrayList(int cap) throws Exception {
        //UPDATE THIS CONSTRUCTOR
        if (cap <= 0) {
            throw new Exception("Cannot have capacity less than one.");
        }
        capacity = cap;
        data = new int[capacity];
    }
    
    /**
     * @return A string that describes the SortedArrayList
     */
    public String toString() {
        String val = "[";
        for (int i = 0; i < size; i++) {
            val = val + data[i];
            
            if (i < size - 1) {
                val = val + ", ";
            }
        }
        val = val + "]";
        return val;
    }
    /*
     * This method is used to make sure that the index
     * stays within the bounds of the size.
     */
    private boolean indexOutOfBounds(int index) {
        return (index < 0 || index >= size);
    }

    //YOUR METHODS GO BELOW HERE
    
    // method that returns the minumum value, or first index.
    public int getMin() {
        int min = data[0];
        return min;
    }

    // method that returns the maximum value, or the last index.
    public int getMax() {
        int max = data[size-1];
        return max;
    } 

    // method that returns the updated size variable used to keep track
    // of how many items are in the array data
    public int getSize() {
        return size; 
    }

    // method that removes the first item in list and shifts all other
    // items to the left by one index. returns the minimum value deleted.
    public int deleteMin() {
        int deleteMin = data[0];
        for(int i = size; i > 0; i--) {

            data[i] = data[i-1];
        }
        size--;
        return deleteMin;
    }  

    // method that removes the last item in the list.
    public int deleteMax() {
        int deleteMax = data[size-1];
        size--;
        return deleteMax;
    } 

    // mehtod that checks whether the input is found in the list.
    public boolean contains(int x) {
        boolean contains = false;
        for (int i = 0; i < size; i++) {
            if (x == data[i]) {
                contains = true;
            }
        }
        return contains;
    } 
    
    // method that adds integers into the ordered array to appropriate
    // index.
    public void add(int x) {
        
        if (indexOutOfBounds(x)) {
            resizeArray();
        }

        if (data.length >= size) {
            resizeArray();
        }
        
        // if first added case
        if (size == 0) {
            data[0] = x;
        }

        // if second added case
        if (x < data[0]) {
            data[1] = data[0];
            data[0] = x;
        }
        
        // for all other added items to the array
        for(int index = 1; index < size; index++) {

            if (x < data[index]) {
                shiftArray(index);
                data[index] = x;
            } 
        }
        // adds one to size after every add call.
        size ++;
    }
    
    // method created by me to simplify shifting.
    // shifts from the final index over to the right.
    // is broken but the idea is here.
    private void shiftArray(int index) {

        for(int i = size; i > index; i--) {
            data[i] = data[i-1];
        }

    }

    // resize array method that doubles the capacity 
    // creates a new array with all data and then puts it back into an updated data array.
    private void resizeArray() {
        int[] newData = Arrays.copyOf(data, capacity*2);
        int[] data = Arrays.copyOf(newData, capacity*2);
    }
}    
   
