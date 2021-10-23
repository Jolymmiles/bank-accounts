import java.util.ArrayList;

public class RegularAccount extends BankAccount {


    public RegularAccount(double account, String bio, int pin, int openMonth) {
        super(account, bio, pin, openMonth, 100, 0.1, 0);
    }



    //Проверка на правильность пина
//    private boolean pinCheck(int pin) {
//        boolean check;
//        pin.hashCode()...
//
//        return check;
//    }


    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public double getAccount() {
        return this.account;
    }

    @Override //Снятие денег со счета
    public void getSomeMoney(double money) {
        this.account -= money;
        this.detalis.add("Снятие денег: " + money);
    }

    @Override //Покупка чего-то
    public void spendMoney(double money) {
        this.account -= money;
        this.detalis.add("Покупка на сумму: " + money);
    }

    @Override
    public void repAccount(double money) {
        this.account += money;
        this.detalis.add("Пополнение счета на сумму:" + money);
    }

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
        return "RegularAccount{" +
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
