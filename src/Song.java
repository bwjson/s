import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Song {
    private static int nextId = 1;
    private int id;
    private String artist;
    private String duration;
    private String name;
    private String album;

    public Song(String artist, String duration, String name, String album) throws SQLException, ClassNotFoundException {
        this.id = nextId++;
        this.artist = artist;
        this.duration = duration;
        this.name = name;
        this.album = album;
        insertIntoDatabase();
    }

    public String getName() {
        return name;
    }

    public String getAlbum() {
        return album;
    }

    public String getArtist() {
        return artist;
    }

    public String getDuration() {
        return duration;
    }

    public int getId() {
        return id;
    }

    public void insertIntoDatabase() throws ClassNotFoundException, SQLException {
        Connection connection;
        DataBaseConnection con = new DataBaseConnection();
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(con.getURL(), con.getUSER(), con.getPASSWORD());
            String SqlAddBook = "INSERT INTO songs(id, artist, duration, name, album) values (?,?,?,?,?)";
            PreparedStatement statement1 = connection.prepareStatement(SqlAddBook);
            statement1.setInt(1, id);
            statement1.setString(2, artist);
            statement1.setString(3, duration);
            statement1.setString(4, name);
            statement1.setString(5, album);
            statement1.executeUpdate();
            System.out.println("The song added");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
