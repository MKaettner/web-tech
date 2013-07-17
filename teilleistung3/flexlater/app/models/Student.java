package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.validation.Constraints.*;

@Entity
public class Student extends Model {

	// Attribute
	@Id
	public Integer studentId;
	@Required
	public String name, firstName;
	@Required
	public Integer majorId;
	@OneToMany(mappedBy="student",cascade=CascadeType.ALL)
	public List<Enrollment> enrollments;
	

	// Methoden

	public static Finder<Integer, Student> find = new Finder (Integer.class, Student.class);

	public static List<Student> all() {
		return find.all();
	}

	public static void create(Student student) {
		student.save();
	}

	public static void delete(Integer studentId) {
		find.ref(studentId).delete();
	}
	
	public static void edit(Student updatedStudent) {
		updatedStudent.update();
	}

	
}
