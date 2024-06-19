package SearchPackage;

import java.io.IOException;
import java.util.Scanner;

public class TestMain {

	//Main Method
	public static void main(String[] args) throws IOException, InterruptedException {
		
      
		Scanner sc = new Scanner(System.in);
		
		//instantiating Onlinesearch class
		Onlinesearch os = new Onlinesearch();
		
		System.out.println("Select your browser ");
		System.out.println("1. Chrome Browser ");
		System.out.println("2. Edge   Browser   ");
		System.out.println("3. To Exit press    ");
		System.out.println("Enter your Choice(1/2/3) ");
		
		int option =1;
		
		//selecting driver using user input
		while(option==1 || option==2)
			try {
				{
					 option = sc.nextInt();
				
				      if(option ==1) {
					     os.Test(DriverSetup.getChromeWEbDriver());
				        }
				       else if(option ==2) {
				    	   os.Test(DriverSetup.getEdgeWEbDriver());
				  
				         }
				       else if(option==3) {
				    	   break;
				       }
				       else {
				    	   System.out.println("Invalid Input");
				    	   break;
					        
				           }
				      break;
				
				}
			} catch (IOException e) {
				
				e.printStackTrace();
			}
	
		
		System.out.println("\n");
		System.out.println("----------------------------");
		System.out.println("       Thank You");
		System.out.println("----------------------------");
		

		
	}

}
