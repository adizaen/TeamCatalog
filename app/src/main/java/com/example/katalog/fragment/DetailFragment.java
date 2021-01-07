package com.example.katalog.fragment;

import android.app.ActionBar;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.bumptech.glide.Glide;
import com.example.katalog.R;
import com.example.katalog.db.DbHelper;

public class DetailFragment extends Fragment implements View.OnClickListener {

    DbHelper dbHelper;
    public static String ID = "id";
    public static String IMAGE = "image";
    public static String NAME = "name";
    public static String YEAR = "year";
    public static String DESCRIPTION = "description";

    ImageView ivTeam;
    TextView tvDetailBadge, tvDetailName, tvDetailYear, tvDetailDescription;
    Button btnFavorite;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        btnFavorite = view.findViewById(R.id.btn_favorite);
        btnFavorite.setOnClickListener(this);
        dbHelper = new DbHelper(getActivity().getApplicationContext());
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ivTeam = view.findViewById(R.id.iv_team);
        tvDetailBadge = view.findViewById(R.id.tv_detail_badge);
        tvDetailName = view.findViewById(R.id.tv_detail_name);
        tvDetailYear = view.findViewById(R.id.tv_detail_year);
        tvDetailDescription = view.findViewById(R.id.tv_full_detail_description);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Bundle bundle = getArguments();

        if (bundle != null){
            String url = bundle.getString(IMAGE);
            String badge = bundle.getString(IMAGE);
            String name = bundle.getString(NAME);
            String year = bundle.getString(YEAR);
            String description = bundle.getString(DESCRIPTION);

            Glide.with(this)
                    .load(url)
                    .into(ivTeam);
            tvDetailBadge.setText(badge);
            tvDetailName.setText(name);
            tvDetailYear.setText(year);
            tvDetailDescription.setText(description);
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_favorite) {
            FavoriteFragment favoriteFragment = new FavoriteFragment();

            if (tvDetailName.getText().toString().isEmpty()) {
                Toast.makeText(getActivity().getApplicationContext(), "Error: Team name required", Toast.LENGTH_LONG).show();
            } else if (tvDetailBadge.getText().toString().isEmpty()) {
                Toast.makeText(getActivity().getApplicationContext(), "Error: Team Badge required", Toast.LENGTH_LONG).show();
            } else {
                dbHelper.addTeamDetail(tvDetailName.getText().toString(), tvDetailBadge.getText().toString());
                FragmentManager mFragmentManager = getFragmentManager();
                if (mFragmentManager != null) {
                    mFragmentManager
                            .beginTransaction()
                            .replace(R.id.fragment_container, favoriteFragment, FavoriteFragment.class.getSimpleName())
                            .commit();
                }
            }
        }
    }
}
