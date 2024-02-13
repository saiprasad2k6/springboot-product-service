import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;


public class RandomTest {
    @Test
    void testLessThan3(){
        Random random = new Random();
        int number = random.nextInt();

        assertThat("Number is not less than max",number < 10000000);
    }
}
