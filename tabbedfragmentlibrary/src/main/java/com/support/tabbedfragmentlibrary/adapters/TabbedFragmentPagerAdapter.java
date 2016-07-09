package com.support.tabbedfragmentlibrary.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class TabbedFragmentPagerAdapter extends FragmentPagerAdapter {
	
	List<Fragment> listfragments;
	
	public TabbedFragmentPagerAdapter(FragmentManager fragmentmanager, List<Fragment> lfrag){
		super(fragmentmanager);
		this.listfragments = lfrag;
	}

	@Override
	public Fragment getItem(int position) {
		return listfragments.get(position);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listfragments.size();
	}

	@Override
	public int getItemPosition(Object object) {
		return super.getItemPosition(object);
	}
}
