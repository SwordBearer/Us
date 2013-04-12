package xmu.swordbearer.us.plugin;

import java.util.List;

import xmu.swordbearer.us.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class PluginListAdapter extends BaseAdapter {
	private List<AccountPlugin> plugins;
	private LayoutInflater inflater;

	public PluginListAdapter(Context context, List<AccountPlugin> plugins) {
		this.plugins = plugins;
		inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		return plugins.size();
	}

	@Override
	public Object getItem(int position) {
		return plugins.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		AccountPlugin plugin = (AccountPlugin) getItem(position);
		if (convertView == null)
			convertView = inflater.inflate(R.layout.plugin_list_item, null);
		TextView tv = (TextView) convertView
				.findViewById(R.id.plugin_list_item_pluginname);
		TextView tv2 = (TextView) convertView
				.findViewById(R.id.plugin_list_item_package);
		tv.setText(plugin.appName);
		tv2.setText(plugin.packageName);
		convertView.setTag(plugin);
		return convertView;
	}
}