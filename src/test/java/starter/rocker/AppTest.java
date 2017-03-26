package starter.rocker;

import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;

import org.jooby.test.JoobyRule;
import org.junit.ClassRule;
import org.junit.Test;

public class AppTest {

  @ClassRule
  public static JoobyRule app = new JoobyRule(new App());

  @Test
  public void shouldRenderHomePage() {
    get("/")
        .then()
        .assertThat()
        .body(equalTo("<html>\n" +
            "  <head>\n" +
            "    <title>Home</title>\n" +
            "  </head>\n" +
            "  <body>\n" +
            "    <h1>Hello Rocker!</h1>\n" +
            "\n" +
            "  </body>\n" +
            "</html>\n"))
        .statusCode(200)
        .contentType("text/html;charset=UTF-8");
  }

}
