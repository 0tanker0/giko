package com.example.giko.base

interface EventHandler<T> {
    fun obtainEvent(event: T)
}