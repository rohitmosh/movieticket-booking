import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Movie {
    private String name;
    private String posterPath;

    public Movie(String name, String posterPath) {
        this.name = name;
        this.posterPath = posterPath;
    }

    public String getName() {
        return name;
    }

    public ImageView getPosterImage() {
        // Load the image from the resources folder inside src
        Image image = new Image(getClass().getResourceAsStream("/resources/images/" + posterPath));
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(150); // Adjust the size of the image
        imageView.setFitWidth(100);
        return imageView;
    }
}
