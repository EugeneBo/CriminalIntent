package eugenebo.com.github.criminalintent.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import eugenebo.com.github.criminalintent.R;
import eugenebo.com.github.criminalintent.model.Crime;
import eugenebo.com.github.criminalintent.model.CrimeLab;

public class CrimeListFragment extends Fragment {

    private RecyclerView crimeRecycleView;
    private CrimeAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_crime_list, container, false);
        crimeRecycleView = view.findViewById(R.id.crime_recycler_view);
        crimeRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return view;
    }

    private void updateUI() {
        CrimeLab crimeLab = CrimeLab.get(getActivity());
        List<Crime> crimes = crimeLab.getCrimes();
        adapter = new CrimeAdapter(crimes);
        crimeRecycleView.setAdapter(adapter);
    }



    //////////////////////////////////////////////////////////////////////////////////////////////////////////



    private class CrimeHolder extends RecyclerView.ViewHolder {

        private TextView titleTextView;
        private TextView dateTextView;

        private Crime crime;

        public CrimeHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_crime, parent, false));
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity(),crime.getCrimeTitle() + " clicked!", Toast.LENGTH_SHORT).show();
                }
            });
            titleTextView = itemView.findViewById(R.id.crime_title);
            dateTextView = itemView.findViewById(R.id.crime_data);
        }

        public void bind(Crime crime) {
            this.crime = crime;
            titleTextView.setText(crime.getCrimeTitle());
            dateTextView.setText(crime.getCrimeDate().toString());
        }

    }



    //////////////////////////////////////////////////////////////////////////////////////////////////////////



    private class CrimeAdapter extends RecyclerView.Adapter<CrimeHolder> {

        private List<Crime> crimes;

        public CrimeAdapter(List<Crime> crimes) {
            this.crimes = crimes;
        }

        @NonNull
        @Override
        public CrimeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new CrimeHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(@NonNull CrimeHolder holder, int position) {

            Crime crime = crimes.get(position);
            holder.bind(crime);
        }

        @Override
        public int getItemCount() {
            return crimes.size();
        }
    }


}
