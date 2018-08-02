package eugenebo.com.github.criminalintent.activity;

import android.support.v4.app.Fragment;

import eugenebo.com.github.criminalintent.fragments.CrimeListFragment;

public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
