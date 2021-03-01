import java.io.*;
import java.util.Scanner;
import java.util.*;
import java.util.Arrays;
import static java.lang.Math.sqrt;


public class Main{

public static void main(String[] args)throws IOException{




}

  public static String[] insert(String s, int i, String[] a,   int logicalSize){

    boolean arrayFull = true;
    for (int b = 0; b < a.length; b++){
      if (a[b] == null){
        arrayFull = false;
        break;
      }
    }  
    if (arrayFull) {
      return null;
    }  
    for(int j = logicalSize -1; j >= i; j-- ){
      a[j] = a[j-1];
    }  
    a[i] = s;
   String[] newArray = Arrays.copyOf(a, logicalSize);
    return newArray;
  }

   public static int[] delete(int target, int[] a, int logicalSize){
     int[] delete = new int[logicalSize];
     boolean isEmptyDeleteArray = true;
     int location = 0;
     boolean targetFound = false;
     for (int k = 0; k <a.length; k++){
       if(target == a[k]){
       targetFound = true;
       }else if(k == 0){
         delete[k] = a[k];
         location ++;
         isEmptyDeleteArray = false;
       }else{
         if(isEmptyDeleteArray == true){
           delete[0] = a[k];
           location ++;
           isEmptyDeleteArray = false;
         }else{
         delete[location] = a[k];
         location ++;
         isEmptyDeleteArray = false;
         }
       }
     }
     if(targetFound == false){
       return a;
     }else{
       return delete;
     }
   }

   public static void stats(String filename)throws IOException{
     Scanner fileReader = new Scanner(new File(filename));
     int count = 0;
     int fileCount = 0;
     int median = 0;
     int stdev = 0;
     int mean = 0;
     int numbersArrayPosition = 0;
     String inputString;
     String currentLineTrimmed;
     int[] buffer = new int[5000];
     
    while(fileReader.hasNext()) {
      buffer[count] = fileReader.nextInt();
      count++;
    }

    int[] numbers = Arrays.copyOf(buffer,count);
    buffer = null;
        median = median(numbers);
        stdev = stdev(numbers);
        mean = average(numbers);
      printArray(mean, median, stdev);
   }

   private static void printArray(int mean, int median, int stdev) throws IOException{
    //Open output.txt for writing
    PrintWriter writer = new PrintWriter(new File("output.txt"));
    writer.println("Mean: " + mean);
    writer.println("Median: " + median);
    writer.println("Standard Deviation: " + stdev);
    writer.close();
  }

  private static int stdev(int[] list){
  int[] listTwo = new int[list.length];
  int[] listThree = new int[list.length];
  int[] listFour = new int[list.length];
  int avg = average(list);
  for (int k = 0; k <list.length; k++){
    listTwo[k] = list[k] - avg;
  }
  for (int g = 0; g <list.length; g++){
    listThree[g] = listTwo[g] * listTwo[g];
  }
  int avgTwo = average(listThree);
  double squareRoot = sqrt(avgTwo);
  int squareRoot2 = (int)squareRoot;
  return squareRoot2;
}

private static int average(int[] numbers){
    int sum = 0;
    for(int i = 0; i < numbers.length; i++){
      sum += numbers[i];
    }
    return sum/numbers.length; 
  }

private static int median(int[] input){
       Arrays.sort(input);
       if(input.length == 1){
         return input[0];
       }else if (input.length == 2){
          return (input[0] + input[1]) /2;
       }else if(input.length % 2 != 0){ 
         int position = (input.length / 2) + 1;
         return input[position-1];
       }

       int position1 = input.length / 2;
       int position2 = position1 - 1;
       int math =(input[position1] + input[position2]);
       int d = math / 2;
       System.out.println(d);
       return  d;
    }
   }
