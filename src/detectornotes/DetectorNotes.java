package detectornotes;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

public class DetectorNotes {

	private File wavFile;
	private MyFFT myfft;

	public DetectorNotes(File wavFile) {
		this.wavFile = wavFile;
		myfft = new MyFFT();
	}

	public int getNote() {
		// Abrindo um Stream
		AudioInputStream ais = null;
		try {
			ais = AudioSystem.getAudioInputStream(this.wavFile);
		} catch (UnsupportedAudioFileException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		AudioFormat monoFormat = new AudioFormat((float) 44100, 16, 1, true,
				false);
		ais = AudioSystem.getAudioInputStream(monoFormat, ais);

		// Lendo os bytes dentro do audio Stream
		byte[] buffer = new byte[8192];
		int bytesRead;
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		try {
			while ((bytesRead = ais.read(buffer)) != -1) {
				output.write(buffer, 0, bytesRead);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] songInByte = output.toByteArray();
		myfft.setByteArraySong(songInByte);

		float[] valuesNotes = myfft.getS1();
		float maxValue = 0;
		int slotNoteMaxValue = 0;
		for (int i = 0; i < valuesNotes.length; i++) {
			if (maxValue < valuesNotes[i]) {
				maxValue = valuesNotes[i];
				slotNoteMaxValue = i;
			}
		}
		return slotNoteMaxValue;
	}

}
