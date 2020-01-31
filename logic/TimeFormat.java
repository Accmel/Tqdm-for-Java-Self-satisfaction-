package logic;

//Please use "TimeFormat" like SimpleDateFormat
public class TimeFormat{
  private String pattern;

  private int minuteIndex;
  private int secondIndex;

  public TimeFormat(String pattern){
    this.pattern = pattern;
    StringBuilder sb = new StringBuilder(pattern);
    //minute
    this.minuteIndex = sb.indexOf("mm");
    if(this.minuteIndex == -1) throw new IllegalArgumentException("フォーマットパターンに\"mm\"を含めてください。");

    //second
    this.secondIndex = sb.indexOf("ss");
    if(this.secondIndex == -1) throw new IllegalArgumentException("フォーマットパターンに\"ss\"を含めてください。");
  }

  public StringBuilder format(long durationMili){
    int durationInt = (int)durationMili/1000;

    int minute = durationInt/60;
    int second = durationInt%60;

    return format(minute, second);
  }

  public StringBuilder format(int minute, int second){
    String mm;
    String ss;
    if(minute < 10){
      mm = "0" + String.valueOf(minute);
    }else{
      mm = String.valueOf(minute);
    }
    if(second < 10){
      ss = "0" + String.valueOf(second);
    }else{
      ss = String.valueOf(second);
    }

    StringBuilder sb = new StringBuilder(this.pattern);
    //minute
    sb.replace(this.minuteIndex, minuteIndex+2, mm);
    //second
    sb.replace(this.secondIndex, secondIndex+2, ss);

    return sb;
  }

  public String getPattern(){
    return this.pattern;
  }

  @Override
  public boolean equals(Object obj){
    if(obj == null) return false;
    if(obj == this) return true;

    if(obj instanceof TimeFormat){
      TimeFormat tf = (TimeFormat)obj;

      if(tf.getPattern().equals(this.pattern)) return true;
    }

    return false;
  }


}
