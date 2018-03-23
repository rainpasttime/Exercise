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
        for(i=0;i<count;i++){
            temMax = numString[i];
            indexMax = i;
            for(j=i+1;j<count;j++){
                if(OneString.judge(temMax,numString[j])){
                    temMax = numString[j];
                    indexMax = j;
                }
            }
            if(indexMax!=i)
                numString[indexMax] = numString[i];
            result = result.concat(temMax);
        }
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
}