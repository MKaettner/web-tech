package controllers;

import play.mvc.*;
import java.util.*;
import models.*;
import play.data.Form;

public class ExamCtrl extends Controller {

	static Form<Exam> examForm = Form.form(Exam.class);

	public static Result exams() {
		return ok(views.html.exams.render(Exam.all(), examForm));
	}

	public static Result updateExam(Integer docentId) {
		Exam exam = new Exam().find.byId(docentId);
		Form<Exam> filledForm = Form.form(Exam.class).fill(exam);
		return ok(views.html.examsForm.render("Update", filledForm,
				Docent.getAllAsMap()));
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

	public static Result storeExam() {
		Form<Exam> filledForm = examForm.bindFromRequest();
		if (filledForm.hasErrors()) {
			return ok(views.html.examsForm.render("Correct", filledForm,
					Docent.getAllAsMap()));
		} else {
			Exam exam = filledForm.get();
			List<Integer> selectedDocents = ExamsCtrl.getMultiSelectIDs(
					filledForm.data(), "docents.docentId");
			for (Integer docentId : selectedDocents) {
				Docent tmpDocent = Docent.find.byId(docentId);
				exam.docents.add(tmpDocent);
			}
			if (exam.examId == null) {
				Exam.create(exam);
			} else {
				Exam.update(exam);
			}
			return ok(views.html.exams.render(Exam.read()));
		}
	}

	public static List<Long> getMultiSelectIDs(Map<String, String> formMap,
			String multiName) {
		ArrayList<Integer> selectedIDs = new ArrayList<Integer>();
		Set<String> fieldNames = formMap.keySet();
		for (String fieldName : fieldNames) {
			if (fieldName.toLowerCase().contains(multiName.toLowerCase())) {
				Integer tmpID = Integer.parseInteger(formMap.get(fieldName));
				selectedIDs.add(tmpID);
			}
		}
		return selectedIDs;
	}

}