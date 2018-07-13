package item;

import buff.Buff;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class GameItem extends Item {

    private static String typeMenu[] = {"Weapon", "Armor", "Decoration"};
    public static final int WEAPON = 0;
    public static final int ARMOR = 1;
    public static final int DECORATION = 2;

    public static final int NOTSAVED = 0;
    public static final int SAVED = 1;
    public static final int REMOVE = 2;

    private int storageStatus;
    private int itemType;
    private HashMap<String , Buff> buff;


    public GameItem(int itemID, String title, String desciption, int itemType){
        super(itemID, title, desciption);
        this.storageStatus = NOTSAVED;
        this.itemType = itemType;
        buff = new HashMap<>();
    }

    public GameItem(){
        super();
        this.storageStatus = NOTSAVED;
        buff = new HashMap<>();
    }

    public static GameItem returnType(int type){
        switch(type){
            case 0:
                return new WeaponItem();
            case 1:
                return new ArmorItem();
            case 2:
                return new DecorationItem();
            default:
                return null;
        }
    }

    public int getType(){
        return itemType;
    }

    // Get all the string by the order of the static int
    public static String [] getItemType(){
        return typeMenu;
    }

    public abstract int getHitPoint();

    public void setStorageStatus(int STATUS){
        storageStatus = STATUS;
    }

    public void setItemType(int TYPE){this.itemType = TYPE;}

    public abstract void setDetail(ArrayList<String> detail);

    public abstract void setDetail();

    public boolean addBuff(Buff incoming){
        return true;
    }

    @Override
    public String toString() {
        return itemID + "\n" + title + "\n" + desciption + "\n";
    }
}
