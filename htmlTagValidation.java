import java.util.*;


public class htmlTagValidation{
    public static void main(String[] args){
        Boolean isValidTag = true;
        String tag = "<HTML><HEAD></HEAD></HEAD>";
        isValidTag = validTag(tag);
        System.out.println(isValidTag);
    }
    private static Boolean validTag(String tag){
        String[] spltr =  tag.replaceAll("<","").split(">");
        Boolean isValidTag = true;
        List<String> startTag = new ArrayList<>();
        List<String> endTag = new ArrayList<>();


        
        for(String str:spltr){
            if(str.startsWith("/"))
                endTag.add(str.replace("/", ""));
            else   
                startTag.add(str);
        }
        startTag.removeIf(x-> endTag.contains(x));

        if(!startTag.isEmpty())
            isValidTag =false;
        
        return isValidTag;
    }
}