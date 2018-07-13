package gameDatabase;

import item.GameItem;
import item.Item;

import java.util.Map;

public class GameDataBase extends DataBase {

    public GameDataBase(){
        super();
    }

    @Override
    public void addData(Item item) {
        System.out.println("HI"+(item.getTitle()));
        if (data.containsKey(item.getItemID())){
            System.out.println("Error! Duplicate Key");
        }
        else{
            data.put(item.getItemID(), item);
        }
    }

    @Override
    public boolean resetDataBase(int verificationCode) {
        if (checkVerification(verificationCode)){
            deleteDataBase();
            return true;
        }
        else{
            System.out.println("Verification Error");
            return false;
        }
    }

    @Override
    public String toString() {
        String output = "";
        Item display;
        for (Map.Entry<Integer, Item> item: data.entrySet()){
            display = item.getValue();
            if(display instanceof GameItem){
                display = (GameItem) display;
                output += display.toString() + "\n";
            }
        }
        return output;
    }

    public Map<Integer, Item> getDataBase(){
        return data;
    }
}
