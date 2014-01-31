package recordmidi;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class RecordMidi {

	private byte[] midiBytes;
	private String noteName;

	public RecordMidi(byte[] midiBytes, String noteName) {
		this.midiBytes = midiBytes;
		this.noteName = noteName;
	}

	public void saveFile() throws IOException {
		File saveFile = new File("MidiFiles/" + this.noteName + ".mid");
		if (saveFile.createNewFile()) {
			System.out.println("\n\nNovo arquivo criado");
		}
		FileOutputStream midiFile = new FileOutputStream(saveFile);
		for (int midiSlot = 0; midiSlot < midiBytes.length; midiSlot++) {
			midiFile.write(midiBytes[midiSlot]);
		}
		midiFile.close();
		System.out.println("Sucesso");
	}

}
