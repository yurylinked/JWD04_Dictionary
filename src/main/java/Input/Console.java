package Input;
import Exception.DictionaryWordNotFoundException;
public interface Console {
    void main();

    void menu();

    void computation(String choice) throws DictionaryWordNotFoundException;
}
