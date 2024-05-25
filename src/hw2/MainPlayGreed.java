package hw2;

import java.util.Scanner;

public class MainPlayGreed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter five numbers from 1 to 6: ");
        String strNumbers = scanner.nextLine();
        while (!strNumbers.matches("^(?:[1-6] ){4}[1-6]$")) {
            System.out.print("Try entering the numbers again: ");
            strNumbers = scanner.nextLine();
        }
        String[] strArrayNumbers = strNumbers.split(" ");
        int[] numbers = new int[strArrayNumbers.length];
        for (int i = 0; i < strArrayNumbers.length; i++) {
            numbers[i] = Integer.parseInt(strArrayNumbers[i]);
        }
        sortArray(numbers);
        System.out.println(getPoints(numbers));
    }

    public static void sortArray(int[] array) {
        int temp;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static int getPoints(int[] array) {
        int points = 0;
        int number = 0;
        int count;
        for (int i = 0; i < array.length; i++) {
            while (number != array[i]) {
                number = array[i];
                count = 0;
                for (int j = 0; j < array.length; j++) {
                    if (array[i] == array[j]) {
                        count++;
                    }
                }
                switch (number) {
                    case 1:
                        if (count >= 3) {
                            points += ((count - 3) * 100) + 1000;
                        } else {
                            points += count * 100;
                        }
                        break;
                    case 2:
                        if (count >= 3) {
                            points += 200;
                        }
                        break;
                    case 3:
                        if (count >= 3) {
                            points += 300;
                        }
                        break;
                    case 4:
                        if (count >= 3) {
                            points += 400;
                        }
                        break;
                    case 5:
                        if (count >= 3) {
                            points += ((count - 3) * 50) + 500;
                        } else {
                            points += count * 50;
                        }
                        break;
                    case 6:
                        if (count >= 3) {
                            points += 600;
                        }
                        break;

                }
            }
        }
        return points;
    }
}
