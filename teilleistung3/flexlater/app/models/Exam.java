package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.validation.Constraints.*;

@Entity
public class Exam extends Model {

		
	// Attribute
	@Id
	public Integer examId;
	
	@Required
	public String name, place, date, time;
	@Required
	public Integer duration, maxParticipant, docentId, majorId;
	@OneToMany(mappedBy="exam",cascade=CascadeType.ALL)
	public List<Enrollment> enrollments;
//	@ManyToOne
//	@Required
//	public Docent docent;
	// Methoden
	
	public static Finder<Integer, Exam> find = new Finder<Integer, Exam> (Integer.class, Exam.class);
	
	public static List<Exam> all() {
		return find.all();
	}

	public static void create(Exam exam) {
		exam.save();
	}

	public static void delete(Integer examId) {
		find.ref(examId).delete();
	}

}
