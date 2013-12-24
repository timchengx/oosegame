package com.oose.game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/* 
 * let user setup time limit on/off
 * and time limit value
 */
public class TimeSetup extends Activity {

	NumberPicker timer; // value picker
	RadioGroup buttonSwitch; // on/off button

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		/* set this activity's layout */
		setContentView(R.layout.time_setup);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		/* get data from previous activity */
		Intent intent = getIntent();

		timer = (NumberPicker) findViewById(R.id.countdownPicker);
		buttonSwitch = (RadioGroup) findViewById(R.id.RadioButtonGroupTimeSwitch);
		
		timer.setMinValue(ChessSetup.DEFAULTTIMELIMIT_MIN);
		timer.setMaxValue(ChessSetup.DEFAULTTIMELIMIT_MAX);
		
		/* if user had set time limit before, get previous set value*/
		timer.setValue(intent.getIntExtra(ChessSetup.TIMELIMIT_INT, ChessSetup.DEFAULTTIMELIMIT_MIN));

		/* 
		 * if user had set time limit on/off, get previous setup 
		 * if not, turn the time limit on
		 */
		if(intent.getBooleanExtra(ChessSetup.LIMITSWITCH_BOOLEAN, true))
			((RadioButton) findViewById(R.id.RadioButtonTimeOn)).setChecked(true);
		else
			((RadioButton) findViewById(R.id.RadioButtonTimeOff)).setChecked(true);

	}

	/* if user hit back button, save all setting and back to previous activity */
	public boolean onOptionsItemSelected(MenuItem item) {
		Intent intent = new Intent();
		int onOff = buttonSwitch.getCheckedRadioButtonId();
		
		/* save time limit value */
		intent.putExtra(ChessSetup.TIMELIMIT_INT, timer.getValue());

		/* determin and save is time limit is  on/off */
		switch (onOff) {
		case R.id.RadioButtonTimeOn:
			intent.putExtra(ChessSetup.LIMITSWITCH_BOOLEAN, true);
			break;
		case R.id.RadioButtonTimeOff:
			intent.putExtra(ChessSetup.LIMITSWITCH_BOOLEAN, false);
			break;
		default:
			intent.putExtra(ChessSetup.LIMITSWITCH_BOOLEAN, true);
			break;
		}

		/* back to previous activity */
		setResult(RESULT_OK, intent);
		finish();
		return true;
	}
	@Override
	public void onBackPressed() {
		onOptionsItemSelected(null);
	}
}
