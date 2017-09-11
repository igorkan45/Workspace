

import java.util.Date;

public class Main {

	public static void main(String[] args) {
		
		//You may test that your code works find here
		//Please check that your code works and has no 
		//compilation problems before to submit
		
		Date date1 = new Date(2017-11-11);
		Date date2 = new Date(2010-11-11);
		Date date3 = new Date(2001-11-11);
		Date date4 = new Date(1900-11-11);
		
		Student student1 = new Student(1, "Student1", date1, 8.2);
		Student student2 = new Student(2, "Student2", date2, 7.1);
		Student student3 = new Student(3, "Student3", date3, 9.4);
		Student student4 = new Student(4, "Student4", date4, 6.8);
		
		Student studentsArray[] = new Student[4];
		studentsArray[0] = student1;
		studentsArray[1] = student2;
		studentsArray[2] = student3;
		studentsArray[3] = student4;
	}

}
