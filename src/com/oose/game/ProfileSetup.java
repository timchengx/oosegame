package com.oose.game;

import java.io.FileNotFoundException;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

/* user can set and take/choose picture from this activity */
public class ProfileSetup extends Activity {

	private int requestID;	// to know which button has been pushed

	/* player one and two - input and picture view */
	ImageView playerOneImageView;
	ImageView playerTwoImageView;
	EditText playerOneNameInput;
	EditText playerTwoNameInput;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		/* setup activity layout */
		setContentView(R.layout.picture_setup);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		/* get players name and image view - for input and show picture */
		playerOneImageView = (ImageView) findViewById(R.id.imagePlayer1);
		playerTwoImageView = (ImageView) findViewById(R.id.imagePlayer2);
		playerOneNameInput = (EditText) findViewById(R.id.editTextPlayer1);
		playerTwoNameInput = (EditText) findViewById(R.id.editTextPlayer2);
		
		playerOneImageView.setDrawingCacheEnabled(true);
		playerTwoImageView.setDrawingCacheEnabled(true);
		
		/* if name and picture has been set before, load previous setting */
		Intent pictureDataIntent = getIntent();
		if (pictureDataIntent.getBooleanExtra(
				ChessSetup.INTENT_HAS_ICON_BOOLEAN, false)) {
			playerOneNameInput.setText(pictureDataIntent
					.getStringExtra(ChessSetup.PLAYER1NAME_STRING));
			playerTwoNameInput.setText(pictureDataIntent
					.getStringExtra(ChessSetup.PLAYER2NAME_STRING));
			playerOneImageView.setImageBitmap((Bitmap) pictureDataIntent
					.getParcelableExtra(ChessSetup.PLAYER1ICON_BITMAP));
			playerTwoImageView.setImageBitmap((Bitmap) pictureDataIntent
					.getParcelableExtra(ChessSetup.PLAYER2ICON_BITMAP));
		}
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
		Intent intent = new Intent();
		
		/* save users name and picture */
		intent.putExtra(ChessSetup.PLAYER1NAME_STRING, playerOneNameInput.getText().toString());
		intent.putExtra(ChessSetup.PLAYER2NAME_STRING, playerTwoNameInput.getText().toString());
		intent.putExtra(ChessSetup.PLAYER1ICON_BITMAP, playerOneImageView.getDrawingCache());
		intent.putExtra(ChessSetup.PLAYER2ICON_BITMAP, playerTwoImageView.getDrawingCache());
		
		/* back to previous activity */
		setResult(RESULT_OK, intent);
		finish();
		return true;
	}
	
	/*  */
	public void pickPicture(View view) {
		Intent imageFilter = new Intent();
		imageFilter.setType("image/*");
		imageFilter.setAction(Intent.ACTION_GET_CONTENT);
		Intent intent = Intent.createChooser(imageFilter, getResources().getString(R.string.choosepicture));
		requestID = view.getId();
		startActivityForResult(intent, ChessSetup.FROMFILEREQUESTCODE);
	}
	
	/* if user push take picture button, this method will handle it */
	public void takePicture(View view) {
		/* call camera to take picture */
		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		requestID = view.getId();
	    startActivityForResult(intent, ChessSetup.CAMERAREQUESTCODE);
	}
	
	/* this method will be called after user finish take or select picture */
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		Bitmap pictureImage = null;
		switch(requestCode) {
		case ChessSetup.CAMERAREQUESTCODE:
			Bundle pictureData = data.getExtras();
			if(pictureData != null)
				pictureImage = (Bitmap) pictureData.get("data");
			break;
		case ChessSetup.FROMFILEREQUESTCODE:
			Uri pictureUri = data.getData();
			try {
				pictureImage = BitmapFactory.decodeStream(getContentResolver().openInputStream(pictureUri));
			} catch (FileNotFoundException e) {
				// if error, do nothing...
			}
			break;
		default:
			break;
		}
		if(pictureImage != null) {
			pictureImage = Bitmap.createScaledBitmap(pictureImage, 100, 100, false);
			
			if(requestID == R.id.ButtonPlayer1TakePicture || 
					requestID == R.id.ButtonPlayer1SetPictureFromFile)
				playerOneImageView.setImageBitmap(pictureImage);
			else		// ButtonPlayer2TakePicture 
				playerTwoImageView.setImageBitmap(pictureImage);
		}
	}
}
