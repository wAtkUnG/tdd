package com.mobile.psc.temperatureconvertortdd;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith( Parameterized.class)//AndroidJUnit4
// @LargeTest
public class HelloEspressoTest {
    private final String celsius,fahrenheit;
    @Parameterized.Parameters
    public static Iterable<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {"0","32.0"},
                {"1","33.8"}

        });
    }

    public HelloEspressoTest(String celsius, String fahrenheit) {
        this.celsius = celsius;
        this.fahrenheit = fahrenheit;
    }

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void convertTemperatureFrom0CelciusShould32Fahrenheit(){
        onView(withId(R.id.editCelsius)).perform(typeText(this.celsius));
        onView(withId(R.id.editFahrenheit)).check(matches(withText(this.fahrenheit)));
    }



}
