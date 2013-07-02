package models;

import java.util.List;
import javax.persistence.*;
import play.db.ebean.Model;

@Entity
public class Exam extends Model {

	// Attribute
	@Id
	public int examId;
	public String name, place, date, time, docent, major;
	public int duration, maxParticipant, docentId;
	

	// Methoden

	public static Exam find(int examId) {
		return null;
	}

	public static List<Exam> all() {
		return null;
	}

	public static void create(Exam exam) {
	}

	public static void delete(int examId) {
	}

}
