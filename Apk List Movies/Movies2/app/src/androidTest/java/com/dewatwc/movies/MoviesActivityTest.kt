@file:Suppress("DEPRECATION")
package com.dewatwc.movies

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import com.dewatwc.movies.ui.home.MoviesActivity
import com.dewatwc.movies.utils.DataDummy
import com.dewatwc.movies.utils.EspressoIdlingResource
import org.junit.Before
import org.junit.After


@Suppress("DEPRECATION")
class MoviesActivityTest {

    private val dummyMovies = DataDummy.generateDummyMovies()

    @get:Rule
    var activityRule = ActivityTestRule(MoviesActivity::class.java)

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }

    @Test
    fun loadMovies() {
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovies.size))
    }

    @Test
    fun loadDetailMovies() {
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.text_title)).check(matches(isDisplayed()))
        onView(withId(R.id.text_title)).check(matches(withText(dummyMovies[0].title)))
        onView(withId(R.id.text_date)).check(matches(isDisplayed()))
        onView(withId(R.id.text_date)).check(matches(withText("Broadcast ${dummyMovies[0].broadcast}")))
    }

    @Test
    fun loadFavorite() {
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.action_tvshow)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())
        onView(withText("FAVORITE")).perform(click())
        onView(withId(R.id.rv_favorite)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_favorite)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.text_title)).check(matches(isDisplayed()))
        onView(withId(R.id.text_title)).check(matches(withText(dummyMovies[0].title)))
        onView(withId(R.id.text_date)).check(matches(isDisplayed()))
        onView(withId(R.id.text_date)).check(matches(withText("Broadcast ${dummyMovies[0].broadcast}")))
        onView(withId(R.id.action_tvshow)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())
    }
}