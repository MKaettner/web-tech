package controllers;

import play.mvc.*;
import models.Exam;
import play.data.Form;


public class ExamCtrl extends Controller{

	static Form<Exam> examForm = Form.form(Exam.class);
	
	public static Result exams() {
		return ok(views.html.exams.render(Exam.all(), examForm));
	}
	
	public static Result newExam() {
		Form<Exam> filledForm = examForm.bindFromRequest();
		if (filledForm.hasErrors()) {
			return badRequest(views.html.exams.render(Exam.all(), filledForm));
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
