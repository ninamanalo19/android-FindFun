package com.ninaestoye.findfun

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {

    // visibility test
    /*@Test
    fun testIsActivityInView() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java);
        onView(withId(R.id.main)).check(matches(isDisplayed()));
    }

    @Test
    fun testNextBtnVisibility() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java);
        onView(withId(R.id.button_next_activity)).check(matches(isDisplayed()));
        onView(withId(R.id.button_next_activity)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)));
    }

    // equality test
    @Test
    fun testIsMainActivityTitleCorrect() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java);
        onView(withId(R.id.activity_main_title)).check(matches(withText(R.string.text_mainactivity)));
    }*/

    // navigation test
    @Test
    fun testNavToSettings() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java);
        onView(withId(R.id.button_next_activity)).perform(click())
        onView(withId(R.id.secondary)).check(matches(isDisplayed()));
    }

    @Test
    fun testBackPressFromSettings() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java);
        onView(withId(R.id.button_next_activity)).perform(click())
        onView(withId(R.id.secondary)).check(matches(isDisplayed()));
        pressBack();
        onView(withId(R.id.main)).check(matches(isDisplayed()));
    }
}