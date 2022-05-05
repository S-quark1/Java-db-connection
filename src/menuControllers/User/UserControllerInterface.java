package menuControllers.User;

import menuControllers.Controller;

public interface UserControllerInterface extends Controller {
    void create(String name, String surname, String gender);
}
