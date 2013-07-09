package models;

import java.util.List;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.validation.Constraints.*;

@Entity
public class Docent extends Model {

	// Attribute
	@Id
	public Long docentId;
	@Required
	public String name, firstName, chair;

	// Methoden

	public static Finder<Long, Docent> find = new Finder(Long.class,
			Docent.class);

	public static List<Docent> all() {
		return find.all();
	}

	public static void create(Docent docent) {
		docent.save();
	}

	public static void delete(Long docentId) {
		find.ref(docentId).delete();
	}

}
