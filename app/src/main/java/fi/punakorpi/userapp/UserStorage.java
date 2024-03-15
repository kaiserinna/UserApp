package fi.punakorpi.userapp;

import java.util.ArrayList;

public class UserStorage {
    private ArrayList<User> users = new ArrayList<>();
    private static UserStorage userStorage= null;

    public static UserStorage getInstance() {
        if (userStorage == null) {
            userStorage = new UserStorage();
        }
        return userStorage;
    }

    public void addUserToStorage(User user) {
        users.add(user);
    }
    public ArrayList<User> getUsers() {
        return users;
    }

    public User getUser(int n) {
        return users.get(n);
    }

    public int getSize() {
        return users.size();
    }
}
