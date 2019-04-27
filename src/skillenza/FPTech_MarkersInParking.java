package skillenza;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class FPTech_MarkersInParking {

	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0) {
            int n = sc.nextInt();
            Map<Integer, Integer> map = new TreeMap<>();
            while(n>0) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                if(map.containsKey(a))
                {
                    if(map.get(a) < b)
                        map.put(a,b);
                }
                else {
                    map.put(a,b);
                }
                n--;
            }
            int prev = Integer.MIN_VALUE;
            int count = 0;
            for(Map.Entry<Integer, Integer> entry : map.entrySet()){
                int k, v;
                k = entry.getKey();
                v = entry.getValue();
                if(prev == Integer.MIN_VALUE) {
                    count = v - k + 1;
                }
                else {
                    if(k <= prev) {
                    	if(!(v<=prev))
                    		count = count + v - prev;
                    }
                    else {
                        count = count + v - k + 1;
                    }
                }
                if(prev<v)
                	prev = v;
            }
            System.out.println(count);
            t--;
        }
}

}

/*
 * 
 Number of Markers

In a metro city in Lalaland, there is a long road with markers on it after each 1 meter. There is a big International School whose vehicles are parked on the road in front of the school.

Let’s say there are N vehicles standing on the road. You are given the starting and the end point of each vehicle standing on the road. (both inclusive.)

You have to find the number of markers that are covered by at least one vehicle. A vehicle with starting point X and endpoint Y is considered to be present on a marker M if X <= M <= Y.

Note that this is a parallel parking lot. The markers cover the whole lot. And it is possible for multiple vehicles to overlap. (That supposes a vehicle is parked from starting point X to endpoint Y. It is possible for another vehicle to be parked parallelly from A to B where X<=A<=Y) As mentioned
the markers cover the whole lot.

Input:

The first line of input consists of an integer T (number of test cases). Each test case consists of the following:

    The first line of test case consists of an integer N.
    This is followed by N lines with two space-separated integers X and Y in each line. X represents the starting position and Y the ending position as described above.

Output:

For each test case, print a single integer which is the count of the number of markers with at least one vehicle
in separate lines.
 
 
 Input :
 
 7
61
30 36
75 77
25 30
98 105
53 55
64 73
95 104
85 92
34 36
86 94
52 56
38 46
57 61
21 24
49 54
30 39
23 31
71 73
49 53
49 54
34 42
46 49
97 103
3 12
44 47
34 37
55 57
43 45
78 84
34 43
99 101
59 67
74 82
71 73
4 10
31 36
38 45
72 81
13 18
19 27
68 75
59 61
77 85
88 90
70 74
35 39
91 99
92 95
29 38
93 100
88 94
76 84
54 61
14 19
76 83
29 36
38 40
21 30
42 49
23 26
36 45
83
79 86
27 33
86 91
42 44
31 35
0 7
72 79
75 77
30 32
25 30
50 54
48 52
8 15
93 96
97 99
8 10
62 64
77 79
79 84
24 28
89 92
23 27
78 83
58 64
59 64
87 95
49 58
80 88
97 100
31 35
78 84
27 29
28 30
92 101
27 30
73 75
46 48
30 32
47 53
37 46
72 78
69 76
12 19
31 34
22 27
7 9
55 63
44 49
42 45
94 97
10 15
86 92
15 21
84 93
5 8
22 25
98 103
50 54
92 96
71 79
97 105
19 25
17 26
39 44
4 7
29 33
52 61
74 83
35 40
30 36
84 90
21 25
95 101
96 105
58 67
54 59
50 57
11 16
40 48
78 85
35 40
63 68
78 86
54
14 17
37 41
37 44
28 30
85 91
68 74
62 68
78 85
42 51
32 39
96 100
91 94
21 30
8 14
81 89
14 23
99 108
2 9
93 97
61 65
38 41
54 56
21 24
21 30
40 43
76 82
91 93
81 87
71 79
72 74
40 48
0 6
90 94
81 86
88 96
65 69
75 80
78 85
56 65
64 71
56 59
85 90
61 70
11 13
13 22
40 43
21 23
97 102
46 54
50 58
24 29
12 18
39 43
1 6
93
17 19
1 9
82 88
71 74
63 72
66 70
48 57
20 22
21 26
87 92
86 89
28 35
38 44
92 98
33 35
26 30
84 93
61 65
32 34
71 80
92 95
94 96
61 65
32 40
49 54
85 94
97 100
41 50
45 48
67 71
25 28
81 85
25 33
80 87
78 80
4 12
93 101
14 18
12 21
40 48
70 74
53 62
43 47
6 9
32 36
19 26
23 25
19 25
46 52
57 64
56 64
47 54
12 16
8 15
13 15
91 96
78 80
55 63
43 46
63 72
39 43
32 41
87 93
63 66
4 11
58 64
39 43
61 70
72 75
28 35
70 79
20 26
68 73
74 79
41 44
86 88
72 80
47 56
22 27
96 100
88 97
38 43
65 67
78 85
21 30
74 79
78 82
96 104
74 78
9 14
60 65
99 101
66 71
95
40 48
91 100
98 106
9 12
15 22
3 9
35 39
26 30
41 44
26 35
99 106
1 5
57 63
13 16
14 16
88 93
22 31
26 32
30 39
97 104
97 100
50 56
15 17
14 20
53 56
0 2
38 45
18 27
97 99
88 90
96 98
19 28
7 14
91 98
32 35
35 38
94 101
65 72
65 71
70 79
73 81
23 28
71 75
10 16
26 30
84 88
78 87
93 96
4 11
27 30
78 82
70 72
51 53
85 91
20 29
39 42
25 30
56 58
57 65
69 78
68 71
57 61
13 18
31 38
92 96
6 14
72 75
46 51
17 22
44 51
87 92
34 36
98 102
13 18
60 68
38 40
91 97
74 76
3 10
74 83
68 74
17 23
61 66
68 76
98 100
19 22
47 50
2 6
47 52
1 6
53 55
39 41
92 99
1 6
23 32
42
43 48
11 20
21 25
55 64
24 33
23 27
19 25
64 71
80 89
70 75
36 40
79 81
6 12
33 36
19 21
47 51
72 76
50 57
84 87
96 103
29 38
23 29
52 57
17 23
22 27
23 27
6 14
90 96
99 105
18 22
36 39
33 35
24 33
53 55
40 44
73 76
73 79
69 76
87 95
9 12
30 33
71 73
87
14 20
86 90
18 25
26 32
42 51
12 15
92 94
17 25
98 103
68 72
60 67
86 95
55 60
81 83
71 74
27 34
17 21
75 77
75 82
76 79
92 98
94 97
64 69
79 83
54 63
61 70
97 106
18 24
98 107
44 47
68 73
6 13
89 96
25 31
87 90
33 42
41 50
16 20
43 45
72 75
47 50
64 70
84 92
0 5
33 39
4 11
68 73
39 46
96 98
74 79
70 79
67 76
35 40
21 25
31 39
27 32
79 85
75 77
26 28
51 53
72 81
13 19
70 72
50 55
21 27
54 59
31 34
6 10
57 63
48 50
74 76
19 22
72 77
73 81
23 29
10 19
80 86
36 44
80 88
21 28
62 64
96 103
49 54
12 20
35 41
47 50
40 44

Output :
103
106
108
104
107
100
108
 */
