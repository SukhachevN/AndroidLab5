package com.example.androidlab5;

import android.view.Gravity;

import androidx.test.espresso.contrib.DrawerActions;

import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.contrib.DrawerMatchers.isClosed;

import androidx.test.espresso.contrib.NavigationViewActions;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import task3.Activity1;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class Task2EspressoTest {
    @Rule
    public ActivityScenarioRule<Activity1> mainActivityRule = new ActivityScenarioRule<>(
            Activity1.class);

    @Test
    public void checkFirstActivity() {
        onView(withId(R.id.buttonActivity1)).check(matches(isDisplayed()));
        onView(withId(R.id.buttonActivity2)).check(doesNotExist());
        onView(withId(R.id.button2Activity2)).check(doesNotExist());
        onView(withId(R.id.buttonActivity3)).check(doesNotExist());
        onView(withId(R.id.button2Activity3)).check(doesNotExist());
        onView(withId(R.id.drawer_layout1)).check(matches(isClosed(Gravity.LEFT)));
        onView(withId(R.id.drawer_layout1)).perform(DrawerActions.open());
        onView(withId(R.id.nav_view_1)).check(matches(isDisplayed()));
        onView(withId(R.id.drawer_layout1)).perform(DrawerActions.close());
    }

    @Test
    public void checkSecondActivity() {
        onView(withId(R.id.buttonActivity1)).check(doesNotExist());
        onView(withId(R.id.buttonActivity2)).check(matches(isDisplayed()));
        onView(withId(R.id.button2Activity2)).check(matches(isDisplayed()));
        onView(withId(R.id.buttonActivity3)).check(doesNotExist());
        onView(withId(R.id.button2Activity3)).check(doesNotExist());
        onView(withId(R.id.drawer_layout2)).check(matches(isClosed(Gravity.LEFT)));
        onView(withId(R.id.drawer_layout2)).perform(DrawerActions.open());
        onView(withId(R.id.nav_view_2)).check(matches(isDisplayed()));
        onView(withId(R.id.drawer_layout2)).perform(DrawerActions.close());
    }

    @Test
    public void checkThirdActivity() {
        onView(withId(R.id.buttonActivity1)).check(doesNotExist());
        onView(withId(R.id.buttonActivity2)).check(doesNotExist());
        onView(withId(R.id.button2Activity2)).check(doesNotExist());
        onView(withId(R.id.buttonActivity3)).check(matches(isDisplayed()));
        onView(withId(R.id.button2Activity3)).check(matches(isDisplayed()));
        onView(withId(R.id.drawer_layout3)).check(matches(isClosed(Gravity.LEFT)));
        onView(withId(R.id.drawer_layout3)).perform(DrawerActions.open());
        onView(withId(R.id.nav_view_3)).check(matches(isDisplayed()));
        onView(withId(R.id.drawer_layout3)).perform(DrawerActions.close());
    }

    @Test
    public void checkActivityAbout() {
        onView(withId(R.id.buttonActivity1)).check(doesNotExist());
        onView(withId(R.id.buttonActivity2)).check(doesNotExist());
        onView(withId(R.id.button2Activity2)).check(doesNotExist());
        onView(withId(R.id.buttonActivity3)).check(doesNotExist());
        onView(withId(R.id.button2Activity3)).check(doesNotExist());
        onView(withId(R.id.drawer_layout1)).check(doesNotExist());
        onView(withId(R.id.drawer_layout2)).check(doesNotExist());
        onView(withId(R.id.drawer_layout3)).check(doesNotExist());
    }

    @Test
    public void testTransition() {
        checkFirstActivity();
        onView(withId(R.id.buttonActivity1)).perform(click());
        checkSecondActivity();
        onView(withId(R.id.buttonActivity2)).perform(click());
        checkFirstActivity();
        onView(withId(R.id.buttonActivity1)).perform(click());
        checkSecondActivity();
        onView(withId(R.id.button2Activity2)).perform(click());
        checkThirdActivity();
        onView(withId(R.id.button2Activity3)).perform(click());
        checkSecondActivity();
        onView(withId(R.id.button2Activity2)).perform(click());
        checkThirdActivity();
        onView(withId(R.id.buttonActivity3)).perform(click());
        checkFirstActivity();
    }

    @Test
    public void fromFirstToAbout() {
        checkFirstActivity();
        onView(withId(R.id.drawer_layout1)).check(matches(isClosed(Gravity.LEFT)));
        onView(withId(R.id.drawer_layout1)).perform(DrawerActions.open());
        onView(withId(R.id.nav_view_1)).perform(NavigationViewActions.navigateTo(R.id.open_about));
        checkActivityAbout();
        pressBack();
        onView(withId(R.id.drawer_layout1)).perform(DrawerActions.close());
        checkFirstActivity();
    }

    @Test
    public void fromSecondToAbout() {
        checkSecondActivity();
        onView(withId(R.id.drawer_layout2)).check(matches(isClosed(Gravity.LEFT)));
        onView(withId(R.id.drawer_layout2)).perform(DrawerActions.open());
        onView(withId(R.id.nav_view_2)).perform(NavigationViewActions.navigateTo(R.id.open_about));
        checkActivityAbout();
        pressBack();
        onView(withId(R.id.drawer_layout2)).perform(DrawerActions.close());
        checkSecondActivity();
    }

    @Test
    public void fromThirdToAbout() {
        checkThirdActivity();
        onView(withId(R.id.drawer_layout3)).check(matches(isClosed(Gravity.LEFT)));
        onView(withId(R.id.drawer_layout3)).perform(DrawerActions.open());
        onView(withId(R.id.nav_view_3)).perform(NavigationViewActions.navigateTo(R.id.open_about));
        checkActivityAbout();
        pressBack();
        onView(withId(R.id.drawer_layout3)).perform(DrawerActions.close());
        checkThirdActivity();
    }

    @Test
    public void TransitionToAbout() {
        checkFirstActivity();
        fromFirstToAbout();
        onView(withId(R.id.buttonActivity1)).perform(click());
        checkSecondActivity();
        fromSecondToAbout();
        onView(withId(R.id.button2Activity2)).perform(click());
        checkThirdActivity();
        fromThirdToAbout();
    }

    @Test
    public void backStack() {
        checkFirstActivity();
        onView(withId(R.id.buttonActivity1)).perform(click());
        checkSecondActivity();
        pressBack();
        checkFirstActivity();
        onView(withId(R.id.buttonActivity1)).perform(click());
        checkSecondActivity();
        onView(withId(R.id.button2Activity2)).perform(click());
        checkThirdActivity();
        pressBack();
        checkSecondActivity();
        pressBack();
        checkFirstActivity();
    }
}
