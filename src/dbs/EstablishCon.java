package dbs;

import java.sql.Connection;
import java.sql.SQLException;

public interface EstablishCon {
    Connection getCon() throws SQLException, ClassNotFoundException;
}
