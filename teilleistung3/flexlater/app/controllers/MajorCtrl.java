package controllers;

import play.mvc.*;
import models.*;
import play.data.Form;

public class MajorCtrl extends Controller {

	static Form<Major> majorForm = Form.form(Major.class);

	public static Result majors() {
		return ok(views.html.majors.render(Major.all(), majorForm));
	}
	
	public static Result newMajor() {
		Form<Major> filledForm = majorForm.bindFromRequest();
		if (filledForm.hasErrors()) {
			return badRequest(views.html.majors.render(Major.all(),
					filledForm));
		} else {
			Major.create(filledForm.get());
			return redirect(routes.MajorCtrl.majors());
		}
	}

	public static Result deleteMajor(Integer majorId) {
		Major.delete(majorId);
		return redirect(routes.MajorCtrl.majors());
	}
	public static Result editMajor(Integer majorId) {
		Major major = new Major().find.byId(majorId);
		Form<Major> filledForm = Form.form(Major.class).fill(major);
		return ok(views.html.majorForm.render("Bearbeite", filledForm));
	}

	public static Result storeMajor() {
		Form<Major> filledForm = majorForm.bindFromRequest();
		if (filledForm.hasErrors()) {
			System.out.println(filledForm);
			return badRequest(views.html.majorForm.render("Fehler beim Bearbeiten von", filledForm));
		} else {
			Major major = filledForm.get();
			if (major.majorId == null) {
				Major.create(major);
			} else {
				Major.edit(major);
			}
			return ok(views.html.majors.render(Major.all(), majorForm));
		}
	}
}