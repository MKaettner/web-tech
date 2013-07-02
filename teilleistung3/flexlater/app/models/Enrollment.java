package models;

import java.util.*;
import play.db.ebean.*;
import javax.persistence.*;

@Entity
public class Enrollment extends Model {

	// Attribute
	@Id
	public int enrollmentId;

	/**
	 * merged from testId and studentId
	 */

	// Methoden

	public static Enrollment find(int enrollmentId) {
		return null;
	}

	public static List<Enrollment> all() {
		return null;
	}

	public static void create(Enrollment enrollment) {
	}

	public static void delete(int enrollmentId) {
	}

}
