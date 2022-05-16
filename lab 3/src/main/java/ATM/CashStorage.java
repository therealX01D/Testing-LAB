package ATM;

public class CashStorage {
    int amountofmoney=500;
    CashStorage(int intialamount){
        this.amountofmoney=intialamount;
    }
    public int getAmountofmoney() {
        return amountofmoney;
    }

    public void setAmountofmoney(int amountofmoney) {
        this.amountofmoney = amountofmoney;
    }
    public int deposit(int amountdeposited){
        this.amountofmoney+=amountdeposited;
        return 0;
    }
    public int withdrawal(int amountneeded){
        if(this.amountofmoney<amountneeded){
            return -1;
        }
        this.amountofmoney=this.amountofmoney-amountneeded;
        return 0;
    }
}
