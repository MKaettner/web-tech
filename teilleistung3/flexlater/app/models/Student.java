package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity
public class Student extends Model {

	// Attribute
	@Id
	public Long studentId;
	public String name, firstName, major;
	

	// Methoden

	public static Finder<Long, Student> find = new Finder (Long.class, Student.class);

	public static List<Student> all() {
		return find.all();
	}

	public static void create(Student student) {
		student.save();
	}

	public static void delete(Long studentId) {
		find.ref(studentId).delete();
	}

	
}
