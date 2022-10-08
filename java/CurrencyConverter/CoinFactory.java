package CurrencyConverter;

public class CoinFactory {

    //Creates the coin
    public static Coin getCoinsInstance(Coins coin){
        switch (coin){
            case ILS:
                return new ILS();
            case USD:
                return new USD();
            default:
                return null;
        }
    }
}