package controllers;

import play.mvc.*;
import models.Docent;
import play.data.Form;

public class DocentCtrl extends Controller {

	static Form<Docent> docentForm = Form.form(Docent.class);

	public static Result docents() {
		return ok(views.html.docents.render(Docent.all(), docentForm));
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

	public static Result deleteDocent(Long docentId) {
		Docent.delete(docentId);
		return redirect(routes.DocentCtrl.docents());
	}

}
