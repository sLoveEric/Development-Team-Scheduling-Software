package team.view;

import java.util.*;

public class TSUtility {
    private static Scanner scanner = new Scanner(System.in);

	public static char readMenuSelection() {
        char c;
        for (; ; ) {
            String str = readKeyBoard(1, false);
            c = str.charAt(0);
            if (c != '1' && c != '2' &&
                c != '3' && c != '4') {
                System.out.print("Error, please reselect: ");
            } else break;
        }
        return c;
    }

    public static void readReturn() {
        System.out.print("Press enter to countinue...");
        readKeyBoard(100, true);
    }

    public static int readInt() {
        int n;
        for (; ; ) {
            String str = readKeyBoard(2, false);
            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.print("Error, please re-enter: ");
            }
        }
        return n;
    }

    public static char readConfirmSelection() {
        char c;
        for (; ; ) {
            String str = readKeyBoard(1, false).toUpperCase();
            c = str.charAt(0);
            if (c == 'Y' || c == 'N') {
                break;
            } else {
                System.out.print("Error, please re-enter: ");
            }
        }
        return c;
    }

    private static String readKeyBoard(int limit, boolean blankReturn) {
        String line = "";

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.length() == 0) {
                if (blankReturn) return line;
                else continue;
            }

            if (line.length() < 1 || line.length() > limit) {
                System.out.print("Input length (not greater than" + limit + ") Error, please re-enter: ");
                continue;
            }
            break;
        }

        return line;
    }
}

