class MyQueue {
    Stack<Integer> st;
    Stack<Integer> helper;
    public MyQueue() {
        st = new Stack<>();
        helper = new Stack<>();
    }
    public void push(int x) {
        while(!st.isEmpty()){
            helper.push(st.pop());
        }
        st.push(x);
        while(!helper.isEmpty()){
            st.push(helper.pop());
        }
    }
    
    public int pop() {
        return st.pop();
    }
    
    public int peek() {
        return st.peek();
    }
    
    public boolean empty() {
        return st.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */