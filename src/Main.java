import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class Main extends Application {
    private User loggedInUser;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Movie Ticket Booking System");

        // Create login form
        Label userLabel = new Label("Username:");
        TextField userText = new TextField();
        Label passLabel = new Label("Password:");
        PasswordField passText = new PasswordField();
        Button loginButton = new Button("Login");

        VBox vbox = new VBox(10, userLabel, userText, passLabel, passText, loginButton);
        vbox.setPadding(new Insets(20));
        vbox.setAlignment(Pos.CENTER);
        vbox.getStyleClass().add("container"); // Apply container style

        Scene loginScene = new Scene(vbox, 400, 300);
        // Load and apply the CSS
        loginScene.getStylesheets().add(getClass().getResource("/resources/styles/styles.css").toExternalForm());

        primaryStage.setScene(loginScene);
        primaryStage.show();

        // Handle login
        loginButton.setOnAction(e -> {
            String username = userText.getText();
            String password = passText.getText();

            try {
                loggedInUser = User.login(username, password);
                showMovieSelection(primaryStage);
            } catch (CustomException ex) {
                showErrorDialog(ex.getMessage());
            }
        });
    }

    // Show movie selection screen
    private void showMovieSelection(Stage stage) {
        Label heading = new Label("Browse Movies");
        heading.getStyleClass().add("label-heading"); // Apply heading style

        // Update movie names and poster paths
        Movie[] movies = { new Movie("Inception", "inception.jpg"), new Movie("Oppenheimer", "oppenheimer.jpg"),
                new Movie("Interstellar", "interstellar.jpg") };

        HBox movieBox = new HBox(20); // To display movies horizontally
        movieBox.setAlignment(Pos.CENTER);
        movieBox.getStyleClass().add("movie-container"); // Apply movie container style

        for (Movie movie : movies) {
            VBox movieContainer = new VBox(10); // VBox for each movie (poster + name)
            movieContainer.setAlignment(Pos.CENTER);

            ImageView poster = movie.getPosterImage();
            Label movieName = new Label(movie.getName());
            movieName.getStyleClass().add("label"); // Apply label style

            Button movieButton = new Button(movie.getName());
            movieButton.getStyleClass().add("button"); // Apply button style
            movieButton.setOnAction(e -> showShowtimeSelection(stage, movie));

            movieContainer.getChildren().addAll(poster, movieName, movieButton);
            movieBox.getChildren().add(movieContainer);
        }

        VBox vbox = new VBox(20, heading, movieBox);
        vbox.setPadding(new Insets(20));
        vbox.setAlignment(Pos.CENTER);
        vbox.getStyleClass().add("container"); // Apply container style

        Scene movieScene = new Scene(vbox, 600, 400);
        movieScene.getStylesheets().add(getClass().getResource("/resources/styles/styles.css").toExternalForm());
        stage.setScene(movieScene);
        stage.show();
    }

    // Show showtime selection screen
    private void showShowtimeSelection(Stage stage, Movie movie) {
        Label showtimeLabel = new Label("Select Showtime for " + movie.getName());

        Button time1 = new Button("10:00 AM");
        Button time2 = new Button("2:00 PM");
        Button time3 = new Button("6:00 PM");

        VBox vbox = new VBox(10, showtimeLabel, time1, time2, time3);
        vbox.setPadding(new Insets(20));
        vbox.setAlignment(Pos.CENTER);

        time1.setOnAction(e -> showSeatSelection(stage, movie, "10:00 AM"));
        time2.setOnAction(e -> showSeatSelection(stage, movie, "2:00 PM"));
        time3.setOnAction(e -> showSeatSelection(stage, movie, "6:00 PM"));

        Scene showtimeScene = new Scene(vbox, 400, 300);
        showtimeScene.getStylesheets().add(getClass().getResource("/resources/styles/styles.css").toExternalForm());
        stage.setScene(showtimeScene);
        stage.show();
    }

    // Show seat selection screen
    private void showSeatSelection(Stage stage, Movie movie, String showtime) {
        Label seatLabel = new Label("Select Seats for " + movie.getName() + " at " + showtime);
        ListView<String> seatList = new ListView<>();
        seatList.getItems().addAll("A1", "A2", "A3", "A4", "A5");

        Button confirmButton = new Button("Confirm Booking");

        VBox vbox = new VBox(10, seatLabel, seatList, confirmButton);
        vbox.setPadding(new Insets(20));
        vbox.setAlignment(Pos.CENTER);

        confirmButton.setOnAction(e -> {
            String selectedSeat = seatList.getSelectionModel().getSelectedItem();
            if (selectedSeat != null) {
                processBooking(movie, showtime, selectedSeat);
                showBookingConfirmation(stage, movie, showtime, selectedSeat);
            } else {
                showErrorDialog("Please select a seat.");
            }
        });

        Scene seatScene = new Scene(vbox, 400, 300);
        seatScene.getStylesheets().add(getClass().getResource("/resources/styles/styles.css").toExternalForm());
        stage.setScene(seatScene);
        stage.show();
    }

    // Process booking with multithreading
    private void processBooking(Movie movie, String showtime, String seat) {
        Booking booking = new Booking(loggedInUser, movie, showtime, seat);
        Thread bookingThread = new Thread(new BookingThread(booking));
        bookingThread.start();
    }

    // Show booking confirmation screen
    private void showBookingConfirmation(Stage stage, Movie movie, String showtime, String seat) {
        Label confirmLabel = new Label("Booking Confirmed!");
        Label userInfo = new Label("User: " + loggedInUser.getUsername());
        Label movieInfo = new Label("Movie: " + movie.getName());
        Label timeInfo = new Label("Showtime: " + showtime);
        Label seatInfo = new Label("Seat: " + seat);

        VBox vbox = new VBox(10, confirmLabel, userInfo, movieInfo, timeInfo, seatInfo);
        vbox.setPadding(new Insets(20));
        vbox.setAlignment(Pos.CENTER);

        Scene confirmScene = new Scene(vbox, 400, 300);
        confirmScene.getStylesheets().add(getClass().getResource("/resources/styles/styles.css").toExternalForm());
        stage.setScene(confirmScene);
        stage.show();
    }

    // Show error dialog
    private void showErrorDialog(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
