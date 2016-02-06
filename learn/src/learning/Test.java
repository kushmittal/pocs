package learning;

public class Test {
	
	public static void main(String ...args)
 {
		if (args == null || !(args.length == 2))
			System.out.println("0,0");
		int small = Integer.valueOf(args[0]) > Integer.valueOf(args[1]) ? Integer
				.valueOf(args[1]) : Integer.valueOf(args[0]);
		int large = Integer.valueOf(args[0]) > Integer.valueOf(args[1]) ? Integer
				.valueOf(args[0]) : Integer.valueOf(args[1]);
		int n = 0;
		while (small != 0) {
			n = small;
			small = large % small;
			large = n;
		}
		System.out.println(n);
	}

}
