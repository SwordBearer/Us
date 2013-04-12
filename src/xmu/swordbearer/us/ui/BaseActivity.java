package xmu.swordbearer.us.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public abstract class BaseActivity extends Activity implements
		android.view.View.OnClickListener {
	@Override
	public void onClick(View v) {

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	public abstract void initViews();
}
