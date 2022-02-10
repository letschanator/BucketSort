
public class BucketSort {

    /**
     * the array that will be sorted, the sorted array is also stored here
     */
    private int[] array;

    /**
     * the buckets array used to preform the bucket sort
     */
    private Integer[][] buckets;

    /**
     * constructor for the bucket sort
     * @param array the array of positive integers to be sorted
     */
    public BucketSort(int[] array){
        this.array = array;
        buckets = new Integer[10][array.length];
    }

    /**
     * getter for the array in it's current state
     * @return a sorted array if sort() has been called an unsorted array otherwise
     */
    public int[] getArray() {
        return array;
    }

    /**
     * setter for the array to sort
     * @param array the new array to sort
     */
    public void setArray(int[] array) {
        this.array = array;
    }

    /**
     * sorts the array according to bucket sort
     */
    public void sort(){
        int mostDigits = 0;
        for(int num:array){ // finds the number in the array with the most digits
           int numdigits = String.valueOf(num).length();
           if(numdigits > mostDigits){
               mostDigits = numdigits;
           }
        }

        for(int i = 0; i < mostDigits; i++){
            for(int j = 0; j < array.length; j++){ // goes through each element of the array and puts it in the corresponding spot in buckets
                int num = array[j];
                buckets[(int)(num/Math.pow(10,i)) % 10][j] = num;
            }
            int index = 0;
            for(int j = 0; j < buckets.length; j++){
                for(int k = 0; k < buckets[j].length; k++){ // resembles the buckets into the array
                    if(buckets[j][k] != null){
                        array[index] = buckets[j][k];
                        index++;
                    }

                }
            }
            buckets = new Integer[10][array.length]; // resets the buckets for the next digit
        }
    }

    /**
     * the to string method for the bubble sort
     * @return a string representation of the array
     */
    @Override
    public String toString(){
        String ret = "[";
        for(int num:array){
            ret = ret + num + ", ";
        }
        ret = ret.substring(0,ret.length()-2) + "]";
        return ret;
    }

}
