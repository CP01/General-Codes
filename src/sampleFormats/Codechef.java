package sampleFormats;

/* package codechef; // don't place package name! */
/*****************************************************************************
* BufferedReader is better than Scanner                                      *
* PrintWriter is better than Sysout                                          *
* Piece of code taken from problem https://www.codechef.com/problems/INTEST  *
******************************************************************************/
import java.io.*;
import java.util.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws IOException
	{
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out, true);
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
		int ctr = 0;
		while(n-->0)
		{
		     if(Integer.parseInt(br.readLine()) % k == 0)
		    {
		        ctr++;
		    }
		}
		System.out.println(ctr);
	}
}
/////////////////////////////////////////////////////////////////////
/*****************************************************************************
* This one is better than BufferedReader                                     *
* Code taken from Soultion at https://www.codechef.com/viewsolution/990792   *
* Piece of code taken from problem https://www.codechef.com/problems/INTEST  *
* Explained at http://stackoverflow.com/questions/37984469/java-performance- *
* and-memory-improvement-code-comparison-from-codechef                       *
******************************************************************************/

class Main{
 
	public static void main(String []args)throws Exception{
 
		byte b;
		byte barr[]=new byte[1028];
		int r=0,n=0,k=0;
		while((r=System.in.read())!= ' '){
			n=n*10+r-'0';
 
		}
		System.out.println(n);
 
		while((r=System.in.read())!='\n'){ 			//change
			k=k*10+r-'0';
 
		}
 
		System.out.println(k);
		//System.in.read();				// remove
		n=0;
		int count=0;
		while((r=System.in.read(barr,0,1028))!=-1){
 
			for(int i=0;i<barr.length;i++){
 
				b=barr[i];
 
				if(b!='\n'){			//change
			
					n=n*10+b-'0';					
 
				}
				
				else{
 
				//	i++;   			//remove
					if(n%k==0)count++;
					n=0;										
					
				}
			}
			
	
		}		
		System.out.println(count);
 
 
	}
} 
///////////////////////////////////////////////////////