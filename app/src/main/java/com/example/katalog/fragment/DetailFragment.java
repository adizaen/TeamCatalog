package com.example.katalog.fragment;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.katalog.R;

public class DetailFragment extends Fragment {

    public static String IMAGE = "image";
    public static String NAME = "name";
    public static String YEAR = "year";
    public static String DESCRIPTION = "description";

    ImageView ivTeam;
    TextView tvDetailName, tvDetailYear, tvDetailDescription;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ivTeam = view.findViewById(R.id.iv_team);
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
            String name = bundle.getString(NAME);
            String year = bundle.getString(YEAR);
            String description = bundle.getString(DESCRIPTION);

            Glide.with(this)
                    .load(url)
                    .into(ivTeam);
            tvDetailName.setText(name);
            tvDetailYear.setText(year);
            tvDetailDescription.setText(description);
        }
    }
}
