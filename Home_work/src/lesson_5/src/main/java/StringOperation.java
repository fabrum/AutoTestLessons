public class StringOperation {


    public int CharactersNamb(String text) {
        String letters = text.replace(" ", "");
        return letters.length();
    }

    public boolean Polindrom(String text) {
        char[] textMass = text.toCharArray();
        boolean resalt = false;
        int lernMass = textMass.length - 1;
        int sizeHalf = textMass.length % 2 == 0 ? textMass.length / 2 : (textMass.length - 1) / 2;
        for (int i = 0; i < sizeHalf; i++) {
            if (textMass[i] != textMass[lernMass - i]) {
                resalt = false;
                break;
            }
            resalt = true;
        }
        return resalt;
    }

    public String ChangPlaseFerstAndLastWords(String text) {
        String[] words = text.split(" ");
        String resalt = words[words.length - 1] + " ";
        for (int i = 1; i < words.length - 1; i++) {
            resalt = resalt.concat(words[i]) + " ";
        }
        return resalt.concat(words[0]);
    }

    public boolean ContainSergOrVasy(String text) {
        boolean resalt;
        resalt = text.contains("Serg");
        if (resalt == false) {
            resalt = text.contains("Vasy");
        }
        return resalt;

    }

    public String BackwardsText(String text) {
        char[] textMass = text.toCharArray();
        String resalt = "";
        int size = textMass.length;
        for (int i = size - 1; i >= 0; i--) {
            resalt = resalt + "" + textMass[i];
        }
        return resalt;


    }
}
