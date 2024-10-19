public class PenumpangPesawat {

    class Passenger {

        String name;
        Passenger next;

        public Passenger(String name) {
            this.name = name;
            this.next = null;
        }
    }

    class Flight {

        private Passenger head;

        public Flight() {
            this.head = null;
        }

        public void addPassenger(String name) {
            Passenger newPassenger = new Passenger(name);

            if (head == null) {
                head = newPassenger;
            } else {
                Passenger current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newPassenger;
            }

            System.out.println("Penumpang \"" + name + "\" berhasil ditambahkan.");
        }

        public void removePassenger(String name) {
            if (head == null) {
                System.out.println("Daftar penumpang kosong, tidak ada yang bisa dihapus.");
                return;
            }

            if (head.name.equals(name)) {
                head = head.next;
                System.out.println("Penumpang \"" + name + "\" berhasil dihapus.");
                return;
            }

            Passenger current = head;
            while (current.next != null) {
                if (current.next.name.equals(name)) {
                    current.next = current.next.next;
                    System.out.println("Penumpang \"" + name + "\" berhasil dihapus.");
                    return;
                }
                current = current.next;
            }

            System.out.println("Penumpang \"" + name + "\" tidak ditemukan.");
        }

        public void displayPassengers() {
            if (head == null) {
                System.out.println("Daftar penumpang kosong.");
                return;
            }

            System.out.println("Daftar penumpang:");
            Passenger current = head;
            while (current != null) {
                System.out.println("- " + current.name);
                current = current.next;
            }
        }
    }

    public static void main(String[] args) {
        PenumpangPesawat pp = new PenumpangPesawat();
        Flight flight = pp.new Flight();

        flight.addPassenger("Fadhilah");
        flight.addPassenger("Nur");
        flight.addPassenger("Hidayah");

        flight.displayPassengers();

        flight.removePassenger("Nur");

        flight.displayPassengers();
    }
}
