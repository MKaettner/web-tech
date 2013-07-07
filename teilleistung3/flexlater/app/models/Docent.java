package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity
public class Docent extends Model {

		// Attribute
		@Id
		public Long docentId;
		public String name, firstName, chair;
		

		// Methoden

		public static Finder<Long, Docent> find = new Finder (Long.class, Docent.class);

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
	
}