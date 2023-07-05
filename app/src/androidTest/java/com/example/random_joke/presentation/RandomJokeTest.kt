package com.example.random_joke.presentation

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.filters.LargeTest
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.ext.junit.rules.ActivityScenarioRule


@RunWith(AndroidJUnit4ClassRunner::class)
@LargeTest
class RandomJokeTest {

    @get:Rule
    val activityTestRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun test() {
        onView(withText("Get Joke")).perform(click())
        onView(withText("mock text 0\nmock punchline 0")).check(matches(isDisplayed()))
        onView(withText("Get Joke")).perform(click())
        onView(withText("mock text 1\nmock punchline 1")).check(matches(isDisplayed()))
    }
}