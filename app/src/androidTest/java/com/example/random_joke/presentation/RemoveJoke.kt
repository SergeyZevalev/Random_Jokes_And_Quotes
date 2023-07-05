package com.example.random_joke.presentation

import android.content.Intent
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.filters.LargeTest
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.random_joke.R
import com.example.random_joke.core.RecyclerViewMatcher
import com.example.random_joke.core.lazyActivityScenarioRule
import com.example.random_joke.data.cache.BaseRealmProvider
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
@LargeTest
class RemoveJoke {

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

        onView(RecyclerViewMatcher(R.id.recyclerView).atPosition(0, R.id.commonDataTextView))
            .check(matches(withText("No cached data!")))
        onView(withText("Get Joke")).perform(click())
        onView(withText("mock text 0\nmock punchline 0")).check(matches(ViewMatchers.isDisplayed()))

        onView(withId(R.id.changeButton)).perform(click())
        onView(RecyclerViewMatcher(R.id.recyclerView).atPosition(0, R.id.commonDataTextView))
            .check(matches(withText("mock text 0\n" +
                            "mock punchline 0")))

        onView(RecyclerViewMatcher(R.id.recyclerView).atPosition(0, R.id.removeButton)).perform(click())
        onView(withText("Yes")).perform(click())
        onView(RecyclerViewMatcher(R.id.recyclerView).atPosition(0, R.id.commonDataTextView))
            .check(matches(withText("No cached data!")))
    }
}