package com.example.random_joke.core.domain

import io.realm.internal.IOException

class NoConnectionException() : IOException()
class ServiceUnavailableException() : IOException()
class NoCachedDataException() : IOException()