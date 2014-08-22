package io.github.furikuri.woodpecker;

import io.github.furikuri.woodpecker.cache.MethodCall;
import io.github.furikuri.woodpecker.cache.MethodCallCache;
import org.apache.log4j.Logger;
import org.aspectj.lang.reflect.MethodSignature;

import java.util.Arrays;
import java.util.List;

public aspect CacheAspect perthis(cacheMethods()) {
    private static final Logger LOG = Logger.getLogger(CacheAspect.class);

    private MethodCallCache cache = new MethodCallCache(10);

    pointcut cacheMethods() : execution(@io.github.furikuri.woodpecker.annotation.Cache * *.*(..)) ;

    Object around() : cacheMethods() {
        MethodSignature signature = (MethodSignature) thisJoinPoint.getSignature();
        List<Object> parameters = Arrays.asList(thisJoinPoint.getArgs());
        MethodCall methodCall = new MethodCall(signature, parameters);
        Object cachedResult = cache.getResultOfMethodCall(methodCall);
        if (cachedResult != null) {
            LOG.debug("Found cached result");
            return cachedResult;
        } else {
            LOG.debug("Save new object in cache");
            Object result = proceed();
            cache.addMethodCall(methodCall, result);
            return result;
        }
    }
}
