package acadglidassignment;

class TemporaryEmp extends Employee
{
	double basic; // variable to store basic salary
	// constructo to inititalize attributes of a temporary employee
	public TemporaryEmp(int empId, String empName, int total_leaves, double basic) 
	{
		this.empId = empId;
		this.empName = empName;
		this.total_leaves = total_leaves;
		this.basic = basic;
	}
	@Override
	
	// prints total leaves of employee 
	void calculate_balance_leaves() 
	{
		
		System.out.println("Employee's total leaves are-----" + this.total_leaves); 
	}

	@Override
	boolean avail_leave(int no_of_leaves, char type_of_leave)
	{
		boolean canApplyLeave = false;
		if((this.total_leaves - no_of_leaves)>=0) // calaculate if Employee can apply leave
		{
			canApplyLeave = true;
			this.total_leaves = this.total_leaves - no_of_leaves;
		}
		return canApplyLeave; // returns true if user can apply leave
	}

	@Override
	void calculate_salary() 
	{
		double pfa = (0.12) * this.basic; // formula to calculate pf
		double hra = (0.50) * this.basic; // formula to calculate hra
		this.total_salary = this.basic + hra - pfa; // formula to calculate total salary
		System.out.println("Emplyee's total salary is--- Rupees" + this.total_salary ); // prints total salary of employee
	}

}
