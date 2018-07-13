package gameDatabase;

import item.ArmorItem;
import item.DecorationItem;
import item.GameItem;
import item.WeaponItem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class DataInitialize {
    private String path = "B:" + File.separator + "Document" + File.separator + "Monash" + File.separator + "GitHub" + File.separator + "GameInit" + File.separator + "resources" + File.separator + "Data.txt";
    private BufferedReader br;

    public DataInitialize() {


    }

    public GameDataBase fetchData (GameDataBase dataBase) throws Exception{
        br = new BufferedReader(new FileReader(path));
        String line;
        int pointer = 0;
        ArrayList<String> otherDetail = new ArrayList<>();

        GameItem item = null;

        while ((line = br.readLine()) != null) {
            System.out.println(line);
            if(line.equals("***")){
                pointer = -1;

                if(item != null) {
                    item.setDetail(otherDetail);
                    dataBase.addData(item);
                    otherDetail.clear();
                }
                item = null;
            }
            switch(pointer){
                case -1:
                    break;
                case 0:
                    item = searchType(Integer.parseInt(line));
                    break;
                case 1:
                    item.setItemID(Integer.parseInt(line));
                    break;
                case 2:
                    item.setTitle(line);
                    break;
                case 3:
                    item.setDesciption(line);
                    break;
                default:
                    otherDetail.add(line);
                    break;


            }
            pointer ++;
        }
        return dataBase;

    }

    private GameItem searchType(int line){
        switch(line){
            case GameItem.WEAPON:
                return new WeaponItem();
            case GameItem.ARMOR:
                return new ArmorItem();
            case GameItem.DECORATION:
                return new DecorationItem();
            default:
                return null;

        }
    }

}
