package envique.challengeapp;

import envique.challengeapp.model.User;


public class State {
    public static User user;
    public static void saveUser(User userSave) {
        user = userSave;
    }
}
