package com.example.random_joke.data.cache

class TestObjectDataBase {

    private var list = mutableListOf<TestCachedObject>()

    fun provideList(): List<TestCachedObject> {
        return list
    }

    fun findAndRemove(id: Int) {
        val found = list.find { it.objectId == id }
        list.remove(found)
    }

    fun find(id: Int): TestCachedObject? {
        return list.find { it.objectId == id }
    }

    fun add(item: TestCachedObject) {
        list.add(item)
    }
}