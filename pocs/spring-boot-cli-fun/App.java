@RestController
class WebApp {

    @RequestMapping("/")
    String home() {
        return "Hello World! Java + Spring Boot " + new java.util.Date();
    }

}
