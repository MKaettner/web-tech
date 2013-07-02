package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity
public class Docent extends Model {

	// Attribute
	@Id
	public int docentId;
	public String name, firstName, chair;
	

	// Methoden

	public static Docent find(int docentId) {
		return null;
	}

	public static List<Docent> all() {
		return null;
	}

	public static void create(Docent docent) {
	}

	public static void delete(int docentId) {
	}

	
}