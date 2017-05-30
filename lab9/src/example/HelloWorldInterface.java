package example;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
 * Created by Jan on 25.05.2017.
 */
@WebService()
public interface HelloWorldInterface {
  @WebMethod
  public String sayHelloWorldFrom(String from);
}
