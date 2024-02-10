import java.sql.*;

public class CreateTables {

    public static void createLikedSongsTable() throws SQLException, ClassNotFoundException {
        try {
            Connection connection;
            DataBaseConnection connect = new DataBaseConnection();
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(connect.getURL(), connect.getUSER(), connect.getPASSWORD());
            String query = "CREATE TABLE likedsongs(id int, listener_id int, song_id int)";
            PreparedStatement state = connection.prepareStatement(query);
            state.executeUpdate();
            System.out.println("The liked songs table created succesfully");
        } catch (Exception e) {
            System.out.println("You have already created the liked songs table");
        }
    }

    public static void createSongsTable() throws ClassNotFoundException, SQLException {
        try {
            Connection connection;
            DataBaseConnection con = new DataBaseConnection();
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(con.getURL(), con.getUSER(), con.getPASSWORD());
            String SqlCreate = "CREATE TABLE songs(id int, artist varchar(50), duration varchar(50), name varchar(50), album varchar(50))";
            PreparedStatement state = connection.prepareStatement(SqlCreate);
            state.executeUpdate();
            System.out.println("The songs table created successfully");
        }catch(Exception e){
            System.out.println("You have already created the songs table");
        }
    }

    public static void createListenersTable() throws ClassNotFoundException, SQLException {
        try {
            Connection connection;
            DataBaseConnection con = new DataBaseConnection();
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(con.getURL(), con.getUSER(), con.getPASSWORD());
            String SqlCreate = "CREATE TABLE listeners(id int, name varchar(50), surname varchar(50), numberOfLikedSongs int)";
            PreparedStatement state = connection.prepareStatement(SqlCreate);
            state.executeUpdate();
            System.out.println("The listeners table created successfully");
        }catch(Exception e){
            System.out.println("You have already created the listeners table");
        }
    }
}
