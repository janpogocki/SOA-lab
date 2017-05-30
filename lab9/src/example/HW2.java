package example;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

/**
 * Created by Jan on 30.05.2017.
 */
public class HW2{

    public static void main(String[] args) throws Exception {

        URL url = new URL("http://localhost:9000/HelloWorldInterface?wsdl");

        //1st argument service URI, refer to wsdl document above
        //2nd argument is service name, refer to wsdl document above
        QName qname = new QName("http://example/", "HelloWorldService");

        Service service = Service.create(url, qname);

        HelloWorldInterface hello = service.getPort(new QName("http://example/", "HelloWorldPort"), HelloWorldInterface.class);

        //System.out.println(hello.getHelloWorldAsString("mkyong"));
        hello.sayHelloWorldFrom("xd");

    }

}
