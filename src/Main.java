import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
            Scanner sc = new Scanner(System.in);

            System.out.println("If database hasn't created - enter 0");
            System.out.println("If database exists - enter 1");

            int isThereDataBase = sc.nextInt();

            if (isThereDataBase == 0) {
                CreateTables.createSongsTable();
                CreateTables.createLikedSongsTable();
                CreateTables.createListenersTable();
            }

            int choice = 1;

            while (choice != 0) {
                System.out.println("1. Add song" + "  2. Add listener" + "  3. Make a liked song for a listener");
                System.out.println("4. Remove song" + "  5. Remove listener" + "  6. Remove liked song");
                System.out.println("7. Show all songs" + "  8. Show all listeners" + "  9. Show all liked songs");
                System.out.println("10. Update info about song" + "  11. Update info about listener" + "  12. Update info about liked song" + " 13. Delete table");
                System.out.println("0. Exit");
                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        String song_name, song_album, song_artist;
                        String duration;
                        System.out.println("Enter name of the song");
                        song_name = sc.nextLine();
                        System.out.println("Enter the album");
                        song_album = sc.nextLine();
                        System.out.println("Enter the artist");
                        song_artist = sc.nextLine();
                        System.out.println("Enter the duration");
                        duration = sc.nextLine();
                        Song song = new Song(song_artist, duration, song_name, song_album);
                        break;
                    case 2:
                        String listener_name, listener_surname;
                        System.out.println("Enter name of the listener");
                        listener_name = sc.nextLine();
                        System.out.println("Enter surname of the listener");
                        listener_surname = sc.nextLine();
                        Listener listener = new Listener(listener_name, listener_surname);
                        break;
                    case 3:
                        int listener_id, song_id;
                        System.out.println("Enter listener ID");
                        listener_id = sc.nextInt();
                        System.out.println("Enter song ID");
                        song_id = sc.nextInt();
                        sc.nextLine();
                        LikedSong likedSong = new LikedSong(listener_id, song_id);
                        break;
                    case 4:
                        int song_id_n;
                        System.out.println("Enter id");
                        song_id_n = sc.nextInt();
                        DeleteTables.DeleteSongsTable(song_id_n);
                        break;
                    case 5:
                        int listener_id_n;
                        System.out.println("Enter id");
                        listener_id_n = sc.nextInt();
                        DeleteTables.DeleteListenersTable(listener_id_n);
                        break;
                    case 6:
                        int liked_song_id;
                        System.out.println("Enter id");
                        liked_song_id = sc.nextInt();
                        DeleteTables.DeleteLikedSongsTable(liked_song_id);
                        break;
                    case 7:
                        System.out.println("All the songs:");
                        ReadTables.showAllSongs();
                        break;
                    case 8:
                        System.out.println("All the listeners:");
                        ReadTables.showAllListeners();
                        break;
                    case 9:
                        System.out.println("All the liked songs:");
                        ReadTables.showAllLikedSongs();
                        break;
                    case 10:
                        String song_name_upd, song_album_upd, song_artist_upd, duration_upd;
                        int id_upd;
                        System.out.println("Enter name of the song");
                        song_name_upd = sc.nextLine();
                        System.out.println("Enter the album");
                        song_album_upd = sc.nextLine();
                        System.out.println("Enter the artist");
                        song_artist_upd = sc.nextLine();
                        System.out.println("Enter the duration");
                        duration_upd = sc.nextLine();
                        System.out.println("Enter the ID of update song");
                        id_upd = sc.nextInt();
                        UpdateTables.updateSong( id_upd, song_artist_upd, duration_upd, song_name_upd, song_album_upd);
                        break;
                    case 11:
                        String listener_name_upd, listener_surname_upd;
                        int listener_id_upd;
                        System.out.println("Enter name");
                        listener_name_upd = sc.nextLine();
                        System.out.println("Enter surname");
                        listener_surname_upd = sc.nextLine();
                        System.out.println("Enter ID of the listener");
                        listener_id_upd = sc.nextInt();
                        UpdateTables.updateListener(listener_id_upd, listener_name_upd, listener_surname_upd);
                        break;
                    case 12:
                        int listener_id_upd_new, song_id_upd_new, id_liked;
                        System.out.println("Enter listener ID");
                        listener_id_upd_new = sc.nextInt();
                        System.out.println("Enter song ID");
                        song_id_upd_new = sc.nextInt();
                        System.out.println("Enter ID of the LikedSong");
                        id_liked = sc.nextInt();
                        UpdateTables.updateLikedSong(id_liked, listener_id_upd_new, song_id_upd_new);
                        break;
                    case 13:
                        String table_name;
                        System.out.println("Enter table name");
                        table_name = sc.nextLine();
                        DeleteTables.DeleteTable(table_name);
                }
            }
        }
    }
