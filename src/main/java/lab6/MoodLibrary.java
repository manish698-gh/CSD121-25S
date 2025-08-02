package lab6;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
/**
 * MoodLibrary stores a list of songs and allows filtering by mood.
 * It includes English, Nepali, and international songs.
 */

public class MoodLibrary {
    private List<Song> songs = new ArrayList<>();
    /**
     * Constructor initializes the song list with various moods and languages.
     */

    public MoodLibrary() {
        // English songs
        songs.add(new Song("Happy", "Pharrell Williams", "Happy", "https://gfx2.decks.de/decks/gfx/co_raw/front/end_8/c2v-r8.jpg"));
        songs.add(new Song("Lovely", "Billie Eilish", "Sad", "https://i.ytimg.com/vi/L-w8gk1GN0g/maxresdefault.jpg"));
        songs.add(new Song("Weightless", "Marconi Union", "Relaxed", "https://i.ytimg.com/vi/Qw-XnIk46mo/maxresdefault.jpg"));
        songs.add(new Song("Eye of the Tiger", "Survivor", "Energetic", "https://images.genius.com/8a4edda4c89467ff82ff17d7cdfda75a.1000x1000x1.jpg"));
        songs.add(new Song("Blinding Lights", "The Weeknd", "Happy", "https://pics.filmaffinity.com/the_weeknd_blinding_lights-816446159-large.jpg"));
        songs.add(new Song("Fix You", "Coldplay", "Sad", "https://static.cifras.com.br/arquivos/artistas/c/coldplay_big.jpg"));

        // Nepali Songs
        songs.add(new Song("Laija Re", "Hemant Rana", "Happy", "https://i.ytimg.com/vi/nUg2cpkM7mc/maxresdefault.jpg"));
        songs.add(new Song("Hamro Nepal Maa", "Neetesh Jung Kunwar", "Relaxed", "https://i.ytimg.com/vi/hVH8vnf6SgQ/maxresdefault.jpg"));
        songs.add(new Song("Phool Ko Aankha Ma", "Ani Choying Drolma", "Sad", "https://i.ytimg.com/vi/nbYj3l-_iKE/maxresdefault.jpg"));
        songs.add(new Song("Sa Karnali", "Tribal Rain", "Energetic", "https://images.genius.com/56b07dfa508a53ffc269f6c9b9fae3f5.1000x1000x1.jpg"));
        songs.add(new Song("Naganya Maya", "Sajjan Raj Vaidya", "Happy", "https://i.ytimg.com/vi/jI7Otd4QkEA/maxresdefault.jpg"));
        songs.add(new Song("Afnu Sansar", "Yugal Gurung", "Relaxed", "https://i.ytimg.com/vi/F2pAd0-XctI/maxresdefault.jpg"));
        songs.add(new Song("Hidhney Manche Ladcha", "The Shadows Nepal", "Sad", "https://images.genius.com/7f9f4cf40d299f03f176bcce58979b2a.1000x667x1.jpg"));
        songs.add(new Song("Jaalma", "Various Artists", "Energetic", "https://i.ytimg.com/vi/egzkuAY-97c/maxresdefault.jpg"));
        songs.add(new Song("Bistarai", "Rohit John Chhetri", "Relaxed", "https://i.ytimg.com/vi/HVZnd4A899k/maxresdefault.jpg"));
        songs.add(new Song("Kalo Seto", "Purna Rai", "Sad", "https://i.ytimg.com/vi/9bd2nvAKyMc/maxresdefault.jpg"));
        songs.add(new Song("Nihiti", "John Chamling Rai", "Relaxed", "https://i.ytimg.com/vi/RKhjbYCfVZE/maxresdefault.jpg"));

        // Hindi Songs
        songs.add(new Song("Kesariya", "Arijit Singh", "Happy", "https://is2-ssl.mzstatic.com/image/thumb/Music112/v4/c9/b8/d0/c9b8d049-07d4-2faf-48c5-72c1090ecca6/196589105493.jpg/1200x1200bf-60.jpg"));
        songs.add(new Song("Channa Mereya", "Arijit Singh", "Sad", "https://i.ytimg.com/vi/M4911cQYL_4/maxresdefault.jpg"));
        songs.add(new Song("Tum Mile", "KK", "Relaxed", "https://i.ytimg.com/vi/pqIwWc7H3IQ/maxresdefault.jpg"));
        songs.add(new Song("Zinda", "Siddharth Mahadevan", "Energetic", "https://www.lyricsbogie.com/wp-content/uploads/2020/04/zinda-lyrics-1-1122x631.jpg"));

    }

    public List<Song> getSongsByMood(String mood) {
        return songs.stream()
                .filter(s -> s.mood().equalsIgnoreCase(mood))
                .collect(Collectors.toList());
    }
}
