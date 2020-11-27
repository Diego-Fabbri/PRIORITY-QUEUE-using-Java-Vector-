
public class UsePriorityQueue {

	public static void main(String[] args) {
		double[] V = { 5,2,7,2,6,8,0,9,1,4 };
		System.out.print("Input vector:  ");
		Sort.print(V);		
		Sort.heapSort(V);
		System.out.print("Sorted vector: ");
		Sort.print(V);
	}
	
}
