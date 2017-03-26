package starter.rocker;

import org.jooby.Jooby;
import org.jooby.rocker.Rockerby;

public class App extends Jooby {

  {
    /** Install Rocker: */
    use(new Rockerby());

    /** Renderer a Rocker template: */
    get("/", req -> {
      String name = req.param("name").value("Rocker");
      return views.index.template(name);
    });
  }

  public static void main(final String[] args) {
    run(App::new, args);
  }

}
