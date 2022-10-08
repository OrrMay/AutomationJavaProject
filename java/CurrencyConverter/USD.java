package CurrencyConverter;

public class USD extends Coin {

    private double value = 3.52;
    // Gets the value of USD in ILS
    @Override
    public double getValue(){
        return this.value;
    }

    // USD gets the ILS value according to the amount of USD
    @Override
    public double calculate(double amt){
        return (amt * value);
    }
}
