package repos.Product;

import entities.Product;
import repos.Repos;

import java.util.List;

public interface ProductReposInterface extends Repos<Product> {
    List<Product> getProductByCategory(String category);
    List<Product> getProductByPriceRange(int min, int max);
}
