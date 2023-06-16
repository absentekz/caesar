package berzhanov.javarush.caesar;

public class Main {
    public static void main(String[] args) {
        Crypter c = new Crypter();
        System.out.println(c.encryptText("ПРИВЕТ, ЭТО Я. Привет, это я!!!", 3));
    }
}