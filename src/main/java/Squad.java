public class Squad {
    private String mName;
    private int mNumber;
    private String mMission;


    public Squad (String name, Integer maxsize, String mission) {
       mName = name;
       mNumber = maxsize;
       mMission = mission;
    }
    public String getName () {
        return mName;
    }

    public int getNumber () {
        return mNumber;
    }

    public String getMission () {
        return mMission;
    }






}

