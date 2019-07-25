//package input;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.CsvSource;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//class BarcodeInputTest {
//
//    @DisplayName("should return true for close && exit input and false for other strings")
//    @CsvSource({
//            "'tadam', 'false'",
//            "'exit', 'true'",
//            "' exit', 'true'",
//            "'exit ', 'true'",
//            "'close', 'true'",
//            "' close', 'true'",
//            "'close ', 'true'",
//            "'1kal', 'false'",
//
//    })
//    @ParameterizedTest(name = "given {0}, expected {1}")
//    void test0(String stringToVerify, boolean expectedValue) throws Exception{
//
//        assertThat(expectedValue).isEqualTo(BarcodeInput.verifyInput(stringToVerify));
//    }
//
//
//
//    @DisplayName("should return true for 9 digit input and false for shorter/longer digit input")
//    @CsvSource({
//            "'123456789', 'true'",
//            "'1', 'false'",
//            "'122', false",
//            "' 123456789', 'true'",
//            "'123456789 ', 'true'",
//            "'123456789123456789', 'false'",
//            "'123456789123', 'false'",
//
//    })
//    @ParameterizedTest(name = "given {0}, expected {1}")
//    void test1(String stringToVerify, boolean expectedValue) throws Exception{
//
//        assertThat(expectedValue).isEqualTo(BarcodeInput.verifyInput(stringToVerify));
//    }
//
//}