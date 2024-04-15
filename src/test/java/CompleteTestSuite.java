import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ChatHistoryUnitTest.class, ChatServerUnitTest.class, CompleteTestSuite.class, SearchByUserUnitTest.class,
TestMessage.class, UserUnitTest.class})
public class CompleteTestSuite {
}
