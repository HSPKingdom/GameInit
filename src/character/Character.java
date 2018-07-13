package character;

public abstract class Character {
    private String title;
    private int experience;


    public Character(String title, int experience){
        this.title = title;
        this.experience = experience;
    }

    public String getTitle(){
        return title;
    }

    public int getExperience(){
        return experience;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setExperience(int experience){
        this.experience = experience;
    }



}
