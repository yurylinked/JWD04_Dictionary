package DictionaryService;

import Dao.DictionaryDAO;
import Exception.*;

import java.io.*;
import java.util.*;

public class DictionaryService extends DictionaryDAO implements DictionaryInterface {
    boolean isRunning = true;
    public void putNewWord() throws IOException {
        Scanner words = new Scanner(System.in);
        while (true) {
            System.out.println("Enter russian word:");
            String rus = words.nextLine();
            System.out.println("Enter english translate:");
            String eng = words.nextLine();
            dictMap.put(rus, eng);
            System.out.println(rus + " = " + eng + " was added to the dictionary");
            System.out.println("Enter more? yes/no:");
            String choice = words.nextLine();
            if (!choice.equals("yes")) {
                break;
            }
        }
    }

    @Override
    public void saveWord() {
        dictMap.put("Кот", "Cat");
        dictMap.put("Лев", "Lion");
        dictMap.put("Машина", "Car");
        dictMap.put("Любовь", "Love");
        dictMap.put("Бежать", "Run");
        dictMap.put("Собака", "Dog");
        dictMap.put("Я", "I");
        dictMap.put("Делать", "Do");
        dictMap.put("Польша", "Poland");
        dictMap.put("Беларусь", "Belarus");
    }


    @Override
    public void findTranslateRusToEng() throws DictionaryWordNotFoundException {
        Scanner words = new Scanner(System.in);
        while (isRunning) {
            System.out.println("Enter russian word:");
            rus = words.nextLine();
            String translated = "";
            if (dictMap.containsKey(rus)) {
                translated += dictMap.get(rus);
            } else {
                translated += "Not found. Enter another word in russian";
            }
            System.out.println(rus + " = " + translated);
            System.out.println("Do you want to continue and enter more words? yes/no:");
            String choice = words.nextLine();
            if (!choice.equals("yes")) {
                break;
            }
        }
    }


    HashMap<String, String> dictMap = new HashMap<>();

    public static String getKeyByValue(Map<String, String> dictMap, String value) {
        for (Map.Entry<String, String> entry : dictMap.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

    @Override
    public void findTranslateEngToRus() {
        Scanner words = new Scanner(System.in);
        while (true) {
            System.out.println("Enter english word:");
            eng = words.nextLine();
            String translated = "";

            translated += getKeyByValue(dictMap, eng);

            if (!dictMap.containsValue(eng)) {
                System.out.println("Not found "+ eng +"." +" Enter another word");
            } else
            System.out.println(eng + " in russian is " + translated);
            System.out.println("Do you want to continue and enter more words? yes/no:");
            String choice = words.nextLine();
            if (!choice.equals("yes")) {
                break;
            }
        }
    }
    @Override
    public void wordCount() {
        System.out.println(dictMap.size());
    }

    @Override
    public void outputAllWords() {
        for (Map.Entry entry : dictMap.entrySet()) {
            System.out.println("Russian words: " + entry.getKey() + " English words: "
                    + entry.getValue());
        }
    }
}
