import java.util.*;
import java.util.Map;

/**
 * Created by Artur on 13.03.2016.
 */
public class Generator
{
    public static void main(String[] args)
    {
        Map<Integer,Integer> numbers = new HashMap<Integer, Integer>();
        int max=48; // max value in lottery 1..max
        Random rand = new Random(100);
        int c=0,num=0;

        //generating randoms
        while (c<Integer.MAX_VALUE)
        {
            rand = new Random();
            num=rand.nextInt(max)+1;
        //    System.out.println(num);
            if (numbers.containsKey(num)) numbers.put(num,numbers.get(num)+1);
            else numbers.put(num,1);
            c++;
        }

        //sort by values
        TreeMap<Integer, Integer> sortedMap = new TreeMap<Integer, Integer>();
        for (Map.Entry entry : numbers.entrySet()) {
            sortedMap.put((Integer) entry.getValue(), (Integer)entry.getKey());
        }

        for (Map.Entry<Integer, Integer> entry : numbers.entrySet())
        {
            System.out.println(entry.getValue()+": counter="+entry.getKey());
        }
        System.out.println("--------------------");
        //printing
        for (Map.Entry<Integer, Integer> entry : sortedMap.entrySet())
        {
            System.out.println(entry.getValue()+": counter="+entry.getKey());
        }

    }
}
