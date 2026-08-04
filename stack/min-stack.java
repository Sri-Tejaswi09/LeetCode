import java.util.*;

class MinStack {
    Stack<Long> st;
    long min;

    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        if (st.isEmpty()) {
            st.push((long)val);
            min = val;
        } else {
            if (val >= min) {
                st.push((long)val);
            } else {
                st.push(2L * val - min); // encoded
                min = val;
            }
        }
    }
    
    public void pop() {
        long top = st.pop();
        if (top < min) {
            min = 2 * min - top; // restore previous min
        }
    }
    
    public int top() {
        long top = st.peek();
        if (top < min) return (int)min;
        return (int)top;
    }
    
    public int getMin() {
        return (int)min;
    }
}