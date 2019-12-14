package mn.chinoyunsoft.cc.clean;

import mn.chinoyunsoft.cc.clean.model.CleanCoder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = CleanApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT) public class CleanCoderControllerIntegrationTest {
    @LocalServerPort private int port;

    @Autowired private TestRestTemplate restTemplate;

    //    @Sql({ "schema.sql", "data.sql" })
    //    @Test
    //    @Ignore
    //    public void testAllCleanCoders()
    //    {
    //        assertTrue(
    //                this.restTemplate
    //                        .getForObject("http://localhost:" + port + "/cleancoders", CleanCoders.class)
    //                        .getCleanCoderList().size() == 3);
    //    }

    @Test public void testAddCleanCoder() {
        CleanCoder cleanCoder = new CleanCoder("Lokesh", true);
        ResponseEntity<String> responseEntity = this.restTemplate.postForEntity("http://localhost:" + port + "/cleancoders", cleanCoder, String.class);
        assertEquals(201, responseEntity.getStatusCodeValue());
    }
}