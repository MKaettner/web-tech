package controllers;

import play.mvc.*;
import models.Student;
import play.data.Form;

public class StudentCtrl extends Controller {

	static Form<Student> studentForm = Form.form(Student.class);

	
	public static Result students() {
		return ok(views.html.students.render(Student.all(), studentForm));
	}
	
	public static Result newStudent() {
		Form<Student> filledForm = studentForm.bindFromRequest();
		if (filledForm.hasErrors()) {
			return badRequest(views.html.students.render(Student.all(), filledForm));
		} else {
			Student.create(filledForm.get());
			return redirect(routes.StudentCtrl.students());
		}
	}
	
	public static Result deleteStudent(Long studentId) {
		Student.delete(studentId);
		return redirect(routes.StudentCtrl.students());
	}
	
}
