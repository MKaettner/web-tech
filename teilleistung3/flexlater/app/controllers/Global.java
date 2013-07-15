import java.util.List;
import java.util.Map;

import models.*;
import play.Application;
import play.GlobalSettings;
import play.libs.Yaml;

import com.avaje.ebean.Ebean; 
 
public class Global extends GlobalSettings {
 
  @Override
  public void onStart(Application app) {
    if(Ebean.find(Student.class).findRowCount() == 0) {
      Map<String,List<Object>> all = (Map<String,List<Object>>)Yaml.load("initial-data.yml");
      Ebean.save(all.get("students"));
    }
    if(Ebean.find(Docent.class).findRowCount() == 0) {
        Map<String,List<Object>> all = (Map<String,List<Object>>)Yaml.load("initial-data.yml");
        Ebean.save(all.get("docents"));
    }
    if(Ebean.find(Major.class).findRowCount() == 0) {
        Map<String,List<Object>> all = (Map<String,List<Object>>)Yaml.load("initial-data.yml");
        Ebean.save(all.get("majors"));
    }
  }
}