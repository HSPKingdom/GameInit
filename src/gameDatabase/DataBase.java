package gameDatabase;

import item.Item;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class DataBase{
    protected Map<Integer, Item> data;
    private int verificationCode = 7577;

    public abstract void addData(Item item);
    public abstract boolean resetDataBase(int verificationCode);

    public boolean deleteData(int key) {
        if (data.containsKey(key)){
            data.remove(key);
            return true;
        }
        else{
            System.out.println("Not Exist");
            return false;
        }
    }

    public Item getItem(int key) {
        return data.get(key);
    }

    public DataBase(){ data = new HashMap<Integer, Item>(); }

    protected boolean checkVerification(int verificationCode){
        return (this.verificationCode == verificationCode);
    }

    protected void deleteDataBase(){
        data.clear();
    }

}
