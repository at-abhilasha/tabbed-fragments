package com.example.tabbedfragmentapplication.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.support.tabbedfragmentapplication.R;
import com.support.tabbedfragmentlibrary.TabbedFragment;

public class TabbedFragmentCustomViewExample extends TabbedFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        addTabInfo(new TabInfo("SubFragment1InCustom", R.string.sub_fragment_1, new SubFragment1()));
        addTabInfo(new TabInfo("SubFragment2InCustom", R.string.sub_fragment_2, new SubFragment2()));
        View v = inflater.inflate(R.layout.fragment_custom, container, false);
        return v;
    }
}
