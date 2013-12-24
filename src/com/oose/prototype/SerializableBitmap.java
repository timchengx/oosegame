package com.oose.prototype;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/* 
 * Bitmap Class from Android can't be Serializable(for SaveGame)
 * This Class implements Serialzable interface to Bitmap
 */
public class SerializableBitmap implements Serializable {

	private static final long serialVersionUID = 575532880906148876L;

	private Bitmap image;

	public Bitmap getImage() {
		return image;
	}

	public SerializableBitmap(Bitmap picture) {
		this.image = picture;
	}

	private void writeObject(ObjectOutputStream out) throws IOException {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		image.compress(Bitmap.CompressFormat.PNG, 100, stream);
		byte[] imageByteArray = stream.toByteArray();
		out.writeInt(imageByteArray.length);
		out.write(imageByteArray);
	}

	private void readObject(ObjectInputStream in) throws IOException,
			ClassNotFoundException {

		int size = in.readInt();
		byte[] imageByteArray = new byte[size];
		in.readFully(imageByteArray);
		this.image = BitmapFactory.decodeByteArray(imageByteArray, 0, size);
	}

}
