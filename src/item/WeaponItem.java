package item;

import java.util.ArrayList;
import java.util.Scanner;

public class WeaponItem extends GameItem{
    private int attackPower;

    public void setAttackPower(int attackPower){this.attackPower = attackPower;}
    public int getAttackPower(){return attackPower;}

    public int getHitPoint(){return attackPower;}

    public void setDetail(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Weapon Attack Power");
        attackPower = reader.nextInt();
    }

    @Override
    public void setDetail(ArrayList<String> detail) {
        attackPower = Integer.parseInt(detail.get(0));
    }
}
