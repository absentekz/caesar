package berzhanov.javarush.caesar;

import java.util.Arrays;

/**
 * Шифрование
 */

public class Crypter {

    private static final char[] alphabet = {'А', 'Б', 'В', 'Г', 'Д'};

    /**
     *
     * @param text - текст для шифрования
     * @param key - ключ шифрования, например 3 (А переводится на Г)
     * @return - зашифрованный текст
     */
    public String encryptText(String text, int key){
        //List<Character> arrayList = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            //arrayList.add(text.indexOf(i));
            s.append(getCharFromAlphabet(text.charAt(i), key));
        }
        return s.toString();

    }

    private char getCharFromAlphabet(char c, int pos){
        int index = Arrays.binarySearch(alphabet, c) + pos;
        return alphabet[index];
    }


}
