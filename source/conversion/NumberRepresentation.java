public class NumberRepresentation {

    private int number; // Цілочисельне значення

    // Конструктор
    public NumberRepresentation(int number) {
        this.number = number;
    }

    // Метод для отримання двійкового представлення числа
    public String getBinary() {
        return Integer.toBinaryString(number);
    }

    // Метод для отримання вісімкового представлення числа
    public String getOctal() {
        return Integer.toOctalString(number);
    }

    // Метод для отримання шістнадцяткового представлення числа
    public String getHexadecimal() {
        return Integer.toHexString(number);
    }

    public int getNumber() {
        return number;
    }

    // Тестовий метод
    public static void main(String[] args) {
        // Створюємо об'єкт для числа 42
        NumberRepresentation nr = new NumberRepresentation(42);

        // Виводимо двійкове, вісімкове та шістнадцяткове представлення
        System.out.println("Число: " + nr.getNumber());
        System.out.println("Двійкове представлення: " + nr.getBinary());
        System.out.println("Вісімкове представлення: " + nr.getOctal());
        System.out.println("Шістнадцяткове представлення: " + nr.getHexadecimal());
    }
}
