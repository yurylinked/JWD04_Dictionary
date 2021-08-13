package DictionaryService;

import Dao.DictionaryDAO;
import Exception.*;

import java.io.*;
import java.util.*;

public class DictionaryService extends DictionaryDAO implements DictionaryInterface {
    boolean isRunning = true;

    public void putNewWord() throws IOException {
        Scanner words = new Scanner(System.in);
        while (isRunning) {
            System.out.println("Enter russian word:");
            String rus = words.nextLine();
            // rus.toUpperCase();
            System.out.println("Enter english translate:");
            String eng = words.nextLine();

            dictMap.put(rus.toLowerCase(), eng.toUpperCase());
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
        dictMap.put("кот", "сat");
        dictMap.put("лев", "lion");
        dictMap.put("машина", "car");
        dictMap.put("любовь", "love");
        dictMap.put("бежать", "run");
        dictMap.put("собака", "dog");
        dictMap.put("я", "i");
        dictMap.put("делать", "do");
        dictMap.put("польша", "poland");
        dictMap.put("беларусь", "belarus");
    }

    @Override
    public void findTranslateRusToEng() throws DictionaryWordNotFoundException {
        Scanner words = new Scanner(System.in);
        while (isRunning) {
            System.out.println("Enter russian word:");
            rus = words.nextLine();
            rus = rus.toLowerCase();
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

    public static String getKeyByValue(Map<String, String> dictMap, String value) {
        for (Map.Entry<String, String> entry : dictMap.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

    @Override
    public void quiz() {
        Set<String> ruSet = dictMap.keySet();
        Scanner words = new Scanner(System.in);
        int wordCount = 0;
        for (String key : ruSet) {
            System.out.println("Enter translate word in russian: " + key);
            rus = words.nextLine();
            rus = rus.toLowerCase();
            if (dictMap.containsValue(rus)) {
                wordCount++;
            }
        }
        System.out.println("Your result is " + wordCount + " points");
    }

    @Override
    public void findTranslateEngToRus() {
        Scanner words = new Scanner(System.in);
        while (isRunning) {
            System.out.println("Enter english word:");
            eng = words.nextLine();
            eng = eng.toLowerCase();
            String translated = "";
            translated += getKeyByValue(dictMap, eng);
            if (!dictMap.containsValue(eng)) {
                System.out.println("Not found " + eng + "." + " Enter another word");
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
            System.out.println("Russian words: = " + entry.getKey() + " English words: "
                    + entry.getValue());
        }
    }
}
