package controllers;

import play.mvc.*;
import models.Enrollment;
import play.data.Form;

public class EnrollmentCtrl extends Controller {
	
	static Form<Enrollment> enrollmentForm = Form.form(Enrollment.class);
	
	public static Result enrollments() {
		return ok(views.html.enrollments.render(Enrollment.all(), enrollmentForm));
	}
	
	public static Result newEnrollment() {
		Form<Enrollment> filledForm = enrollmentForm.bindFromRequest();
		if (filledForm.hasErrors()) {
			return badRequest(views.html.enrollments.render(Enrollment.all(), filledForm));
		} else {
			Enrollment.create(filledForm.get());
			return redirect(routes.EnrollmentCtrl.enrollments());
		}
	
	}
	
	public static Result deleteEnrollment(Integer enrollmentId) {
		Enrollment.delete(enrollmentId);
		return redirect(routes.EnrollmentCtrl.enrollments());
	}
	
}
