package recordmidi;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class RecordMidi {
	
	private byte[] midiBytes;
	
	public RecordMidi(byte[] midiBytes) {
		this.midiBytes = midiBytes;
	}
	
	public void saveFile() throws IOException{
		File saveFile = new File("MidiFiles/testMidifile.mid");
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
