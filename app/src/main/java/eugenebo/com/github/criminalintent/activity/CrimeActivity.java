package eugenebo.com.github.criminalintent.activity;

import android.support.v4.app.Fragment;

import eugenebo.com.github.criminalintent.fragments.CrimeFragment;


public class CrimeActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeFragment();
    }
}
