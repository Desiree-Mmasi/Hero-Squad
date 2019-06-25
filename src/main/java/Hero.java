public class Hero {
    private String mName;
    private int mAge;
    private String mPower;
    private String mWeakness;

    public Hero (String name, int age, String power, String weakness) {
        mName = name;
        mAge = age;
        mPower = power;
        mWeakness = weakness;
    }



    public String getWeakness(){
        return mWeakness;
    }

    public String getPower() {
        return mPower;
    }

    public int getAge() {
        return mAge;
    }


    public String getName() {
        return mName;

    }
}
