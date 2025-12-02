package com.example.mipt2;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;

@RunWith(AndroidJUnit4.class)
public class MainActivityUiTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testTypingTextShowsResult() {

        onView(withId(R.id.txtInputText))
                .perform(typeText("Hello world. This is a test."), closeSoftKeyboard());

        onView(withId(R.id.btnCalculate))
                .perform(click());

        onView(withId(R.id.txtResult))
                .check(matches(isDisplayed()));
    }
}
