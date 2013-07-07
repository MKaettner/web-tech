package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {
  
    public static Result index() {
        return ok(index.render("Herzlich Wilkommen zu flexLater! Fuer alle die etwas mehr Zeit haben."));
    }
  
}
