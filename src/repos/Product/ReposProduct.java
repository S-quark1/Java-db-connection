package repos.Product;

import dbs.EstablishCon;
import entities.Product;
import repos.Repos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReposProduct implements ProductReposInterface {
    private final EstablishCon db;

    public ReposProduct(EstablishCon db) {
        this.db = db;
    }

    @Override
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        Connection con = null;
        try{
            con = db.getCon();
            String sql = "SELECT * FROM product ORDER BY id";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet res = st.executeQuery();

            while(res.next()){
                Product product = new Product(res.getInt("id"), res.getString("name"), res.getString("category"), res.getInt("price"));
                products.add(product);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try{
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return products;
    }

    @Override
    public Product getById(int id) {
        Product productById = null;
        Connection con = null;
        try{
            con = db.getCon();
            String sql = "SELECT * FROM product WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1,id);

            ResultSet res = st.executeQuery();

            if(res.next()){
                productById = new Product(res.getInt("id"), res.getString("name"), res.getString("category"), res.getInt("price"));
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try{
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return productById;
    }

    @Override
    public Boolean create(Product product) {
        boolean success = false;
        Connection con = null;
        try{
            con = db.getCon();
            String sql = "INSERT INTO product(name,category,price) VALUES (?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, product.getName());
            st.setString(2, product.getCategory());
            st.setInt(3, product.getPrice());

            st.execute();
            success = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try{
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return success;
    }

    @Override
    public Boolean delete(int id) {
        Connection con = null;
        try{
            con = db.getCon();
            String sql = "DELETE FROM product WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1,id);

            st.execute();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        } finally {
            try{
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Boolean InDB(Product product) {
        Boolean productIn = true;
        Connection con = null;
        try{
            con = db.getCon();
            String sql = "SELECT * FROM product WHERE NAME =? AND CATEGORY=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, product.getName());
            st.setString(2, product.getCategory());

            ResultSet res = st.executeQuery();

            if(res.next()){
                productIn = false;
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try{
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return productIn;
    }

    @Override
    public List<Product> getProductByCategory(String category) {
        List<Product> products = new ArrayList<>();
        Connection con = null;
        try{
            con = db.getCon();
            String sql = "SELECT * FROM product WHERE category=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1,category);

            ResultSet res = st.executeQuery();

            while(res.next()){
                Product product = new Product(res.getInt("id"), res.getString("name"), res.getString("category"), res.getInt("price"));
                products.add(product);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try{
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return products;
    }

    @Override
    public List<Product> getProductByPriceRange(int min, int max) {
        List<Product> products = new ArrayList<>();
        Connection con = null;
        try{
            con = db.getCon();
            String sql = "SELECT * FROM product WHERE price BETWEEN ? AND ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1,min);
            st.setInt(2,max);

            ResultSet res = st.executeQuery();

            while(res.next()){
                Product product = new Product(res.getInt("id"), res.getString("name"), res.getString("category"), res.getInt("price"));
                products.add(product);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try{
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return products;
    }
}
