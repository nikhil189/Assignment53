package acadglidassignment;

import java.util.Scanner;

public class EmployeeManager
{

	public static void main(String ...K)
	{
		try
		{
			EmployeeManager objEmployeeManager  = new EmployeeManager(); // object to fetch functions of Employee Manager Class
			int IEmpIndex;
			//initializing values for permanent Employees
			PermanentEmp objPermanentEmp1 = new PermanentEmp(1001, "Sunil Date", 5, 2, 3, 10000);
			PermanentEmp objPermanentEmp2 = new PermanentEmp(1002, "Suraj Patil", 2, 1, 3, 8000);
			PermanentEmp objPermanentEmp3 = new PermanentEmp(1003, "Sourabh Jain", 4, 3, 2, 12000);
			PermanentEmp objPermanentEmp4 = new PermanentEmp(1004, "Saransh Sharma", 5, 2, 4, 18000);
			
			//inititalizing values for Temporary Employees
			TemporaryEmp objTemporaryEmp1 = new TemporaryEmp(5001, "Rakesh Khandagale", 5, 10000);
			TemporaryEmp objTemporaryEmp2 = new TemporaryEmp(5002, "Amit Sharma", 2, 20000);
			TemporaryEmp objTemporaryEmp3 = new TemporaryEmp(5003, "Shivam Bahuguna", 7, 10500);
			TemporaryEmp objTemporaryEmp4 = new TemporaryEmp(5004, "Prashant Pashte", 4, 11000);
			
			PermanentEmp arrPermanentEmp [] = {objPermanentEmp1, objPermanentEmp2,objPermanentEmp3, objPermanentEmp4}; // array containing records of all PermannetEmp
			TemporaryEmp arrTemporaryEmp [] ={objTemporaryEmp1,objTemporaryEmp2,objTemporaryEmp3,objTemporaryEmp4};
			
			System.out.println("Hello, Welcome to Leave and Salary Management System");
			System.out.println("Please Enter Your Employee ID Permanent Emp id between 1001 -1004 and temperory Employee between 5001-5004 ");
			
			Scanner objScanner = new Scanner(System.in);
			int tempEmpID = objScanner.nextInt();
			if(objEmployeeManager.checkPermanentEmp(tempEmpID)) // check whether a valid PErmanent Employee or Temporary
			{
				IEmpIndex =objEmployeeManager.getPermanentEmployeeDetails(tempEmpID, arrPermanentEmp); // gets index of employee from Records
				System.out.println("\n Employee Details :::: " + "\n Employee ID:::: "+ arrPermanentEmp[IEmpIndex].empId+"\n Name::::" +arrPermanentEmp[IEmpIndex].empName);
				System.out.println("Do you want to Apply for leave or know total salary? Press 1 for leave and 2 for salary");
				int userinput = objScanner.nextInt();
				switch(userinput)
				{
					case 1: 
					{
						System.out.println("\n Your current available laves are:::" +"\n Paid Leaves::: "+arrPermanentEmp[IEmpIndex].paid_leave + "\n Casual Leaves::: " +arrPermanentEmp[IEmpIndex].casual_leave+ "\n Sick Leaves::: " +arrPermanentEmp[IEmpIndex].sick_leave );
						System.out.println("Please Enter 'p' for paid leave 'c' for casual leave and 's' for sick leaves");
						char type = objScanner.next().charAt(0);
						System.out.println("Enter number of leaves you want to apply");
						int num_ofLeaves  = objScanner.nextInt();
						if(arrPermanentEmp[IEmpIndex].avail_leave(num_ofLeaves, type))
						{
							System.out.println("Leaves Applied Successfully");
						}
						else
						{
							System.out.println("Sorry!!! Can't apply. You have entered more leaves than available");
						}
						arrPermanentEmp[IEmpIndex].calculate_balance_leaves();
						
					}
					break;
					case 2:
					{
						arrPermanentEmp[IEmpIndex].calculate_salary();
					}
					break;
					default :
					{
						System.out.println("Invalid Input");
					}
				}
			}
				else
				{
					IEmpIndex =objEmployeeManager.getTemporaryEmployeeDetails(tempEmpID, arrTemporaryEmp); // gets index of employee from Records
					System.out.println("\n Employee Details :::: " + "\n Employee ID:::: "+ arrTemporaryEmp[IEmpIndex].empId+"\n Name::::" +arrTemporaryEmp[IEmpIndex].empName);
					System.out.println("Do you want to Apply for leave or know total salary? Press 1 for leave and 2 for salary");
					int userinput = objScanner.nextInt();
					switch(userinput)
					{
						case 1: 
						{
							System.out.println("\n Your total available laves are:::" + arrTemporaryEmp[IEmpIndex].total_leaves );
							System.out.println("Please Enter 'p' for paid leave 'c' for casual leave and 's' for sick leaves");
							char type = objScanner.next().charAt(0);
							System.out.println("Enter number of leaves you want to apply");
							int num_ofLeaves  = objScanner.nextInt();
							if(arrTemporaryEmp[IEmpIndex].avail_leave(num_ofLeaves, type))
							{
								System.out.println("Leaves Applied Successfully");
							}
							else
							{
								System.out.println("Sorry!!! Can't apply. You have entered more leaves than available");
							}
							arrTemporaryEmp[IEmpIndex].calculate_balance_leaves();
							
						}
						break;
						case 2:
						{
							arrTemporaryEmp[IEmpIndex].calculate_salary();
						}
						break;
						default :
						{
							System.out.println("Invalid Input");
						}
					}
				}
			
			
			objScanner.close();
		}
		catch(Exception ex)
		{
			System.out.println("Seems you have entered invalid input");
			System.exit(0);
		}
	}
	
	// function to get details of Permanent Employee and its index in array 
	public int getPermanentEmployeeDetails(int empID, PermanentEmp objPermanent[])
	{
		int index =0;
		for (int i = 0; i < objPermanent.length; i++) 
		{
			if(empID == objPermanent[i].empId) // compares employee id stated by user with those in records
			{
				index =i;
			}
		}
		return index;
	}
	
	// function to get details of Permanent Employee and its index in array 
	public int getTemporaryEmployeeDetails(int empID, TemporaryEmp objTemperory[])
	{
		int index =0;
		for (int i = 0; i < objTemperory.length; i++) 
		{
			if(empID == objTemperory[i].empId) // compares employee id stated by user with those in records
			{
				index =i;
			}
		}
		return index;
	}

	/*
	 * function to check permanent or temporary employee*/
	public boolean checkPermanentEmp(int tempEmpID)
	{
		boolean isPerm = false ;
		if(tempEmpID < 1001 || tempEmpID >5004 || (tempEmpID >1004 && tempEmpID <5001) )
		{
			System.out.println("Employee Does not Exist");
			
		}
		else if(tempEmpID >=1001 && tempEmpID <=1004)
		{
			isPerm = true;
		}
		else
		{
			isPerm = false;
		}
		return isPerm;
	}
	
}
