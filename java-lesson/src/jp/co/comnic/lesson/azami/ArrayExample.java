package jp.co.comnic.lesson.azami;

public class ArrayExample {

	public static void main(String[] args) {
            

	
	   
	    int [][]array2 =new  int[10][10];
	  
//	    System.out.println("課題1の2次元配列");
//	    for(int i=0;i<array2.length;i++)
//	    {
//	    	for (int j = 0; j <array2[j].length; j++) {
//				System.out.println(array2[i][j]);
//			}
//	    }
//	    System.out.println("課題2の2次元配列");
//	    for(int[] value:array2)
//	    {
//	    	for(int x:value)
//	    	{
//	    		System.out.println(x);
//	    	}
//	    }
    
	    for(int i=0;i<array2.length;i++)
	    {
	    	for (int j = 0; j <array2[i].length; j++) {
	    		if(i==0&&j==0)
	    		{
	    			System.out.println("  "+"");
	    		}
	    		else if(i==0||j==0)
	    		{
	    			if(i==0)
	    			{
	    				System.out.print(j);
	    			}
	    			else {
	    				System.out.print(i);
	    			}
	    		}
	    		else {
					System.out.print(i*j);
	    		}
	    		
	    	}
	    	System.out.println();
	    }
    }
}
