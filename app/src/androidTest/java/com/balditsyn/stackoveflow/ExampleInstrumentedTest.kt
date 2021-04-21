package com.balditsyn.stackoveflow

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.balditsyn.stackoveflow.R
import com.balditsyn.stackoveflow.data.repository.QuestionRepository
import kotlinx.coroutines.selects.select

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.balditsyn.stackoverflow", appContext.packageName)
    }

    @Test
    fun checkUI() {
        ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.question_list)).perform(swipeDown())
        onView(withId(R.id.question_list)).perform(click())
        onView(withId(R.id.answer_list)).check(matches(isDisplayed()))
        onView(withId(R.id.answer_list)).perform(pressBack())
        onView(withId(R.id.question_list)).check(matches(isDisplayed()))
    }
}