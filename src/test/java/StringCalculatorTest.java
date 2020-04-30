import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {
    StringCalc test = new StringCalc();
    @Test
    void emptyStringTest() throws Exception {
        assertEquals(0,test.add(""));
    }
    @Test
    void oneNUmber() throws Exception {
        assertEquals(199, test.add("199"));
    }
    @Test
    void twoNumberAdd() throws Exception {
        assertEquals(135,test.add("12,123"));
    }
    @Test
    void multipleNumAdd() throws Exception {
        assertEquals(138,test.add("12,123,1,1,1"));
    }
    @Test
   void addWithWhitespace() throws Exception {
        assertEquals(3, test.add("1\n,2"));
    }
    @Test
    void addDelimiterHandler() throws Exception {
        assertEquals(3, test.add("//;\n1;2"));
    }
    @Test
    void loadError(){
           assertThrows(IllegalArgumentException.class, () -> test.add("-1,-2,3,4"),"ERROR: negatives not allowed");
    }
    @Test
    void ignoreGreaterthan1000() throws Exception {
        assertEquals(3,test.add("//;\n10089;1,2"));
    }
    @Test
    void delimeterOfAnyLength() throws Exception {
        assertEquals(6,test.add("//***\n1***2***3"));
    }

    @Test
    void differentDelimeterOfAnyLength() throws Exception {
        assertEquals(6,test.add("//[:D][%]\n1:D2%3"));
    }

    @Test
    void invalidInputError(){
        assertThrows(Exception.class, () -> test.add("//;\n1000;1;2;"),"ERROR: invalid input");
    }

}
