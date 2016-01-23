import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by radhikadesai on 1/22/16.
 */
public class LargestSum {
    public static void main(String args[]){
        List<Integer> numbers = Arrays.asList(-2,1,-3,4,-1,2,1,-5,4);
        LargestSum sum = new LargestSum();
        System.out.print(sum.maxSubArray(numbers));

    }
    public int maxSubArray(final List<Integer> a) {
        int largestSum=0;
        int sum=0;
        int snum=a.get(0);
        for(int i=0;i<a.size();i++){
            if(snum<a.get(i))snum=a.get(i);
            if(sum + a.get(i)>0) sum+=a.get(i);
            else{sum=0;}
            if(largestSum<sum) largestSum = sum;
        }
        if(largestSum==0)return snum;
        return largestSum;
    }
}
