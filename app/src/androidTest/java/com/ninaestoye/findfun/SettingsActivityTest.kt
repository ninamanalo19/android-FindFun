package com.ninaestoye.findfun

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class SettingsActivityTest {

    // This ensures that SettingsActivity is loaded
    // This is replacing: val activityScenario = ActivityScenario.launch(MainActivity::class.java);
    // on each function
    @get: Rule
    val activityRule = ActivityScenarioRule(SettingsActivity::class.java);

    @Test
    fun testIsActivityInView() {
        onView(ViewMatchers.withId(R.id.secondary))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }
}