//encoding Shift-JIS

package boot;

import logic.TimeFormat;
import logic.ProgressBar;
import out.Display;

//100%|■■■■■■■■■■| 100/100 [01:40<00:00,  1.00s/it]

public class Tqdm {
  private TimeFormat tf;

	private final int totalFmt;
	private int nowFmt;

  private int per;
  private String progressBar;
  private long startTime;
  private long nowTime;
  private double averageTime;


  //constructor
	public Tqdm(int totalFmt) {
		this.totalFmt = totalFmt;
		this.nowFmt = 1;
    this.progressBar = "――――――――――";
    this.per = 0;
    this.startTime = System.currentTimeMillis();
    this.averageTime = 0;

    this.tf = new TimeFormat("mm:ss");
	}

  public void tqdm(){
    this.nowTime = System.currentTimeMillis();
    int per = culcPer(this.nowFmt, this.totalFmt);
    makeProgressBar(per);
    long duration = this.nowTime - this.startTime;
    String durationStr = tf.format(duration).toString();
    this.averageTime = culcAverageTime(duration, this.nowFmt);
    String remainingStr = tf.format(culcRemaining(this.averageTime, this.totalFmt - this.nowFmt)).toString();
    Display.print(this.per, this.progressBar, this.nowFmt, this.totalFmt, durationStr, remainingStr, this.averageTime);
    this.nowFmt++;
  }



  private String makeProgressBar(int per){
    if(per != this.per){
      this.per = per;
      this.progressBar = ProgressBar.makeProgressBar(this.per);
    }
    return this.progressBar;
  }
  private int culcPer(int nowFmt, int totalFmt){
    if(totalFmt<=0) return -1;
    return (int)Math.floor((double)this.nowFmt/(double)this.totalFmt*100);
  }
  private long culcRemaining(double averageTime, int remainFmt){
    if(remainFmt<=0) return -1;
    return (int)Math.floor(averageTime * 1000) * remainFmt;
  }
  private double culcAverageTime(long time, int num){
    String str = String.format("%.2f", ((time/1000) / (double)num));

    return Double.parseDouble(str);
  }

  public int gettotalFmt(){
    return this.totalFmt;
  }
  public int getnowFmt(){
    return this.nowFmt;
  }
  public String getProgressBar(){
    return this.progressBar;
  }
  public int getPer(){
    return this.per;
  }
  public String getStartTime(){
    //return this.startTime;
    return null;
  }
  public String getEndTime(){
    //return this.endTime;
    return null;
  }
}
