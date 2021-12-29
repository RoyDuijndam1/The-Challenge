package envique.challengeapp.model;

public class User {
    public String userName;
    public String city;
    public int score;
    public String phone;
    public String email;
    public String id;


    public User(String userName, String city, int score, String phone, String email, String id) {
        this.id = id;
        this.userName = userName;
        this.city = city;
        this.score = score;
        this.phone = phone;
        this.email = email;
    }
}
