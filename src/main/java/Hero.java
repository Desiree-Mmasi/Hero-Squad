

public class Hero {
    private String name;
    private Integer age;
    private String Power;
    private String Weakness;

    public Hero (String name, Integer age, String power, String weakness) {
        this.name = name;
        this.age = age;
        Power = power;
        Weakness = weakness;
    }



    public String getWeakness () {
        return Weakness;
    }

    public String getPower () {
        return Power;
    }

    public Integer getAge () {
        return age;
    }


    public String getName () {
        return name;
    }

    public Hero (String name) {
        this.name = name;
    }
}
