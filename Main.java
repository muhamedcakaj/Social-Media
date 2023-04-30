

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        UserInterface userInterface = new UserInterface(scan);

        userInterface.start();

    }

}