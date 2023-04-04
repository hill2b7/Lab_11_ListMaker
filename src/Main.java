import java.util.ArrayList; //import of java arraylist
import java.util.Scanner; //import of java scanner

public class Main
{
    static ArrayList<String> list = new ArrayList<>(); // creation of new array
    static Scanner in =new Scanner(System.in); //creation of new scanner

    public static void main(String[] args)
    {

        boolean done = false; // declaration of variable
        String userChoice = ""; // declaration of variable
        final String menu = "A - Add D - Delete P - Print Q - Quit";  //sets menu to a final string because it never changes
        do //Start of loop that will run until the while condition is met
        {
            showList();
            //display the list

            //display menu
            userChoice = SafeInput.getRegExString(in,menu,"[AaDdPpQq]"); //user choice must match one of the characters specified
            userChoice = userChoice.toUpperCase(); //converts any lowercase choices received to upper case

            switch(userChoice) //switch that will execute options based on users choice
            {
                case "A":
                    addListItem(); // calling of method that will add an item to the list
                    break; //force break of switch

                case "D":
                    deleteItem();
                    break; //force break of switch

                case "P":
                    showList(); //method to show the list if input is P
                    break; //force break of switch

                case "Q":
                    done = quit(); //method that will cause the program to quit if input received is q
                    break; //force break of switch
            }

        }while(!done); //loop will break once the while condition is met

    }
    private static void showList()
    {
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
        if(list.size() != 0 ) //if the list size is greater than zero then the for loop below will run
        {
            for (int i = 0; i < list.size(); i++)
            {
                System.out.printf("%3d%35s", i + 1, list.get(i));
                System.out.println("");
            }

        }
        else
        {
            System.out.println("+++            No items in the list           +++");
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
        }

    }
    private static void addListItem()
    {
        String itemToAdd = SafeInput.getNonZeroLenString(in, "Add an item to your list"); //user input prompt asking to add an item to the list
        list.add(itemToAdd); //adds the input received to the list
    }

    private static boolean quit()
    {

        boolean done = SafeInput.getYNConfirm(in, "Are you sure you want to quit the program?"); //user input prompt asking if the user is wanting to quit the program
        return done; //return of a boolean variable
    }

    private static void deleteItem()
    {
        int itemToRemove = SafeInput.getRangedInt(in, "What list item are you wanting to remove?",1, list.size()); //user input prompt asking the user to input an int of what item they are wanting to remove
        itemToRemove = itemToRemove - 1; //equation to see the input received to the correct arrray indices
        list.remove(itemToRemove); //removes the item specified from the current list
    }

}