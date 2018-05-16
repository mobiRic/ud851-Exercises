package android.example.com.visualizerpreferences;

import android.os.Bundle;
import android.support.v7.preference.PreferenceFragmentCompat;

// TODO (2) Create a class called SettingsFragment that extends PreferenceFragmentCompat
public class SettingsFragment extends PreferenceFragmentCompat {

    // TODO (3) In res->xml create a file called pref_visualizer
    // TODO (4) In pref_visualizer create a preference screen containing a single check box preference
    // This check box preference should have a default value of true, the key 'show_bass', a
    // summaryOff of Hidden, a summaryOn of Shown and a title of 'Show Bass'

    // TODO (5) In SettingsFragment's onCreatePreferences method add the preference file using the
    // addPreferencesFromResource method
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.pref_visualizer);
    }
}
