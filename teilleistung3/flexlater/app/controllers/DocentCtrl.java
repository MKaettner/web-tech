package controllers;

import play.mvc.*;
import models.*;
import play.data.Form;

public class DocentCtrl extends Controller {

	static Form<Docent> docentForm = Form.form(Docent.class);

	public static Result docents() {
		return ok(views.html.docents.render(Docent.all(), docentForm));
	}

	public static Result updateDocent(Integer docentId) {
		Docent docent = new Docent().find.byId(docentId);
		Form<Docent> filledForm = Form.form(Docent.class).fill(docent);
		return ok(views.html.docents.render("Update", filledForm));
	}
	
	public static Result newDocent() {
		Form<Docent> filledForm = docentForm.bindFromRequest();
		if (filledForm.hasErrors()) {
			return badRequest(views.html.docents.render(Docent.all(),
					filledForm));
		} else {
			Docent.create(filledForm.get());
			return redirect(routes.DocentCtrl.docents());
		}
	}

	public static Result deleteDocent(Integer docentId) {
		Docent.delete(docentId);
		return redirect(routes.DocentCtrl.docents());
	}
	
	public static Result matchDocent() {
		Form<Docent> filledForm = docentForm.bindFromRequest();
		if (filledForm.hasErrors()) {
			return ok(views.html.docents.render("Correct", filledForm));
		} else {
			Docent docent = filledForm.get();
			if(docent.docentId == null) {
				Docent.create(docent);
			}
			else
				Docent.update(docent);
			return ok(views.html.docents.render(Docent.read()));
		}
	}

}
