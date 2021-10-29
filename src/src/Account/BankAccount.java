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

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    //Конструктор
    protected BankAccount(double account, String bio, int pin, int openMonth) {
        this.account = account;
        this.bio = bio;
        this.pin = pin;
        this.openMonth = openMonth;
        this.detalis = new ArrayList<String>();
    }

    protected BankAccount() {
    }

    //Проверка пин кода
    protected boolean checkPin(Integer inputPin) {
        return inputPin.hashCode() == this.pin;
    }

    protected static void pinError(){
        System.out.println("Неверный пин-код!");
    }

    //Получение информации о кол-ве денег на счету
    public double getAccount() {
        return this.account;
    }
    //Снятие денег
    abstract void getSomeMoney(double money, Integer inputPin);


    //Оплатить что-либо
    public void spendMoney(double money, Integer inputPin) {
        if (checkPin(inputPin)) {
            if (checkMoney(money)) {
                this.account -= money;
                this.account += money * bonus;
                this.detalis.add(LocalDateTime.now().format(formatter)+" Покупка на сумму: " + money);
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

    //Получение информации по владельцу
    public String getBio() {
        return this.bio;
    }

    //Рассчет комисси и штрафов
    abstract void makeFineAndOther();

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


}
