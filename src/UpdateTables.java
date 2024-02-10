import java.sql.*;

public class UpdateTables {

    public static void updateSong(int id, String artist, String duration, String name, String album) throws ClassNotFoundException, SQLException {
        try {
            Connection connection;
            DataBaseConnection connect = new DataBaseConnection();
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(connect.getURL(), connect.getUSER(), connect.getPASSWORD());

            String sql_query = "UPDATE songs SET artist = ?, duration = ?, name = ?, album = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql_query);
            statement.setString(1, artist);
            statement.setString(2, duration);
            statement.setString(3, name);
            statement.setString(4, album);
            statement.setInt(5, id);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("The song successfully updated");
            } else {
                System.out.println("Nothing updated");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void updateListener(int id, String name, String surname) throws ClassNotFoundException, SQLException {
        try {
            Connection connection;
            DataBaseConnection connect = new DataBaseConnection();
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(connect.getURL(), connect.getUSER(), connect.getPASSWORD());

            String sql_query = "UPDATE listeners SET name = ?, surname = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql_query);
            statement.setString(1, name);
            statement.setString(2, surname);
            statement.setInt(3, id);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("The listener updated successfully");
            } else {
                System.out.println("Nothing updated");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void updateLikedSong(int id, int listener_id, int song_id) throws ClassNotFoundException, SQLException {
        try {
            Connection connection;
            DataBaseConnection connect = new DataBaseConnection();
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(connect.getURL(), connect.getUSER(), connect.getPASSWORD());

            String sql_query = "UPDATE likedsongs SET listener_id = ?, song_id = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql_query);
            statement.setInt(1, listener_id);
            statement.setInt(2, song_id);
            statement.setInt(3, id);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("The listener updated successfully");
            } else {
                System.out.println("Nothing updated");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
