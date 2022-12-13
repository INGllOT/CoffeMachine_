
import java.util.*;

public class CoffeeMachine {

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        coffeeMachine.start();

    }


    int mlOfWater = 400;
    int mlOfMilk = 540;
    int gOfCoffeeBeans = 120;
    int cups = 9;
    int money = 550;

    Scanner scanner = new Scanner(System.in);

    public void start() {
        for(;;) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scanner.nextLine();
            System.out.println();
            action(action);
            if (action.equals("exit")) break;
        }
    }

    public void action(String action) {

        switch (action) {
            case "buy":
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
                String StringChoose = scanner.nextLine();
                int choose = 0;
                if(StringChoose.equals("back")) break;

                if(!StringChoose.equals("back")) {
                    choose = Integer.parseInt(StringChoose);
                }
                if (choose == 1) {
                    if (!calculateProd(choose)) break;
                    setMlOfWater(getMlOfWater() - 250);
                    setgOfCoffeeBeans(getgOfCoffeeBeans() - 16);
                    setMoney(getMoney() + 4);
                    setCups(getCups() - 1);
                } else if (choose == 2) {
                    if (!calculateProd(choose)) break;
                    setMlOfWater(getMlOfWater() - 350);
                    setMlOfMilk(getMlOfMilk() - 75);
                    setgOfCoffeeBeans(getgOfCoffeeBeans() - 20);
                    setMoney(getMoney() + 7);
                    setCups(getCups() - 1);
                } else if (choose == 3) {
                    if (!calculateProd(choose)) break;
                    setMlOfWater(getMlOfWater() - 200);
                    setMlOfMilk(getMlOfMilk() - 100);
                    setgOfCoffeeBeans(getgOfCoffeeBeans() - 12);
                    setMoney(getMoney() + 6);
                    setCups(getCups() - 1);
                } else {
                    System.out.println("Something wrong in choosing caffe !!!");
                }
                break;

            case "fill":
                System.out.println("Write how many ml of water you want to add:");
                setMlOfWater(getMlOfWater() + scanner.nextInt());

                System.out.println("Write how many ml of milk you want to add:");
                setMlOfMilk(getMlOfMilk() + scanner.nextInt());

                System.out.println("Write how many grams of coffee beans you want to add:");
                setgOfCoffeeBeans(getgOfCoffeeBeans() + scanner.nextInt());

                System.out.println("Write how many disposable cups you want to add:");
                setCups(getCups() + scanner.nextInt());
                break;

            case "take":
                System.out.println("I gave you $" + getMoney());
                setMoney(0);
                break;
            case "remaining":
                printInfo();
                break;

            case"exit":
                break;

        }
    }
    public void printInfo() {
        System.out.println("The coffee machine has:\n" +
                mlOfWater + " ml of water\n" +
                mlOfMilk + " ml of milk\n" +
                gOfCoffeeBeans + " g of coffee beans\n" +
                cups + " disposable cups\n" +
                "$" + money + " of money\n");
    }

    public boolean calculateProd(int product) {

        HashMap<String, Double> ownedProducts = new HashMap<>();

        if (product == 1){
            double waterOnOneCupOfCoffee = mlOfWater / 250;
            double coffeeOnCupOfCoffee = gOfCoffeeBeans / 16;
            ownedProducts.put("water", waterOnOneCupOfCoffee);
            ownedProducts.put("coffee beans", coffeeOnCupOfCoffee);
            ownedProducts.put("cups", Double.valueOf(String.valueOf(cups)));

        } else if (product == 2) {
            double waterOnOneCupOfCoffee = mlOfWater / 350;
            double coffeeOnCupOfCoffee = gOfCoffeeBeans / 20;
            double milkOnOneCupOfCoffee = mlOfMilk / 75;
            ownedProducts.put("water", waterOnOneCupOfCoffee);
            ownedProducts.put("coffee beans", coffeeOnCupOfCoffee);
            ownedProducts.put("milk", milkOnOneCupOfCoffee);
            ownedProducts.put("cups", Double.valueOf(String.valueOf(cups)));

        } else if (product == 3) {
            double waterOnOneCupOfCoffee = mlOfWater / 200;
            double milkOnOneCupOfCoffee = mlOfMilk / 100;
            double coffeeOnCupOfCoffee = gOfCoffeeBeans / 12;
            ownedProducts.put("water", waterOnOneCupOfCoffee);
            ownedProducts.put("coffee beans", coffeeOnCupOfCoffee);
            ownedProducts.put("milk", milkOnOneCupOfCoffee);
            ownedProducts.put("cups", Double.valueOf(String.valueOf(cups)));
        }
        double min = Collections.min(ownedProducts.values());
        if (min < 1) {

            ownedProducts.forEach((key, value) -> {
                String val = null;
                if(value == min) {
                    System.out.println("Sorry, not enough " + key + "!");
                }
            });
            return false;
        } else {
            System.out.println("I have enough resources, making you a coffee!\n");
            return true;
        }
    }

    public int getMlOfWater() {
        return mlOfWater;
    }

    public void setMlOfWater(int mlOfWater) {
        this.mlOfWater = mlOfWater;
    }

    public int getMlOfMilk() {
        return mlOfMilk;
    }

    public void setMlOfMilk(int mlOfMilk) {
        this.mlOfMilk = mlOfMilk;
    }

    public int getgOfCoffeeBeans() {
        return gOfCoffeeBeans;
    }

    public void setgOfCoffeeBeans(int gOfCoffeeBeans) {
        this.gOfCoffeeBeans = gOfCoffeeBeans;
    }

    public int getCups() {
        return cups;
    }

    public void setCups(int cups) {
        this.cups = cups;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
