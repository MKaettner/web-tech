package models;

import java.util.List;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.validation.Constraints.*;

@Entity
public class Exam extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 917063215248035769L;
	// Attribute
	@Id
	public int examId;
	
	@Required
	public String name, place, date, time, docent, major;
	@Required
	public int duration, maxParticipant, docentId;
	

	// Methoden
	
	public static Finder<Long, Exam> find = new Finder<Long, Exam> (Long.class, Exam.class);

	public static Exam find(long examId) {
		return find.ref(examId);
	}

	public static List<Exam> all() {
		return find.all();
	}

	public static void create(Exam exam) {
		exam.save();
	}

	public static void delete(long examId) {
		find.ref(examId).delete();
	}

}
