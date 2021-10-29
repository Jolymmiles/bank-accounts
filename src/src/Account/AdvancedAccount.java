package Account;

import java.util.ArrayList;

public class AdvancedAccount extends BankAccount {

    public AdvancedAccount(double account, String bio, Integer pin, int openMonth) {
        this.account = account;
        this.bio = bio;
        this.pin = pin.hashCode();
        this.openMonth = openMonth;
        this.fine = 100;
        this.commission = 0.1;
        this.bonus = 0.01;
        this.detalis = new ArrayList<String>();
    }



    public double getAccount() {
        return this.account;
    }

    @Override
    void getSomeMoney(double money, Integer inputPin) {

    }

    //Снятие денег со счета
    public void getSomeMoney(double money) {
        if (checkMoney(money)) {
            this.account -= money;
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
            this.account += money*fine < 100 ? money*fine : 0;
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
