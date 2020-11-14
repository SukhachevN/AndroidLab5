package com.example.androidlab5;
import android.content.pm.ActivityInfo;
import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Rule
    public ActivityScenarioRule<MainActivity> mainActivityRule = new ActivityScenarioRule<>(
            MainActivity.class);
    @Test
    public void testButton() {
        onView(withId(R.id.button)).check(matches(withText("Клик")));
        onView(withId(R.id.edit_text)).perform(typeText("super Text"));
        onView(withId(R.id.edit_text)).check(matches(withText("super Text")));
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.button)).check(matches(withText("Кнопка нажата")));
        mainActivityRule.getScenario().onActivity(new ActivityScenario.ActivityAction<MainActivity>() {
            @Override
            public void perform(MainActivity activity) {
                activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE);
            }
        });
        onView(withId(R.id.button)).check(matches(withText("Клик")));
        onView(withId(R.id.edit_text)).check(matches(withText("super Text")));
    }
}