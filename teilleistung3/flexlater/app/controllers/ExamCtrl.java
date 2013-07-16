package controllers;

import play.mvc.*;
import java.util.*;
import models.*;
import play.data.Form;

public class ExamCtrl extends Controller {

	static Form<Exam> examForm = Form.form(Exam.class);

	public static Result exams() {
		return ok(views.html.exams.render(Exam.all(), examForm, Docent.all(), Major.all()));
	}

	public static Result newExam() {
		Form<Exam> filledForm = examForm.bindFromRequest();
		if ((filledForm.field("name").value()).length()<5) {
			return badRequest(views.html.exams.render(Exam.all(), filledForm, Docent.all(), Major.all()));
		} else if (filledForm.hasErrors()) {
			return badRequest(views.html.exams.render(Exam.all(), filledForm, Docent.all(), Major.all()));
		} else {
			Exam.create(filledForm.get());
			return redirect(routes.ExamCtrl.exams());
		}
	}


	public static Result deleteExam(Integer examId) {
		Exam.delete(examId);
		return redirect(routes.ExamCtrl.exams());
	}
}