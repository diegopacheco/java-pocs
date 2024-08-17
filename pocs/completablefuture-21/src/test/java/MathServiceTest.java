import org.junit.jupiter.api.Test;

public class MathServiceTest {

    @Test
    public void testSum(){
        MathService mathService = new MathService();
        mathService.sum(1,2).thenAccept(result -> {
            System.out.printf("result: %d\n", result);
            assert(result == 3);
        });
    }

    @Test
    public void testSub(){
        MathService mathService = new MathService();
        mathService.sub(1,2).thenAccept(result -> {
            System.out.printf("result: %d\n", result);
            assert(result == -1);
        });
    }

    @Test
    public void testMul(){
        MathService mathService = new MathService();
        mathService.mul(1,2).thenAccept(result -> {
            System.out.printf("result: %d\n", result);
            assert(result == null);
        });
    }

}
