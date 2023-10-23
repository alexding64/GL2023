import java.util.Map;
import java.util.List;

public class TestPlan {
    public Map<String,Matrix> matrixes;
    public Test[] tests;

    public static TestPlan from_file(String filename){
        return new TestPlan();
    }
}
// A revoir
/*public class TestPlan {
private Map<String, Matrix> matrixes;
private Test[] tests;

public TestPlan(Map<String, Matrix> matrixes, Test[] tests) {
    this.matrixes = matrixes;
    this.tests = tests;
}

public static TestPlan from_file(String filename) {
    // Logique pour charger un plan de test depuis un fichier (non implémentée ici)
    // Vous devrez implémenter cette méthode pour charger les données du fichier.
    Map<String, Matrix> loadedMatrixes = loadMatrixesFromFileName(filename);
    Test[] loadedTests = loadTestsFromFileName(filename);

    // Crée un nouvel objet TestPlan avec les données chargées
    return new TestPlan(loadedMatrixes, loadedTests);
}

public Map<String, Matrix> getMatrixes() {
    return matrixes;
}

public void setMatrixes(Map<String, Matrix> matrixes) {
    this.matrixes = matrixes;
}

public Test[] getTests() {
    return tests;
}

public void setTests(Test[] tests) {
    this.tests = tests;
}
}*/