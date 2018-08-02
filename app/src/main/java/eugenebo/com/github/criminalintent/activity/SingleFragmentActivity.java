package eugenebo.com.github.criminalintent.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import eugenebo.com.github.criminalintent.R;

public abstract class SingleFragmentActivity extends AppCompatActivity {

    protected abstract Fragment createFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_container);
        //во fragmentManager хранится список добавленных фрагментов
        //и через fragmentManager.findFragmentById(R.id.fragment_container);
        //он возвращает фрагмент по id контейнера

        //если фрагмента нету в списке fragmentManager и он == null,
        // он создается с нуля.

        if (fragment==null) {
            fragment=createFragment();
            fragmentManager.beginTransaction()
                    .add(R.id.fragment_container,fragment)
                    .commit();
        }
    }

}
