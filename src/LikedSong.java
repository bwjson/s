import java.sql.*;

public class LikedSong {
    public static int LnextId = 1;
    public int id;
    public int listener_id;
    public int song_id;

    public LikedSong(int listener_id, int song_id) throws SQLException, ClassNotFoundException {
        this.id = LnextId++;
        this.listener_id = listener_id;
        this.song_id = song_id;
        insertIntoDatabase();
    }

    private void insertIntoDatabase() {
        Connection connection;
        DataBaseConnection connect = new DataBaseConnection();
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(connect.getURL(), connect.getUSER(), connect.getPASSWORD());
            assert connection != null;

            Statement statement1 = connection.createStatement();
            Statement statement2 = connection.createStatement();
            String query1 = "SELECT * FROM listeners ORDER BY id";
            String query2 = "SELECT * FROM songs ORDER BY name";
            ResultSet result1 = statement1.executeQuery(query1);
            ResultSet result2 = statement2.executeQuery(query2);

            int countId = 0;
            int countSongs = 0;

            while(result1.next()){
                countId+=1;
            }
            while(result2.next()){
                countSongs+=1;
            }

            if(countId <= 0) {
                System.out.println("List of listeners is empty");
            } else if (countSongs <= 0) {
                    System.out.println("List of songs is empty");
            } else {
                    PreparedStatement listenerCheckStatement = connection.prepareStatement("SELECT * FROM listeners WHERE id = ?");
                    listenerCheckStatement.setInt(1, listener_id);
                    ResultSet listenerResult = listenerCheckStatement.executeQuery();
                    if (!listenerResult.next()) {
                        throw new SQLException("There is no listener with id " + listener_id);
                    }

                    PreparedStatement songCheckStatement = connection.prepareStatement("SELECT * FROM songs WHERE id = ?");
                    songCheckStatement.setInt(1, song_id);
                    ResultSet song = songCheckStatement.executeQuery();
                    if (!song.next()) {
                        throw new SQLException("There is no song with id " + song_id);
                    }

                    String liked_query = "INSERT INTO likedsongs(id, listener_id, song_id) values (?,?,?)";
                    PreparedStatement liked = connection.prepareStatement(liked_query);
                    liked.setInt(1, id);
                    liked.setInt(2, listener_id);
                    liked.setInt(3, song_id);
                    liked.executeUpdate();
                    System.out.print("The listener has successfully added the liked song \n");
                    String updateListenerQuery = "UPDATE listeners SET numberOfLikedSongs = numberOfLikedSongs + 1 WHERE id = ?";
                    PreparedStatement updateListenerStatement = connection.prepareStatement(updateListenerQuery);
                    updateListenerStatement.setInt(1, listener_id);
                    updateListenerStatement.executeUpdate();
                }
        } catch (Exception e) {
            System.out.println(e);
        }
    }


}
