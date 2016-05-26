import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ScrabbleSolver extends PriorityQueueComparator {

	static PriorityQueueComparator pqc = new PriorityQueueComparator();
	static Scanner dict;

	public static void main(String args[]) throws FileNotFoundException {

		System.out.println("Enter Letters: ");
		Scanner input = new Scanner(System.in);

		String answer = input.nextLine();

		PriorityQueue<String> pq = new PriorityQueue<String>(pqc);
		pq = generator(answer);

		System.out.println("Here are your possible words:" + "\n");
		for (int i = 0; i < 10; i++) {
			if (pq.isEmpty() == false)
				System.out.println(pq.poll());
		}

	}

	public static PriorityQueue<String> generator(String in) throws FileNotFoundException {

		PriorityQueue<String> pq = new PriorityQueue<String>(pqc);
		Scanner dict = new Scanner(new File("ADD LOCATION OF DICTIONARY.txt -> FOUND ON GITHUB"));

		do {

			String current = dict.nextLine();
			String temp = in;
			boolean valid = true;

			for (int i = 0; i < current.length() && valid == true; i++) {

				if ((temp.indexOf(String.valueOf(current.charAt(i)))) > -1) {

					temp = temp.replaceFirst(String.valueOf(current.charAt(i)), "");
				}

				else

					valid = false;
			}


			if (valid == true) {

				pq.add(current);
			}

		}

		while (dict.hasNext());

		dict.close();

		return pq;

	}
}
