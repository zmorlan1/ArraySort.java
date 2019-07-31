public class ArraySort {
  /**
  * Sorts the first n objects in an array into acending order.
  * @param array An array of comparable Objects.
  * @param int first postion of first comparable object in array.
  * @param int last postion of the last comparable object in array.  
  * @return	none
  */
  public static <T extends Comparable<? super T>> 
         void quickSort(T [] array, int first, int last) {
         
         final int MIN_SIZE = 4;
         int pivotIndex = 0; 
         
         if (last - first + 1 < MIN_SIZE) {
         
            insertionSort(array, first, last);
         
         }// End if
         else {
         
         pivotIndex = partition(array, first, last);
         
         quickSort(array, first, pivotIndex - 1);
         quickSort(array, pivotIndex + 1, last);
         
         }// End else 


    
  }// End quickSort
//*****************************************************************************   
   /**
   * Swaps two entries in the array 
   * @param int i First entry in the array to be swapped 
   * @param int j Second entry in the array to be swapped
   * @return none
   */      
   private static void swap(Object [] array, int i, int j) {
        
        Object temp = array[i];
        
        array[i] = array[j];
        array[j] = temp;
        
    }// End swap 
//*****************************************************************************
  /**
  * Sorts small array under MIN_SIZE into acending order
  * @param array An array of comparable Objects.
  * @param int first postion of first comparable object in array.
  * @param int last postion of the last comparable object in array.  
  * @return	none
  */
  public static <T extends Comparable<? super T>> 
         void insertionSort(T [] array, int first, int last) {
         
      if( first < last) {
      
         insertionSort(array, first, last - 1);
         
         insertInOrder(array[last], array, first, last - 1);
      
      }// End if
         
  }// End InsertionSort  
//*****************************************************************************
  /**
  * Sorts small array under MIN_SIZE into acending order
  * @param  T anEntry abstract data type from the array
  * @param array An array of comparable Objects.
  * @param int first postion of first comparable object in array.
  * @param int last postion of the last comparable object in array.  
  * @return	none
  */
  public static <T extends Comparable<? super T>> 
         void insertInOrder(T anEntry, T [] array, int first, int last) {
         
      if(anEntry.compareTo(array[last]) <= 0) {
      
         array[last + 1] = anEntry;
      
      }// End if
      else if( first < last) {
      
         array[last + 1] = array[last];
         insertInOrder(anEntry, array, first, last - 1);
      }// end else if
      else {
      
         array[last + 1] = array[last];
         array[last] = anEntry; 
      }// End else 
              
  }// End InsertionSort 
//*****************************************************************************
    /**
    * Method that finds the middle of the array
    * @param int first the position of the first entry of the array
    * @param int last the position of the last entry of the array
    * @return the middle value of the array
    */ 	
    private static int selectMiddle(int first, int last) {
    
        return (first + last) / 2;
        
    }// End selectPivot  
//*****************************************************************************  
    /**
    * Method that sorts the first middle and last entry by acending order
    * @param T [] array an array storing some sort of data type
    * @param int first the position of the first entry of the array
    * @param int middle the position of the middle entry of the array 
    * @param int last the position of the last entry of the array
    */    
    private static <T extends Comparable<? super T>> 
        void sortFirstMiddleLast(T [] array, int first, int middle, int last) {
            
            // middle < first < last
            if(array[middle].compareTo(array[first]) < 0 &&
               array[first].compareTo(array[last]) < 0) {
               
              swap(array, first, middle);
              
            }// End if  
            
            // last < middle < first 
            else if (array[last].compareTo(array[middle]) < 0 &&
               array[middle].compareTo(array[first]) < 0) {
               
               swap(array, first, last);
               
            }// End else if
            
            // middle < last < first
            else if (array[middle].compareTo(array[last]) < 0 &&
               array[last].compareTo(array[first]) < 0) {
               
               swap(array, first, middle);
               swap(array, middle, last);
               
            }// End else if 
            
            // first < last < middle
            else if (array[first].compareTo(array[last]) < 0 &&
               array[last].compareTo(array[middle]) < 0) {
               
               swap(array, last, middle);
               
            }// End else if
            
            // last < first < middle   
            else if (array[last].compareTo(array[first]) < 0 &&
               array[first].compareTo(array[middle]) < 0) {
               
               swap(array, last, middle);
               swap(array, middle, first);               
               
            }// End else if       
        }// End sortFirstMiddleLast
//*****************************************************************************  
    /**
    * Method that sorts the first middle and last entry by acending order
    * @param T [] array an array storing some sort of data type
    * @param int first the position of the first entry of the array 
    * @param int last the position of the last entry of the array
    * @return int pivotIndex the postion of the pivot value
    */           
    private static <T extends Comparable<? super T>> 
                  int partition(T [] array, int first, int last) {
                      
            int mid = selectMiddle(first, last); 
            int pivotIndex = last - 1;
            int indexFromLeft = first + 1;
            int indexFromRight = last - 2;
            T pivotValue = array[pivotIndex];
            boolean done = false;
             
            sortFirstMiddleLast(array, first, mid, last);
            
            swap(array, mid, last - 1);
            
            while(!done) {
               
               while (array[indexFromLeft].compareTo(pivotValue) < 0) {
               
                  indexFromLeft++;
               
               }// End while  
               while (array[indexFromRight].compareTo(pivotValue) > 0) {
               
                  indexFromRight--;
               
               }// End while
               if(indexFromLeft < indexFromRight) {
               
                  swap(array, indexFromLeft, indexFromRight);
                  indexFromLeft++;
                  indexFromRight--;
               
               }// End if
               else {
               
                  done = true;
                  
               }// End else 
    
            }// End while
            
            swap(array, pivotIndex, indexFromLeft);
            pivotIndex = indexFromLeft;
            return pivotIndex;            
    }// End partition
                
}// End ArraySort
