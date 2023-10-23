import java.util.List;

public class Cpu extends Component {
    private int permutation_cost;
    private int rotation_cost;
    private int resolution_cost;

    public Cpu(String name, int permutation_cost, int rotation_cost, int resolution_cost) 
    {
        super(name);
        this.permutation_cost = permutation_cost;
        this.rotation_cost = rotation_cost;
        this.resolution_cost = resolution_cost;
    }

     /*
     * Class Getter and Setter
     */
    
    public int getPermutationCost() {
        return permutation_cost;
    }

    public void setPermutationCost(int permutation_cost) {
        this.permutation_cost = permutation_cost;
    }

    public int getRotationCost() {
        return rotation_cost;
    }

    public void setRotationCost(int rotation_cost) {
        this.rotation_cost = rotation_cost;
    }

    public int getResolutionCost() {
        return resolution_cost;
    }

    public void setResolutionCost(int resolution_cost) {
        this.resolution_cost = resolution_cost;
    }
    
    public Matrix[] permutation(Matrix[] m){
        return m;
    }

    public Matrix[] rotation(Matrix[] m){
        return m;
    }

    public int resolution(Matrix[] m){
        return 0;
    }
}
