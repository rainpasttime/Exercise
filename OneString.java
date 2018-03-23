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
        if((tem.length())<numString.length()){  //tem是12，numString是120,122,130,112这样的情况
            int i = 0;
            int j = 0;
            int max = numString.length();
            while(i<max){   
                if(tem.charAt(j)<numString.charAt(i)){
                    return true;
                }
                else if(tem.charAt(j)>numString.charAt(i)){  
                    return false;
                }
                i++;
                j++;
                if(j==(tem.length())){
                    j=0;
                }
            }
        }
        else{               //tem是120,122,130,112同时numString是12的情况。或者tem是129，numString是130,122,150,119的情况  
            int i = 0;
            int j = 0;
            int max = (tem.length());
            while(i<max){
                if(tem.charAt(i)>numString.charAt(j)){
                    return false;
                }
                else if(tem.charAt(i)<numString.charAt(j)){
                    return true;
                }
                i++;
                j++;
                if(j==numString.length()){
                    j = 0;
                }
            }
        }
        return false;
    }
}