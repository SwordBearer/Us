package xmu.swordbearer.us.plugin;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

public class PluginManager {
	public static final String SHARED_USER_ID = "xmu.swordbearer.plugins";

	public static List<AccountPlugin> findPlugins(Context context) {
		List<AccountPlugin> plugins = new ArrayList<AccountPlugin>();
		PackageManager pm = context.getPackageManager();
		List<PackageInfo> packageInfos = pm
				.getInstalledPackages(PackageManager.GET_UNINSTALLED_PACKAGES);
		AccountPlugin plugin = null;
		for (PackageInfo info : packageInfos) {
			String sharedUserId = info.sharedUserId;
			String packageName = info.packageName;
			if ((sharedUserId == null) || !sharedUserId.equals(SHARED_USER_ID)
					|| packageName.equals("xmu.swordbearer.us"))
				continue;
			plugin = new AccountPlugin();
			String label = pm.getApplicationLabel(info.applicationInfo)
					.toString();
			plugin.appName = label;
			Log.e("TEST", "AppName " + label);
			plugin.packageName = packageName;
			plugin.sharedUserId = sharedUserId;
			plugins.add(plugin);
		}
		return plugins;
	}
}
