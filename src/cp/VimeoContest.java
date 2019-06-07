package cp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;

/**
 Coloring Tree - Vimeo Hacker Earth Contest
 Unsolved - Getting TLE 
 */

public class VimeoContest {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         PrintWriter wr = new PrintWriter(System.out);
         String[] N_Q = br.readLine().split(" ");
         int N = Integer.parseInt(N_Q[0]);
         int Q = Integer.parseInt(N_Q[1]);
         int[] T = new int[Q];
         int[] V = new int[Q];
         int Type1 = 0 ;
         //Type1 denotes the number of Type 1 queries.
         for(int i_T=0; i_T<Q; i_T++)
         {  String[] arr_T = br.readLine().split(" ");
         	T[i_T] = Integer.parseInt(arr_T[0]);
         	V[i_T] = Integer.parseInt(arr_T[1]);
         	if(T[i_T]==1) Type1++ ; 
         	
         }
         
         int[] out_ = ColoringTree(N, T, V, Q, Type1);
         System.out.print(out_[0]+"\n");
         for(int i_out_=1; i_out_<out_.length; i_out_++)
         {
         	System.out.print(out_[i_out_]+"\n");
         }

         wr.close();
         br.close();
    }
    static int[] ColoringTree(int N, int[] T, int[] V,int Q, int Type1){
        // Write your code here
        int[] res = new int[Type1];
        int out = 0;
       Node root = Node.initialize(N);
       int toClr = 1;
       for(int i=0;i<Q;i++) {
           if(T[i] == 2) {
           System.out.println(T[i] + " type - vertex "+V[i]);
               Node.fillColor(root, V[i], toClr);
               toClr++;
           }
           else {
               res[out] = Node.findColor(root, V[i]);
               out++;
           }
       }
       return res;
    }
}

class Node {
    @Override
	public String toString() {
		// TODO Auto-generated method stub
		return new String(val+"");
	}

	int clr = 0, val;
    Node l = null, r = null;
    
    Node(int val) {
        this.val = val;
    }
    
    public static Node initialize(int n) {
        int i = 0;
        Node root = new Node(++i);
        Node end = root;
        Queue<Node> q  = new LinkedList<>();
        q.add(root);
        while(i<n) {
        	end = q.remove();
            end.l = new Node(++i);
            end.r = new Node(++i);
            q.add(end.l);
            q.add(end.r);
        }
        print(root);
        return root;
    }
    
    public static void print(Node root) {
    	Queue<Node> q = new LinkedList<>();
    	q.add(root);
    	while(!q.isEmpty()) {
    		Node cur = q.remove();
    		if(cur!=null && cur.l != null && cur.r !=  null)
    			System.out.println(cur.l.val + " <- "+cur.val+" -> "+cur.r.val);
    		else if(cur != null && cur.l != null)
    			System.out.println(cur.l.val + " <- "+cur.val+" -> null");
    		else if(cur != null)
    			System.out.println("null <- "+cur.val+" -> null");
    		if(cur != null) {
    			q.add(cur.l);
    			q.add(cur.r);
    		}
    			
    	}
    }
    
    public static void fillColor(Node root, int v, int nextClr) {
        Node cur = root;
        Queue<Node> q = new LinkedList<>();
        Queue<Node> qToClr = new LinkedList<>();
        q.add(cur);
        while(true) {
            if(q.isEmpty()) {
                throw new RuntimeException("Invalid Input");
            }
            cur = q.remove();
            if(cur == null)
            {
                continue;
            }
            if(cur.val == v)
            {
                qToClr.add(cur.l);
                qToClr.add(cur.r);
           System.out.println(qToClr);
                break;
            }
            q.add(cur.l);
            q.add(cur.r);
        }
        while(!qToClr.isEmpty()) {
            cur = qToClr.remove();
            if(cur==null) {
                continue;
            }
            cur.clr = nextClr;
            System.out.println(v+"-v nClr-"+nextClr+" "+cur.val + " has "+cur.clr);
            qToClr.add(cur.l);
            qToClr.add(cur.r);
            
        }
    }
    
    public static int findColor(Node root, int x) {
        Node cur = root;
        Queue<Node> q = new LinkedList<>();
        q.add(cur);
        while(true) {
            if(q.isEmpty()) {
                throw new RuntimeException("Invalid Input");
            }
            cur = q.remove();
            if(cur == null)
            {
                continue;
            }
            if(cur.val == x)
            {
                return cur.clr;
            }
            q.add(cur.l);
            q.add(cur.r);
        }
        
    }
    
    
}



/*
Coloring Tree

You are given a complete binary tree with 
vertices rooted with vertex

. A complete binary tree is a binary tree in which every level, except possibly the last, is completely filled, and all nodes are as far left as possible.

The level order traversal of the tree from left to right is given by

.

Initially, all vertices are colored with color

.

We have given  
  queries each consisting of two letters and

.

If
, then answer the color of vertex

.

If
, then color all the vertex of the subtree rooted with vertex with color which is numbered more than the color used in the previous query of this type. We use color

in the first query of this type.

​​​​​​Input

The first line contains two space-separated integers 
and denoting the number of vertices in tree and number of queries respectively.
The next  lines contains  space-separated integers denoting and

for the given query.

Output

For each query with
, output the color of vertex

in a single line.

Constraints

Sample Input

10 7

1 5

2 2

1 5

1 8

1 1

2 3

1 6

Sample Output

0

1

1

0

2

Explanation

Initially, all nodes are colored with color

.

So for the first query, the answer is

.

In the second query, all vertices in the subtree rooted with vertex
are colored with color . So, vertices are colored with color

.

So, for the third query and fourth query, the answer is

.

For the fifth query, the answer is
because the color of vertex is still

.

In the sixth query, all vertices in the subtree rooted with vertex
are colored with color . So, vertices  are colored with color

.

So, for the fifth query, the answer is
.

*/