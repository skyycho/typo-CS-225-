import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author SkyCho
 */

/**
 * Reads a file where the user's hands were one key to far to the right.
 * Outputs to standard output what the user intended to type.
 *
 */
public class Typo {
    // The map from mistyped characters to the intended characters.
    // TODO: You need to initialize and use this map.
    private static Map<Character, Character> corrections = new HashMap<>();
    private static void initMap()
    {
        corrections.put('\\', ']'); //how to do backlash
        corrections.put('|', '}');
        corrections.put(']', '[');
        corrections.put('}', '{');
        corrections.put('[', 'p');
        corrections.put('{', 'P');
        corrections.put('p', 'o');
        corrections.put('P', 'O');
        corrections.put('o', 'i');
        corrections.put('O', 'I');
        corrections.put('i', 'u');
        corrections.put('I', 'U');
        corrections.put('u', 'y');
        corrections.put('U', 'Y');
        corrections.put('y', 't');
        corrections.put('Y', 'T');
        corrections.put('t', 'r');
        corrections.put('T', 'R');
        corrections.put('r', 'e');
        corrections.put('R', 'E');
        corrections.put('e', 'w');
        corrections.put('E', 'W');
        corrections.put('w', 'q');
        corrections.put('W', 'Q');
        corrections.put('\'', ';');
        corrections.put('"', ':');
        corrections.put(';', 'l');
        corrections.put(':', 'L');
        corrections.put('l', 'k');
        corrections.put('L', 'K');
        corrections.put('k', 'j');
        corrections.put('K', 'J');
        corrections.put('j', 'h');
        corrections.put('J', 'H');
        corrections.put('h', 'g');
        corrections.put('H', 'G');
        corrections.put('g', 'f');
        corrections.put('G', 'F');
        corrections.put('f', 'd');
        corrections.put('F', 'D');
        corrections.put('d', 's');
        corrections.put('D', 'S');
        corrections.put('s', 'a');
        corrections.put('S', 'A');
        corrections.put('/', '.');
        corrections.put('?', '>');
        corrections.put('.', ',');
        corrections.put('>', '<');
        corrections.put(',', 'm');
        corrections.put('<', 'M');
        corrections.put('m', 'n');
        corrections.put('M', 'N');
        corrections.put('n', 'b');
        corrections.put('N', 'B');
        corrections.put('b', 'v');
        corrections.put('B', 'V');
        corrections.put('v', 'c');
        corrections.put('V', 'C');
        corrections.put('c', 'x');
        corrections.put('C', 'X');
        corrections.put('x', 'z');
        corrections.put('X', 'Z');
        corrections.put(' ', ' ');
        corrections.put('=', '-');
        corrections.put('+', '_');
        corrections.put('-', '0');
        corrections.put('_', ')');
        corrections.put('0', '9');
        corrections.put(')', '(');
        corrections.put('9', '8');
        corrections.put('(', '*');
        corrections.put('8', '7');
        corrections.put('*', '&');
        corrections.put('7', '6');
        corrections.put('&', '^');
        corrections.put('6', '5');
        corrections.put('^', '%');
        corrections.put('5', '4');
        corrections.put('%', '$');
        corrections.put('4', '3');
        corrections.put('$', '#');
        corrections.put('3', '2');
        corrections.put('#', '@');
        corrections.put('2', '1');
        corrections.put('@', '!');
        corrections.put('1', '`');
        corrections.put('!', '~');
    }

    /**
     * Correct one line by shifting the characters one to the left on the keyboard.
     * 
     * @param line the line that was mistyped
     * @return the corrected line
     */
    private static String correct(String line) {
        // TODO: You need to implement this method.

        String newLine = "";
        for (int i = 0; i < line.length(); i++) {
                if (corrections.containsKey(line.charAt(i))) {
                    newLine += corrections.get(line.charAt(i));
            }
        }
        return newLine;
    }

    public static void main(String[] args) {
        // Get the file name. Exit if none was provided.

        if (args.length == 0) {
            System.out.println("Please enter a file name when you run the program");
            return;
        }
        initMap();

        // Read and correct the file.
        try (Scanner in = new Scanner(new File(args[0]))) {
            while (in.hasNext()) {
                String corrected = correct(in.nextLine());
                System.out.println(corrected);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File " + args[0] + " could not be found.");
        }
    }
}