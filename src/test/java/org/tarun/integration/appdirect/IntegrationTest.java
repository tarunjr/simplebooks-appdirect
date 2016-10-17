package org.simplebooks.integration.appdirect;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTest {

  @LocalServerPort
  private int port;

  @Autowired
  private TestRestTemplate template;

  private final String CREATE_EVENT_RESOURCE = "/subscription/create/notification?url=http%3A%2F%2Flocalhost%3A8080%2Ftest%2Fsubscription%2Fcreate%2Fevent";

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void testUnAuthorized() throws Exception {
      URL createUrl = new URL("http://localhost:" + port  +  CREATE_EVENT_RESOURCE);
      ResponseEntity<String> response = template.getForEntity(createUrl.toString(),String.class);
      assertThat(response.getStatusCode()).isEqualTo(HttpStatus.UNAUTHORIZED);
  }

  public void testCreate() throws Exception {
      String createUrl = "http://localhost:" + port  +  CREATE_EVENT_RESOURCE;

      HttpHeaders headers = new HttpHeaders();
      headers.set("authorization", "oauth string");
      HttpEntity<String> entity = new HttpEntity<String>(headers);
      ResponseEntity<String> response = template.exchange(createUrl, HttpMethod.GET, entity, String.class);

      assertThat(response.getStatusCode()).isEqualTo(HttpStatus.UNAUTHORIZED);
  }
}
