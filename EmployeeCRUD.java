import java.util.*;
class Employee{
	int id;
	String name;
	String department;
	
	public Employee(int id, String name, String department) {
		this.id = id;
		this.name = name;
		this.department = department;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getdepartment() {
		return department;
	}
	public void setdepartment(String department) {
		this.department = department;
	}
	
}
public class EmployeeCRUD {
	static Scanner s=new Scanner(System.in);
	public String addEmployee(List<Employee> l) {
		System.out.println("enter ID:");
		int id=s.nextInt();
		String name=s.next();
		System.out.println("Enter Name:");
		String department=s.next();
		System.out.println("Enter department:");
		l.add(new Employee(id,name,department));
		return "Added Succesfully";
	}
	public String deleteEmployee(List<Employee>l) {
		System.out.println("Enter ID to delete");
		int id=s.nextInt();
		for(Employee i:l) {
			if(i.id==id) {
				l.remove(i);
				break;
			}
		}
		return "Deleted Successfully";
		}
	public void searchEmployee(List<Employee> l) {
		System.out.println("Enter Id to search");
		int id=s.nextInt();
		int f=0;
		for(Employee i:l) {
			if(i.id==id) {
				System.out.println("ID:"+i.getId()+"\nName:"+i.getName()+"\ndepartment:"+i.getdepartment()+"\n------------------");
				f=1;
				break;
			}
		}
		if(f==0) {
			System.out.println("Employee not found");
		}
	}
	public void displayEmployees(List<Employee> l) {
		System.out.println("Employees\n------------------------");
		if(l.isEmpty()){
			System.out.println("Employees List is Empty");
			return;
		}
		for(Employee i:l) {
			System.out.println("ID:"+i.getId()+"\nName:"+i.getName()+"\ndepartment:"+i.getdepartment()+"\n------------------");
			
		}
		System.out.println("-----------------------------------------");
	}
	public static void main(String[] args) {
		List<Employee> l=new ArrayList<>();
		EmployeeCRUD m=new EmployeeCRUD();
		int c;
		do{
			System.out.println("1.Add\n2.Delete\n3.Search\n4.Display\n5.Exit");
			c=s.nextInt();
			if(c<1||c>5){
				System.out.println("Invalid choice");
				c=1;
				continue;
			}
			switch(c) {
			case 1: System.out.println(m.addEmployee(l));
					break;
			case 2: System.out.println(m.deleteEmployee(l));
					break;
			case 3: m.searchEmployee(l);
					break;
			case 4: m.displayEmployees(l);
					break;
			default:System.out.println("Exiting");
					break;
			}
		}while(c<5);
	}
}
