import java.util.*;

/**
 * Created by Divya Chopra on 9/23/2016.
 */
public class EgyptianCafe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of orders : ");
        int numOfOrders = sc.nextInt();
        System.out.println("Enter order number : ");
        int orderNum = sc.nextInt();
        Queue<Map.Entry <Integer,Integer>> priorityQueue = new LinkedList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        sc.nextLine();
        int index = 0;
        for(int i = 0; i < numOfOrders; i++)
        {
            map.put(index++,Integer.parseInt(sc.nextLine()));
            //priorityQueue.add(orderPair);
            //System.out.println(priorityQueue.element());

        }

        for(Map.Entry<Integer,Integer> m: map.entrySet())
        {
            priorityQueue.add(m);
        }

        findTotalTime(priorityQueue, orderNum,map);

    }

    private static void findTotalTime(Queue<Map.Entry<Integer, Integer>> priorityQueue, int orderNum, HashMap<Integer, Integer> map) {
        int totalTime = 0;

        while(!priorityQueue.isEmpty())
        {
            int value = Collections.max(map.values());
            System.out.println("Value : "+value);
            int key = 0;
            for(Map.Entry<Integer, Integer> pair: map.entrySet())
            {
                if(pair.getValue() == value)
                key = pair.getKey();
            }
            Map.Entry<Integer,Integer> pair = priorityQueue.poll();
            int pairKey = pair.getKey(), pairValue=pair.getValue();

            System.out.println("pairKey : " +pairKey+ "pairValue : " +pairValue);
            System.out.println();
            if(pairKey==orderNum)
            {
                if(pairValue==value)
                {
                    totalTime +=2;
                    map.remove(pairKey);
                    System.out.println("Total Processing Time : " + totalTime);
                    break;
                }
                else{
                    priorityQueue.add(pair);
                    continue;
                }
            }
            else if(pairKey != orderNum)
            {
                if(pairValue < value)
                {
                    priorityQueue.add(pair);
                    continue;
                }
                else
                {
                    totalTime +=2;
                    map.remove(pairKey);
                    //System.out.println("Total Processing Time : " + totalTime);
                    //break;
                }
            }
        }
    }
}
