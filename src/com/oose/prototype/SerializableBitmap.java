package com.oose.prototype;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class SerializableBitmap implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 575532880906148876L;

	private Bitmap image;

	public Bitmap getImage() {
		return image;
	}

	public SerializableBitmap(Bitmap picture) {
		this.image = picture;
	}

	private void writeObject(ObjectOutputStream out) throws IOException {
		final ByteArrayOutputStream stream = new ByteArrayOutputStream();
		image.compress(Bitmap.CompressFormat.PNG, 100, stream);
		final byte[] imageByteArray = stream.toByteArray();
		out.writeInt(imageByteArray.length);
		out.write(imageByteArray);
	}

	private void readObject(ObjectInputStream in) throws IOException,
			ClassNotFoundException {

		final int length = in.readInt();
		final byte[] imageByteArray = new byte[length];
		in.readFully(imageByteArray);
		image = BitmapFactory.decodeByteArray(imageByteArray, 0, length);
	}
}
