import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {

    private String artist;
    private String name;
    private List<Song> songs;

    public Album() {
    }

    public Album(String artist, String name) {
        this.artist = artist;
        this.name = name;
        this.songs = new ArrayList<>();
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    //functionalities in album
    public boolean findSong(String name){
        for(Song song: songs){
            if(song.getTitle().equals(name)){
                return true;
            }
        }
        return false;
    }

    //add song
    public String addSongToAlbum(String title, double duration){
        if(!findSong(title)){
            //add
            Song song = new Song(title, duration);
            this.songs.add(song);
            return "Song has been added to the Album";
        }
        return "Song already exists";
    }

    //add to playlist from album
    public String addToPlayListFromAlbum(String title, LinkedList<Song> playList){
        for(Song song: songs){
            if (song.getTitle().equals(title)){
                playList.add(song);
                return "Song has been added to your playlist";
            }
        }
        return "Song doesn't exist in album";
    }

    /**
     * Polymorphism: Overloading Method
     * @param songNo
     * @param playList
     * @return
     */

    public String addToPlayListFromAlbum(int songNo, LinkedList<Song> playList){
        int index = songNo - 1;
        if (index >= 0 && index<songs.size()){
            playList.add(songs.get(index));
            return "Song has been added successfully";
        }
        return "Incorrect song number!!";
    }

}
