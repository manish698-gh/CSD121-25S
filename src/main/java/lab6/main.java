package lab6;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.List;

/**
 * Main class for the Mood-Based Music Recommender application.
 * Allows users to select a mood and view recommended songs with visuals.
 *
 * Author: Manish Ghimire
 * Course: CSD121 - Lab 6
 * Date: July 2025
 */
public class main extends Application {

    private MoodLibrary library = new MoodLibrary();
    private ListView<HBox> songListView = new ListView<>();
    private Label songCountLabel = new Label();
    private VBox root; // Needed for dynamic background change

    @Override
    public void start(Stage primaryStage) {
        // App title
        Label title = new Label("🎶 Mood-Based Music Recommender 🎶");
        title.setFont(new Font("Arial", 24));

        // Mood selector with emojis
        ComboBox<String> moodSelector = new ComboBox<>();
        moodSelector.getItems().addAll("😊 Happy", "😢 Sad", "🧘 Relaxed", "⚡ Energetic");
        moodSelector.setPromptText("Select your mood");
        moodSelector.setMaxWidth(200);
        moodSelector.setTooltip(new Tooltip("Choose a mood to get matching songs"));

        // Show button with event handler
        Button showButton = new Button("Show Songs 🎧");
        showButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-weight: bold;");
        showButton.setOnAction(new ShowSongsHandler(moodSelector));

        songCountLabel.setFont(new Font(14));
        songCountLabel.setPadding(new Insets(5, 0, 5, 0));

        VBox controlBox = new VBox(10, moodSelector, showButton, songCountLabel);
        controlBox.setAlignment(Pos.CENTER);

        root = new VBox(20, title, controlBox, songListView);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.TOP_CENTER);
        root.setStyle("-fx-background-color: #f0f4f8;"); // Default

        Scene scene = new Scene(root, 500, 600);
        primaryStage.setTitle("Mood Music App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Displays songs for the selected mood.
     * Also updates the background based on mood.
     * @param mood mood string (e.g., "Happy")
     */
    private void displaySongs(String mood) {
        songListView.getItems().clear();
        List<Song> songs = library.getSongsByMood(mood);

        if (songs.isEmpty()) {
            songCountLabel.setText("No songs found for this mood 😞");
        } else {
            songCountLabel.setText("Found " + songs.size() + " song(s) for " + mood + " mood:");
        }

        updateBackground(mood); // visual polish

        for (Song song : songs) {
            ImageView imageView = new ImageView();
            try {
                imageView.setImage(new Image(song.imageUrl(), 50, 50, true, true));
            } catch (Exception e) {
                // imageView remains blank if image fails
            }

            VBox textBox = new VBox(
                    new Label("🎵 " + song.title()),
                    new Label("By " + song.artist())
            );
            textBox.setPadding(new Insets(5));

            HBox item = new HBox(10, imageView, textBox);
            item.setAlignment(Pos.CENTER_LEFT);
            item.setPadding(new Insets(5));
            item.setStyle("-fx-background-color: white; -fx-border-color: lightgray;");

            songListView.getItems().add(item);
        }
    }

    /**
     * Changes background color depending on mood.
     * @param mood mood string
     */
    private void updateBackground(String mood) {
        String color;
        switch (mood.toLowerCase()) {
            case "happy": color = "#FFF9C4"; break;
            case "sad": color = "#E1F5FE"; break;
            case "relaxed": color = "#E8F5E9"; break;
            case "energetic": color = "#FFEBEE"; break;
            default: color = "#f0f4f8"; break;
        }
        root.setStyle("-fx-background-color: " + color + ";");
    }

    /**
     * Handles button click using an explicit EventHandler.
     */
    private class ShowSongsHandler implements EventHandler<ActionEvent> {
        private final ComboBox<String> moodSelector;

        public ShowSongsHandler(ComboBox<String> moodSelector) {
            this.moodSelector = moodSelector;
        }

        @Override
        public void handle(ActionEvent event) {
            String selected = moodSelector.getValue();
            if (selected != null) {
                String mood = selected.replaceAll("[^a-zA-Z]", ""); // Remove emoji
                displaySongs(mood);
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Please select a mood.");
                alert.show();
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
