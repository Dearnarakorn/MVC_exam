package Model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Model {

    public String CalculateQ4(String in){
        in = in.replaceAll("\\n", " ");
        String output ="";
            output = processq4(in,output);      
        return output;
    }

    public String CalculateQ5(String in){
        String[] lines = in.split("\n");
        String output ="";
        for (String line : lines) {
            output = processq5(line,output);
        }

        return output;
    }

    private String processq4(String input, String output) {
        Pattern pattern = Pattern.compile("<([A-Z/]+)>(.*?)</\\1>|([^<]+)");
        Matcher matcher = pattern.matcher(input);
        
        String currentTag = null;
        StringBuilder content = new StringBuilder();
        
        while (matcher.find()) {
            if (matcher.group(1) != null) {
                if (currentTag != null) {
                    if (!currentTag.endsWith("/")) {
                        output += "[TAG= \"" + currentTag + "\"]{" + content.toString() + "}\n";
                    }
                }
                currentTag = matcher.group(1);
                content.setLength(0);
                content.append(matcher.group(2));
            } else {
                content.append(matcher.group(3));
            }
        }
        
        if (currentTag != null && !currentTag.endsWith("/")) {
            output += "[TAG= \"" + currentTag + "\"]{" + content.toString() + "}\n";
        } else {
            output += "[UNTAGGED]{" + content.toString() + "}\n";
        }
        return output;
    }
    
    private String processq5(String line,String output) {
        Pattern pattern = Pattern.compile("<([A-Z/]+)>(.*?)</\\1>|([^<]+)");
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            if (matcher.group(1) != null) {
                output += ("[TAG= \"" + matcher.group(1) + "\"]{" + matcher.group(2) + "}\n");
            } else {
                output += ("[UNTAGGED]{" + matcher.group(3) + "}\n");
            }
        }
        return output;
    }
}

