package berzhanov.javarush.caesar;

import java.util.Arrays;

/**
 * Шифрование
 */

public class Crypter {

    private static final char[] upperAlphabet = Alphabet.upperAlphabet;
    private static final char[] lowerAlphabet = Alphabet.lowerAlphabet;
    private static final char[] otherAlphabet = Alphabet.otherAlphabet;

    /**
     *
     * @param text текст для шифрования
     * @param key ключ шифрования, например 3 (А переводится на Г)
     * @return зашифрованный текст
     */
    public String encryptText(String text, int key){
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            s.append(getCharFromAlphabet(text.charAt(i), key));
        }
        return s.toString();
    }

    private char getCharFromAlphabet(char c, int pos){
        int searchPos = Arrays.binarySearch(upperAlphabet, c);  //поиск в массиве с верхним регистром
        if (searchPos >= 0) {
            int resultPos = searchPos + pos;    //найденная позиция в массиве + pos
            //внутри [] - если перешли границу размера массива, то начать с начала массива
            return upperAlphabet[resultPos >= upperAlphabet.length ? resultPos - upperAlphabet.length : resultPos];
        }
        else {
            searchPos = Arrays.binarySearch(lowerAlphabet, c);  //поиск в массиве с нижним регистром
            if (searchPos >= 0){
                int resultPos = searchPos + pos;    //найденная позиция в массиве + pos
                //внутри [] - если перешли границу размера массива, то начать с начала массива
                return lowerAlphabet[resultPos >= lowerAlphabet.length ? resultPos - lowerAlphabet.length : resultPos];
            }
        }
        return c;   //ничего не найдено, вернуть входящую букву
    }

    public String decryptText(String text, int key){
        return null;
    }

}
