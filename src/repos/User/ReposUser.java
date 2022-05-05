package repos.User;

import dbs.EstablishCon;
import entities.User;
import repos.Repos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReposUser implements UserReposInterface {
    private final EstablishCon db;

    public ReposUser(EstablishCon db) {
        this.db = db;
    }

    public List<User> getAll(){
        List<User> users = new ArrayList<>();
        Connection con = null;
        try{
            con = db.getCon();
            String sql = "SELECT * FROM users ORDER BY id";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet res = st.executeQuery();

            while(res.next()){
                User user = new User(res.getInt("id"), res.getString("name"), res.getString("surname"), res.getBoolean("gender"));
                users.add(user);
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
        return users;
    }

    @Override
    public User getById(int id) {
        User userById = null;
        Connection con = null;
        try{
            con = db.getCon();
            String sql = "SELECT * FROM users WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1,id);

            ResultSet res = st.executeQuery();

            if(res.next()){
                userById = new User(res.getInt("id"), res.getString("name"), res.getString("surname"), res.getBoolean("gender"));
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
        return userById;
    }

    @Override
    public Boolean create(User newUser) {
        boolean success = false;
        Connection con = null;
        try{
            con = db.getCon();
            String sql = "INSERT INTO users(name,surname,gender) VALUES (?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, newUser.getName());
            st.setString(2, newUser.getSurname());
            st.setBoolean(3, newUser.isGender());

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
            String sql = "DELETE FROM users WHERE id=?";
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
    public Boolean InDB(User user) {
        Boolean userIn = true;
        Connection con = null;
        try{
            con = db.getCon();
            String sql = "SELECT * FROM users WHERE NAME =? AND SURNAME=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, user.getName());
            st.setString(2, user.getSurname());

            ResultSet res = st.executeQuery();

            if(res.next()){
                userIn = false;
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
        return userIn;
    }
}
