import java.util.Map;
import java.util.List;

public class TestPlan 
{
	
    public Map<String,Matrix> matrixes;
    public Test[] tests;

    public static TestPlan from_file(String filename)
    {
        return new TestPlan();
    }
}

