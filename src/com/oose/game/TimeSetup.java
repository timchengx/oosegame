package com.oose.game;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 * 
 * @see SystemUiHider
 */
public class TimeSetup extends Activity {
	NumberPicker timer;
	RadioGroup buttonSwitch;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.time_setup);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		Intent intent = getIntent();
		timer = (NumberPicker) findViewById(R.id.countdownPicker);
		timer.setMinValue(30);
		timer.setMaxValue(90);
		timer.setValue(intent.getIntExtra(KEYINDEX.TIMELIMIT_VALUE, 30));
		buttonSwitch = (RadioGroup) findViewById(R.id.RadioButtonGroupTimeSwitch);
		if(intent.getBooleanExtra(KEYINDEX.LIMITSWITCH_BOOLEAN, true))
			((RadioButton) findViewById(R.id.RadioButtonTimeOn)).setChecked(true);
		else
			((RadioButton) findViewById(R.id.RadioButtonTimeOff)).setChecked(true);
	}
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()) {
		case android.R.id.home:
		Intent intent = new Intent();
		intent.putExtra(KEYINDEX.TIMELIMIT_VALUE, timer.getValue());
		int onOff = buttonSwitch.getCheckedRadioButtonId();
		
		switch(onOff) {
		case R.id.RadioButtonTimeOn:
			intent.putExtra(KEYINDEX.LIMITSWITCH_BOOLEAN, true);
			break;
		case R.id.RadioButtonTimeOff:
			intent.putExtra(KEYINDEX.LIMITSWITCH_BOOLEAN, false);
			break;
		default:
			intent.putExtra(KEYINDEX.LIMITSWITCH_BOOLEAN, true);
			break;
		}
		
		setResult(RESULT_OK,intent);
			finish();
		}
		return true;
	}
}
