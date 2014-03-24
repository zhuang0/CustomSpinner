package com.geniuseoe.spiner.demo;

import java.util.ArrayList;
import java.util.List;

import com.geniuseoe.spiner.demo.widget.AbstractSpinerAdapter;
import com.geniuseoe.spiner.demo.widget.SpinerPopWindow;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * 
 * @author geniuseoe2012
 *  more brilliant£¬please pay attention to my csdn blog --> http://blog.csdn.net/geniuseoe2012 
 *  android  develop group £º298044305
 */
public class SpinerWindowDemoActivity extends Activity implements OnClickListener,
		AbstractSpinerAdapter.IOnItemSelectListener {
	/** Called when the activity is first created. */

	private View mRootView;
	private TextView mTView;
	private ImageButton mBtnDropDown;
	private List<String> nameList = new ArrayList<String>();
	private SpinerPopWindow mSpinerPopWindow;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		setupViews();
		setHero(0);
	}

	private void setupViews() {
		mRootView = findViewById(R.id.rootView);

		mTView = (TextView) findViewById(R.id.tv_value);
		mBtnDropDown = (ImageButton) findViewById(R.id.bt_dropdown);
		mBtnDropDown.setOnClickListener(this);

		String[] names = getResources().getStringArray(R.array.hero_name);
		for (int i = 0; i < 20; i++) {
			nameList.add(String.valueOf(i));
		}

		mSpinerPopWindow = new SpinerPopWindow(this);
		mSpinerPopWindow.refreshData(nameList, 0);
		mSpinerPopWindow.setItemListener(this);
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.bt_dropdown:
			showSpinWindow();
			break;
		}
	}

	private void setHero(int pos) {
		if (pos >= 0 && pos <= nameList.size()) {
			String value = nameList.get(pos);
			mTView.setText(value);
		}
	}

	private void showSpinWindow() {
		Log.e("", "showSpinWindow");
		mSpinerPopWindow.setWidth(mTView.getWidth());
		mSpinerPopWindow.showAsDropDown(mTView);
	}

	@Override
	public void onItemClick(int pos) {

		setHero(pos);

	}

}