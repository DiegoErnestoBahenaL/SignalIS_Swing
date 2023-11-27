package Data.Models;

public class Affiliate {

    private long Id;
    private String Name;
    private String FathersLastName;
    private String MothersLastName;
    private int Age;
    private AffiliateTypeEnum Type;
    private long UserId;

    public  Affiliate(){}

    public Affiliate(long id, String name, String fathersLastName, String mothersLastName, int age, AffiliateTypeEnum type, long userId) {
        Id = id;
        Name = name;
        FathersLastName = fathersLastName;
        MothersLastName = mothersLastName;
        Age = age;
        Type = type;
        UserId = userId;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getFathersLastName() {
        return FathersLastName;
    }

    public void setFathersLastName(String fathersLastName) {
        FathersLastName = fathersLastName;
    }

    public String getMothersLastName() {
        return MothersLastName;
    }

    public void setMothersLastName(String mothersLastName) {
        MothersLastName = mothersLastName;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public AffiliateTypeEnum getType() {
        return Type;
    }

    public void setType(AffiliateTypeEnum type) {
        Type = type;
    }

    public long getUserId() {
        return UserId;
    }

    public void setUserId(long userId) {
        UserId = userId;
    }
}
