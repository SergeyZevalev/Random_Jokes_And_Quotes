package com.example.random_joke.presentation

import android.content.Intent
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.filters.LargeTest
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.random_joke.R
import com.example.random_joke.core.lazyActivityScenarioRule
import com.example.random_joke.data.cache.BaseRealmProvider
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
@LargeTest
class SaveJokeToFavorites {

    @get:Rule
    val activityTestRule = lazyActivityScenarioRule<MainActivity>(launchActivity = false)


    @Before
    fun before() {
        val realmProvider = BaseRealmProvider(ApplicationProvider.getApplicationContext(), true)

        realmProvider.provide().use {
            it.executeTransaction{
                it.deleteAll()
            }
        }

        activityTestRule.launch(
            Intent(
                ApplicationProvider.getApplicationContext(),
                MainActivity::class.java
            )
        )
    }

    @Test
    fun test(){
        onView(withText("No cached data!")).check(matches(isDisplayed()))
        onView(withText("Get Joke")).perform(click())
        onView(withText("mock text 0\nmock punchline 0")).check(matches(isDisplayed()))

        onView(withId(R.id.changeButton)).perform(click())
        onView(withId(R.id.commonDataTextView)).check(matches(withText("mock text 0\n" +
                "mock punchline 0")))
    }

}