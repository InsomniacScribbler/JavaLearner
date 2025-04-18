import java.util.ArrayList;
import java.util.List;

public class Main{
	public static void main(String[] args) {
		ArrayList<Integer> arrayList = new ArrayList<>();

//		List<Integer> list = new ArrayList<>();
		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(80);
//		System.out.println(arrayList.size());
//		System.out.println(arrayList.getFirst());
//		System.out.println(arrayList.getLast());
//		System.out.println(arrayList.getClass());
//		System.out.println(arrayList.get(2));
//		for (Integer i : arrayList){
//			System.out.println(i);
//		}
		System.out.println(arrayList.contains(5));
		arrayList.add(2,50);//adds the elements
		System.out.println(arrayList.toString());
		arrayList.set(2,30); //changes the element
		System.out.println(arrayList.toString());

	}
}