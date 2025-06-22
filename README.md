# 🎬 Movie Ticket Booking System (OOP-based Java Project)

## 📌 Project Overview

This is a **Movie Ticket Booking System** developed using **Object-Oriented Programming principles in Java**. The system streamlines the movie booking process by providing features such as movie selection, seat booking, multithreaded ticket confirmation, and basic user management. The project showcases real-world application of OOP concepts along with multithreading, exception handling, and JDBC connectivity (extendable).

---

## 🚀 Features

- 🔐 **User Authentication** – Register and log in as a user.
- 🎞️ **Browse Movies** – View list of available movies and showtimes.
- 🪑 **Seat Selection** – Choose from available seats.
- 🎟️ **Ticket Booking** – Confirm your booking with multithreaded processing.
- ⚠️ **Custom Exception Handling** – For managing booking errors.
- 🔄 **Concurrent Booking Handling** – Thread-safe implementation using multithreading.
- 🗃️ **Modular Design** – Clean class structure using OOP.
- 🛢️ **Database Integration Ready** – JDBC structure included for future database integration (currently uses in-memory logic).

---

## 🧠 Technologies Used

- **Java SE** (Core Java)
- **OOP Principles** (Encapsulation, Abstraction, Inheritance, Polymorphism)
- **Multithreading** – For handling multiple bookings concurrently.
- **Custom Exceptions** – Robust error handling via `CustomException.java`.
- **Java Collections Framework**
- **JDBC** – (planned for database connectivity)
- **CLI-Based UI** (extendable to JavaFX GUI)

---

## 📂 Project Structure

```
MovieTicketBookingSystem/
│
├── Main.java               # Entry point: handles user interaction and flow control
├── User.java               # Handles user login/registration details
├── Movie.java              # Movie model with title, showtimes, etc.
├── Booking.java            # Booking logic including seat assignment
├── BookingThread.java      # Implements multithreaded booking simulation
├── CustomException.java    # Custom exception class for validation and errors
└── JavaSynopsis.pdf        # Project synopsis with flow diagram and tech overview
```

---

## 📋 Prerequisites

Before running this application, ensure you have:

- Java Development Kit (JDK) 8 or higher
- JavaFX SDK (if not included with your JDK)
- An IDE such as IntelliJ IDEA, Eclipse, or VS Code
- Git (for cloning the repository)

---

## ⚙️ How to Run

1. **Compile the Project**

   ```bash
   javac *.java
   ```

2. **Run the Program**

   ```bash
   java Main
   ```

---

## 📈 System Flow

1. User Registration / Login
2. Browse Movies and Showtimes
3. Select a Movie and Time
4. Choose Available Seats
5. Confirm Booking
6. Get Confirmation (simulated via console)

---

## 📤 Future Enhancements

- Integration with a real **MySQL/PostgreSQL database** via JDBC
- GUI using **JavaFX**
- **Email/SMS Confirmation** integration
- **Admin Panel** for movie and showtime management
- Real-time seat availability updates across users

---

## 👨‍💻 Contributors

- Rohit Mohanty
