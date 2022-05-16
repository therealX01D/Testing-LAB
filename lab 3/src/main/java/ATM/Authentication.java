package ATM;

public class Authentication {
    public String cardvalid(String cardno){
        return cardno.length()== 16 ? "valid":"not valid";
    }
    public String pinvalid(String pin){
        return pin.length()== 4 ? "valid":"not valid";
    }
    public String access(String pin, String card, String mode,int amount){
        if(cardvalid(card)=="not valid"||pinvalid(pin)=="not valid"){
            return "not valid card or pin";
        }
        CashStorage cs = new CashStorage(500);
        if(amount<0) return "cannot complete transaction";
        if(mode=="deposit") {
            cs.deposit(amount);
        } else if (mode=="withdrawal") {
            int k =cs.withdrawal(amount);
            if (k==-1) return "No sufficent amount";
        } else{
            return "undefined mode";
        }
        return "transaction success";
    }
}
