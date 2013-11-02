package com.mejorandola.ejemplo;

import uk.co.senab.actionbarpulltorefresh.library.PullToRefreshAttacher;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.mejorandola.ejemplo.data.CustomPagerAdapter;

public class MainActivity extends FragmentActivity 
						 implements ViewPager.OnPageChangeListener, ActionBar.TabListener {
	private ViewPager view_pager;
	private CustomPagerAdapter adapter;
	private PullToRefreshAttacher pull_to_refresh_attacher;
	
	@Override
	protected void onCreate(
			Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		pull_to_refresh_attacher = PullToRefreshAttacher.get(this);
		
		adapter = new CustomPagerAdapter(getSupportFragmentManager());
		view_pager = (ViewPager)findViewById(R.id.pager);
		view_pager.setAdapter(adapter);
		
		ActionBar bar = getActionBar();
		bar.removeAllTabs();
		bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		bar.addTab(bar.newTab().setText("Lista").setTabListener(this));
		bar.addTab(bar.newTab().setText("Grid").setTabListener(this));
		
	}

	public PullToRefreshAttacher getAttacher() {
		return pull_to_refresh_attacher;
	}

	@Override
	public void onPageScrollStateChanged(
			int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageScrolled(
			int arg0, float arg1,
			int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageSelected(int arg0) {
		getActionBar().setSelectedNavigationItem(arg0);
	}

	@Override
	public void onTabReselected(
			Tab tab,
			FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabSelected(Tab tab,
			FragmentTransaction ft) {
		view_pager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(
			Tab tab,
			FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

}
