import java.util.Random;
import java.util.Scanner;

public class RouletteGame
{
	static String schwarz_rot(int nummer) {
        if (nummer < 11) {
        	if ((nummer % 2) != 0)
        		return "rot";
        	else if ((nummer % 2) == 0)
        		return "schwarz";
        }
        else if (nummer < 19) {
        	if ((nummer % 2) != 0)
        		return "schwarz";
        	else if ((nummer % 2) == 0)
        		return "rot";
        }
        else if (nummer < 29) {
        	if ((nummer % 2) != 0)
        		return "rot";
        	else if ((nummer % 2) == 0)
        		return "schwarz";
        }
        else if (nummer < 37) {
        	if ((nummer % 2) != 0)
        		return "schwarz";
        	else if ((nummer % 2) == 0)
        		return "rot";
        }
		return null;
    }
	
	
	static int generator(int min, int max) {
	    Random random = new Random();
	    return random.nextInt(max - min) + min;
	}
	
	
   public static void main(String[] args)
   {

       Scanner keyboard = new Scanner(System.in);
       int choice;
       int number;
       int rouletteNum;
       int result = 0;
   
       int startkapital = 1000;
       int einsatzbetrag = 0;
       
       

       while (startkapital > 0)
       {
    	   System.out.println("Startkapital: "+  startkapital + " Euro");
    	   
           System.out.print("Geben Sie Ihren Einsatzbetrag ein: ");
           
           einsatzbetrag = keyboard.nextInt();
           
           if (einsatzbetrag <= startkapital) {
        	   
        	   startkapital = startkapital - einsatzbetrag;
        	   
        	   System.out.println("Geben Sie Ihre Spielentscheidung ein \n");
	           System.out.println("0 - Rot\n1 - Schwarz\n2 - Nummer\n");
	           
	           choice = keyboard.nextInt();
	           while (choice < 0 || choice > 2)
	           {
	               System.out.print("Spielentscheidung nicht gültig !");
	               choice = keyboard.nextInt();
	           }
	           number = 0;
	           rouletteNum = generator(1,37);
	           if (choice == 2)  
	           {
	               while (number < 1 || number > 37)
	               {
	                   System.out.print("Setzen Sie auf die Zahl(1-36): ");
	                   number = keyboard.nextInt();
	               }
	               
	               if (rouletteNum == number)
	                   result = 35;
	               else
	                   result = 0;
	           }
	           else if (choice == 1){
	        	   if (schwarz_rot(rouletteNum) == "schwarz")
	        		   result = 2;
	               else
	                   result = 0;      	   
	           }
	           else if (choice == 0){
	        	   if (schwarz_rot(rouletteNum) == "rot")
	        		   result = 2;
	               else
	                   result = 0;
	           }
	           
	           
	           System.out.println("Roulette number: " + rouletteNum);
	       
	           if (result > 0)
	           {
	        	   int betrag = result * einsatzbetrag;
	               System.out.println("Herzlichen Glueckwunsch!!! Sie haben gewonnen!");
	               System.out.println("Sie haben " + betrag + " Euro gewonnen ! \n");	
	               startkapital = startkapital + betrag;
	           }
	           else
	           {
	               System.out.println("Sie haben verloren. Mehr Glueck beim naechsten Mal!");
	               System.out.println("Sie haben "+  einsatzbetrag + " Euro verloren !\n");
	               
	
	           }
           }
           else {
        	   
        	   System.out.println("Einsatzbetrag nicht gueltig");
        	   continue;
           }
           
           
       }
       
       System.out.println("Startkapital nicht genug !");

   }
}