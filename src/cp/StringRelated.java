package cp;

import java.util.ArrayList;
import java.util.List;

public class StringRelated {

	public static void main(String[] args) {

		String str = "hereiamstackerrank";
		hackerrankInString(str);
	}

	static String hackerrankInString(String s) {
		// Complete this function
		s = s.toLowerCase();
		int sp = -1;
		List<Integer> hArr = new ArrayList<>();
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i) == 'h')
			{
				hArr.add(i);
			}
		}
		for(int i=0;i<hArr.size();i++)
		{
			int curCh = hArr.get(i);
			int newCh = s.indexOf('a',curCh);
			if(newCh>curCh)
			{
				curCh = newCh;
				newCh = s.indexOf('c',curCh);
				if(newCh>curCh)
				{
					curCh = newCh;
					newCh = s.indexOf('k',curCh);
					if(newCh>curCh)
					{
						curCh = newCh;
						newCh = s.indexOf('e',curCh);
						if(newCh>curCh)
						{
							curCh = newCh;
							newCh = s.indexOf('r',curCh);
							//
							if(newCh>curCh)
							{
								curCh = newCh;
								newCh = s.indexOf('r',curCh+1);
								if(newCh>curCh)
								{
									curCh = newCh;
									newCh = s.indexOf('a',curCh);
									if(newCh>curCh)
									{
										curCh = newCh;
										newCh = s.indexOf('n',curCh);
										if(newCh>curCh)
										{
											curCh = newCh;
											newCh = s.indexOf('k',curCh);
											if(newCh>curCh)
												return "YES";
										}
									}
								}
							}
							//   
						}
					}
				}
			}
		}
		return "NO";
	}

	
}
