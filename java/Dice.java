/**
 * Created by IntelliJ IDEA.
 * User: zachmanc
 * Date: Oct 21, 2010
 * Time: 12:39:14 PM
 * To change this template use File | Settings | File Templates.
 */
import java.util.Random;


public class Dice {

	private int[] rollArray;

	//Default constructor 
    public Dice(){
        this.rollArray = new int[2];
        this.rollArray[0] = 0;
		this.rollArray[1] = 0;
    }
	
	//Getter
	public int[] getRollArray() {
        return this.rollArray;
    }
	
	//Various Methods 
    public void roll(){
        Random rand = new Random();
		//Generating random numbers between 0-5
        int die1 = (rand.nextInt(6));
		int die2 = (rand.nextInt(6));
		//Add 1 to offset random number generated 
        die1 += 1;
        die2 += 1;
		//Set array with dice values 
		this.rollArray[0] = die1;
		this.rollArray[1] = die2;
    }

	public String toString(){
		return("rollArray[0]/first die roll is " + rollArray[0] +
				"\n rollArray[1]/second die roll is " + rollArray[1]); 
	}
	//Dunno if we need this 
    public void printRoll(){
        System.out.print(this.rollArray[0]);
        System.out.print(" ");
        System.out.println(this.rollArray[1]);
    }

}

