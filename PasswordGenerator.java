public class PasswordGenerator {
    public static String generatePassword(int length) {
        String[] randLett = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        char[] randSym = {',','.','/',';','\'','[',']','\\','-','=','`','<','>','?',':','\"','{','}','|', '_','+','~', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')'};

        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int randNum = Randomizer.generate(1, 4);
            if (randNum == 1) {
                password.append(Randomizer.generate(0, 9));
            } else if (randNum == 2) {
                password.append(randLett[Randomizer.generate(0, randLett.length - 1)].toLowerCase());
            } else if (randNum == 3) {
                password.append(randLett[Randomizer.generate(0, randLett.length - 1)].toUpperCase());
            } else {
                password.append(randSym[Randomizer.generate(0, randSym.length - 1)]);
            }
        }
        return password.toString();
    }
}