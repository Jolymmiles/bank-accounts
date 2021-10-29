package Account;

import java.util.ArrayList;

public class YouthAccount extends BankAccount{

    public YouthAccount(double account, String bio, Integer pin, int openMonth) {
        this.account = account;
        this.bio = bio;
        this.pin = pin.hashCode();
        this.openMonth = openMonth;
        this.fine = 300;
        this.commission = 0.1;
        this.bonus = 0.02;
        this.detalis = new ArrayList<String>();
    }

    //Снятие денег со счета
    @Override
    public void getSomeMoney(double money, Integer inputPin) {
        if (checkPin(inputPin)) {
            if (checkMoney(money-10)) {
                this.account -= money-10;
                this.detalis.add("Снятие денег: " + money);
            } else {
                System.out.println("На вашем счету недостаточно денег.");
            }
        } else {
            pinError();
        }
    }

    void makeFineAndOther() {
        this.account -= Math.min(fine, this.account*commission);
        if (this.account < 5000) {
            this.account -= fine;
            this.detalis.add("Штраф: " + fine);
        }
        this.detalis.add("Обслуживание: " + Math.min(fine, this.account*commission));
    }

}
