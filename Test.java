import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/*Emma Chiusano
 * Date Created: 28 October 2021
 * Last Date Modified: 10 November 2021*/
public class Test {
	//main method
	public static void main(String[]args) {
		ArrayList<String>animalAL=new ArrayList();
		LinkedList<String> animalLL=new LinkedList();
		readFromFile(animalAL, animalLL, "animals.txt");
		testContains(animalAL, animalLL);
		testRemove(animalAL, animalLL);
		testAdd(animalAL, animalLL);
	}
	//O(n)
	/*Method to test the time complexity of the contains method in teh array list and linked list
	 * @param ArrayList<String> and LinkedList<String>
	 * @return none*/
	public static void testContains(ArrayList<String> al, LinkedList<String> ll) {
		int totalAL = 0;
		int totalLL = 0;
		System.out.println("Comparing the methods contains(E item)");
		System.out.println("=======================================");
		System.out.println("Animal Name\t\t\tIterations(AL)\tIterations(LL)");
		for (int i=0; i<20; i++) {
			int index=(int)(Math.random()*al.size());
			String randomName=al.get(index);
			int itAL=al.contains(randomName);
			int itLL=ll.contains(randomName);
			totalAL+=itAL;
			totalLL+=itLL;
			System.out.printf("%-25s\t%-10d\t%-10d\n", randomName, itAL, itLL);
		}
		System.out.printf("%-25s\t%-10d\t%-10d\n", "Average # iterations", totalAL/20, totalLL/20);
	}
	//O(n)
	/*Method to test the time complexity of the remove method in teh array list and linked list
	 * @param ArrayList<String> and LinkedList<String>
	 * @return none*/
	private static void testRemove(ArrayList<String> al, LinkedList<String> ll) {
		// TODO Auto-generated method stub
		int totalAL=0;
		int totalLL=0;
		System.out.println("Comparing the methods remove(E item)");
		System.out.println("====================================");
		System.out.println("Animal Name\t\t\tIterations(AL)\tIterations(LL)");
		for (int i=0; i<20; i++) {
			int index=(int)(Math.random()*al.size());
			String randomName=al.get(index);
			int itAL=al.remove(randomName);
			int itLL=ll.remove(randomName);
			totalAL+=itAL;
			totalLL+=itLL;
			System.out.printf("%-25s\t%-10d\t%-10d\n", randomName, itAL, itLL);
		}
		System.out.printf("%-25s\t%-10d\t%-10d\n", "Average # iterations", totalAL/20, totalLL/20);
	}
	//O(n)
	/*Method to test the time complexity of the add method in teh array list and linked list
	 * @param ArrayList<String> and LinkedList<String>
	 * @return none*/
	private static void testAdd(ArrayList<String> al, LinkedList<String> ll) {
		// TODO Auto-generated method stub
		int totalAL=0;
		int totalLL=0;
		System.out.println("Comparing the methods add(int index, E item)");
		System.out.println("===========================================");
		System.out.println("Animal Name\t\t\tIterations(AL)\tIterations(LL)");
		for (int i=0; i<20; i++) {
			int index=(int)(Math.random()*al.size());
			String randomName=al.get(index);
			int itAL=al.add(index,randomName);
			int itLL=ll.add(index, randomName);
			totalAL+=itAL;
			totalLL+=itLL;
			System.out.printf("%-25s\t%-10d\t%-10d\n", randomName, itAL, itLL);
		}
		System.out.printf("%-25s\t%-10d\t%-10d\n", "Average # iterations", totalAL/20, totalLL/20);
	}
	//O(n)
	/*Method to read in the animal names form the file and add them to their respective lists
	 * @param ArrayList<String> and LinkedList<String> and String filename
	 * @return none*/
	public static void readFromFile(ArrayList<String> al, LinkedList<String> ll, String filename) {
		File file=new File(filename);
		try {
			Scanner readFile=new Scanner(file);
			while (readFile.hasNext()) {
				String line=readFile.nextLine();
				al.add(line);
				ll.add(line);
			}
			readFile.close();
		}
		catch(FileNotFoundException e) {
			
		}
	}
}
/*
 * Questions:
 * 1. Explain why the number of iterations is different in the two lists for the same animal, but the 
 * average numbers of iterations are of the same order.
 * 
 * The number of iterations is different in the two lists for the same animal because the animals are randomly generated, 
 * and the lists are sorted through differently. In an array list, the data is made into a list and gets sorted through one 
 * by one until the index is found. In a linked list, the memory needs to be accessed for each item. These two different
 * methods of sorting through the lists results in, for the most part in this example, the array list being quicker. However, 
 * the two types of list are returning around the same number of iterations when they are averaged because, since the list 
 * is randomized, when you are searching a linked list, if the element is closer to the front, it will take less iterations, and 
 * along the same lines, if you are searching for an element in an array list where the element is close to the back of the list, 
 * it will take more iterations to find that element. This means that the randomness of the list organization is causing them 
 * to be on the same magnitude of iterations.
 * 
 * 
 * 
 * 2. Discuss the results you obtained for the average number of iterations against the time complexity 
 * analysis you performed when you defined the methods.
 * 
 * I would say that the average number of iterations in this program is about proportional to the time complexity of the 
 * methods inside of it. Since the lists were randomized, it makes sense that it may have taken a bit of time to iterate through
 * them. However, since there were hundreds of animals, and we only iterated through them twenty times, this helped to reduce
 * the time complexity a bit. I would say that overall, I think that the complexity was towards the lower limit of what we would have 
 * expected, but that they definitely did take up quite a bit of iterations. Based on the complexity of how they were sorted through and 
 * how the list was generated, the complexity could have changed from time to time, as seen in the question above. 
 * */
