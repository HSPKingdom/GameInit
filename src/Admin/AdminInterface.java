package Admin;

import gameDatabase.DataInitialize;
import gameDatabase.GameDataBase;
import item.GameItem;
import item.Item;

import java.io.*;
import java.util.Map;

public class AdminInterface {

    private GameDataBase dataBase;
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public AdminInterface() throws Exception{
        dataBase = new GameDataBase();
        fetchDataBase();
    }

    private boolean fetchDataBase() throws Exception{
        String path = "B:" + File.separator + "Document" + File.separator + "Monash" + File.separator + "GitHub" + File.separator + "GameInit" + File.separator + "resources" + File.separator + "Data.txt";

        DataInitialize initialize = new DataInitialize();
        dataBase = initialize.fetchData(dataBase);

        System.out.println(dataBase.toString());

        return true;
    }

// ========================== Public Functions ==========================
    public GameItem addDataQuery() throws Exception{
        System.out.println("Item ID: ");
        int id = Integer.parseInt(reader.readLine());

        System.out.println("Choose from the following type:");
        String types[] = GameItem.getItemType();
        for (int i=0; i<=types.length-1; i++){
            System.out.println(i + ". " +types[i]);
        }
        GameItem newItem = GameItem.returnType(Integer.parseInt(reader.readLine()));
        if(newItem == null){
            throw new Exception("Wrong type");
        }
        newItem.setItemID(id);

        System.out.println("Title of the item:");
        newItem.setTitle(reader.readLine());

        System.out.println("Description: ");
        newItem.setDesciption(reader.readLine());


        newItem.setDetail();

        System.out.println(newItem.toString());

        return newItem;
    }

    public void addDataBase() throws Exception{
        dataBase.addData(addDataQuery());
    }

    public void removeData() throws IOException{

        System.out.println("Please Select Item ID to be removed: ");
        if(dataBase.deleteData(Integer.parseInt(reader.readLine()))){
            System.out.println("Remove Success!");
        }
        else{
            System.out.println("Item did not exist");
        }
    }

    public boolean changeData() throws Exception{
        System.out.println("Please Select Item ID to be change: ");
        int changingID = Integer.parseInt(reader.readLine());
        if(dataBase.getItem(changingID)==null){
            System.out.println("Item Do not exist");
            return false;
        }

        System.out.println(dataBase.getItem(changingID).toString());
        GameItem newItem = addDataQuery();

        dataBase.deleteData(changingID);
        dataBase.addData(newItem);
        return true;
    }

    public boolean saveDataBase() throws Exception{
        String path = "B:" + File.separator + "Document" + File.separator + "Monash" + File.separator + "GitHub" + File.separator + "Game" + File.separator + "resources" + File.separator + "Data.txt";
        FileWriter br = new FileWriter(new File(path), false);
        br.write("***");

        Map<Integer, Item> database = dataBase.getDataBase();
        for(Map.Entry<Integer, Item> item: database.entrySet()){
            GameItem input = (GameItem)item.getValue();
            br.write(input.getType());
            br.write(input.getItemID());
            br.write(input.getTitle());
            br.write(input.getDesciption());


            br.write("***");
        }

        br.close();
        return true;

    }

    public boolean deleteDataBase() throws IOException{
        System.out.println("Enter DataBase Verification Key");
        if(dataBase.resetDataBase(Integer.parseInt(reader.readLine()))){
            System.out.println("Success!");
            return true;
        }
        else{
            System.out.println("Verification Key failed");
            return false;
        }
    }

    public void showDataBase(){
        Map<Integer, Item> data = dataBase.getDataBase();
        for(Map.Entry<Integer, Item> item: data.entrySet()){
            GameItem temp = (GameItem)item.getValue();
            System.out.println(temp.toString());
        }
    }
}
