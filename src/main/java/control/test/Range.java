package control.test;

public class Range {

	public static int[] range(int n){
		int arr[] = new int[n];
		for(int i=0;i<n;i++){
			arr[i] = i;
		}
		return arr;
	}
	
	public static int[] range(int start, int end){
		int len = end - start;
		int arr[] = new int[len];
		for(int i=start;i<len;i++){
			arr[i] = i;
		}
		return arr;
	}
	
	public static int[] range(int start, int end, int step){
		return null;
	}
	/**
	 *HappyBoyLi
	 *2017-1-21 ÏÂÎç2:39:40
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i:range(5)){
			System.out.println(i);
		}
	}

}
