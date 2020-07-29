package com.jason.movietvcatalog.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.jason.movietvcatalog.R
import com.jason.movietvcatalog.utils.DataDummy
import org.junit.Rule
import org.junit.Test

class HomeActivityTest {

    private val dummyMovie = DataDummy.generateDummyMovie()
    private val dummyTvshow = DataDummy.generateDummyTVShow()
    private val dummyActor = DataDummy.generateActorMovie(dummyMovie[0].id.toString())

    @get:Rule
    var activityRule = ActivityTestRule(HomeActivity::class.java)

    @Test
    fun loadMovie() {
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyMovie.size
            )
        )
    }

    @Test
    fun loadTvshow() {
        onView(withText(R.string.tvshow)).perform(click())
        onView(withId(R.id.rv_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshow)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyTvshow.size
            )
        )
    }

    @Test
    fun loadDetailMovie() {
        onView(withId(R.id.rv_movies)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.genre)).check(matches(isDisplayed()))
        onView(withId(R.id.genre)).check(matches(withText(dummyMovie[0].genre)))
        onView(withId(R.id.release_year)).check(matches(isDisplayed()))
        onView(withId(R.id.release_year)).check(matches(withText(dummyMovie[0].yearRelease)))
        onView(withId(R.id.duration)).check(matches(isDisplayed()))
        onView(withId(R.id.duration)).check(matches(withText(dummyMovie[0].duration)))
        onView(withId(R.id.director)).check(matches(isDisplayed()))
        onView(withId(R.id.director)).check(matches(withText(dummyMovie[0].director)))
        onView(withId(R.id.sinopsis)).check(matches(isDisplayed()))
        onView(withId(R.id.sinopsis)).check(matches(withText(dummyMovie[0].description)))
    }

    @Test
    fun loadActor() {
        onView(withId(R.id.rv_movies)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(android.R.id.content)).perform(ViewActions.swipeUp())
        onView(withId(R.id.rv_actor)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_actor)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyActor.size
            )
        )
    }
}