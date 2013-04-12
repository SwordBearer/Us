package xmu.swordbearer.us.ui;

import xmu.swordbearer.us.R;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends TabActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initTabs();
	}

	private void initTabs() {
		TabHost tabHost = getTabHost();
		TabHost.TabSpec tabSpec;
		Intent intent;

		intent = new Intent(this, SpotNewsActivity.class);
		tabSpec = tabHost.newTabSpec("spotnews");
		tabSpec.setIndicator("SpotNews");
		tabSpec.setContent(intent);
		tabHost.addTab(tabSpec);

		intent = new Intent(this, AccountActivity.class);
		tabSpec = tabHost.newTabSpec("account");
		tabSpec.setIndicator("Account");
		tabSpec.setContent(intent);
		tabHost.addTab(tabSpec);

		intent = new Intent(this, WatchListActivity.class);
		tabSpec = tabHost.newTabSpec("watchlist");
		tabSpec.setIndicator("WatchList");
		tabSpec.setContent(intent);
		tabHost.addTab(tabSpec);

		intent = new Intent(this, FavoriteActivity.class);
		tabSpec = tabHost.newTabSpec("favorite");
		tabSpec.setIndicator("Favorite");
		tabSpec.setContent(intent);
		tabHost.addTab(tabSpec);

		intent = new Intent(this, SettingsActivity.class);
		tabSpec = tabHost.newTabSpec("settings");
		tabSpec.setIndicator("Settings");
		tabSpec.setContent(intent);
		tabHost.addTab(tabSpec);
	}
}
