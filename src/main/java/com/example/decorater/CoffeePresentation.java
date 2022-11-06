package com.example.decorater;

public class CoffeePresentation {

    public static void main(String[] args) {
        Coffee americano = new Americano();

//        Coffee americanoWithMocha = new Mocha(americano);
//        Coffee americanoWith2Mocha = new Mocha(americanoWithMocha);
//        Coffee americanoWith2MochaAndMilk = new Milk(americanoWith2Mocha);
//        Coffee americanoWith2MochaAndMilkAndChocolate = new Chocolate(americanoWith2MochaAndMilk);

        Coffee americanoWith2MochaAndMilkAndChocolate = new Chocolate(new Milk(new Mocha(americano)));
        System.out.println("Decription:" + americanoWith2MochaAndMilkAndChocolate.getDecription());
        System.out.println("Cost:" + americanoWith2MochaAndMilkAndChocolate.getCost());
    }
}

interface Coffee{
    String getDecription();

    float getCost();
}

class Americano implements Coffee{

    @Override
    public String getDecription() {
        return "Americano";
    }

    @Override
    public float getCost() {
        return 1.5f;
    }
}

class Expresso implements Coffee{

    @Override
    public String getDecription() {
        return "Expresso ";
    }

    @Override
    public float getCost() {
        return 1.3f;
    }
}

class Cappucino implements Coffee{

    @Override
    public String getDecription() {
        return "Cappucino ";
    }

    @Override
    public float getCost() {
        return 1.4f;
    }
}

abstract class CoffeeDecorator implements Coffee{
    protected Coffee decoratedCoffee;

    protected CoffeeDecorator(Coffee decoratedCoffee){
        this.decoratedCoffee = decoratedCoffee;
    }
    @Override
    public String getDecription() {
        return decoratedCoffee.getDecription();
    }

    @Override
    public float getCost() {
        return decoratedCoffee.getCost();
    }
}

class Mocha extends CoffeeDecorator{


    protected Mocha(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    public String getDecription() {
        return decoratedCoffee.getDecription() + " Mocha";
    }

    @Override
    public float getCost() {
        return .2f + decoratedCoffee.getCost();
    }
}

class Milk extends CoffeeDecorator{

    protected Milk(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    public String getDecription() {
        return decoratedCoffee.getDecription() + " Milk";
    }

    @Override
    public float getCost() {
        return .3f + decoratedCoffee.getCost();
    }
}


class Chocolate extends CoffeeDecorator{

    protected Chocolate(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    public String getDecription() {
        return decoratedCoffee.getDecription() + " Chocolate";
    }

    @Override
    public float getCost() {
        return .4f + decoratedCoffee.getCost();
    }
}
