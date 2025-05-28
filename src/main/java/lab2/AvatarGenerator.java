package lab2; // User-defined package for grouping related classes

import javax.imageio.ImageIO; // (javax.imageio) Image read/write classes
import javax.swing.*;         // (javax.swing) GUI components
import java.awt.*;            // (java.awt) GUI and graphics classes
import java.io.IOException;   // (java.io) IO exception class
import java.io.InputStream;   // (java.io) Input stream class
import java.net.URI;          // (java.net) URI representation
import java.net.http.HttpClient;    // (java.net.http) HTTP client
import java.net.http.HttpRequest;   // (java.net.http) HTTP request
import java.net.http.HttpResponse;  // (java.net.http) HTTP response

public class AvatarGenerator { // Class for generating and displaying avatars

    public static void main(String[] args) {
        try {
            // getRandomAvatarStream: static class method, returns InputStream (reference)
            var avatarStream = AvatarGenerator.getRandomAvatarStream();
            // showAvatar: static class method, takes InputStream (reference)
            AvatarGenerator.showAvatar(avatarStream);
        } catch (IOException | InterruptedException e) {
            // printStackTrace: instance method, prints error
            e.printStackTrace();
        }
    }

    public static InputStream getRandomAvatarStream() throws IOException, InterruptedException {
        // styles: String[] (reference), avatar styles
        String[] styles = { "adventurer", "adventurer-neutral", "avatars", "big-ears",
                "big-ears-neutral", "big-smile", "bots", "cradles", "crocodiles-neutral",
                "fun-emoji", "icons", "identicon", "initials", "lorelei", "micah", "minivans",
                "open-peeps", "personas", "pixel-art", "pixel-art-neutral" };
        // Math.random: static class method, returns double; styles.length: array instance variable (int, primitive)
        var style = styles[(int)(Math.random() * styles.length)]; // style: String (reference)
        var seed = (int)(Math.random() * 10000); // seed: int (primitive)
        // URI.create: static method, returns URI (reference); String.formatted: instance method, formats string
        var uri = URI.create("https://api.dicebear.com/9.x/%s/png?seed=%d".formatted(style, seed));
        // HttpRequest.newBuilder: static method, returns builder; .build: instance method, returns HttpRequest
        var request = HttpRequest.newBuilder(uri).build();
        // HttpClient.newHttpClient: static method, returns HttpClient (reference, constructor)
        try (var client = HttpClient.newHttpClient()) {
            // client.send: instance method, sends request, returns HttpResponse<InputStream>
            // HttpResponse.BodyHandlers.ofInputStream: static method, returns handler
            var response = client.send(request, HttpResponse.BodyHandlers.ofInputStream());
            // response.body: instance method, returns InputStream (reference)
            return response.body();
        }
    }

    public static void showAvatar(InputStream imageStream) { // imageStream: InputStream (reference)
        // JFrame: (javax.swing), window class, constructor
        JFrame frame = new JFrame("PNG Viewer");
        // setDefaultCloseOperation, setResizable, setSize: instance methods
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(200, 200);
        // getContentPane: instance method, returns Container; setBackground: instance method; Color.BLACK: static variable
        frame.getContentPane().setBackground(Color.BLACK);
        try {
            // ImageIO.read: static method, reads image, returns Image (reference)
            Image image = ImageIO.read(imageStream);
            // ImageIcon: (javax.swing), wraps image, constructor; JLabel: (javax.swing), label, constructor
            JLabel imageLabel = new JLabel(new ImageIcon(image));
            // frame.add: instance method, adds component; BorderLayout.CENTER: static variable
            frame.add(imageLabel, BorderLayout.CENTER);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // setVisible: instance method, shows window
        frame.setVisible(true);
    }
}
