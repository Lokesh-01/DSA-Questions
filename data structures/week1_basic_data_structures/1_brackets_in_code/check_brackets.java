import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

class Bracket {
    Bracket(char type, int position) {
        this.type = type;
        this.position = position;
    }

    boolean Match(char c) {
        if (this.type == '[' && c == ']')
            return true;
        if (this.type == '{' && c == '}')
            return true;
        if (this.type == '(' && c == ')')
            return true;
        return false;
    }

    char type;
    int position;
}

class check_brackets {
    public static void main(String[] args) throws IOException {
        InputStreamReader input_stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input_stream);
        String text = reader.readLine();
        Stack<Bracket> s = new Stack<Bracket>();
        for (int position = 0; position < text.length(); ++position) {
            char next = text.charAt(position);

            if (next == '(' || next == '[' || next == '{') {
                // Process opening bracket, write your code
            	s.push(new Bracket(next,position));
            }

            if (next == ')' || next == ']' || next == '}') {
                if(s.isEmpty()){
                    System.out.println(position+1);
                    return;
                }else{
                    Bracket b=s.pop();
                    if(!b.Match(next)){
                        System.out.println(position+1);
                        return;
                    }
                }
            }
        }
        // Printing answer, write your code here
        if(s.empty()){
            System.out.println("Success");
        }else{
            System.out.println(s.pop().position+1);
        }
    }
}
