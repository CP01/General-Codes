package skillenza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GreyTip_EmpFiring {

	public static void main(String[] args) {
	    try {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        int t = Integer.parseInt(br.readLine());
	        while (t>0) {
	            String[] ecd = br.readLine().split(" ");
	            int e,c,d;
	            e = Integer.parseInt(ecd[0]);
	            c = Integer.parseInt(ecd[1]);
	            d = Integer.parseInt(ecd[2]);
	            String charOfExEmp[] = br.readLine().split(" ");
	            Long exEmpChar[] = Arrays.stream(charOfExEmp).map(Long::parseLong).toArray(Long[]::new);
	            int toBeFired = 0;
	            for(int i=1;i<=e;i++) {
	                String empChar[] = br.readLine().split(" ");
	                int charCtr = 0;
	                for(int j=0; j<c && charCtr<=d ;j++) {
	                    if(Long.parseLong(empChar[j]) != exEmpChar[j]) {
	                        charCtr++;
	                    }
	                }
	                if(charCtr<=d)
	                {
	                    toBeFired++;
	                }
	            }
	            System.out.println(toBeFired);
	            t--;
	        }

			} catch (IOException e) {
				e.printStackTrace();
			}

	    }

}
