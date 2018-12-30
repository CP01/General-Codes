package cp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class StringQue {

	public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Set<String> set = new HashSet<>();
        int size = 1;
        while(size<=str.length()) {
            for(int i=0;i<str.length();i++)
            {
                StringBuilder sb = new StringBuilder("");
                for(int j=0; j<size && (i+j)<str.length(); j++)
                {
                    sb.append(str.charAt(i+j)+"");
                }
                set.add(sb.toString());
                //System.out.println(sb.toString());
                if(size==str.length())
                	break;
            }
            size++;
        }
        System.out.println(set.size());
        

    
	}

}
