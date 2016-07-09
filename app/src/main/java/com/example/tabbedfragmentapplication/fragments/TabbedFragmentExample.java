package com.example.tabbedfragmentapplication.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.support.tabbedfragmentapplication.R;
import com.support.tabbedfragmentlibrary.TabbedFragment;

/**
 * Created by abhilasha.jain on 7/6/2016.
 */
public class TabbedFragmentExample extends TabbedFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        addTabInfo(new TabbedFragment.TabInfo("SubFragment1InCustom", R.string.sub_fragment_1, new SubFragment1()));
        addTabInfo(new TabbedFragment.TabInfo("SubFragment2InCustom", R.string.sub_fragment_2, new SubFragment2()));
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
