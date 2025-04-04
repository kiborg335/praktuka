package model;

import java.io.Serializable;

/**
 * Клас для зберігання параметрів та результатів обчислень.
 * Реалізує серіалізацію.
 */
public class CalculationData implements Serializable {
    private static final long serialVersionUID = 1L;

    private int number;
    private String binary;
    private String octal;
    private String hexadecimal;

    // Transient поле (не серіалізується)
    private transient String temporaryData;

    public CalculationData(int number) {
        this.number = number;
        this.binary = Integer.toBinaryString(number);
        this.octal = Integer.toOctalString(number);
        this.hexadecimal = Integer.toHexString(number);
        this.temporaryData = "Тимчасові дані";
    }

    public int getNumber() {
        return number;
    }

    public String getBinary() {
        return binary;
    }

    public String getOctal() {
        return octal;
    }

    public String getHexadecimal() {
        return hexadecimal;
    }

    public void display() {
        System.out.println("Число: " + number);
        System.out.println("Двійкове: " + binary);
        System.out.println("Вісімкове: " + octal);
        System.out.println("Шістнадцяткове: " + hexadecimal);
        System.out.println("Transient поле: " + temporaryData);
    }
}
