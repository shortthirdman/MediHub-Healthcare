package com.shortthirdman.medihub.common.annotation;

@FunctionalInterface
public interface ApiCallable<T> {
    T call();
}
