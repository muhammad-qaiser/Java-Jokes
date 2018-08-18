package com.udacity.gradle.builditbigger;

import android.support.test.espresso.IdlingRegistry;
import android.support.test.espresso.IdlingResource;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.udacity.gradle.builditbigger.utils.AppConstants.DEFAULT_EXCEPTION;
import static org.hamcrest.Matchers.not;

@RunWith(AndroidJUnit4.class)
public class JokeTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule
            = new ActivityTestRule<>(MainActivity.class);


    IdlingResource mIdle;
    @Before
    public void registerIdelRes()
    {
        mIdle = mActivityTestRule.getActivity().getIdlingResource();
        IdlingRegistry.getInstance().register(mIdle);
    }

    @Test
    public void jokeTest()
    {
        onView(withId(R.id.btnTellJoke)).
                check(matches(isDisplayed()));
        onView(withId(R.id.btnTellJoke)).
                perform(click());
        onView(withId(R.id.tvJoke)).
                check(matches(isDisplayed()));
        onView(withId(R.id.tvJoke)).
                check(matches(not(withText(DEFAULT_EXCEPTION))));


    }

    @After
    public void unRegister()
    {
        IdlingRegistry.getInstance().unregister(mIdle);
    }


}