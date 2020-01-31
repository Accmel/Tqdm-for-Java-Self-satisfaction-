//encoding Shift-JIS
package out;


//100%|■■■■■■■■■■| 100/100 [01:40<00:00,  1.00s/it]
//print per
//print progressBar
//print now / all
//print {elapsed(経過)}<{remaining(残存)}
//print rate_fmt

public class Display{
	//Display progressBar
	public static void print(int per, String bar, int nowIndex, int allIndex, String elapsed, String remaining, double rate_fmt){
		//"\r"
		System.out.print("\r");
		//print progressBar
		//print per
		printPer(per);
		//print bar
		printBar(bar);

		System.out.print(" ");

		//print now / all
		printNowDivAll(nowIndex, allIndex);

		System.out.print(" ");
		System.out.print("[");

		//print {elapsed(経過)}<{remaining(残存)}
		printElapsedAndRemaining(elapsed, remaining);

		System.out.print(",");
		System.out.print(" ");

		//print rate_fmt
		printRateFmt(rate_fmt);

		System.out.print("]");
	}
	public static void printPer(int per){
		System.out.print(per + "%");
	}
	public static void printBar(String bar){
		System.out.print("|" + bar + "|");
	}
	public static void printNowDivAll(int nowIndex, int allIndex){
		System.out.print(nowIndex + "/" + allIndex);
	}
	public static void printElapsedAndRemaining(String elapsed, String remaining){
		System.out.print(elapsed + "<" + remaining);
	}
	public static void printRateFmt(double rate_fmt){
		System.out.print(rate_fmt + "s/it");
	}

/*
	public static void tqdm() {
		nowIndex++;

		System.out.print("\r");
		String bar = makeProgressBar();
		System.out.print(bar + "   ");
		System.out.print(nowIndex + "/ " + allIndex);
	}

	private String makeProgressBar(){
		int per = (int)Math.floor((double)nowIndex/(double)allIndex*10);

		
	}
	*/
}
