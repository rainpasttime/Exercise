import java.util.Scanner;

public class OneString{
    public static void main(String args[]){
        Scanner read = new Scanner(System.in);
        int i;
        int j;
        int indexMax;
        String temMax;
        String result = "";
        String countString = read.nextLine();
        int count = Integer.parseInt(countString);
        String inputString = read.nextLine();
        String numString[] = inputString.split("\\s");
        quickSort(0,count-1,numString);
        for(i=count-1;i>=0;i--)
            result = result.concat(numString[i]);
        System.out.println(result);
        read.close();
    }
    static boolean judge(String tem,String numString){
        String resultOne = tem.concat(numString);
        String resultTwo = numString.concat(tem);
        if(Integer.parseInt(resultOne)>Integer.parseInt(resultTwo))
            return false;
        else
            return true;
    }
    static void quickSort(int first,int end,String[] numString){
        int pivot;
        if(first<end){
            pivot = partition(first,end,numString);
            quickSort(first,pivot-1,numString);
            quickSort(pivot+1,end,numString);
        }
    }
    static int partition(int s,int t,String[] numString){
        int i = s;
        int j = t;
        if(s==t){
            return 0;
        }
        else{
            while(i<j){
                while(i<j&&judge(numString[i],numString[j]))
                j--;
                if(i<j){
                    String tem = numString[i];
                    numString[i] = numString[j];
                    numString[j] = tem;
                    i++;
                }
                while(i<j&&judge(numString[i],numString[j]))
                    i++;
                if(i<j){
                    String tem = numString[i];
                    numString[i] = numString[j];
                    numString[j] = tem;
                    j--;
                }
            }
        }
        return i;
    }
}