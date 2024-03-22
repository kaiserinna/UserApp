package fi.punakorpi.userapp;

import android.content.Context;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Comparator;

public class UserStorage {
    private static UserStorage userStorage = null;
    private static String fileName = "users.data";
    private ArrayList<User> users = new ArrayList<>();


    public static UserStorage getInstance() {
        if (userStorage == null) {
            userStorage = new UserStorage();
        }
        return userStorage;
    }

    public void addUserToStorage(User user) {
        users.add(user);
        sortUsers();

    }
    public void sortUsers() {
        users.sort(Comparator.comparing(User::getLastName));
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

    public void saveUsersToFile(Context context) {
        try {
            ObjectOutputStream userWriter = new ObjectOutputStream(context.openFileOutput(fileName, Context.MODE_PRIVATE));
            userWriter.writeObject(users);
            userWriter.close();
        } catch (IOException e) {
            System.out.println("Käyttäjien tallentaminen ei onnistunut");
        }
    }

    public void loadUsersFromFile(Context context) {
        try {
            ObjectInputStream userWriter = new ObjectInputStream(context.openFileInput(fileName));
            users = (ArrayList<User>) userWriter.readObject();
            userWriter.close();
        } catch (FileNotFoundException e) {
            users = new ArrayList<>();
        } catch (IOException e) {
            System.out.println("Käyttäjien lukeminen ei onnistunut");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Ohjelmointivirhe, luokkaa ei löydy");
            e.printStackTrace();
        }
    }
}