import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReadTables {
    public static void showAllSongs() {
        Connection connection;
        DataBaseConnection con = new DataBaseConnection();
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(con.getURL(), con.getUSER(), con.getPASSWORD());
            assert connection != null;
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM songs ORDER BY id";
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
                System.out.println("ID: " + result.getInt( "id") + ";" + "  Artist: " + result.getString("artist") + ";" + " Name: " + result.getString("name") + ";" + " Album: " + result.getString("album") + ";" + " Duration: " + result.getString("duration"));
            }

        } catch (Exception e) {
            System.out.println("Empty");
        }
    }

    public static void showAllListeners(){
        Connection connection;
        DataBaseConnection con = new DataBaseConnection();
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(con.getURL(), con.getUSER(), con.getPASSWORD());
            assert connection != null;
            Statement statement = connection.createStatement();
            String SqlShow = "SELECT * FROM listeners";
            ResultSet result = statement.executeQuery(SqlShow);
            while(result.next()){
                System.out.println("ID: " + result.getInt( "id") + ";" + " numberOfLikedSongs: " + result.getInt("numberOfLikedSongs") + ";" + " Name: " + result.getString("name") + ";" + " Surname: " + result.getString("surname"));
            }

        } catch (Exception e) {
            System.out.println("Empty");
        }
    }

    public static void showAllLikedSongs(){
        Connection connection;
        DataBaseConnection con = new DataBaseConnection();
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(con.getURL(), con.getUSER(), con.getPASSWORD());
            assert connection != null;
            Statement statement = connection.createStatement();
            String SqlShow = "SELECT * FROM likedsongs";
            ResultSet result = statement.executeQuery(SqlShow);
            while(result.next()){
                System.out.println("ID: " + result.getInt( "id") + ";" + " Listener ID: " + result.getString("listener_id") + ";" + " Song ID: " + result.getString("song_id"));
            }

        } catch (Exception e) {
            System.out.println("Empty");
        }
    }
}
