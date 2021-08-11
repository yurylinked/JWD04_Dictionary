package DictionaryService;

import Dao.DictionaryDAO;
import Exception.DictionaryWordNotFoundException;
import java.io.*;
import java.util.Map;
import java.util.Scanner;

public class DictionaryService extends DictionaryDAO implements DictionaryInterface {

    public void putNewWord() throws IOException {
        Scanner words = new Scanner(System.in);
        while (true) {
            System.out.println("Enter russian word:");
            String rus = words.nextLine();
            System.out.println("Enter english translate:");
            String eng = words.nextLine();
            dictMap.put(rus, eng);
            System.out.println(rus +" = "+ eng + " was added to the dictionary");
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
    public void findTranslate throws DictionaryWordNotFoundException() {
        Scanner words = new Scanner(System.in);
        while (true) {
            System.out.println("Enter russian word:");
            rus = words.nextLine();
            String translated = "";
            if (dictMap.containsKey(rus)) {
                translated += dictMap.get(rus);
            } else {
                translated += rus;
            }
            System.out.println(rus + " in english is " + translated);
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
