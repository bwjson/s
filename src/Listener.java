import java.sql.*;

public class Listener {
    private static int nextId = 1;
    private int id;
    private int numberOfLikedSongs;
    private String name;
    private String surname;

    public Listener(String name, String surname) throws SQLException, ClassNotFoundException {
        this.id = nextId++;
        this.name = name;
        this.surname = surname;
        insertIntoDatabase();
    }

    public int getId() {
        return id;
    }

    public int getNumberOfLikedSongs() {
        return numberOfLikedSongs;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void insertIntoDatabase() throws ClassNotFoundException, SQLException {
        Connection connection;
        DataBaseConnection con = new DataBaseConnection();

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(con.getURL(), con.getUSER(), con.getPASSWORD());
            String query = "INSERT INTO listeners(id, numberOfLikedSongs, name, surname) values(?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            String countQuery = "SELECT COUNT(*) AS total FROM likedsongs WHERE listener_id = ?";
            PreparedStatement countStatement = connection.prepareStatement(countQuery);
            countStatement.setInt(1, id);
            ResultSet resultSet = countStatement.executeQuery();
            if(resultSet.next()) {
                numberOfLikedSongs = resultSet.getInt("total");
            }
            preparedStatement.setInt(2, numberOfLikedSongs);
            preparedStatement.setString(3, name);
            preparedStatement.setString(4, surname);
            preparedStatement.executeUpdate();
            System.out.println("The listener added");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
