package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity
public class Student extends Model {

	// Attribute
	@Id
	public int studentId;
	public String name, firstName, major;
	

	// Methoden

	public static Student find(int studentId) {
		return null;
	}

	public static List<Student> all() {
		return null;
	}

	public static void create(Student student) {
	}

	public static void delete(int studentId) {
	}

	
}
