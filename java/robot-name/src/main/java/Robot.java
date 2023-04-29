import java.util.*;

public class Robot {
    private static final Set<String> USED_NAMES = new HashSet<>();
    
    private String name;
    
    public Robot() {
        reset();
    }
    
    public String getName() {
        return name;
    }
    
    public void reset() {
        String newName;
        do {
            newName = generateName();
        } while (USED_NAMES.contains(newName));
        USED_NAMES.add(newName);
        name = newName;
    }
    
    private String generateName() {
        Random random = new Random();

        String generateLetters = random.ints(65, 91)
                .limit(2)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        String generateDigits = random.ints(48, 58)
                .limit(3)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generateLetters + generateDigits;
    }
}
