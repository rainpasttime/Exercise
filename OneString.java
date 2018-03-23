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
        int i;
        int j;
        int max = tem.length()>numString.length()?tem.length():numString.length();
        while(max!=0){
            if(tem.charAt(i)>numString.charAt(j)){
                return false;
            }
            else if(tem.charAt(i)<numString.charAt(j)){
                return true;
            }
            else{
                i++;
                j++;
                if(i==tem.length())
                    i = 0;
                if(j==numString.length())
                    j = 0;
                max--;
            }
        }
        return false;
    }
}