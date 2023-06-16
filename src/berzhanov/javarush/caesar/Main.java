package berzhanov.javarush.caesar;

public class Main {
    public static void main(String[] args) {
        CaesarCrypt c = new CaesarCrypt();
        String text = "ПРИВЕТ, ЭТО Я. Привет, это я!!! Пишу много текста, вот инглиш буквы QWERTYqwerty!\n" +
                "Новая строка, точка.\n" +
                " тЕПЕРЬ ПИШУ ГРОМКО! Я учитываю только русские буквы.\n" +
                "Была проблема с буквой ё и буквой Ё.\n" +
                "Решил проблему сортировав массив. ЙОУ, ЁХохо! ёхохо!";

        String encryptText = c.encryptText(text, 5);
        String decryptText = c.decryptText(encryptText, 5);
        System.out.println("------------Шифруем текст:          ----------");
        System.out.println(text);
        System.out.println("------------Результат шифрования:   ----------");
        System.out.println(encryptText);
        System.out.println("------------Результат дешифрования: ----------");
        System.out.println(decryptText);

    }
}