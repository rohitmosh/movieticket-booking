public class Booking {
    private User user;
    private Movie movie;
    private String showtime;
    private String seat;

    public Booking(User user, Movie movie, String showtime, String seat) {
        this.user = user;
        this.movie = movie;
        this.showtime = showtime;
        this.seat = seat;
    }

    public String getDetails() {
        return "User: " + user.getUsername() + ", Movie: " + movie.getName() + ", Showtime: " + showtime + ", Seat: "
                + seat;
    }
}
