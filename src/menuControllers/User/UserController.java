package menuControllers.User;

import entities.User;
import repos.User.UserReposInterface;

import java.util.List;

public class UserController implements UserControllerInterface {
    private final UserReposInterface repos;

    public UserController(UserReposInterface repos){
        this.repos = repos;
    }
    public void delete(int id) {
        boolean success = repos.delete(id);
        System.out.println(success ? "User removed successfully!" : "User deletion failed!");
    }

    public void create(String name, String surname, String gender) {
        User newUser = new User(name, surname, (gender.equalsIgnoreCase("male")));

        if (repos.InDB(newUser)){
            boolean success = repos.create(newUser);
            System.out.println(success ? "User created successfully!" : "User creation failed!");
        }
        else{
            System.out.println("User is already in database!");
        }
    }

    public void getById(int id) {
        User user = repos.getById(id);
        System.out.println("\n" + (user == null ? "There is no user with id = " + id : user.toString()));
    }

    public void getAll() {
        List<User> users = repos.getAll();
        users.forEach(user -> System.out.println(user.toString()));
    }
}
