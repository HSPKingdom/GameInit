package item;

import java.util.Map;

public abstract class Item {


    protected int itemID;
    protected String title;
    protected String desciption;


    // Not in use yet
    private int sshVerification;

    public Item(){
        this.itemID = -1;
        this.title = "";
        this.desciption = "";
    }

    public Item(int itemID, String title, String desciption){
        this.itemID = itemID;
        this.title = title;
        this.desciption = desciption;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }


}
