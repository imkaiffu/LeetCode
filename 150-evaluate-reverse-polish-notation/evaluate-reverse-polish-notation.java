class Solution {
    public int evalRPN(String[] tokens) {
       Stack<Integer> st = new Stack<>();
        for(String s : tokens){
            if(s.equals("+") || s.equals("-") ||  s.equals("*") || s.equals("/")){
                int b = st.pop();
                int a = st.pop();
                switch(s){
                    case "+" : st.push(a + b);
                    break;
                    case "*" : st.push(a * b);
                    break;
                    case "/" : st.push(a / b);
                    break;
                    case "-" : st.push(a - b);
                }
            }else{
                int num = Integer.parseInt(s);
                st.push(num);
            }
        }
        return st.peek();
    }
}