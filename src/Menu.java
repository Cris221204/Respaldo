import java.util.*;
import java.util.HashMap;
public class Menu {
  public HashMap<Integer,Controller>menuItems;
  Menu(){
    menuItems=new HashMap<>();
  }
  void display() {
    System.out.println("MENU: ");
    for (Integer key : menuItems.keySet()) {
      MenuItem menuItem = (MenuItem) menuItems.get(key);
      System.out.println(key + " - " + menuItem.getText());
    }
    Scanner scanner = new Scanner(System.in);
    int option = scanner.nextInt();
    scanner.nextLine();

    MenuItem menuItem = (MenuItem) menuItems.get(option);
    menuItem.getController().execute();

  }

  void addMenuItem(int key, MenuItem menuItem) {
    menuItems.put(key, (Controller) menuItem);

  }

}
