import java.sql.*;

public class DeleteTables {
    public static void DeleteLikedSongsTable(int id) throws SQLException, ClassNotFoundException {
        try {
            Connection connection;
            DataBaseConnection connect = new DataBaseConnection();
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(connect.getURL(), connect.getUSER(), connect.getPASSWORD());

            Statement statement = connection.createStatement();
            String Sqlid = "select * from likedsongs order by id";
            ResultSet result = statement.executeQuery(Sqlid);
            int countId = 0;
            while (result.next()) {
                countId += 1;
            }
            if (countId <= 0) {
                System.out.println("List of likedsongs is empty");
            } else {
                String SqlRemove = "delete from likedsongs where id = ?";
                PreparedStatement statement1 = connection.prepareStatement(SqlRemove);
                statement1.setInt(1, id);
                statement1.executeUpdate();
                System.out.println("Liked song successfully removed from table");

            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public static void DeleteSongsTable(int id) throws ClassNotFoundException, SQLException {
        try {
            Connection connection;
            DataBaseConnection connect = new DataBaseConnection();
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(connect.getURL(), connect.getUSER(), connect.getPASSWORD());

            Statement statement = connection.createStatement();
            String Sqlid = "select * from songs order by id";
            ResultSet result = statement.executeQuery(Sqlid);
            int countId = 0;
            while (result.next()) {
                countId += 1;
            }
            if (countId <= 0) {
                System.out.println("List of songs is empty");
            } else {
                String SqlRemove = "delete from songs where id = ?";
                PreparedStatement statement1 = connection.prepareStatement(SqlRemove);
                statement1.setInt(1, id);
                statement1.executeUpdate();
                System.out.println("Song successfully removed from table");

            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void DeleteListenersTable(int id) throws ClassNotFoundException, SQLException {
        try {
            Connection connection;
            DataBaseConnection connect = new DataBaseConnection();
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(connect.getURL(), connect.getUSER(), connect.getPASSWORD());

            Statement statement = connection.createStatement();
            String Sqlid = "select * from listeners order by id";
            ResultSet result = statement.executeQuery(Sqlid);
            int countId = 0;
            while (result.next()) {
                countId += 1;
            }
            if (countId <= 0) {
                System.out.println("List of listeners is empty");
            } else {
                String SqlRemove = "delete from listeners where id = ?";
                PreparedStatement statement1 = connection.prepareStatement(SqlRemove);
                statement1.setInt(1, id);
                statement1.executeUpdate();
                System.out.println("The listener successfully removed from table");

            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void DeleteTable(String name) throws ClassNotFoundException, SQLException {
        try {
            Connection connection;
            DataBaseConnection connect = new DataBaseConnection();
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(connect.getURL(), connect.getUSER(), connect.getPASSWORD());

            String query = "DROP TABLE " + name;
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);

            System.out.println("The table deleted successfully");

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
