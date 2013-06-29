package models;

import java.util.*;

import play.data.validation.Constraints.*;

import play.db.ebean.*;
import javax.persistence.*;

@Entity
public class Enrollment extends Model {

	@Id
	public int enrollmentId;
	/**
	 * merged from testId and studentId
	 */

	// public static Finder<Long, Enrollment> find = new Finder(Long.class,
	// Enrollment.class);
	//
	// public static List<Enrollment> all() {
	// return Enrollment.all();
	// }
	//
	// public static void create(Enrollment enrollment) {
	// enrollment.save();
	// }
	// public static void delete(int enrollmentId) {
	//
	// }
	//

}
