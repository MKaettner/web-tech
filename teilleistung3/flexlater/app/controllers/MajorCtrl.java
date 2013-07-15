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
}