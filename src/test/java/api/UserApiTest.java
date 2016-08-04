package api;

import com.soupsnakes.model.User;
import com.soupsnakes.Swagger2SpringBoot;
import com.soupsnakes.repositories.UserRepository;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import static io.restassured.RestAssured.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Swagger2SpringBoot.class)
@WebAppConfiguration
@IntegrationTest("server.port:8090")
public class UserApiTest {

    @Autowired
    UserRepository repository;

    User harry;
    User ron;
    User hermione;

    @Value("${local.server.port}")
    int port;

    @Before
    public void setUp(){
        harry = new User("Harry Potter");
        ron = new User("Ron Weasley");
        hermione = new User("Hermione Granger");

        repository.save(harry);
        repository.save(ron);
        repository.save(hermione);

        RestAssured.port = port;
    }

    // GET user by id
    @Test
    public void canFetchUserById() {
        String harryId = harry.getId();
        when().
                get("/users/{id}", harryId).
                then().
                statusCode(200).
                body("name", Matchers.is("Harry Potter")).
                body("id", Matchers.is(harryId));
    }

    @After
    public void cleanUp() {
        repository.delete(harry);
        repository.delete(ron);
        repository.delete(hermione);
    }

}
