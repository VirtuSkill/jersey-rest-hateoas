package org.virtuskill.jersey.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.virtuskill.jersey.domain.Address;
import org.virtuskill.jersey.domain.Student;

public class StudentDAO {

	private static HashMap<Long, Student> students = new HashMap<Long, Student>();

	static {
		Address jackAddress = new Address(1, "120", "jack street", "paris", "00900");
		Address johnAddress = new Address(2, "123", "john street", "london", "00930");
		Address maryAddress = new Address(3, "124", "mary street", "london", "00940");
		Address sofiaAddress = new Address(4, "125", "sofia street", "paris", "00909");
		Address markAddress = new Address(5, "457", "mark street", "london", "10900");
		Address samAddress = new Address(6, "323", "sam street", "london", "20900");
		Address mikeAddress = new Address(6, "673", "mike street", "paris", "70900");

		Student jack = new Student(100, "Jack", "III", "Stanford", new ArrayList<>(Arrays.asList(jackAddress)));
		Student john = new Student(101, "John", "III", "Hartford", new ArrayList<>(Arrays.asList(johnAddress)));
		Student mary = new Student(102, "Mary", "III", "Hartford", new ArrayList<>(Arrays.asList(maryAddress)));
		Student sofia = new Student(103, "Sofia", "VI", "Stanford", new ArrayList<>(Arrays.asList(sofiaAddress)));
		Student mark = new Student(104, "Mark", "VI", "Hartford", new ArrayList<>(Arrays.asList(markAddress)));
		Student sam = new Student(105, "Sam", "VI", "Hartford", new ArrayList<>(Arrays.asList(samAddress)));
		Student mike = new Student(106, "Mike", "V", "Stanford", new ArrayList<>(Arrays.asList(mikeAddress)));

		students.put(jack.getId(), jack);
		students.put(john.getId(), john);
		students.put(mary.getId(), mary);
		students.put(sofia.getId(), sofia);
		students.put(mark.getId(), mark);
		students.put(sam.getId(), sam);
		students.put(mike.getId(), mike);
	}

	public List<Student> getAllStudentDetails() {
		return new ArrayList<Student>(students.values());
	}

	public Student getStudent(long id) {
		Student obj = students.get(id);
		return obj;
	}

	public List<Address> getStudentAddress(long id) {
		for (long key : students.keySet()) {
			Student stdObj = students.get(key);
			if (stdObj.getId() == id) {
				List<Address> addrObj = stdObj.getAddress();
				return addrObj;
			}
		}
		return null;
	}
}
