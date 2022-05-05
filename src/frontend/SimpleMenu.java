package frontend;

import menuControllers.Product.ProductController;
import menuControllers.User.UserController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SimpleMenu {
    private final UserController userCtrl;
    private final ProductController productCtrl;
    Scanner scanner = new Scanner(System.in);

    public SimpleMenu(UserController userCtrl, ProductController productCtrl) {
        this.userCtrl = userCtrl;
        this.productCtrl = productCtrl;
    }

    public void entrance() {
        System.out.println("*********************");
        System.out.println("Please select: ");
        System.out.println("1. User");
        System.out.println("2. Product");
        System.out.println("0. Exit");
        int ans = scanner.nextInt();
        if (ans == 1) {
            startUser();
        }
        else if (ans == 2) {
            startProduct();
        }
        else end();
    }
    public void startUser() {
        while (true) {
            System.out.println();
            System.out.println("Welcome to DataBase");
            System.out.println("Select option:");
            System.out.println("1. Get all users");
            System.out.println("2. Get user by id");
            System.out.println("3. Create user");
            System.out.println("4. Remove user");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter option (1-4): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    getAllUsers();
                } else if (option == 2) {
                    getUserById();
                } else if (option == 3) {
                    createUser();
                } else if (option == 4){
                    deleteUser();
                } else {
                    end();
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be integer");
                scanner.nextLine(); // to ignore incorrect input
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("\n*************************");
        }
    }
    public void end() {
        System.out.println("Session terminated");
        System.out.println("*************************");
    }

    private void deleteUser() {
        System.out.println("Please enter id: ");
        int id = scanner.nextInt();
        userCtrl.delete(id);
    }

    private void createUser() {
        System.out.println("Please enter name");
        String name = scanner.next();
        System.out.println("Please enter surname");
        String surname = scanner.next();
        System.out.println("Please enter gender (male/female)");
        String gender = scanner.next();

        userCtrl.create(name, surname, gender);
    }

    private void getUserById() {
        System.out.println("Please enter id: ");
        int id = scanner.nextInt();
        userCtrl.getById(id);
    }

    private void getAllUsers() {
        userCtrl.getAll();
    }

//    **************************
    public void startProduct() {
        while (true) {
            System.out.println();
            System.out.println("Welcome to DataBase");
            System.out.println("Select option:");
            System.out.println("1. Get all products");
            System.out.println("2. Get product by id");
            System.out.println("3. Create product");
            System.out.println("4. Remove product");
            System.out.println("5. Get products by category");
            System.out.println("6. Get products by price range");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter option (1-6): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    getAllProducts();
                } else if (option == 2) {
                    getProductById();
                } else if (option == 3) {
                    createProduct();
                } else if (option == 4){
                    deleteProduct();
                } else if (option == 5){
                    getProductByCategory();
                }else if (option == 6){
                    getProductByPriceRange();
                } else {
                    end();
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be integer");
                scanner.nextLine(); // to ignore incorrect input
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("\n*************************");
        }
    }
    private void deleteProduct() {
        System.out.println("Please enter id: ");
        int id = scanner.nextInt();
        productCtrl.delete(id);
    }

    private void createProduct() {
        System.out.println("Please enter name");
        String name = scanner.next();
        System.out.println("Please enter category");
        String category = scanner.next();
        System.out.println("Please enter price");
        int price = scanner.nextInt();

        productCtrl.create(name, category, price);
    }

    private void getProductById() {
        System.out.println("Please enter id: ");
        int id = scanner.nextInt();
        productCtrl.getById(id);
    }

    private void getAllProducts() {
        productCtrl.getAll();
    }
    private void getProductByCategory(){
        System.out.println("Please enter category: ");
        String cat = scanner.next();
        productCtrl.getProductByCategory(cat);
    }
    private void getProductByPriceRange(){
        System.out.println("Please min price : ");
        int min = scanner.nextInt();
        System.out.println("Please max price : ");
        int max = scanner.nextInt();
        productCtrl.getProductByPriceRange(min, max);
    }
}
