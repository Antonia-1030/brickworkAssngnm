package mentormate.rickwork;

import java.util.Scanner;

public class Brickwork {
    //values of items
    public static final String Col_Divider = " | ";
    public static final String Row_Divider = " =====";
    public static final String Empty_Pos = "   ";
    public static final String Brick_1 = " 1|1 ";
    public static final String Brick_2 = " 2|2 ";
    public static final String Brick_3 = " 3|3 ";
    public static final String Brick_4 = " 4|4 ";


    public static final Scanner scanner = new Scanner(System.in);
    public static boolean isWallFinished = false;

    public static void main(String[] args) {
        //sample wall for example
        final String[][] sampleWall = {{Brick_1, Brick_2}, {Brick_3, Brick_4}};
        Sample(sampleWall);
        //condition
        System.out.print("Make new wall by not repeating previous brickwork.");

        //main wall
        String[][] emptyWall = {{Empty_Pos, Empty_Pos},
                {Empty_Pos, Empty_Pos}};
        //running the program
        do {
            System.out.print("Enter coordinates of brick.");
            int[] coords = readCoordinates(emptyWall);
            moveBrick(emptyWall,coords);

        } while (!isWallFinished);
        print(emptyWall);

        //check if two walls are the same
        if (sampleWall == emptyWall) {
            System.out.println("-1");
        }
        System.out.print("Congrats! You finished it!");
        scanner.close();
    }

    //Movement action
    public static void moveBrick(String[][] emptyWall, int[] coords) {
        String figure = emptyWall[coords[1]][coords[0]];
        String target = emptyWall[coords[3]][coords[2]];

        emptyWall[coords[3]][coords[2]] = figure;

        if (!target.equals(Empty_Pos)) {
            System.out.print("Position is full!");
        }
    }
    // bricks
    public static boolean isBrick(String figure) {
        String figureType = figure.substring(0);

        return figureType.equals(Brick_1);
    }
    public static boolean isBrick2(String figure) {
        String figureType = figure.substring(0);

        return figureType.equals(Brick_2);
    }
    public static boolean isBrick3(String figure) {
        String figureType = figure.substring(0);

        return figureType.equals(Brick_3);
    }
    public static boolean isBrick4(String figure) {
        String figureType = figure.substring(0);

        return figureType.equals(Brick_4);
    }
    //Coordinates reading
    public static int[] readCoordinates(String[][] emptyWall) {
        String stringCoordinates;
        int[] coordinates = new int[4];

        do {
            System.out.print("Въведете координати на хода: ");
            stringCoordinates = scanner.nextLine();
        } while (stringCoordinates.length() != 4);

        int[] fromCoordinates = transformCoordinates(stringCoordinates.substring(0, 2));
        int[] toCoordinates   = transformCoordinates(stringCoordinates.substring(2, 4));

        coordinates[0] = fromCoordinates[0];
        coordinates[1] = fromCoordinates[1];
        coordinates[2] = toCoordinates[0];
        coordinates[3] = toCoordinates[1];

        return coordinates;
    }

    public static int[] transformCoordinates(String stringCoordinates) {
        int[] coordinates = new int[2];

        coordinates[0] = stringCoordinates.charAt(0);
        coordinates[1] = stringCoordinates.charAt(1);

        return coordinates;
    }
    //Setting sample wall
    public static void Sample(String[][] sampleWall) {
        System.out.print(Row_Divider);
        for (int i = 0; i < sampleWall.length; i++) {
            for (int j = 0; j < sampleWall[i].length; j++) {
                Sample(sampleWall[i][j]);
                if (j < sampleWall[i].length - 1) {
                    Sample(Col_Divider);
                }
            }
            System.out.print(Row_Divider);
        }
        //empty wall set
        public static void print(String[][] emptyWall) {
            System.out.print(Row_Divider);
            for (int i = 0; i < emptyWall.length; i++) {
                for (int j = 0; j < emptyWall[i].length; j++) {
                    print(emptyWall[i][j]);
                    if (j < emptyWall[i].length - 1) {
                        print(Col_Divider);
                    }
                }
                System.out.print(Row_Divider);
            }
    }

}

