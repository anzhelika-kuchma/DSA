package Arrays;

public class MovieTheater {
    private final char[][] seats;

    public MovieTheater(int rows, int cols) {
        seats = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                seats[i][j] = '0';
            }
        }
    }

    // reserve a seat
    public void reserveSeat(int row, int col) {
        if (row >= seats.length || col >= seats[0].length || row < 0 || col < 0) {
            System.out.println("Invalid seat number.");
            return;
        }
        if (seats[row][col] == 'X') {
            System.out.println("The seat is already taken. Please choose another seat.");
        } else {
            seats[row][col] = 'X';
            System.out.println("Seat reserved successfully.");
        }
    }

    // display the seating chart
    public void displaySeatingChart() {
        for (char[] row : seats) {
            for (char seat : row) {
                System.out.print(seat + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        MovieTheater theatre = new MovieTheater(8, 8);
        theatre.displaySeatingChart();

        // reserve seats
        theatre.reserveSeat(3, 3);
        theatre.displaySeatingChart();

        // reserve the same seat
        theatre.reserveSeat(3, 3);
    }
}
