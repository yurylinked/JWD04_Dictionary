package DictionaryService;

import java.io.IOException;

public interface DictionaryInterface{
    void saveWord();

    void findTranslate throw DictionaryWordNotFoundException ();

    void wordCount();

    void putNewWord() throws IOException;

    void outputAllWords();
}