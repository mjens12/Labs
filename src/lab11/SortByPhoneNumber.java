package lab11;

import java.util.Comparator;

public class SortByPhoneNumber implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		return o1.getPhone().compareTo(o2.getPhone());
	}
}
