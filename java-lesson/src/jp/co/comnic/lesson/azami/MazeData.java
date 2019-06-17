package jp.co.comnic.lesson.azami;

public class MazeData {
	  private int width;  // 迷路の横の大きさ
	  private int height;  // 迷路の縦の大きさ
	  public byte[] data;  // 実際の迷路データ


	  public void setWidth(int value) {
	    if (value > 1)
	      width = value;
	  }
	  public int getWidth() { return width; }
	  public void setHeight(int value) { height = value; }
	  public int getHeight() { return height; }
	  
	  public static final byte PATH = 0;  // 通路
	  public static final byte WALL = 1;  // 壁
	  public static final byte ENTRANCE = 2;  // 入口
	  public static final byte EXIT = 3;  // 出口

}
