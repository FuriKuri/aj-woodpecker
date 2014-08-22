package io.github.furikuri.woodpecker.cache;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MethodCallCache {
    private Map<MethodCall, Object> methodsCalls = new ConcurrentHashMap<>();
    private Queue<MethodCall> queue = new ConcurrentLinkedQueue<>();

    private int size;

    public MethodCallCache(int size) {
        this.size = size;
    }

    public void addMethodCall(MethodCall methodCall, Object object) {
        methodsCalls.put(methodCall, object);
        queue.add(methodCall);

        while (queue.size() > size) {
            MethodCall keyToRemove = queue.poll();
            methodsCalls.remove(keyToRemove);
        }
    }

    public Object getResultOfMethodCall(MethodCall methodCall) {
        return methodsCalls.get(methodCall);
    }
}
