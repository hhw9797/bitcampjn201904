package test;

public class Test {
	
	public static int miniValue(int[] arr) {
		int mini = arr[0];
		
		for(int i=1; i<arr.length; i++) {
			if(arr[i]<mini) {
				mini = arr[i];
			}
		}
		return mini;
	}
	
	public static int maxValue(int[] arr) {
		int max = arr[0];
		
		for(int i=1; i<arr.length; i++) {
			if(arr[i]>max) {
				max = arr[i];
			}
		}
		return max;
	}

}
