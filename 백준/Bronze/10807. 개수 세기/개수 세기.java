import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int [] arr = new int[N];
		
		
		for(int i=0; i<N; i++) {
			
			arr[i] = sc.nextInt();
		}
		
		int count = 0;
		int v = sc.nextInt();
		for(int i=0; i<N; i++) {
			if (arr[i] == v) {
				count=count+1;
				
			}
		}
				
		System.out.println(count);
		sc.close();

	}

}