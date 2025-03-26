package test;

import model.CalculationData;
import logic.Converter;
import io.SerializationDemo;

public class TestSerialization {
    public static void main(String[] args) {
        int number = 42;
        String filename = "data.ser";

        // Конвертація
        CalculationData data = Converter.convert(number);
        data.display();

        // Серіалізація
        SerializationDemo.saveToFile(filename, data);

        // Десеріалізація
        CalculationData loadedData = SerializationDemo.loadFromFile(filename);
        if (loadedData != null) {
            System.out.println("\nВідновлені дані:");
            loadedData.display();  // transient поле буде null
        }
    }
}
