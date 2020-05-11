import java.security.PublicKey;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
public class domashna {
    public static void main(String[] args) {
        enterSize();
    }
    public static void enterSize(){
        Scanner word= new Scanner(System.in);
        System.out.println("Enter the size ");
        int n=word.nextInt();
        numberSave(n,word);
    }
    public static void numberSave(int n,Scanner word){
        int[] numbers = new int[n];
        int count=0;
        for (int i=0;i<n;i++){
            do{
                System.out.println("Enter number between 0 and 100 for position "+ count);
                numbers[i] = word.nextInt();
                if (numbers[i]>=0&&numbers[i]<=100)
                    count++;
            }while (numbers[i]<0||numbers[i]>100);
        }
        menu(numbers,n,word);
    }
    public static void menu(int[] numbers,int n,Scanner word) {
        System.out.println("Enter a number to chose one of the options");
        System.out.println("1.Sort the numbers(ascending)");
        System.out.println("2.Sort the numbers(descending)");
        System.out.println("3.Check a number and it position");
        System.out.println("4.Randomize the numbers");
        System.out.println("5.Sum of the all the numbers");
        System.out.println("6.Show the biggest number");
        System.out.println("7.Show the smallest number");
        System.out.println("8.Show the average of the numbers");
        System.out.println("9.Check for symmetry for the numbers");
        System.out.println("10.Show the numbers in reverse order");
        System.out.println("11.Show the numbers");
        System.out.println("12.Exit");
        int chose = word.nextInt();
        switch (chose) {
            case 1: {
                sortAscending(numbers);
                menu(numbers,n,word);
                //quickSort(numbers,0,numbers.length-1,n);
                break;
            }
            case 2:{
                sortDescending(numbers);
                menu(numbers,n,word);
                break;
            }
            case 3: {
                searchNumber(numbers,word);
                menu(numbers,n,word);
                break;
            }
            case 4: {
                randNumbers(numbers);
                menu(numbers,n,word);
                break;
            }
            case 5:{
                sumNumber(numbers);
                menu(numbers,n,word);
                break;
            }
            case 6:{
                maxNumber(numbers);
                menu(numbers,n,word);
                break;
            }
            case 7:{
                minNumber(numbers);
                menu(numbers,n,word);
                break;
            }
            case 8:{
                avrNumber(numbers,n);
                menu(numbers,n,word);
                break;
            }
            case 9:{
                numbersSymmetry(numbers,n);
                menu(numbers,n,word);
                break;
            }
            case 10:{
                arrReverse(numbers,n);
                menu(numbers,n,word);
                break;
            }
            case 11:{
                showNumbers(numbers);
                menu(numbers,n,word);
                break;
            }
            default:{
                System.out.println("Thank you very much for using our program");
            }
        }
    }
    public static void sortAscending(int[] numbers){
        quickSortAscending(numbers,0,numbers.length-1);
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
    }
    public static void sortDescending(int[] numbers){
        quickSortDescending(numbers,0,numbers.length-1);
            for (int i = 0; i < numbers.length; i++) {
                System.out.print(numbers[i] + " ");
            }
    }
    public static void quickSortAscending(int[] numbers, int start, int end){

        int partition = partitionAscending(numbers, start, end);

        if(partition-1>start) {
            quickSortAscending(numbers, start, partition - 1);
        }
        if(partition+1<end) {
            quickSortAscending(numbers, partition + 1, end);
        }
    }
    public static int partitionAscending(int[] numbers, int start, int end){
        int pivot = numbers[end];

        for(int i=start; i<end; i++){
            if(numbers[i]<pivot){
                int temp= numbers[start];
                numbers[start]=numbers[i];
                numbers[i]=temp;
                start++;
            }
        }

        int temp = numbers[start];
        numbers[start] = pivot;
        numbers[end] = temp;

        return start;
    }
    public static void quickSortDescending(int number[], int left, int right){
        if(left < right)
        {
            int q = partitionDescending(number, left, right);
            quickSortDescending(number, left, q);
            quickSortDescending(number, q + 1, right);
        }
    }
    public static int partitionDescending(int numbers[], int left, int right){
        int pivot = numbers[left];
        int l = left;
        for(int i = left + 1; i <= right; i++){
            if (numbers[i] > pivot){
                l++;
                int temp = numbers[l];
                numbers[l]= numbers[i];
                numbers[i]= temp;
            }
        }

        int temp = numbers[l];
        numbers[l] = numbers[left];
        numbers[left] = temp;

        return l;

    }
    public static void searchNumber(int[] number,Scanner word){
        System.out.println("Enter the number you want to check");
        int numb=word.nextInt(),position=-1,count=0;
        for (int i=0; i<number.length;i++){
            if(numb==number[i]){
                position = i;
                count++;
            }
        }
        if (count!=0)
        System.out.println("The position of "+numb+" is "+position);
        else System.out.println("Your number wasn't found");
    }
    public static void sumNumber(int[] numbers){
        int sum=0;
        for (int i=0;i<numbers.length;i++){
            sum+=numbers[i];
        }
        System.out.println("The sum of the numbers is "+ sum);
    }
    public static void maxNumber(int[] numbers){
        int max=numbers[0];
        for (int i=1; i<numbers.length;i++){
            if (max<numbers[i]){
                max=numbers[i];
            }
        }
        System.out.println("The biggest number is "+max);
    }
    public static void minNumber(int[] numbers){
        int min=numbers[0];
        for (int i=1; i<numbers.length;i++){
            if (min>numbers[i]){
                min=numbers[i];
            }
        }
        System.out.println("The smallest number is "+min);
    }
    public static void avrNumber(int[] numbers,int n){
        double avr=0;
        for (int i=0;i<numbers.length;i++){
            avr+=numbers[i];
        }
        avr/=n;
        System.out.println("The sum of the numbers is "+ avr);
    }
    public static void arrReverse(int[] numbers,int n){
        int arrHelper[]=new int[n];
        for(int i = 0;i<numbers.length;i++){
            arrHelper[i]=numbers[i];
        }
        for(int i = 0;i<numbers.length;i++){
            numbers[i]=arrHelper[i];
        }
        for(int i = 0;i<numbers.length;i++){
            System.out.print(numbers[i]+" ");
        }
    }
    public static void numbersSymmetry(int[] numbers,int n){
        int counterOne=0,counterTwo=n-1,counterSymmetry=0,counterWhile=0;
        if(n%2==0){
            do {
                if(numbers[counterOne]==numbers[counterTwo]){
                    counterOne++;
                    counterTwo--;
                }else {
                    counterSymmetry++;
                    counterOne++;
                    counterTwo--;
                }
            }while (counterWhile<n/2);
        }else {
            do {
                if (numbers[counterOne] == numbers[counterTwo]) {
                    counterOne++;
                    counterTwo--;
                } else counterSymmetry++;
                counterWhile++;
            } while (counterWhile < n / 2||counterWhile<(n/2)+1);
        }
        if(counterSymmetry==0){
            System.out.println("Your numbers are symmetry");
        }else {
            System.out.println("Your numbers aren't symmetry");
        }
        for (int i=0;i<numbers.length;i++) {
            System.out.println(numbers[i]+" ");
        }
    }
    public static void showNumbers(int[] numbers){
        for (int i=0;i<numbers.length;i++){
            System.out.print(numbers[i]+" ");
        }
    }
    public static void randNumbers(int[] numbers){
        Random rnd = ThreadLocalRandom.current();
        for (int i = numbers.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);

            int a = numbers[index];
            numbers[index] = numbers[i];
            numbers[i] = a;
        }
        for (int i=0;i<numbers.length;i++) {
            System.out.print(numbers[i]+" ");
        }
    }
}

