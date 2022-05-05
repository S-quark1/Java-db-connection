import dbs.EstablishCon;
import dbs.PostgresProduct;
import dbs.PostgresUser;
import entities.User;
import frontend.SimpleMenu;
import menuControllers.Product.ProductController;
import menuControllers.Product.ProductControllerInterface;
import menuControllers.User.UserController;
import menuControllers.User.UserControllerInterface;
import repos.Product.ProductReposInterface;
import repos.Product.ReposProduct;
import repos.User.ReposUser;
import repos.User.UserReposInterface;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) {
//        try{
//            User user = new User("Bake", "Bakebayev", true);
//            Field field = User.class.getDeclaredField("surname");
//            field.setAccessible(true);//если не будет, то exception
//            System.out.println(field.get(user));
//
//        } catch (Exception e){
//            System.out.println("oh oh");
//        }
        EstablishCon db1 = new PostgresUser();
        EstablishCon db2 = new PostgresProduct();

        UserReposInterface repos1 = new ReposUser(db1);
        ProductReposInterface repos2 = new ReposProduct(db2);

        UserController userCtrl = new UserController(repos1);
        ProductController productCtrl = new ProductController(repos2);

        SimpleMenu sm = new SimpleMenu(userCtrl, productCtrl);

        sm.entrance();
    }
}
