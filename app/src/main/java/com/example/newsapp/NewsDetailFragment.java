package com.example.newsapp;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

public class NewsDetailFragment extends Fragment {
    private static final String ARG_NEWS_ITEM = "news_item";
    private NewsItem newsItem;

    public static NewsDetailFragment newInstance(NewsItem item) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_NEWS_ITEM, item);
        NewsDetailFragment fragment = new NewsDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            newsItem = (NewsItem) getArguments().getSerializable(ARG_NEWS_ITEM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_detail, container, false);

        ImageView ivImage = view.findViewById(R.id.iv_news_image);
        TextView tvContent = view.findViewById(R.id.tv_news_content);
        RecyclerView rvRelatedNews = view.findViewById(R.id.rv_related_news);

        // Load data
        Glide.with(this).load(newsItem.getImageUrl()).into(ivImage);
        tvContent.setText(newsItem.getContent()); // Display random text

        // Related news setup (existing code)
        rvRelatedNews.setLayoutManager(new LinearLayoutManager(getContext()));
        rvRelatedNews.setAdapter(new NewsAdapter(newsItem.getRelatedNews(), item -> {
            ((MainActivity) requireActivity()).navigateToFragment(NewsDetailFragment.newInstance(item));
        }));

        return view;
    }
}
