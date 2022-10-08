package CurrencyConverter;

public class CoinFactory {

    //Creates the coins
    public static Coin getCoinsInstance(Coins coins){
        switch (coins){
            case ILS:
                return new ILS();
            case USD:
                return new USD();
            default:
                return null;
        }
    }
}