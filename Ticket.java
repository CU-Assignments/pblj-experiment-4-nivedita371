class TicketBookingSystem {
    private int availableSeats = 10;

    public synchronized boolean bookTicket(String user) {
        if (availableSeats > 0) {
            System.out.println(user + " booked a ticket. Seats left: " + (--availableSeats));
            return true;
        } else {
            System.out.println(user + " failed to book. No seats left.");
            return false;
        }
    }
}

class BookingThread extends Thread {
    private TicketBookingSystem system;
    private String user;

    public BookingThread(TicketBookingSystem system, String user, int priority) {
        this.system = system;
        this.user = user;
        setPriority(priority);  // Set thread priority
    }

    @Override
    public void run() {
        system.bookTicket(user);
    }
}

public class TicketBookingDemo {
    public static void main(String[] args) {
        TicketBookingSystem system = new TicketBookingSystem();

        Thread vip1 = new BookingThread(system, "VIP User 1", Thread.MAX_PRIORITY);
        Thread vip2 = new BookingThread(system, "VIP User 2", Thread.MAX_PRIORITY);
        Thread normal1 = new BookingThread(system, "Normal User 1", Thread.NORM_PRIORITY);
        Thread normal2 = new BookingThread(system, "Normal User 2", Thread.NORM_PRIORITY);
        Thread normal3 = new BookingThread(system, "Normal User 3", Thread.NORM_PRIORITY);

        vip1.start();
        vip2.start();
        normal1.start();
        normal2.start();
        normal3.start();
    }
}
