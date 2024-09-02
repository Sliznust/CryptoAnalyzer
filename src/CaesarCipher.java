public class CaesarCipher {

    // Метод для шифрования текста
    public static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                result.append((char) ((ch - base + shift) % 26 + base));
            } else {
                result.append(ch);  // Оставляем символы, не являющиеся буквами, без изменений
            }
        }
        return result.toString();
    }

    // Метод для расшифровки текста
    public static String decrypt(String text, int shift) {
        return encrypt(text, 26 - shift);  // Обратный сдвиг для расшифровки
    }
}