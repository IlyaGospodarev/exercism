import java.util.regex.Pattern;

class SqueakyClean {
        static String clean(String identifier) {
            return skipNonLetters(identifier);
        }

         private static String skipNonLetters(String identifier) {
            return convertCase(identifier).replaceAll("[^A-Za-z_ΟàḃçĐḂ]", "");
        }

        private static String convertCase(String identifier) {
            return Pattern.compile("-(.)")
                    .matcher(replaceControlCharacters(identifier))
                    .replaceAll(mr -> mr.group(1)
                            .toUpperCase());
        }

        private static String replaceControlCharacters(String identifier) {
            return replaceSpaces(identifier)
                    .replaceAll("\\p{Cntrl}", "CTRL");
        } 

        private static String replaceSpaces(String identifier) {
            return identifier.replace(" ", "_");
        }  
}
