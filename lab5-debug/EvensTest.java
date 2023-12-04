import static org.junit.Assert.*;
import org.junit.*;

public class EvensTest {
    @Test 
	public void testSumEvenIndices1() {
    int[] input1 = {2, 6, 3};
    int output1 = EvensExamples.sumEvenIndices(input1);
    int expect1 = 5;
    assertEquals(expect1, output1);
	}

    @Test 
	public void testSumEvenIndices2() {
    int[] input2 = {1};
    int output2 = EvensExamples.sumEvenIndices(input2);
    int expect2 = 1;
    assertEquals(expect2, output2);
	}

    @Test 
	public void testSumEvenIndices3() {
    int[] input3 = {};
    int output3 = EvensExamples.sumEvenIndices(input3);
    int expect3 = 0;
    assertEquals(expect3, output3);
	}
}
