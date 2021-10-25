package shit;

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

    public BankAccount(double account, String bio, int pin, int openMonth, double fine, double commission, double bonus) {
        this.account = account;
        this.bio = bio;
        this.pin = pin;
        this.openMonth = openMonth;
        this.fine = fine;
        this.commission = commission;
        this.bonus = bonus;
        this.detalis = new ArrayList<String>();
    }

    //Получение информации о кол-ве денег на счету
    abstract double getAccount();
    //Снятие денег
    abstract void getSomeMoney(double money);
    //Оплатить что-либо
    abstract void spendMoney(double money);
    //Пополнить счет
    abstract void repAccount(double money);
    //Получение информации по владельцу
    abstract String getBio();

    //Рассчет комисси и штрафов
    abstract void makeFineAndOther();

    //Детализация по счету
    abstract ArrayList getDetalis();

    //Проверка на наличие денег
    protected boolean checkMoney(double money) {
        if (this.account < money) {
            return false;
        } else return true;
    }


}
