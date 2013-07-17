package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.validation.Constraints.*;

@Entity
public class Major extends Model {

	// Attribute
	@Id
	public Integer majorId;
	@Required
	public String name;
	@ManyToMany(cascade=CascadeType.PERSIST)
	public List<Student> students;


	// Methoden

	public static Finder<Integer, Major> find = new Finder(Integer.class,
			Major.class);

	public static List<Major> all() {
		return find.all();
	}

	public static void create(Major major) {
		major.save();
	}

	public static void delete(Integer majorId) {
		find.ref(majorId).delete();
	}
	
	public static void edit(Major updatedMajor) {
		updatedMajor.update();
	}
}