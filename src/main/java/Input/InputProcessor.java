package Input;

import DictionaryService.DictionaryService;
import Exception.DictionaryWordNotFoundException;

import java.io.IOException;
import java.util.Scanner;


public class InputProcessor extends DictionaryService implements Console {
    boolean isRunning = true;

    @Override
    public void main() {
        Scanner num = new Scanner(System.in);
        saveWord();
        try {
            while (isRunning) {
                menu();
                String choice = num.nextLine();
                computation(choice);
            }
        } catch (DictionaryWordNotFoundException e) {

        }
    }

    private void printConsole(final String message) {
        System.out.println(message);
    }

    @Override
    public void menu() {
        System.out.println(" ");
        System.out.println("Hello human, let's translate!");
        System.out.println("-----------");
        System.out.println("1. Put new words");
        System.out.println("2. Translate russian word");
        System.out.println("3. Translate english word");
        System.out.println("4. Word count in dictionary");
        System.out.println("5. Output all words");
        System.out.println("6. Quiz");
        System.out.println("7. Program exit");
        System.out.print("Please choose: ");
    }

    @Override
    public void computation(String choice) throws DictionaryWordNotFoundException {
        int choiceNum = Integer.parseInt(choice);
        switch (choiceNum) {
            case 1:
                try {
                    putNewWord();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                findTranslateRusToEng();
                break;
            case 3:
                findTranslateEngToRus();
                break;
            case 4:
                wordCount();
                break;
            case 5:
                outputAllWords();
                break;
            case 6:
                quiz();
                break;
            case 7:
                isRunning = false;
                printConsole("App closes.");
                break;
            default:
                printConsole("Invalid choice. Restarting app.\n");
        }
    }
}
