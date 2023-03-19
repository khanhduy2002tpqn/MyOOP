public class App {
    public static void main(String[] args) throws Exception {
        //câu 2
        String str="  Khoa    CNTT    CDN    Da    Nang  ";
        System.out.println(str.replaceAll("\\s\\s+", " ").trim());
         //câu 3
        String str1="an toan thong tin, an toan giao thong";
        System.out.println(str1.replaceAll("an ", "An "));
        //câu 4
        System.out.println(countWords(str1));
        //cau 5
        System.out.println(capitalizeString(str1));
        //câu 6
        System.out.println(str1.indexOf("thong"));
        //câu 7
        StringBuilder str2 = new StringBuilder(str1);
        System.out.println(str2.reverse().toString());
    }
    //câu 4
    public static int countWords(String str) {
        if (str == null) {
            return -1;
        }
        int count = 0;
        int size = str.length();
        boolean check = true;
        for (int i = 0; i < size; i++) {
            if (str.charAt(i) != ' ' && str.charAt(i) != '\t' 
                    && str.charAt(i) != '\n') {
                if(check) {
                    count++;
                    check = false;
                }
            } else {
                check = true;
            }
        }
        return count;
    }
    //câu 5
    public static String capitalizeString(String str) {
        char[] chars = str.toLowerCase().toCharArray();
        boolean found = false;
        for (int i = 0; i < chars.length; i++) {
          if (!found && Character.isLetter(chars[i])) {
            chars[i] = Character.toUpperCase(chars[i]);
            found = true;
          } else if (Character.isWhitespace(chars[i]) || chars[i]=='.' || chars[i]=='\'') {
            found = false;
          }
        }
        return String.valueOf(chars);
      }
}
