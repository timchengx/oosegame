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

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 * 
 * @see SystemUiHider
 */
public class PictureSetup extends Activity {
	
	private int requestID;
	
	ImageView playerOneImageView;
	ImageView playerTwoImageView;
	EditText playerOneNameView;
	EditText playerTwoNameView;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.picture_setup);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		playerOneImageView = (ImageView) findViewById(R.id.imagePlayer1);
		playerTwoImageView = (ImageView) findViewById(R.id.imagePlayer2);
		playerOneNameView = (EditText) findViewById(R.id.editTextPlayer1);
		playerTwoNameView = (EditText) findViewById(R.id.editTextPlayer2);
		playerOneImageView.setDrawingCacheEnabled(true);
		playerTwoImageView.setDrawingCacheEnabled(true);
		Intent pictureDataIntent = getIntent();
		if(pictureDataIntent.getBooleanExtra(KEYINDEX.INTENT_HAS_ICON_BOOLEAN, false)) {
			playerOneNameView.setText(pictureDataIntent.getStringExtra(KEYINDEX.PLAYER1NAME_STRING));
			playerTwoNameView.setText(pictureDataIntent.getStringExtra(KEYINDEX.PLAYER2NAME_STRING));
			playerOneImageView.setImageBitmap((Bitmap)pictureDataIntent.getParcelableExtra(KEYINDEX.PLAYER1ICON_BITMAP));
			playerTwoImageView.setImageBitmap((Bitmap)pictureDataIntent.getParcelableExtra(KEYINDEX.PLAYER2ICON_BITMAP));
		}
	}
	public boolean onOptionsItemSelected(MenuItem item) {
		//switch(item.getItemId()) {
		//case android.R.id.home:
		Intent intent = new Intent();
		//Bundle bundle = new Bundle();
		//bundle.putSerializable(pSaveIntentID, pictureSave);
		//intent.putExtra(bundle);
		intent.putExtra(KEYINDEX.PLAYER1NAME_STRING, playerOneNameView.getText().toString());
		intent.putExtra(KEYINDEX.PLAYER2NAME_STRING, playerTwoNameView.getText().toString());
		intent.putExtra(KEYINDEX.PLAYER1ICON_BITMAP, playerOneImageView.getDrawingCache());
		intent.putExtra(KEYINDEX.PLAYER2ICON_BITMAP, playerTwoImageView.getDrawingCache());
		setResult(RESULT_OK, intent);
		this.finish();
		//}
		return true;
	}
	public void pickPicture(View view) {
		Intent imageFilter = new Intent();
		imageFilter.setType("image/*");
		imageFilter.setAction(Intent.ACTION_GET_CONTENT);
		Intent intent = Intent.createChooser(imageFilter, getResources().getString(R.string.choosepicture));
		requestID = view.getId();
		startActivityForResult(intent, KEYINDEX.CAMERAREQUESTCODE);
	}
	public void takePicture(View view) {
		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		requestID = view.getId();
	    startActivityForResult(intent, KEYINDEX.CAMERAREQUESTCODE);
	}
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		Bitmap pictureImage = null;
		switch(requestCode) {
		case KEYINDEX.CAMERAREQUESTCODE:
			Bundle pictureData = data.getExtras();
			if(pictureData != null)
				pictureImage = (Bitmap) pictureData.get("data");
			
		case KEYINDEX.FROMFILEREQUESTCODE:
			Uri pictureUri = data.getData();
			try {
				pictureImage = BitmapFactory.decodeStream(getContentResolver().openInputStream(pictureUri));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//show a android error...
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
