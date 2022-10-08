package CurrencyConverter;

public class ILS extends Coin {

    private double value = 0.28;
    // Gets the value of ILS in USD
    @Override
    public double getValue(){
        return this.value;
    }

    // ILS gets the USD value according to the amount of ILS
    @Override
    public double calculate(double amt){
        return (amt * value);
    }
}
