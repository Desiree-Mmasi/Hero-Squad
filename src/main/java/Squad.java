public class Squad {
    private String mName;
    private Integer mMaxsize;
    private String mMission;


    public Squad (String name, Integer maxsize, String mission) {
       mName = name;
       mMaxsize = maxsize;
       mMission = mission;
    }
    public String get () {
        return mName;
    }

    public Integer getMaxsize () {
        return mMaxsize;
    }

    public String getMission () {
        return mMission;
    }






}

