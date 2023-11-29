package Data.Models;

public class User {
    private long Id;
    private String UserName;
    private String Password;

    public User (){}

    public User(long id, String userName, String password) {
        Id = id;
        UserName = userName;
        Password = password;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
