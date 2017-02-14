package acadglidassignment;

class PermanentEmp extends Employee 
{
	int paid_leave, sick_leave, casual_leave; // variables to store various type of leaves
	double basic, hra, pfa; // variables to store various components of salary
	
	// constructor to initlaize various attributes of an employee
	PermanentEmp(int EmpID, String Empname, int paid_leave, int sick_leave, int casual_leave, double basic)
	{
		this.empId = EmpID;
		this.empName = Empname;
		this.paid_leave = paid_leave;
		this.sick_leave = sick_leave;
		this.casual_leave = casual_leave;
		this.total_leaves = this.paid_leave + this.sick_leave + this.casual_leave;
		this.basic = basic;
	}
	
	@Override
	void calculate_balance_leaves() // calculate total leaves of employee
	{
		
		this.total_leaves = this.paid_leave + this.sick_leave + this.casual_leave; // sum of various leaves available is denoted as total leaves
		System.out.println("Employee's total leaves are-----" + this.total_leaves); // prints total available leaves of employee
	}

	@Override
	boolean avail_leave(int no_of_leaves, char type_of_leave) // method to check if user can apply for leave and update the applicable component
	{
		boolean canApplyLeave = false;
		switch(type_of_leave)
		{
			case 'p': // paid leave computation
			{
				if((this.paid_leave - no_of_leaves)>=0)
				{
					this.paid_leave = this.paid_leave - no_of_leaves;
					canApplyLeave = true;
				}
			}
			break;
			case 's': // sick leave computation
			{
				if((this.sick_leave - no_of_leaves)>=0)
				{
					this.sick_leave = this.sick_leave - no_of_leaves;
					canApplyLeave = true;
				}
			}
			break;
			case 'c' : // casual leave computation
			{
				if((this.casual_leave - no_of_leaves)>=0)
				{
					this.casual_leave = this.casual_leave - no_of_leaves;
					canApplyLeave = true;
				}
			}
			break;
		}
		return canApplyLeave; // returns true if leave can be applied
	}

	@Override
	void calculate_salary()
	{
		 pfa = (0.12) * this.basic; // formula to calculate pf
		 hra =(0.50)* this.basic; // formula to calculate hra
		 this.total_salary = this.basic + hra - pfa; // formula to calculate total salary
		 System.out.println("Emplyee's total salary is--- Rupees" + this.total_salary ); // prints total salary of employee
	}

}
