package com.example.android.asynctaskloader;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;

import com.example.android.asynctaskloader.utilities.NetworkUtils;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.URL;

/**
 * Created by Richard on 15/05/2018.
 */

class GithubLoader extends AsyncTaskLoader<String> {
    @Nullable private final Bundle args;
    @NonNull private final WeakReference<ProgressBar> loadingIndicator;

    public GithubLoader(Context context, @Nullable Bundle args, @Nullable ProgressBar loadingIndicator) {
        super(context);
        this.args = args;
        this.loadingIndicator = new WeakReference<>(loadingIndicator);
    }

    // TODO (5) Override onStartLoading
    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        // Within onStartLoading

        // TODO (6) If args is null, return.
        if (args == null) {
            return;
        }

        // TODO (7) Show the loading indicator
        ProgressBar progressBar = loadingIndicator.get();
        if (progressBar != null) {
            progressBar.setVisibility(View.VISIBLE);
        }

        // TODO (8) Force a load
        forceLoad();
        // END - onStartLoading
    }

    // TODO (9) Override loadInBackground
    @Override
    public String loadInBackground() {

        if (args == null) {
            return null;
        }

        // Within loadInBackground
        // TODO (10) Get the String for our URL from the bundle passed to onCreateLoader
        String searchUrl = args.getString(MainActivity.SEARCH_QUERY_URL_EXTRA);

        // TODO (11) If the URL is null or empty, return null
        if (TextUtils.isEmpty(searchUrl)) {
            return null;
        }

        // TODO (12) Copy the try / catch block from the AsyncTask's doInBackground method
        String githubSearchResults = null;
        try {
            githubSearchResults = NetworkUtils.getResponseFromHttpUrl(new URL(searchUrl));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return githubSearchResults;

        // END - loadInBackground
    }
}
