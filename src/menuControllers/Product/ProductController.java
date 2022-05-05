package menuControllers.Product;

import entities.Product;
import repos.Product.ProductReposInterface;

import java.util.List;

public class ProductController implements ProductControllerInterface {
    private final ProductReposInterface repos;

    public ProductController(ProductReposInterface repos) {
        this.repos = repos;
    }
    public void delete(int id) {
        boolean success = repos.delete(id);
        System.out.println(success ? "Product removed successfully!" : "Product deletion failed!");
    }

    public void create(String name, String category, int price) {
        Product newProduct = new Product(name, category, price);

        if (repos.InDB(newProduct)){
            boolean success = repos.create(newProduct);
            System.out.println(success ? "Product created successfully!" : "Product creation failed!");
        }
        else{
            System.out.println("Product is already in database!");
        }
    }

    public void getById(int id) {
        Product product = repos.getById(id);
        System.out.println("\n" + (product == null ? "There is no user with id = " + id : product.toString()));
    }

    public void getAll() {
        List<Product> products = repos.getAll();
        products.forEach(product -> System.out.println(product.toString()));
    }

    public void getProductByCategory(String category){
        List<Product> products = repos.getProductByCategory(category);
        products.forEach(product -> System.out.println(product.toString()));
    }
    public void getProductByPriceRange(int min, int max){
        List<Product> products = repos.getProductByPriceRange(min, max);
        products.forEach(product -> System.out.println(product.toString()));
    }
}
