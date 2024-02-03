package leet.top_interview_150._06_stack;

import java.util.Stack;

public class _02_simplify_path {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] directories = path.split("/");

        for(String directory : directories){
            if (directory.equals(".") || directory.isEmpty()){
                continue;
            } else if(directory.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            } else{
                stack.add(directory);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(String s : stack){
            sb.append("/").append(s);
        }

        return sb.length() > 0 ? sb.toString() : "/";
    }
}
