import java.util.Date;

/**
 * A fix-sized array of students array length should always be equal to the
 * number of stored elements after the element was removed the size of the array
 * should be equal to the number of stored elements after the element was added
 * the size of the array should be equal to the number of stored elements null
 * elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given
 * class, interface or method DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;

	/**
	 * DO NOT remove or change this constructor, it will be used during task
	 * check
	 * 
	 * @param length
	 */

	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	public Student[] getStudents() {

		Student[] returnStudents = new Student[students.length];
		int j = 0;

		for (int i = 0; i < students.length; i++) {

			returnStudents[j] = students[i];
			j++;
		}

		return returnStudents;
	}

	@Override
	public void setStudents(Student[] students) throws IllegalArgumentException {

		// here we have basic array students[]
		// and array which we want to replace the basic array replaceStud[]

		Student[] replaceStud = new Student[5];
		int j = 0;

		for (int i = 0; i < students.length; i++) {
			students[i] = replaceStud[j];
			j++;
		}

	}

	@Override
	public Student getStudent(int index) throws IllegalArgumentException {

		return students[index];
	}

	@Override
	public void setStudent(Student student, int index) throws IllegalArgumentException {

		students[index] = student;

	}

	@Override
	public void addFirst(Student student) throws IllegalArgumentException {

		int newLength = students.length + 1;
		Student[] newArray = new Student[newLength];
		int j = 1;

		newArray[0] = student;

		for (int i = 0; i < students.length; i++) {

			newArray[j] = students[i];
			j++;

		}
	}

	@Override
	public void addLast(Student student) throws IllegalArgumentException {

		int newLength = students.length + 1;
		Student[] newArray = new Student[newLength];
		int j = 0;

		newArray[newLength] = student;

		for (int i = 0; i < students.length; i++) {

			newArray[j] = students[i];
			j++;

		}

	}

	@Override
	public void add(Student student, int index) throws IllegalArgumentException {

		int newLength = students.length + 1;
		Student[] newArray = new Student[newLength];
		int i = 0;
		for (int j = 0; j < index; j++) {
			newArray[j] = students[i];
			i++;
		}

		newArray[index] = student;

		int k = index;
		for (int j = index + 1; j < newLength; j++) {
			newArray[j] = students[k];
			k++;
		}

	}

	@Override
	public void remove(int index) throws IllegalArgumentException {

		int newLength = students.length - 1;
		Student[] newArray = new Student[newLength];

		int j = 0;

		for (int i = 0; i < index; i++) {
			newArray[i] = students[j];
			j++;
		}
		
		int k = index+1;

		for (int i = index; i < newLength; i++) {
			newArray[i]	= students[k];
			k++;
		}

	}

	@Override
	public void remove(Student student) {
		// Add your implementation here
	}

	@Override
	public void removeFromIndex(int index) {
		// Add your implementation here
	}

	@Override
	public void removeFromElement(Student student) {
		// Add your implementation here
	}

	@Override
	public void removeToIndex(int index) {
		// Add your implementation here
	}

	@Override
	public void removeToElement(Student student) {
		// Add your implementation here
	}

	@Override
	public void bubbleSort() {
		// Add your implementation here
	}

	@Override
	public Student[] getByBirthDate(Date date) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		// Add your implementation here
		return null;
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		// Add your implementation here
		return 0;
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		// Add your implementation here
		return null;
	}

	@Override
	public Student getNextStudent(Student student) {
		// Add your implementation here
		return null;
	}
}
