package acwing;

public class MinStack {
    Element[] a;
    int tt;
    public MinStack() {
        tt = -1;
        a = new Element[100];
    }

    public void push(int x) {
        int minimum = tt < 0 ? x : Math.min(x, a[tt].second);
        Element e = new Element();
        e.first = x;
        e.second = minimum;
        tt++;
        a[tt] = e;
    }

    public void pop() {
        tt--;
    }

    public int top() {
        return a[tt].first;
    }

    public int getMin() {
        return a[tt].second;
    }
}

class Element{
    int first;
    int second;
}