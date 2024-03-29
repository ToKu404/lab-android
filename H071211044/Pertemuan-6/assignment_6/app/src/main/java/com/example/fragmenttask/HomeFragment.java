package com.example.fragmenttask;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class HomeFragment extends Fragment {

    static final DataSource datasource = new DataSource();
    static final PostAdapter adapter = new PostAdapter(datasource.getPosts());

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView tvEmptyPosts = view.findViewById(R.id.tv_empty_posts);
        RecyclerView rvPost = view.findViewById(R.id.rv_post);
        //setup rv
        rvPost.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvPost.setAdapter(adapter);

        //saat item > 0 maka sembunyikan textview post
        if (adapter.getItemCount() > 0) {
            tvEmptyPosts.setVisibility(View.GONE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}