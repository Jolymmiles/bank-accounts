package Account;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public abstract class BankAccount {
    protected double account;
    protected String bio;
    protected int pin;
    protected int openMonth;
    protected double fine;
    protected double commission;
    protected double bonus;
    protected ArrayList<String> detalis;

    protected final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    //Конструктор
    protected BankAccount(double account, String bio, Integer pin, int openMonth, double fine, double commission, double bonus) {
        this.account = account;
        this.bio = bio;
        this.pin = pin.hashCode();
        this.openMonth = openMonth;
        this.fine = fine;
        this.commission = commission;
        this.bonus = bonus;
        this.detalis = new ArrayList<String>();
    }


    //Проверка пин кода
    protected boolean checkPin(Integer inputPin) {
        return inputPin.hashCode() == this.pin;
    }

    protected static void pinError(){
        System.out.println("Неверный пин-код!");
    }

    //Рассчет комисси и штрафов
    abstract void makeFineAndOther();

    //Снятие денег
    abstract void getSomeMoney(double money, Integer inputPin);

    //Оплатить что-либо
    public void spendMoney(double money, Integer inputPin, String shopName) {
        if (checkPin(inputPin)) {
            if (checkMoney(money)) {
                this.account -= money;
                this.account += money * bonus;
                this.account += bonus == 0.02 | bonus == 0 ? money*bonus : money*this.bonus < 100 ? money*this.bonus : 0;
                this.detalis.add(LocalDateTime.now().format(formatter)+" Покупка на сумму: " + money + " " + shopName);
            } else {
                System.out.println("На вашем счету недостаточно денег.");
            }
        } else {
            pinError();
        }
    }

    //Пополнить счет
    public void repAccount(double money, Integer inputPin) {
        if (checkPin(inputPin)) {
            this.account += money;
        } else {
            pinError();
        }
    }

    //Получение информации о кол-ве денег на счету
    public double getAccount(Integer inputPin) {
        if (checkPin(inputPin)) {
            return this.account;
        } else {
            pinError();
            return 0;
        }
    }

    //Получение информации по владельцу
    public String getBio() {
        return this.bio;
    }

    //Детализация по счету
    public void getDetalis() {
        for (String detali : this.detalis) {
            System.out.println(detali);
        }
    }

    //Проверка на наличие денег
    protected boolean checkMoney(double money) {
        return !(this.account < money);
    }

    @Override
    public String toString() {
        return "\nДенег на счету: " + this.account +
                "\nФИО Владельца: " + this.bio +
                "\nМесяц открытия: " + this.openMonth +
                "\nШтраф: " + this.fine +
                "\nКомиссия: " + this.commission +
                "\nКэшбэк: " + this.bonus ;
    }
}
