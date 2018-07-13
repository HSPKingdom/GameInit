package item;

import java.util.ArrayList;
import java.util.Scanner;

public class ArmorItem extends GameItem {

    private int defence;

    public int getHitPoint(){return defence;}

    public void setDetail(){
        Scanner reader = new Scanner(System.in);

        System.out.println("Defence Point: ");
        defence = reader.nextInt();
    }

    @Override
    public void setDetail(ArrayList<String> detail) {
        defence = Integer.parseInt(detail.get(0));
    }


}
