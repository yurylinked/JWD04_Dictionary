package DictionaryService;
import Exception.DictionaryWordNotFoundException;
import java.io.IOException;

public interface DictionaryInterface{
    void saveWord();

    void findTranslateEngToRus();

    void wordCount();

    void putNewWord() throws IOException;

    void outputAllWords();

    void findTranslateRusToEng() throws DictionaryWordNotFoundException;
}