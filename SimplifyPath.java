import java.util.LinkedList;
import java.util.List;


public class SimplifyPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimplifyPath ins = new SimplifyPath();
		System.out.println(ins.simplifyPath("/home/"));
		System.out.println(ins.simplifyPath("/a/./b/../../c/"));
		System.out.println(ins.simplifyPath("/../"));
		System.out.println(ins.simplifyPath("/home//foo/"));
	}

    public String simplifyPath(String path) {
        String[] tokens = path.split("/");
        
        List<String> stack  = new LinkedList<String>();
        for (String token : tokens) {
        	String str = token.trim();
        	if (!"".equals(str) && !".".equals(str)) {
        		if ("..".equals(str)) {
        			if (stack.size() == 0) {
        				continue;
        			}
        			stack.remove(stack.size() - 1);
        		} else {
        			stack.add(stack.size(), str);
        		}
        	}
        }
        
        String result = "";
        if (stack.size() == 0) {
        	return "/";
        }
        for (String str : stack) {
        	result += "/"+str;
        }
        return result;
    }
}
