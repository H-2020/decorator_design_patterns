package com.example.decorater;

public class PizzaMaker {

    public static void main(String[] args) {

        // The PlainPizza object is sent to the Mozzarella constructor

        // and then to the TomatoSauce constructor

        Pizza basicPizza = new TomatoSauce(new Mozzarella(new PlainPizza()));

     //   System.out.println("Ingredients: " + basicPizza.getDescription());

        System.out.println("Price: " + basicPizza.getCost());

    }
}


//  Blueprint for classes that will have decorators

interface Pizza {

    public String getDescription();

    public double getCost();

}


// Implements the Pizza interface with only the required
// methods from the interface

// Every Pizza made will start as a PlainPizza

class PlainPizza implements Pizza {

    public String getDescription() {

        return "Thin dough";

    }

    public double getCost() {

        System.out.println("Cost of Dough: " + 4.00);

        return 4.00;

    }

}

// Has a "Has a" relationship with Pizza. This is an
// Aggregation Relationship

abstract class ToppingDecorator implements Pizza {

    protected Pizza tempPizza;
    // Assigns the type instance to this attribute of a Pizza

    // All decorators can dynamically customize the Pizza

    // instance PlainPizza because of this

//        public ToppingDecorator(Pizza tempPizza) {
//            this.tempPizza = tempPizza;
//        }

    public ToppingDecorator(Pizza newPizza) {

        tempPizza = newPizza;

    }

    public String getDescription() {

        return tempPizza.getDescription();

    }

    public double getCost() {

        return tempPizza.getCost();

    }

}

class Mozzarella extends ToppingDecorator {

    public Mozzarella(Pizza newPizza) {

        super(newPizza);

        System.out.println("Adding Dough");

        System.out.println("Adding Moz");

    }

    // Returns the result of calling getDescription() for

    // PlainPizza and adds " mozzarella" to it

    public String getDescription() {

        return tempPizza.getDescription() + ", mozzarella";

    }

    public double getCost() {

        System.out.println("Cost of Moz: " + .50);

        return tempPizza.getCost() + .50;

    }

}

class TomatoSauce extends ToppingDecorator {

    public TomatoSauce(Pizza newPizza) {

        super(newPizza);

        System.out.println("Adding Sauce");

    }

    // Returns the result of calling getDescription() for

    // PlainPizza, Mozzarella and then TomatoSauce
    public String getDescription() {

        return tempPizza.getDescription() + ", tomato sauce";

    }

    public double getCost() {

        System.out.println("Cost of Sauce: " + .35);

        return tempPizza.getCost() + .35;

    }

}


