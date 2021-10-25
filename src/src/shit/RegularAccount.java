package shit;

import java.util.ArrayList;

public class RegularAccount extends BankAccount {


    public RegularAccount(double account, String bio, int pin, int openMonth) {
        super(account, bio, pin, openMonth, 100, 0.1, 0);
    }


    @Override
    public double getAccount() {
        return this.account;
    }

    @Override //Снятие денег со счета
    public void getSomeMoney(double money) {
        if (checkMoney(money)) {
            this.account -= money;
            this.detalis.add("Снятие денег: " + money);
        } else {
            System.out.println("На вашем счету недостаточно денег.");
        }

    }

    @Override //Покупка чего-то
    public void spendMoney(double money) {
        if (checkMoney(money)) {
            this.account -= money;
            this.detalis.add("Покупка на сумму: " + money);
        } else {
            System.out.println("На вашем счету недостаточно денег.");
        }



    }
    //Пополнение денег
    @Override
    public void repAccount(double money) {
        this.account += money;
    }

    //Получить данные по владельцу
    @Override
    public String getBio() {
        return bio;
    }

    @Override
    void makeFineAndOther() {
        this.account -= Math.min(fine, this.account*commission);
        if (this.account < 5000) {
            this.account -= fine;
            this.detalis.add("Штраф: " + fine);
        }
        this.detalis.add("Обслуживание: " + Math.min(fine, this.account*commission));
    }

    @Override
    public ArrayList<String> getDetalis() {
        return detalis;
    }

    @Override
    public String toString() {
        return "shit.RegularAccount{" +
                "account=" + account +
                ", bio='" + bio + '\'' +
                ", pin=" + pin +
                ", openMonth=" + openMonth +
                ", fine=" + fine +
                ", commission=" + commission +
                ", bonus=" + bonus +
                ", detalis=" + detalis +
                '}';
    }
}
