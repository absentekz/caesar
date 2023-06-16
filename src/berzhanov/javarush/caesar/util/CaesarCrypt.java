package berzhanov.javarush.caesar.util;

import java.util.Arrays;

/**
 * Шифр Цезаря
 */

public class CaesarCrypt {

    private static final char[] upperAlphabet = Alphabet.upperAlphabet.toCharArray();

    private static final char[] lowerAlphabet = Alphabet.lowerAlphabet.toCharArray();

    /**
     * <b>Шифрование текста по ключу - сдвиг вперед на количество "ключ"<b/>
     * @param text текст для шифрования
     * @param key ключ шифрования, например 3 (А переводится на Г)
     * @return зашифрованный текст
     */
    public String encryptText(String text, int key){
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            s.append(encryptChar(text.charAt(i), key));
        }
        return s.toString();
    }

    /**
     * <b>Дешифрование текста по ключу - сдвиг назад на количество "ключ"<b/>
     * @param text текст для дешифрования
     * @param key ключ шифрования, например 3 (Г переводится на А)
     * @return дешифрованный текст
     */
    public String decryptText(String text, int key){
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            s.append(decryptChar(text.charAt(i), key));
        }
        return s.toString();
    }


    private static char encryptChar(char c, int pos){
        int searchPos = binarySearch(upperAlphabet, c);  //поиск в массиве с верхним регистром
        if (searchPos >= 0) {
            int resultPos = searchPos + pos;    //найденная позиция в массиве + pos
            //внутри [] - если перешли границу размера массива, то начать с начала массива
            return upperAlphabet[resultPos >= upperAlphabet.length ? resultPos - upperAlphabet.length : resultPos];
        }
        else {
            searchPos = binarySearch(lowerAlphabet, c);  //поиск в массиве с нижним регистром
            if (searchPos >= 0){
                int resultPos = searchPos + pos;    //найденная позиция в массиве + pos
                //внутри [] - если перешли границу размера массива, то начать с начала массива
                return lowerAlphabet[resultPos >= lowerAlphabet.length ? resultPos - lowerAlphabet.length : resultPos];
            }
        }
        return c;   //ничего не найдено, вернуть входящую букву
    }

    private static char decryptChar(char c, int pos){
        int searchPos = binarySearch(upperAlphabet, c);  //поиск в массиве с верхним регистром
        if (searchPos >= 0) {
            int resultPos = searchPos - pos;    //найденная позиция в массиве - pos
            //внутри [] - если перешли границу размера массива, то начать с начала массива
            return upperAlphabet[resultPos < 0 ? upperAlphabet.length + resultPos : resultPos];
        }
        else {
            searchPos = binarySearch(lowerAlphabet, c);  //поиск в массиве с нижним регистром
            if (searchPos >= 0){
                int resultPos = searchPos - pos;    //найденная позиция в массиве - pos
                //внутри [] - если перешли границу размера массива, то начать с начала массива
                return lowerAlphabet[resultPos < 0 ? lowerAlphabet.length + resultPos : resultPos];
            }
        }
        return c;   //ничего не найдено, вернуть входящую букву
    }

    private static int binarySearch(char[] array, char target) {
        Arrays.sort(array);
        return Arrays.binarySearch(array, target);
    }


}
