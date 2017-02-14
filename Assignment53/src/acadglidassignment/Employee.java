package acadglidassignment;

abstract class Employee
{
	int empId; // unique ID assigned to each emplyee
	String empName; // employee name
	int total_leaves; // total_leaves available to employee
	double total_salary; // total salary aof employee
	
	abstract void calculate_balance_leaves(); // function to display basic salary of employee
	abstract boolean avail_leave(int no_of_leaves, char type_of_leave); // function to update leave record of employee
	abstract void calculate_salary(); // function to calculate and display salary of employee

}
