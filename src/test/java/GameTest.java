

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.rules.ExpectedException;

import javax.lang.model.type.NullType;
import java.util.PriorityQueue;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GameTest {

    private  static  Stream<Arguments> WhoWinProvider(){
        return Stream.of(
                Arguments.of("scissors","rock","Player 2 win!"),
                Arguments.of("scissors","paper","Player 1 win!"),
                Arguments.of("paper","rock","Player 1 win!"),
                Arguments.of("paper","scissors","Player 2 win!"),
                Arguments.of("rock","scissors","Player 1 win!"),
                Arguments.of("rock","paper","Player 2 win!"),
                Arguments.of("scissors","scissors","Draw!"),
                Arguments.of("rock","rock","Draw!"),
                Arguments.of("paper","paper","Draw!")
        );
    }
    private  static  Stream<Arguments> InValidProvider(){
        return Stream.of(
                Arguments.of("scissors","Software",new IllegalArgumentException()),
                Arguments.of("softwaretest","軟體測試",new IllegalArgumentException()),
                Arguments.of("333","paper",new IllegalArgumentException())

        );
    }
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @ParameterizedTest
    @MethodSource("WhoWinProvider")
    void WhoWinTest(String Player1,String Player2,Object expected){
            assertEquals(expected,new Game().WhoWin(Player1,Player2));
    }
    @ParameterizedTest
    @MethodSource("InValidProvider")
    public void WhoWinExceptionTest(String str1,String str2,Exception obj){
        Exception exception1 = assertThrows(obj.getClass(),()->{
            new Game().WhoWin(str1,str2);
        });
    }
}
