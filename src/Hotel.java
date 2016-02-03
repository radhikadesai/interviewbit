import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * TEST CASES :

 List<Integer> arrive= Arrays.asList(13, 14, 36, 19, 44, 1, 45, 4, 48, 23, 32, 16, 37, 44, 47, 28, 8, 47, 4, 31, 25, 48, 49, 12, 7, 8 );
 List<Integer> depart= Arrays.asList(28, 27, 61, 34, 73, 18, 50, 5, 86, 28, 34, 32, 75, 45, 68, 65, 35, 91, 13, 76, 60, 90, 67, 22, 51, 53);
 System.out.print(s.hotel(arrive,depart,23));
 */

public class Hotel {
    public static void main(String[] args){
        Solution s = new Solution();
        List<Integer> arrive= Arrays.asList(1,2,3);
        List<Integer> depart= Arrays.asList(2,3,4);
        System.out.print(s.hotel(arrive,depart,1));
    }
}
class Solution {
    public boolean hotel(List<Integer> arrive, List<Integer> depart, int K) {
        List<Occupancy> occupancies = new ArrayList<Occupancy>();
        boolean occupancyPossible = true;
        for (int i=0;i<arrive.size();i++)
        {
            Occupancy occupancy = new Occupancy();
            occupancy.setDate(arrive.get(i));
            occupancy.setType("a");
            occupancies.add(occupancy);
        }
        for(int i=0;i<depart.size();i++){
            Occupancy occupancy = new Occupancy();
            occupancy.setDate(depart.get(i));
            occupancy.setType("d");
            occupancies.add(occupancy);
        }
        Collections.sort(occupancies);
        for (int i=0;i<2* arrive.size() && K>=0;i++)
        {
            if(occupancies.get(i).getType().equals("a")){
                K=K-1;
            }
            else {
                K=K+1;
            }
        }
        if(K<0){
            occupancyPossible=false;
        }
        return occupancyPossible;
    }
}
class Occupancy implements Comparable<Occupancy>{
    int date;
    String type;
    public int getDate() {
        return date;
    }
    public void setDate(int date) {
        this.date = date;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int compareTo(Occupancy occupancy) {
        if(occupancy.getDate()<this.getDate()){
            return 1;
        }
        if(occupancy.getDate()>this.getDate()) {
            return -1;
        }
        if(occupancy.getDate()==this.getDate()){
            return 1;
        }
        return 0;
    }
}
