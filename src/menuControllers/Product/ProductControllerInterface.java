package menuControllers.Product;

import menuControllers.Controller;

public interface ProductControllerInterface extends Controller {
    void create(String name, String category, int price);
    void getProductByCategory(String category);
    void getProductByPriceRange(int min, int max);
}
