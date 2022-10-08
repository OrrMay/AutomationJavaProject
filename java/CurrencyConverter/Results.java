package CurrencyConverter;

public class Results {
    private Coins coin;
    private double amount;

    // Constructor
    public Results(Coins coin, double amount){
        this.coin = coin;
        this.amount = amount;
    }

    // Converts the results to String
    public String convertToString(){
        String amountString = String.format("%.2f", this.amount);
        if (this.coin == Coins.ILS){
            String coinString = "ILS";
            return amountString + " " + coinString;
        }else{
            String coinString = "USD";
            return amountString + " " + coinString;
        }
    }
}
