package ru.mirea.yatsenko.loadermanager;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.loader.content.AsyncTaskLoader;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MyLoader extends AsyncTaskLoader<String> {

    String someText;

    static String s = "";
    public MyLoader(@NonNull Context context, Bundle bundle) {
        super(context);
        if (bundle != null)
            someText = bundle.getString(s);
    }
    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public String loadInBackground() {
        List<String> stringList = Arrays.asList(someText.split(""));
        Collections.shuffle(stringList);
        String shuffle="";
        for (String item: stringList) {
            shuffle+=item;
        }
        return shuffle;
    }
}
