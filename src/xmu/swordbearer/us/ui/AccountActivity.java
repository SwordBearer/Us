package xmu.swordbearer.us.ui;

import java.util.List;

import xmu.swordbearer.us.R;
import xmu.swordbearer.us.plugin.AccountPlugin;
import xmu.swordbearer.us.plugin.PluginListAdapter;
import xmu.swordbearer.us.plugin.PluginManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class AccountActivity extends BaseActivity implements
		OnItemClickListener {
	private ListView lvAccount;
	private List<AccountPlugin> plugins = null;
	private PluginListAdapter pluginAdapter;
	private PluginBroadcastReceiver pluginBroadcastReceiver;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initViews();

		pluginBroadcastReceiver = new PluginBroadcastReceiver();
		plugins = PluginManager.findPlugins(this);
		pluginAdapter = new PluginListAdapter(this, plugins);
		lvAccount.setAdapter(pluginAdapter);
	}

	@Override
	public void initViews() {
		this.setContentView(R.layout.activity_account);
		lvAccount = (ListView) findViewById(R.id.accountlist);
		lvAccount.setOnItemClickListener(this);
	}

	@Override
	protected void onStart() {
		super.onStart();
		registerPluginBroadcast();
	}

	@Override
	protected void onStop() {
		super.onStop();
		unregisterReceiver(pluginBroadcastReceiver);
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View v, int pos, long id) {

		AccountPlugin plugin = (AccountPlugin) v.getTag();
		Intent intent = new Intent();
		ComponentName name = new ComponentName(plugin.packageName,
				plugin.packageName + ".Start");
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.setComponent(name);
		startActivityForResult(intent, 0);
	}

	private void registerPluginBroadcast() {
		IntentFilter pluginFilter = new IntentFilter();
		pluginFilter.addAction(Intent.ACTION_PACKAGE_ADDED);
		pluginFilter.addAction(Intent.ACTION_PACKAGE_REPLACED);
		pluginFilter.addAction(Intent.ACTION_PACKAGE_REMOVED);
		pluginFilter.addCategory(Intent.CATEGORY_DEFAULT);
		registerReceiver(pluginBroadcastReceiver, pluginFilter);
	}

	private class PluginBroadcastReceiver extends BroadcastReceiver {
		@Override
		public void onReceive(Context context, Intent intent) {
			plugins = PluginManager.findPlugins(AccountActivity.this);
			pluginAdapter.notifyDataSetChanged();
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}

}
