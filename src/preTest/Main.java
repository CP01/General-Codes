package preTest;

/* Do not add a package declaration */
import java.util.*;
import java.io.*;


public class Main {
    public static int processData(ArrayList<String> array) {
        ArrayList<Servers> serverList = new ArrayList<>();
        for(String str : array)
        {
        	serverList.add(new Servers(str));
        	
        }
        Collections.sort(serverList, new Comparator<Servers>() {

			@Override
			public int compare(Servers o1, Servers o2) {
				String str1 = o1.toString();
				String str2 = o2.toString();
				return str2.compareTo(str1);
			}
		});
        int result = 0;
        for(int i=0;i<serverList.size();i++)
        {
        	int obsoleteVerCtr = 0;
        	if(serverList.get(i).used)
        		continue;
        	for(int j=0;j<serverList.size();j++)
        	{
        		if(serverList.get(i).solution(serverList.get(j))!=0)
        		{
        			serverList.get(j).used = true;
        			obsoleteVerCtr++;
        		}
        	}
        	serverList.get(i).used = true;
        	if(obsoleteVerCtr>=2)
        		result++;
        }
        return result;
    }

    public static void main (String[] args) {
        ArrayList<String> inputData = new ArrayList<String>();
        try {
            Scanner in = new Scanner(new BufferedReader(new FileReader("D:\\folder\\WS\\GeneralCodes\\src\\preTest\\input.txt")));
            while(in.hasNextLine()) {
                String line = in.nextLine().trim();
                if (!line.isEmpty()) // Ignore blank lines
                    inputData.add(line);
            }
            int retVal = processData(inputData);
            PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("D:\\folder\\WS\\GeneralCodes\\src\\preTest\\output.txt")));
            output.println("" + retVal);
            output.close();
        } catch (IOException e) {
            System.out.println("IO error in input.txt or output.txt");
        }
    }
}

class Servers {
	private int server;
	private String type;
	private String name;
	private int version;
	public boolean used = false;
	
	Servers(String input)
	{
		String list[] = input.split(",");
		this.server = Integer.valueOf(list[0].substring(6, 7));
		this.type = list[1].trim().toLowerCase();
		this.name = list[2].trim().toLowerCase();
		String ver[] = list[3].trim().split("\\.");
		if(ver.length==3)
		{
			this.version = Integer.valueOf(ver[0]+ver[1]+ver[2]);
		}
		else if(ver.length==2)
		{
			this.version = Integer.valueOf(ver[0]+ver[1]);
		}
		else {
			this.version = Integer.valueOf(ver[0]);
		}
	}
	
	public String toString()
	{
		return type+name+version;
	}
	
	/* 0=same server
	 * 1=ver > cur ver
	 * -1=ver < cur ver
	 */
	public int solution(Servers obj) {
		int result = 0;
		if(this.server!=obj.server)
		{
			if(this.type.equals(obj.type) && this.name.equals(obj.name))
			{
				result = this.version>obj.version ? 1 : (this.version<obj.version ? -1 : 0);
			}
		}
		return result;
	}
}