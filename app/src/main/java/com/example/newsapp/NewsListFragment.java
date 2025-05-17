package com.example.newsapp;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

public class NewsListFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_list, container, false);

        // Initialize lists
        List<NewsItem> topStories = new ArrayList<>();
        List<NewsItem> news = new ArrayList<>();

        // Top Story 1
        List<NewsItem> related1 = new ArrayList<>();
        related1.add(new NewsItem(
                "AI Ethics Debate",
                "Regulations needed for AI...",
                "https://picsum.photos/200/300?random=4",
                "AI ethics discussions intensify..." +
                        "Why do we use it?\n" +
                        "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like)." +
                        "", // Add content
                new ArrayList<>()
        ));
        related1.add(new NewsItem(
                "Carbon Emissions Report",
                "Global emissions drop...",
                "https://picsum.photos/200/300?random=5",
                "Latest report shows progress..." +
                        "Why do we use it?\n" +
                        "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).", // Add content
                new ArrayList<>()
        ));

        // Add to topStories
        topStories.add(new NewsItem(
                "Global Climate Summit 2023",
                "Leaders pledge to reduce emissions...",
                "https://picsum.photos/200/300?random=1",
                "World leaders commit to net-zero targets..." +
                        "Why do we use it?\n" +
                        "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).", // Add content
                related1
        ));

        // General News Items
        news.add(new NewsItem(
                "Tech Giant Launches New Phone",
                "Revolutionary features unveiled...",
                "https://picsum.photos/200/300?random=2",
                "New smartphone with AI capabilities..." +
                        "Why do we use it?\n" +
                        "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).", // Add content
                new ArrayList<>()
        ));
        news.add(new NewsItem(
                "Mars Rover Discovers Water",
                "NASA confirms ancient lakes...",
                "https://picsum.photos/200/300?random=3",
                "Evidence of water found on Mars..." +
                        "Why do we use it?\n" +
                        "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).", // Add content
                new ArrayList<>()
        ));


        // Setup RecyclerViews
        RecyclerView rvTopStories = view.findViewById(R.id.rv_top_stories);
        rvTopStories.setLayoutManager(new LinearLayoutManager(
                getContext(), LinearLayoutManager.HORIZONTAL, false));
        rvTopStories.setAdapter(new NewsAdapter(topStories, item -> {
            ((MainActivity) requireActivity()).navigateToFragment(NewsDetailFragment.newInstance(item));
        }));

        RecyclerView rvNews = view.findViewById(R.id.rv_news);
        rvNews.setLayoutManager(new LinearLayoutManager(
                getContext(), LinearLayoutManager.HORIZONTAL, false));
        rvNews.setAdapter(new NewsAdapter(news, item -> {
            ((MainActivity) requireActivity()).navigateToFragment(NewsDetailFragment.newInstance(item));
        }));

        return view;
    }
}