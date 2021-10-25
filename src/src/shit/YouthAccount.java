package shit;

import java.util.ArrayList;

public class YouthAccount extends BankAccount{
    public YouthAccount(double account, String bio, int pin, int openMonth) {
        super(account, bio, pin, openMonth, 300, 10, 0.02);
    }

    public double getAccount() {
        return this.account;
    }

    //Снятие денег со счета
    public void getSomeMoney(double money) {
        if (checkMoney(money-10)) {
            this.account -= money-10;
            this.detalis.add("Снятие денег: " + money);
        } else {
            System.out.println("На вашем счету недостаточно денег.");
        }

    }

    //Покупка чего-то
    public void spendMoney(double money) {
        if (checkMoney(money)) {
            this.account -= money;
            this.detalis.add("Покупка на сумму: " + money);
            this.account += money*fine;
        } else {
            System.out.println("На вашем счету недостаточно денег.");
        }
    }

    //Пополнение счета
    public void repAccount(double money) {
        this.account += money;
        this.detalis.add("Пополнение счета на сумму:" + money);
    }


    public String getBio() {
        return bio;
    }


    void makeFineAndOther() {
        this.account -= Math.min(fine, this.account*commission);
        if (this.account < 5000) {
            this.account -= fine;
            this.detalis.add("Штраф: " + fine);
        }
        this.detalis.add("Обслуживание: " + Math.min(fine, this.account*commission));
    }


    public ArrayList<String> getDetalis() {
        return detalis;


    }
}
