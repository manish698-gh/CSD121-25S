package lab6;

/**
 * Represents a song with title, artist, mood, and image.
 */
public class Song {
    private String title;
    private String artist;
    private String mood;
    private String imageUrl;


    /**
     * Creates a new Song.
     *
     * @param title    Song title
     * @param artist   Artist name
     * @param mood     Mood category
     * @param imageUrl Image URL
     */
    public Song(String title, String artist, String mood, String imageUrl) {
        this.title = title;
        this.artist = artist;
        this.mood = mood;
        this.imageUrl = imageUrl;
    }

    /**
     * @return Song title
     */
    public String title() {
        return title;
    }

    /**
     * @return Artist name
     */
    public String artist() {
        return artist;
    }

    /**
     * @return Mood
     */
    public String mood() {
        return mood;
    }

    /**
     * @return Image URL
     */
    public String imageUrl() {
        return imageUrl;
    }

}
