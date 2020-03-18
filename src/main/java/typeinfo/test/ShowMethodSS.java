package typeinfo.test;

import java.util.regex.Pattern;

public class ShowMethodSS {
	
	private static String usage = 
			"usage:\n" +
				    "ShowMethods qualified.class.name\n" +
				    "To show all methods in class or:\n" +
				    "ShowMethods qualified.class.name word\n" +
				    "To search for methods involving 'word'";
	private static Pattern p = Pattern.compile("\\w+\\.");
	

	/**
	 *HappyBoyLi
	 *2017-1-26 ÏÂÎç4:01:32
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length < 1){
			System.out.println(usage);
			System.exit(0);
		}
		int lines = 0;
		try {
			Class<?> c= Class.forName(args[0]);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
