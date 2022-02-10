import java.util.Scanner;

public class Runner {

    /**
     * the runner for bucket sort to make an it array and sort it using bucket sort
     * @param args the arguments for the program
     */
    public static void main(String[] args){
        boolean done = false;
        Scanner src = new Scanner(System.in);
        while (!done){
            System.out.print("How many numbers would you like to sort:");
            int len = src.nextInt();
            int[] array = new int[len];
            for(int i = 1; i <= len; i++){
                System.out.print("What is element " + i + ":");
                array[i-1] = src.nextInt();
            }
            BucketSort sort = new BucketSort(array);
            System.out.println("The unsorted array: " + sort);
            sort.sort();
            System.out.println("The sorted array: " + sort);
            System.out.print("would you like to sort another array (1 for yes, 2 for no):");
            int num = src.nextInt();
            if(num != 1){
                done = true;
            }
        }

    }
}
