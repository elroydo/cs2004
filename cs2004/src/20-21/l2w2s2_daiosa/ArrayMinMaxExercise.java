package l2w2s2_daiosa;

public class ArrayMinMaxExercise {

	public static void main(String[] args) {
		double arr[] = {3, 34, 1, 65, 23, 45, 2, 86};
		
		System.out.println("maxval=" + ArrayMax(arr));
		System.out.println("minval=" + ArrayMin(arr));
	}
	
	public static double ArrayMax(double a[]) {
		double CurrentMax = a[0];
		
		for(int i=1; i<a.length; i++) {
			if(a[i]>CurrentMax) {
				CurrentMax = a[i];
			}
		}
		return CurrentMax;
	}
	
	public static double ArrayMin(double a[]) {
		double CurrentMax = a[0];
		
		for(int i=1; i<a.length; i++) {
			if(a[i]<CurrentMax) {
				CurrentMax = a[i];
			}
		}
		return CurrentMax;
	}
}
