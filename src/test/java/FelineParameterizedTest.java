import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

@RunWith(Parameterized.class)
public class FelineParameterizedTest {
    Feline feline = new Feline();
    Feline felineSpy  = Mockito.spy(feline);

    private final int kittensCount;
    private final int expectedKittensCount;

    public FelineParameterizedTest(int kittensCount, int expectedKittensCount) {
        this.kittensCount = kittensCount;
        this.expectedKittensCount = expectedKittensCount;
    }

    @Parameterized.Parameters //
    public static Object[][] getKittensCount() {
        return new Object[][] {
                { 0, 0 },
                { 1, 1 },
                { 2, 2 },
        };
    }
    @Test
    public void getKittensWithParametersTest() {
        felineSpy.getKittens(kittensCount);
        Assert.assertEquals(expectedKittensCount, felineSpy.getKittens(kittensCount));
    }

}
