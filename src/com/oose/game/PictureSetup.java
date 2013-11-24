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
	private final int cameraRequestCode = 100;
	private final int fromFileRequestCode = 200;
	private int requestID;
	private final int error = -1;
	//private final String 
	ImageView playerOneImageView;
	ImageView playerTwoImageView;
	EditText playerOneNameView;
	EditText playerTwoNameView;
	
	private final String pOneNameText = "p1name";
	private final String pTwoNameText = "p2name";
	private final String pOneBitmap = "p1pic";
	private final String pTwoBitmap = "p2pic";
	private final String hasPictureData = "hPD";
	
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
		if(pictureDataIntent.getBooleanExtra(hasPictureData, false)) {
			playerOneNameView.setText(pictureDataIntent.getStringExtra(pOneNameText));
			playerTwoNameView.setText(pictureDataIntent.getStringExtra(pTwoNameText));
			playerOneImageView.setImageBitmap((Bitmap)pictureDataIntent.getParcelableExtra(pOneBitmap));
			playerTwoImageView.setImageBitmap((Bitmap)pictureDataIntent.getParcelableExtra(pTwoBitmap));
		}
	}
	public boolean onOptionsItemSelected(MenuItem item) {
		//switch(item.getItemId()) {
		//case android.R.id.home:
		Intent intent = new Intent();
		//Bundle bundle = new Bundle();
		//bundle.putSerializable(pSaveIntentID, pictureSave);
		//intent.putExtra(bundle);
		intent.putExtra(pOneNameText, playerOneNameView.getText().toString());
		intent.putExtra(pTwoNameText, playerTwoNameView.getText().toString());
		intent.putExtra(pOneBitmap, playerOneImageView.getDrawingCache());
		intent.putExtra(pTwoBitmap, playerTwoImageView.getDrawingCache());
		setResult(RESULT_OK, intent);
		this.finish();
		//}
		return true;
	}
	public void pickPicture(View view) {
		Intent imageFilter =new Intent();
		imageFilter.setType("image/*");
		imageFilter.setAction(Intent.ACTION_GET_CONTENT);
		Intent intent = Intent.createChooser(imageFilter, getResources().getString(R.string.choosepicture));
		requestID = view.getId();
		startActivityForResult(intent, fromFileRequestCode);
	}
	public void takePicture(View view) {
		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		requestID = view.getId();
	    startActivityForResult(intent, cameraRequestCode);
	}
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		Bitmap pictureImage = null;
		switch(requestCode) {
		case cameraRequestCode:
			Bundle pictureData = data.getExtras();
			pictureImage = (Bitmap) pictureData.get("data");
			
		case fromFileRequestCode:
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
		pictureImage = Bitmap.createScaledBitmap(pictureImage, 100, 100, false);
		if(requestID == R.id.ButtonPlayer1TakePicture || 
				requestID == R.id.ButtonPlayer1SetPictureFromFile)
			playerOneImageView.setImageBitmap(pictureImage);
		else		// ButtonPlayer2TakePicture 
			playerTwoImageView.setImageBitmap(pictureImage);
	}
}
