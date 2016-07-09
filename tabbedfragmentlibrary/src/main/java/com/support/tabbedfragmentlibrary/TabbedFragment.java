package com.support.tabbedfragmentlibrary;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TabHost.TabContentFactory;
import android.widget.TabHost.TabSpec;

import com.example.tabbedfragmentlibrary.R;
import com.support.tabbedfragmentlibrary.adapters.TabbedFragmentPagerAdapter;

public class TabbedFragment extends Fragment implements TabHost.OnTabChangeListener, ViewPager.OnPageChangeListener {

    private List<TabInfo> mTabsInfo = new ArrayList<TabInfo>();
    private TabHost mTabHost;
    protected ViewPager mViewPager;
    protected TabbedFragmentPagerAdapter mPagerAdapter;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    	View v = inflater.inflate(R.layout.tabbed_fragment, container, false);
        return v;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initializeTabbedFragmentViews(view);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public void onSaveInstanceState(Bundle outState) {
        //outState.putString("tab", mTabHost.getCurrentTabTag()); // save the tab selected
        super.onSaveInstanceState(outState);
    }
    
    public void addTabInfo(TabInfo tabInfo) {
    	mTabsInfo.add(tabInfo);
    }
    
    protected void initializeTabbedFragmentViews(View view) {
    	mTabHost = (TabHost)view.findViewById(R.id.tabhost);
        mViewPager = (ViewPager)view.findViewById(R.id.viewpager);
        if (mTabHost == null || mViewPager == null) {
        	throw new RuntimeException("Your layout file must have a TabHost whose id attribute is 'tabhost' and a ViewPager whose id attribute is 'viewpager'. Else include tabbed_fragment layout in your fragment layout");
        }
        initializeViewPager();
        initializeTabHost();
    }



    private void initializeViewPager() {
    	if (mTabsInfo == null || mTabsInfo.size() == 0) {
    		throw new RuntimeException("No Tabs added. You must add TabInfos");
    	}
    	List<Fragment> fragments = new ArrayList<Fragment>();
    	for(int i=0; i<mTabsInfo.size(); i++) {
    		fragments.add(mTabsInfo.get(i).fragment);
    	}
        mPagerAdapter = new TabbedFragmentPagerAdapter(getChildFragmentManager(), fragments);
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.addOnPageChangeListener(this);
    }
    
    private void initializeTabHost() {
        mTabHost.setup();
        for(int i = 0; i < mTabsInfo.size(); i++) {
        	TabInfo info = mTabsInfo.get(i);
        	TabSpec tabspec = mTabHost.newTabSpec(info.tag);
        	if(info.mView != null) {
        		tabspec.setIndicator(info.mView);
        	} else {
        		tabspec.setIndicator(getString(info.tabNameId));
        	}
        	tabspec.setContent(new DummyTabFactory(getActivity()));
        	mTabHost.addTab(tabspec);
        }
        mTabHost.setOnTabChangedListener(this);
    }
    
    public void onDestroyView() {
        super.onDestroyView();
        mTabHost = null;
        mViewPager = null;
        mTabsInfo.clear();
    }

    @Override
    public void onPageScrollStateChanged(int arg0) {

    }

    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {

    }

    @Override
    public void onPageSelected(int position) {
        mTabHost.setCurrentTab(position);
    }

    @Override
    public void onTabChanged(String tabId) {
        if (mTabHost != null && mViewPager != null) {
            int pos = mTabHost.getCurrentTab();
            mViewPager.setCurrentItem(pos);
        }
    }
    
    class DummyTabFactory implements TabContentFactory {

        private final Context mContext;

        public DummyTabFactory(Context context) {
            mContext = context;
        }

        public View createTabContent(String tag) {
            View v = new View(mContext);
            v.setMinimumWidth(0);
            v.setMinimumHeight(0);
            return v;
        }

    }
    
    public class TabInfo {
		private String tag;
		private Fragment fragment;
		private int tabNameId;
		private View mView;

		private TabInfo(String tag, int tabNameId, Fragment fragment, View view) {
			this.tag = tag;
			this.tabNameId = tabNameId;
			this.fragment = fragment;
			mView = view;
		}
		
		public TabInfo(String tag, int tabNameId, Fragment fragment) {
			this(tag, tabNameId, fragment, null);
		}
		
		public TabInfo(String tag, Fragment fragment, View view) {
			this(tag, 0, fragment, view);
		}
		
    }

}
