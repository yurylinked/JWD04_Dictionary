package Input;

public interface Console {
    void main();

    void menu();

    void computation(String choice) throws Exception.DictionaryWordNotFoundException;
}
