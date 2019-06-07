package algos;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class ActivitySelectionProblem {

	public static void main(String[] args) {

		/* Other Sample Code - starts*/
		String A[] = {"2", "1", "5", "3", "4"};
		String B[] = {"6", "7", "5", "3", "4"};
        SortedSet<String> aSet = new TreeSet<>(Arrays.asList(A));
        SortedSet<String> bSet = new TreeSet<>(Arrays.asList(B));
        System.out.println(aSet);
        for(String x : bSet) {
			if(aSet.contains(x))
				aSet.remove(x);
			else
				aSet.add(x);
		}
        String res = aSet + "";
        res = res.replace("[","{");
        res = res.replace("]","}");
        System.out.println(res);
        Integer aa[] = Arrays.stream(A).map(Integer::parseInt).toArray(Integer[]::new);
        		//Arrays.stream(Arrays.stream(A).mapToInt(Integer::parseInt).toArray()).boxed().toArray(Integer[]::new);
        System.out.println(aa[0]);
        System.exit(0);
        /* Other Sample Code - ends*/
        
        
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0) {
            int n = sc.nextInt();
        	sc.nextLine();
        	TreeMap<Double, Double> map = new TreeMap<>();
        	int ctr = 0;
        	Double prevEndTime = 0d;
            while(n>0) {
                String str = sc.nextLine();
                String[] strArr = str.split(" ");
                str = strArr[1].substring(strArr[1].indexOf(":")+1);
                double dec = Double.valueOf(str);
                double start = Double.valueOf(strArr[1].substring(0, strArr[1].indexOf(":")));
                dec = dec/60;
                start = start + dec;
                
                str = strArr[2].substring(strArr[2].indexOf(":")+1);
                dec = Double.valueOf(str);
                double end = Double.valueOf(strArr[2].substring(0, strArr[2].indexOf(":")));
                dec = dec/60;
                end = end + dec;
                //System.out.println(strArr[0] + " " +start + " to "+end);
                if(map.containsKey(end)) {
                	if(start>map.get(end)) {
                		map.put(end, start);
                	}
                }
                else {
                	map.put(end, start);
                }
                n--;
            }
            System.out.println(map);
            for(Map.Entry<Double, Double> entry : map.entrySet()) {
            	if(entry.getValue() >= prevEndTime) {
            		prevEndTime = entry.getKey();
            		ctr++;
            	}
            }
            System.out.println(ctr);
            t--;
        }
	}

}

// https://www.geeksforgeeks.org/activity-selection-problem-greedy-algo-1/

/*
 Sample Input

2
4
Maths 16:00 18:00
ComputerScience 12:00 18:00
Physics 12:30 14:00
Chemistry 18:00 19:30
5
Geography 14:00 16:00
History 12:00 14:30
Arts 14:00 16:30
Literature 12:30 13:30
German 13:30 15:00

Sample Output

2
2
 */
 