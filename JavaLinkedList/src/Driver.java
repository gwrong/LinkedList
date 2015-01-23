import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This is where the main method is
 * 
 * @author Graham Wright
 * @version 1.0
 */
public class Driver {

	private static int currentIndex = 0;
	
	/**
	 * Returns the options for the user
	 * Commands: add, remove, current, next
	 * previous, reverse, list, exit
	 * Locations: front, back, or index
	 * 
	 * @return The user options in a String
	 */
	private static String mainMenu() {
        String menu = "Enter a command : ";
        return menu;
    }
	
	/**
	 * Handles adding to the list
	 * 
	 * @param list The DoublyLinkedList
	 * @param scan The scanner used to get input
	 */
	private static void optionAdd(DoublyLinkedList<Integer> list, Scanner scan) {
		boolean needInput = true;
		boolean firstTime = true;
		int number = 0;
		while (needInput) {
			System.out.print("What number would you like to add? ");
			try {
				if (!firstTime) {
					scan.nextLine();
				}
				number = scan.nextInt();
				needInput = false;
			} catch (InputMismatchException e) {
		    	System.out.println("That is not a number");
		    	firstTime = false;
			}
		}
    	scan.nextLine();
		System.out.print("Where would you like to add? ");
		String index = scan.nextLine();
		if (index.equalsIgnoreCase("front")) {
			if (!list.isEmpty()) {
				currentIndex++;
			}
			list.add(0, number);
		} else if (index.equalsIgnoreCase("back")) {
			list.add(list.size(), number);
		} else {
			try {
				int numIndex = Integer.parseInt(index);
				list.add(numIndex, number);
				if (numIndex <= currentIndex) {
					currentIndex++;
				}
			} catch (NumberFormatException e) {
				System.out.println("That is not a valid location. Try adding again.");
			}
		}
    }
	
	/**
	 * Handles removing from the list
	 * 
	 * @param list The DoublyLinkedList
	 * @param scan The scanner used to get input
	 */
	private static void optionRemove(DoublyLinkedList<Integer> list, Scanner scan) {
		boolean correctChoice = false;
		boolean isNumber = false;
		int option = 0;
		while (!correctChoice) {
			System.out.println("Would you like to remove from an index (1) or remove a certain element (2)?");
			try {
				option = scan.nextInt();
				scan.nextLine();
				isNumber = true;
			} catch (InputMismatchException e) {
				scan.nextLine();
				System.out.println("That is not a valid choice.");
			}
			if (option == 1 || option == 2) {
				correctChoice = true;
			} else if (isNumber) {
				System.out.println("That is not a valid choice.");
			}
		}
		
		if (option == 1) {
			System.out.print("Where would you like to remove? ");
			String index = scan.nextLine();
			if (index.equalsIgnoreCase("front")) {
				list.remove(0);
				currentIndex--;
			} else if (index.equalsIgnoreCase("back")) {
				if (currentIndex >= list.size() - 1) {
					currentIndex--;
				}
				list.remove(list.size() - 1);
			} else {
				try {
					int numIndex = Integer.parseInt(index);
					list.remove(numIndex);
					if (numIndex < currentIndex) {
						currentIndex--;
					}
				} catch (NumberFormatException e) {
					System.out.println("That is not a valid location. Try removing again.");
				}
				
			}
		} else {
			boolean validInput = false;
			int num = 0;
			while (!validInput) {
				System.out.print("What would you like to remove? ");
				try {
					num = scan.nextInt();
					scan.nextLine();
					validInput = true;
				} catch (InputMismatchException e) {
					scan.nextLine();
					System.out.println("That is not a valid choice.");
				}

			}
			list.remove(new Integer(num));
		}
    }
	
	
	/**
	 * Prints the cursor's current place
	 * 
	 * @param list The DoublyLinkedList
	 */
	private static void optionCurrent(DoublyLinkedList<Integer> list) {
		if (currentIndex > -1 && currentIndex < list.size()) {
    		System.out.print("Result: " + list.get(currentIndex).toString());
        	System.out.println();
    	} else {
    		System.out.print("There is nothing there!");
    		System.out.println();
    	}
    }
	
	/**
	 * Gets the next cursor pointer
	 * 
	 * @param list The DoublyLinkedList
	 */
	private static void optionNext(DoublyLinkedList<Integer> list) {
		currentIndex++;
    	if (currentIndex < list.size()) {
    		System.out.print("Result: " + list.get(currentIndex).toString());
    		System.out.println();
    	} else {
    		if (currentIndex > list.size()) {
    			currentIndex = list.size();
    		}
    		System.out.print("There is nothing there!");
    		System.out.println();
    	}
    }
	
	/**
	 * Gets the previous cursor pointer
	 * 
	 * @param list The DoublyLinkedList
	 */
	private static void optionPrevious(DoublyLinkedList<Integer> list) {
		currentIndex--;
    	if (currentIndex > -1) {
    		System.out.print("Result: " + list.get(currentIndex));
    		System.out.println();
    	} else {
    		if (currentIndex < -1) {
        		currentIndex++;
    		}
    		System.out.print("There is nothing there!");
    		System.out.println();
    	}
    }
	
	
	/**
	 * Prints the list
	 * 
	 * @param list The DoublyLinkedList
	 */
	private static void optionList(DoublyLinkedList<Integer> list) {
		System.out.print("List: ");
    	for (Integer integer : list) {
    		System.out.print(integer.toString() + " ");
    	}
    	System.out.println();
    }

	/**
	 * The main method
	 * 
	 * @param args The command line argument
	 */
	public static void main(String[] args) {
		
		DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
		Scanner scan = new Scanner(System.in);
		boolean keepGoing = true;
		System.out.println("Your DoublyLinkedList has 0 elements.");

        while (keepGoing) {
            System.out.print(Driver.mainMenu());
            String input = scan.nextLine();

            if (input.equalsIgnoreCase("add")) {
            	Driver.optionAdd(list, scan);
            } else if (input.equalsIgnoreCase("remove")) {
            	Driver.optionRemove(list, scan);
            } else if (input.equalsIgnoreCase("current")) {
            	Driver.optionCurrent(list);
            } else if (input.equalsIgnoreCase("next")) {
            	Driver.optionNext(list);
            } else if (input.equalsIgnoreCase("previous")) {
            	Driver.optionPrevious(list);
            } else if (input.equalsIgnoreCase("reverse")) { 
            	list.reverseList();
            } else if (input.equalsIgnoreCase("list")) {
            	Driver.optionList(list);
            } else if (input.equalsIgnoreCase("exit")) {
            	System.out.println("Goodbye.");
            	keepGoing = false;
            } else {
                System.out.println("That is not a valid choice. Try again");
            }   
        }
	}
}
