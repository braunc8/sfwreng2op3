/* Assignment 7 (100 marks in total; 5% of the final score of this course)
 *
 * Question 1 (40 marks)
    Use java to implement a class Dice, a class Gambler and a method that continue gambling between two gamblers until one
    gambler cannot afford the stake.

 */

// the class of Dice to play
class Dice {
    private int num_faces;

    Dice(){
        num_faces=6; // standard dice with 6 faces by default.
    }

    // implement the roll dice method that roll the dice once and return the value of the roll.
    // (5 marks)
    public int rollDice() {
        int val = (int) (Math.random()*num_faces)+1;//gives a value on the die and returns it
        return val;
    }
}

// the class of gambler
class Gambler {
    public int money;
    public Dice die;

    Gambler(int initial_money) {
        money = initial_money;
        die = new Dice();
    }

    // use static method to implement the gambling activity.
    // In a gambling activity, two gamblers gamble on a stake.
    // Each gambler rolls a die, the gambler who roles a larger value wins the stake.
    // if it is a due, then roll again, until there is a winner.
    // Note: a gambler cannot start gamble if he does not have more money than the amount of stake.
    // Note: return false if at least one gambler cannot afford the stake. Otherwise, return true.
    // Note: print the result of rolled dice values, and the winner of the gambling.
    // (20 marks)
    static boolean gambling(Gambler gambler_1, Gambler gambler_2, int stake) {
        //if gambler 1 or gambler 2 doesn't have enough money, prints who doesn't have enough and then returns false
        if (gambler_1.money<stake){//when gambler 1 doesn't have enough
            System.out.println("Gambler 1 cannot gamble because they have less than $" + stake);
            return false;
        }else if (gambler_2.money<stake){//when gambler 2 doesn't have enough
            System.out.println("Gambler 2 cannot gamble because they have less than $" + stake);
            return false;
        }

        //this code block rolls the dice
        System.out.println("Rolling dice...");
        int die_1=gambler_1.die.rollDice();
        int die_2=gambler_2.die.rollDice();

        //if they are the same, the computer prints that they need to roll again and rolls the die again, loops until die are different
        while (die_1==die_2){
            System.out.println("Both gamblers rolled a " + die_1+"! Please roll again.");

            System.out.println("Rolling dice...");
            die_1=gambler_1.die.rollDice();
            die_2=gambler_2.die.rollDice();
        }

        //prints out the dice values
        System.out.println("The value of gambler 1's die is " + die_1 + ".");
        System.out.println("The value of gambler 2's die is " + die_2 + ".");

        //prints out the winner and alters both gamblers money according to the stakes
        if (die_1>die_2){
            System.out.println("The winner is gambler 1.");
            gambler_1.money+=stake;
            gambler_2.money-=stake;
        }else {
            System.out.println("The winner is gambler 2.");
            gambler_2.money+=stake;
            gambler_1.money-=stake;
        }
        return true;
    }
}

public class Q1_DiceGambling {

    // Continue Gambling until one gambler cannot afford the stake
    // Print the amount of money of each gambler after each round of gambling.
    // Print the value of rolled dice for each gambler in each round of gambling.
    // (15 marks)
    public static void keepGambling(Gambler gambler_1, Gambler gambler_2, int stake, int max_gambling_times) {
        boolean cont;
        int i=0;
        do{
            //prints out each round number and runs each round
            int round_num=i+1;
            System.out.println("\nRound " +round_num);
            cont=Gambler.gambling(gambler_1,gambler_2,stake);

            //prints out how much money each gambler has
            System.out.println("Gambler 1 has $" +gambler_1.money);
            System.out.println("Gambler 2 has $" +gambler_2.money);

            i++;
        }while(cont&&(i<max_gambling_times));

        if(i==10){
            System.out.println("\nReached maximum number of rounds! ("+ i + ")\nExiting game");
        }
    }

    public static void main(String[] args) {
        int initial_money = 10;
        int stake = 3;
        int max_gambling_times = 10;

        Gambler gambler1 = new Gambler(initial_money);
        Gambler gambler2 = new Gambler(initial_money);

        keepGambling(gambler1, gambler2, stake, max_gambling_times);
    }
}
