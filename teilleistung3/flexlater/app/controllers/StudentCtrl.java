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
		return TODO;
	}
	
	public static Result deleteStudent(int id) {
		return TODO;
	}
	
}
