public class FlightSeatAllocation {

    public static int maxNumberOfFamilies(int n, int[][] reservedSeats) throws Exception{

        for(int i=0; i<reservedSeats.length; i++) {
            if(reservedSeats[i][0] > n || reservedSeats[i][1] > 10){
                throw new Exception("Seat rows are less than reserved seat rows");
            }
        }

        //2, 3, 4, 5  === 1, 2, 3, 4
        //4, 5, 6, 7  === 3, 4, 5, 6
        //6, 7, 8, 9  === 5, 6, 7, 8
        int allSeats[][] = new int[n][10];
        for (int i = 0; i < reservedSeats.length; i++) {
            int row, col;
            row = reservedSeats[i][0];
            col = reservedSeats[i][1];
            row--;
            col--;
            allSeats[row][col] = 1;
        }

        int groups = 0;

        for (int i = 0; i < n; i++) {
            boolean leftAisle = false;
            boolean rightAisle = false;
            if (allSeats[i][1] == 0 && allSeats[i][2] == 0 && allSeats[i][3] == 0 && allSeats[i][4] == 0) {
                groups++;
                leftAisle = true;
            }
            if (allSeats[i][5] == 0 && allSeats[i][6] == 0 && allSeats[i][7] == 0 && allSeats[i][8] == 0) {
                groups++;
                rightAisle = true;
            }
            if (allSeats[i][3] == 0 && allSeats[i][4] == 0 && allSeats[i][5] == 0 && allSeats[i][6] == 0 && !leftAisle && !rightAisle) {
                groups++;
            }
        }
        return groups;
    }

    public static void main(String[] args)  {
//        int[][] ints = {{1, 2}, {1, 3}, {1, 8}, {2, 6}, {3, 1}, {3, 10}};
//        int[][] ints = {{2, 1}, {1, 8}, {2, 6}};
        int[][] ints = {{4,3},{1,4},{4,6},{1,7}};
        try {
            System.out.println(FlightSeatAllocation.maxNumberOfFamilies(4, ints));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
