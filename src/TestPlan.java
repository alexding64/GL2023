import java.util.Map;
import java.util.List;

public class TestPlan 
{

    private Map<String,Matrix> matrixes;
    private Test[] tests;

    public static TestPlan fromFile(String filename)
    {
        return new TestPlan();
    }
}

