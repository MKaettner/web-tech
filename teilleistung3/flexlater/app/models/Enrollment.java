package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.validation.Constraints.*;

@Entity
public class Enrollment extends Model {

	// Attribute
	@Id
	public Integer enrollmentId;
	@ManyToOne
	@Required
	public Student student;
	@ManyToOne
	@Required
	public Exam exam;
	// Methoden

	public static Finder<Integer, Enrollment> find = new Finder<Integer, Enrollment> (Integer.class, Enrollment.class);
	
	public static Enrollment find(Integer enrollmentId) {
		return find.ref(enrollmentId);
	}

	public static List<Enrollment> all() {
		return find.all();
	}

	public static void create(Enrollment enrollment) {
		enrollment.save();
	}

	public static void delete(Integer enrollmentId) {
		find.ref(enrollmentId).delete();
	}

}