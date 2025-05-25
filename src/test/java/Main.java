import com.mysql.cj.jdbc.admin.MiniAdmin;
import org.junit.jupiter.api.BeforeAll;

public class Main {

    private String name;
    public Main(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }

}
