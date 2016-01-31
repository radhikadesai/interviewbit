import java.util.*;

/**
 * Created by radhikadesai on 1/30/16.
 */
public class HotelBooking {
    public static void main(String[] args){
     Solution s = new Solution();
     List<Integer> arrive= Arrays.asList(13, 14, 36, 19, 44, 1, 45, 4, 48, 23, 32, 16, 37, 44, 47, 28, 8, 47, 4, 31, 25, 48, 49, 12, 7, 8 );
     List<Integer> depart= Arrays.asList(28, 27, 61, 34, 73, 18, 50, 5, 86, 28, 34, 32, 75, 45, 68, 65, 35, 91, 13, 76, 60, 90, 67, 22, 51, 53);
     System.out.print(s.hotel(arrive,depart,23));
    }
}
class Solution {
    public boolean hotel(List<Integer> arrive, List<Integer> depart, int K) {
        List<Occupancy> occupancies = new ArrayList<Occupancy>();
        boolean occupancyPossible = true;
        for (int i=0;i<arrive.size();i++)
        {
            Occupancy occupancy = new Occupancy();
            occupancy.setArrival(arrive.get(i));
            occupancy.setDeparture(depart.get(i));
            occupancies.add(occupancy);

        }
        Collections.sort(occupancies);
        for (int i=0;i<arrive.size()-1 && K>0;i++)
        {
            if(occupancies.get(i+1).getArrival()<occupancies.get(i).getDeparture()){
                K=K-1;
            }
        }
        if(K==0){
            occupancyPossible=false;
        }
        return occupancyPossible;
    }
}

class Occupancy implements Comparable<Occupancy>{

    Integer arrival;
    Integer departure;

    public Integer getDeparture() {
        return departure;
    }

    public void setDeparture(Integer departure) {
        this.departure = departure;
    }

    public Integer getArrival() {
        return arrival;
    }

    public void setArrival(Integer arrival) {
        this.arrival = arrival;
    }

    @Override
    public int compareTo(Occupancy occupancy) {
        if(occupancy.getArrival()<this.getArrival()){
            return 1;
        }
        if(occupancy.getArrival()>this.getArrival()) {
            return -1;
        }
        return 0;
    }
}