package controllers;

import play.mvc.*;
import models.*;
import play.data.Form;

public class StudentCtrl extends Controller {

	static Form<Student> studentForm = Form.form(Student.class);

	public static Result students() {
		return ok(views.html.students.render(Student.all(), studentForm,
				Major.all()));
	}

	public static Result newStudent() {
		Form<Student> filledForm = studentForm.bindFromRequest();
		if (filledForm.hasErrors()) {
			return badRequest(views.html.students.render(Student.all(),
					filledForm, Major.all()));
		} else {
			Student.create(filledForm.get());
			return redirect(routes.StudentCtrl.students());
		}
	}

	public static Result deleteStudent(Integer studentId) {
		Student.delete(studentId);
		return redirect(routes.StudentCtrl.students());
	}

	public static Result editStudent(Integer studentId) {
		Student student = new Student().find.byId(studentId);
		Form<Student> filledForm = Form.form(Student.class).fill(student);
		return ok(views.html.studentForm.render("Bearbeite", filledForm, Major.all()));
	}

	public static Result storeStudent() {
		Form<Student> filledForm = studentForm.bindFromRequest();
		if (filledForm.hasErrors()) {
			System.out.println(filledForm);
			return badRequest(views.html.studentForm.render("Fehler beim Bearbeiten von", filledForm, Major.all()));
		} else {
			Student student = filledForm.get();
			if (student.studentId == null) {
				Student.create(student);
			} else {
				Student.edit(student);
			}
			return ok(views.html.students.render(Student.all(), studentForm, Major.all()));
		}
	}
}