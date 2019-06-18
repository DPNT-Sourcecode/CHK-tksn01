package befaster.solutions.HLO;

public class HelloSolution {
    public String hello(String friendName) {
        final String nameToPrint = friendName == null ? "" : friendName;
        return String.format("Hello, %s!", nameToPrint);
    }
}

