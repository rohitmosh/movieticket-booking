public class BookingThread implements Runnable {
    private Booking booking;

    public BookingThread(Booking booking) {
        this.booking = booking;
    }

    @Override
    public void run() {
        try {
            // Simulate processing time
            Thread.sleep(2000);
            System.out.println("Booking confirmed: " + booking.getDetails());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
