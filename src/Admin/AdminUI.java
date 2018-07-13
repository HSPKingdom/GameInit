package Admin;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AdminUI {



    public static void main(String[] arg) throws Exception{
        int instruction = -1;
        AdminInterface admin = new AdminInterface();
        while (instruction != 0) {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("==============================================================================");
            System.out.println("ADMIN MENU:  ");
            System.out.println("1. Add Item to DataBase");
            System.out.println("2. Remove Item from DataBase");
            System.out.println("3. Change Item Status");
            System.out.println("4. Delete DataBase");
            System.out.println("5. Save DataBase");
            System.out.println("6. Print DataBase");
            System.out.println("==============================================================================");
            instruction = Integer.parseInt(reader.readLine());
            switch (instruction) {
                case 1:
                    admin.addDataBase();
                    break;
                case 2:
                    admin.removeData();
                    break;
                case 3:
                    admin.changeData();
                    break;
                case 4:
                    admin.deleteDataBase();
                    break;

                case 6:
                    admin.showDataBase();
                    break;
                default:
                    break;

            }
        }

    }
}
