import java.util.*;

/**
 * Created by radhikadesai on 1/22/16.
 */
public class BiggestNumber {
    public static void main(String args[]){
        List<Integer> numbers = Arrays.asList(931, 94, 209, 448, 716, 903, 124, 372, 462, 196, 715, 802, 103, 740, 389, 872, 615, 638, 771, 829, 899, 999, 29, 163, 342, 902, 922, 312, 326, 817, 288, 75, 37, 286, 708, 589, 975, 747, 743, 699, 743, 954, 523, 989, 114, 402, 236, 855, 323, 79, 949, 176, 663, 587, 322);

        BiggestNumber s = new BiggestNumber();
        s.largestNumber(numbers);
        System.out.print(s.largestNumber(numbers));
    }
    public String largestNumber(final List<Integer> a) {
        int largestNumberOfDigits=0;
        boolean allNumbersZero=true;
        for(int number : a){
            if(number!=0){
                allNumbersZero=false;
            }
            if(Util.findNumberOfDigits(number)>largestNumberOfDigits)
                largestNumberOfDigits=Util.findNumberOfDigits(number);
        }
        if(allNumbersZero)
        {
            return "0";
        }
        String finalNumber="";
        List<Integer> listOfNumbers = new ArrayList<Integer>(a);
        Collections.sort(listOfNumbers, new NumberComparator(listOfNumbers,1));
        for(Integer number :listOfNumbers){
            finalNumber=finalNumber.concat(number.toString());
        }
        return finalNumber;
    }


}

class Util{
    public static int findNthDigit(Object number,int n){
        String num = String.valueOf(number);
        char[] digits1 = num.toCharArray();
        char nthDigit;
        if(digits1.length<=n-1){
            nthDigit= digits1[0];
        }
        else {
            nthDigit = digits1[n - 1];
        }
        Integer intDigitN=Character.getNumericValue(nthDigit);
        return intDigitN;
    }
    public static int findNumberOfDigits(Object number){
        String num = String.valueOf(number);
        char[] digits1 = num.toCharArray();
        return digits1.length;
    }
}
class NumberComparator implements Comparator {
    List<Integer> list;
    int nthDigit;
    public NumberComparator(List list,int nthDigit) {
        this.list =list;
        this.nthDigit=nthDigit;
    }

    @Override
    public int compare(Object i1, Object i2) {
        int largestNumberOfDigits=0;
        if(Util.findNumberOfDigits(i1)>largestNumberOfDigits)
            largestNumberOfDigits=Util.findNumberOfDigits(i1);
        if(Util.findNumberOfDigits(i2)>largestNumberOfDigits)
            largestNumberOfDigits=Util.findNumberOfDigits(i2);
        int intDigit1;
        int intDigit2;
        int i=1;
        while(i<=largestNumberOfDigits){
            intDigit1=Util.findNthDigit(i1,i);
            intDigit2 =Util.findNthDigit(i2,i);
            if(intDigit1==intDigit2){
                i++;
            }
            else if(intDigit1>intDigit2){
                return -1;
            }
            else {
                return 1;
            }
        }
        return 0;
    }
}
