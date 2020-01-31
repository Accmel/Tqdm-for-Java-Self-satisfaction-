package logic;

public class ProgressBar{
  private String progressBar;

  public ProgressBar(){
    this.progressBar = "――――――――――";
  }
  /**
  @param per Progress per (0 <= per <= 100)
  */
  public ProgressBar(int per){
    if(per<0 || 100<per) throw new IllegalArgumentException("Set per in 0 between 100");

    this.progressBar = makeProgressBar(per);
  }

  public static String makeProgressBar(int per){
    StringBuilder bar = new StringBuilder("――――――――――");
		for(int i=0; i<10 && per>=10; i++){
			bar.setCharAt(i, '■');
			per -= 10;
		}

		return bar.toString();
  }
}
