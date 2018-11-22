package com.artur.collections;

import java.util.LinkedList;

public class Stack<T> {
    private LinkedList<T> storage = new LinkedList<T>();

    public void push(T t) {
        storage.addFirst(t);
    }

    public T peek() {
        return storage.getFirst();
    }

    public T pop() {
        return storage.removeFirst();
    }

    public boolean empty() {
        return storage.isEmpty();
    }

    public String toString() {
        return storage.toString();
    }
}

class StackTest {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        for(String s : "Мама мыла раму".split(" ")){
            stack.push(s);
        }

        while (!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}

